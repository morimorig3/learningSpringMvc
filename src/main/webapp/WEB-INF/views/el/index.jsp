<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL式</title>
</head>
<body>
<h1>EL式確認ページ</h1>
<div>
<h2>算術演算</h2>
<p>+ : 2 + 3 = ${2 + 3}</p>
<p>- : 2 - 3 = ${2 - 3}</p>
<p>* : 2 * 3 = ${2 * 3}</p>
<p>/ : 2 / 3 = ${2 / 3}</p>
<p>% : 2 % 3 = ${2 % 3}</p>
<h2>比較演算子</h2>
<p>== : 2 == 3 = ${2 == 3}</p>
<p>!= : 2 != 3 = ${2 != 3}</p>
<p>empty : empty(null) = ${empty(null)}</p>
<h2>暗黙オブジェクト</h2>
<p>pageContext : ${pageContext}</p>
<p>cookie : ${cookie}</p>
<h2>EL関数</h2>
<p>fn:toUpperCase("ra-men") : ${fn:toUpperCase("ra-men")}</p>
</div>
<p><a href="<c:url value='/' />">トップへ</a></p>
</body>
</html>