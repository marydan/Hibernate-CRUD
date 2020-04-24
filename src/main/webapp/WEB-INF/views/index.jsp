<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4> Add Category </h4>

<form method="POST" action="save" modelAttribute="category">
Categoryid <input type=text name=cid disabled> <br>
Description <input type=text name=cname> <br>
<input type=submit value="Save"> <br>
</form>
 
 <h3> View Details </h3>
 

<table border="3">
<tr><td> categoryid </td><td> Description</td> </tr>

<c:forEach items="${categorieslist}" var="cat">
<tr>
<td>${cat.cid} </td>
<td>${cat.cname} </td>
<td><a href="delete?catid=${cat.cid}">Delete</a> </td>
<td><a href="findcat?catid=${cat.cid}">Update</a> </td>

</tr>
</c:forEach>


</table>

<h3> Update</h3>

<form  method="PUT" action="update" modelAttribute="catupd">
Category ID <input type=text name=cid  value=${catobj.cid}> <br>
Description <input type=text name=cname value=${catobj.cname}> <br>
<input type=submit value="Update">
</form>

</body>

</html>