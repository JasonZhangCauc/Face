package com.cauc.face;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * 人脸识别测试类
 * 本类不做特殊描述
 * testService
 * 创建人:JasonZhang 
 * 时间：2018-9-22-上午11:22:36 
 * @version 1.0.0
 *
 */
public class testService {

	
	public static void main(String[] args) {
		FaceService testService=new FaceService();
		String fileString="D:\\个人文件\\个人文件----------项目\\Face_System\\WebRoot\\images\\2.jpg";
		
		String url=new UrlVo().getUrlDetect();
		
		String faceString=testService.faceimg(fileString,url);
		System.out.println("testService.class: "+faceString);
		StringBuffer buffer = new StringBuffer();
		try {
			JSONObject json =new JSONObject(faceString);
			JSONArray array = json.getJSONArray("faces");
			for(int i=0;i<array.length();i++)
			{
				JSONObject jo =array.getJSONObject(i);
				JSONObject attrJson = jo.getJSONObject("attributes");
				
				//性别
				String face_gender = attrJson.getJSONObject("gender").getString("value");
				//年齡
				int face_age = attrJson.getJSONObject("age").getInt("value");
				System.out.println("性别："+face_gender+" 年龄： "+face_age);
				face_gender=(face_gender=="Male"? "男":"女");
				buffer.append("性别:" + face_gender  + "<br />");
				buffer.append("年龄:" + face_age  + "岁<br />");
			}
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}

}
