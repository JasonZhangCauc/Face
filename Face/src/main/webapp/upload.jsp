<%@ page language="java" import="java.util.*,com.cauc.face.*" pageEncoding="utf-8"%>
<%
	String fileName=UploadFilesUtil.uploadFiles(request,response);
	System.out.println("in upload.jsp");
	if(null !=fileName){
	session.setAttribute("fileName","upload/"+fileName);
	response.sendRedirect("face.jsp");
	}
%>