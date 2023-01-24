<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log In</title>
    <!--- Style -->
    <style type="text/css">
    	<%@include file="/WEB-INF/styles/loginStyle.css"%>
    	<%@include file="/WEB-INF/styles/editStyle.css"%>
    </style>
    <!-- font style -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Urbanist:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap"
        rel="stylesheet">
    <!-- icons link -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
	<%@include file="/WEB-INF/headerE.jsp"%>
    <section class="login-box">
        <h1>Edit Profil</h1>
        <form action="EditProfilServlet" method="post" id="addForm">
            <div>
            	<label for="fname">First Name</label>
                <input value="${teacher1.firstname}" type="text" name="fname" id="fname" class="input-Field" required>
            </div>
            <div>
            	<label for="lname">Last Name</label>
                <input value="${teacher1.lastname}" type="text" name="lname" id="lname" class="input-Field" required>
            </div>
            <div>
                <label for="username">Username</label>
                <input value="${teacher1.username}" type="text" name="username" id="username" class="input-Field" required>
            </div>
            <div>
            	<label for="password">Password</label>
                <input value="${teacher1.password}" type="text" name="password" id="password" class="input-Field" required>
            </div>
            <div>
            	<label for="phone">Phone</label>
                <input value="${teacher1.phone}" type="number" maxlength="10" name="phone" id="phone" class="input-Field" required>
            </div>
            <div>
            	<label for="address">Address</label>
                <input value="${teacher1.address}" type="text" name="address" id="address" class="input-Field">
            </div>
            <span style="margin-top: 20px; display: none;"></span>
            <button type="submit" class="form-Button">Edit</button>
        </form>
    </section>
</body>
</html>