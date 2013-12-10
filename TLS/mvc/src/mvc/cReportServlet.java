package mvc;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class cReportServlet extends HttpServlet {
    private static final String CONTENT_TYPE = "text/html; charset=windows-1252";

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);  
        PrintWriter out = response.getWriter();
        
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
            "            <p><a href = \"vUserMain.jsp\">Main</a></p>\n" + 
            "            <p><a href = \"vBrowse.jsp\">Browse Items</a></p>\n" + 
            "            <p><a href = \"vViewPrevious.jsp\"> View previous Purchases </a></p>\n" + 
            "            <p><a href = \"vPurchse.jsp\"> Purchase New Toy </a></p>\n" + 
            "            <p><a href = \"vReserve.jsp\"> Items on reserve </a></p>\n" + 
            "            <p><a href = \"vEditDetails.jsp\"> Edit personal details </a></p>\n" + 
            "            <p><a href = \"vReport.jsp\">Generate Report</a></p>\n" + 
            "        </div>\n" + 
            "        <div id = \"content\">\n" + 
            "       <h3>Monthly report</h3>\n"+
            "            <table>\n" + 
            "                <tr>\n" + 
            "                    <td>ToyID</td>\n" + 
            "                    <td>CustID</td>\n" + 
            "                    <td>DateIn</td>\n" + 
            "                    <td>DateOut</td>\n" +
            "                </tr>\n");
            String[] vResult = new String[4];
            ResultSet rsReport = stmt.executeQuery("SELECT * FROM ADMIN.TRANSACTION");
            while(rsReport.next()) {
                vResult[0] = rsReport.getString("TOYID");
                vResult[1] = rsReport.getString("CUSTID");
                vResult[2] = rsReport.getString("TDATEIN");
                vResult[3] = rsReport.getString("TDATEOUT");
                out.println(
                "                <tr>\n" +               
                "<td>" + vResult[0] + "</td>\n" +
                "<td>" + vResult[1] + "</td>\n" +
                "<td>" + vResult[2] + "</td>\n" +
                "<td>" + vResult[3] + "</td>\n" +
                "                </tr>\n"
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

    public void doPost(HttpServletRequest request, 
                       HttpServletResponse response) throws ServletException, IOException {response.setContentType(CONTENT_TYPE);
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>cReportServlet</title></head>");
        out.println("<body>");
        out.println("<p>The servlet has received a POST. This is the reply.</p>");
        out.println("</body></html>");
        out.close();
    }
}
