import java.awt.BorderLayout;

import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class officeadd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					officeadd frame = new officeadd();
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
	public officeadd() {
		setResizable(false);
		setTitle("OFFICE EDIT");
		conn = oracleconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1114, 748);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OFFICE ID");
		lblNewLabel.setBounds(81, 157, 136, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblOfficeName = new JLabel("OFFICE NAME");
		lblOfficeName.setBounds(81, 204, 136, 36);
		contentPane.add(lblOfficeName);
		
		JLabel lblOfficeDetails = new JLabel("OFFICE DETAILS");
		lblOfficeDetails.setBounds(81, 251, 136, 36);
		contentPane.add(lblOfficeDetails);
		
		JLabel lblAddressId = new JLabel("ADDRESS ID");
		lblAddressId.setBounds(81, 303, 136, 36);
		contentPane.add(lblAddressId);
		
		JLabel lblAgencyId = new JLabel("AGENCY ID");
		lblAgencyId.setBounds(81, 350, 136, 36);
		contentPane.add(lblAgencyId);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(209, 157, 187, 28);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(209, 210, 187, 28);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(209, 257, 187, 28);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(209, 309, 187, 28);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(209, 356, 187, 28);
		contentPane.add(textArea_4);
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " insert into OFFICES (OFFICE_ID, OFFICE_NAME, office_Details, ADDRESS_ID, AGENCY_ID) VALUES (?, ?, ?, ?, ?)";
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.setString(1, textArea.getText());
					 pst.setString(2, textArea_1.getText());
					 pst.setString(3, textArea_2.getText());
					 pst.setString(4, textArea_3.getText());
					 pst.setString(5, textArea_4.getText());
					
					 
					 pst.executeQuery();
					 
					 JOptionPane.showMessageDialog(null, "Data Added");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
			}
		});
		btnNewButton.setBounds(747, 146, 117, 47);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " Update OFFICES set OFFICE_ID='"+textArea.getText()+"', OFFICE_NAME='"+textArea_1.getText()+"', office_Details='"+textArea_2.getText()+"', ADDRESS_ID='"+textArea_3.getText()+"', AGENCY_ID='"+textArea_4.getText()+"'  where OFFICE_ID='"+textArea.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Updated");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
			}
		});
		btnUpdate.setBounds(747, 222, 117, 47);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " DELETE from OFFICES where OFFICE_ID='"+textArea.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Deleted");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
				
			}
		});
		btnDelete.setBounds(747, 292, 117, 47);
		contentPane.add(btnDelete);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officeadd.this.dispose();
				manageframe1 mngfr1 = new manageframe1();
				mngfr1.setVisible(true);
			}
		});
		btnMainMenu.setBounds(939, 649, 117, 47);
		contentPane.add(btnMainMenu);
	}
}
