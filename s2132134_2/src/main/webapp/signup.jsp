<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign up</title>
</head>
<body>
<%@include file="common.jsp" %>
<div class="body-wrap">
	<div class="body-inner">
	<h1 class="page-title">Sign up</h1>
		<div class="form-wrap">
			<p class="form-description">アカウントを新規作成</p>
			<form action="signup" method="POST">
				<input type="text" name="user" placeholder="ユーザー名" class="form-textinput">
				<input type="password" name="pass" placeholder="パスワード" class="form-textinput">
				<input type="submit" value="登録する" class="form-submit">
				<p class="text-center text-sm text-gray-500">すでにアカウントをお持ちですか？ <a class="underline" href="./login">ログインする</a></p>
			</form>
		</div>
	</div>
</div>
	
</body>
</html>