import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clientfrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientfrm frame = new clientfrm();
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
	public clientfrm() {
		setResizable(false);
		setTitle("Client Portal");
		conn = oracleconnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1089, 743);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					 String query = " select * from CLIENTS ";
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
		btnNewButton.setBounds(93, 72, 118, 34);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 117, 1063, 586);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Edit Data");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addclient addcl = new addclient();
				addcl.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(221, 72, 111, 34);
		contentPane.add(btnNewButton_1);
	}
}
