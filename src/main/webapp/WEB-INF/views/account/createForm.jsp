<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント作成ページ</title>
</head>
<body>
<form:form action="/learningapp/account/createForm?confirm" method="post" modelAttribute="accountCreateForm">
	<div>
	名前：
		<form:input path="name" />
		<form:errors path="name" />
	</div>
	<div>
	TEL：
		<form:input path="tel" />
		<form:errors path="tel" />
	</div>
	<div>
	誕生日：
		<form:input path="dateOfBirth" type="date" />
		<form:errors path="dateOfBirth" />
	</div>
	<div>
	E-mail：
		<form:input path="email" type="email" />
		<form:errors path="email" />
	</div>
	<form:button>確認</form:button>
</form:form>
</body>
</html>