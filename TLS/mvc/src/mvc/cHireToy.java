package mvc;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

public class cHireToy extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

  
    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, IOException {
                       
                response.setContentType(CONTENT_TYPE);
                
                PrintWriter out= response.getWriter();
                
                HttpSession vSession = request.getSession(true);
                
                String[] vParamToys = request.getParameterValues("item");
                
                mUserBean vUBean =(mUserBean) vSession.getAttribute("exchangeUserDetails");
                
        Calendar vCal = Calendar.getInstance();
        vCal.add(Calendar.DATE,30);
        if(vParamToys.length > 3 && vUBean != null){
        
        out.println("can not hire more than three Itmes");
            
        }else
                try{
                    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
                    String url = "jdbc:oracle:thin:@localhost:1521:xe";
                    Connection conn;
                    conn = DriverManager.getConnection(url,"admin","admin");
                    Statement stmt =conn.createStatement();

//out.println(vUBean.getUserID());
                 ResultSet vResult = stmt.executeQuery("SELECT * FROM ADMIN.RENT WHERE CUSTID=' "+vUBean.getUserID()+"'");
                 int vCount = 0;
                 
                 while(vResult.next()){
                 vCount++;
                 }
                 if((vCount + vParamToys.length) > 3 )
                 out.println("Exceding the hiring limit");
                 else{
                 vCount++;
                 String vRentId = String.valueOf(vCount);
                    for(int i=0;i<vParamToys.length;i++){
                       out.println("vCount"+vCount+"vUBean"+vUBean.getUserID()+"Tennis<br>");
                       stmt.executeUpdate("INSERT INTO ADMIN.RENT (RENTID, CUSTID, TOYNAME, DUEDATE) VALUES ('"+vRentId+"' , '"+vUBean.getUserID()+"' , '"+vParamToys[i]+"' , '"+ vCal.DATE+"' )"); 
                         conn.commit()     ;
                    }
                    conn.close();
                 }
                }catch(Exception e){
                    out.println("Error:");
                }
        
        //request.getRequestDispatcher("/vUserMain.jsp").forward(request,response);
    }
}
