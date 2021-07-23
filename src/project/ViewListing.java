package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
import java.sql.Statement;


public class ViewListing extends JFrame {

	static String username2;
        private JPanel contentPane;
        
        ViewListing(String st) { username2 = new String(st); }


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewListing frame = new ViewListing();
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
	public ViewListing() {
                String vname=null,vloc=null,vdost=null,vht=null,vsqft=null,vrent=null,vna=null;
                try{                                    
                    //ResultSet r1=null;
                    Class.forName("org.sqlite.JDBC");
                    String url= "jdbc:sqlite:HRS.db";
                    Connection conn=DriverManager.getConnection(url);
                    Statement st = conn.createStatement();
                    //st.setString(1,username2);
                    
                    ResultSet r1=st.executeQuery("SELECT * FROM listings WHERE un='"+username2+"';");
                    //conn.close();
                    while(r1.next()){
                        vname=r1.getString("name");
                        vloc=r1.getString("loc");
                        vdost=r1.getString("dost");
                        vht=r1.getString("ht");
                        vsqft=r1.getString("sqft");
                        vrent=r1.getString("rent");
                        vna=r1.getString("na");
                    }
                    conn.close();
                }
                catch(Exception ex){
                    System.out.print(ex.getMessage());
                }
                
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
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(237, 55, 200, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("House Renting System");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(196, 85, 300, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("View your Listing");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setForeground(Color.PINK);
		lblNewLabel_1_1.setBounds(237, 124, 200, 21);
		contentPane.add(lblNewLabel_1_1);
		
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
		lblNewLabel_2.setBounds(196, 209, 100, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel un = new JLabel(username2);
		un.setForeground(Color.GREEN);
		un.setBackground(Color.BLACK);
		un.setBounds(289, 209, 141, 16);
		contentPane.add(un);
		
		JLabel lblNewLabel_3 = new JLabel("PropertyName :");
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(166, 237, 120, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel own = new JLabel(vname);
		own.setBackground(Color.BLACK);
		own.setForeground(Color.GREEN);
		own.setBounds(289, 237, 228, 16);
		contentPane.add(own);
		
		JLabel lblNewLabel_4 = new JLabel("Location  :");
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setBounds(202, 265, 100, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel loc = new JLabel(vloc);
		loc.setForeground(Color.GREEN);
		loc.setBackground(Color.BLACK);
		loc.setBounds(289, 265, 141, 16);
		contentPane.add(loc);
		
		JLabel lblNewLabel_5 = new JLabel("DoorNo. StreetName :");
		lblNewLabel_5.setBackground(Color.BLACK);
		lblNewLabel_5.setForeground(Color.RED);
		lblNewLabel_5.setBounds(129, 293, 210, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel dnoSt = new JLabel(vdost);
		dnoSt.setForeground(Color.GREEN);
		dnoSt.setBackground(Color.BLACK);
		dnoSt.setBounds(289, 293, 322, 16);
		contentPane.add(dnoSt);
		
		JLabel lblNewLabel_6 = new JLabel("House Type :");
		lblNewLabel_6.setBackground(Color.BLACK);
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setBounds(186, 321, 100, 16);
		contentPane.add(lblNewLabel_6);
		
		JLabel hType = new JLabel(vht);
		hType.setForeground(Color.GREEN);
		hType.setBackground(Color.BLACK);
		hType.setBounds(289, 321, 141, 16);
		contentPane.add(hType);
		
		JLabel lblNewLabel_7 = new JLabel("Sq.ft :");
		lblNewLabel_7.setBackground(Color.BLACK);
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(228, 349, 60, 16);
		contentPane.add(lblNewLabel_7);
		
		JLabel sqft = new JLabel(vsqft);
		sqft.setForeground(Color.GREEN);
		sqft.setBackground(Color.BLACK);
		sqft.setBounds(289, 349, 141, 16);
		contentPane.add(sqft);
		
		JLabel lblNewLabel_8 = new JLabel("Rent :");
		lblNewLabel_8.setBackground(Color.BLACK);
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(228, 377, 60, 16);
		contentPane.add(lblNewLabel_8);
		
		JLabel rent = new JLabel(vrent);
		rent.setForeground(Color.GREEN);
		rent.setBackground(Color.BLACK);
		rent.setBounds(289, 377, 61, 16);
		contentPane.add(rent);
		
		JLabel lblNewLabel_9 = new JLabel("NearbyLocations :");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBackground(Color.BLACK);
		lblNewLabel_9.setBounds(153, 404, 200, 16);
		contentPane.add(lblNewLabel_9);
		
		JLabel na = new JLabel(vna);
		na.setForeground(Color.GREEN);
		na.setBackground(Color.BLACK);
		na.setBounds(289, 404, 100, 16);
		contentPane.add(na);
		
	}

}
