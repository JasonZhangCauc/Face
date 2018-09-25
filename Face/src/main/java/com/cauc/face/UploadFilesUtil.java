package com.cauc.face;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * 
 * 图像上传工具类
 * UploadFilesUtil
 * 创建人:JasonZhang 
 * 时间：2018-9-22-下午3:29:26 
 * @version 1.0.0
 *
 */
public class UploadFilesUtil 
{
	
	/**
	 * 
	 * 文件异步上传工具类
	 * 方法名：uploadFiles
	 * 创建人：JasonZhang 
	 * 时间：2018-9-22-下午3:29:39 
	 * 邮件：hasp_Jason@163.com
	 * @param request 请求
	 * @param response 响应
	 * @return String 服务器路径
	 * @exception 
	 * @since  1.0.0
	 */
	public static String uploadFiles(HttpServletRequest request,HttpServletResponse response)
	{
		String fileName = null;
		
		//统一编码集
		try 
		{
			request.setCharacterEncoding("utf-8");
			boolean bol = ServletFileUpload.isMultipartContent(request);
			if(bol)
			{
				//构建文件上传对象
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				
				//创建文件迭代器
				Iterator items = upload.parseRequest(request).iterator();
				while(items.hasNext())
				{
					FileItem item = (FileItem)items.next();
					//判断
					boolean ite = item.isFormField();
					if(!ite)
					{
						//文件名
						fileName=item.getName();
						//定义文件上传目录
						String FilePath = request.getRealPath("upload");
						
						File file = new File(FilePath);
						if(!file.exists())//文件不存在则创建
						{
							file.mkdirs();
						}
						File uploadFile = new File(FilePath+"\\"+fileName);
						System.out.println("FilePath: "+FilePath);
						item.write(uploadFile);
					}
				}		
			}
			System.out.println("UploadFilesUtil.java fileName: "+fileName);
			//文件名称
			return fileName;
		} catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}finally{}
	}
	//java入口
}
