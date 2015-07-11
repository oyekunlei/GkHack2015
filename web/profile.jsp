<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Interior-Design-Responsive-Website-Templates-Edge">
        <meta name="author" content="webThemez.com">
        <title>Profile</title>
        <link rel="favicon" href="assets/images/favicon.png">
        <link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <!-- Custom styles for our template -->
        <link rel="stylesheet" href="assets/css/bootstrap-theme.css" media="screen">
        <link rel="stylesheet" type="text/css" href="assets/css/isotope.css" media="screen" />
        <link rel="stylesheet" href="assets/js/fancybox/jquery.fancybox.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="assets/css/style2.css">
        <link rel='stylesheet' id='camera-css'  href='assets/css/camera.css' type='text/css' media='all'> 
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->
        <%@page import="com.geekedin.geek.Geek,com.geekedin.skill.Skill,java.util.Vector" %>
    </head>

    <body>
        <%
            Geek geek = (Geek) session.getAttribute("geek");
            Vector<Skill> geekskills = (Vector<Skill>) session.getAttribute("geekskills");
        %>
        <!-- Fixed navbar -->
        <div class="navbar navbar-inverse">
            <div class="container">
                <div class="navbar-header">
                    <!-- Button for smallest screens -->
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="index.html">
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

        <header id="head" class="secondary">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8">
                        <h1>My profile</h1>
                    </div>
                </div>
            </div>
        </header>

        <!-- container -->
        <section class="container">
            <div class="info">
                <%
                    if (geek != null) {
                        if (geekskills != null) {
                %>
                <form action="FileUploadServlet" method="post" entype="multipart/form-data">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="thumbnail">
                                <div class="picture">
                                    <img src="files/dpp.png" />
                                    <div class="form-group">
                                        <input type="file" class="form-control" name="image">
                                        <input type="hidden" name="geekid" value="<%=geek.getId()%>" /><br/>
                                        <input type="submit" name="UploadPhoto" value="Upload Picture" />
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
                <form action="GeekServlet" class="form-light mt-20" role="form">
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" name="name" value="<%=geek.getName()%>">
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Surname</label>
                                <input type="text" class="form-control" name="surname" value = "<%=geek.getSurname()%>">
                            </div>
                        </div>
                    </div>	
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Gender</label>
                                <select name="gender" class="form-control">
                                    <option>Male</option>
                                    <option>Female</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Phone number</label>
                                <input type="text" class="form-control" name="phone" value="<%=geek.getPhoneNumber()%>">
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Email</label>
                                <input type="text" class="form-control" name="email" value="<%=geek.getEmail()%>">
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>City</label>
                                <input type="text" class="form-control" name="city" value="<%=geek.getCity()%>">
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Country</label>
                                <input type="text" class="form-control" name="country" value="<%=geek.getCountry()%>">
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="col-md-6">
                                <div class="form-group">

                                    <h3>Current Skills:</h3>
                                    <div class="clearfix"></div>

                                    <%
                                        for (Skill skill : geekskills) {
                                    %>
                                    <p><%=skill.getName()%></p>
                                    <%

                                        }
                                    %>
                                </div>
                            </div>

                            <div class="col-md-6" >  
                                <div class="skills">
                                    <br>
                                    <h3>Add a skill</h3>
                                    
                                    <%
                                        Vector<Skill> skills = (Vector<Skill>) session.getAttribute("skills");
                                        if (skills != null) {
                                            for (Skill skill : skills) {
                                    %>
                                    <label><input type="checkbox" name="skills" value="<%=skill.getId()%>"  class="checkbox"/> <%=skill.getName()%></label>
                                    <div class="clearfix"></div>
                                    <%
                                            }
                                        }
                                    %>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="clearfix"></div>
                    
                    <button type="submit" class="btn btn-two">Edit Profile</button><p><br/></p>

                </form>



                <%
                        }
                    }
                %>

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
