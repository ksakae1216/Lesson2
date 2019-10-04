<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en" >

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>更新画面</title>
  
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

	<script	src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
 	<script>
		$(function() {
 			$("input[name='userFirstName']").focus(function (){
 				console.log('フォーカスされました。');
 				$("input[name='userFirstName']").addClass('bg-primary text-white');
 			});
 		});

 	</script>

</head>

<body>
		<!-- Default form contact -->
<form:form class="text-center border border-light p-5" modelAttribute="lessonListForm">

    <p class="h4 mb-4 bg-info text-white rounded">Update user: ${lessonListForm.userId}</p>

    <!-- userFirstName -->
    <label>User FirstName</label>
    <form:input path="userFirstName" class="form-control mb-4" placeholder="User FirstName"/>

    <!-- userLastName -->
    <label>User LastName</label>
    <form:input path="userLastName" class="form-control mb-4" placeholder="User LastName"/>

    <!-- lesson1st -->
    <label>lesson1st</label>
     <form:select path="lesson1st" cssClass="browser-default custom-select mb-4">
    	<form:options items="${languageForm}" itemValue="language" itemLabel="language"/>
    </form:select>
    
    <!-- lesson2nd -->
    <label>lesson2nd</label>
     <form:select path="lesson2nd" cssClass="browser-default custom-select mb-4">
    	<form:options items="${languageForm}" itemValue="language" itemLabel="language"/>
    </form:select>

    <form:checkbox path="deleteFlg"/>
    <form:label path="">このIDを削除</form:label>

    <form:button  class="btn btn-info btn-block">更新</form:button>

	<form:hidden path="userId"/>
</form:form>
<!-- Default form contact -->

	
</html>