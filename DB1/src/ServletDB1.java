
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class ServletDB1
 */
public class ServletDB1 extends HttpServlet {
	Connection conn=null;
	Statement stmt=null;
	ResultSet rs=null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDB1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html"); 
		 		try
				{  
		   		Class.forName("com.mysql.cj.jdbc.Driver"); 
				out.println("Driver is Loaded");
				out.println("<br><br>"); 
		   	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/janhavi","root","root");  
				out.println( "Connection is Available");
		   		stmt = con.createStatement();  
		   	        rs=stmt.executeQuery("select * from employee3");  
		    
		   			while(rs.next())
					{ 
		 			int id=rs.getInt(1);
					String name=rs.getString(2);
					String city=rs.getString(3);
					String mobno=rs.getString(4);
					String age=rs.getString(5);
					out.println("<br><br>"); 
					out.println("The Employee Id is"+" "+id); 
					out.println("<br><br>");
					out.println("The Employee Name is"+" "+name);
					out.println("<br><br>");
					out.println("The Employee City is"+" "+city); 
					out.println("<br><br>");
					out.println("The Employee Mobile No. is"+" "+mobno);
					out.println("<br><br>");
					
		   			out.println("The Employee age is"+" "+age);
					 
		  			 }  
		  
				}
				catch(Exception e){out.println(e);}
	}

}
