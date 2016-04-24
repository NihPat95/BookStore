<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="vo.UserRecords" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>MindPalace</title>
      <link href="css/bootstrap.min.css" rel="stylesheet">
      <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700|Lato:400,300,700' rel='stylesheet' type='text/css'>
      <link href="css/productdetail.css" rel="stylesheet">
      <link href="css/temp.css" rel="stylesheet">
      <link rel="stylesheet" href="css/font-awesome.min.css">
      <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
      <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
      <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
      <style>
       .imgback{
        background-image: url("<%=request.getContextPath()%>/img/big/${sessionScope.bookdetail.getISBN()}.png");
        background-size: cover;"
       }
       </style>
      
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
                        <li><a href="#">Comedy</a></li>
                        <li><a href="#">Fantasy</a></li>
                        <li><a href="#">Fiction</a></li>
                        <li><a href="#">Horror</a></li>
                        <li><a href="#">Romantic</a></li>
                        <li><a href="#">Thriller</a></li>
                     </ul>
                  </li>
                  <li><a href="#">Upload Book</a></li>
                  <li><a href="#">Contact</a></li>
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
                  	<li><a href="DisplayCart"><span class="glyphicon glyphicon-shopping-cart"></span></a></li>
                  	<li><a href="#"><span class="glyphicon glyphicon-user"></span> <%=user.getName()%></a></li>
                  	<li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                  	<% } %>
               </ul>
            </div>
            <!--Navigation bar Ends-->
         </div>
      </nav>
   </header>
  <!--Product Details-->
      <div class="productmain">
        <div class="row imgback">
            <div class="col-sm-6 text-center">
                <img src="img/small/${sessionScope.bookdetail.getISBN()}.png" style="width:80%; padding:30px;">
           </div>
            <div class="col-sm-6 side" style="padding-bottom:20px;">
                <h1>${sessionScope.bookdetail.getTitle()}</h1>
                <div class="row">
                <div class="col-sm-8">
                    <h4>${sessionScope.bookdetail.getAuthor()}</h4>
                    <h5>${sessionScope.bookdetail.getPublisher()}</h5>
                    <h6>${sessionScope.bookdetail.getISBN()}</h6>
                    </div>
                <div class="col-sm-4">
                    <h5>${sessionScope.bookdetail.getGenre()}</h5>
                    <h5>${sessionScope.bookdetail.getType()}</h5>
                    <h6>${sessionScope.bookdetail.getPages()} Pages</h6>
                </div>
                </div>
                <h4>Synopsis</h4>
                <p>
                ${sessionScope.bookdetail.getSynopsis()}    
                </p>
               
                <h3>Rs ${sessionScope.bookdetail.getPrice()}</h3>
                    <form action="AddToCart?id=${sessionScope.bookdetail.getISBN()}&flag=index" method="post">
                    <input type="submit" value="Add To Cart">
                    </form>
               </div>
       </div>
       
           </div>
       
       <!--Product Ends -->

       <!--Top Products-->
       
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
                        <li><a href="#"><i class="facebok"> </i></a></li>
						<li><a href="#"><i class="twiter"> </i></a></li>
						<li><a href="#"><i class="goog"> </i></a></li>
						<li><a href="#"><i class="be"> </i></a></li>
						<li><a href="#"><i class="pp"> </i></a></li>
							<div class="clearfix"></div>	
					</ul>
				</div>
			</li>
				
		
			
	</div>
</div>
</div>
<!--Footer Top End-->
       
       <!--Footer-->
            <footer>
                <div class="row">
                    <div class="col-sm-3">
                        <h3>CUSTOMER CARE</h3>               
                        <ul>
                        <li>Help Center</li>
                            <li>FAQ</li>
                            <li>How To Buy</li>
                            <li>Delivery</li>
                        </ul>
                    </div>
                    <div class="col-sm-3">
                        <h3>ABOUT US</h3>               
                        <ul>
                        <li>Team</li>
                        <li>Contact</li>
                        </ul>
                    </div>
                </div>
            </footer>
       <!--Footer End-->
       
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="js/bootstrap.min.js"></script>
      <script src="js/parallax.js"></script>
   </body>
</html>