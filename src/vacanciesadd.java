import java.awt.BorderLayout;

import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vacanciesadd extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vacanciesadd frame = new vacanciesadd();
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
	public vacanciesadd() {
		setResizable(false);
		setTitle("VACANCIES EDIT");
		conn = oracleconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1123, 766);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VACANCY ID");
		lblNewLabel.setBounds(50, 122, 75, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblClientId = new JLabel("CLIENT ID");
		lblClientId.setBounds(50, 158, 75, 25);
		contentPane.add(lblClientId);
		
		JLabel lblDateFilled = new JLabel("DATE FILLED");
		lblDateFilled.setBounds(50, 230, 135, 25);
		contentPane.add(lblDateFilled);
		
		JLabel lblDataPublished = new JLabel("DATA PUBLISHED");
		lblDataPublished.setBounds(50, 194, 151, 25);
		contentPane.add(lblDataPublished);
		
		JLabel lblFeePayable = new JLabel("FEE PAYABLE");
		lblFeePayable.setBounds(50, 266, 151, 25);
		contentPane.add(lblFeePayable);
		
		JLabel lblDateFeePaid = new JLabel("DATE FEE PAID");
		lblDateFeePaid.setBounds(50, 302, 135, 25);
		contentPane.add(lblDateFeePaid);
		
		JLabel lblVacanciesVacancyId = new JLabel("VACANCIES VACANCY ID");
		lblVacanciesVacancyId.setBounds(50, 335, 172, 25);
		contentPane.add(lblVacanciesVacancyId);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(232, 122, 195, 22);
		contentPane.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(232, 158, 195, 22);
		contentPane.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(232, 194, 195, 22);
		contentPane.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(232, 230, 195, 22);
		contentPane.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(232, 266, 195, 22);
		contentPane.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(232, 302, 195, 22);
		contentPane.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setBounds(232, 335, 195, 22);
		contentPane.add(textArea_6);
		
		JButton btnNewButton = new JButton("Add Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " insert into VACANCIES (VACANCY_ID, CLIENT_ID, DATE_VACANCY_PUBLISHZHED, DATE_VACANCY_FILLED, FEE_PAYABLE, DATE_FEE_PAID, VACANCIES_VACANCY_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.setString(1, textArea.getText());
					 pst.setString(2, textArea_1.getText());
					 pst.setString(3, textArea_2.getText());
					 pst.setString(4, textArea_3.getText());
					 pst.setString(5, textArea_4.getText());
					 pst.setString(6, textArea_5.getText());
					 pst.setString(7, textArea_6.getText());

					
					 
					 pst.executeQuery();
					 
					 JOptionPane.showMessageDialog(null, "Data Added");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
			}
		});
		btnNewButton.setBounds(790, 123, 102, 44);
		contentPane.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " Update VACANCIES set VACANCY_ID='"+textArea.getText()+"', CLIENT_ID='"+textArea_1.getText()+"', DATE_VACANCY_PUBLISHZHED='"+textArea_2.getText()+"', DATE_VACANCY_FILLED='"+textArea_3.getText()+"', FEE_PAYABLE='"+textArea_4.getText()+"', DATE_FEE_PAID='"+textArea_5.getText()+"', VACANCIES_VACANCY_ID='"+textArea_6.getText()+"' where VACANCY_ID='"+textArea.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Updated");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
			}
		});
		btnUpdate.setBounds(790, 178, 102, 44);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = "DELETE from VACANCIES where VACANCY_ID='"+textArea.getText()+"' ";
					
					 PreparedStatement pst = conn.prepareStatement(query);
					 pst.execute();
					 
					 JOptionPane.showMessageDialog(null, "Data Deleted");
					 
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
				
			}
		});
		btnDelete.setBounds(790, 231, 102, 44);
		contentPane.add(btnDelete);
		
		JButton btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				vacanciesadd.this.dispose();
				manageframe1 mngfr1 = new manageframe1();
				mngfr1.setVisible(true);
				
			}
		});
		btnMainMenu.setBounds(973, 682, 102, 44);
		contentPane.add(btnMainMenu);
		
		JLabel lblNewLabel_1 = new JLabel("DD-Month-YY");
		lblNewLabel_1.setBounds(450, 199, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("DD-Month-YY");
		label.setBounds(450, 235, 75, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("DD-Month-YY");
		label_1.setBounds(450, 307, 75, 14);
		contentPane.add(label_1);
	}

}
