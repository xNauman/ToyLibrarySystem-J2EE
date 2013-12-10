package mvc;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class cLogout extends HttpServlet {
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
    }
}
