package mvc;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class cLoginServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
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
        
        cEmail = request.getParameter("vEmail");
        cPassword = request.getParameter("vPassword");
        
        boolean isLogin = false;
        String errorMsg = "The username and/or password you entered do not match.";
        
        try { 
            int count;
            // Load JDBC driver:
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 

            // Connect to DB
            String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
            Connection conn = DriverManager.getConnection(url,"admin","admin"); 
            Statement stmt = conn.createStatement();
            
            // check if email and password exists together in DB:
            count = 0;
            ResultSet rsLoginOK = stmt.executeQuery(" SELECT * FROM ADMIN.USERS WHERE EMAIL = '"+cEmail+"' AND PASSWORD = '"+cPassword+"' ");
            while(rsLoginOK.next()) {
                count++;
                cUserID = rsLoginOK.getString("ID");
                cUserType = rsLoginOK.getString("USERTYPE");
                //cEmail = rsLoginOK.getString("EMAIL");
                cFirstName = rsLoginOK.getString("FIRSTNAME");
                cLastName = rsLoginOK.getString("LASTNAME");
                cGender = rsLoginOK.getString("GENDER");
                cDOB = rsLoginOK.getString("DOB");
                cAddress = rsLoginOK.getString("ADDRESS");
                cDelAddress = rsLoginOK.getString("DELIVERYADDRESS");
                cPhoneNo = rsLoginOK.getString("PHONENUMBER");
            }
            if(count == 1) { // user exists
                isLogin = true;
            }
        } catch (Exception e) { 
            System.err.println("Got an exception! "); 
            System.err.println(e.getMessage()); 
        }
        
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
        mUserDetails.setErrorMsg(errorMsg);
        session.setAttribute("exchangeUserDetails", mUserDetails);
        
        if(isLogin == true)
            if(cUserType.charAt(0) == '1') // admin login
                request.getRequestDispatcher("/vAdminMain.jsp").forward(request, response);
            else // customer login
                request.getRequestDispatcher("/vUserMain.jsp").forward(request, response);
        else
            request.getRequestDispatcher("/vLoginError.jsp").forward(request, response);
    }
}
