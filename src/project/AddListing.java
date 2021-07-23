package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddListing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddListing frame = new AddListing();
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
	public AddListing() {
		//Login l=new Login();
                //String usn=l.usna;
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 617, 529);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("101acres");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setBounds(238, 46, 200, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("House Renting System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(197, 74, 400, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Owner o = new Owner();
				o.setVisible(true);
                                dispose();
			}
		});
		btnNewButton.setForeground(Color.CYAN);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(6, 27, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Username : ");
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(191, 134, 100, 16);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(280, 129, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("PropertyName :");
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(170, 162, 120, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(280, 157, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Location  :");
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(197, 190, 100, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(280, 185, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Door No. StreetName :");
		lblNewLabel_5.setBackground(Color.BLACK);
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(120, 218, 300, 16);
		contentPane.add(lblNewLabel_5);
		
		textField_3 = new JTextField();
		textField_3.setBounds(280, 213, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("House Type :");
		lblNewLabel_6.setBackground(Color.BLACK);
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(181, 246, 100, 16);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(280, 241, 130, 26);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Sq.ft :");
		lblNewLabel_7.setBackground(Color.BLACK);
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(225, 274, 65, 16);
		contentPane.add(lblNewLabel_7);
		
		textField_5 = new JTextField();
		textField_5.setBounds(280, 269, 130, 26);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Rent :");
		lblNewLabel_8.setBackground(Color.BLACK);
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(225, 302, 65, 16);
		contentPane.add(lblNewLabel_8);
		
		textField_6 = new JTextField();
		textField_6.setBounds(280, 297, 130, 26);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("NearbyLocations :");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBackground(Color.BLACK);
		lblNewLabel_9.setBounds(148, 330, 200, 16);
		contentPane.add(lblNewLabel_9);
		
		textField_7 = new JTextField();
		textField_7.setBounds(280, 325, 130, 26);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                                String s=textField.getText();
                                String s1=textField_1.getText();
                                String s2=textField_2.getText();
                                String s3=textField_3.getText();
                                String s4=textField_4.getText();
                                String s5=textField_5.getText();
                                String s6=textField_6.getText();
                                String s7=textField_7.getText();
                                
				if(s.length() == 0 || s1.length() == 0 || s2.length() == 0 || s3.length() == 0 || s4.length() == 0 || s5.length() == 0 || s6.length() == 0 || s7.length() == 0) {
					JOptionPane.showMessageDialog(null, "Kindly Fill All The Field");
					
				} else {
                                    try{
                                    Class.forName("org.sqlite.JDBC");
                                    String url= "jdbc:sqlite:HRS.db";
                                    Connection conn= null;
                                    conn=DriverManager.getConnection(url);
                                    String sql="INSERT INTO listings(un,name,loc,dost,ht,sqft,rent,na) VALUES(?,?,?,?,?,?,?,?)";
                                    PreparedStatement ps=conn.prepareStatement(sql);
                                    ps.setString(1, s);
                                    ps.setString(2, s1);
                                    ps.setString(3, s2);
                                    ps.setString(4, s3);
                                    ps.setString(5, s4);
                                    ps.setString(6, s5);
                                    ps.setString(7, s6);
                                    ps.setString(8, s7);
                                    ps.executeUpdate();
                                    conn.close();
            
                                }
                                catch(Exception ex){
                                    System.out.print(ex.getMessage());
                                }
                                        Owner o = new Owner();
                                        o.setVisible(true);
                                        dispose();
				}
                        }
                         
                                
		});
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.YELLOW);
		btnNewButton_1.setBounds(238, 400, 117, 29);
		contentPane.add(btnNewButton_1);
	}
        
}
