<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bookmark.UserModel, bookmark.ReviewModel, java.util.List"%>
<% UserModel user = (UserModel) request.getAttribute("user"); %>
<% List<ReviewModel> reviewList = (List<ReviewModel>) request.getAttribute("review"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
<%@include file="common.jsp" %>
<div class="body-wrap">
	<div class="body-inner">
		<% if (user != null) {%>
			<h1 class="page-title"><%=user.getUserName() %></h1>
			<p class="mt-4 text-slate-500">自己紹介</p>
			<p><%=user.getUserBio() %></p>
			<div class="divider"></div>
			<% if (reviewList != null && reviewList.size() != 0) { %>
				<% for (ReviewModel review: reviewList) { %>
					<div class="mt-2 p-4 border border-gray-100 rounded-lg shadow-sm">
						<p class="text-lg font-bold text-gray-90"><%=review.getReviewTitle()%></p>
						<a href="book?bookID=<%=review.getBookId() %>" class="mt-1 text-xs font-medium text-gray-600 link link-hover">「<%=review.getBookTitle()%>」- <%=review.getBookAuthor() %></a>
						<p class="mt-3 text-sm text-gray-500"><%=review.getComment()%></p>
					</div>
				<% } %>
			<% } else { %>
				<p>null:review</p>
			<% } %>
		<% } else { %>
			<p>null:user</p>
		<% } %>
	</div>
</div>
</body>
</html>