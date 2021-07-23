package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.sql.*;

class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 617, 529);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("101acres");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(242, 57, 200, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("House Renting System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(195, 93, 300, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username : ");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(195, 258, 120, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(195, 296, 120, 16);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(284, 253, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(284, 291, 108, 27);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("Email  : ");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(217, 335, 100, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(284, 330, 238, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mobile No. :");
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(187, 373, 110, 16);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(284, 368, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("SignUp");
		lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(259, 204, 74, 27);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login();
				boolean b = true;
				String s1 = textField.getText();
                                char[] s = passwordField.getPassword();
                                String s2 = String.valueOf(s);
                                String s3 = textField_1.getText();
                                if(!s3.contains("@")) {
		        	JOptionPane.showMessageDialog(null, "Incorrect email address");
		        	log.dispose();
		        	b = false;
                                }
                                String s4 = textField_2.getText(); 
                                if(s4.length() != 10){
		        	JOptionPane.showMessageDialog(null, "Incorrect mobile number");
		        	log.dispose();
		        	b = false;
                                }
                                String s5 = textField_3.getText();
		        try{
		            Class.forName("org.sqlite.JDBC");
		            String url= "jdbc:sqlite:HRS.db";
		            Connection conn= null;
		            conn=DriverManager.getConnection(url);
		            String sql="INSERT INTO details(un,pwd,email,phno,mode) VALUES(?,?,?,?,?)";
		            PreparedStatement ps=conn.prepareStatement(sql);
		            ps.setString(1, s1);
		            ps.setString(2, s2);
		            ps.setString(3, s3);
		            ps.setString(4, s4);
		            ps.setString(5, s5);
		            ps.executeUpdate();
                            ps.close();
		            conn.close();
		        }
		        catch(Exception a){
		            System.out.print(a.getMessage());
		        }
		        if(b == true) {
		        	log.setVisible(true);
                                dispose();
		        }	
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(229, 453, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Owner / Tenant :");
		lblNewLabel_7.setBackground(Color.BLACK);
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(155, 414, 160, 16);
		contentPane.add(lblNewLabel_7);
		
		textField_3 = new JTextField();
		textField_3.setBounds(284, 406, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
