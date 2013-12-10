<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>TLS: Register Page</title>
    <link href="css/TLS.css" rel="stylesheet" media="screen"/>
  </head>
  <body>
    <div id = "container">
          <div id = "header">
              <p>
                <h1>Register for TLS</h1>
              </p>
          </div>
          <div id = "Register">
              <form name="vRegisterForm" action="cregisterservlet" method="post"
                      enctype="application/x-www-form-urlencoded">
              <p>
                <h2>Fields marked with (<font color="#ff0000">*</font>) indicate mandatory fields.</h2>
              </p>
              <p>
                <h3>Login details:</h3>
              </p>
              <p>
                <label>Email:</label> <input type="text" name="vEmail"/><font color="#ff0000">
                  *
                </font>
              </p>
              <p>
                <label>Password:</label> <input type="password" name="vPassword"/><font color="#ff0000">
                  *
                </font>
              </p>
              <p>
                <label>Confirm Password:</label> <input type="password" name="vConfirmPass"/><font color="#ff0000">
                  *
                </font>
              </p>
              <hr/>
              <p>
                <h3>User details:</h3>
              </p>
              <p>
                <label>First Name: </label> <input type="text" name="vFirstName"/><font color="#ff0000">
                  *
                </font>
              </p>
              <p>
                <label>Last Name:</label> <input type="text" name="vLastName"/><font color="#ff0000">*</font>
              </p>
              <p>
                <label> Gender: </label>
                <input type="radio" name="vGender" value="m"/>Male
                <input type="radio" name="vGender" value="f"/>Female 
                <font color="#ff0000">
                  *
                </font>
              </p>
              <p>
                <label> Date of Birth (yyyy/mm/dd): </label>
                <input type="text" name="vDOB"/><font color="#ff0000">
                  *
                </font>
              </p>
              <p>
                <label>Postal Address: </label>
                <font color="#ff0000">
                  <input type="text" name="vAddress"/>
                  *
                </font>
              </p>
              <p>
                <label>Delivery Address: </label>
                <input type="text" name="vDelAddress"/>
                (leave blank if it's the same as Postal Address)
              </p>
              <p>
                <label>Phone Number: </label>
                <input type="text" name="vPhoneNo"/>
              </p>
              <p>
                <input type="submit" name="vRegister" value="Register"/><input type="button" name="vBack" value="Back" onclick="history.go(-1)"/>
              </p>
            </form>
        </div>
    </div>
    </body>
</html>