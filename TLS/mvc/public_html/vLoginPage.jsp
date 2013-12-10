<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>vLoginPage</title>
    <link href="css/TLS.css" rel="stylesheet" media="screen"/>
  </head>
  <body>
    <div id = "container">
            <div id = "header">
                  <p>
                     <h1>TLS - Login</h1>
                  </p>
              </div>
              <div id = "Login"> 
                <form name="vLoginForm" action="cloginservlet" method="post" enctype="application/x-www-form-urlencoded">
                     <p>Email:<input type="text" name="vEmail"/> </p>
                     <p>Password:<input type="password" name="vPassword"/></p>
                     <p><input type="submit" name="vLoginButton" value="Login"/></p>
                     <p><a href="vRegisterUser.jsp">Not a member? Signup Now!</a></p>
                </form>
            </div>
    </div>
    </body>
</html>