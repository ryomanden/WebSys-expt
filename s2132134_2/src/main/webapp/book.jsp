<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bookmark.Booklist, java.util.List"%>
<% Booklist book = (Booklist) request.getAttribute("book"); %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if (book != null) { %>
		<h1><%=book.getTitle()%></h1>
		<h2><%=book.getAuthor()%></h2>
		<p><%=book.getCreatedAt()%></p>
	<% } else { %>
		<h1>Book page</h1>
		<p>不正なURLです。</p>
	<% } %>
	<a href="list">list</a>
</body>
</html>