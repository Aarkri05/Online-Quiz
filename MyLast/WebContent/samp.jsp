<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<style>



li{
	float: left;
	list-style-type: none;}

li a {
    display: block;
    color: #030a40;;
    padding: 14px 16px;
	text-align: center;
    text-decoration: none;
	border-right: 1px solid #1a2286
}

li a.active:hover {
    background-color: #030a40;
    color: white;
	
}

li a:hover:not(.active) {
    background-color: #030a40;
    color: white;
	
}


</style>


<body background="images/sam.gif">

<script>  
function mypass(lnames){  
window.alert("Name must be your last name");
	
	}
</script>




<br>


	<c:if test='${not empty sessionScope.user}'>

		<a href='${pageContext.request.contextPath}/uploads.html'>
		<div class="button nameuser"><button>Logged as, ${sessionScope.user}</button></div>
		</a>

		><form action="MyChed" method="post"><input type="submit" value="logout" name="Logout"></form></div>
		</a>

		<div id="wrapper">

			<form name="login-form" class="login-form">
				<div class="header" style="height: 60px;">
					
					<h1 style="float: right; color:aqua;">You're already logged in,
						${sessionScope.user} !</h1>
				</div>

			</form>

		</div>

	</c:if>

	<!--  If user is not logged in -->

	<c:if test='${empty sessionScope.user}'>

		<a href='${pageContext.request.contextPath}/forms.html'><div
				class="button nameuser"
				style="width: 500px; position: relative; color:aqua; left: 30%; top: 30px">
				If you don`t have an account, please click here to register</div></a>

		<div id="wrapper">

			<form name="login-form" class="login-form" action="MyCheck"
				method="post">

								
					
					<h3 style="color:aqua;">Note:Please enter your last name</style>
  <h5 style="color:white; text-align:center;">Username:<input type="text" name="lnames" onblur="myPass(this);" value=" " required>
  </h5>
  
  <h5 style="color:white; text-align:center;">Password:<input type="text" name="pwds" value=" " required></h5>
  <br>
  
  <input type="submit" value="Login" style="margin-left: 50%;">
  
					
					
				
				</div>
		

				

			</form>

		</div>
		
			




		
	</c:if>

</body>
</html>
