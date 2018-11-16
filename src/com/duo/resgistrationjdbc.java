package com.duo;

import java.awt.FlowLayout;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.Registration;

import com.model.login;
import com.model.registration;
import com.sun.prism.paint.Color;




public class resgistrationjdbc {

	Connection con;
	PreparedStatement ps,ps1,ps2;
	ResultSet rs;
	int i;
	int newCost;
	
	
	
	public Connection myConnection(){
		//1.load driver
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","System","wuser123");
			System.out.println("Connection to db..");
		} catch (ClassNotFoundException e) {
			
		} catch (SQLException e) {
			
		}
		return con;
	}
	public int saveData(List<registration> lst){
		
		
		registration r = (registration)lst.get(0);
		try {
			con=myConnection();
			ps=con.prepareStatement("insert into Register values(?,?,?,?,?)");
			ps.setString(1, r.getUsername());
			ps.setString(3, r.getEmail());
			ps.setString(2, r.getPassword());
			ps.setLong(4, r.getPhoneNO());
			ps.setInt(5,r.getCost() );
			i = ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}
		catch(Exception e){
			
		}
		return i;
	}
public boolean Payment(String name ){
	/*registration r = (registration)lst.get(0);*/
	boolean temp = true;
	try {
		con=myConnection();
		ps=con.prepareStatement("select cost from register where username=?");
		ps.setString(1, name);
		rs = ps.executeQuery();
		
		registration r = new registration();
		while(rs.next()) {
			r.setCost(rs.getInt(1));
			int j =r.getCost();
			System.out.println(j);
			if(r.getCost()>1000) {
			newCost=j-1500;
			r.setCost(newCost);
			System.out.println(r.getCost());
			ps1=con.prepareStatement("update register set cost= ? where username= ? ");
			ps1.setInt(1, r.getCost());
			ps1.setString(2, name);
			ps1.executeQuery();
		}
			
			else{
			return temp=false;
			}
				
		}
		try {
			ps2=con.prepareStatement("insert into bill values(?,1500)");
			ps2.setString(1, name);
		
			ps2.executeQuery();
		} catch (SQLException e) {
			
		}
			
	}catch(Exception e)
	{
		System.out.println("failed");
	}
	
	return temp;
}
public ArrayList<registration> bill(String name){
	
	ArrayList<registration> list = new ArrayList<registration>();
	String sql = "SELECT * FROM bill where username= ?";
	 try {
	PreparedStatement st = con.prepareStatement(sql);
	st.setString(1, name);
	 ResultSet rs = st.executeQuery();
	 while(rs.next()) {
		 login l = new login();
	registration r = new registration(l);
	r.setUsername(rs.getString(1));
	r.setCost(rs.getInt(2));
	list.add(r);
	 }
	} catch (SQLException e) {
	
	}
	
	return list;
	
}
	
	
	public Boolean validateData(List<registration> lst) {
		
		registration r = (registration)lst.get(0);
		Boolean temp=false;
		try {
			con=myConnection();
			ps=con.prepareStatement("select * from Register");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
			if(rs.getString(1).equals(r.getUsername()) && rs.getString(2).equals(r.getPassword())){
				temp=true;
				break;
			}
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return temp;
	}
	
	
	public List<registration> getAllData()
	{
		List<registration> lst=new LinkedList<registration>();
		con=myConnection();
		try
		{
		Statement s=
					con.createStatement
					(ResultSet.TYPE_SCROLL_SENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
			rs=s.executeQuery("select * from Register");
			while(rs.next())
			{
				registration a=new registration();
				
				a.setUsername(rs.getString(1));
				a.setEmail(rs.getString(2));
				a.setPassword(rs.getString(3));
				a.setPhoneNO(rs.getLong(4));
//				a.setBal(rs.getDouble(4));
				lst.add(a);
				System.out.println("cnt");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return lst;
	}
		
	public String billHTML(String name) {
		con=myConnection();

	    StringBuilder sb = new StringBuilder();
	    sb.append("<html>"
	            + "<style type='text/css'>"
	            + "body, h1, th, td {"
	            + "  font-family: Serif;"
	            + "  font-size: 12pt;"
	            + "}"
	            + "h1 {"
	            + "  font-size: 20pt;"
	            + "}"
	            + "table {"
	            //+ "  border-collapse: collapse;"
	            //+ "  border-style: none;"
	            + "}"
	            + "td, th {"
	            //+ "  border: thin solid gray;"
	            + "}"
	            + "th {"
	            + "  border-bottom: thin solid gray;"
	            + "}"
	            + ".overline td {"
	            + "  border-top: thin solid gray;"
	            + "}"
	            + "</style>"
	            + "<body>");
	    sb.append("<h1>- BILL -</h1>");
	   
	    try  
	    {
	    	 String sql = "SELECT * FROM bill where username= ?";
	    	 PreparedStatement st = con.prepareStatement(sql);
	    	st.setString(1, name);
	        ResultSet rs = st.executeQuery();
	        {
	            sb.append("<table width='650' cellspacing='0'>"
	                    + "<tr>"
	                    + "<th width='50%' align='left'>Item</th>"
	                    + "<th width='30%' align='right'>Amount</th>"
	                    + "</tr>");
	            int total = 0;
	            while (rs.next()) {
	                sb.append("<tr>"
	                        + "<td>")
	                    .append(rs.getString("username"))
	                    .append("</td>"
	                        + "<td align='right'>")
	                    .append(formatInt(rs.getInt("cost")))
	                    .append("</td>"
	                        + "<td align='right'>")
	                    .append("</td>"
	                        + "</tr>");
	                total += rs.getInt("cost");
	            }
	            sb.append("<tr class='overline'>"
	                    + "<td>&nbsp;")
	                .append("</td>"
	                    + "<td align='right'>")
	                .append("Total")
	                .append("</td>"
	                    + "<td align='right'>")
	                .append(formatAmount(total))
	                .append("</td>"
	                    + "</tr>"
	                + "</table>");
	        }
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return sb.toString();
	}
		
	private static String formatInt(int amount) {
	    return new MessageFormat("{0,number}").format(new Object[]{amount});
	}

	private static String formatAmount(int amount) {
	    return new MessageFormat("{0,number,currency}").format(new Object[]{amount})
	        .replace(' ', '\u00a0');
	}
}




