<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SubCategory</title>

</head>
<body>

		<div >
		<table>
			<caption>Product</caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>CategoryName</th>
					<th>Sequence</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td>${category.id}</td>
						<td>${category.categoryName}</td>
						<td>${category.sequence}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	
	
</body>
</html>