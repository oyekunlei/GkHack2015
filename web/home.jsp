<%@page import="com.geekedin.geek.Geek"%>
<!--
Author: WebThemez
Author URL: http://webthemez.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Interior-Design-Responsive-Website-Templates-Edge">
	<meta name="author" content="webThemez.com">
	<title>Home</title>
	<link rel="favicon" href="assets/images/favicon.png">
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css"> 
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen"> 
	<link rel="stylesheet" href="assets/css/style2.css">
    <link rel='stylesheet' id='camera-css'  href='assets/css/camera.css' type='text/css' media='all'> 
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Interior-Design-Responsive-Website-Templates-Edge">
	<meta name="author" content="webThemez.com">
	<title>Home</title>
	<link rel="favicon" href="assets/images/favicon.png">
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css"> 
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen"> 
	<link rel="stylesheet" href="assets/css/style2.css">
    <link rel='stylesheet' id='camera-css'  href='assets/css/camera.css' type='text/css' media='all'> /respond.min.js"></script>
	<![endif]-->
</head>
<body>
        <%
            Geek geek = (Geek) session.getAttribute("geek");
        %>
	<!-- Fixed navbar -->
	<div class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
				<a class="navbar-brand" href="home.jsp">
					<img src="assets/images/GEEKEDin.png" alt="Techro HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right mainNav">
					<li class="active"><a href="home.jsp">Home</a></li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Challenges <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="ChallengeServlet?select=ViewChallenges">View Challenges</a></li>
							<li><a href="addChallenge.jsp">Add A Challenge</a></li>
						</ul>
                                        </li>
                                        <li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">Teams <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="TeamServlet?select=ViewTeams">View Teams</a></li>
                                                        <li><a href="createTeam.jsp">Create Team</a></li>
						</ul>
					</li>
                                        <li><a href="GeekServlet?select=ViewGeeks">Geeks</a></li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=geek.getName()%> <%=geek.getSurname()%> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="profile.jsp">My profile</a></li>
							<li><a href="RegisterServlet?select=logout">Logout</a></li>
						</ul>
					</li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- /.navbar -->
	<!-- Header -->
	<header id="head">
		<div class="container">
					<div class="fluid_container">
                    <div class="camera_wrap camera_emboss pattern_1" id="camera_wrap_4">
                        <div data-thumb="assets/images/slides/thumbs/img1.jpg" data-src="assets/images/a3.jpg">
                        </div> 
                        <div data-thumb="assets/images/slides/thumbs/img2.jpg" data-src="assets/images/b3.jpg">
                        </div>
                        <div data-thumb="assets/images/slides/thumbs/img3.jpg" data-src="assets/images/c3.jpg">
                        </div> 
						<div data-thumb="assets/images/slides/thumbs/img2.jpg" data-src="assets/images/d4.jpg">
                        </div>
                        <div data-thumb="assets/images/slides/thumbs/img3.jpg" data-src="assets/images/e3.jpg">
                        </div> 
						<div data-thumb="assets/images/slides/thumbs/img3.jpg" data-src="assets/images/f3.jpg">
                        </div> 
						<div data-thumb="assets/images/slides/thumbs/img3.jpg" data-src="assets/images/g2.jpg">
                        </div> 
                    </div><!-- #camera_wrap_3 -->
                </div><!-- .fluid_container -->
		</div>
	</header>
	<!-- /Header -->

  
      <section class="news-box top-margin">
        <div class="container">
            <h2><span>About the Hack</span></h2>
            <div class="row">
       
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <div class="newsBox">
                        <div class="thumbnail">
                            <figure><img src="assets/images/ict_1.jpg" alt=""></figure>
                            <div class="caption maxheight2">
                            <div class="box_inner">
                                        <div class="box">
                                            <p class="title"><strong>CONCEPT</strong></p>
                                            <p>Hackathons are coding or electronic competitions that may run up to 72 hours and that gather tech-lovers around challenges, for fun or for social good.</p>
                                        </div>
                                        
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <div class="newsBox">
                        <div class="thumbnail">
                            <figure><img src="assets/images/hack.jpg" alt=""></figure>
                            <div class="caption maxheight2">
                            <div class="box_inner">
                                        <div class="box">
                                            <p class="title"><strong>FOCUS</strong></p>
                                            <p>Apps for campus life; Apps/applications to help lecturer-student; Informational apps; ICT marketing and interest stimulation; Targeting skills development and employment; Innovation of the future; For Socio-Economical value</p>
                                        </div>
                                        
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12">
                    <div class="newsBox">
                        <div class="thumbnail">
                            <figure><img src="assets/images/sponsors2.png" alt=""></figure>
                            <div class="caption maxheight2">
                           <div class="box_inner">
                                        <div class="box">
                                            <p class="title"><strong>SPONSORS</strong></p>
                                            <p>Here are some of Geekulcha's proud sponsors and partners. </p>
                                        </div>
              
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
   
  
	
      <section class="container">
      <div class="row">
      	<div class="col-md-4"><div class="title-box clearfix "><h2 class="title-box_primary">About Us</h2></div> 
        <p><span>Geekulcha is where the young, skilled, creative and ambitious tech minds meet to connect with each other, share knowledge, collaborate on projects, network with industry leaders, obtain training to further improve and enhance their skills and to put that newly acquired skill to work.</span></p>
        <p>Our focus is on empowering the young geeks through ICT skills development and training while giving them a taste of what awaits them in the big world through industry exposure.</p>
        <a href="http://www.geekulcha.com/about" title="Read more" class="btn-inline " target="_blank">Read more</a> </div>
        
      
         <div class="col-md-4"><div class="title-box clearfix "><h2 class="title-box_primary">Take Part</h2></div> 
            <blockquote class="blockquote-1">
					<p>All Hackers, join us for this amazing event.</p>
					<p> Bring your laptops, your electronic equipment, some toileteries, and come have fun!
				</blockquote></div>
          
          <div class="col-md-4"><div class="title-box clearfix "><h2 class="title-box_primary">Hacking Categories</h2></div> 
            <div class="list styled custom-list">
            <ul>
            <li><a title="Mobile Applications Development" href="#">Mobile Applications </a></li>
            <li><a title="Web Applications Development" href="#">Web Applications</a></li>
            <li><a title="Graphics Design" href="#">Graphics Design</a></li>
            <li><a title="Electronics" href="#">Electronics</a></li>
            <li><a title="Innovation/Entrepreneurship" href="#">Innovation/Entrepreneurship</a></li>
            </ul>
            </div>
         </div>
      </div>
      </section>
      
    	 
    <footer id="footer">
		<div class="container">

			<div class="clear"></div>
			<!--CLEAR FLOATS-->
		</div>
		<div class="footer2">
			<div class="container">
				<div class="row">

					<div class="col-md-6 panel">
						<div class="panel-body">
							<p class="text-right">
								 Copyright &copy; 2015 GeekedIn
							</p>
						</div>
					</div>

				</div>
				<!-- /row of panels -->
			</div>
		</div>
	</footer>

	<!-- JavaScript libs are placed at the end of the document so the pages load faster -->
	<script src="assets/js/modernizr-latest.js"></script> 
	<script type='text/javascript' src='assets/js/jquery.min.js'></script>
    <script type='text/javascript' src='assets/js/fancybox/jquery.fancybox.pack.js'></script>
    
    <script type='text/javascript' src='assets/js/jquery.mobile.customized.min.js'></script>
    <script type='text/javascript' src='assets/js/jquery.easing.1.3.js'></script> 
    <script type='text/javascript' src='assets/js/camera.min.js'></script> 
    <script src="assets/js/bootstrap.min.js"></script> 
	<script src="assets/js/custom.js"></script>
    <script>
		jQuery(function(){
			
			jQuery('#camera_wrap_4').camera({
				height: '600',
				loader: 'bar',
				pagination: false,
				thumbnails: false,
				hover: false,
				opacityOnGrid: false,
				imagePath: 'assets/images/'
			});

		});
	</script>
    
</body>
</html>
