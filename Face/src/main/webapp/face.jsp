<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>人脸识别</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/face.css">
</head>

<body>
	<div class="container">
		<h1><i class="fa fa-bandcamp fa-spin"></i>人脸识别</h1>
		<!-- <div class="banner"></div> -->

		<form action="upload.jsp" method="post" enctype="multipart/form-data"
			id="arryForm">
			<a href="javascript:;" class="upload" id="upload_btn"
				onClick="openBrows();">上传照片</a> <input type="file" id="file"
				name="file" onchange="saveFile()" /> <input type="text"
				id="filename" />
		</form>

		<div class="photo">
			<div class="p_box">
				<img src="${empty fileName ? 'images/face.jpg' :fileName}" id="path"
					alt="zhang" width="300px"  style=" border-radius: 15px;" />
				<div class="bs scale"></div>
			</div>
			<div class="p_value">
				<h2>人脸识别扫描结果：</h2>
				<p class="p_info" id="p_message"></p>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="http://cdn.bootcss.com/canvas-nest.js/1.0.0/canvas-nest.min.js"></script>
	<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
	<script src="js/dot.js"></script>
	<script type="text/javascript">
        Dot("dot", {
            cW:window.innerWidth,
            cH:100,
            dotColor:'#DE0D59'
        });
        </script>
	<script type="text/javascript">
	$(function(){
		//点击上传按钮
		$("#upload_btn").click(function(){
			
			var ie = navigator.appName == "Microsoft Internet Explorer" ? true :false;
			if(ie){
				document.getElementById("file").click();//file文本绑定click事件
				document.getElementById("fileName").value=document.getElementById("file").value;
			}else{
				var a =document.createEvent("MouseEvents");
				a.initEvent("click",true,true);
				document.getElementById("file").dispatchEvent(a);}
				
		});
		//执行人脸识别
	faceDo();
	});
	//上传图像
	function saveFile(){
			document.getElementById("arryForm").submit();
		}
	
	//人脸识别
	function faceDo(){
		var msg= $("#path").attr("src");
		$.ajax({
			type:"post",
			url:"faceData.jsp",
			data:{"path":msg},
			success:function(data){
			$("#p_message").prepend(data);
				$(".bs").removeClass().empty();
			}
		});
	}
	 function openBrows(){
       	
   	}
</script>
</body>
</html>
