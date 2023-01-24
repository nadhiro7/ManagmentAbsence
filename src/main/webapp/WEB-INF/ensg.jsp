<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Teacher session managment</title>
    <!-- Style -->
    <style type="text/css">
    	<%@include file="/WEB-INF/styles/ensgStyle.css"%>
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
        <section id="add" class="add">
        <div class="container">
            <h2>Presence management</h2>
        <div class="sessions">
            <h1>Sessions</h1>
            <c:if test="${sessionsList.size() > 0}">  
   				<c:forEach var="i" begin="0" end="${sessionsList.size()-1}" step="1">  
    				<div class="sessionCard">
                		<div>
                    		<c:out value="${i + 1}" />
                		</div>
                		<div class="column">
                    		<div>
                        		<c:out value="${sessionsList[i].nameModule}" />
                    		</div>
                    		<div>
                        		<c:out value="${sessionsList[i].date}" />
                    		</div>
                    		<div>
                        		<c:out value="${sessionsList[i].groupe}" />
                    		</div>
                		</div>
                		<a id="hs" href="http://localhost:7486/MiniProject/SessionListServlet?sessionId=${sessionsList[i].sessionId}"></a>
            		</div>
				</c:forEach> 
			</c:if>
        </div>
        <button class="form-Button" id="addSession"><i class="fa fa-plus-circle"> Add session</i></button>
        </div>
    </section>
    <div class="addSession container">
        <i class="fa fa-times" id="close"></i>
        <h2>Add Session</h2>
        <form action="AddSessionServlet" id="form" method="post">
            <div>
                <label for="nameM">Module Name</label>
                <input type="text" id="nameM" name="nameM" required maxlength="45">
            </div>
            <div>
                <label for="date">Session Date</label>
                <input type="date" id="date" name="date" required>
            </div>
            <div>
                <label for="Gr">Group Number</label>
                <input type="number" id="Gr" name="Gr" required>
            </div>
            <span id="up" style="align-self: center; color: red; font-size: 15px;"></span>
            <button type="submit" id="adsession">Add</button>
        </form>
    </div>
    <script>
        let addButton = document.getElementById( "addSession" );
        addButton.onclick = () =>
        {
            document.querySelector( "section" ).style.filter = "brightness(0.35)";
            document.querySelector( ".addSession" ).style.display = "flex";
        }
        let close = document.getElementById( "close" );
        close.onclick = () =>
        {
            document.querySelector( "section" ).style.filter = "brightness(1)";
            document.querySelector( ".addSession" ).style.display = "none";
        }
    </script>
</body>
</html>