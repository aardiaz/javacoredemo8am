package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductServiceImpl implements ProductService {
	
	 static List<Product>  plist  = new ArrayList<>();

	@Override
	public void addProduct(Product pd) {
		
	    try {
			 
			Class.forName("");
			//getConnection()
			
		  String sql = "insert into product(name,price)values('"+pd.getName()+"','"+pd.getPrice()+"')";	
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		plist.add(pd);
//		System.out.println("------success-----size = "+plist.size());
	}

	@Override
	public void deleteProduct(int index) {
		 
		
		//plist.remove(index);
	}

	@Override
	public List<Product> getAllProducts() {
		
		List<Product>  prodlist = new ArrayList<>();
		
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "1234");
				
				String sql = "select * from product";
				Statement stm = con.createStatement();
				ResultSet  rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					
					Product p = new Product();
					
					p.setId(rs.getInt("id"));
					p.setName(rs.getString("name"));
					p.setPrice(rs.getInt("price"));
					p.setCompany(rs.getString("company"));
					
					prodlist.add(p);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return prodlist;
	}
	
}
