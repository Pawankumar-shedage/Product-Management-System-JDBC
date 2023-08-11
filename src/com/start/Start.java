package com.start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.entity.Product;
import com.productDao.ProductDao;



public class Start {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to your Product Magement System.");
		
		BufferedReader read_input = new BufferedReader(new InputStreamReader(System.in));
		
		boolean go =true;
		
		while(go)
		{
			System.out.println("\nPress 1 to ADD a new Product\n"
					+ "Press 2 to DELETE a Product\n"
					+ "Press 3 to DISPLAY a Product\n"
					+ "Press 4 to Update a Product\n"
					+ "Press 5 to Search a Product\n"
					+ "Press 6 to Count total products in the list\n"
					+ "Press 7 to Display Records in descending order!\n"
					+ "Press 8 for LIKE Operator\n"
					+ "Press 9 to EXIT APPLICATION\n\n");
			
			
			int choice = Integer.parseInt(read_input.readLine());
			
			//Switch case to choose cases
			switch (choice)
			{
			case 1: //insert
				System.out.println("Enter Product ID");
				int  prod_id = Integer.parseInt(read_input.readLine());
				
				System.out.println("Enter Product Name");
				String prod_name = read_input.readLine();
				
				System.out.println("Enter Product price (Rs)");
				double prod_price = Double.parseDouble(read_input.readLine());
				
				System.out.println("Enter Product Quantity");
				String quantity = read_input.readLine();
				
				//Prod Obj
				Product pr1 = new Product(prod_id,prod_name,prod_price,quantity);
				
				boolean f = ProductDao.insertProduct(pr1);
				
				if(f)System.out.println("Product added successfully.");
				else System.out.println("Something went wrong please try again.");
				
				break;
				
			case 2: //delete
				
				System.out.println("Enter Product Id, to delete the product.");
				int id  = Integer.parseInt(read_input.readLine());
				
				boolean f2 = ProductDao.deleteProduct(id);
				
				if(f2)
				{
					System.out.println("Product with ID "+ id +" deleted Successfully");
				}
				else {
					System.out.println("Something terribly went wrong.");
				}
				
				
				break;
				
			
			case 3:	//Display product table
				
				boolean f3 = ProductDao.displayProducts();
				
				//To add conditons, for empty table-> then to display msg...???
				
				if(f3)
				{
					System.out.println("\nProducts details fetched successfully.");
				}
				else System.out.println("Sorry please try again.");
				
				break;
				
			case 4:	 //Update Product
				
				System.out.println("Enter Product Id which you want to update");
				int old_id = Integer.parseInt(read_input.readLine());
				
				//Enter new details id,name,price and quantity.
				System.out.println("Enter Product ID, Product Name, Product Price, Product Quantity");
				
				int new_id = Integer.parseInt(read_input.readLine());
				String new_name = read_input.readLine();				
				double new_price = Double.parseDouble(read_input.readLine());
				String new_quantity = read_input.readLine();
				
				Product updt_prod = new Product(new_id,new_name, new_price,new_quantity);
				
				boolean upd = ProductDao.updateProduct(updt_prod, old_id);
				
				if(upd)System.out.println("Product Updated Successfully.");
				else System.out.println("Please check inserted details and try again.");
				
				break;
				
			case 5:
				break;
				
			case 6:
				break;
				
				
			case 9:
				go =false;
				System.out.println("\nThank you for using my Application!! \n");				
				break;
				
				
				default:{
					System.out.println("Wrong choice pls re-enter your choice");
				}
			}
			
			
			
			
			
			
		}
	
		
	}
}
