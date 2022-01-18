import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class officepanel extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					officepanel frame = new officepanel();
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
	public officepanel() {
		setTitle("Office Panel");
		setResizable(false);
		conn = oracleconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1095, 716);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					 String query = " select * from OFFICES ";
					 PreparedStatement pst = conn.prepareStatement(query);
					 
					 ResultSet rs = pst.executeQuery();
					 
					 table.setModel(DbUtils.resultSetToTableModel(rs));
					
			         rs.close();
			         pst.close();
			        }catch (Exception e) {
			            JOptionPane.showMessageDialog(null, e);
			            
			        }
				
				
			}
		});
		btnNewButton.setBounds(64, 74, 112, 44);
		contentPane.add(btnNewButton);
		
		JButton btnEditData = new JButton("Edit Data");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officeadd offadd = new officeadd();
				offadd.setVisible(true);
			}
		});
		btnEditData.setBounds(186, 74, 112, 44);
		contentPane.add(btnEditData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 127, 1069, 537);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
