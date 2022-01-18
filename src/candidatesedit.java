import java.awt.BorderLayout;

import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class candidatesedit extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					candidatesedit frame = new candidatesedit();
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
	public candidatesedit() {
		setTitle("CADIDATES EDIT PANEL");
		setResizable(false);
		conn = oracleconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 785);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANDIDATE ID");
		lblNewLabel.setBounds(47, 131, 107, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblAddressId = new JLabel("ADDRESS ID");
		lblAddressId.setBounds(47, 169, 96, 27);
		contentPane.add(lblAddressId);
		
		JLabel lblOfficeId = new JLabel("OFFICE ID");
		lblOfficeId.setBounds(47, 203, 96, 27);
		contentPane.add(lblOfficeId);
		
		JLabel lblRegistrationDate = new JLabel("REGISTRATION DATE");
		lblRegistrationDate.setBounds(47, 241, 149, 27);
		contentPane.add(lblRegistrationDate);
		
		JLabel lblFirstName = new JLabel("FIRST NAME");
		lblFirstName.setBounds(47, 279, 96, 27);
		contentPane.add(lblFirstName);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(47, 317, 96, 27);
		contentPane.add(lblEmail);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setBounds(47, 355, 96, 27);
		contentPane.add(lblPhone);
		
		JLabel lblCandidatescandidateid = new JLabel("CANDIDATES CANDIDATE ID");
		lblCandidatescandidateid.setBounds(47, 393, 190, 27);
		contentPane.add(lblCandidatescandidateid);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(322, 132, 206, 22);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(322, 170, 206, 22);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(322, 204, 206, 22);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(322, 242, 206, 22);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(322, 280, 206, 22);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(322, 318, 206, 22);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(322, 356, 206, 22);
		contentPane.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(322, 394, 206, 22);
		contentPane.add(textArea_7);
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					 String query = " insert into CANDIDATES (CANDIDATE_ID, ADDRESS_ID, OFFICE_ID, REGISTRATION_DATE, FIRST_NAME, EMAIL_ADDRESS, HOME_PHONE_NUMBER, CANDIDATES_CANDIDATE_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
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
		btnNewButton.setBounds(850, 131, 119, 54);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					 String query = " Update CANDIDATES set CANDIDATE_ID='"+textArea.getText()+"', ADDRESS_ID='"+textArea_1.getText()+"', OFFICE_ID='"+textArea_2.getText()+"', REGISTRATION_DATE='"+textArea_3.getText()+"', FIRST_NAME='"+textArea_4.getText()+"', EMAIL_ADDRESS='"+textArea_5.getText()+"', HOME_PHONE_NUMBER='"+textArea_6.getText()+"', CANDIDATES_CANDIDATE_ID='"+textArea_7.getText()+"'  where CANDIDATE_ID='"+textArea.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Updated");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
				
			}
		});
		btnUpdate.setBounds(850, 205, 119, 54);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = "DELETE from CANDIDATES where CANDIDATE_ID='"+textArea.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Deleted");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
			}
		});
		btnDelete.setBounds(850, 281, 119, 54);
		contentPane.add(btnDelete);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				candidatesedit.this.dispose();
				manageframe1 mng1 = new manageframe1();
				mng1.setVisible(true);
			}
		});
		btnMainMenu.setBounds(969, 670, 119, 54);
		contentPane.add(btnMainMenu);
		
		JLabel lblDdmonthyy = new JLabel("DD-Month-YY");
		lblDdmonthyy.setBounds(547, 247, 81, 14);
		contentPane.add(lblDdmonthyy);
	}

}
