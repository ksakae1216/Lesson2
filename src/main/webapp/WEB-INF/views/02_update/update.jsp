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

</head>

<body>
		<!-- Default form contact -->
<form:form class="text-center border border-light p-5" modelAttribute="lessonListForm">

    <p class="h4 mb-4">Update user: ${lessonListForm.userId}</p>

    <!-- userFirstName -->
    <label>User FirstName</label>
    <form:input path="userFirstName" class="form-control mb-4" placeholder="User FirstName"/>

    <!-- userLastName -->
    <label>User LastName</label>
    <form:input path="userLastName" class="form-control mb-4" placeholder="User LastName"/>

    <!-- lesson1st -->
    <label>lesson1st</label>
    <form:input path="lesson1st" class="form-control mb-4" placeholder="lesson1st"/>
    
    <!-- lesson2nd -->
    <label>lesson2nd</label>
    <form:input path="lesson2nd" class="form-control mb-4" placeholder="lesson2nd"/>

    <!-- Subject -->
    <label>Subject</label>
    <select class="browser-default custom-select mb-4">
        <option value="" disabled>Choose option</option>
        <option value="1" selected>Feedback</option>
        <option value="2">Report a bug</option>
        <option value="3">Feature request</option>
        <option value="4">Feature request</option>
    </select>

    <!-- Message -->
    <div class="form-group">
        <textarea class="form-control rounded-0" id="exampleFormControlTextarea2" rows="3" placeholder="Message"></textarea>
    </div>

    <!-- Copy -->
    <div class="custom-control custom-checkbox mb-4">
        <input type="checkbox" class="custom-control-input" id="defaultContactFormCopy">
        <label class="custom-control-label" for="defaultContactFormCopy">Send me a copy of this message</label>
    </div>

    <form:button  class="btn btn-info btn-block">更新</form:button>

	<form:hidden path="userId"/>
</form:form>
<!-- Default form contact -->

	
</html>