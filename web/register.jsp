<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>Register</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>
        <link rel="stylesheet" href="assets/css/reset.css">
        <link rel="stylesheet" href="assets/css/supersized.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <%@page import="com.geekedin.skill.Skill,java.util.Vector" %>
		<!--
		-->
        <!--<script>
            $(document).ready(function() {
                $('#register_form').validate({
                    rules: {
                        name: "required",
                        surname: "required",
                        country: "required",
                        city: "required",
                        email: {
                            required: true,
                            email: true
                        },
                        phone: {
                            required: true,
                            number: true
                        }

                    }, // end of rules

                    messages: {
                        email: {
                            required: "Please type your email address.",
                            email: "Please enter a valid email address"
                        }

                    } // end of messages
                });
            });
        </script>-->
        
        
    </head>

    <body>

        <div class="page-container">
			<h1>It will only take you few minutes to register...</h1>
            <form action="RegisterServlet" method="post">
                <input type="text" name="name"  placeholder="Name" >
				<input type="text" name="surname" placeholder="Surname" >
				Gender:
				<label><input type="radio" name="gender" value="male" checked="checked" class="radio"/> Male</label>
				<label><input type="radio" name="gender" value="female" class="radio"/> Female</label>
				<input type="text" name="phone" placeholder="Phone number" >
				<input type="text" name="email" placeholder="Email address" >
				<input type="text" name="city" placeholder="City" >
				<input type="text" name="country" placeholder="Country" ><br />
				<div class="skills">
					Skills:
				<div class="clearfix"></div>
                                <% 
                                    Vector<Skill> skills = (Vector<Skill>) session.getAttribute("skills");
                                    if(skills != null)
                                    {
                                        for(Skill skill: skills)
                                        {
                                %>
                                            <label><input type="checkbox" name="skills" value="<%=skill.getId()%>"  class="checkbox"/> <%=skill.getName()%></label>
                                            <div class="clearfix"></div>
                                <%
                                        }
                                    }
                                %>
                                </div>
				
				<br><button type="submit" name ="select" id="login-button" value="Register">Register</button>
                                <div class="error"><span>+</span></div>
            </form>
         
                
          
        </div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>
        <script src="assets/script/lib/jquery.js"></script>
        <script src="assets/script/dist/jquery.validate.js"></script>

        <script>
            $(document).ready(function() {
                $('#register_form').validate({
                    rules: {
                        name: {
                            required: true
                        },
                        surname: {
                            required: true
                        }
                    }, // end of rules

                    messages: {
                        name: {
                            required: "Please type your username.",
                        },
                        surname: {
                            required: "Please enter your password"
                        }

                    } // end of messages
                });
            });
        </script>
    </body>

</html>

