<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String current = (String) request.getAttribute("current"); %>
<% Boolean stat = (Boolean) request.getAttribute("isLogin"); %>
<% boolean isLogin = (stat == null) ? false : stat;%>
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