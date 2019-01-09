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

		<form:form method="post" commandName="subCategory">	
				
				Enter subCategory : 
				<form:input path="subCategoryName" type="text" required="required"></form:input>
				
				Select category :
				<form:select path="categoryId">
					  <form:option value="NONE" label="--- Select ---" />
					  <form:options items="${categories}" itemLabel="categoryName" itemValue="id" />
				</form:select>
						
			
			<form:button type="submit">Add</form:button>
		</form:form>

	
	
</body>
</html>