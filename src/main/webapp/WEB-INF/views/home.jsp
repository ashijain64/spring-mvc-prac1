<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Categories</title>

</head>
<body>
	<div>
		<table>
			<caption>Category SubCategory</caption>
			<thead>
				<tr>
					<th>Category</th>
					<th>SubCategory</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td>${category.categoryName}</td>
						<td><c:forEach items="${category.subCategories}"
								var="subCategory">
							${subCategory.subCategoryName} <br>						
						</c:forEach></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<table>
			<caption>Product</caption>
			<thead>
				<tr>
					<th>Product</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><a href = "/product/${product.id}" >${product.productName}</a></td>
						<td>${product.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>