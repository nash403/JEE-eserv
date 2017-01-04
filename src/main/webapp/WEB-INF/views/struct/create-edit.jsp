<%@page import="fr.eservices.structure.model.Structure"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Create Structure</title>
    <!-- Bootstrap core CSS -->
    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
   <div class="container">
   
   	<form:form method="POST" modelAttribute="structure" action="create">
   	<div class="form-group row">
   	<h2>Structure</h2>
   		<div class="form-group">   		
   			<form:label path="name">Structure name</form:label>
   			<form:input class="form-control" path="name"/>
   		</div>
   		<div class="form-group">   		
   			<form:label path="street">Street</form:label>
   			<form:input class="form-control" path="street"/>
   		</div>
   		<div class="form-group">   		
   			<form:label path="zipcode">Zip Code</form:label>
   			<form:input class="form-control" path="zipcode"/>
   		</div>
   		<div class="form-group">   		
   			<form:label path="region">Region</form:label>
   			<form:input class="form-control" path="region"/>
   		</div>
   		<div class="form-group">   		
   			<form:label path="country">Country</form:label>
   			<form:input class="form-control" path="country"/>
   		</div>
   		<div class="form-group">   		
   			<form:label path="status">Status</form:label>
   			<c:set var="enumValues" value="<%=Structure.Status.values()%>"/>
   			<form:select path="status" class="form-control" name="enumValue">
	   			<c:forEach items="${enumValues}" var="enumValue">
	   				<form:option value="${enumValue}">${enumValue}</form:option>
	   			</c:forEach>
   			</form:select>
   		</div>
   	<input type="submit" class="btn btn-primary" value="Create"/>
   	</div>
   	</form:form>
   </div>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>