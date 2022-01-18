import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.text.TabSet;

import net.proteanit.sql.DbUtils;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addressfrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addressfrm frame = new addressfrm();
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
	public addressfrm() {
		conn = oracleconnection.dbConnector();
		setResizable(false);
		setTitle("Address Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1044, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Load Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 String query = " select * from ADDRESS ";
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
		btnNewButton.setBounds(47, 65, 136, 44);
		contentPane.add(btnNewButton);
		
		JButton btnEditData = new JButton("Edit Data");
		btnEditData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				addressadd add1 = new addressadd();
				add1.setVisible(true);
				
				
				
			}
		});
		btnEditData.setBounds(193, 65, 136, 44);
		contentPane.add(btnEditData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 120, 1003, 567);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
