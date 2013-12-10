package mvc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class cLogoutServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        try {
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>cLogoutServlet</title></head>");
            out.println("<body>");
            out.println("<p>The servlet has received a GET. This is the reply.</p>");
            out.println("</body></html>");
            out.close();
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        }
    }

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        try {
            HttpSession session = request.getSession(true);    

            String cUserID = "";
            String cUserType = "";
            String cEmail = "";
            String cPassword = "";
            String cFirstName = "";
            String cLastName = "";
            String cGender = "";
            String cDOB = "";
            String cAddress = "";
            String cDelAddress = "";
            String cPhoneNo = "";

            mUserBean mUserDetails = new mUserBean();
            mUserDetails.setUserID(cUserID);
            mUserDetails.setUserType(cUserType);
            mUserDetails.setPassword(cPassword);
            mUserDetails.setFirstName(cFirstName);
            mUserDetails.setLastName(cLastName);
            mUserDetails.setGender(cGender);
            mUserDetails.setDOB(cDOB);
            mUserDetails.setAddress(cAddress);
            mUserDetails.setDelAddress(cDelAddress);
            mUserDetails.setPhoneNo(cPhoneNo);
            session.setAttribute("exchangeUserDetails", mUserDetails);

            request.getRequestDispatcher("/vLoginPage.jsp").forward(request, response);
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        }
    }
}
