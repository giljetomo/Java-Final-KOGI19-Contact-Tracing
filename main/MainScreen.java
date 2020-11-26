package kogi19.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

import kogi19.DatabaseHandler.DatabaseHandler;

import javax.swing.DefaultComboBoxModel;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
//import com.jgoodies.forms.layout.FormSpecs;

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
	private JPasswordField pfPasswordAddNewAdmin;
	private JPasswordField pfRePasswordAddNewAdmin;
	private JPanel panelAddNewAdmin;
	private JTextField tfUsernameAddNewAdmin;
	private JPanel panelSystemPortal;
	private JButton btnAddTestResult;
	private JButton btnAddPositiveIndividual;
	private JButton btnGenerateReports;
	private JButton btnLogoutSystem;
	private JPanel panelAddIndividual;
	private JLabel lblPassword_3_2;
	private JButton btnCancelChangePassword_2;
	private JButton btnAdd_1;
	private JLabel lblPassword_1_2;
	private JLabel lblPassword_2_2;
	private JLabel lblNewLabel_1_2;
	private JTextField tfNameAddIndividual;
	private JComboBox genderComboBox;
	private JLabel lblPassword_3_3;
	private JTextField tfAddressAddIndividual;
	private JTextField tfContactAddIndividual;
	private JDateChooser dateChooserAddIndividual;
	private JPanel panelAddTestResult;
	private JLabel lblPassword_3_4;
	private JButton btnCancelChangePassword_3;
	private JButton btnAdd_2;
	private JLabel lblPassword_2_3;
	private JLabel lblNewLabel_1_3;
	private JComboBox ComboBoxPersonIdAddClinic;
	private JLabel lblPassword_3_5;
	private JDateChooser dateChooserBirthdateAddClinic;
	private JComboBox ComboBoxResultAddClinic;
	private JTextField tfNameAddClinic;
	private JButton btnAddClinic;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(370, 0, 463, 544);
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelLogInUC0 = new JPanel();
		panelLogInUC0.setBackground(Color.WHITE);
		layeredPane.add(panelLogInUC0, "name_2544617418237453");
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		JTextField tfUserName = new JTextField();
		tfUserName.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfUserName.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 18));
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remember to separate login for superuser and regular
				dbhandler = DatabaseHandler.getInstance();
				username = tfUserName.getText();
				userType = dbhandler.validAdminUser(username, String.valueOf(tfPassword.getPassword()));
				if(!Objects.isNull(userType)) {
					JOptionPane.showMessageDialog(null, "Welcome back, "+username+"!", "Information", JOptionPane.INFORMATION_MESSAGE);
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
		btnLogIn.setFont(new Font("Verdana", Font.BOLD, 18));
		
		tfPassword = new JPasswordField();
		tfPassword.setFont(new Font("Verdana", Font.PLAIN, 18));
		GroupLayout gl_panelLogInUC0 = new GroupLayout(panelLogInUC0);
		gl_panelLogInUC0.setHorizontalGroup(
			gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogInUC0.createSequentialGroup()
					.addContainerGap(75, Short.MAX_VALUE)
					.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelLogInUC0.createSequentialGroup()
							.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfPassword)
								.addComponent(tfUserName, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
							.addGap(52))
						.addGroup(gl_panelLogInUC0.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(75))))
		);
		gl_panelLogInUC0.setVerticalGroup(
			gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogInUC0.createSequentialGroup()
					.addGap(217)
					.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelLogInUC0.createSequentialGroup()
							.addComponent(tfUserName, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelLogInUC0.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGroup(gl_panelLogInUC0.createSequentialGroup()
								.addGap(28)
								.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))
					.addGap(62)
					.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		panelLogInUC0.setLayout(gl_panelLogInUC0);
		
		panelSuperUserUC1 = new JPanel();
		panelSuperUserUC1.setBackground(Color.WHITE);
		layeredPane.add(panelSuperUserUC1, "name_50771646590100");
		
		btnAddNewAdmin = new JButton("Add New Admin");
		btnAddNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelAddNewAdmin);
			}
		});
		btnAddNewAdmin.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnEnterTheSystem = new JButton("System Portal");
		btnEnterTheSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelSystemPortal);
			}
		});
		btnEnterTheSystem.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnChangePasswordSU = new JButton("Change Password");
		btnChangePasswordSU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelChangePasswordUC12);	
				pf_OldPassword.setText(null);
				pf_NewPassword.setText(null);
				pf_newRetypedPassword.setText(null);
			}
		});
		btnChangePasswordSU.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelLogInUC0);
			}
		});
		btnLogout.setFont(new Font("Verdana", Font.BOLD, 18));
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
		panelRegularUser.setBackground(Color.WHITE);
		layeredPane.add(panelRegularUser, "name_54442385767900");
		
		btnEnterTheSystem_1 = new JButton("System Portal");
		btnEnterTheSystem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelSystemPortal);
			}
		});
		btnEnterTheSystem_1.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnChangePasswordRU = new JButton("Change Password");
		btnChangePasswordRU.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelChangePasswordUC12);
				pf_OldPassword.setText(null);
				pf_NewPassword.setText(null);
				pf_newRetypedPassword.setText(null);
			}
		});
		btnChangePasswordRU.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnLogout_1 = new JButton("Logout");
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelLogInUC0);
			}
		});
		btnLogout_1.setFont(new Font("Verdana", Font.BOLD, 18));
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
		panelChangePasswordUC12.setBackground(Color.WHITE);
		layeredPane.add(panelChangePasswordUC12, "name_55635682621000");
		
		lblPassword_1 = new JLabel("New Password");
		lblPassword_1.setBounds(53, 189, 138, 25);
		lblPassword_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		pf_NewPassword = new JPasswordField();
		pf_NewPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pf_NewPassword.setBounds(214, 178, 222, 43);
		
		lblNewLabel_1 = new JLabel("Old Password");
		lblNewLabel_1.setBounds(53, 125, 125, 25);
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		btnCancelChangePassword = new JButton("CANCEL");
		btnCancelChangePassword.setBounds(91, 355, 126, 54);
		btnCancelChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changePanelByUserType(userType);
			}
		});
		btnCancelChangePassword.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnLogIn_1 = new JButton("CHANGE");
		btnLogIn_1.setBounds(251, 356, 137, 54);
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
		btnLogIn_1.setFont(new Font("Verdana", Font.BOLD, 18));
		
		lblPassword_2 = new JLabel("Re-type");
		lblPassword_2.setBounds(53, 232, 89, 24);
		lblPassword_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		
		pf_newRetypedPassword = new JPasswordField();
		pf_newRetypedPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pf_newRetypedPassword.setBounds(213, 243, 222, 43);
		
		pf_OldPassword = new JPasswordField();
		pf_OldPassword.setBounds(213, 112, 222, 43);
		pf_OldPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblPassword_3 = new JLabel("New Password");
		lblPassword_3.setBounds(53, 259, 135, 25);
		lblPassword_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelChangePasswordUC12.setLayout(null);
		panelChangePasswordUC12.add(lblNewLabel_1);
		panelChangePasswordUC12.add(lblPassword_1);
		panelChangePasswordUC12.add(lblPassword_2);
		panelChangePasswordUC12.add(lblPassword_3);
		panelChangePasswordUC12.add(pf_OldPassword);
		panelChangePasswordUC12.add(pf_NewPassword);
		panelChangePasswordUC12.add(pf_newRetypedPassword);
		panelChangePasswordUC12.add(btnCancelChangePassword);
		panelChangePasswordUC12.add(btnLogIn_1);
		
		panelAddNewAdmin = new JPanel();
		panelAddNewAdmin.setBackground(Color.WHITE);
		panelAddNewAdmin.setLayout(null);
		layeredPane.add(panelAddNewAdmin, "name_2537506951486689");
		
		JLabel lblPassword_3_1 = new JLabel("New Password");
		lblPassword_3_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_3_1.setBounds(48, 259, 135, 25);
		panelAddNewAdmin.add(lblPassword_3_1);
		
		JButton btnCancelChangePassword_1 = new JButton("CANCEL");
		btnCancelChangePassword_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelSuperUserUC1);
			}
		});
		btnCancelChangePassword_1.setFont(new Font("Verdana", Font.BOLD, 18));
		btnCancelChangePassword_1.setBounds(108, 332, 126, 54);
		panelAddNewAdmin.add(btnCancelChangePassword_1);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			
			
			//Koji
			public void actionPerformed(ActionEvent e) {
				dbhandler = DatabaseHandler.getInstance();
				String newUser = tfUsernameAddNewAdmin.getText();
				String newPassword = String.valueOf(pfPasswordAddNewAdmin.getPassword());
				String rePassword = String.valueOf(pfRePasswordAddNewAdmin.getPassword());
				
				boolean userExist = dbhandler.checkUser(newUser);
				
				if (userExist) {
					JOptionPane.showMessageDialog(null, "User Already Exist", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!newPassword.equals(rePassword)){
					JOptionPane.showMessageDialog(null, "Password Mimatch!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if(dbhandler.addNewAdmin(newUser, newPassword)) {
						JOptionPane.showMessageDialog(null, "User Added", "Information", JOptionPane.INFORMATION_MESSAGE);
						switchPanel(panelSuperUserUC1);
					} else {
						JOptionPane.showMessageDialog(null, "System Error", "Error", JOptionPane.ERROR_MESSAGE);						
					}
				}
			//Koji
				
				
			}
		});
		btnAdd.setFont(new Font("Verdana", Font.BOLD, 18));
		btnAdd.setBounds(278, 333, 127, 54);
		panelAddNewAdmin.add(btnAdd);
		
		JLabel lblPassword_1_1 = new JLabel("Password");
		lblPassword_1_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_1_1.setBounds(48, 180, 103, 25);
		panelAddNewAdmin.add(lblPassword_1_1);
		
		pfPasswordAddNewAdmin = new JPasswordField();
		pfPasswordAddNewAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pfPasswordAddNewAdmin.setBounds(195, 167, 231, 53);
		panelAddNewAdmin.add(pfPasswordAddNewAdmin);
		
		JLabel lblPassword_2_1 = new JLabel("Re-type");
		lblPassword_2_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_2_1.setBounds(48, 232, 90, 24);
		panelAddNewAdmin.add(lblPassword_2_1);
		
		pfRePasswordAddNewAdmin = new JPasswordField();
		pfRePasswordAddNewAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pfRePasswordAddNewAdmin.setBounds(195, 232, 231, 52);
		panelAddNewAdmin.add(pfRePasswordAddNewAdmin);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(48, 115, 114, 25);
		panelAddNewAdmin.add(lblNewLabel_1_1);
		
		tfUsernameAddNewAdmin = new JTextField();
		tfUsernameAddNewAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUsernameAddNewAdmin.setBounds(195, 101, 231, 54);
		panelAddNewAdmin.add(tfUsernameAddNewAdmin);
		tfUsernameAddNewAdmin.setColumns(10);
		
		panelSystemPortal = new JPanel();
		panelSystemPortal.setBackground(Color.WHITE);
		layeredPane.add(panelSystemPortal, "name_2544669003617475");
		
		btnAddTestResult = new JButton("Add Test Result");
		btnAddTestResult.setBounds(104, 189, 271, 54);
		btnAddTestResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				populateJComboBoxIndividuals();
				
				switchPanel(panelAddTestResult);
			}
		});
		btnAddTestResult.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnAddPositiveIndividual = new JButton("Add Positive Individual");
		btnAddPositiveIndividual.setBounds(104, 253, 271, 54);
		btnAddPositiveIndividual.setFont(new Font("Verdana", Font.BOLD, 17));
		
		btnGenerateReports = new JButton("Generate Reports");
		btnGenerateReports.setBounds(104, 317, 271, 54);
		btnGenerateReports.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnLogoutSystem = new JButton("LOGOUT");
		btnLogoutSystem.setBounds(244, 411, 170, 54);
		btnLogoutSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelLogInUC0);
			}
		});
		btnLogoutSystem.setFont(new Font("Verdana", Font.BOLD, 18));
		
		JButton btnAddIndividual = new JButton("Add Individual");
		btnAddIndividual.setBounds(104, 61, 271, 54);
		btnAddIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelAddIndividual);
			}
		});
		btnAddIndividual.setFont(new Font("Verdana", Font.BOLD, 18));
		
		JButton btnCancelSystem = new JButton("CANCEL");
		btnCancelSystem.setBounds(47, 411, 170, 54);
		btnCancelSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePanelByUserType(userType);
				
			}
		});
		btnCancelSystem.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnAddClinic = new JButton("Add Clinic");
		btnAddClinic.setBounds(104, 125, 271, 54);
		btnAddClinic.setFont(new Font("Verdana", Font.BOLD, 18));
		panelSystemPortal.setLayout(null);
		panelSystemPortal.add(btnGenerateReports);
		panelSystemPortal.add(btnCancelSystem);
		panelSystemPortal.add(btnLogoutSystem);
		panelSystemPortal.add(btnAddPositiveIndividual);
		panelSystemPortal.add(btnAddClinic);
		panelSystemPortal.add(btnAddTestResult);
		panelSystemPortal.add(btnAddIndividual);
		
		panelAddIndividual = new JPanel();
		panelAddIndividual.setBackground(Color.WHITE);
		panelAddIndividual.setLayout(null);
		layeredPane.add(panelAddIndividual, "name_2545465710490669");
		
		lblPassword_3_2 = new JLabel("Contact");
		lblPassword_3_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_3_2.setBounds(73, 341, 92, 25);
		panelAddIndividual.add(lblPassword_3_2);
		
		btnCancelChangePassword_2 = new JButton("CANCEL");
		btnCancelChangePassword_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelSystemPortal);
			}
		});
		btnCancelChangePassword_2.setFont(new Font("Verdana", Font.BOLD, 18));
		btnCancelChangePassword_2.setBounds(99, 412, 126, 54);
		panelAddIndividual.add(btnCancelChangePassword_2);
		
		btnAdd_1 = new JButton("ADD");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbhandler = DatabaseHandler.getInstance();
				String addUser = tfNameAddIndividual.getText();
				String addGender = String.valueOf(genderComboBox.getSelectedItem());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date addBirthdate = Date.valueOf(sdf.format(dateChooserAddIndividual.getDate()));
				String addAddress = tfAddressAddIndividual.getText();
				String addContact = tfContactAddIndividual.getText();
				
				Individual individual = new Individual(addUser, addGender, addBirthdate, addContact, addAddress);
				
				if(dbhandler.addNewIndividual(individual)) {
					JOptionPane.showMessageDialog(null, "Individual Added", "Success", JOptionPane.INFORMATION_MESSAGE);
				} else
					JOptionPane.showMessageDialog(null, "Try again!", "System Error", JOptionPane.ERROR_MESSAGE);
		

				
				
			}
		});
		btnAdd_1.setFont(new Font("Verdana", Font.BOLD, 18));
		btnAdd_1.setBounds(269, 413, 127, 54);
		panelAddIndividual.add(btnAdd_1);
		
		lblPassword_1_2 = new JLabel("Gender");
		lblPassword_1_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_1_2.setBounds(73, 141, 79, 25);
		panelAddIndividual.add(lblPassword_1_2);
		
		lblPassword_2_2 = new JLabel("Birthdate");
		lblPassword_2_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_2_2.setBounds(73, 202, 92, 24);
		panelAddIndividual.add(lblPassword_2_2);
		
		lblNewLabel_1_2 = new JLabel("Name");
		lblNewLabel_1_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(73, 90, 69, 25);
		panelAddIndividual.add(lblNewLabel_1_2);
		
		tfNameAddIndividual = new JTextField();
		tfNameAddIndividual.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfNameAddIndividual.setColumns(10);
		tfNameAddIndividual.setBounds(178, 65, 231, 54);
		panelAddIndividual.add(tfNameAddIndividual);
		
		genderComboBox = new JComboBox();
		genderComboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		genderComboBox.setBounds(178, 136, 231 , 35);
		
		genderComboBox.addItem("Male");
		genderComboBox.addItem("Female");
		
		panelAddIndividual.add(genderComboBox);
		
		lblPassword_3_3 = new JLabel("Address");
		lblPassword_3_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_3_3.setBounds(73, 272, 92, 25);
		panelAddIndividual.add(lblPassword_3_3);
		
		tfAddressAddIndividual = new JTextField();
		tfAddressAddIndividual.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfAddressAddIndividual.setColumns(10);
		tfAddressAddIndividual.setBounds(178, 243, 231, 54);
		panelAddIndividual.add(tfAddressAddIndividual);
		
		tfContactAddIndividual = new JTextField();
		tfContactAddIndividual.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfContactAddIndividual.setColumns(10);
		tfContactAddIndividual.setBounds(178, 312, 231, 54);
		tfContactAddIndividual.setDocument(new JTextFieldLimit(11));
		panelAddIndividual.add(tfContactAddIndividual);
		
		dateChooserAddIndividual = new JDateChooser();
		dateChooserAddIndividual.getCalendarButton().setFont(new Font("Verdana", Font.PLAIN, 18));
		dateChooserAddIndividual.setBounds(178, 188, 231, 40);
		panelAddIndividual.add(dateChooserAddIndividual);
		
		panelAddTestResult = new JPanel();
		panelAddTestResult.setBackground(Color.WHITE);
		panelAddTestResult.setLayout(null);
		layeredPane.add(panelAddTestResult, "name_2551243279798657");
		
		lblPassword_3_4 = new JLabel("Result");
		lblPassword_3_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_3_4.setBounds(51, 209, 78, 35);
		panelAddTestResult.add(lblPassword_3_4);
		
		btnCancelChangePassword_3 = new JButton("CANCEL");
		btnCancelChangePassword_3.setFont(new Font("Verdana", Font.BOLD, 18));
		btnCancelChangePassword_3.setBounds(91, 396, 126, 54);
		panelAddTestResult.add(btnCancelChangePassword_3);
		
		btnAdd_2 = new JButton("ADD");
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		contentPane.setLayout(null);
		btnAdd_2.setFont(new Font("Verdana", Font.BOLD, 18));
		btnAdd_2.setBounds(261, 397, 127, 54);
		panelAddTestResult.add(btnAdd_2);
		
		lblPassword_2_3 = new JLabel("Test Date");
		lblPassword_2_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_2_3.setBounds(51, 279, 104, 24);
		panelAddTestResult.add(lblPassword_2_3);
		
		lblNewLabel_1_3 = new JLabel("Clinic Name");
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(51, 87, 115, 25);
		panelAddTestResult.add(lblNewLabel_1_3);
		
		tfNameAddClinic = new JTextField();
		tfNameAddClinic.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfNameAddClinic.setColumns(10);
		tfNameAddClinic.setBounds(182, 78, 231, 44);
		panelAddTestResult.add(tfNameAddClinic);
		
		ComboBoxPersonIdAddClinic = new JComboBox();
		ComboBoxPersonIdAddClinic.setFont(new Font("Verdana", Font.PLAIN, 14));
		ComboBoxPersonIdAddClinic.setBounds(182, 139, 231, 44);
		panelAddTestResult.add(ComboBoxPersonIdAddClinic);
		
		lblPassword_3_5 = new JLabel("Person ID");
		lblPassword_3_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_3_5.setBounds(51, 149, 104, 25);
		panelAddTestResult.add(lblPassword_3_5);
		
		dateChooserBirthdateAddClinic = new JDateChooser();
		dateChooserBirthdateAddClinic.setBounds(182, 272, 231, 37);
		dateChooserBirthdateAddClinic.setFont(new Font("Verdana", Font.PLAIN, 13));
		panelAddTestResult.add(dateChooserBirthdateAddClinic);
		
		ComboBoxResultAddClinic = new JComboBox();
		ComboBoxResultAddClinic.setFont(new Font("Verdana", Font.PLAIN, 14));
		ComboBoxResultAddClinic.setModel(new DefaultComboBoxModel(new String[] {"Positive", "Negative"}));
		ComboBoxResultAddClinic.setBounds(182, 204, 231, 44);
		panelAddTestResult.add(ComboBoxResultAddClinic);
		contentPane.add(layeredPane);
	}
	
	private void populateJComboBoxIndividuals() {
		dbhandler = DatabaseHandler.getInstance();
		ArrayList<String> individuals = dbhandler.getIndividuals();
		ComboBoxPersonIdAddClinic.setModel(new DefaultComboBoxModel<String>(individuals.toArray(new String[0])));
		panelAddTestResult.add(ComboBoxPersonIdAddClinic);
	}

	protected void changePanelByUserType(String userType) {	
		if(userType.equals("s")) 
			switchPanel(panelSuperUserUC1);
		else
			switchPanel(panelRegularUser);	
	}
}
