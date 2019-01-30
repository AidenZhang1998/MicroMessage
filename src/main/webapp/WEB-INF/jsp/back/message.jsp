<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<title>增加message</title>
<script src="<%=basePath%>/resources/js/back/list.js"></script>
<style>
#msgForm>div+div {
	margin-top: 20px;
}

#msgForm>div>label {
	width: 20%;
	padding-left: 2%;
	display: inline-block;
	line-height: 30px;
}

#msgForm>div>.row-content {
	width: 77%;
	display: inline-block;
}

#msgForm>div>.row-content>input {
	width: 85%;
	height: 30px;
}

#msgForm>div>.row-content>textarea {
	width: 85%;
	height: 300px;
}
</style>
</head>
<body style="background: #e1e9eb;">
	<form action="" id="msgForm" method="post">
		<div>
			<label for="command">指令名称：</label>
			<div class="row-content">
				<input id="command" name="command" type="text"
					value="${message.command}" />
			</div>
		</div>
		<div>
			<label for="description">描述：</label>
			<div class="row-content">
				<input id="description" name="description" type="text"
					value="${message.description}" />
			</div>
		</div>
		<div>
			<label for="content">内容：</label>
			<div class="row-content">
				<textarea id="content" name="content" style="resize: none;">${message.content}</textarea>
			</div>
		</div>
		<div>


			<input class="return"
				onclick="javascript:location.href='${basePath}List.action'"
				type="button" title="返回" value="返回" /> 
			<input type="submit" onclick="CreateOne('<%=basePath%>');"
				value="注册" />

		</div>
	</form>
</body>
</html>
