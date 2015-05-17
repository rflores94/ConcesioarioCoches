package Concesionario.GUI;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ScrollPaneConstants;

import java.awt.Font;

import javax.swing.JTextPane;
import javax.swing.JLabel;

public class About extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("Sobre concesionario");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnOk.setBounds(233, 173, 91, 23);
		
		getContentPane().setLayout(null);
		
		ImageIcon conc = new ImageIcon("src/img/concesionario.png");
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(conc);
		lblNewLabel.setBounds(259, 87, 113, 61);
		getContentPane().add(lblNewLabel);
		
		JTextArea txtrConcesionarioIesGran = new JTextArea();
		getContentPane().add(txtrConcesionarioIesGran);
		txtrConcesionarioIesGran.setFont(new Font("Consolas", Font.PLAIN, 13));
		txtrConcesionarioIesGran.setEditable(false);
		txtrConcesionarioIesGran.setText("Concesionario IES Gran Capit\u00E1n\r\n\r\nVersion: (3.2.7)\r\nBuild id: 0123456789\r\n(c) Copyright 2015.  All rights reserved.\r\n\r\nRealizado por:\r\n\tRoberto Carlos Flores G\u00F3mez");
		txtrConcesionarioIesGran.setBounds(0, 0, 378, 152);
		getContentPane().add(btnOk);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}