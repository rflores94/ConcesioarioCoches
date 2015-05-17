package Concesionario.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.Panel;

import javax.swing.ButtonGroup;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.border.TitledBorder;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;

import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import concesionarioCoches.Concesionario;
import concesionarioCoches.Marca;
import concesionarioCoches.Modelo;

public class Crear extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Crear dialog = new Crear();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Crear() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setBounds(21, 33, 66, 14);
		contentPanel.add(lblMatrcula);
		
		textField = new JTextField();
		textField.setBounds(81, 30, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Color", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(267, 17, 78, 105);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBounds(6, 16, 66, 79);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JRadioButton plata = new JRadioButton("Plata");
		buttonGroup.add(plata);
		plata.setBounds(6, 7, 74, 23);
		panel.add(plata);
		
		JRadioButton rojo = new JRadioButton("Rojo");
		buttonGroup.add(rojo);
		rojo.setBounds(6, 33, 74, 23);
		panel.add(rojo);
		
		JRadioButton azul = new JRadioButton("Azul");
		buttonGroup.add(azul);
		azul.setBounds(6, 59, 74, 23);
		panel.add(azul);
		panel_1.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel, plata, rojo, azul}));
		
		final JComboBox<Marca> comboBoxMarca = new JComboBox();
		final JComboBox<Modelo> comboBoxModelo = new JComboBox();
		
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
			}
		});
		
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxMarca.setBounds(81, 70, 86, 22);
		contentPanel.add(comboBoxMarca);
		
		
		comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
		comboBoxModelo.setBounds(81, 115, 86, 22);
		contentPanel.add(comboBoxModelo);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton crear = new JButton("Crear");
				crear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
//						if(Concesionario.annadir())
					}
				});
				crear.setActionCommand("OK");
				buttonPane.add(crear);
				getRootPane().setDefaultButton(crear);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
		private Object[] getModelo(JComboBox<Marca> comboBoxMarca) {
			Marca marca = (Marca) comboBoxMarca.getSelectedItem();
			ArrayList<Modelo> modelos = new ArrayList<Modelo>();
			for (Modelo m : Modelo.values()) {
				if (m.getMarca() == marca)
					modelos.add(m);
			}
			return modelos.toArray();
		}
	}
