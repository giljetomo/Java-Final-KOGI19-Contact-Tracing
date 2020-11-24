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
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JTextField;

public class MainScreen extends JFrame {

	private JPanel contentPane;
	DatabaseHandler dbhandler = null;
	private JPanel panelLogInUC0;
	private JPanel panelSuperUserUC1;
	private JLayeredPane layeredPane;
	private JTextField tfUserName;
	private JLabel lblPassword;
	private JTextField tfPassword;
	private JButton btnNewButton;
	private JButton btnLogIn;

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
	
	public void switchPanel (JPanel panel) {
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
		
		tfUserName = new JTextField();
		tfUserName.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		
		tfPassword = new JTextField();
		tfPassword.setColumns(10);
		
		btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		
		btnLogIn = new JButton("LOG IN");
		btnLogIn.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		GroupLayout gl_panelLogInUC0 = new GroupLayout(panelLogInUC0);
		gl_panelLogInUC0.setHorizontalGroup(
			gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelLogInUC0.createSequentialGroup()
					.addContainerGap(65, Short.MAX_VALUE)
					.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelLogInUC0.createSequentialGroup()
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(tfPassword, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_panelLogInUC0.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
		);
		panelLogInUC0.setLayout(gl_panelLogInUC0);
		
		panelSuperUserUC1 = new JPanel();
		layeredPane.add(panelSuperUserUC1, "name_50771646590100");
		
		JButton btnNewButton_1 = new JButton("SUPER USER PANEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanel(panelLogInUC0);
			}
		});
		GroupLayout gl_panelSuperUserUC1 = new GroupLayout(panelSuperUserUC1);
		gl_panelSuperUserUC1.setHorizontalGroup(
			gl_panelSuperUserUC1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperUserUC1.createSequentialGroup()
					.addGap(145)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(148, Short.MAX_VALUE))
		);
		gl_panelSuperUserUC1.setVerticalGroup(
			gl_panelSuperUserUC1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperUserUC1.createSequentialGroup()
					.addGap(183)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(241, Short.MAX_VALUE))
		);
		panelSuperUserUC1.setLayout(gl_panelSuperUserUC1);
		contentPane.setLayout(gl_contentPane);
	}
}
