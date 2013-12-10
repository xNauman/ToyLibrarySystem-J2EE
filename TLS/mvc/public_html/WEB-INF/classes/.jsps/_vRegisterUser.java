
import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _vRegisterUser extends com.orionserver.http.OrionHttpJspPage {


  // ** Begin Declarations


  // ** End Declarations

  public void _jspService(HttpServletRequest request, HttpServletResponse response) throws java.io.IOException, ServletException {

    response.setContentType( "text/html;charset=windows-1252");
    /* set up the intrinsic variables using the pageContext goober:
    ** session = HttpSession
    ** application = ServletContext
    ** out = JspWriter
    ** page = this
    ** config = ServletConfig
    ** all session/app beans declared in globals.jsa
    */
    PageContext pageContext = JspFactory.getDefaultFactory().getPageContext( this, request, response, null, true, JspWriter.DEFAULT_BUFFER, true);
    // Note: this is not emitted if the session directive == false
    HttpSession session = pageContext.getSession();
    int __jsp_tag_starteval;
    ServletContext application = pageContext.getServletContext();
    JspWriter out = pageContext.getOut();
    _vRegisterUser page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);

    }
    catch (Throwable e) {
      if (!(e instanceof javax.servlet.jsp.SkipPageException)){
        try {
          if (out != null) out.clear();
        }
        catch (Exception clearException) {
        }
        pageContext.handlePageException(e);
      }
    }
    finally {
      OracleJspRuntime.extraHandlePCFinally(pageContext, true);
      JspFactory.getDefaultFactory().releasePageContext(pageContext);
    }

  }
  private static final char __oracle_jsp_text[][]=new char[2][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n\"http://www.w3.org/TR/html4/loose.dtd\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<html>\n  <head>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"/>\n    <title>TLS: Register Page</title>\n    <link href=\"css/TLS.css\" rel=\"stylesheet\" media=\"screen\"/>\n  </head>\n  <body>\n    <div id = \"container\">\n          <div id = \"header\">\n              <p>\n                <h1>Register for TLS</h1>\n              </p>\n          </div>\n          <div id = \"Register\">\n              <form name=\"vRegisterForm\" action=\"cregisterservlet\" method=\"post\"\n                      enctype=\"application/x-www-form-urlencoded\">\n              <p>\n                <h2>Fields marked with (<font color=\"#ff0000\">*</font>) indicate mandatory fields.</h2>\n              </p>\n              <p>\n                <h3>Login details:</h3>\n              </p>\n              <p>\n                <label>Email:</label> <input type=\"text\" name=\"vEmail\"/><font color=\"#ff0000\">\n                  *\n                </font>\n              </p>\n              <p>\n                <label>Password:</label> <input type=\"password\" name=\"vPassword\"/><font color=\"#ff0000\">\n                  *\n                </font>\n              </p>\n              <p>\n                <label>Confirm Password:</label> <input type=\"password\" name=\"vConfirmPass\"/><font color=\"#ff0000\">\n                  *\n                </font>\n              </p>\n              <hr/>\n              <p>\n                <h3>User details:</h3>\n              </p>\n              <p>\n                <label>First Name: </label> <input type=\"text\" name=\"vFirstName\"/><font color=\"#ff0000\">\n                  *\n                </font>\n              </p>\n              <p>\n                <label>Last Name:</label> <input type=\"text\" name=\"vLastName\"/><font color=\"#ff0000\">*</font>\n              </p>\n              <p>\n                <label> Gender: </label>\n                <input type=\"radio\" name=\"vGender\" value=\"m\"/>Male\n                <input type=\"radio\" name=\"vGender\" value=\"f\"/>Female \n                <font color=\"#ff0000\">\n                  *\n                </font>\n              </p>\n              <p>\n                <label> Date of Birth (yyyy/mm/dd): </label>\n                <input type=\"text\" name=\"vDOB\"/><font color=\"#ff0000\">\n                  *\n                </font>\n              </p>\n              <p>\n                <label>Postal Address: </label>\n                <font color=\"#ff0000\">\n                  <input type=\"text\" name=\"vAddress\"/>\n                  *\n                </font>\n              </p>\n              <p>\n                <label>Delivery Address: </label>\n                <input type=\"text\" name=\"vDelAddress\"/>\n                (leave blank if it's the same as Postal Address)\n              </p>\n              <p>\n                <label>Phone Number: </label>\n                <input type=\"text\" name=\"vPhoneNo\"/>\n              </p>\n              <p>\n                <input type=\"submit\" name=\"vRegister\" value=\"Register\"/><input type=\"button\" name=\"vBack\" value=\"Back\" onclick=\"history.go(-1)\"/>\n              </p>\n            </form>\n        </div>\n    </div>\n    </body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
