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
				//to add exception of id not present....
				
				if(f2)
				{
					System.out.println("Product with ID "+ id +" deleted Successfully");
				}
				else {
					System.out.println("Something terribly went wrong.");
				}
				
				
				break;
				
			
			case 3:	//Display product table
				
				System.out.println("Product ID |  Product Name  | Product Price  | Product Quantiy \n");
				
				boolean f3 = ProductDao.displayProducts();
				
				//To add conditons, for empty table-> then to display msg...???
				
				if(f3)
				{
					System.out.println("\nProduct details fetched successfully.");
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
				
				
				//
				System.out.println("Updated Product: " + updt_prod);
				break;
				
			case 5: //Search.
				System.out.println("Enter student id which you want to search.");
				
				int searchID = Integer.parseInt(read_input.readLine());
				
				
				boolean search = ProductDao.searchProduct(searchID);
				
				if(search)
				{
					System.out.println("Product is present");
				}
				else
				{
					System.out.println("No results found.");
				}
				
				break;
				
			case 6: //Count the products.
				
				System.out.print("Total Products: ");
				boolean count = ProductDao.countTotalProducts();
				
				if(!count) System.out.println("Something went wrong.");
				
				break;
				
			case 7: //Display records in DESC Order
				
				System.out.println("Product ID |  Product Name  | Product Price  | Product Quantiy \n");
				
				boolean desc = ProductDao.dispProductDesc();
				if(!desc) System.out.println("Some issues encountered!");
				
				break;
				
			case 8: //Like Operator.
				
				//char inp = Character.parse  //to set ch
				
				System.out.println("Enter chars to find match in Product Name\n");
				String ch = read_input.readLine();
				boolean likeOp = ProductDao.likePattern(ch);
				
				if(!likeOp) System.out.println("No Matches found.");
				
				//To add error handling for false result.
				
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
