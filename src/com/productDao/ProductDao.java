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
			Connection connect = ConnectionJDBC.creat_connection();
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
			Connection connect = ConnectionJDBC.creat_connection();
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
	
	
	//Display
	public static boolean displayProducts()
	{
		boolean f = false;
			//here user input is not required.
		
		try {
			Connection conn = ConnectionJDBC.creat_connection();
			
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
				System.out.format("%s,%s,%s,%s\n",id, prod_name,price,quant);
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
	
	
	//Update product case 4
	public static boolean updateProduct(Product prod, int old_id)
	{
		boolean f = false;
		
		try {
			Connection conn = ConnectionJDBC.creat_connection();
			
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
	
	
	
	
	
	
	
}
