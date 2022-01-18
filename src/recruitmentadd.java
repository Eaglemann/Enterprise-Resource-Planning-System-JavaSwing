import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import java.sql.*;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class recruitmentadd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recruitmentadd frame = new recruitmentadd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;

	/**
	 * Create the frame.
	 */
	public recruitmentadd() {
		setResizable(false);
		setTitle("RECRUITMENT AGENCY EDIT DATA");
		conn = oracleconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1122, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AGENCY ID");
		lblNewLabel.setBounds(51, 137, 75, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblAagencyName = new JLabel("AGENCY NAME");
		lblAagencyName.setBounds(51, 181, 93, 33);
		contentPane.add(lblAagencyName);
		
		JLabel lblContactName = new JLabel("CONTACT NAME");
		lblContactName.setBounds(51, 225, 93, 33);
		contentPane.add(lblContactName);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setBounds(51, 269, 85, 33);
		contentPane.add(lblGender);
		
		JLabel lblJobTitle = new JLabel("JOB TITLE");
		lblJobTitle.setBounds(51, 313, 75, 33);
		contentPane.add(lblJobTitle);
		
		JLabel lblMobile = new JLabel("MOBILE");
		lblMobile.setBounds(51, 357, 75, 33);
		contentPane.add(lblMobile);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(51, 401, 75, 33);
		contentPane.add(lblEmail);
		
		JLabel lblWebAddress = new JLabel("WEB ADDRESS");
		lblWebAddress.setBounds(51, 445, 75, 33);
		contentPane.add(lblWebAddress);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(180, 141, 193, 22);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(180, 185, 193, 22);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(180, 229, 193, 22);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(180, 273, 193, 22);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(180, 317, 193, 22);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(180, 361, 193, 22);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(180, 405, 193, 22);
		contentPane.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(180, 449, 193, 22);
		contentPane.add(textArea_7);
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " insert into RECRUITMENT_AGENCIES (AGENCY_ID, AGECNY_NAME, CONTACT_NAME, CONTACT_GENDER_MF, CONTACT_JOB_TITLE, CELL_MOBILE_PHONE, EMAIL_ADDRESS, WEB_ADDRESS) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.setString(1, textArea.getText());
					 pst.setString(2, textArea_1.getText());
					 pst.setString(3, textArea_2.getText());
					 pst.setString(4, textArea_3.getText());
					 pst.setString(5, textArea_4.getText());
					 pst.setString(6, textArea_5.getText());
					 pst.setString(7, textArea_6.getText());
					 pst.setString(8, textArea_7.getText());
					
					 
					 pst.executeQuery();
					 
					 JOptionPane.showMessageDialog(null, "Data Added");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
				
				
			}
		});
		btnNewButton.setBounds(802, 142, 100, 39);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " Update RECRUITMENT_AGENCIES set AGENCY_ID='"+textArea.getText()+"', AGECNY_NAME='"+textArea_1.getText()+"', CONTACT_NAME='"+textArea_2.getText()+"', CONTACT_GENDER_MF='"+textArea_3.getText()+"', CONTACT_JOB_TITLE='"+textArea_4.getText()+"', CELL_MOBILE_PHONE='"+textArea_5.getText()+"', EMAIL_ADDRESS='"+textArea_6.getText()+"', WEB_ADDRESS='"+textArea_7.getText()+"' where AGENCY_ID='"+textArea.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Updated");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
				
			}
		});
		btnUpdate.setBounds(802, 207, 100, 39);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = "DELETE from RECRUITMENT_AGENCIES where AGENCY_ID='"+textArea.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Deleted");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
			}
		});
		btnDelete.setBounds(802, 274, 100, 39);
		contentPane.add(btnDelete);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recruitmentadd.this.dispose();
				manageframe1 mngfr1 = new manageframe1();
				mngfr1.setVisible(true);
				
			}
		});
		btnMainMenu.setBounds(955, 654, 100, 39);
		contentPane.add(btnMainMenu);
	}

}
