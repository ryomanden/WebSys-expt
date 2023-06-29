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
	<h1>Book List</h1>
	<% if (booklist != null) { %>
	<ul>
		<% for (Booklist list: booklist) { %>
		<li><a href="book?bookID=<%=list.getBookId()%>"><%=list.getTitle() %> / <%=list.getAuthor() %></a></li>
		<% } %>
	</ul>
	<a href="favorite?userID=1">Bookmark</a>
	<% } %>
</body>
</html>