import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageframe1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageframe1 frame = new manageframe1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public manageframe1() {
		setResizable(false);
		setTitle("Management Panel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToManagement = new JLabel("Welcome to Management Panel");
		lblWelcomeToManagement.setFont(new Font("Trebuchet MS", Font.PLAIN, 26));
		lblWelcomeToManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToManagement.setBounds(116, 11, 453, 36);
		contentPane.add(lblWelcomeToManagement);
		
		JButton btnNewButtonclients = new JButton("Clients");
		Image img = new ImageIcon(this.getClass().getResource("/customer.png")).getImage();
		btnNewButtonclients.setIcon(new ImageIcon(img));
		btnNewButtonclients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				manageframe1.this.dispose();
				clientfrm clfrm = new clientfrm();
				clfrm.setVisible(true);
				
			}
		});
		btnNewButtonclients.setBounds(30, 135, 121, 45);
		contentPane.add(btnNewButtonclients);
		
		JButton btnAddress = new JButton("Address");
		Image img1 = new ImageIcon(this.getClass().getResource("/address.png")).getImage();
		btnAddress.setIcon(new ImageIcon(img1));
		btnAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageframe1.this.dispose();
				addressfrm addfrm = new addressfrm();
				addfrm.setVisible(true);
				
			}
		});
		btnAddress.setBounds(161, 135, 112, 45);
		contentPane.add(btnAddress);
		
		JButton btnCandidates = new JButton("Candidates");
		Image img11 = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		btnCandidates.setIcon(new ImageIcon(img11));
		btnCandidates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageframe1.this.dispose();
				candidatesform cndfrm = new candidatesform();
				cndfrm.setVisible(true);
			}
		});
		btnCandidates.setBounds(430, 191, 172, 45);
		contentPane.add(btnCandidates);
		
		JButton btnOffices = new JButton("Offices");
		Image img111 = new ImageIcon(this.getClass().getResource("/folder.png")).getImage();
		btnOffices.setIcon(new ImageIcon(img111));
		btnOffices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageframe1.this.dispose();
				officepanel offpn = new officepanel();
				offpn.setVisible(true);
						
			}
		});
		btnOffices.setBounds(583, 135, 112, 45);
		contentPane.add(btnOffices);
		
		JButton btnRecruitmentagencies = new JButton("Recruitment Agencies");
		Image img1111 = new ImageIcon(this.getClass().getResource("/staff.png")).getImage();
		btnRecruitmentagencies.setIcon(new ImageIcon(img1111));
		btnRecruitmentagencies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageframe1.this.dispose();
				recruitform recfrm = new recruitform();
				recfrm.setVisible(true);
				
			}
		});
		btnRecruitmentagencies.setBounds(30, 191, 172, 45);
		contentPane.add(btnRecruitmentagencies);
		
		JButton btnVacancies = new JButton("Vacancies ");
		Image img11111 = new ImageIcon(this.getClass().getResource("/vacancy-sign.png")).getImage();
		btnVacancies.setIcon(new ImageIcon(img11111));
		btnVacancies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manageframe1.this.dispose();
				vacanciesfrm vcfr = new vacanciesfrm();
				vcfr.setVisible(true);
			}
		});
		btnVacancies.setBounds(430, 135, 139, 45);
		contentPane.add(btnVacancies);
	}
}
