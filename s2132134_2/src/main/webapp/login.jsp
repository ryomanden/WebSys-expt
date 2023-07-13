<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%@include file="common.jsp" %>
<div class="body-wrap">
	<div class="body-inner">
	<h1 class="page-title">Login</h1>
		<div class="form-wrap">
			<p class="form-description">サイトにログイン</p>
			<form action="login" method="POST">
				<input type="text" name="user" placeholder="username" class="form-textinput">
				<input type="password" name="pass" placeholder="password" class="form-textinput">
				<input type="submit" value="ログイン" class="form-submit">
				<p class="text-center text-sm text-gray-500">アカウントがまだありませんか？ <a class="underline" href="">アカウントを作成</a></p>
			</form>
		</div>
	</div>
</div>
	
</body>
</html>