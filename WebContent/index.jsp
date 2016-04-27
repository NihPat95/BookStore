<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="vo.UserRecords" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <title>MindPalace</title>
   <link href="css/bootstrap.min.css" rel="stylesheet">
   <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700|Lato:400,300,700' rel='stylesheet' type='text/css'>
   <link href="css/style.css" rel="stylesheet">
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
                  	<li><a href="#"><span class="glyphicon glyphicon-user"></span><%=user.getName()%></a></li>
                  	<li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
                  	<% } %>
               </ul>
            </div>
            <!--Navigation bar Ends-->
         </div>
      </nav>
   </header>
   <!--Sliding-->
   <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
         <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
         <li data-target="#myCarousel" data-slide-to="1"></li>
         <li data-target="#myCarousel" data-slide-to="2"></li>
         <li data-target="#myCarousel" data-slide-to="3"></li>
      </ol>
      <!-- Wrapper for slides -->
      <div class="carousel-inner" role="listbox">
         <div class="item active">
      <img src="img/1.png" alt="GOT">
    </div>

    <div class="item">
      <img src="img/2.png" alt="GOT">
    </div>

    <div class="item">
      <img src="img/3.png" alt="GOT">
    </div>

    <div class="item">
      <img src="img/4.png" alt="GOT">
    </div>
      </div>
      <!-- Left and right controls -->
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
      </a>
   </div>
   <!--Sliding Ends-->
   <!--Latest Products-->
   <div class="main">
      <div class="row">
         <div class="im col-xs-4 text-center">
            <hr/>
         </div>
         <div class="ti col-xs-4 text-center">
            <h3>Latest Books</h3>
         </div>
         <div class="im col-xs-4 text-center">
            <hr/>
         </div>
      </div>
      <div class="productlist row text-center">
        <c:forEach items="${sessionScope.booklist}" var="x">
         <div class="itemp col-sm-3">
            <div class="productimg row">
            <a href="<%=request.getContextPath()%>/ProductDetail?Id=${x.getISBN()}">
               <img src="img/small/${x.getISBN()}.png">
            </a>
            </div>
            <div class="row">
               <h4>
               <a href="<%=request.getContextPath()%>/ProductDetail?Id=${x.getISBN()}">${x.getTitle()}</a>
            	</h4>
               <h6>${x.getPrice()}</h6>
               <span class="btn btn-default">
              <a href="AddToCart?id=${x.getISBN()}&flag=index">Add To Cart</a>
               </span>
            </div>
         </div>
         </c:forEach>
         
         <div class="itemp col-sm-3 seeall">
            <h4>
            <a href="<%=request.getContextPath()%>/ProductList">
               See All<br/>Products
            </a>
            </h4>
           </div>
      </div>
   </div>
   <!--Latest Products Ends-->
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
            <h3><a href="construct.html">CUSTOMER CARE</a></h3>
            <ul>
               <li><a href="construct.html">Help Center</a></li>
               <li><a href="construct.html">FAQ</a></li>
               <li><a href="construct.html">How To Buy</a></li>
               <li><a href="construct.html">Delivery</a></li>
            </ul>
         </div>
         <div class="col-sm-3">
            <h3><a href="construct.html">ABOUT US</a></h3>
            <ul>
               <li><a href="construct.html">Team</a></li>
               <li><a href="construct.html">Contact</a></li>
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