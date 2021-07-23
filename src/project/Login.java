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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import javax.swing.JDialog;



public class Login extends JFrame {

	public String usna;
        private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	//public login(String s){
        //    usna=new String(s);
        //}
        
        
        public Login() {
                
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
		lblNewLabel.setBounds(241, 47, 200, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("House Renting System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBounds(200, 82, 310, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(269, 232, 100, 27);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Username : ");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(184, 285, 100, 16);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(279, 280, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Password : ");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(184, 323, 100, 16);
		contentPane.add(lblNewLabel_4);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(289, 318, 111, 26);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e){
                                ResultSet r1=null,r2=null;
                                usna=textField.getText();
                                String pass=new String(passwordField.getPassword());
                                    try{
                                    Class.forName("org.sqlite.JDBC");
                                    String url= "jdbc:sqlite:HRS.db";
                                    Connection conn= null;
                                    conn=DriverManager.getConnection(url);
                                    PreparedStatement st = conn.prepareStatement("select * from details where un=? AND pwd=?");
                                    st.setString(1,usna);
                                    st.setString(2,pass);
                                    r1=st.executeQuery();
                                    if(r1.next()){
                                        String mode;
                                        mode = r1.getString("mode");
                                        if("Owner".equals(mode)){
                                            Owner ow=new Owner(usna);
                                            Owner o=new Owner();
                                            o.setVisible(true);
                                            dispose();
                                        }
                                        else if("Tenant".equals(mode)){
                                            new Tenant().usr(usna);
                                            Tenant t=new Tenant();
                                            t.setVisible(true);
                                            dispose();
                                        }
                                        
                                    }
                                    conn.close();
                                    }
                                catch(Exception ex){
                                    System.out.print(ex.getMessage());
                                }
                                                                        
                                
                                
                                	
			}
		});
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBounds(241, 373, 117, 29);
		contentPane.add(btnNewButton);
	}
}
