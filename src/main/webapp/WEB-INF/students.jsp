<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Student management</title>
    <!-- Style -->
    <style type="text/css">
    	<%@include file="/WEB-INF/styles/style.css"%>
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
	<%@include file="/WEB-INF/header.jsp"%>
    <section class="liste container">
        <h2>List of Students</h2>
        <div class="tab">
            <div class="row header">
                <div class="column">
                    Firstname
                </div>
                <div class="column">
                    Lastname
                </div>
                <div class="column">
                    Student ID
                </div>
                <div class="column">
                    Groupe
                </div>
                <div class="column">
                    Email
                </div>
                <div class="column">
                    Address
                </div>
            </div>
            <c:if test="${studentsList.size() > 0}">  
   				<c:forEach var="i" begin="0" end="${studentsList.size()-1}" step="1">  
    				<div class="row" id="${studentsList[i].studentId}">
      					<div class="column" data-title="firstname"><c:out value="${studentsList[i].firstname}" /></div>
      					<div class="column" data-title="lastname"><c:out value="${studentsList[i].lastname}" /></div>
      					<div class="column" data-title="Id"><c:out value="${studentsList[i].studentId}" /></div>
      					<div class="column" data-title="groupe"><c:out value="${studentsList[i].groupe}" /></div>
      					<div class="column" data-title="Email"><c:out value="${studentsList[i].email}" /></div>
      					<div class="column" data-title="address"><c:out value="${studentsList[i].address}" /></div>
      					<a href="http://localhost:7486/MiniProject/RemoveServlet?SID=${studentsList[i].studentId}" value="${studentsList[i].studentId}" title="Remove teacher"><i class="fa fa-trash"></i></a>
    				</div>
				</c:forEach>
			</c:if>  
           
        </div>
    </section>
    <section id="add" class="add container">
        <h2>Add students</h2>
        <div></div>
        <form action="AddStudentServlet" method="post" id="addForm">
            <div>
                <input type="text" name="fname" id="fname" class="input-Field" required>
                <label for="fname">First Name</label>
            </div>
            <div>
                <input type="text" name="lname" id="lname" class="input-Field" required>
                <label for="lname">Last Name</label>
            </div>
            <div>
                <input type="number" name="ID" id="ID" class="input-Field" required>
                <label for="ID">Student ID</label>
            </div>
            <div>
                <input type="number" min="1" max="4" name="groupe" id="groupe" class="input-Field" required>
                <label for="password">Groupe</label>
            </div>
            <div>
                <input type="email" name="email" id="email" class="input-Field" required>
                <label for="phone">Email</label>
            </div>
            <div>
                <input type="text" name="address" id="address" class="input-Field">
                <label for="address">Address</label>
            </div>
            <span style="margin-top: 20px; display: none;"></span>
            <button type="submit" class="form-Button"><i class="fa fa-plus-circle"> Add</i></button>
        </form>
    </section>
    <section id="edit" class="add container">
        <h2>Edit Students</h2>
        <div></div>
        <div>
            Entre the ID that you want to Edit
            <div id="getUserEdit">
                <input type="number" id="un" placeholder="ID" class="input-Field">
                <button type="submit" id="getInfo" class="form-Button">Get</button>
            </div>
        </div>
        <form action="EditStudentServlet" method="post" style="display: none;" id="editForm">
            <div>
                <input type="text" name="Efirstname" id="Efirstname" class="input-Field" required>
                <label for="Efirstname">First Name</label>
            </div>
            <div>
                <input type="text" name="Elastname" id="Elastname" class="input-Field" required>
                <label for="Elastname">Last Name</label>
            </div>
            <div>
                <input type="number" name="UID" id="UID" class="input-Field" required>
                <label for="UID">Student ID</label>
            </div>
            <div>
                <input type="number" name="Egroupe" id="Egroupe" class="input-Field" required>
                <label for="Egroupe">Groupe</label>
            </div>
            <div>
                <input type="email" name="E-mail" id="E-mail" class="input-Field" required>
                <label for="E-mail">Email</label>
            </div>
            <div>
                <input type="text" name="Eaddress" id="Eaddress" class="input-Field">
                <label for="Eaddress">Address</label>
            </div>
            <div style="display: none;">
                <input type="text" name="key" id="key" class="input-Field" required>
            </div>
            <span style="margin-top: 20px; display: none;"></span>
            <button type="submit" class="form-Button"><i class="fa fa-pencil-square"> Edit</i></button>
        </form>
    </section>
    <script>
        let inputs1 = document.querySelectorAll(".add form div input");
        let labels1 = document.querySelectorAll(".add form div label");
        let inputs2 = document.querySelectorAll(".deletEdit > form div input");
        let labels2 = document.querySelectorAll(".deletEdit > form div label");
        for(let i =0 ; i < inputs1.length ; i++){
            inputs1[i].addEventListener("focus",()=>{
                labels1[i].classList.add("labelFocus");
            })
        }
        for(let i =0 ; i < inputs1.length ; i++){
            inputs1[i].addEventListener("blur",()=>{
                if(inputs1[i].value == "") labels1[i].classList.remove("labelFocus");
            })
        }
        for(let i =0 ; i < inputs2.length ; i++){
            inputs2[i].addEventListener("focus",()=>{
                labels2[i].classList.add("labelFocus");
            })
        }
        for(let i =0 ; i < inputs2.length ; i++){
            inputs2[i].addEventListener("blur",()=>{
                if(inputs2[i].value == "") labels2[i].classList.remove("labelFocus");
            })
        }
        let getInfo = document.getElementById("getInfo");
        getInfo.onclick = ()=>{
            let user = document.getElementById("un").value;
            let getinf = document.getElementById(user);
            if(getinf != null || getinf != undefined){
                let editForm = document.getElementById("editForm");
                editForm.style.display = "flex";
                let inputs = document.querySelectorAll("#editForm input");
                inputs[0].value = getinf.children[0].textContent;
                inputs[1].value = getinf.children[1].textContent;
                inputs[2].value = getinf.children[2].textContent;
                inputs[3].value = getinf.children[3].textContent;
                inputs[4].value = getinf.children[4].textContent;
                inputs[5].value = getinf.children[5].textContent;
                inputs[6].value = getinf.children[2].textContent;
                for(let i =0 ; i < inputs.length -1 ; i++){
                    inputs[i].focus();
                    inputs[i].blur();
                }
            }
        }
    </script>
</body>
</html>