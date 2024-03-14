package com.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

public class ProductListForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductListForm frame = new ProductListForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductListForm() {
		setTitle("Product List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 74, 507, 275);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Name", "Company", "Price"
			}
		));
		scrollPane.setViewportView(table);
		
		displayData();
	}
	
	//display data in jtable
	private void displayData() {
		
		ProductService  ps = new  ProductServiceImpl();
		List<Product>  plist = ps.getAllProducts();
		
		   DefaultTableModel  tmodel = (DefaultTableModel) table.getModel();
		   tmodel.setRowCount(0);//reset table
		   
		   for(Product p : plist) {
			   tmodel.addRow(new Object[] {p.getId(), p.getName(),p.getCompany(),p.getPrice()});
		   }
		
	}
	
}
