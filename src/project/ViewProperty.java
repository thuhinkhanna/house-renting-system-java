package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

class listing {
    	String un,name,loc,dost,ht,sqft,rent,na;
        listing initf(String un,String name,String loc,
                String dost,String ht,String sqft,String rent,String na) {
            listing x = new listing();
            x.un = un;
            x.name = name;
            x.loc = loc;
            x.dost = dost;
            x.ht = ht;
            x.sqft = sqft;
            x.rent = rent;
            x.na = na;
            return x;
        }
        String listmake() {
            if(this.un.length()>0){String c = this.ht + " property available to rent in " + this.name + " \n " +
                 this.dost + this.loc + " \n " + " area: " + this.sqft + " \t " + " rent: " + this.rent;
            return c; }
            return "<empty :-)>";
        }
}

public class ViewProperty extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProperty frame = new ViewProperty();
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
        static String sqlquery;
        public ViewProperty(String s) {sqlquery = s;}
	public ViewProperty() throws ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 1000, 1000);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("101acres");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 34));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(450, 58, 200, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("House Renting System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(400, 94, 300, 27);
		contentPane.add(lblNewLabel_1);
		
		JButton back = new JButton("Back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tenant t = null;
                            try {
                                t = new Tenant();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(ViewProperty.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (SQLException ex) {
                                Logger.getLogger(ViewProperty.class.getName()).log(Level.SEVERE, null, ex);
                            }
				t.setVisible(true);
                                dispose();
			}
		});
		back.setForeground(Color.CYAN);
		back.setBackground(Color.BLACK);
		back.setBounds(28, 31, 117, 29);
		contentPane.add(back);
		
		/*JButton next = new JButton("Next");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewMore view = new ViewMore();
				view.setVisible(true);
                    }
		});
		next.setForeground(Color.CYAN);
		next.setBackground(Color.BLACK);
		next.setBounds(469, 31, 117, 29);
		contentPane.add(next); */
                int count = 0;
                listing[] m = new listing[3];
                m[0]=null;
                m[1]=null;
                m[2]=null;
                try{
            Class.forName("org.sqlite.JDBC");
            String url= "jdbc:sqlite:HRS.db";
            Connection con = DriverManager.getConnection(url);
            Statement s = con.createStatement();
            boolean results = s.execute(sqlquery);
            //Loop through result sets.
            do {
                if(results) {
                ResultSet rs = s.getResultSet();
                while (rs.next() && count <3) {
                System.out.println(rs.getString("un"));
                m[count] = new listing().initf(rs.getString("un"),rs.getString("name"),
                        rs.getString("loc"),rs.getString("dost"),
                        rs.getString("ht"),rs.getString("sqft"),
                        rs.getString("rent"),rs.getString("na"));
                count++;
                }
                rs.close();
                }
                System.out.println();
                results = s.getMoreResults();
            } while(results);
            s.close();
        }catch(SQLException e){
            System.out.print(e.getMessage());
        }
                System.out.println(count);
                switch(count){
                    case 3:    {JLabel rone = new JLabel(m[2].listmake());
                rone.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		rone.setForeground(Color.LIGHT_GRAY);
		rone.setBackground(Color.DARK_GRAY);
		rone.setBounds(28, 370, 1200, 91);
		contentPane.add(rone);}
		
                    case 2: {JLabel rtwo = new JLabel(m[1].listmake());
		rtwo.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		rtwo.setForeground(Color.LIGHT_GRAY);
                rtwo.setBackground(Color.DARK_GRAY);
		rtwo.setBounds(28, 267, 1200, 91);
		contentPane.add(rtwo);}
		
                    case 1: {JLabel rthree = new JLabel(m[0].listmake());
		rthree.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		rthree.setForeground(Color.LIGHT_GRAY);
                rthree.setBackground(Color.DARK_GRAY);
		rthree.setBounds(28, 164, 1200, 91);
		contentPane.add(rthree);}
                    break;
                    default:{JLabel rxero = new JLabel("No Records Found, Try Agian...");
		rxero.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		rxero.setForeground(Color.LIGHT_GRAY);
                rxero.setBackground(Color.DARK_GRAY);
		rxero.setBounds(28, 164, 1200, 91);
		contentPane.add(rxero);}
                        
                    
	}
}   
}
