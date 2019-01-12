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

		<form:form method="post" commandName="product">	
				
				Enter Product : 
				<form:input path="productName" type="text" required="required"></form:input>
				Enter Description : 
				<form:input path="description" type="text" required="required"></form:input>
				Enter ImageUrl : 
				<form:input path="imageUrl" type="text" required="required"></form:input>
				
				Select SubCategory :
				<form:select path="subCategoryId">
					  <form:option value="NONE" label="--- Select ---" />
					  <form:options items="${subCategories}" itemLabel="subCategoryName" itemValue="id" />
				</form:select>
						
			
			<form:button type="submit">Add</form:button>
		</form:form>

	
	
</body>
</html>