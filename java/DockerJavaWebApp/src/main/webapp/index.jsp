<%--
  Created by IntelliJ IDEA.
  User: Dimosthenis
  Date: 8/1/2021
  Time: 3:32 μ.μ.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>I do CRUD!!</title>
    <!-- Bootstrap Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous"/>
</head>

<body>
<div class="container">
    <h1>User Register Form</h1>

    <form action="LogicAndValidation" method="post">
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" value="firstname">
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" value="lastName">
        </div>
        <div class="username">
            <label for="firstName">Username:</label>
            <input type="text" class="form-control" id="username" name="username" value="username">
        </div>
        <div class="password">
            <label for="firstName">Password:</label>
            <input type="password" class="form-control" id="password" name="password" value="password"/></>
        </div>
        <div class="email">
            <label for="firstName">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="dmanias@eap.gr">
        </div>
        <input type="hidden" class="form-control" name="action" value="addUser">
        <button type="submit" class="btn btn-default">Add User</button>
    </form>

    <form action="LogicAndValidation" method="post">
        <input type="hidden" class="form-control" name="email"  value="dmanias@eap.gr" >
        <input type="hidden" class="form-control" name="action" value="getUser">
        <button type="submit" class="btn btn-default">Get User</button>
    </form>

</div>
</body>

<!--Bootstrap Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</html>

