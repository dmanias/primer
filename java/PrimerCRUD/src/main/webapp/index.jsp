<%@ page import="java.util.ArrayList" %>
<%@ page import="gr.primer.PrimerCRUD.dataLayer.User" %>


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
    <form action="ViewLogic" method="post" >
        <h1>User Register Form</h1>
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
            <input type="password" class="form-control" id="password" name="password" value="password"/>
        </div>

        <div class="email">
            <label for="firstName">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="dmanias@eap.gr">
        </div>
        <input type="hidden" class="form-control" name="action" value="addUser">
        <button type="submit" class="btn btn-default">Add User</button>
</form>

    <form action="ViewLogic" method="post" >
        <h1>Input Order</h1>
        <div class="form-group">
            <label for="firstName">Order Id:</label>
            <input type="text" class="form-control" id="orderId" name="orderId" value="orderid">
        </div>

        <div class="username">
            <label for="firstName">User Email:</label>
            <input type="text" class="form-control" id="userEmail" name="userEmail" value="useremail">
        </div>

        <input type="hidden" class="form-control" name="action" value="addOrder">
        <button type="submit" class="btn btn-default">Add Order</button>
    </form>

<form action="ViewLogic" method="post">
    <input type="text" class="form-control" name="email" value="dmanias@eap.gr">
    <input type="hidden" class="form-control" name="action" value="getUser">
    <button type="submit" class="btn btn-default">Get User</button>
</form>

    <% if (request.getAttribute("firstName") != null) {%>
<form action="ViewLogic" method="post">
    <h2><% out.print(request.getAttribute("firstName"));%></h2>
    <input type="hidden" class="form-control" name="email" value="<%out.print(request.getAttribute("email"));%>">
    <input type="hidden" class="form-control" name="action" value="deleteUser">
    <button type="submit" class="btn btn-default">Delete user</button>
</form>
<%}%>

<form action="ViewLogic" method="post">
    <input type="hidden" class="form-control" name="action" value="getAllUsers">
    <button type="submit" class="btn btn-default">Get All Users</button>
</form>

<div>
    <% ArrayList<User> usersList = new ArrayList<>();
        if (request.getAttribute("usersList") != null) {
            usersList = (ArrayList<User>) request.getAttribute("usersList");
            for (User user : usersList) { %>
    <form action="ViewLogic" method="post">
        <h2><%out.print(user.getEmail());%></h2>
        <input type="hidden" class="form-control" name="email" value="<%out.print(user.getEmail());%>">
        <input type="hidden" class="form-control" name="action" value="deleteUser">
        <button type="submit" class="btn btn-default">Delete user</button>
    </form>
    <%
            }
        }
    %>
</div>

</div>
</body>

<!--Bootstrap Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</html>

