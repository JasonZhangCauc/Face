package com.cauc.face;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import javax.net.ssl.SSLException;

import org.json.JSONArray;
import org.json.JSONObject;
public class testCompare {
	//http://localhost:8090/Face/facedoor.jsp
	public static String faceCompare(String Base64) throws Exception{
		String confidenceStr="PASS!";
        String base64=Base64;
		String url = "https://api-cn.faceplusplus.com/facepp/v3/compare";
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, byte[]> byteMap = new HashMap<>();
        map.put("api_key", "xaYCAbBxddiu_g8Kku4Nfs-nfyG5_dKJ");
        map.put("api_secret", "tiIs2tTWQAyLn19pMVJ06Qz_Hv6EaZqt");
		//map.put("image_url1", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1914445230,187341494&fm=200&gp=0.jpg");
		//map.put("image_url2", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1914445230,187341494&fm=200&gp=0.jpg");
		map.put("image_base64_1", base64);
		map.put("image_base64_2", base64);
        
        try{
            byte[] bacd = post(url, map, byteMap);
            String str = new String(bacd);
            JSONObject json =new JSONObject(str);
            int confidenceInt=(int) json.getLong("confidence");
            
        }catch (Exception e) {
        	e.printStackTrace();
		}
		return confidenceStr;
	}

	public static String faceCheck(String Base64) throws Exception {
		String checkStr = "";
		String base64 = Base64;
		String url = "https://api-cn.faceplusplus.com/facepp/v3/detect";
		HashMap<String, String> map = new HashMap<>();
		HashMap<String, byte[]> byteMap = new HashMap<>();
		map.put("api_key", "xaYCAbBxddiu_g8Kku4Nfs-nfyG5_dKJ");
		map.put("api_secret", "tiIs2tTWQAyLn19pMVJ06Qz_Hv6EaZqt");
		map.put("return_landmark", "1");
		map.put("return_attributes",
				"gender,age,smiling,headpose,facequality,blur,eyestatus,emotion,ethnicity,beauty,mouthstatus,eyegaze,skinstatus");
		map.put("image_base64", base64);
		try {
			byte[] bacd = post(url, map, byteMap);
			String str = new String(bacd);
			System.out.println(str);
			JSONObject json =new JSONObject(str);
			JSONArray array = json.getJSONArray("faces");
			int length=array.length();
			for(int i=0;i<length;i++)
			{
				if(length>1){
					return "请不要多人同时检测";
				}
				JSONObject jo =array.getJSONObject(i);
				JSONObject attrJson = jo.getJSONObject("attributes");
				
				//性别
				String face_gender = attrJson.getJSONObject("gender").getString("value");
				//年齡
				int face_age = attrJson.getJSONObject("age").getInt("value");
				System.out.println("FaceMessageUtil"+"性别："+face_gender+" 年龄： "+face_age);
				
				face_gender=(face_gender.equals("Male")? "男":"女");
				checkStr=checkStr+"性别: " + face_gender;
				checkStr=checkStr+"\n年龄: " + face_age  + "岁";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return checkStr;
	}
	
	private final static int CONNECT_TIME_OUT = 30000;
    private final static int READ_OUT_TIME = 50000;
    private static String boundaryString = getBoundary();
    protected static byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception {
        HttpURLConnection conne;
        URL url1 = new URL(url);
        conne = (HttpURLConnection) url1.openConnection();
        conne.setDoOutput(true);
        conne.setUseCaches(false);
        conne.setRequestMethod("POST");
        conne.setConnectTimeout(CONNECT_TIME_OUT);
        conne.setReadTimeout(READ_OUT_TIME);
        conne.setRequestProperty("accept", "*/*");
        conne.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundaryString);
        conne.setRequestProperty("connection", "Keep-Alive");
        conne.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0;Windows NT 5.1;SV1)");
        DataOutputStream obos = new DataOutputStream(conne.getOutputStream());
        Iterator iter = map.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<String, String> entry = (Map.Entry) iter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            obos.writeBytes("--" + boundaryString + "\r\n");
            obos.writeBytes("Content-Disposition: form-data; name=\"" + key
                    + "\"\r\n");
            obos.writeBytes("\r\n");
            obos.writeBytes(value + "\r\n");
        }
        if(fileMap != null && fileMap.size() > 0){
            Iterator fileIter = fileMap.entrySet().iterator();
            while(fileIter.hasNext()){
                Map.Entry<String, byte[]> fileEntry = (Map.Entry<String, byte[]>) fileIter.next();
                obos.writeBytes("--" + boundaryString + "\r\n");
                obos.writeBytes("Content-Disposition: form-data; name=\"" + fileEntry.getKey()
                        + "\"; filename=\"" + encode(" ") + "\"\r\n");
                obos.writeBytes("\r\n");
                obos.write(fileEntry.getValue());
                obos.writeBytes("\r\n");
            }
        }
        obos.writeBytes("--" + boundaryString + "--" + "\r\n");
        obos.writeBytes("\r\n");
        obos.flush();
        obos.close();
        InputStream ins = null;
        int code = conne.getResponseCode();
        try{
            if(code == 200){
                ins = conne.getInputStream();
            }else{
                ins = conne.getErrorStream();
            }
        }catch (SSLException e){
            e.printStackTrace();
            return new byte[0];
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buff = new byte[4096];
        int len;
        while((len = ins.read(buff)) != -1){
            baos.write(buff, 0, len);
        }
        byte[] bytes = baos.toByteArray();
        ins.close();
        return bytes;
    }
    private static String getBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < 32; ++i) {
            sb.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-".charAt(random.nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_".length())));
        }
        return sb.toString();
    }
    private static String encode(String value) throws Exception{
        return URLEncoder.encode(value, "UTF-8");
    }
    
    public static byte[] getBytesFromFile(File f) {
        if (f == null) {
            return null;
        }
        try {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = stream.read(b)) != -1)
                out.write(b, 0, n);
            stream.close();
            out.close();
            return out.toByteArray();
        } catch (IOException e) {
        }
        return null;
    }
}
