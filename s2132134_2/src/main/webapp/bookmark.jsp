<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="bookmark.Booklist, java.util.List"%>
<% List<Booklist> booklist = (List<Booklist>) request.getAttribute("list"); %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Book Mark</title>
</head>
<body>
<%@include file="common.jsp" %>
<div class="body-wrap">
	<div class="body-inner">
		<h1 class="page-title">My Favorite</h1>
		<div class="overflow-x-auto w-full">
			<% if (booklist != null && booklist.size() > 0) {%>
				<p class="text-xs ml-3 mb-3 text-slate-400"><%=booklist.size() %>冊の本があります。</p>
				<table class="table w-full">
					<thead>
						<tr>
							<th>タイトル</th>
							<td>著者</th>
							<td>出版日</th>
							<td></th>
						</tr>
					</thead>
					<tbody>
						<% for (Booklist list: booklist) { %>
							<tr>
								<th><%=list.getTitle()%></th>
								<td><%=list.getAuthor()%></td>
								<td><%=list.getCreatedAt()%></td>
								<td class="w-1"><a href="book?bookID=<%=list.getBookId()%>" class="btn btn-outline btn-primary">詳細</a></td>
							</tr>
						<% } %>			
					</tbody>
				</table>
			<% } else { %>
				<div class="alert alert-error w-fit">
				  <svg xmlns="http://www.w3.org/2000/svg" class="stroke-current shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10 14l2-2m0 0l2-2m-2 2l-2-2m2 2l2 2m7-2a9 9 0 11-18 0 9 9 0 0118 0z" /></svg>
				  <span>Error: お気に入りの本を登録していないか、URLが間違っています。</span>
				</div>
			<% } %>
		</div>
	</div>	
</div>
</body>
</html>