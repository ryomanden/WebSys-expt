<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bookmark.Booklist, bookmark.ReviewModel, java.util.List"%>
<% Booklist book = (Booklist) request.getAttribute("book"); %>
<% List<ReviewModel> reviewList = (List<ReviewModel>) request.getAttribute("review"); %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title><%=book.getTitle() %> - <%=book.getAuthor() %></title>
</head>
<body>
<%@include file="common.jsp" %>
<div class="body-wrap">
	<div class="body-inner">
	<% if (book != null) { %>
		<h1 class="mt-7 font-bold text-4xl"><%=book.getTitle()%></h1>
		<p class="mt-4 text-slate-500 ">著者 : <%=book.getAuthor()%></p>
		<p class="mt-1 text-slate-500 ">出版日 : <%=book.getCreatedAt()%></p>
		<%if (reviewList != null && reviewList.size() != 0) { %>
			<% for (ReviewModel review: reviewList) { %>
				<div class="mt-2 p-4 border border border-gray-100 rounded-lg shadow-sm">
					<p class="text-lg font-bold text-gray-90"><%=review.getReviewTitle()%></p>
					<a href="" class="mt-1 text-xs font-medium text-gray-600 link link-hover">By ID:<%=review.getUserId()%>(ユーザー名出るように)</a>
					<p class="mt-3 text-sm text-gray-500"><%=review.getComment()%></p>
				</div>
			<% } %>
		<% } else { %>
			<p>レビューはまだありません</p>
		<% } %>
	<% } else { %>
		<h1>Book page</h1>
		<p>不正なURLです。</p>
	<% } %>
	</div>
</div>
</body>
</html>