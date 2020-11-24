package kogi19.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kogi19.databaseScripts.DatabaseHandler;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	DatabaseHandler dbhandler = null;
	private JPanel panelLogInUC0;
	private JPanel panelSuperUserUC1;
	private JLayeredPane layeredPane;
	private JLabel lblPassword;
	private JButton btnAddNewAdmin;
	private JButton btnEnterTheSystem;
	private JButton btnChangePasswordSU;
	private JButton btnLogout;
	private JPasswordField tfPassword;
	private JButton btnEnterTheSystem_1;
	private JButton btnChangePasswordRU;
	private JButton btnLogout_1;
	private JPanel panelRegularUser;
	private JLabel lblPassword_1;
	private JPasswordField pf_NewPassword;
	private JLabel lblNewLabel_1;
	private JButton btnCancelChangePassword;
	private JButton btnLogIn_1;
	private JPanel panelChangePasswordUC12;
	private JLabel lblPassword_2;
	private JLabel lblPassword_3;
	private JPasswordField pf_newRetypedPassword;
	private JPasswordField pf_OldPassword;
	private String userType;
	private String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void switchPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	/**
	 * Create the frame.
	 */
	public MainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		layeredPane = new JLayeredPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(365)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 463, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelLogInUC0 = new JPanel();
		layeredPane.add(panelLogInUC0, "name_50751536261500");
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		
		JTextField tfUserName = new JTextField();
		tfUserName.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remember to separate login for superuser and regular
				dbhandler = DatabaseHandler.getInstance();
				username = tfUserName.getText();
				userType = dbhandler.validAdminUser(username, String.valueOf(tfPassword.getPassword()));
				if(!Objects.isNull(userType)) {
					JOptionPane.showMessageDialog(null, "Login Successful!", "Information", JOptionPane.INFORMATION_MESSAGE);
					if(userType.equalsIgnoreCase("s")) {
						switchPanel(panelSuperUserUC1); //superUser login
					} else {
						switchPanel(panelRegularUser);  //regularUser login
					}
				} else {
					JOptionPane.showMessageDialog(null, "Invalid credentials", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnLogIn.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		tfPassword = new JPasswordField();
		GroupLayout gl_panelLogInUC0 = new GroupLayout(panelLogInUC0);
		gl_panelLogInUC0.setHorizontalGroup(
			gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogInUC0.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
					.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelLogInUC0.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfPassword))
						.addGroup(gl_panelLogInUC0.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfUserName, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))
					.addGap(63))
				.addGroup(gl_panelLogInUC0.createSequentialGroup()
					.addGap(97)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
		);
		gl_panelLogInUC0.setVerticalGroup(
			gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogInUC0.createSequentialGroup()
					.addGap(205)
					.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfUserName, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
		);
		panelLogInUC0.setLayout(gl_panelLogInUC0);
		
		panelSuperUserUC1 = new JPanel();
		layeredPane.add(panelSuperUserUC1, "name_50771646590100");
		
		btnAddNewAdmin = new JButton("Add New Admin");
		btnAddNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAddNewAdmin.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		btnEnterTheSystem = new JButton("System Portal");
		btnEnterTheSystem.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		btnChangePasswordSU = new JButton("Change Password");
		btnChangePasswordSU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelChangePasswordUC12);	
				pf_OldPassword.setText(null);
				pf_NewPassword.setText(null);
				pf_newRetypedPassword.setText(null);
			}
		});
		btnChangePasswordSU.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelLogInUC0);
			}
		});
		btnLogout.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		GroupLayout gl_panelSuperUserUC1 = new GroupLayout(panelSuperUserUC1);
		gl_panelSuperUserUC1.setHorizontalGroup(
			gl_panelSuperUserUC1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSuperUserUC1.createSequentialGroup()
					.addContainerGap(124, Short.MAX_VALUE)
					.addGroup(gl_panelSuperUserUC1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAddNewAdmin, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
						.addComponent(btnEnterTheSystem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnChangePasswordSU, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLogout, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(119))
		);
		gl_panelSuperUserUC1.setVerticalGroup(
			gl_panelSuperUserUC1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSuperUserUC1.createSequentialGroup()
					.addContainerGap(111, Short.MAX_VALUE)
					.addComponent(btnAddNewAdmin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnEnterTheSystem, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnChangePasswordSU, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(104))
		);
		panelSuperUserUC1.setLayout(gl_panelSuperUserUC1);
		
		panelRegularUser = new JPanel();
		layeredPane.add(panelRegularUser, "name_54442385767900");
		
		btnEnterTheSystem_1 = new JButton("System Portal");
		btnEnterTheSystem_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		btnChangePasswordRU = new JButton("Change Password");
		btnChangePasswordRU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelChangePasswordUC12);
				pf_OldPassword.setText(null);
				pf_NewPassword.setText(null);
				pf_newRetypedPassword.setText(null);
			}
		});
		btnChangePasswordRU.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		btnLogout_1 = new JButton("Logout");
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelLogInUC0);
			}
		});
		btnLogout_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		GroupLayout gl_panelRegularUser = new GroupLayout(panelRegularUser);
		gl_panelRegularUser.setHorizontalGroup(
			gl_panelRegularUser.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelRegularUser.createSequentialGroup()
					.addContainerGap(144, Short.MAX_VALUE)
					.addGroup(gl_panelRegularUser.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnEnterTheSystem_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnChangePasswordRU, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnLogout_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(126))
		);
		gl_panelRegularUser.setVerticalGroup(
			gl_panelRegularUser.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelRegularUser.createSequentialGroup()
					.addContainerGap(182, Short.MAX_VALUE)
					.addComponent(btnEnterTheSystem_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnChangePasswordRU, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnLogout_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addGap(105))
		);
		panelRegularUser.setLayout(gl_panelRegularUser);
		
		panelChangePasswordUC12 = new JPanel();
		layeredPane.add(panelChangePasswordUC12, "name_55635682621000");
		
		lblPassword_1 = new JLabel("New Password");
		lblPassword_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		
		pf_NewPassword = new JPasswordField();
		
		lblNewLabel_1 = new JLabel("Old Password");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		
		btnCancelChangePassword = new JButton("CANCEL");
		btnCancelChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanelByUserType(userType);
			}
		});
		btnCancelChangePassword.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		btnLogIn_1 = new JButton("CHANGE");
		btnLogIn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				dbhandler = DatabaseHandler.getInstance();
				String oldPassword = String.valueOf(pf_OldPassword.getPassword());
				String newPassword = String.valueOf(pf_newRetypedPassword.getPassword());
				
				if(Objects.isNull(dbhandler.validAdminUser(username, oldPassword))) {
					JOptionPane.showMessageDialog(null, "Invalid Old password!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if(String.valueOf(pf_NewPassword.getPassword()).equals(newPassword)) {
						if(dbhandler.changePassword(username, oldPassword, newPassword)) {
								JOptionPane.showMessageDialog(null, "Password changed!", "Success", JOptionPane.INFORMATION_MESSAGE);
								changePanelByUserType(userType);
						} else
							JOptionPane.showMessageDialog(null, "Try again!", "System Error", JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Password mismatch!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnLogIn_1.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		lblPassword_2 = new JLabel("Re-type");
		lblPassword_2.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		
		lblPassword_3 = new JLabel("New Password");
		lblPassword_3.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		
		pf_newRetypedPassword = new JPasswordField();
		
		pf_OldPassword = new JPasswordField();
		GroupLayout gl_panelChangePasswordUC12 = new GroupLayout(panelChangePasswordUC12);
		gl_panelChangePasswordUC12.setHorizontalGroup(
			gl_panelChangePasswordUC12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
					.addGap(97)
					.addComponent(btnCancelChangePassword, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(btnLogIn_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(75, Short.MAX_VALUE))
				.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_panelChangePasswordUC12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
							.addComponent(lblPassword_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(pf_NewPassword, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
							.addGroup(gl_panelChangePasswordUC12.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
									.addGap(1)
									.addComponent(lblPassword_3, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblPassword_2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addComponent(pf_newRetypedPassword, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
							.addComponent(pf_OldPassword, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))
					.addGap(37))
		);
		gl_panelChangePasswordUC12.setVerticalGroup(
			gl_panelChangePasswordUC12.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_panelChangePasswordUC12.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(lblPassword_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addGap(7))
						.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
							.addComponent(pf_OldPassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(pf_NewPassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(18)))
					.addGroup(gl_panelChangePasswordUC12.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
							.addGap(5)
							.addComponent(lblPassword_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(9)
							.addComponent(lblPassword_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelChangePasswordUC12.createSequentialGroup()
							.addGap(11)
							.addComponent(pf_newRetypedPassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)))
					.addGap(49)
					.addGroup(gl_panelChangePasswordUC12.createParallelGroup(Alignment.LEADING)
						.addComponent(btnCancelChangePassword, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogIn_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
		);
		panelChangePasswordUC12.setLayout(gl_panelChangePasswordUC12);
		contentPane.setLayout(gl_contentPane);
	}

	protected void changePanelByUserType(String userType) {	
		if(userType.equals("s")) 
			switchPanel(panelSuperUserUC1);
		else
			switchPanel(panelRegularUser);	
	}
}
