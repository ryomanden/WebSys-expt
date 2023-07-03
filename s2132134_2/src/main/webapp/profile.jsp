<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bookmark.UserModel, java.util.List"%>
<% UserModel user = (UserModel) request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="common.jsp" %>
<div class="body-wrap">
	<div class="body-inner">
		<% if (user != null) { %>
			<h1 class="page-title"><%=user.getUserName() %></h1>
			<p class="mt-4 text-slate-500">自己紹介</p>
			<p><%=user.getUserBio() %></p>
		<% } else { %>
			<p>ここにエラー出す</p>
		<% } %>
	</div>
</div>
</body>
</html>