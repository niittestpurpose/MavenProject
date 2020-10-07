<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="InsertCategory" method="post">
<table align="center">
	<tr bgcolor="pink">
		<td align="center" colspan="2"><h3>Category Detail</h3></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Category Name</td>
		<td><input type="text" name="catName"/></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Category Desc</td>
		<td><textarea rows="5" cols="30" name="catDesc"></textarea></td>
	</tr>
	<tr bgcolor="pink">
		<td colspan="2" align="center">
			<input type="submit" value="Insert Category"/>
		</td>
	</tr>
</table>
</form>

<table align="center">
	<tr bgcolor="pink">
		<td>Catgory ID</td>
		<td>Category Name</td>
		<td>Category Desc</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr bgcolor="cyan">
		<td>${category.categoryId}</td>
		<td>${category.categoryName}</td>
		<td>${category.categoryDesc}</td>
		<td>
			<a href="deleteCategory/${category.categoryId}">Delete</a>&nbsp;&nbsp;/&nbsp;&nbsp;
			<a href="editCategory/${category.categoryId}">Edit</a>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>