<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>SubCategories</title>

</head>
<body>
	<div >
		<table >
			<caption>SubCategories</caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>SubCategoryName</th>
					<th>Category</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${subCategories}" var="subCategory">
					<tr>
						<td>${subCategory.id}</td>
						<td>${subCategory.subCategoryName}</td>
						<td>${subCategory.category.categoryName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>