<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>更新画面</title>
  <link rel="stylesheet" href="/web/resources/style.css">
</head>

<body>
	更新画面
	<form:form modelAttribute="lessonListForm">
		${lessonListForm.userFirstName}
	</form:form>
	
</html>