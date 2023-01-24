<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <!-- Style -->
    <style type="text/css">
    	<%@include file="/WEB-INF/styles/headerStyle.css"%>
    </style>
    <link rel="stylesheet" href="styles/headerStyle.css">
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
    <header>
        <div class="container">
            <nav>
                <div class="logo">
                    <img src="images/photo_2021-11-12_21-01-34.jpg"  alt="">
                    <p class="back">Univ-Constantine2</p>
                </div>
                <i class="fa fa-bars" onclick="navbar()" id="menu"></i>
                <ul>
                    <li><a id="2" href="http://localhost:7486/MiniProject/EnsgServlet" class="active">Session</a></li>
                    <li><a id="3" href="http://localhost:7486/MiniProject/EditProfilServlet">EditProfile</a></li>
                </ul>
                <div class="profile">
                    <div>
                        <p id="userName">${teacher.firstname} ${teacher.lastname}</p>
                    </div>
                    <ul>
                        <li><a href="http://localhost:7486/MiniProject/LogoutServlet" id="signOut"><i class="fa fa-sign-out"></i> Sign Out</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </header>
    <script>
         function navbar()
        {
            let menu = document.getElementById( "menu" );
            if ( menu.classList.contains( "fa-bars" ) )
            {
                document.querySelector( ".profile" ).classList.add( "vsb" );
                document.querySelector( "nav > ul" ).classList.add( "vsb" );
                menu.classList.replace( "fa-bars", "fa-times" );
            } else
            {
                document.querySelector( ".profile" ).classList.remove( "vsb" );
                document.querySelector( "nav > ul" ).classList.remove( "vsb" );
                menu.classList.replace( "fa-times", "fa-bars" );
            }
        }
    </script>
</body>
</html>