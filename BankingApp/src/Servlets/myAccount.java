package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class myAccount
 */
public class myAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Bank","root","");
				PreparedStatement pst = con.prepareStatement("select * from createaccountdetails");
				ResultSet result = pst.executeQuery();
				while(result.next())
				{
					out.print("<html>");
					out.print("<head>");
					out.print("<p style='table{border-collapse:collapse;width:100%;border:1px solid black;}'>");
					out.print("<body>");
					out.print("<table border='1'><tr><td>Name:"+result.getString(2)+"</td></tr><tr><td>Branch Name:"+result.getString(3)+"</td></tr><tr><td>Bank Name:"+result.getString(4)+"</td></tr><tr><td>Account Type:"+result.getString(5)+"</td></tr><tr><td>Account Number:"+result.getString(6)+"</td></tr><tr><td>Bank Code:"+result.getString(7)+"</td></tr>");
					out.print("</table>");
					out.print("</body>");
					out.print("</style>");
					out.print("</head>");
					out.print("</html>");
//					RequestDispatcher rd=request.getRequestDispatcher("myAccountDe.jsp");
//					rd.include(request, response);
				}
				pst.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
	}

}
