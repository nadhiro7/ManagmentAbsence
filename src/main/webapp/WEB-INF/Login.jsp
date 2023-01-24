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
    <section class="login-box">
        <h1>Log In</h1>
        <form action="LoginServlet" method="post">
            <div>
                <label for="email">Your email or username :</label>
                <input type="text" name="email" id="email" placeholder="Email or Username">
            </div>
            <div>
                <label for="password">Your password :</label>
                <input type="password" id="password" name="password" placeholder="Password">
                <i  id="show" class="fa fa-eye"></i>
            </div>
            <div class="choice">
                choose your role :
                <select name="role" id="role">
                    <option value="admin">Admin</option>
                    <option value="teacher">Teacher</option>
                </select>
            </div>
            <button type="submit" class="form-Button">Login</button>
            <p>Forgot your password? <a href="">Click here</a></p>
        	<p style="color: red; font-size: 18px; margin-top: 10px; " id="incorrect"></p>
        </form>
    </section>
    <script type="text/javascript">
        let show =document.getElementById('show');
        let password = document.getElementById("password");
        show.onclick = ()=>{
            if(show.classList.contains("fa-eye")){
                show.classList.replace("fa-eye" , "fa-eye-slash");
                document.querySelectorAll('input')[1].type = "text";
            }else{
                show.classList.replace("fa-eye-slash" ,"fa-eye" );
                document.querySelectorAll('input')[1].type = "password";
            }
        }
    </script>
</body>
</html>