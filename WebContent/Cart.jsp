<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="vo.CartRecord" %>
<%@ page import="vo.UserRecords" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
 <head>
 	 
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
       <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>MindPalace</title>
      <link href="css/bootstrap.min.css" rel="stylesheet">
      <script src="js/jquery.min.js"></script>
  	  <link href="css/cartstyle.css" rel="stylesheet">
      <link href="css/temp.css" rel="stylesheet">
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
   <!--Cart Page-->
       <%CartRecord cart[] = (CartRecord[])session.getAttribute("cartlist"); 
       	 int price = 0;
       	 for(CartRecord d:cart){
       		 price += d.getBooks().getPrice();
       	 }
       %>
       <div class="main">
        <div class="row">
            <div class="col-sm-3 order">
                <h3><center>Order Summary</center></h3>
                <hr/>
                <h4>Number Of Items <span class="fig"><%=cart.length%></span></h4>
                <h4>Total <span class="fig">Rs.<%=price%></span></h4>
            </div>
            <div class="col-sm-9">
                <!--Enter Data Here-->
            	<c:forEach items="${sessionScope.cartlist}" var="x">
               <div class="row items">
                    <div class="col-sm-4">
                    <a href="<%=request.getContextPath()%>/ProductDetail?Id=${x.getBooks().getISBN()}">
                    <img src="img/small/${x.getBooks().getISBN()}.png" style="width:80%;">
                   	</a>
                   </div>
                   <div class="col-sm-8 rgt">
                       <a href="<%=request.getContextPath()%>/DeleteCartItem?Id=${x.getID()}"><span class="close">Remove</span></a>
                        <a href="<%=request.getContextPath()%>/ProductDetail?Id=${x.getBooks().getISBN()}">
                        <h2>${x.getBooks().getTitle()}</h2>
                       </a>
                       <h4>${x.getBooks().getAuthor()}</h4>
                       <h3>${x.getBooks().getPrice()}</h3>
                       <p>Delivered In 2-3 Working Days</p>
                   </div>
                </div>
                </c:forEach>
                <!--End-->
            </div>
        </div>
       </div>
       
       <!--Cart Page Ends-->

       
      
       <!--Top Products-->
       
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