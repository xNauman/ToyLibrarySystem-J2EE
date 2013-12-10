
import oracle.jsp.runtime.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import oracle.jsp.el.*;
import javax.servlet.jsp.el.*;


public class _vLoginError extends com.orionserver.http.OrionHttpJspPage {


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
    _vLoginError page = this;
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
      out.print( exchangeUserDetails.getErrorMsg());
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
    "\n<html>\n  <head>\n    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"/>\n    <title>vLoginError</title>\n    <link href=\"css/TLS.css\" rel=\"stylesheet\" media=\"screen\"/>\n  </head>\n  <body>\n    <div id = \"container\">\n            <p>\n              ".toCharArray();
    __oracle_jsp_text[2] = 
    "\n            </p>\n            <div id = \"header\">\n                    <p> Dear Customer, </p>\n                    <p>There was an error trying to process your request:</p>\n                    <p>\n                      <ul>\n                        <li>\n                          ".toCharArray();
    __oracle_jsp_text[3] = 
    "\n                        </li>\n                      </ul>\n                    </p>\n                    <p>Please go back and try again.</p>\n                    <p><a href=\"javascript:history.go(-1)\">[Go Back]</a></p>\n            </div>\n    </div>\n    </body>\n</html>".toCharArray();
    }
    catch (Throwable th) {
      System.err.println(th);
    }
}
}
