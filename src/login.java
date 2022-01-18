import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login {

	private JFrame frmManagementPortal;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmManagementPortal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	Connection conn = null;

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
		conn = oracleconnection.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmManagementPortal = new JFrame();
		frmManagementPortal.setTitle("Management Portal");
		frmManagementPortal.setBounds(100, 100, 450, 300);
		frmManagementPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManagementPortal.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 51, 79, 29);
		frmManagementPortal.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(114, 93, 79, 38);
		frmManagementPortal.getContentPane().add(lblNewLabel_1);
		
		JTextArea textAreausn = new JTextArea();
		textAreausn.setBounds(203, 53, 116, 22);
		frmManagementPortal.getContentPane().add(textAreausn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(203, 102, 116, 20);
		frmManagementPortal.getContentPane().add(passwordField);
		
		JButton btnlogin = new JButton("Login");
		Image img = new ImageIcon(this.getClass().getResource("/enter.png")).getImage();
		btnlogin.setIcon(new ImageIcon(img));
		btnlogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					 String query = " select * from LOGIN where username=? and password=? ";
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.setString(1, textAreausn.getText());
					 pst.setString(2, passwordField.getText());
					 
					 ResultSet rs = pst.executeQuery();
					 int count = 0;
					 while(rs.next()) {
						 count++;
					 }
					 if (count == 1) {
						 JOptionPane.showMessageDialog(null, "Username and password is correct!");
						 frmManagementPortal.dispose();
						 manageframe1 mngfr = new manageframe1();
						 mngfr.setVisible(true);
						 
					 }
					 else if (count > 1) {
						 JOptionPane.showMessageDialog(null, "Duplicate username and password!");
					 }
					 else {
						 JOptionPane.showMessageDialog(null, "Username or password is not correct!");
					 }
					 
			         rs.close();
			         pst.close();
			        }catch (Exception e) {
			            JOptionPane.showMessageDialog(null, e);
			            
			        }
				
				
			}
		});
		btnlogin.setBounds(224, 160, 89, 23);
		frmManagementPortal.getContentPane().add(btnlogin);
		
		JLabel lblNewLabelicon = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabelicon.setIcon(new ImageIcon(img1));
		lblNewLabelicon.setBounds(10, 58, 99, 95);
		frmManagementPortal.getContentPane().add(lblNewLabelicon);
	}
}
