package project;

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
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.*;

public class Owner extends JFrame {

	static String username1;
        Owner(String s) { username1 = new String(s); }
        private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Owner frame = new Owner();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Owner() {
                
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 617, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("101acres");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 35));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(234, 78, 200, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("House Renting System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(200, 111, 370, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hey Owner!");
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setBounds(200, 204, 200, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Select your function");
		lblNewLabel_3.setForeground(Color.PINK);
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(234, 237, 200, 21);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Add Listing");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{                                    
                                    Class.forName("org.sqlite.JDBC");
                                    String url= "jdbc:sqlite:HRS.db";
                                    Connection conn= DriverManager.getConnection(url);;           
                                    Statement st = conn.createStatement();
                                    ResultSet r1=st.executeQuery("SELECT * FROM listings WHERE un='"+username1+"';");
                                    conn.close();
                                    if(r1.next()){
                                        JOptionPane.showMessageDialog(null, "Your username already enrolled in listing! ");
                                    }
                                    else{
                                        AddListing add=new AddListing();
                                        add.setVisible(true);
                                        dispose();
                                    }
                                }
                                catch(Exception ex){
                                    System.out.print(ex.getMessage());
                                }
                        }   
		});
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(200, 284, 200, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Listing");
                btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                            //new dellisting().del(username1);
                            int xv=0;
                            try{                                    
                                        Class.forName("org.sqlite.JDBC");
                                        String url1= "jdbc:sqlite:HRS.db";
                                        Connection conn1= DriverManager.getConnection(url1);
                                        String sql="DELETE FROM listings WHERE un='"+username1+"';";
                                        Statement st1 =conn1.createStatement();
                                        //st1.setString(1,username1);
                                        xv = st1.executeUpdate(sql);
                                        conn1.close();
                                        if(xv==1){
                                        JOptionPane.showMessageDialog(null, " Your listing DELETED successfully! ");
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, " Add a listing first! ");
                                        }
                                }
                                catch(Exception ex){
                                   System.out.print(xv+" del "+ex.getMessage());
                                }
                        }
		});
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setBounds(200, 322, 200, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Listing");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                                try{                                    
                                    Class.forName("org.sqlite.JDBC");
                                    String url= "jdbc:sqlite:HRS.db";
                                    Connection conn= null;
                                    conn=DriverManager.getConnection(url);
                                    Statement st = conn.createStatement();
                                    ResultSet r1=st.executeQuery("SELECT * FROM listings WHERE un='"+username1+"';");
                                    conn.close();
                                    if(r1.next()){
                                        ViewListing v=new ViewListing(username1);
                                        ViewListing view=new ViewListing();
                                        view.setVisible(true);
                                        dispose();
                                    }
                                    else{
                                       JOptionPane.showMessageDialog(null, " Add a listing first! "); 
                                    }
                                    conn.close();
                                }
                                catch(Exception ex){
                                    System.out.println(ex.getMessage());
                                }
				              
				
			}
		});
		btnNewButton_2.setForeground(Color.MAGENTA);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(200, 363, 200, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Log Out");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				First f = new First();
				f.setVisible(true);
                                dispose();
				
			}
		});
		btnNewButton_3.setForeground(Color.YELLOW);
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setBounds(220, 439, 125, 29);
		contentPane.add(btnNewButton_3);
	}
}
