<%@page language="java" contentType="text/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value="${PageContext}/UpdateCategory"/>" method="post">
<table align="center">
	<tr bgcolor="pink">
		<td align="center" colspan="2"><h3>Category Detail</h3></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Category Id</td>
		<td><input type="text" name="catId" value="${category.categoryId}" readonly/></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Category Name</td>
		<td><input type="text" name="catName" value="${category.categoryName}"/></td>
	</tr>
	<tr bgcolor="cyan">
		<td>Category Desc</td>
		<td><textarea rows="5" cols="30" name="catDesc">${category.categoryDesc}</textarea></td>
	</tr>
	<tr bgcolor="pink">
		<td colspan="2" align="center">
			<input type="submit" value="Update Category"/>
		</td>
	</tr>
</table>
</form>

</body>
</html>