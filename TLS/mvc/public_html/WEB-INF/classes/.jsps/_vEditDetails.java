
import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _vEditDetails extends com.orionserver.http.OrionHttpJspPage {


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
    _vEditDetails page = this;
    ServletConfig config = pageContext.getServletConfig();
    javax.servlet.jsp.el.VariableResolver __ojsp_varRes = (VariableResolver)new OracleVariableResolverImpl(pageContext);

    try {


      out.write(__oracle_jsp_text[0]);
      out.write(__oracle_jsp_text[1]);
      mvc.mUserBean exchangeUserDetails;
      synchronized (session) {
        if ((exchangeUserDetails = (mvc.mUserBean) pageContext.getAttribute( "exchangeUserDetails", PageContext.SESSION_SCOPE)) == null) {
          exchangeUserDetails = (mvc.mUserBean) new mvc.mUserBean();
          pageContext.setAttribute( "exchangeUserDetails", exchangeUserDetails, PageContext.SESSION_SCOPE);
        }
      }
      out.write(__oracle_jsp_text[2]);
      out.print( exchangeUserDetails.getFirstName());
      out.write(__oracle_jsp_text[3]);

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
  private static final char __oracle_jsp_text[][]=new char[4][];
  static {
    try {
    __oracle_jsp_text[0] = 
    "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n\"http://www.w3.org/TR/html4/loose.dtd\">\n".toCharArray();
    __oracle_jsp_text[1] = 
    "\n<html>\n  <head>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"/>\n    <title>TLS: Edit Details Page</title>\n    <link href=\"css/TLS.css\" rel=\"stylesheet\" media=\"screen\"/>\n  </head>\n  <body><p>\n      ".toCharArray();
    __oracle_jsp_text[2] = 
    "\n    <div id = \"container\">\n        <div id = \"header\"> \n            <div id = \"logout\">\n                <form name = \"vLogoutForm\" action = \"clogoutservlet\" method = \"post\" >\n                    <input type=\"submit\" name=\"mLogout\" value =\"Log out\">\n                </form>\n            </div>\n            <p></p>\n            <h1>Welcome to TLS - Edit personal details </h1><p> \n            You are logged in as: ".toCharArray();
    __oracle_jsp_text[3] = 
    "\n            </p>\n        </div>\n         <div id = \"menu\" >\n            <h3>Menu</h3>\n            <p><a href = \"vUserMain.jsp\">Main</a></p>\n            <p><a href = \"vtoylist?func=toys.jsp\">Browse Items</a></p>\n            <p><a href = \"vtoyslist?func=history.jsp\"> View previous Purchases </a></p>\n            <p><a href = \"vPurchse.jsp\"> Purchase New Toy </a></p>\n            <p><a href = \"vReserve.jsp\"> Items on reserve </a></p>\n            <p><a href = \"vEditDetails.jsp\"> Edit personal details </a></p>           \n        </div>\n        <div id = \"content\">\n            <h3>Login details</h3>\n            <p><label id = \"text\">Password:</label> <input type=\"password\" name=\"vPassword\"/></p>\n            <p><label id = \"text\">Confirm Password:</label> <input type=\"password\" name=\"vConfirmPass\"/></p>\n            <h3>Personal details</h3>\n            <p><label id = \"text\">Postal Address: </label><input type=\"text\" name=\"vAddress\"/></p>\n            <p><label id = \"text\">Delivery Address: </label><input type=\"text\" name=\"vDelAddress\"/></p>\n            <p><label id = \"text\"   >Phone Number: </label><input type=\"text\" name=\"vPhoneNo\"/></p>\n            <p><input type=\"submit\" name=\"vChange\" value=\"Change details\"/></p>\n            <p><input type=\"button\" name=\"vBack\" value=\"Back\" onclick=\"history.go(-1)\"/></p>\n        </div>\n    </div>\n    </body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
