import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addclient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addclient frame = new addclient();
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
	public addclient() {
		conn = oracleconnection.dbConnector();
		setResizable(false);
		setTitle("Client Add Data");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1043, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientName = new JLabel("Client Name");
		lblClientName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientName.setBounds(77, 181, 113, 27);
		contentPane.add(lblClientName);
		
		JLabel lblClientId = new JLabel("Client ID");
		lblClientId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientId.setBounds(77, 219, 113, 27);
		contentPane.add(lblClientId);
		
		JLabel lblClientName_1 = new JLabel("Client Name 1");
		lblClientName_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientName_1.setBounds(77, 257, 113, 27);
		contentPane.add(lblClientName_1);
		
		JLabel lblAddress = new JLabel("Email");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress.setBounds(77, 295, 113, 27);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Mobile");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(77, 333, 113, 27);
		contentPane.add(lblEmail);
		
		JLabel lblMobile = new JLabel("Date of First Contact");
		lblMobile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMobile.setBounds(77, 369, 130, 27);
		contentPane.add(lblMobile);
		
		JLabel lblDateOfFirst = new JLabel("Address ID");
		lblDateOfFirst.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateOfFirst.setBounds(77, 407, 165, 27);
		contentPane.add(lblDateOfFirst);
		
		JLabel lblClientsClientId = new JLabel("Clients Client ID");
		lblClientsClientId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientsClientId.setBounds(77, 486, 113, 27);
		contentPane.add(lblClientsClientId);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(214, 181, 234, 27);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(214, 222, 234, 27);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(214, 260, 234, 27);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(214, 298, 234, 27);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(214, 336, 234, 27);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(214, 372, 234, 27);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(214, 410, 234, 27);
		contentPane.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setBounds(214, 448, 234, 27);
		contentPane.add(textArea_7);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setBounds(214, 489, 234, 27);
		contentPane.add(textArea_8);
		
		
		
		
		JButton btnAddNew = new JButton("Add New");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " insert into CLIENTS (CLIENT_NAME, CLIENT_ID, CLIENT_NAME1, EMAIL_ADDRESS, CELL_MOBILE_PHONE_NUMBER, DATE_FIRST_CONTACT, ADDRESS_ID, OFFICE_ID, CLIENTS_CLIENT_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.setString(1, textArea.getText());
					 pst.setString(2, textArea_1.getText());
					 pst.setString(3, textArea_2.getText());
					 pst.setString(4, textArea_3.getText());
					 pst.setString(5, textArea_4.getText());
					 pst.setString(6, textArea_5.getText());
					 pst.setString(7, textArea_6.getText());
					 pst.setString(8, textArea_7.getText());
					 pst.setString(9, textArea_8.getText());
					
					 
					 pst.executeQuery();
					 
					 JOptionPane.showMessageDialog(null, "Data Added");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
			}
		});
		btnAddNew.setBounds(670, 185, 103, 46);
		contentPane.add(btnAddNew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " Update CLIENTS set CLIENT_NAME='"+textArea.getText()+"', CLIENT_ID='"+textArea_1.getText()+"', CLIENT_NAME1='"+textArea_2.getText()+"', EMAIL_ADDRESS='"+textArea_3.getText()+"', CELL_MOBILE_PHONE_NUMBER='"+textArea_4.getText()+"', DATE_FIRST_CONTACT='"+textArea_5.getText()+"', ADDRESS_ID='"+textArea_6.getText()+"', OFFICE_ID='"+textArea_7.getText()+"', CLIENTS_CLIENT_ID='"+textArea_8.getText()+"' where CLIENT_ID='"+textArea_1.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Updated");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
				
			}
		});
		btnUpdate.setBounds(670, 248, 103, 46);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = "DELETE from CLIENTS where CLIENT_ID='"+textArea_1.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Deleted");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
			}
		});
		btnDelete.setBounds(670, 314, 103, 46);
		contentPane.add(btnDelete);
		
		
		JLabel lblOfficeId = new JLabel("Office ID");
		lblOfficeId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOfficeId.setBounds(77, 445, 113, 27);
		contentPane.add(lblOfficeId);
		
		JLabel lblDdmonthyy = new JLabel("DD-Month-YY");
		lblDdmonthyy.setBounds(474, 377, 94, 14);
		contentPane.add(lblDdmonthyy);
		
		JButton btnNewButton = new JButton("Main Panel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addclient.this.dispose();
				manageframe1 mngfr1 = new manageframe1();
				mngfr1.setVisible(true);
			}
		});
		btnNewButton.setBounds(764, 580, 165, 41);
		contentPane.add(btnNewButton);
		
		
	}

}
