<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Categories</title>

</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<caption>Categories</caption>
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