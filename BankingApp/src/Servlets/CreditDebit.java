package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreditDebit
 */
public class CreditDebit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreditDebit() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String bank=request.getParameter("bank");
		String type=request.getParameter("type");
		String accno=request.getParameter("accno");
		String ifsc=request.getParameter("ifsc");
		int amount=Integer.parseInt(request.getParameter("amount"));
		String date=request.getParameter("date");
		int ref=13;
		int result=0;
//		LocalDateTime lt= new LocalDateTime.now();
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Bank","root","");
			if(type.equals("Deposit"))
			{
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from deposit where accno="+accno);
				int netAmount=0;
				if(rs.next())
				{
					netAmount=rs.getInt(6)+amount;
					out.println("<h3><b><p style='color:red' align='center' margin-top:50%'>Amount Deposited Successfully,Please check your balance</p><b></h3>");
					RequestDispatcher rd=request.getRequestDispatcher("deposit.jsp");
					rd.include(request, response);
				}
				int debit=0;
				PreparedStatement  pst =con.prepareStatement("update deposit set amount=? where accno=? ");
				pst.setInt(1,netAmount);
				pst.setString(2, accno);
				pst.executeUpdate();
				
				ref=ref*113*3+2;
				PreparedStatement  pst1 =con.prepareStatement("insert into debitedamount(bank,type,accno,reference,deposit,balance,withdraw,date) values(?,?,?,?,?,?,?,?)");
				pst1.setString(1, bank);
				pst1.setString(2, type);
				pst1.setString(3, accno);
				pst1.setLong(4, ref);
				pst1.setInt(5, amount);
				pst1.setInt(6, netAmount);
				pst1.setInt(7, debit);
				pst1.setString(8, date); 
				pst1.executeUpdate();
				pst1.close();
				
			}
			else if(type.equals("Withdraw")) 
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from deposit where accno="+accno);
				int totalAmount=0;
				int originalAmount=0;
				
				while(rs.next())
				{
					originalAmount=rs.getInt(6);
					
					if(amount<originalAmount)
					{
						totalAmount=originalAmount-amount;
						out.println("<h3><b><p style='color:red' align='center' margin-top:50%'>Amount Debited Successfully,Your Remaining Balance in your Account is:"+totalAmount+"</p><b></h3>");
						RequestDispatcher rd=request.getRequestDispatcher("deposit.jsp");
						rd.include(request, response);

					}
					else {
						totalAmount=originalAmount;
						out.println("<h3><b><p style='color:red' align='center' margin-top:50%'>Insufficient Balance!!!</p><b></h3>");
						out.println("<h3><b><p style='color:red' align='center' margin-top:50%'>Your Bank Balance in your Account is:"+totalAmount+"</p><b></h3>");
						out.println("<h3><b><p style='color:red' align='center' margin-top:50%'>You entered amount is:"+amount+"</p><b></h3>");
						RequestDispatcher rd=request.getRequestDispatcher("deposit.jsp");
						totalAmount=originalAmount;
						rd.include(request, response);
	
					}
				}
				int availableAmount=totalAmount;
				PreparedStatement  pst =con.prepareStatement("update deposit set amount=? where accno=? ");
				pst.setInt(1, totalAmount);
				pst.setString(2, accno);
				pst.executeUpdate();
				
				
				if(amount<originalAmount)
				{
					ref=ref*113*3+2;
					PreparedStatement  pst1 =con.prepareStatement("insert into debitedamount(bank,type,accno,reference,deposit,balance,withdraw,date) values(?,?,?,?,?,?,?,?)");
					pst1.setString(1, bank);
					pst1.setString(2, type);
					pst1.setString(3, accno);
					pst1.setLong(4, ref);
					pst1.setInt(5, originalAmount);
					pst1.setInt(6, availableAmount);
					pst1.setInt(7, amount);
					pst1.setString(8, date); 
					pst1.executeUpdate();
					pst1.close();
					
				}
				pst.close();
				
			}
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
