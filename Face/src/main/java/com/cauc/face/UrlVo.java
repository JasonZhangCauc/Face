package com.cauc.face;
/**
 * 
 * 人脸识别url VO
 * UrlDao
 * 创建人:JasonZhang 
 * 时间：2018-9-22-上午11:14:19 
 * @version 1.0.0
 *
 */
public class UrlVo {
	
	/**
	 * 人脸识别
	 */
	String urlDetect = "https://api-cn.faceplusplus.com/facepp/v3/detect";
	/**
	 * 人脸分析
	 */
	String urlCompare = "https://api-cn.faceplusplus.com/facepp/v3/face/analyze";
	/**
	 * 人脸查找
	 */
	String urlSearchString = "https://api-cn.faceplusplus.com/facepp/v3/search";
	
	/**
	 * 
	 * 获取人脸识别url
	 * 方法名：getUrlDetect
	 * 创建人：JasonZhang 
	 * 时间：2018-9-22-上午11:18:42 
	 * 邮件：hasp_Jason@163.com
	 * @return urlDetect
	 * @exception 
	 * @since  1.0.0
	 */
	public String getUrlDetect() {
		return urlDetect;
	}
	
	/**
	 * 
	 * 获取人脸分析url
	 * 方法名：getUrlCompare
	 * 创建人：JasonZhang 
	 * 时间：2018-9-22-上午11:18:29 
	 * 邮件：hasp_Jason@163.com
	 * @return urlCompare
	 * @exception 
	 * @since  1.0.0
	 */
	public String getUrlCompare() {
		return urlCompare;
	}
	
	/**
	 * 
	 * 获取人脸查找url
	 * 方法名：getUrlSearchString
	 * 创建人：JasonZhang 
	 * 时间：2018-9-22-上午11:18:01 
	 * 邮件：hasp_Jason@163.com
	 * @return urlSearchString
	 * @exception 
	 * @since  1.0.0
	 */
	public String getUrlSearchString() {
		return urlSearchString;
	}
}
