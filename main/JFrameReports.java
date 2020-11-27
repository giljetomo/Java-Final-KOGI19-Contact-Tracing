package kogi19.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.ui.RefineryUtilities;

import kogi19.DatabaseHandler.DatabaseHandler;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class JFrameReports extends JFrame {
	
	DatabaseHandler dbhandler = null;
	private JPanel contentPane;
	private JTable table;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JButton btnGenerateChart;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameReports frame = new JFrameReports();
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
	public JFrameReports() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1076, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		dbhandler = new DatabaseHandler();
		DefaultTableModel model = dbhandler.getDataForReport();
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Export Report");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SpreadsheetBuilder sb = new SpreadsheetBuilder();
				
				try {
					if(sb.createSpreadsheet()) {
						JOptionPane.showMessageDialog(null, "Report Successfully Exported!", "Information", JOptionPane.INFORMATION_MESSAGE);
					} else
						JOptionPane.showMessageDialog(null, "Try again!", "System Error", JOptionPane.ERROR_MESSAGE);
			
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		btnGenerateChart = new JButton("Generate Chart");
		btnGenerateChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LineChartCases chart = new LineChartCases("Total Cases", "REPORTED CASES");
			      chart.pack();
			      RefineryUtilities.centerFrameOnScreen(chart);
			      chart.setVisible(true);
			}
		});
		btnGenerateChart.setFont(new Font("Verdana", Font.BOLD, 18));
		btnGenerateChart.setBounds(556, 610, 209, 51);
		contentPane.add(btnGenerateChart);
		
		lblNewLabel_6 = new JLabel("LIST OF EXPOSED INDIVIDUALS BY SOURCE PERSON");
		lblNewLabel_6.setForeground(new Color(220, 20, 60));
		lblNewLabel_6.setFont(new Font("Verdana", Font.BOLD, 24));
		lblNewLabel_6.setBounds(155, 10, 766, 60);
		contentPane.add(lblNewLabel_6);
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 18));
		btnNewButton.setBounds(168, 610, 182, 51);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 80, 935, 467);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JFrameReports.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel.setBounds(0, 0, 567, 559);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(JFrameReports.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_1.setBounds(562, 0, 498, 559);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(JFrameReports.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_2.setBounds(0, 557, 302, 178);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(JFrameReports.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_3.setBounds(299, 557, 302, 178);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(JFrameReports.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_4.setBounds(601, 557, 302, 178);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(JFrameReports.class.getResource("/kogi19/images/background_final.jpg")));
		lblNewLabel_5.setBounds(899, 557, 162, 178);
		contentPane.add(lblNewLabel_5);
			
	}
}
