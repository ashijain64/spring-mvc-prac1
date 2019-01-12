<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>${product.productName}</title>

</head>
<body>
	<div >
		<table class="table">
			<caption>Product</caption>
			<thead>
				<tr>
					<th>Id</th>
					<th>productName</th>
					<th>description</th>
					<th>ImageUrl</th>
					<th>Price</th>
					
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${product.id}</td>
					<td>${product.productName}</td>
					<td>${product.description}</td>
					<td>${product.imageUrl}</td>
					<td>${product.price}</td>
				</tr>
				
			</tbody>
		</table>
	</div>
</body>
</html>