<!doctype html>
<html>
<head>
    <link href="login.css" media="all" rel="stylesheet" type="text/css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $('#toggle-login').click(function () {
                $('#login').toggle();
            })
        });
    </script>
</head>
<body>

<span href="#" class="button" id="toggle-login">Log in</span>

<div id="login">

    <div id="triangle"></div>
    <h1>Log in</h1>

    <form id="myLoginForm" name="loginform" action="j_security_check" method="post">
        <input id="j_username" name="j_username" type="text" placeholder="User name"/>
        <input id="j_password" name="j_password" type="password" placeholder="Password"/>
        <input type="submit" value="Log in"/>
    </form>


</div>

</body>
</html>
