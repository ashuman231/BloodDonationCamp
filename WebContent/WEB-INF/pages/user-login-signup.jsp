<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<%
if(session.getAttribute("UserEmail") != null){
	response.sendRedirect("user-index.jsp");
	return;
}
%>
 <body>

        <!-- Top content -->
        <div class="top-content">
        	<h1 style="color:blue; font-size:50px;">WELCOME ON OUR WEBPAGES(Blood Donation camp is there.)</h1>
        	<h2 style="color:red; font-size:30px;"><strong> Login and Signup page for doners.</strong></h2>
        	
            <div class="inner-bg">
                <div class="container">
               
               
                    <div class="row">
                     
                        <div class="col-sm-5">
                        <span style="color:red; font-size:30px" > ${message} </span>
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Login to our site</h3>
	                            		<p>Enter email and password to log on:</p>
	                            		<p id="loginerror" style="color: red;"></p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-key"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form"  action="/BloodDonation/userLogin" method="post" class="login-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-username">Email</label>
				                        	<input required type="text"  placeholder="Email..." class="form-username form-control" name="userEmail">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password">Password</label>
				                        	<input required type="password" placeholder="Password..." class="form-password form-control" name="userPassword">
				                        </div>
				                        <input type="submit" class="btn btn-lg btn-secondary" value="Sign in!">
				                    </form>
			                    </div>
		                    </div>
		                
                        </div>	
                        <div class="col-sm-5">
                        	<span style="color:red; font-size:30px" > ${message1} </span>
                        	<div class="form-box">
                        		<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Sign up now</h3>
	                            		<p>Fill in the form below to get instant access:</p>
	                            		<p id="signuperror" style="color:red;"></p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-pencil"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="/BloodDonation/userSignup" method="post" class="registration-form">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-first-name">Name</label>
				                        	<input required type="text" name="userName" placeholder="Name..." class="form-first-name form-control" >
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">Email</label>
				                        	<input required type="email" name="userEmail" placeholder="Email..." class="form-email form-control">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-last-name">Password</label>
				                        	<input required type="password" name="userPassword" placeholder="Password..." class="form-last-name form-control">
				                        </div>
				                        <input id="signupbutton" type="submit" class="btn btn-lg btn-secondary" value="Sign me up!">
				                    </form>
			                    </div>
                        	</div>
                        	
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>
</body>

</html>