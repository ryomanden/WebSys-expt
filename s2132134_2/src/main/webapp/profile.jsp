<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bookmark.UserModel, java.util.List"%>
<% 
request.setCharacterEncoding("UTF-8");
UserModel user = (UserModel) request.getAttribute("user");
%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title><%=user.getUserName() %> in User Profile</title>
</head>
<body>
<script type="text/javascript">
	const charCounter = (c) => {
		var charCountText = document.getElementById('charCount');
		charCountText.innerHTML = c+'文字';
		if (c > 200) {
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
		<% if (user != null) { %>
			<h1 class="page-title"><%=user.getUserName() %></h1>
			<div class="w-full relative">
	  			<form action="profile" method="POST">
					<label class="label">
			    			<span class="label-text text-slate-500">自己紹介</span>
			    			<span class="label-text-alt" id="charCount"><%= (user.getUserBio() != null) ? user.getUserBio().length() : 0 %>文字</span>
		  			</label>
					<textarea name="bio" class="form-textarea" placeholder="自己紹介を記入してください。" onkeyup="charCounter(this.value.length)"><%= (user.getUserBio() != null) ? user.getUserBio() : "" %></textarea>
					<div class="flex w-full">
						<input type="submit" value="保存" class="form-save" id="submit">
					</div>
				</form>
			</div>
		<% } else { %>
			<p>ここにエラー出す</p>
		<% } %>
	</div>
</div>
</body>

</html>