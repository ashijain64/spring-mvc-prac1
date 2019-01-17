<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Categories</title>

</head>
<body>
	<div>
		<table>
			<caption>Cart</caption>
			<thead>
				<tr>
					<th>Product</th>
					<th>Quantity</th>
					<th>Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cart.cartItems}" var="cartItem">
					<tr>
						<td>${cartItem.product.productName}</td>
						<td>${cartItem.quantity}</td>
						<td>${cartItem.product.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>