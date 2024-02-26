<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display All Book</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
<style>
	html{
		scroll-behavior: smooth;
	}
	body{
		background: url('bgImage.jpg') center/cover no-repeat;
		background-size: cover;
    	background-size: cover; 
    	background-position: center;
    	background-repeat: no-repeat;
		background-color: #CCE2EE;
		background-size: cover;
		position:center;
		font-family: Arial, Helvetica, sans-serif;
		color: Black;
	}	
	.bg{
		background-image: url('bgImage.jpg');
		background-color:  #CCE2EE;
		font-size: 60;
		font-family: Arial Black;
		color: darkslateblue;
		justify-content: center;
	}
	.container{
		justify-content: center;
		padding-top: 20px;
	}
  a{
	  text-decoration: none;
	  text-decoration-color: black;
	  text-shadow: 0,0,black;
  }
</style>
<script>
    function updateDateTime() {
        var now = new Date();
        var options = { day: 'numeric', month: 'short',year: 'numeric', hour: '2-digit', minute: '2-digit', second: '2-digit', hour12: true };
        var formattedDateTime = now.toLocaleDateString('en-US', options);
        document.getElementById("currentDateTime").innerHTML = formattedDateTime;
    }

    // Update the time every second
    setInterval(updateDateTime, 1000);
 </script>
</head>
<body>
	
	<div class="d-flex bg">
		<div class="p-2 flex-grow-1"><span style='font-size:30px;'>&#128218;</span>Library Management System</div>
		<div class="p-2"><p id="currentDateTime" style="color: darkmagenta; padding-right: 15px;"></p></div>
	</div>
	
	<div class="container">
		<table class="table table-bordered table-hover">
		  <thead>
		    <tr>
		      <th scope="col">Book Id</th>
		      <th scope="col">Book Name</th>
		      <th scope="col">Book Price</th>
		      <th scope="col">Book Info</th>
		      <th scope="col">Released Date</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach items="${variable}" var="i"> 
		    <tr>
		      <th scope="row">${i.bookId}</th>
		      <td>${i.bookName}</td>
		      <td>${i.bookPrice}</td>
		      <td>${i.bookInfo} </td>
		      <td>${i.releasedDate} </td>
		    </tr>
		</c:forEach>
		  </tbody>
		</table>
		<div>
			<button type="button" class="btn btn-secondary btn-lg">
				<a href="/" class="link-light link-offset-2 link-underline-opacity-25 link-underline-opacity-100-hover">
				Show Options
				</a>
			</button>
		</div>
	</div>
</body>
</html>