package com.cauc.face;

import java.io.File;
import java.util.HashMap;

/**
 * 
 * 人脸识别接口
 * FaceInterface
 * 创建人:JasonZhang 
 * 时间：2018-9-22-上午11:19:55 
 * @version 1.0.0
 *
 */
public interface FaceInterface {
	
	/**
	 * 
	 * 根据文件地址和api_url获取人脸信息
	 * 方法名：faceimg
	 * 创建人：JasonZhang 
	 * 时间：2018-9-22-上午11:20:10 
	 * 邮件：hasp_Jason@163.com
	 * @param fileString
	 * @param urlString
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	String faceimg(String fileString,String urlString);
	
	/**
	 * 
	 * 
	 * 方法名：post
	 * 创建人：JasonZhang 
	 * 时间：2018-9-22-上午11:21:08 
	 * 邮件：hasp_Jason@163.com
	 * @param url
	 * @param map
	 * @param fileMap
	 * @return
	 * @throws Exception byte[]
	 * @exception 
	 * @since  1.0.0
	 */
	byte[] post(String url, HashMap<String, String> map, HashMap<String, byte[]> fileMap) throws Exception;
	
	/**
	 * 
	 * 
	 * 方法名：getBoundary
	 * 创建人：JasonZhang 
	 * 时间：2018-9-22-上午11:21:13 
	 * 邮件：hasp_Jason@163.com
	 * @return String
	 * @exception 
	 * @since  1.0.0
	 */
	String getBoundary();
	
	/**
	 * 
	 * 
	 * 方法名：encode
	 * 创建人：JasonZhang 
	 * 时间：2018-9-22-上午11:21:17 
	 * 邮件：hasp_Jason@163.com
	 * @param value
	 * @return
	 * @throws Exception String
	 * @exception 
	 * @since  1.0.0
	 */
	String encode(String value)throws Exception;
	
	/**
	 * 
	 * 
	 * 方法名：getBytesFromFile
	 * 创建人：JasonZhang 
	 * 时间：2018-9-22-上午11:21:23 
	 * 邮件：hasp_Jason@163.com
	 * @param f
	 * @return byte[]
	 * @exception 
	 * @since  1.0.0
	 */
	byte[] getBytesFromFile(File f);
	
}
