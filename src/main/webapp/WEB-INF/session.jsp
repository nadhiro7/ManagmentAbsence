<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Session List</title>
    <!-- Style -->
    <style type="text/css">
    	<%@include file="/WEB-INF/styles/sessionStyle.css"%>
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
    <section class="liste">
        <h2>List of Session</h2>
        <div class="tab">
            <div class="row header">
                <div class="column">
                    
                </div>
                <div class="column">
                    Firstname
                </div>
                <div class="column">
                    Lastname
                </div>
                <div class="column">
                    Adress
                </div>
                <div class="column">
                    Group
                </div>
                <div class="column">
                   State
                </div>
                <div class="column">
                   choose State
                </div>
            </div>
              <c:if test="${StudentsofSessionList.size() > 0}">  
   				<c:forEach var="i" begin="0" end="${StudentsofSessionList.size()-1}" step="1">  
    				 <div class="row">
                		<div class="column">
                    		<c:out value="${i + 1}" />
                		</div>
                		<div class="column">
                    		<c:out value="${StudentsofSessionList[i].lastname}" />
                		</div>
                		<div class="column">
                    		<c:out value="${StudentsofSessionList[i].firstname}" />
                		</div>
                		<div class="column">
                    		<c:out value="${StudentsofSessionList[i].studentId}" />
                		</div>
                		<div class="column">
                    		<c:out value="${StudentsofSessionList[i].groupe}" />
                		</div>
                		<div class="column">
                    		<c:out value="${StudentsofSessionList[i].state}" />
                		</div>
                		<form action="ChangeStateServlet?studentId=${StudentsofSessionList[i].studentId}&sessionId=${Skey}" id="form" method="post">
                		<div class="column choice">
                    		<select name="role" class="role" id="role" >
                        		<option value="non">  -  </option>
                        		<option value="present">present</option>
                        		<option value="absent">absent</option>
                    		</select>
                		</div>
                		<button type="submit" title="Save state of student"><i class="fa fa-save"></i></button>
                		</form>
              		</div>
				</c:forEach> 
			</c:if>
        </div>
    </section>
</body>
</html>