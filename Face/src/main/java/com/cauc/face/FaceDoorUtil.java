package com.cauc.face;


import java.io.File;
import javax.net.ssl.SSLException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.facepp.http.HttpRequests;
import com.facepp.http.PostParameters;

/**
 * 
 * 获取人脸识别信息工具类
 * FaceDoorUtil
 * 创建人:JasonZhang 
 * 时间：2018-9-22-上午11:44:27 
 * @version 1.0.0
 *
 */
public class FaceDoorUtil {
	
	public static String getFaceDoorMessage(String base64) throws Exception
	{
		/*StringBuffer buffer = new StringBuffer();
		FaceService testService=new FaceService();
		System.out.println("path: "+path);
		
		//文件路径
		String fileString=path;
		//api-url
		String url=new UrlVo().getUrlDetect();
		//获取人脸信息
		String faceString=testService.faceimg(fileString,url);
		//控制台模拟日志
		System.out.println("testService.class: "+faceString);
		
		try {
			JSONObject json =new JSONObject(faceString);
			JSONArray array = json.getJSONArray("faces");
			int length=array.length();
			for(int i=0;i<length;i++)
			{
				if(length>1){
					System.out.println("第"+(i+1)+"个人"+ "<br />");
				}
				JSONObject jo =array.getJSONObject(i);
				JSONObject attrJson = jo.getJSONObject("attributes");
				
				//性别
				String face_gender = attrJson.getJSONObject("gender").getString("value");
				//年齡
				int face_age = attrJson.getJSONObject("age").getInt("value");
				System.out.println("FaceMessageUtil"+"性别："+face_gender+" 年龄： "+face_age);
				
				face_gender=(face_gender.equals("Male")? "男":"女");
				buffer.append("性别:" + face_gender );
				buffer.append("年龄:" + face_age  + "岁<br />");
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}finally{
			
		}*/
		System.out.println("path"+base64);
		String string;
		
		//string = testCompare.faceCompare(base64);
		string = testCompare.faceCheck(base64);
		return string;
		
		
		
	}
	
	
}

