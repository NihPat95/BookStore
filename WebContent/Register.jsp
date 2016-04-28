	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
   <%@ page import="vo.UserRecords" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>MindPalace</title>
   <link href="css/bootstrap.min.css" rel="stylesheet">
   <script src="js/jquery.min.js"></script>
  	  <link href="css/temp.css" rel="stylesheet">
   <link href="css/regstyle.css" rel="stylesheet">
   <link rel="stylesheet" href="css/font-awesome.min.css">
   <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
   <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
   <!--[if lt IE 9]>
   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
   <![endif]-->
</head>
<body>
     <header>
      <nav class="navbar navbar-inverse">
         <div class="container-fluid">
            <div class="navbar-header">
               <!--Logo-->
               <a class="navbar-brand" href="index.jsp"></a>
               <!--Collapse Button-->
               <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>
               <span class="icon-bar"></span>                        
               </button>
            </div>
            <!--Navigation Bar Start-->  
            <div class="collapse navbar-collapse" id="myNavbar">
               <ul class="nav navbar-nav">
               </ul>
               <ul class="nav navbar-nav navbar-right">
                  <li><a href="index.jsp">Home</a></li>
                  <li class="dropdown">
                     <a class="dropdown-toggle" data-toggle="dropdown" href="#">Books<span class="caret"></span></a>
                     <ul class="dropdown-menu">
                        <li><a href="GetGenre?genrebox=Comedy">Comedy</a></li>
                        <li><a href="GetGenre?genrebox=Fantasy">Fantasy</a></li>
                        <li><a href="GetGenre?genrebox=Fiction">Fiction</a></li>
                        <li><a href="GetGenre?genrebox=Horror">Horror</a></li>
                        <li><a href="GetGenre?genrebox=Romance">Romance</a></li>
                        <li><a href="GetGenre?genrebox=Thriller">Thriller</a></li>
                     </ul>
                  </li>
                  <li><a href="https://github.com/nihpat95">Contact</a></li>
                  <li class="search">
                     <form action="<%=request.getContextPath()%>/Search" method="post">
                        <input type="text" name="search" id="search" placeholder="Search">
                        <input type="submit" value>
                     </form>
                  </li>
                	<% UserRecords user = (UserRecords)session.getAttribute("user");
                  	 if(user==null){
                  		%>
                  	<li><a href="Register.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                  	<li><a href="Register.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                  	<% }else{ %>
                  <li><a href="DisplayCart"><span class="glyphicon glyphicon-shopping-cart">(<%=session.getAttribute("cartno") %>)</span></a></li>
                  		<li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=user.getName()%></a></li>
                  	<li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                  	<% } %>
               </ul>
            </div>
            <!--Navigation bar Ends-->
         </div>
      </nav>
   </header>
   
   <!--Registration Page-->
   <div class="registrationmain">
      <div class="row">
         <div class="col-sm-6">
            <h1>New User? Register Now</h1>
               <form action="<%request.getContextPath();%>NewRegister" method="post">
               <input type="text" name="name" id="name" placeholder="Enter Name Here">
               <br/>
               <input type="text" name="email" id="email" placeholder="Enter Email Here">
               <br/>
               <input type="text" name="number" id="number" placeholder="Enter Number Here">
               <br/>
               <input type="password" name="password" id="password" placeholder="Enter Password Here">
               <br/>
               <input type="password" name="repassword" id="repassword" placeholder="Retype Password">
               <br/>
               <h4>${sessionScope.register}</h4>
               <%session.setAttribute("register",null); %>
               <input type="submit" value="Create Account">
               <input type="reset" value="Reset Form">
            </form>
         </div>
         <div class="col-sm-6">
            <h1>Existing User</h1>
            <form action="<%request.getContextPath();%>Login" method="post">
               <input type="text" name="email" id="email" placeholder="Enter Email Here">
               <br/>
               <input type="password" name="password" id="password" placeholder="Enter Password Here">
               <br/>
               <h4>${sessionScope.login}</h4>
               <%session.setAttribute("login",null);%>
              <%--  <a href="<%request.getContextPath();%>ForgotPassword.jsp">Forgot Password</a>
                --%> 
                <input type="submit" value="Log In">
               
            </form>
         </div>
      </div>
   </div>
   <!--Registration Page Ends-->
 <!--Footer-->
            <footer>
             
                
                
                   <div class="row text-center">
                        <!--Footer Top-->
       <div class="foot-top">
	<div class="container follow">
		<div class="row text-center">
			<li>
				<div class="fooll">
					<h2>Follow Us On</h2>
				</div>
			</li>
			<li>
				<div class="social-ic">
					<ul>
                        <li><a href="construct.html"><i class="facebok"> </i></a></li>
						<li><a href="construct.html"><i class="twiter"> </i></a></li>
						<li><a href="construct.html"><i class="goog"> </i></a></li>
						<li><a href="construct.html"><i class="be"> </i></a></li>
						<li><a href="construct.html"><i class="pp"> </i></a></li>
							<div class="clearfix"></div>	
					</ul>
				</div>
			</li>
				
		
			
	</div>
</div>

                    </div>
                       
                        
					
				</div>
                
            </footer>
   <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
   <!-- Include all compiled plugins (below), or include individual files as needed -->
   <script src="js/bootstrap.min.js"></script>
   <script src="js/parallax.js"></script>
</body>
</html>