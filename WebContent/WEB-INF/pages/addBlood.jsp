<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%
if(session.getAttribute("userEmail") == null){
	response.sendRedirect("user-login-signup.jsp");
	return;
}
%>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=session.getAttribute("userName") %>'s Shop</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body style="background-color: #F1F3FA;">
<br>

      <div class="modal-header">
        <h5 class="modal-title" id="addaproductmodal">Tell us about the Blood</h5>
      </div>
      <div class="modal-body">
        <form action="/BloodDonation/addBloodInfo" style="max-height:400px" method="get"  >
            <input required class="form-control" name="name" placeholder="enter your Name"><br>
        	<input required class="form-control" name="group" placeholder="blood group"><br>
        	<input required  class="form-control" name="address" placeholder="address"><br>
        	<input required  class="form-control" name="contact" placeholder="contact number"><br>
        	<input required  class="form-control" name="city" placeholder="city where you live"><br>
        	<input type="hidden" name="email" value=<%= session.getAttribute("userEmail") %> ><br>
            <div class="modal-footer">
       		<button  type="submit" > Add Blood</button>
       	     </form>
            </div>
</body>
</html>
