<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="Interior-Design-Responsive-Website-Templates-Edge">
	<meta name="author" content="webThemez.com">
	<title>Teams</title>
	<link rel="favicon" href="assets/images/favicon.png">
	<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/font-awesome.min.css">
	<!-- Custom styles for our template -->
	<link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen">
	<link rel="stylesheet" type="text/css" href="assets/css/isotope.css" media="screen" />
	<link rel="stylesheet" href="assets/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="assets/css/style2.css">
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="assets/js/html5shiv.js"></script>
	<script src="assets/js/respond.min.js"></script>
	<![endif]-->
        <%@page import="com.geekedin.geek.Geek,com.geekedin.challenge.Challenge,java.util.Vector" %>
</head>

<body>
    
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
					<li><a href="home.jsp">Home</a></li>
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
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><%=((Geek) session.getAttribute("geek")).getName()%> <%=((Geek) session.getAttribute("geek")).getSurname()%> <b class="caret"></b></a>
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

	<header id="head" class="secondary">
		<div class="container">
			<div class="row">
				<div class="col-sm-8">
					<h1>Geeks Teams</h1>
				</div>
			</div>
		</div>
	</header>

	<!-- container -->
	<section class="container">
		<div class="row">
			<div class="col-md-12">
				<section id="portfolio" class="page-section section appear clearfix">
					<br />
					<br />
					<h4>Have an idea of a potential challenge? Please upload your challenge and share it with other participants.</h4>
					<br><br>
					<div class="clearfix"></div>

					<div class="container">
                        <form action="TeamServlet" method="post" class="form-light mt-20" role="form">
								<div class="col-md-6">
                                <div class="form-group">
									<label>Group name</label>
                                    <input type="text" name="name" class="form-control" placeholder="The name of your group">
								</div>
								</div>
								<div class="clearfix"></div>
								<div class="col-md-6">
									<div class="form-group">	
                                        <label>Challenge</label>
                                        <select name="challengeId" class="form-control" >
                                            <%
                                                Vector<Challenge> challenges = (Vector<Challenge>) session.getAttribute("challenges");
                                                Geek geek = (Geek) session.getAttribute("geek");
                                                if(challenges != null)
                                                {
                                                    for(Challenge challenge: challenges)
                                                    {
                                                
                                            %>
                                                        <option value="<%=challenge.getId()%>"><%=challenge.getName()%></option>
                                            <%
                                                    }
                                                }
                                            %>
                                        </select>
                                        <input type="hidden" name="leaderId" value="<%=geek.getId()%>"/>
                                    </div>
								</div>
								<div class="clearfix"></div>
								<div class="col-md-6">
									<div class="form-group">	
										<label>Limit</label>
										<input type="text" name="limit" class="form-control" placeholder="The maximum number of participants allowed">
									</div>
                                </div>
								<div class="clearfix"></div>
								<div class="col-md-6">
									<div class="form-group">	
										<label>Skills needed:</label><br>
										<textarea name="skills" rows="5" cols="76" id="form-entry"></textarea>
									</div>
                                </div>
								<div class="clearfix"></div>
								<input type="submit" name="select" value="Create Team">
						</form>
					
					</div>

				</section>
			</div>
		</div>

	</section>
	<!-- /container -->

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
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.cslider.js"></script>
	<script src="assets/js/jquery.isotope.min.js"></script>
	<script src="assets/js/fancybox/jquery.fancybox.pack.js" type="text/javascript"></script>
	<script src="assets/js/custom.js"></script>
</body>
</html>
