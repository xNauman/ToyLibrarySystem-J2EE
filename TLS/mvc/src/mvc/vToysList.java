package mvc;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.PrintStream;

public class vToysList extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";
    private String mUserName = null;
    private mUserBean mUBean = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {
                      
              
        HttpSession session = request.getSession(true);
        
        //get the parameter              
        String vFunctionType = request.getParameter("func");
        
        //get the "bean" for current user
        mUBean = (mUserBean)session.getAttribute("exchangeUserDetails");
        
        //check the action and perform accordingly
    if(vFunctionType!= null){
            if(vFunctionType.equalsIgnoreCase("toys"))
                    this.showToyList(request,response);
            else if(vFunctionType.equalsIgnoreCase("history"))
                    this.showBorrowingHistory(request,response);
    }
    else
    request.getRequestDispatcher("/vCustomerMain.jsp");
                      
    
    }
    
    private void  showToyList(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException{
                      
                          PrintWriter out = response.getWriter();
                          HttpSession session = request.getSession(true);
                          request.getAttribute("vEmail");
                          
                          try {
                              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
                              String url = "jdbc:oracle:thin:@localhost:1521:xe";
                              Connection conn;
                              conn = DriverManager.getConnection(url,"admin","admin");
                              Statement stmt =conn.createStatement();

                              out.println(
                              "<html>\n" + 
                              "  <head>\n" +
                              "    <title>TLS: Main Page</title>\n" + 
                              "    <link href=\"css/TLS2.css\" rel=\"stylesheet\" media=\"screen\"/>\n" + 
                              "  </head>\n" + 
                              "  <body><p>\n" + 
                              "      <jsp:useBean id=\"exchangeUserDetails\" class=\"mvc.mUserBean\"\n" + 
                              "                   scope=\"session\"/>\n" + 
                              "    <div id = \"container\">\n" + 
                              "        <div id = \"header\"> \n" + 
                              "            <div id = \"logout\">\n" + 
                              "                <form name = \"vLogoutForm\" action = \"clogoutservlet\" method = \"post\" >\n" + 
                              "                    <input type=\"submit\" name=\"mLogout\" value =\"Log out\">\n" + 
                              "                </form>\n" + 
                              "            </div>\n" + 
                              "            <h1>Welcome to TLS - Customer Page </h1> \n" + 
                              "            <p>You are logged in as: <jsp:getProperty name=\"exchangeUserDetails\" property=\"firstName\"/></p>\n" + 
                              "        </div>\n" + 
                              "         <div id = \"menu\" >\n" + 
                              "            <h3>Menu</h3>\n" + 
                              "           <p><a href = \"vUserMain.jsp\">Main</a></p>\n" + 
                              "            <p><a href = \"vtoyslist?func=toys\">Browse Items</a></p>\n" + 
                              "            <p><a href = \"vtoyslist?func=history\"> View previous Purchases </a></p>\n" + 
                              "            <p><a href = \"vEditDetails.jsp\"> Edit personal details </a></p>\n" + 
                              "        </div>\n" + 
                              "        <div id = \"content\">\n" + 
                              "       <h3>Monthly report</h3>\n"+
                              "            <table>\n" + 
                              "                <tr>\n" + 
                              "                    <td>Toy Name</td>\n" + 
                              "                    <td>Toy Price</td>\n" + 
                              "                    <td>Quantity</td>\n" + 
                              "                </tr>\n");
                              String[] vResult = new String[3];
                              //String mResult = "";
                              //ResultSet rsUser = stmt.executeQuery("SELECT distinct ID FROM ADMIN.USER WHERE EMAIL ="+"'vEmail'");
                              //String mResult = rsUser.getString("ID");
                              ResultSet rsReport = stmt.executeQuery("SELECT * FROM ADMIN.TOY");
                              while(rsReport.next()) {
                                  vResult[0] = rsReport.getString("TOYNAME");
                                  vResult[1] = rsReport.getString("TPRICE");
                                  vResult[2] = rsReport.getString("QUANTITY");
                                  out.println(
                                  "<form action=chiretoy method=POST>"+
                                  "                <tr>\n" + 
                                  "                    <td id = \"item\"><input type=checkbox name=item value="+vResult[0]+
                                  " />"+vResult[0] +"</td>\n" + 
                                  "                    <td id = \"item\">"+ vResult[1] +"</td>\n" + 
                                  "                    <td id = \"item\">"+ vResult[2] +"</td>\n" + 
                                  "                </tr>"                                  
                                  );
                              }
                              out.println(
                              "<input type=\"submit\" value=\"hire\"></form>"+
                              "            </table>\n" + 
                              "        </div>\n" + 
                              "    </div>" +
                              "</body>\n" + 
                              "</html>"
                              );
                              
                              
                          }catch(Exception e){
                              out.println("Error");
                          }
                      }
    //still under progress
    private void  showBorrowingHistory(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException{
                      
                          PrintWriter out = response.getWriter();
                          HttpSession session = request.getSession(true);
                          request.getAttribute("vEmail");
                          
                          try {
                              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");   
                              String url = "jdbc:oracle:thin:@localhost:1521:xe";
                              Connection conn;
                              conn = DriverManager.getConnection(url,"admin","admin");
                              Statement stmt =conn.createStatement();

                              out.println(
                              "<html>\n" + 
                              "  <head>\n" +
                              "    <title>TLS: Main Page</title>\n" + 
                              "    <link href=\"css/TLS2.css\" rel=\"stylesheet\" media=\"screen\"/>\n" + 
                              "  </head>\n" + 
                              "  <body><p>\n" + 
                              "      <jsp:useBean id=\"exchangeUserDetails\" class=\"mvc.mUserBean\"\n" + 
                              "                   scope=\"session\"/>\n" + 
                              "    <div id = \"container\">\n" + 
                              "        <div id = \"header\"> \n" + 
                              "            <div id = \"logout\">\n" + 
                              "                <form name = \"vLogoutForm\" action = \"clogoutservlet\" method = \"post\" >\n" + 
                              "                    <input type=\"submit\" name=\"mLogout\" value =\"Log out\">\n" + 
                              "                </form>\n" + 
                              "            </div>\n" + 
                              "            <h1>Welcome to TLS - Customer Page </h1> \n" + 
                              "            <p>You are logged in as: "+mUBean.getFirstName()+"</p>\n" + 
                              "        </div>\n" + 
                              "         <div id = \"menu\" >\n" + 
                              "            <h3>Menu</h3>\n" + 
                              "            <p><a href = \"vUserMain.jsp\">Main</a></p>\n" + 
                              "            <p><a href = \"vtoyslist?func=toys\">Browse Items</a></p>\n" + 
                              "            <p><a href = \"vtoyslist?func=history\"> View previous Purchases </a></p>\n" + 
                              "            <p><a href = \"vEditDetails.jsp\"> Edit personal details </a></p>\n" + 
                              "        </div>\n" + 
                              "        <div id = \"content\">\n" + 
                              "       <h3>Monthly report</h3>\n"+
                              "            <table>\n" + 
                              "                <tr>\n" + 
                              "                    <td>Item</td>\n" + 
                              "                    <td>Due Date</td>\n" + 
                              "                </tr>\n");
                              String[] vResult = new String[2];
                              //String mResult = "";
                              ResultSet rsUser = stmt.executeQuery("SELECT distinct ID FROM ADMIN.TRANSACTION WHERE EMAIL ="+"'vEmail'");
                              String mResult = rsUser.getString("ID");
                              ResultSet rsReport = stmt.executeQuery("SELECT * FROM ADMIN.RENT WHERE CUSTID = '"+mResult+"'");
                              while(rsReport.next()) {
                                  vResult[0] = rsReport.getString("TOYNAME");
                                  vResult[1] = rsReport.getString("DUEDATE");
                                  out.println(
                                  "<form action=chiretoy method=get>"+
                                  "                <tr>\n" + 
                                  "                    <td id = \"item\">"+ vResult[0] +"</td>\n" + 
                                  "                    <td id = \"item\">"+ vResult[1] +"</td>\n" + 
                                  "                </tr>"
                                  );
                              }
                              out.println(
                              "            </table>\n" +
                              "        </div>\n" + 
                              "    </div>" +
                              "</body>\n" + 
                              "</html>"
                              );
                              
                              
                          }catch(Exception e){
                              out.println("");
                          }
                      }
                      
}


