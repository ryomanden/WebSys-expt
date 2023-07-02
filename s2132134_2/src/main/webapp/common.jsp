<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        L
      </span>
    </div>
	
	<!-- general -->
    <div class="border-t border-gray-100">
      <div class="px-2">
        <div class="py-4">
          <a
            href=""
            class="t group relative flex justify-center rounded bg-blue-50 px-2 py-1.5 text-blue-700"
          >
			<i class="fa-solid fa-user"></i>
            <span
              class="absolute start-full top-1/2 ms-4 -translate-y-1/2 rounded bg-gray-900 px-2 py-1.5 text-xs font-medium text-white opacity-0 group-hover:opacity-100"
            >
              None
            </span>
          </a>
        </div>

		<!-- btn list -->
        <ul class="space-y-1 border-t border-gray-100 pt-4">
			<!-- list -->
          <li>
            <a
              href="list"
              class="group relative flex justify-center rounded px-2 py-1.5 text-gray-500 hover:bg-gray-50 hover:text-gray-700"
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
              class="group relative flex justify-center rounded px-2 py-1.5 text-gray-500 hover:bg-gray-50 hover:text-gray-700"
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
    <form action="logout">
      <button
        type="submit"
        class="group relative flex w-full justify-center rounded-lg px-2 py-1.5 text-sm text-gray-500 hover:bg-gray-50 hover:text-gray-700"
      >
        <svg
          xmlns="http://www.w3.org/2000/svg"
          class="h-5 w-5 opacity-75"
          fill="none"
          viewBox="0 0 24 24"
          stroke="currentColor"
          stroke-width="2"
        >
          <path
            stroke-linecap="round"
            stroke-linejoin="round"
            d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1"
          />
        </svg>

        <span
          class="absolute start-full top-1/2 ms-4 -translate-y-1/2 rounded bg-gray-900 px-2 py-1.5 text-xs font-medium text-white opacity-0 group-hover:opacity-100"
        >
          Logout
        </span>
      </button>
    </form>
  </div>
</div>