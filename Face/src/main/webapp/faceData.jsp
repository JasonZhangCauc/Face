<%@ page language="java" import="java.util.*,com.cauc.face.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String path = request.getParameter("path");
	String pathName=request.getRealPath(path);
	String msg=FaceMessageUtil.getFaceMessage(pathName);
	out.println(msg);
%>



