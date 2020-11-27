package kogi19.main;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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

	private String sourcePersonId;
	private String testResult;
	private JPanel contentPane;
	DatabaseHandler dbhandler = null;
	private JPanel panelLogInUC0;
	private JPanel panelSuperUserUC1;
	private JLayeredPane layeredPane;
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
	private JButton btnAddExposedIndividuals;
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
	private JButton btnCancelAddTestResult;
	private JButton btnAdd_2;
	private JLabel lblPassword_2_3;
	private JLabel lblNewLabel_1_3;
	private JComboBox ComboBoxPersonIdAddTestResult;
	private JLabel lblPassword_3_5;
	private JDateChooser dateChooserTestDate;
	private JComboBox ComboBoxResultAddResult;
	private JButton btnAddClinic;
	private JPanel panelUsername;
	private JPanel panelPassword;
	private JTextField tfUserName;
	private JPanel panelAddClinic;
	private JButton btnCancelChangePassword_4;
	private JButton btnAdd_3;
	private JLabel lblNewLabel_1_4;
	private JTextField tfClinicNameAddClinic;
	private JLabel lblNewLabel_1_5;
	private JTextField tfAddressAddClinic;
	private JComboBox ComboBoxClinicName;
	private JPanel panelExposedIndividualsPortal;
	private JButton btnAddIndividualToExistingLocation;
	private JButton btnCancelSystem_1;
	private JButton btnAddNewLocation;
	private JComboBox ComboBoxSourceIndividual;
	private JPanel panelAddLocation;
	private JButton btnCancelChangePassword_5;
	private JButton btnAddLocationSourceIndividual;
	private JLabel lblNewLabel_1_6;
	private JTextField tfLocationNameAddLocation;
	private JLabel lblNewLabel_1_7;
	private JTextField tfAddressAddLocation;
	private JLabel lblNewLabel_1_8;
	private JLabel lblSourceIndividualName;
	private JLabel lblPassword_3_6;
	private JComboBox ComboBoxSymptom;
	private JPanel panelAddIndividualToExistingLocation;
	private JLabel lblSourceIndividualExisting;
	private JComboBox ComboBoxLocationExisting;
	private JComboBox ComboBoxExposedIndividualExisting;
	private JDateChooser dateChooserDateOfExposure;
	private JLabel branding;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_10;

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
		setLocationRelativeTo(null);
	
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(370, 0, 463, 544);
		layeredPane.setBackground(Color.WHITE);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelLogInUC0 = new JPanel();
		panelLogInUC0.setBackground(Color.WHITE);
		layeredPane.add(panelLogInUC0, "name_2544617418237453");
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setBounds(90, 452, 131, 39);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Verdana", Font.BOLD, 14));
		
		JButton btnLogIn = new JButton("LOG IN");
		btnLogIn.setBounds(248, 452, 131, 39);
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
		btnLogIn.setFont(new Font("Verdana", Font.BOLD, 14));
		
		panelUsername = new JPanel();
		panelUsername.setBounds(63, 247, 336, 79);
		panelUsername.setBackground(new Color(153, 204, 204));
		panelUsername.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Username", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "USERNAME", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		 ((javax.swing.border.TitledBorder) panelUsername.getBorder()).setTitleFont(new Font("Verdana", Font.PLAIN, 16));
		
		tfUserName = new JTextField();
		tfUserName.setBounds(47, 28, 254, 35);
		tfUserName.setFont(new Font("Verdana", Font.PLAIN, 16));
		tfUserName.setColumns(10);
		panelLogInUC0.setLayout(null);
		panelLogInUC0.add(btnExit);
		panelLogInUC0.add(btnLogIn);
		panelLogInUC0.add(panelUsername);
		panelUsername.setLayout(null);
		panelUsername.add(tfUserName);
		
		panelPassword = new JPanel();
		panelPassword.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Password", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "PASSWORD", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		((javax.swing.border.TitledBorder) panelPassword.getBorder()).setTitleFont(new Font("Verdana", Font.PLAIN, 16));
		panelPassword.setBackground(new Color(153, 204, 204));
		panelPassword.setBounds(63, 327, 336, 79);
		panelLogInUC0.add(panelPassword);
		panelPassword.setLayout(null);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(48, 27, 251, 36);
		tfPassword.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelPassword.add(tfPassword);
		
		branding = new JLabel("");
		branding.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/images/background_final.jpg")));
		branding.setBounds(0, 0, 463, 544);
		panelLogInUC0.add(branding);
		
		panelSuperUserUC1 = new JPanel();
		panelSuperUserUC1.setBackground(Color.WHITE);
		layeredPane.add(panelSuperUserUC1, "name_50771646590100");
		
		btnAddNewAdmin = new JButton("Add New Admin");
		btnAddNewAdmin.setBounds(124, 170, 220, 54);
		btnAddNewAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelAddNewAdmin);
			}
		});
		btnAddNewAdmin.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnEnterTheSystem = new JButton("System Portal");
		btnEnterTheSystem.setBounds(124, 242, 220, 54);
		btnEnterTheSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelSystemPortal);
			}
		});
		btnEnterTheSystem.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnChangePasswordSU = new JButton("Change Password");
		btnChangePasswordSU.setBounds(124, 314, 220, 54);
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
		btnLogout.setBounds(124, 386, 220, 54);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelLogInUC0);
			}
		});
		btnLogout.setFont(new Font("Verdana", Font.BOLD, 18));
		panelSuperUserUC1.setLayout(null);
		panelSuperUserUC1.add(btnAddNewAdmin);
		panelSuperUserUC1.add(btnEnterTheSystem);
		panelSuperUserUC1.add(btnChangePasswordSU);
		panelSuperUserUC1.add(btnLogout);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel.setBounds(2, 0, 463, 544);
		panelSuperUserUC1.add(lblNewLabel);
		
		panelRegularUser = new JPanel();
		panelRegularUser.setBackground(Color.WHITE);
		layeredPane.add(panelRegularUser, "name_54442385767900");
		
		btnEnterTheSystem_1 = new JButton("System Portal");
		btnEnterTheSystem_1.setBounds(122, 241, 215, 54);
		btnEnterTheSystem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelSystemPortal);
			}
		});
		btnEnterTheSystem_1.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnChangePasswordRU = new JButton("Change Password");
		btnChangePasswordRU.setBounds(122, 313, 215, 54);
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
		btnLogout_1.setBounds(122, 385, 215, 54);
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelLogInUC0);
			}
		});
		btnLogout_1.setFont(new Font("Verdana", Font.BOLD, 18));
		panelRegularUser.setLayout(null);
		panelRegularUser.add(btnEnterTheSystem_1);
		panelRegularUser.add(btnChangePasswordRU);
		panelRegularUser.add(btnLogout_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_2.setBounds(0, 0, 463, 544);
		panelRegularUser.add(lblNewLabel_2);
		
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
		btnLogIn_1.setBounds(263, 356, 125, 54);
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
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_3.setBounds(-1, 0, 466, 544);
		panelChangePasswordUC12.add(lblNewLabel_3);
		
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
		btnAdd.setBounds(279, 333, 126, 54);
		panelAddNewAdmin.add(btnAdd);
		
		JLabel lblPassword_1_1 = new JLabel("Password");
		lblPassword_1_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_1_1.setBounds(48, 180, 103, 25);
		panelAddNewAdmin.add(lblPassword_1_1);
		
		pfPasswordAddNewAdmin = new JPasswordField();
		pfPasswordAddNewAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pfPasswordAddNewAdmin.setBounds(191, 167, 235, 53);
		panelAddNewAdmin.add(pfPasswordAddNewAdmin);
		
		JLabel lblPassword_2_1 = new JLabel("Re-type");
		lblPassword_2_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_2_1.setBounds(48, 232, 90, 24);
		panelAddNewAdmin.add(lblPassword_2_1);
		
		pfRePasswordAddNewAdmin = new JPasswordField();
		pfRePasswordAddNewAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pfRePasswordAddNewAdmin.setBounds(191, 232, 235, 52);
		panelAddNewAdmin.add(pfRePasswordAddNewAdmin);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(48, 115, 114, 25);
		panelAddNewAdmin.add(lblNewLabel_1_1);
		
		tfUsernameAddNewAdmin = new JTextField();
		tfUsernameAddNewAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUsernameAddNewAdmin.setBounds(191, 101, 235, 54);
		panelAddNewAdmin.add(tfUsernameAddNewAdmin);
		tfUsernameAddNewAdmin.setColumns(10);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_4.setBounds(0, 0, 466, 544);
		panelAddNewAdmin.add(lblNewLabel_4);
		
		panelSystemPortal = new JPanel();
		panelSystemPortal.setBackground(Color.WHITE);
		layeredPane.add(panelSystemPortal, "name_2544669003617475");
		
		btnAddTestResult = new JButton("Add Test Result");
		btnAddTestResult.setBounds(104, 189, 271, 54);
		btnAddTestResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				populateJComboBoxIndividuals();
				populateJComboBoxClinics();
				switchPanel(panelAddTestResult);
			}
		});
		btnAddTestResult.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnAddExposedIndividuals = new JButton("Add Exposed Individuals");
		btnAddExposedIndividuals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateJComboBoxSourceIndividuals();
				switchPanel(panelExposedIndividualsPortal);
			}
		});
		btnAddExposedIndividuals.setBounds(104, 253, 271, 54);
		btnAddExposedIndividuals.setFont(new Font("Verdana", Font.BOLD, 17));
		
		btnGenerateReports = new JButton("Generate Reports");
		btnGenerateReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFrame reportsFrame = new JFrameReports();
				reportsFrame.setVisible(true);
			}
		});
		btnGenerateReports.setBounds(104, 317, 271, 54);
		btnGenerateReports.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnLogoutSystem = new JButton("LOGOUT");
		btnLogoutSystem.setBounds(255, 423, 164, 54);
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
		btnCancelSystem.setBounds(47, 423, 170, 54);
		btnCancelSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				changePanelByUserType(userType);
				
			}
		});
		btnCancelSystem.setFont(new Font("Verdana", Font.BOLD, 18));
		
		btnAddClinic = new JButton("Add Clinic");
		btnAddClinic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelAddClinic);
			}
		});
		btnAddClinic.setBounds(104, 125, 271, 54);
		btnAddClinic.setFont(new Font("Verdana", Font.BOLD, 18));
		panelSystemPortal.setLayout(null);
		panelSystemPortal.add(btnGenerateReports);
		panelSystemPortal.add(btnCancelSystem);
		panelSystemPortal.add(btnLogoutSystem);
		panelSystemPortal.add(btnAddExposedIndividuals);
		panelSystemPortal.add(btnAddClinic);
		panelSystemPortal.add(btnAddTestResult);
		panelSystemPortal.add(btnAddIndividual);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_5.setBounds(-3, -1, 467, 546);
		panelSystemPortal.add(lblNewLabel_5);
		
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
		btnCancelChangePassword_2.setBounds(97, 413, 127, 54);
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
					switchPanel(panelSystemPortal);
				} else
					JOptionPane.showMessageDialog(null, "An individual can't have the same contact!", "System Error", JOptionPane.ERROR_MESSAGE);
				
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
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_6.setBounds(1, -2, 462, 546);
		panelAddIndividual.add(lblNewLabel_6);
		
		panelAddTestResult = new JPanel();
		panelAddTestResult.setBackground(Color.WHITE);
		layeredPane.add(panelAddTestResult, "name_2551243279798657");
		panelAddTestResult.setLayout(null);
		
		ComboBoxPersonIdAddTestResult = new JComboBox();
		ComboBoxPersonIdAddTestResult.setBounds(182, 139, 231, 44);
		ComboBoxPersonIdAddTestResult.setFont(new Font("Verdana", Font.PLAIN, 14));
		panelAddTestResult.add(ComboBoxPersonIdAddTestResult);
		
		dateChooserTestDate = new JDateChooser();
		dateChooserTestDate.setBounds(182, 312, 231, 37);
		dateChooserTestDate.setFont(new Font("Verdana", Font.PLAIN, 13));
		panelAddTestResult.add(dateChooserTestDate);
		
		ComboBoxSymptom = new JComboBox();
		ComboBoxSymptom.setBounds(182, 256, 231, 44);
		ComboBoxSymptom.setModel(new DefaultComboBoxModel(new String[] {"Symptomatic", "Asymptomatic"}));
		ComboBoxSymptom.setFont(new Font("Verdana", Font.PLAIN, 14));
		panelAddTestResult.add(ComboBoxSymptom);
		
		ComboBoxResultAddResult = new JComboBox();
		ComboBoxResultAddResult.setBounds(182, 204, 231, 44);
		//this section 

