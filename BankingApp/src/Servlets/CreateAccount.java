package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateAccount
 */
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String bname=request.getParameter("bname");
		String bank=request.getParameter("bank");
		String type=request.getParameter("type");
		String accno=request.getParameter("accno");
		String ifsc=request.getParameter("ifsc");
		
		int result=0;
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Bank","root","");
				PreparedStatement pst = con.prepareStatement("insert into createaccountdetails(name,bname,bank,type,accno,ifsc) values(?,?,?,?,?,?)");
				pst.setString(1, name);
				pst.setString(2, bname);
				pst.setString(3, bank);
				pst.setString(4, type);
				pst.setString(5, accno);
				pst.setString(6, ifsc);
				result = pst.executeUpdate();
				if(result!=0)
				{
					out.println("<h3><b><p style='color:red' align='center' margin-top:50%'>Hello,"+name+" Account created Successfully</p><b></h3>");
					RequestDispatcher rd=request.getRequestDispatcher("CreateAccount.jsp");
					rd.include(request, response);
				}else {
					RequestDispatcher rd=request.getRequestDispatcher("CreateAccount.jsp");
					out.println("Account not created!!! All fields are mandatory");
					rd.include(request, response);

				}
				pst.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
