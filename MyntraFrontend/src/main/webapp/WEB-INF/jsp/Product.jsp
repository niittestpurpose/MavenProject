<%@page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="InsertProduct" modelAttribute="product">
	<table align="center">
		<tr bgcolor="pink">
			<td align="center" colspan="2">Product Information</td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName"/></td>
		</tr>
		<tr>
			<td>Product Price</td>
			<td><form:input path="price"/></td>
		</tr>
		<tr>
			<td>Product Stock</td>
			<td><form:input path="stock"/></td>
		</tr>
		<tr>
			<td>Category</td>
			<td><form:input path="categoryId"/></td>
		</tr>
		<tr>
			<td>Supplier</td>
			<td><form:input path="supplierId"/></td>
		</tr>
		<tr>
			<td>Product Desc</td>
			<td><form:textarea path="productDesc"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="InsertProduct"/>
			</td>
		</tr>
	</table>
</form:form>
</body>
</html>