//		ComboBoxResultAddResult.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (ComboBoxResultAddResult.getSelectedItem().toString().equalsIgnoreCase("Negative")) {
//					ComboBoxSymptom.setSelectedIndex(-1);
//					ComboBoxSymptom.setEnabled(false);
//					panelAddTestResult.add(ComboBoxSymptom);
//					testResult = "N";
//	
//				} else {
//					ComboBoxSymptom.setEnabled(true);
//					panelAddTestResult.add(ComboBoxSymptom);
//					testResult = "P";
//					
//				}
//			}
//		});
		
		ComboBoxResultAddResult.setFont(new Font("Verdana", Font.PLAIN, 14));
		ComboBoxResultAddResult.setModel(new DefaultComboBoxModel(new String[] {"Positive", "Negative"}));
		panelAddTestResult.add(ComboBoxResultAddResult);
		
		
		ComboBoxClinicName = new JComboBox();
		ComboBoxClinicName.setBounds(182, 75, 231, 44);
		ComboBoxClinicName.setFont(new Font("Verdana", Font.PLAIN, 14));
		panelAddTestResult.add(ComboBoxClinicName);
		
		lblPassword_3_4 = new JLabel("Result");
		lblPassword_3_4.setBounds(51, 209, 78, 35);
		lblPassword_3_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAddTestResult.add(lblPassword_3_4);
		
		btnCancelAddTestResult = new JButton("CANCEL");
		btnCancelAddTestResult.setBounds(91, 396, 126, 54);
		btnCancelAddTestResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelSystemPortal);
			}
		});
		btnCancelAddTestResult.setFont(new Font("Verdana", Font.BOLD, 18));
		panelAddTestResult.add(btnCancelAddTestResult);
		
		btnAdd_2 = new JButton("ADD");
		btnAdd_2.setBounds(261, 397, 127, 54);
		btnAdd_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// clinid_id, result, testingDate, person_id
				dbhandler = DatabaseHandler.getInstance();
				
				int clinicNameIndex = ComboBoxClinicName.getSelectedIndex();
				int clinicId =  dbhandler.getClinicId(clinicNameIndex);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date testDate = Date.valueOf(sdf.format(dateChooserTestDate.getDate()));
				int personNameIndex = ComboBoxPersonIdAddTestResult.getSelectedIndex();
				String personId =  dbhandler.getPersonId(personNameIndex);
				
				String condition = Objects.isNull(ComboBoxSymptom.getSelectedItem().toString()) ? null : ComboBoxSymptom.getSelectedItem().toString();
				String result = String.valueOf(ComboBoxResultAddResult.getSelectedItem()).equalsIgnoreCase("Positive") ? "P" : "N";
				
				if(dbhandler.addResult(personId, clinicId, result, testDate, condition)) {
					JOptionPane.showMessageDialog(null, "Result Added", "Success", JOptionPane.INFORMATION_MESSAGE);
					switchPanel(panelSystemPortal);
				} else
					JOptionPane.showMessageDialog(null, "Try again!", "System Error", JOptionPane.ERROR_MESSAGE);
				
				
			}
		});
		contentPane.setLayout(null);
		btnAdd_2.setFont(new Font("Verdana", Font.BOLD, 18));
		panelAddTestResult.add(btnAdd_2);
		
		lblPassword_2_3 = new JLabel("Test Date");
		lblPassword_2_3.setBounds(51, 319, 104, 24);
		lblPassword_2_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAddTestResult.add(lblPassword_2_3);
		
		lblNewLabel_1_3 = new JLabel("Clinic Name");
		lblNewLabel_1_3.setBounds(51, 87, 115, 25);
		lblNewLabel_1_3.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAddTestResult.add(lblNewLabel_1_3);
		
		lblPassword_3_5 = new JLabel("Person ID");
		lblPassword_3_5.setBounds(51, 149, 104, 25);
		lblPassword_3_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAddTestResult.add(lblPassword_3_5);
		
		lblPassword_3_6 = new JLabel("Condition");
		lblPassword_3_6.setBounds(51, 261, 104, 35);
		lblPassword_3_6.setFont(new Font("Verdana", Font.PLAIN, 18));
		panelAddTestResult.add(lblPassword_3_6);
		
		contentPane.add(layeredPane);
		
		panelAddClinic = new JPanel();
		layeredPane.add(panelAddClinic, "name_2573581966566636");
		panelAddClinic.setLayout(null);
		panelAddClinic.setBackground(Color.WHITE);
		
		btnCancelChangePassword_4 = new JButton("CANCEL");
		btnCancelChangePassword_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelSystemPortal);
			}
		});
		btnCancelChangePassword_4.setFont(new Font("Verdana", Font.BOLD, 18));
		btnCancelChangePassword_4.setBounds(91, 396, 126, 54);
		panelAddClinic.add(btnCancelChangePassword_4);
		
		btnAdd_3 = new JButton("ADD");
		btnAdd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dbhandler = DatabaseHandler.getInstance();
				String clinicName = tfClinicNameAddClinic.getText();
				String clinicAddress = tfAddressAddClinic.getText();
				
				Clinic clinic = new Clinic(clinicName, clinicAddress);
				
				boolean clinicExist = dbhandler.checkClinic(clinicName);
				
				if (clinicExist) {
					JOptionPane.showMessageDialog(null, "Clinic Already Exist", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					if(dbhandler.addNewClinic(clinic)) {
						JOptionPane.showMessageDialog(null, "Clinic Added", "Information", JOptionPane.INFORMATION_MESSAGE);
						switchPanel(panelSystemPortal);
					} else {
						JOptionPane.showMessageDialog(null, "System Error", "Error", JOptionPane.ERROR_MESSAGE);						
					}
				}
				
				
			}
		});
		btnAdd_3.setFont(new Font("Verdana", Font.BOLD, 18));
		btnAdd_3.setBounds(261, 397, 127, 54);
		panelAddClinic.add(btnAdd_3);
		
		lblNewLabel_1_4 = new JLabel("Clinic Name");
		lblNewLabel_1_4.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(51, 87, 110, 25);
		panelAddClinic.add(lblNewLabel_1_4);
		
		tfClinicNameAddClinic = new JTextField();
		tfClinicNameAddClinic.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfClinicNameAddClinic.setColumns(10);
		tfClinicNameAddClinic.setBounds(169, 78, 254, 44);
		panelAddClinic.add(tfClinicNameAddClinic);
		
		lblNewLabel_1_5 = new JLabel("Address");
		lblNewLabel_1_5.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_5.setBounds(51, 180, 115, 25);
		panelAddClinic.add(lblNewLabel_1_5);
		
		tfAddressAddClinic = new JTextField();
		tfAddressAddClinic.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfAddressAddClinic.setColumns(10);
		tfAddressAddClinic.setBounds(137, 171, 286, 44);
		panelAddClinic.add(tfAddressAddClinic);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_8.setBounds(-1, 1, 466, 542);
		panelAddClinic.add(lblNewLabel_8);
		
		panelExposedIndividualsPortal = new JPanel();
		panelExposedIndividualsPortal.setLayout(null);
		panelExposedIndividualsPortal.setBackground(Color.WHITE);
		layeredPane.add(panelExposedIndividualsPortal, "name_2628972984262691");
		
		btnAddIndividualToExistingLocation = new JButton("<html>Add Individual to<br>an Existing Location</html>");
		btnAddIndividualToExistingLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int personNameIndex = ComboBoxSourceIndividual.getSelectedIndex();
				sourcePersonId =  dbhandler.getSourcePersonId(personNameIndex);
				populateComboBoxLocationExisting();
				populateComboBoxExposedIndividualExisting();
				lblSourceIndividualExisting.setText(ComboBoxSourceIndividual.getSelectedItem().toString());
				switchPanel(panelAddIndividualToExistingLocation);
			}
		});
		btnAddIndividualToExistingLocation.setFont(new Font("Verdana", Font.BOLD, 18));
		btnAddIndividualToExistingLocation.setBounds(104, 265, 271, 94);
		panelExposedIndividualsPortal.add(btnAddIndividualToExistingLocation);
		
		btnCancelSystem_1 = new JButton("CANCEL");
		btnCancelSystem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelSystemPortal);
			}
		});
		btnCancelSystem_1.setFont(new Font("Verdana", Font.BOLD, 18));
		btnCancelSystem_1.setBounds(104, 409, 271, 54);
		panelExposedIndividualsPortal.add(btnCancelSystem_1);
		
		btnAddNewLocation = new JButton("Add New Location");
		btnAddNewLocation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblSourceIndividualName.setText(ComboBoxSourceIndividual.getSelectedItem().toString());
				switchPanel(panelAddLocation);
			}
		});
		btnAddNewLocation.setFont(new Font("Verdana", Font.BOLD, 17));
		btnAddNewLocation.setBounds(104, 175, 271, 54);
		panelExposedIndividualsPortal.add(btnAddNewLocation);
		
		JLabel lblSourceIndividual = new JLabel("<html>Source<br>Individual</html>");
		lblSourceIndividual.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSourceIndividual.setBounds(58, 72, 119, 44);
		panelExposedIndividualsPortal.add(lblSourceIndividual);
		
		ComboBoxSourceIndividual = new JComboBox();
		ComboBoxSourceIndividual.setFont(new Font("Verdana", Font.PLAIN, 14));
		ComboBoxSourceIndividual.setBounds(189, 72, 231, 44);
		panelExposedIndividualsPortal.add(ComboBoxSourceIndividual);
		
		panelAddLocation = new JPanel();
		layeredPane.add(panelAddLocation, "name_2632603111643737");
		panelAddLocation.setLayout(null);
		panelAddLocation.setBackground(Color.WHITE);
		
		btnCancelChangePassword_5 = new JButton("CANCEL");
		btnCancelChangePassword_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelExposedIndividualsPortal);
			}
		});
		btnCancelChangePassword_5.setFont(new Font("Verdana", Font.BOLD, 18));
		btnCancelChangePassword_5.setBounds(91, 396, 126, 54);
		panelAddLocation.add(btnCancelChangePassword_5);
		
		btnAddLocationSourceIndividual = new JButton("ADD");
		btnAddLocationSourceIndividual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbhandler = DatabaseHandler.getInstance();
				String locationName = tfLocationNameAddLocation.getText();
				String locationAddress = tfAddressAddLocation.getText();
				int personNameIndex = ComboBoxSourceIndividual.getSelectedIndex();
				sourcePersonId =  dbhandler.getSourcePersonId(personNameIndex);
				
				Location location = new Location(locationName, locationAddress, sourcePersonId);
				
				
				if(dbhandler.addNewLocation(location)) {
					JOptionPane.showMessageDialog(null, "Location Added", "Information", JOptionPane.INFORMATION_MESSAGE);
					switchPanel(panelSystemPortal);
				} else {
					JOptionPane.showMessageDialog(null, "Location Already Exist for This Individual!", "Error", JOptionPane.ERROR_MESSAGE);						
				}
			}
		});
		btnAddLocationSourceIndividual.setFont(new Font("Verdana", Font.BOLD, 18));
		btnAddLocationSourceIndividual.setBounds(261, 397, 127, 54);
		panelAddLocation.add(btnAddLocationSourceIndividual);
		
		lblNewLabel_1_6 = new JLabel("<html>Location<br>Name</html>");
		lblNewLabel_1_6.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_6.setBounds(51, 174, 96, 54);
		panelAddLocation.add(lblNewLabel_1_6);
		
		tfLocationNameAddLocation = new JTextField();
		tfLocationNameAddLocation.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfLocationNameAddLocation.setColumns(10);
		tfLocationNameAddLocation.setBounds(171, 175, 254, 44);
		panelAddLocation.add(tfLocationNameAddLocation);
		
		lblNewLabel_1_7 = new JLabel("Address");
		lblNewLabel_1_7.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_7.setBounds(53, 277, 115, 25);
		panelAddLocation.add(lblNewLabel_1_7);
		
		tfAddressAddLocation = new JTextField();
		tfAddressAddLocation.setFont(new Font("Verdana", Font.PLAIN, 18));
		tfAddressAddLocation.setColumns(10);
		tfAddressAddLocation.setBounds(139, 268, 286, 44);
		panelAddLocation.add(tfAddressAddLocation);
		
		lblNewLabel_1_8 = new JLabel("REGISTER LOCATION");
		lblNewLabel_1_8.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel_1_8.setBounds(129, 19, 261, 39);
		panelAddLocation.add(lblNewLabel_1_8);
		
		lblSourceIndividualName = new JLabel("Person Name");
		lblSourceIndividualName.setForeground(new Color(51, 51, 204));
		lblSourceIndividualName.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblSourceIndividualName.setBounds(47, 85, 377, 33);
		panelAddLocation.add(lblSourceIndividualName);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_10.setBounds(0, 0, 463, 545);
		panelAddLocation.add(lblNewLabel_10);
		
		panelAddIndividualToExistingLocation = new JPanel();
		panelAddIndividualToExistingLocation.setLayout(null);
		panelAddIndividualToExistingLocation.setBackground(Color.WHITE);
		layeredPane.add(panelAddIndividualToExistingLocation, "name_2638995138281648");
		
		JButton btnCancelChangePassword_5_1 = new JButton("CANCEL");
		btnCancelChangePassword_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelExposedIndividualsPortal);
			}
		});
		btnCancelChangePassword_5_1.setFont(new Font("Verdana", Font.BOLD, 18));
		btnCancelChangePassword_5_1.setBounds(104, 404, 126, 54);
		panelAddIndividualToExistingLocation.add(btnCancelChangePassword_5_1);
		
		JButton btnAddLocationSourceIndividual_1 = new JButton("ADD");
		btnAddLocationSourceIndividual_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int personNameIndex = ComboBoxSourceIndividual.getSelectedIndex();
				sourcePersonId =  dbhandler.getSourcePersonId(personNameIndex);

				int locationIndex = ComboBoxLocationExisting.getSelectedIndex();
				int locationId =  dbhandler.getSourceIndividualLocationId(locationIndex, sourcePersonId);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date exposureDate = Date.valueOf(sdf.format(dateChooserDateOfExposure.getDate()));
				
				int exposedIndividualIndex = ComboBoxExposedIndividualExisting.getSelectedIndex();
				String exposedIndividualId = dbhandler.getSelectedExposedIndividual(exposedIndividualIndex);
				
