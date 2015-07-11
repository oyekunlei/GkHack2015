
<!DOCTYPE html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>Login</title>
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
		
		

       

    </head>

    <body>

        <div class="page-container">
			<div class="header">
				<h1>Welcome to GeekedIn, the web space for geeks</h1>
			<div>
                            <br>
                            <h1>Login</h1>
            <form action="RegisterServlet" method="post">
                <input type="text" name="username" class="username" placeholder="Username">
                <input type="password" name="password" class="password" placeholder="Password">
                <button type="submit" name = "select" value="Login">Sign me in</button>
                <div class="error"><span>+</span></div>
            </form>
			<div class="connect">
                <p>Don't have an account yet, <a href="RegisterServlet?select=load"> Register</a>
            </div>
                
          
        </div>
                        </div>
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
                $('#login_form').validate({
                    rules: {
                        username: {
                            required: true
                        },
                        password: {
                            required: true
                        }
                    }, // end of rules

                    messages: {
                        username: {
                            required: "Please type your username.",
                        },
                        password: {
                            required: "Please enter your password"
                        }

                    } // end of messages
                });
            });
        </script>
    </body>

</html>

