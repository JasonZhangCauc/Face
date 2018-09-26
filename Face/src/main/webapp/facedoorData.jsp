<%@ page language="java" import="java.util.*,com.cauc.face.*" pageEncoding="utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");
	String base64 = request.getParameter("imgBase64");
	String msg=FaceDoorUtil.getFaceDoorMessage(base64);
	out.println(msg);
%>