//				System.out.println(sourcePersonId + locationId + String.valueOf(exposureDate) + exposedIndividualId);
				
				if(dbhandler.addExposedIndividual(exposedIndividualId, sourcePersonId, locationId, exposureDate)) {
					JOptionPane.showMessageDialog(null, "Exposed Individual Added", "Success", JOptionPane.INFORMATION_MESSAGE);
					populateComboBoxExposedIndividualExisting();
					panelAddIndividualToExistingLocation.add(ComboBoxExposedIndividualExisting);
					switchPanel(panelAddIndividualToExistingLocation);
				} else
					JOptionPane.showMessageDialog(null, "Individual Already Added!", "System Error", JOptionPane.ERROR_MESSAGE);
				
				
			}
		});
		btnAddLocationSourceIndividual_1.setFont(new Font("Verdana", Font.BOLD, 18));
		btnAddLocationSourceIndividual_1.setBounds(274, 405, 127, 54);
		panelAddIndividualToExistingLocation.add(btnAddLocationSourceIndividual_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Location");
		lblNewLabel_1_3_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(58, 172, 115, 25);
		panelAddIndividualToExistingLocation.add(lblNewLabel_1_3_1);
		
		ComboBoxLocationExisting = new JComboBox();
		ComboBoxLocationExisting.setFont(new Font("Verdana", Font.PLAIN, 14));
		ComboBoxLocationExisting.setBounds(189, 168, 231, 44);
		panelAddIndividualToExistingLocation.add(ComboBoxLocationExisting);
		
		
		
		JLabel lblNewLabel_1_3_2 = new JLabel("<html>Exposed<br>Individual</html>");
		lblNewLabel_1_3_2.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblNewLabel_1_3_2.setBounds(58, 247, 115, 44);
		panelAddIndividualToExistingLocation.add(lblNewLabel_1_3_2);
		
		ComboBoxExposedIndividualExisting = new JComboBox();
		ComboBoxExposedIndividualExisting.setFont(new Font("Verdana", Font.PLAIN, 14));
		ComboBoxExposedIndividualExisting.setBounds(189, 247, 231, 44);
		panelAddIndividualToExistingLocation.add(ComboBoxExposedIndividualExisting);
		
		lblSourceIndividualExisting = new JLabel("Source Individual");
		lblSourceIndividualExisting.setForeground(Color.BLUE);
		lblSourceIndividualExisting.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblSourceIndividualExisting.setBounds(104, 67, 283, 25);
		panelAddIndividualToExistingLocation.add(lblSourceIndividualExisting);
		
		JLabel lblPassword_2_2_1 = new JLabel("<html>Date of<br>Exposure</html>");
		lblPassword_2_2_1.setFont(new Font("Verdana", Font.PLAIN, 18));
		lblPassword_2_2_1.setBounds(84, 325, 92, 54);
		
		dateChooserDateOfExposure = new JDateChooser();
		dateChooserDateOfExposure.getCalendarButton().setFont(new Font("Verdana", Font.PLAIN, 18));
		dateChooserDateOfExposure.setBounds(189, 325, 231, 40);
		panelAddIndividualToExistingLocation.add(dateChooserDateOfExposure);
		
		JLabel lblBranding = new JLabel("");
		lblBranding.setIcon(new ImageIcon(MainScreen.class.getResource("/kogi19/main/branding.png")));
		lblBranding.setBounds(0, 0, 374, 544);
		contentPane.add(lblBranding);
		
		
		ImageIcon img = new ImageIcon("branding1.png");
		
	}
	
	private void populateJComboBoxIndividuals() {
		dbhandler = DatabaseHandler.getInstance();
		ArrayList<String> individuals = dbhandler.getIndividuals();
		ComboBoxPersonIdAddTestResult.setModel(new DefaultComboBoxModel<String>(individuals.toArray(new String[0])));
		panelAddTestResult.add(ComboBoxPersonIdAddTestResult);
	}
	
	private void populateJComboBoxClinics() {
		dbhandler = DatabaseHandler.getInstance();
		ArrayList<String> clinics = dbhandler.getClinics();
		ComboBoxClinicName.setModel(new DefaultComboBoxModel<String>(clinics.toArray(new String[0])));
		panelAddTestResult.add(ComboBoxClinicName);
	}
	
	private void populateJComboBoxSourceIndividuals() {
		dbhandler = DatabaseHandler.getInstance();
		ArrayList<String> individuals = dbhandler.getSourceIndividuals();
		ComboBoxSourceIndividual.setModel(new DefaultComboBoxModel<String>(individuals.toArray(new String[0])));
		panelExposedIndividualsPortal.add(ComboBoxSourceIndividual);
	}

	private void populateComboBoxLocationExisting() {
		dbhandler = DatabaseHandler.getInstance();
		ArrayList<String> locations = dbhandler.getSourceIndividualLocations(sourcePersonId);
		ComboBoxLocationExisting.setModel(new DefaultComboBoxModel<String>(locations.toArray(new String[0])));
		panelAddIndividualToExistingLocation.add(ComboBoxLocationExisting);
	}
	
	private void populateComboBoxExposedIndividualExisting() {
		dbhandler = DatabaseHandler.getInstance();
		ArrayList<String> locations = dbhandler.getPossibleExposedIndividuals();
		ComboBoxExposedIndividualExisting.setModel(new DefaultComboBoxModel<String>(locations.toArray(new String[0])));
		panelAddIndividualToExistingLocation.add(ComboBoxExposedIndividualExisting);
	}
	
	protected void changePanelByUserType(String userType) {	
		if(userType.equals("s")) 
			switchPanel(panelSuperUserUC1);
		else
			switchPanel(panelRegularUser);	
	}
}
