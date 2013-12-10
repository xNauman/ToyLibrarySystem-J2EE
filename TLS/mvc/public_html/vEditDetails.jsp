<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>TLS: Edit Details Page</title>
    <link href="css/TLS.css" rel="stylesheet" media="screen"/>
  </head>
  <body><p>
      <jsp:useBean id="exchangeUserDetails" class="mvc.mUserBean"
                   scope="session"/>
    <div id = "container">
        <div id = "header"> 
            <div id = "logout">
                <form name = "vLogoutForm" action = "clogoutservlet" method = "post" >
                    <input type="submit" name="mLogout" value ="Log out">
                </form>
            </div>
            <p></p>
            <h1>Welcome to TLS - Edit personal details </h1><p> 
            You are logged in as: <jsp:getProperty name="exchangeUserDetails" property="firstName"/>
            </p>
        </div>
         <div id = "menu" >
            <h3>Menu</h3>
            <p><a href = "vUserMain.jsp">Main</a></p>
            <p><a href = "vtoylist?func=toys.jsp">Browse Items</a></p>
            <p><a href = "vtoyslist?func=history.jsp"> View previous Purchases </a></p>
            <p><a href = "vPurchse.jsp"> Purchase New Toy </a></p>
            <p><a href = "vReserve.jsp"> Items on reserve </a></p>
            <p><a href = "vEditDetails.jsp"> Edit personal details </a></p>           
        </div>
        <div id = "content">
            <h3>Login details</h3>
            <p><label id = "text">Password:</label> <input type="password" name="vPassword"/></p>
            <p><label id = "text">Confirm Password:</label> <input type="password" name="vConfirmPass"/></p>
            <h3>Personal details</h3>
            <p><label id = "text">Postal Address: </label><input type="text" name="vAddress"/></p>
            <p><label id = "text">Delivery Address: </label><input type="text" name="vDelAddress"/></p>
            <p><label id = "text"   >Phone Number: </label><input type="text" name="vPhoneNo"/></p>
            <p><input type="submit" name="vChange" value="Change details"/></p>
            <p><input type="button" name="vBack" value="Back" onclick="history.go(-1)"/></p>
        </div>
    </div>
    </body>
</html>