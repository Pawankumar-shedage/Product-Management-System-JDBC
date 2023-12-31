package com.productDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;

import com.entity.Product;

public class ProductDao {
	
	//DAO - Data Access Object.
	
	//Insert.
	public static boolean insertProduct(Product prod) 
	{
		boolean flag = false;
		
		try{
			Connection connect = ConnectionJDBC.create_connection();
			String query = "Insert into product(prod_id, prod_name, prod_price, prod_quantity) values(?,?,?,?);";
			
			PreparedStatement s = connect.prepareStatement(query);
			
			s.setInt(1, prod.getProd_id());
			s.setString(2, prod.getProd_name());
			s.setDouble(3, prod.getProd_price());
			s.setString(4, prod.getProd_quantity());
			
			s.executeUpdate();
			flag = true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
	
	//Delete
	public static boolean deleteProduct(int  id)
	{
		boolean f = false;
		
		try {
			Connection connect = ConnectionJDBC.create_connection();
			String query = "delete from product where prod_id = ?;";
			PreparedStatement p = connect.prepareStatement(query);
			
			p.setInt(1, id);
			
			p.executeUpdate();		
			
			f =true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	// case 3 Display
	public static boolean displayProducts()
	{
		boolean f = false;
			//here user input is not required.
		
		try {
			Connection conn = ConnectionJDBC.create_connection();
			
			String query = "select * from product;";
				
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			//iterating result set for each entry in the table.
			while(rs.next())
			{	
				int id = rs.getInt("prod_id");
				String prod_name = rs.getString("prod_name");
				double price = rs.getDouble("prod_price");
				String quant = rs.getString("prod_quantity");
				
				//%s String specifier, we are displaying data as a string.
				System.out.format("%s, %s, %s, %s\n",id, prod_name,price,quant);
			}
			
			//Imp to close the statement.
			st.close();
			
			//imp to set f = true;
			f = true;
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	//case 4 Update product 
	public static boolean updateProduct(Product prod, int old_id)
	{
		boolean f = false;
		
		try {
			Connection conn = ConnectionJDBC.create_connection();
			
			String query = "update product set prod_id = ?, prod_name= ?, prod_price= ?, prod_quantity= ? where prod_id = ? ;";
			
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setInt(1, prod.getProd_id());
			p.setString(2, prod.getProd_name());
			p.setDouble(3, prod.getProd_price());
			p.setString(4, prod.getProd_quantity());
			
			//old id
			p.setInt(5, old_id);
			
			p.executeUpdate();
			
			f =true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	
	//case 5 Search by id
	public static boolean searchProduct(int id)
	{
		boolean f = false;
		
		try {
			Connection conn = ConnectionJDBC.create_connection();
			
			String query = "select * from product where prod_id = ?";
			
			PreparedStatement p = conn.prepareStatement(query);
			p.setInt(1, id);
			
			ResultSet rs = p.executeQuery();
			while(rs.next())
			{
				int prdID = rs.getInt("prod_id"); 
				String prdName = rs.getString("prod_name");
				double prod_price =rs.getDouble("prod_price");
				String prod_quant = rs.getString("prod_quantity");
				
				
				System.out.format("%s,%s,%s,%s\n",prdID, prdName, prod_price, prod_quant);
			}
			
			p.close();

			f = true; 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	
	//Count Products.
	public static boolean countTotalProducts()
	{
		boolean f = false;
		
		try {
			Connection conn = ConnectionJDBC.create_connection();
			
			String query = "select count(*) from product;";
			
			PreparedStatement p = conn.prepareStatement(query);

			
			ResultSet rs  =p.executeQuery();
			
			while(rs.next())
			{
				int id = rs.getInt(1);
				
				//%s string specifier
				System.out.format("%s", id + "\n");
			}
			
			
			p.close();
			f = true; 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	//case 7 desc order display of records
	public static boolean dispProductDesc()
	{
		boolean f = false;
		try {
			Connection conn = ConnectionJDBC.create_connection();
			
			String query = "select * from product ORDER BY prod_id DESC;";
			
			Statement s = conn.createStatement(); 
			ResultSet rs = s.executeQuery(query);
			
			while(rs.next())
			{
				int id  = rs.getInt("prod_id");
				String name = rs.getString("prod_name");
				double price = rs.getDouble("prod_price");
				String quant = rs.getString("prod_quantity");
				
				System.out.format("%s, %s, %s, %s \n", id+" ",name+" ",price+" ",quant+" " , "\n");
				
			}
			
			s.close();
			
			f=true;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
	
	//Case 8: Like Operator Wild card for records, return records with similar patter
				//Pattern-> "% ", "_r", "r%", secondLast character "%a_"
	
	public static boolean likePattern(String ch)
	{
		boolean f =false;
		try {
			Connection conn = ConnectionJDBC.create_connection();
			
//			String query = "select * from product where (prod_name LIKE '?%' OR prod_name LiKE '%?');";
			String query = "select * from product where prod_name OR prod_id LIKE ?;";
			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(1, "%"+ ch + "%");
			
			//for printing the record resultSet is used to iterate and print✨✨
			ResultSet rs = p.executeQuery();
			while(rs.next())
			{
				
				int id  = rs.getInt("prod_id");
				String name = rs.getString("prod_name");
				double price = rs.getDouble("prod_price");
				String quant = rs.getString("prod_quantity");
				
				System.out.format("%s, %s, %s, %s \n", id+" ",name+" ",price+" ",quant+" " , "\n");
				
			}
			f = true;
			
//			f = false;
			
			rs.close();
			p.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return f;
	}
	
//--------------------------------------------------------------------------------
	
	
}
