<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=windows-1252"%>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=windows-1252"/>
    <title>vLoginError</title>
    <link href="css/TLS.css" rel="stylesheet" media="screen"/>
  </head>
  <body>
    <div id = "container">
            <p>
              <jsp:useBean id="exchangeUserDetails" class="mvc.mUserBean"
                           scope="session"/>
            </p>
            <div id = "header">
                    <p> Dear Customer, </p>
                    <p>There was an error trying to process your request:</p>
                    <p>
                      <ul>
                        <li>
                          <jsp:getProperty name="exchangeUserDetails" property="errorMsg"/>
                        </li>
                      </ul>
                    </p>
                    <p>Please go back and try again.</p>
                    <p><a href="javascript:history.go(-1)">[Go Back]</a></p>
            </div>
    </div>
    </body>
</html>