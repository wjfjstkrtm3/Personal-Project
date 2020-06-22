<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/resources/js/toDoList.js"></script>
<link href="https://fonts.googleapis.com/css?family=Gamja+Flower"
	rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Nanum+Gothic"
	rel="stylesheet">
<style>
html, body, input {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: 'Gamja Flower', cursive;
}

button {
	font-family: 'Gamja Flower', cursive;
	background: #a369af;
	color: #fff;
	font-size: 18px;
	cursor: pointer;
}

.list-box {
	width: 500px;
	margin: 100px auto;
	border: 1px solid #eee;
	padding: 20px 30px 50px;
	background: #333;
}

.list-box h1 {
	padding-bottom: 10px;
	text-align: center;
	color: #9fd6c2;
	border-bottom: 1px solid #87898f;
}

.write-box {
	width: 100%;
	height: 35px;
	font-size: 0;
}

.write-box input {
	width: 400px;
	font-size: 20px;
	border: none;
	padding: 0 10px;
	height: 100%;
}

.write-box button {
	width: 100px;
	border: none;
	height: 100%;
}

.list-table {
	border-spacing: 0px;
	border-collapse: collapse;
	width: 100%;
	margin: 20px 0;
}

th, td {
	border: 1px solid #ddd;
	padding: 10px 20px;
	font-size: 20px;
}

th {
	background: #9fd6c2;
}

td {
	color: #fff;
}

tbody td:first-child {
	text-align: center;
}

.btn-area {
	text-align: center;
}

.btn-area button {
	height: 35px;
	padding: 0 10px;
	border: none;
}`
</style>
</head>
<body>
	<div class="list-box">
		<h1>To Do List</h1>
		<div class="write-box">
			<input type="text" class="text-basic" id="text-basic">
			<button type="button" id="btnAdd">추가</button>
		</div>
		<table class="list-table">
			<colgroup>
				<col width="10%">
				<col width="90%">
			</colgroup>
			<thead>
				<tr>
					<th>check</th>
					<th>To do List</th>
				</tr>
			</thead>
			<tbody id="listBody">
			
			</tbody>
		</table>
		<div class="btn-area">
			<button type="button" id="deleteSel">선택 삭제</button>
			<button type="button" id="btnDelLast">마지막 삭제</button>
			<button type="button" id="btnDelAll">전체 삭제</button>
		</div>
	</div>
</body>
</html>

