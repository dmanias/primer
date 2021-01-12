<%@ page import="java.util.ArrayList" %>
<%@ page import="gr.primer.PrimerCRUD.dataLayer.User" %>
<%@ page import="gr.primer.PrimerCRUD.dataLayer.Department" %>

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
<!-- Form for register users-->
<div class="container">
    <form action="ViewLogic" method="post" >
        <h1>User Register Form</h1>
        <div class="form-group">
            <label for="firstName">First Name:</label>
            <input type="text" class="form-control" id="firstName" name="firstName" value="Dimosthenis">
        </div>
        <div class="form-group">
            <label for="lastName">Last Name:</label>
            <input type="text" class="form-control" id="lastName" name="lastName" value="Manias">
        </div>
        <div class="email">
            <label for="firstName">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="dmanias@eap.gr">
        </div>
        <div class="password">
            <label for="firstName">Password:</label>
            <input type="password" class="form-control" id="password" name="password" value="password"/>
        </div>
        <div class="form-group">
            <label for="departmentId">departmentId:</label>
            <input type="text" class="form-control" id="departmentId" name="departmentId" value="9"/>
        </div>
        <input type="hidden" class="form-control" name="action" value="addUser">
        <button type="submit" class="btn btn-default">Add User</button>
</form>

    <!-- Select user form-->
    <form action="ViewLogic" method="post">
        <input type="text" class="form-control" name="email" value="dmanias@eap.gr">
        <input type="hidden" class="form-control" name="action" value="getUser">
        <button type="submit" class="btn btn-default">Get User</button>
    </form>

    <!-- Form for show users list-->
    <form action="ViewLogic" method="post">
        <input type="hidden" class="form-control" name="action" value="getAllUsers">
        <button type="submit" class="btn btn-default">Get All Users</button>
    </form>

    <div>
        <% ArrayList<User> usersList = new ArrayList<>();
            if (request.getAttribute("usersList") != null) {
        %><h2> Users List:</h2><%
                usersList = (ArrayList<User>) request.getAttribute("usersList");
                for (User user : usersList) { %>
        <form action="ViewLogic" method="post">
            <h3><%out.print(user.getFirstName() + " " + user.getLastName());%></h3>
            <input type="hidden" class="form-control" name="email" value="<%out.print(user.getEmail());%>">
            <input type="hidden" class="form-control" name="action" value="deleteUser">
            <button type="submit" class="btn btn-default">Delete user</button>
        </form>
        <%
                }
            }
        %>
    </div>

    <!-- Form for register departments-->
    <form action="ViewLogic" method="post" >
        <h1>Department Register Form</h1>
        <div class="form-group">
            <label for="departmentName">Department Name:</label>
            <input type="text" class="form-control" id="departmentName" name="departmentName" value="The best department">
        </div>
        <div class="form-group">
            <label for="userId">User's Id:</label>
            <input type="text" class="form-control" id="userId" name="userId" value="7">
        </div>

        <input type="hidden" class="form-control" name="action" value="addDepartment">
        <button type="submit" class="btn btn-default">Add Department</button>
    </form>

    <!-- Select department form-->
    <form action="ViewLogic" method="post">
        <input type="text" class="form-control" name="departmentId" value="1">
        <input type="hidden" class="form-control" name="action" value="getDepartment">
        <button type="submit" class="btn btn-default">Get Department</button>
    </form>
    <% if (request.getAttribute("departmentName") != null) {%>
    <form action="ViewLogic" method="post">
        <h2><% out.print(request.getAttribute("departmentName"));%></h2>
        <input type="hidden" class="form-control" name="departmentId" value="<%out.print(request.getAttribute("departmentId"));%>">
        <input type="hidden" class="form-control" name="action" value="deleteDepartment">
        <button type="submit" class="btn btn-default">Delete Department</button>
    </form>
    <%}%>
</div>

<!-- Form for show departments list-->
<form action="ViewLogic" method="post">
    <input type="hidden" class="form-control" name="action" value="getAllDepartments">
    <button type="submit" class="btn btn-default">Get All Departments</button>
</form>

<div>
    <% ArrayList<Department> departmenstList = new ArrayList<>();
        if (request.getAttribute("departmenstList") != null) {
    %><h2> Departments List:</h2><%
            departmenstList = (ArrayList<Department>) request.getAttribute("departmenstList");
            for (Department department : departmenstList) { %>
    <form action="ViewLogic" method="post">
        <h3><%out.print(department.getDepartmentName());%></h3>
        <input type="hidden" class="form-control" name="departmentId" value="<%out.print(department.getDepartmentId());%>">
        <input type="hidden" class="form-control" name="action" value="deleteDepartment">
        <button type="submit" class="btn btn-default">Delete Department</button>
    </form>
    <%
            }
        }
    %>
</div>
</body>

<!--Bootstrap Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</html>

