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
   	<form class="form-signin" role="form" method="post" action="structure/create">
   		<h2 class="form-signin-heading">Create Structure</h2>
   		<label for="inputStructureName" class="form-control">Structure Name</label>
   		<input type="text" id="inputStructureName" name="email" class="form-control" placeholder="Structure Name" required autofocus/>
   		<label for="inputStatus" class="form-control">Status</label>
   		<select name="status" id="inputStatus" class="form-control">
   			<option value="ENTREPRISE">Enterprise</option>
   			<option value="ASSOCIATION">Association</option>
   		</select>
   		<div class="form-group">
   			<h3>Address</h3>   		
   			<label for="inputStreet" class="form-control">Street</label>
   			<input type="text" id="inputStreet" name="street" class="form-control"/>
   			<label for="inputZipCode" class="form-control">Zip Code</label>
   			<input type="text" id="inputZipCode" name="zipcode" class="form-control"/>
   			<label for="inputRegion" class="form-control">Region</label>
   			<input type="text" id="inputRegion" name="region" class="form-control"/>
   			<label for="inputCity" class="form-control">City</label>
   			<input type="text" id="inputCity" name="city" class="form-control"/>
   			<label for="inputCountry" class="form-control">Country</label>
   			<input type="text" id="inputStreet" name="country" class="form-control"/>	
   		</div>	
   	</form>
   </div>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="http://getbootstrap.com/assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>