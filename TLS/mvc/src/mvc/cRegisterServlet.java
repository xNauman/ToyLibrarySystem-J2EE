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


public class cRegisterServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        boolean isError = false;
        String errorMsg = "The following mandatory field(s) were not provided: ";
        HttpSession session = request.getSession(true);

        String cUserID = "";
        String cUserType = "2";
        String cEmail = "";
        String cPassword = "";
        String cPass = "";
        String cPassrpt = "";
        String cFirstName = "";
        String cLastName = "";
        String cGender = "";
        String cDOB = "";
        String cAddress = "";
        String cDelAddress = "";
        String cPhoneNo = "";
        
        cEmail = request.getParameter("vEmail");
        cPass = request.getParameter("vPassword");
        cPassrpt = request.getParameter("vConfirmPass");
        cFirstName = request.getParameter("vFirstName");
        cLastName = request.getParameter("vLastName");
        cGender = request.getParameter("vGender");
        cDOB = request.getParameter("vDOB");
        cAddress = request.getParameter("vAddress");
        cDelAddress = request.getParameter("vDelAddress");
        cPhoneNo = request.getParameter("vPhoneNo");
        
        if(cEmail.length() <= 0) {
            isError = true;
            if(errorMsg.charAt(errorMsg.length()-2) != ':')
                errorMsg += ", ";
            errorMsg += "Email";
        }
        
        if(cPass.length() <= 0) {
            isError = true;
            if(errorMsg.charAt(errorMsg.length()-2) != ':')
                errorMsg += ", ";
            errorMsg += "Password";
        }
        
        if(cPassrpt.length() <= 0) {
            isError = true;
            if(errorMsg.charAt(errorMsg.length()-2) != ':')
                errorMsg += ", ";
            errorMsg += "Confirm Password";
        }
        
        if(cFirstName.length() <= 0) {
            isError = true;
            if(errorMsg.charAt(errorMsg.length()-2) != ':')
                errorMsg += ", ";
            errorMsg += "First Name";
        }
        
        if(cLastName.length() <= 0) {
            isError = true;
            if(errorMsg.charAt(errorMsg.length()-2) != ':')
                errorMsg += ", ";
            errorMsg += "Last Name";
        }
        
        if(cGender == null) {
            isError = true;
            if(errorMsg.charAt(errorMsg.length()-2) != ':')
                errorMsg += ", ";
            errorMsg += "Gender";
        }
        
        if(cDOB.length() <= 0) {
            isError = true;
            if(errorMsg.charAt(errorMsg.length()-2) != ':')
                errorMsg += ", ";
            errorMsg += "Date of Birth";
        }
        
        if(cAddress.length() <= 0) {
            isError = true;
            if(errorMsg.charAt(errorMsg.length()-2) != ':')
                errorMsg += ", ";
            errorMsg += "Postal Address";
        }
        
        if(errorMsg.charAt(errorMsg.length()-2) != ':')
            errorMsg += ".";
        
        if(cDelAddress.length() <= 0) {
            cDelAddress = cAddress;
        }
        
        if(cPass.toLowerCase().equals(cPassrpt.toLowerCase())) {
            cPassword = cPass.toLowerCase();
            
            try { 
                int count;
                // Load JDBC driver:
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 

                // Connect to DB
                String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
                Connection conn = DriverManager.getConnection(url,"ADMIN","admin"); 
                Statement stmt = conn.createStatement();
                
                // check date:
                if((Integer.parseInt(cDOB.substring(5,7)) >= 01 && Integer.parseInt(cDOB.substring(5,7)) <= 12) && (Integer.parseInt(cDOB.substring(8,10)) >= 01 && Integer.parseInt(cDOB.substring(8,10)) <= 31)) {
                    // check existance of user in DB:
                    ResultSet rsEmailExists = stmt.executeQuery(" SELECT * FROM RAJA.USERS WHERE EMAIL = '"+cEmail+"' ");
                    count = 0;
                    while(rsEmailExists.next())
                        count++;
                    if(count >= 1) {
                        isError = true;
                        errorMsg = "A user already exists with that Email.";    
                    }
                    else {
                        // get next ID number:
                        ResultSet rsID = stmt.executeQuery(" SELECT * FROM ADMIN.USERS ");
                        count = 0;
                        while(rsID.next())
                            count++;
                            
                        cUserID = String.valueOf(count+1);
                        
                        // store user into DB:
                        stmt.executeUpdate(" INSERT INTO ADMIN.USERS (ID, EMAIL, PASSWORD, USERTYPE, ADDRESS, FIRSTNAME, LASTNAME, PHONENUMBER, GENDER, DOB, DELIVERYADDRESS) VALUES ('"+ cUserID + "', '" + cEmail + "', '" + cPassword + "', '" + cUserType + "', '" + cAddress + "', '" + cFirstName + "', '" + cLastName + "', '" + cPhoneNo + "', '" + cGender + "', to_date('" + cDOB + "','yyyy/mm/dd'), '" + cDelAddress + "')" );
                        conn.commit();
                    }
                }
                else {
                    isError = true;
                    errorMsg = "The date entered is not valid.";
                }
                
            } catch (Exception e) { 
                System.err.println("Got an exception! "); 
                System.err.println(e.getMessage()); 
            } 
        }
        else {
            errorMsg = "The passwords entered do not match.";
            isError = true;
        }
        
        // create and set bean data:
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
        
        if(isError == false)
            request.getRequestDispatcher("/vUserMain.jsp").forward(request, response);
        else
            request.getRequestDispatcher("/vRegisterError.jsp").forward(request, response);
    }
}
