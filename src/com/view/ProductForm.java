package com.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.model.Product;
import com.service.ProductService;
import com.service.ProductServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameTxt;
	private JTextField priceTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductForm frame = new ProductForm();
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
	public ProductForm() {
		setTitle("ProductForm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 506);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(146, 114, 46, 14);
		contentPane.add(lblNewLabel);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(238, 96, 248, 51);
		contentPane.add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Company");
		lblNewLabel_1.setBounds(146, 177, 79, 25);
		contentPane.add(lblNewLabel_1);
		
		JComboBox companyCmb = new JComboBox();
		companyCmb.setModel(new DefaultComboBoxModel(new String[] {"select", "DELL", "SAMSUNG", "CG", "ACER", "GS"}));
		companyCmb.setBounds(238, 168, 248, 43);
		contentPane.add(companyCmb);
		
		JLabel lblNewLabel_2 = new JLabel("Price");
		lblNewLabel_2.setBounds(146, 240, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		priceTxt = new JTextField();
		priceTxt.setBounds(238, 222, 248, 51);
		contentPane.add(priceTxt);
		priceTxt.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product p = new Product();
				
				p.setName(nameTxt.getText());
				p.setCompany(companyCmb.getSelectedItem().toString());
				p.setPrice(Integer.parseInt(priceTxt.getText()));
				
				ProductService  ps = new ProductServiceImpl();
				ps.addProduct(p);
				
				JOptionPane.showMessageDialog(null, "added success");
				
			}
		});
		btnNewButton.setBounds(280, 293, 158, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Product Detials");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblNewLabel_3.setBounds(179, 24, 320, 51);
		contentPane.add(lblNewLabel_3);
	}
}
