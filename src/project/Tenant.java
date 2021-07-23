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
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tenant extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
        static String uname; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tenant frame = new Tenant();
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
        public void usr(String s) { uname = s;}
	public Tenant() throws ClassNotFoundException, SQLException {
                
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
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(233, 58, 200, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("House Renting System");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(188, 94, 300, 27);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Enter Location :");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_2.setForeground(Color.PINK);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setBounds(130, 165, 200, 16);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(251, 158, 200, 32);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Add Filters :");
		lblNewLabel_3.setForeground(new Color(51, 204, 255));
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setBounds(55, 233, 110, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Rent Budget");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setBounds(110, 261, 110, 16);
		contentPane.add(lblNewLabel_4);
		
		textField_1 = new JTextField();
		textField_1.setBounds(216, 256, 130, 26);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
                JButton apply1 = new JButton("Apply");
		apply1.setForeground(Color.YELLOW);
		apply1.setBackground(Color.BLACK);
		apply1.setBounds(362, 256, 117, 29);
		contentPane.add(apply1);
		
		JLabel lblNewLabel_5 = new JLabel("Bedroom(s)");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setBackground(Color.BLACK);
		lblNewLabel_5.setBounds(120, 305, 120, 16);
		contentPane.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(216, 300, 130, 26);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
                JButton apply2 = new JButton("Apply");
		apply2.setForeground(Color.YELLOW);
		apply2.setBackground(Color.BLACK);
		apply2.setBounds(362, 300, 117, 29);
		contentPane.add(apply2);
		
		JLabel lblNewLabel_6 = new JLabel("Nearby Attractions");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setBackground(Color.BLACK);
		lblNewLabel_6.setBounds(70, 348, 170, 16);
		contentPane.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setBounds(216, 343, 130, 26);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton apply3 = new JButton("Apply");
		apply3.setForeground(Color.YELLOW);
		apply3.setBackground(Color.BLACK);
		apply3.setBounds(362, 343, 117, 29);
		contentPane.add(apply3);
		
		JButton search = new JButton("Search");
		search.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				String s1 = textField.getText();
				if(s1.length() == 0) {
					JOptionPane.showMessageDialog(null, "Enter Location");
				} else {
                                        String loc,ht=" IS NOT NULL",rent=" IS NOT NULL",na=" IS NOT NULL";
                                        loc = s1;
                                        if (textField_1.getText().length()>0) rent = textField_1.getText();
					if (textField_2.getText().length()>0) ht = textField_2.getText();
                                        if (textField_3.getText().length()>0) na = textField_3.getText();
                                        //sql construction
                                        loc = "='" + loc.toLowerCase() + "'";
                                        if(!" IS NOT NULL".equals(ht)) ht = "='" + ht.toLowerCase() + "'";
                                        if(!" IS NOT NULL".equals(rent)) rent = "='" + rent.toLowerCase() + "'";
                                        if(!" IS NOT NULL".equals(na)) na = "='" + na.toLowerCase() + "'";
                                        String sqlquery = "SELECT * FROM listings WHERE loc"+loc+" AND ht"+ht+" AND rent"+rent+" AND na"+na+";";
                                        ViewProperty parse = new ViewProperty(sqlquery);
                                        ViewProperty view=null;
                                    try {
                                        view = new ViewProperty();
                                    } catch (ClassNotFoundException ex) {
                                        Logger.getLogger(Tenant.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                        view.setVisible(true);
                                        dispose();
				}
			}
		});
		search.setForeground(Color.GREEN);
		search.setBackground(Color.BLACK);
		search.setBounds(216, 419, 130, 29);
		contentPane.add(search);
		
		JButton logout = new JButton("Log out");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				First f = new First();
				f.setVisible(true);
                                dispose();
			}
		});
		logout.setForeground(Color.RED);
		logout.setBackground(Color.BLACK);
		logout.setBounds(456, 34, 117, 29);
		contentPane.add(logout);
	}
}
