<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アカウント作成完了ページ</title>
</head>
<body>
<p>アカウント作成完了</p>
<p><c:out value="${accountCreateForm.name}" />さん</span></p>
<p><c:out value="${accountCreateForm.tel}" /></span></p>
<p><c:out value="${accountCreateForm.dateOfBirth}" /></span></p>
<p><c:out value="${accountCreateForm.email}" /></span></p>
<p><c:out value="${accountCreateForm.sessionTestValueString}" /></span></p>
<p><a href="<c:url value='/' />">トップへ</a></p>
</body>
</html>