<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bookmark.Booklist, java.util.List"%>
<% List<Booklist> booklist = (List<Booklist>) request.getAttribute("list"); %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Book Mark</h1>
	<ul>
	</ul>
</body>
</html>