<%@page import="java.util.ListIterator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Blood</title>
</head>
<body style="background-color: #ffffff;">
<nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color:#32127A;">
  <a class="navbar-brand" href="/BloodDonation/userIndex"><img alt="Logo" src="images/amazonlogowhite.png" style="" height="40px" width="180px"></a>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
  	<form action="/BloodDonation/search" class="form-inline mr-auto">
  		<input required  name="searchCity" list="datalist" type="text" class="form-control mr-sm-2"  style="width:500px" placeholder="Type your city name">
  		<input type="submit" class="btn" value="Search">
  	</form>
    <ul class="navbar-nav">
      <li class="nav-item active">
      	<%
      	if(session.getAttribute("userEmail") == null){
      		%>
      	<a href="/BloodDonation/user-login-signup"><button id="navbarloginsignup" class="btn btn-md" >Login/Sign up</button> </a>
      		<%
      	} else{
      		%>
      		  <a href="/BloodDonation/userLogout"><button id="navbarloginsignup" class="btn btn-md" >Logout</button> </a>  
      		<%
      	}
      	%>
    
      </li>
      &nbsp&nbsp&nbsp&nbsp
      <li class="nav-item active">
       <a href="/BloodDonation/userCart"> <button class="btn btn-md" data-toggle="modal" ><i class="fa fa-shopping-cart"></i> 
        &nbsp<span style="font-size:15px;font-weight:bold;color:maroon;">Add Blood</span></button> </a>
      </li>
      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
    </ul>
  </div>
</nav>

<div class="container" style="background-color:#ffffff">
<br>
	<p style="font-size:26px; color:#2f4f4f;font-family: 'Alegreya', serif;">Premium collection in city</p>
	<div class="row">
	<table>
	  <tr>
	    <th>name</th>
	    <th>email</th>
	    <th>city</th>
	    <th>group</th>
	    <th>address</th>
	    <th>contact</th>
	    
	  </tr>
	  <%
	 ArrayList<ArrayList<String>>al  = (ArrayList<ArrayList<String>>)session.getAttribute("searchCity") ;
	  ListIterator<ArrayList<String>> lit = al.listIterator();
	  while(lit.hasNext()) 
	  {
	   ArrayList<String>ans = (ArrayList<String>)lit.next();
	  ListIterator<String> lit1 = ans.listIterator();
	  while(lit1.hasNext())
	  {
		  String BloodId = lit1.next();
	  %>
	  <tr>
	    <th><%= (String)lit1.next() %></th>
	    <th><%= (String)lit1.next() %></th>
	    <th><%= (String)lit1.next() %></th>
	    <th><%= (String)lit1.next() %></th>
	    <th><%= (String)lit1.next() %></th>
	    <th><%= (String)lit1.next() %></th>
	  </tr>
	  <%
	  }
	  }
	  %>
	  </table>
	  
	</div>
<br>
</div>
 <br><br><br>
</body>
</html>
