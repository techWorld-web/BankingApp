package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deposit
 */
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Deposit() {
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
		
		int result=0;
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Bank","root","");
			if(type.equals("Deposit"))
			{
				PreparedStatement pst = con.prepareStatement("insert into deposit(name,bank_name,credit,accno,ifsc,amount,date) values(?,?,?,?,?,?,?)");
				pst.setString(1, name);
				pst.setString(2, bank);
				pst.setString(3, type);
				pst.setString(4, accno);
				pst.setString(5, ifsc);
				pst.setInt(6, amount);
				pst.setString(7, date);
				result = pst.executeUpdate();
				if(result!=0)
				{
					out.println("<h3><b><p style='color:red' align='center' margin-top:50%'>Amount Deposited Successfully,Please check your balance</p><b></h3>");
					RequestDispatcher rd=request.getRequestDispatcher("deposit.jsp");
					rd.include(request, response);
				}else {
					RequestDispatcher rd=request.getRequestDispatcher("deposit.jsp");
					out.println("Amount Deposit not successfully");
					rd.include(request, response);

				}
				pst.close();

			}
			else if(type.equals("Withdraw")) 
			{
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from deposit where accno="+accno);
				int totalAmount=0;
				int originalAmount=0;
				int ref=13;
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
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
