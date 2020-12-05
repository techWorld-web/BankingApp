package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Connection con;
       PreparedStatement pst;
       PrintWriter writer;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException {
//		// Database Connection
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			con=DriverManager.getConnection("jdbc:mysql://localhost/Bank","root","");
//		}
//		catch(Exception e)
//		{
//			System.out.println(e);
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("email");
		String pass=request.getParameter("pass");
		int result=0;
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Bank","root","");
			PreparedStatement pst = con.prepareStatement("insert into customerdetails(email,password) values(?,?)");
			pst.setString(1, name);
			pst.setString(2, pass);
			result = pst.executeUpdate();
			if(result!=0)
			{
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				out.println("<h3><p style='color:red' align='center' margin-top:50%'>User Registred Successfully</p></h3>");
				rd.include(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				out.println("User cannot Register due to internet connection");
				rd.include(request, response);

			}
			pst.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
