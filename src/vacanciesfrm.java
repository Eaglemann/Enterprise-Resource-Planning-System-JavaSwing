import java.awt.BorderLayout;

import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class vacanciesfrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vacanciesfrm frame = new vacanciesfrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Connection conn = null;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public vacanciesfrm() {
		setTitle("VACANCIES PANEL");
		setResizable(false);
		conn = oracleconnection.dbConnector()
;		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1109, 758);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " select * from VACANCIES ";
					 PreparedStatement pst = conn.prepareStatement(query);
					 
					 ResultSet rs = pst.executeQuery();
					 
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
			         rs.close();
			         pst.close();
			        }catch (Exception e1) {
			            JOptionPane.showMessageDialog(null, e1);
			            
			        }
				
			}
		});
		btnNewButton.setBounds(36, 79, 95, 40);
		contentPane.add(btnNewButton);
		
		JButton btnEditData = new JButton("Edit Data");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vacanciesadd vcadd = new vacanciesadd();
				vcadd.setVisible(true);
				
			}
		});
		btnEditData.setBounds(139, 79, 95, 40);
		contentPane.add(btnEditData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 133, 1083, 585);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
