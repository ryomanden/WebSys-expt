<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="poker.PokerModel" %>
<%
PokerModel model = (PokerModel)request.getAttribute("model");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Poker</title>
</head>
<body>
ポーカーゲーム
<hr>
ゲーム回数：<%= model.getGames() %>
<hr>
<form action="/s2132134_2/PokerServlet" method="POST">
<input type="submit" value="送信">
</form>
<hr>
<a href="/s2132134_2/PokerServlet">リセット</a>
<hr>
<% if (model.getGames() < 5) { %>
5回未満
<% } else { %>
5回以上
<% } %>
</body>
</html>