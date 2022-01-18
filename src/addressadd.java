import java.awt.BorderLayout;

import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addressadd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addressadd frame = new addressadd();
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
	public addressadd() {
		setTitle("Address Edit");
		setResizable(false);
		conn = oracleconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 968, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Address ID");
		lblNewLabel.setBounds(60, 161, 82, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblCityTown = new JLabel("City Town");
		lblCityTown.setBounds(60, 201, 82, 29);
		contentPane.add(lblCityTown);
		
		JLabel lblZip = new JLabel("ZIP CODE");
		lblZip.setBounds(60, 281, 82, 29);
		contentPane.add(lblZip);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setBounds(60, 241, 82, 29);
		contentPane.add(lblProvince);
		
		JLabel lblCountry = new JLabel("COUNTRY");
		lblCountry.setBounds(60, 321, 82, 29);
		contentPane.add(lblCountry);
		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(138, 163, 136, 30);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(138, 201, 136, 30);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(138, 240, 136, 30);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(138, 283, 136, 30);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(138, 321, 136, 30);
		contentPane.add(textArea_4);
		
		
		
		JButton btnAddData = new JButton("Add Data");
		btnAddData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " insert into ADDRESS (ADDRESS_ID, CITY_TOWN, STATE_COUNTRY_PROVINCE, ZIP, COUNTRY) VALUES (?, ?, ?, ?, ?)";
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
		btnAddData.setBounds(608, 161, 111, 40);
		contentPane.add(btnAddData);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = "UPDATE ADDRESS set ADDRESS_ID='"+textArea.getText()+"', CITY_TOWN='"+textArea_1.getText()+"', STATE_COUNTRY_PROVINCE='"+textArea_2.getText()+"', ZIP='"+textArea_3.getText()+"', COUNTRY='"+textArea_4.getText()+"' where ADDRESS_ID='"+textArea.getText()+"'  ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Updated");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
				
				
				
			}
		});
		btnUpdate.setBounds(608, 212, 111, 40);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					 String query = "DELETE from ADDRESS where ADDRESS_ID='"+textArea.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Deleted");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
				
			}
		});
		btnDelete.setBounds(608, 265, 111, 40);
		contentPane.add(btnDelete);
		
		JButton btnMainPanel = new JButton("Main Panel");
		btnMainPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addressadd.this.dispose();
				manageframe1 mngfr1 = new manageframe1();
				mngfr1.setVisible(true);
				
			}
		});
		btnMainPanel.setBounds(800, 599, 111, 40);
		contentPane.add(btnMainPanel);
		

	}

}
