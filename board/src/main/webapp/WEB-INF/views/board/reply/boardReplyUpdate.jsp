<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<div>
<form action="" method="POST">
	제목 : <input type="text" name="writer" value="${replyVo.writer}" readonly="readonly"><br>
	내용 : <input type="text" name="content" value="${replyVo.content}"><br>
	<input type="submit" value="수정하기">
</form>
</div>

</body>
</html>