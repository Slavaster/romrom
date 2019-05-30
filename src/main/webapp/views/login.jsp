<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/static/stylesheets/login_style.css" rel="stylesheet" id="bootstrap-css" type="text/css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

${SPRING_SECURITY_LAST_EXCEPTION.message}

<div class="wrapper fadeInDown">
    <div id="formContent">

        <div class="fadeIn first">
            <img src="https://img.icons8.com/bubbles/100/000000/administrator-male.png" id="icon" alt="User Icon" />
        </div>

        <!-- Login Form -->
        <form action="login" method="POST">
            <input type="text" id="login" class="fadeIn second" name="username" placeholder="login">
            <input type="text" id="password" class="fadeIn third" name="password" placeholder="password">
            <input type="submit" class="fadeIn fourth" value="Log In">
        </form>

        <!-- Remind Passowrd -->
        <div id="formFooter">
            <a class="underlineHover" href="#">Forgot Password?</a>
        </div>

    </div>
</div>
</body>
</html>