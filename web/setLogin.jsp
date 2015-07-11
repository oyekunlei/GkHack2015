<%-- 
    Document   : setLogin
    Created on : Jun 27, 2015, 4:24:49 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>Fullscreen Login</title>
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
        <%@page import="com.geekedin.skill.Skill,java.util.Vector, com.geekedin.geek.Geek" %>
    </head>

    <body>

        <div class="page-container">
            <h1>Fill in the form to set login details</h1>
            <h1>Login</h1>
            <form action="RegisterServlet" method="post">
                <%
                    Geek geek = (Geek) session.getAttribute("geek");
                    if (geek != null) {
                %>
                <input type="hidden" name="id" value="<%=geek.getId()%>">
                <input type="text" name="username" placeholder="Username">
                <input type="password" name="password" placeholder="Pasword">


                <br><button type="submit" name ="select" id="login-button" value="Set Login Details">Set Login Details</button>
                <%
                    }
                %>

            </form>



        </div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.8.2.min.js"></script>
        <script src="assets/js/supersized.3.2.7.min.js"></script>
        <script src="assets/js/supersized-init.js"></script>
        <script src="assets/js/scripts.js"></script>

    </body>

</html>


