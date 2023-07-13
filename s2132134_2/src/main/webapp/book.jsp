<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bookmark.Booklist, bookmark.ReviewModel, java.util.List"%>
<%
Booklist book = (Booklist) request.getAttribute("book");
List<ReviewModel> reviewList = (List<ReviewModel>) request.getAttribute("review");
ReviewModel myReview = (ReviewModel) request.getAttribute("myReview");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title><%=book.getTitle() %> - <%=book.getAuthor() %></title>
</head>
<body>
<script type="text/javascript">
	const charCounter = (c) => {
		var charCountText = document.getElementById('charCount');
		charCountText.innerHTML = c+'文字';
		if (c > 50) {
			charCountText.classList.add("text-red-500");
			document.getElementById("submit").disabled = true;
		} else {
			charCountText.classList.remove("text-red-500");
			document.getElementById("submit").disabled = false;
		}
	}
</script>
<%@include file="common.jsp" %>
<div class="body-wrap">
	<div class="body-inner">
	<% if (book != null) { %>
		<h1 class="mt-7 font-bold text-4xl"><%=book.getTitle()%></h1>
		<p class="mt-4 text-slate-500 ">著者 : <%=book.getAuthor()%></p>
		<p class="mt-1 text-slate-500 ">出版日 : <%=book.getCreatedAt()%></p>
		<div class="divider">読者のレビュー</div>
		<%if (reviewList != null && reviewList.size() != 0) { %>
			<% for (ReviewModel review: reviewList) { %>
				<div class="mt-2 p-4 border border-gray-100 rounded-lg shadow-sm">
					<p class="text-lg font-bold text-gray-90"><%=review.getReviewTitle()%></p>
					<a href="user?userID=<%=review.getUserId() %>" class="mt-1 text-xs font-medium text-gray-600 link link-hover">By <%=review.getUserName()%></a>
					<p class="mt-3 text-sm text-gray-500"><%=review.getComment()%></p>
				</div>
			<% } %>
		<% } else { %>
			<p>レビューはまだありません</p>
		<% } %>
		<div class="divider mt-10">レビューを投稿する</div>
		<form action="book" method="POST">
			<label class="label">
	    			<span class="label-text text-slate-500">タイトル</span>
	    			<span class="label-text-alt" id="charCount"><%= (myReview.getReviewTitle() != null) ? myReview.getReviewTitle().length() : 0 %>文字</span>
  			</label>
			<input type="text" name="reviewTitle" placeholder="タイトル" class="form-textinput" onkeyup="charCounter(this.value.length)" value="<%= (myReview.getReviewTitle() != null) ? myReview.getReviewTitle() : "" %>">
			<label class="label">
	    			<span class="label-text text-slate-500">レビュー</span>
  			</label>
			<textarea name="review" class="form-textarea" placeholder="この本のレビューを記入してください。"><%= (myReview.getComment() != null) ? myReview.getComment() : "" %></textarea>
			<div class="flex w-full">
				<input type="submit" value="投稿" class="form-save" id="submit">
			</div>
		</form>
	<% } else { %>
		<h1>Book page</h1>
		<p>不正なURLです。</p>
	<% } %>
	</div>
</div>
</body>
</html>