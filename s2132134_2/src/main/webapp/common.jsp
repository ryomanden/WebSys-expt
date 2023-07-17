<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String current = (String) request.getAttribute("current");
String signUpStatus = (String) session.getAttribute("signUpStatus");
Boolean stat = (Boolean) request.getAttribute("isLogin");
Boolean success = (Boolean) request.getAttribute("isSuccess");
boolean isLogin = (stat == null) ? false : stat;
boolean isSuccess = (success == null) ? false : success;
%>
<!DOCTYPE html>
<style type="text/css">
<%@include file="CSS/styles_dist.css" %>
</style>
<link rel ="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
<div class="fixed flex h-screen w-16 z-50 flex-col justify-between border-e bg-white">
  <div>
  	<!-- logo -->
    <div class="inline-flex h-16 w-16 items-center justify-center">
      <span
        class="grid h-10 w-10 place-content-center rounded-lg bg-gray-100 text-xs text-gray-600"
      >
        <i class="fa-solid fa-book"></i>
      </span>
    </div>
	<!-- profile -->
    <div class="border-t border-gray-100">
      <div class="px-2">
        <div class="py-4">
          <a
            href="profile"
            class="group <%= ("profile".equals(current)) ? "side-active" : "side-deactive" %>"
          >
			<i class="fa-solid fa-user"></i>
            <span
              class="absolute start-full top-1/2 ms-4 -translate-y-1/2 rounded bg-gray-900 px-2 py-1.5 text-xs font-medium text-white opacity-0 group-hover:opacity-100"
            >
              Profile
            </span>
          </a>
        </div>

		<!-- btn list -->
        <ul class="space-y-1 border-t border-gray-100 pt-4">
			<!-- list -->
          <li>
            <a
              href="list"
              class="group <%= ("list".equals(current)) ? "side-active" : "side-deactive" %>"
            >
       		<i class="fa-solid fa-list"></i>
              <span
                class="absolute start-full top-1/2 ms-4 -translate-y-1/2 rounded bg-gray-900 px-2 py-1.5 text-xs font-medium text-white opacity-0 group-hover:opacity-100"
              >
                BookList
              </span>
            </a>
          </li>
			<!-- fav -->
          <li>
            <a
              href="favorite"
              class="group <%= ("favorite".equals(current)) ? "side-active" : "side-deactive" %>"
            >
            <i class="fa-solid fa-heart"></i>
              <span
                class="absolute start-full top-1/2 ms-4 -translate-y-1/2 rounded bg-gray-900 px-2 py-1.5 text-xs font-medium text-white opacity-0 group-hover:opacity-100"
              >
                Favorite
              </span>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </div>

	<!-- logout -->
  <div class="sticky inset-x-0 bottom-0 border-t border-gray-100 bg-white p-2">
  	<% if (isLogin) { %>
    	<a href="logout" class="side-deactive">
   	  		<i class="fa-solid fa-right-from-bracket"></i>
        	<span class="side-tooltip">Logout</span>
    	</a>
 	<% } else { %>
   		<a href="login" class="<%= ("login".equals(current)) ? "side-active" : "side-deactive" %>">
  			<i class="fa-solid fa-right-to-bracket"></i>
    	    <span class="side-tooltip">Login</span>
	   	</a>
  	<% } %>
  </div>
</div>
<%if (isSuccess) { %>
	<div class="toast z-50" id="toast">
		<div class="alert">
  			<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" class="stroke-info shrink-0 w-6 h-6"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"></path></svg>
  			<span>更新しました。</span>
		</div>
	</div>
	<script type="text/javascript">
		const toast = document.querySelector("#toast")
		toast.style.visibility = "visible";
		setTimeout(function() {
		      toast.style.visibility = "hidden";
		}, 3000);
	</script>
<% } %>
<%if (signUpStatus != null) { %>
	<div class="toast z-50" id="toast">
		<%if (signUpStatus.equals("success")) { %>
			<div class="alert">
	  			<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" class="stroke-info shrink-0 w-6 h-6"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"></path></svg>
	  			<span>作成しました。</span>
			</div>
			<script type="text/javascript">
				const toast = document.querySelector("#toast")
				toast.style.visibility = "visible";
				setTimeout(function() {
				      toast.style.visibility = "hidden";
				}, 3000);
			</script>
		<% } else if (signUpStatus.equals("duplicate")) { %>
			<div class="alert alert-warning">
				<svg xmlns="http://www.w3.org/2000/svg" class="stroke-current shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 9v2m0 4h.01m-6.938 4h13.856c1.54 0 2.502-1.667 1.732-3L13.732 4c-.77-1.333-2.694-1.333-3.464 0L3.34 16c-.77 1.333.192 3 1.732 3z" /></svg>
				<span>すでに登録されています。</span>
			</div>
			<script type="text/javascript">
				const toast = document.querySelector("#toast")
				toast.style.visibility = "visible";
				setTimeout(function() {
				      toast.style.visibility = "hidden";
				}, 3000);
			</script>
		<% } else if (signUpStatus.equals("fail")) { %>
			<div class="alert alert-error">
				<svg xmlns="http://www.w3.org/2000/svg" class="stroke-current shrink-0 h-6 w-6" fill="none" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 9v2m0 4h.01m-6.938 4h13.856c1.54 0 2.502-1.667 1.732-3L13.732 4c-.77-1.333-2.694-1.333-3.464 0L3.34 16c-.77 1.333.192 3 1.732 3z" /></svg>
				<span>エラーが発生しました。</span>
			</div>
			<script type="text/javascript">
				const toast = document.querySelector("#toast")
				toast.style.visibility = "visible";
				setTimeout(function() {
				      toast.style.visibility = "hidden";
				}, 3000);
			</script>
		<% } %>	
	</div>
	<% session.setAttribute("signUpStatus", null); %>
<% } %>