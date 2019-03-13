<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;
}
</style>


</head>
<body>
<h1>Well come to restfull  web services </h1>
<br>


<div style="border: 2px ; background-color: linen;" > 
Add new Person
<form action="/Persons" method="post"> 
	<input type="text" name="firstName" >
	<input type="text" name="lastName" >
	<input type="submit" value="Submit" >
</form>
</div>

<hr>
Updating form 
<div style="background-color: linen;" > 
<mvc:form method="POST" modelAttribute="person" action="/Persons/${person.id}" >
	<table>
			<input type="hidden" name="method" value="put">
		<tr>
	        <td><mvc:label path="id">id</mvc:label></td>
	        <td> <mvc:input path="id" /> </td>
	    </tr>
	   
	    <tr>
	        <td><mvc:label path="firstName">First Name</mvc:label></td>
	        <td><mvc:input path="firstName" /></td>
	    </tr>
	    
	    <tr>
	        <td><mvc:label path="lastName">Last Name</mvc:label></td>
	        <td><mvc:input path="lastName" /></td>
	    </tr>
	     
        <tr>
	        <td colspan="2">
                <input type="submit" value="Update" />
	        </td>
	    </tr>
	</table>  
</mvc:form>
</div>



<hr>
	All persons List : 
     
 
  <c:if test="${not empty persons}">  
    
  <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th>Update</th>
      <th>Delete</th>
     </tr>
  </thead>
  
 <c:forEach var="person" items="${persons }">  
  <tbody>
    <tr>
      <th scope="row">${person.id}</th>
      <td>${person.firstName}</td>
	  <td>${person.lastName}</td>
	  <td><a href="/Persons/${person.id}" >update </a></td>	
	  <td>
	  	<form action="/Persons/${person.id}" method="post">
	  	 <input type="hidden" name="method" value="delete">
	  	 <input type="submit" value="delete" >
	  	</form>
 	  </td>
	  
   </tr>    
  </tbody>
 </c:forEach>
  
</table>
 </c:if>   
	
</body>
</html>