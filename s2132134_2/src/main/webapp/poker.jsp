<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="poker.PokerModel"%>
<%
PokerModel model = (PokerModel) request.getAttribute("model");
String label = model.getButtonLabel();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- CDNからTailwind CSSの読み込み -->
<script src="https://cdn.tailwindcss.com"></script>
<title>Poker</title>
</head>
<body class="text-slate-950">
	<h1 class="text-3xl font-bold left-1/2 text-center">ポーカーゲーム</h1>

	<!-- Information -->
	<div class="m-5">
		<p class="mt-3 w-fit border text-slate-700 border-slate-100 rounded-lg overflow-hidden">
			<span class="p-1 inline bg-slate-100">ゲーム回数</span>　<%=model.getGames()%>　</p>
		<p class="mt-3 w-fit border text-slate-700 border-slate-100 rounded-lg overflow-hidden">
			<span class="p-1 inline bg-slate-100">　チップ　</span>　<%=model.getChips()%>　</p>

		<!-- Message -->
		<div
			class="w-fit block my-3 px-5 py-3 bg-amber-100 text-amber-700 rounded-lg"><%=model.getMessage()%></div>

		<!-- Application -->
		<form action="/s2132134_2/PokerServlet" method="POST">
		
			<!-- Trump List -->
			<div class="inline-grid grid-cols-5 gap-1.5">
				<label
					class="p-3 relative w-fit block [&:has(input[type='checkbox']:checked)]:bg-slate-100 after:content-['Change'] after:hidden [&:has(input[type='checkbox']:checked)]:after:block after:absolute after:bg-blue after:top-1 after:left-1 after:bg-red-500 after:px-1 after:text-slate-100 after:text-xs after:rounded-full rounded-lg"><img
					src="cards/<%=model.getHandcardAt(0)%>.png" width="100"
					height="150"><input type="checkbox" name="change" value="0"></label>
				<label
					class="p-3 relative w-fit block [&:has(input[type='checkbox']:checked)]:bg-slate-100 after:content-['Change'] after:hidden [&:has(input[type='checkbox']:checked)]:after:block after:absolute after:bg-blue after:top-1 after:left-1 after:bg-red-500 after:px-1 after:text-slate-100 after:text-xs after:rounded-full rounded-lg"><img
					src="cards/<%=model.getHandcardAt(1)%>.png" width="100"
					height="150"><input type="checkbox" name="change" value="1"></label>
				<label
					class="p-3 relative w-fit block [&:has(input[type='checkbox']:checked)]:bg-slate-100 after:content-['Change'] after:hidden [&:has(input[type='checkbox']:checked)]:after:block after:absolute after:bg-blue after:top-1 after:left-1 after:bg-red-500 after:px-1 after:text-slate-100 after:text-xs after:rounded-full rounded-lg"><img
					src="cards/<%=model.getHandcardAt(2)%>.png" width="100"
					height="150"><input type="checkbox" name="change" value="2"></label>
				<label
					class="p-3 relative w-fit block [&:has(input[type='checkbox']:checked)]:bg-slate-100 after:content-['Change'] after:hidden [&:has(input[type='checkbox']:checked)]:after:block after:absolute after:bg-blue after:top-1 after:left-1 after:bg-red-500 after:px-1 after:text-slate-100 after:text-xs after:rounded-full rounded-lg"><img
					src="cards/<%=model.getHandcardAt(3)%>.png" width="100"
					height="150"><input type="checkbox" name="change" value="3"></label>
				<label
					class="p-3 relative w-fit block [&:has(input[type='checkbox']:checked)]:bg-slate-100 after:content-['Change'] after:hidden [&:has(input[type='checkbox']:checked)]:after:block after:absolute after:bg-blue after:top-1 after:left-1 after:bg-red-500 after:px-1 after:text-slate-100 after:text-xs after:rounded-full rounded-lg"><img
					src="cards/<%=model.getHandcardAt(4)%>.png" width="100"
					height="150"><input type="checkbox" name="change" value="4"></label>
			</div>
			
			<!-- Button -->
			<div class="w-32 flex flex-col">
				<!-- Change/NextGame -->
				<input
					class="mt-5 mb-2 text-sm text-center font-semibold text-white py-2.5 px-4 rounded-lg bg-slate-900 focus:outline-none hover:bg-slate-700 focus:ring-1 focus:ring-slate-400 focus:ring-offset-2"
					type="submit" value="<%=label%>">
				<!-- Reset -->
				<a
					class="mt-2 text-sm text-center font-semibold text-slate-950 py-2.5 px-4 rounded-lg bg-slate-50 focus:outline-none hover:bg-slate-100 focus:ring-1 focus:ring-slate-400 focus:ring-offset-2"
					href="/s2132134_2/PokerServlet">リセット</a>
			</div>
		</form>
	</div>
</body>
<style>
/* disable default checkbox */
input[type="checkbox"] {
	display: none;
}
</style>
</html>