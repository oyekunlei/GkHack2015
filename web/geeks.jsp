<%@page import="com.geekedin.skill.Skill"%>
<%@page import="com.geekedin.geek.Geek"%>
<%@page import="com.geekedin.team.Team"%>
<%@page import="java.util.Vector"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Interior-Design-Responsive-Website-Templates-Edge">
        <meta name="author" content="webThemez.com">
        <title>Geeks</title>
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
    </head>

    <body>
        <%
            Vector<Team> teams = (Vector<Team>) session.getAttribute("geeksTeams");
            Vector<Skill> skills = (Vector<Skill>) session.getAttribute("geeksSkills");
            Geek geek = (Geek) session.getAttribute("geek");
            Vector<Geek> geeks = (Vector<Geek>) session.getAttribute("allgeeks");
           
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
                        <li class="active"><a href="GeekServlet?select=ViewGeeks">Geeks</a></li>
                        <li class="dropdown">
                            <%
                                 if (geek != null) {
                            %>
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
                        <p>
                        <h4>Find out other geeks.</h4>
                        <br />
                        <br />

                        </p>

                        <div class="container">
                            <form action="" method="post" class="form-light mt-20" role="form">
                                <%
                                
                                    if (geeks != null) {
                                        if (skills != null) {
                                           if (teams != null) {
                                                for (Geek g : geeks) {
                                %>
                                <div class="profile">
                                    <div class="form-group">
                                        <div class="thumbnail">
                                            <div class="picture">
                                                <img src="files/dpp.png" />
                                            </div>
                                        </div>
                                        <label>Name & Surname: <%=g.getName()%> <%=g.getSurname()%></label>
                                        <br><label>Gender: <%=g.getGender()%></label>
                                        <br><label>Skills:</label>
                                        <%
                                            for (int id : g.getSkills()) {
                                                for (Skill s : skills) {
                                                    if (s.getId() == id) {
                                        %>
                                         <%=s.getName()%>,
                                        <%
                                                    }
                                                }
                                            }
                                           for (Team t : teams) {
                                              if (t.getId() == g.getTeamId()) {
                                        %>
                                        <br><label>Team: <%=t.getName()%></label>
                                        <%
                                                }
                                           }
                                        %>
                                        <div class="dropdown">
                                            <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">More
                                                <span class="caret"></span></button>
                                            <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
                                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">View Full Profile</a></li>
                                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Invite</a></li>
                                                <li role="presentation"><a role="menuitem" tabindex="-1" href="#">Ask for help</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <%
                                    }
                                } else {

                                %>
                                <h1>No teams loaded</h1>
                                <%                                                    }
                                } else {
                                %>
                                <h1>No skills loaded</h1>
                                <%
                                    }

                                } else {
                                %>
                                <h1>No geeks loaded</h1>
                                <%
                                        }
                                    }
                                 else
                                 {
                                     %>
                                     <h1>Please <a href="index.jsp">Login</a></h1>
                                     <%
                                 }
                                %>
                            </form>
                        </div>
                    </section>

                </div>
            </div>

        </section>
        <!-- /container -->

        <footer id="footer">
            <div class="container">
                <div class="social text-center">
                    <a href="#"><i class="fa fa-twitter"></i></a>
                    <a href="#"><i class="fa fa-facebook"></i></a>
                    <a href="#"><i class="fa fa-dribbble"></i></a>
                    <a href="#"><i class="fa fa-flickr"></i></a>
                    <a href="#"><i class="fa fa-github"></i></a>
                </div>

                <div class="clear"></div>
                <!--CLEAR FLOATS-->
            </div>
            <div class="footer2">
                <div class="container">
                    <div class="row">

                        <div class="col-md-6 panel">
                            <div class="panel-body">
                                <p class="simplenav">
                                    <a href="index.html">Home</a> | 
                                    <a href="about.html">About</a> |
                                    <a href="services.html">Services</a> |
                                    <a href="price.html">Price</a> |
                                    <a href="projects.html">Projects</a> |
                                    <a href="contact.html">Contact</a>
                                </p>
                            </div>
                        </div>

                        <div class="col-md-6 panel">
                            <div class="panel-body">
                                <p class="text-right">
                                    Copyright &copy; 2014. Template by <a href="http://webthemez.com/" rel="develop">WebThemez.com</a>
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
