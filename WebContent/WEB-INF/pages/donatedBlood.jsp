<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<body>
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
<br><br><%
	      if(session.getAttribute("userEmail") == null){
	    	  %>
			   	<h5 ><strong> You need to login first! </strong> </h5>	 	  
	    	  <%
	      } else {
	    	  %>
	<table>
	  <tr>
	    <th>name</th>
	    <th>email</th>
	    <th>city</th>
	    <th>group</th>
	    <th>address</th>
	    <th>contact</th>
	    <th>Delete</th>
	  </tr>
	  <%
	 ArrayList<ArrayList<String>>al  = (ArrayList<ArrayList<String>>)session.getAttribute("searchEmail") ;
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
	    <td><%= (String)lit1.next() %></td>
	    <td><%= (String)lit1.next() %></td>
	    <td><%= (String)lit1.next() %></td>
	    <td><%= (String)lit1.next() %></td>
	    <td><%= (String)lit1.next() %></td>
	    <td><%= (String)lit1.next() %></td>
	    <td>  <a href="/BloodDonation/deleteBlood?BloodId=<%=BloodId%>"><button>Delete</button> </a> </td>
	  </tr>
     <%
      }
	  }
	      }
	 %>
		  <a href="/BloodDonation/addBlood" ><button>Add Blood</button> </a>
	  <%
	    
	  %>
	  </table>
</body>
</html>
