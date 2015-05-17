package Concesionario.GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import concesionarioCoches.Coche;
import concesionarioCoches.Marca;
import concesionarioCoches.Modelo;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class VentanaPadre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final JPanel contentPanel = new JPanel();
	protected JTextField textField;
	protected JLabel lblMatricula;
	protected JLabel lblMarca;
	protected JLabel lblModelo;
	protected JRadioButton radioButtonPlata;
	protected JRadioButton radioButtonRojo;
	protected JRadioButton radioButtonAzul;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JComboBox<Marca> comboBoxMarca;
	protected JComboBox<Modelo> comboBoxModelo;
	protected JButton annadir;
	protected JButton eliminar;
	protected JButton buttonAnterior;
	protected JButton buttonSiguiente;
	protected JButton buscar;
	protected JButton salir;
	private JPanel panel;

	public VentanaPadre() {
		super();
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 388, 232);
		
		lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setBounds(26, 11, 76, 30);
		
		textField = new JTextField();
		textField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if(!Coche.esValida(textField.getText()))
					textField.setForeground(java.awt.Color.RED);
				else if(Coche.esValida(textField.getText()))
					textField.setForeground(java.awt.Color.BLACK);
			}
		});
		
		textField.setBounds(106, 16, 92, 20);
		textField.setColumns(10);
		
		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(26, 77, 49, 14);
		
		comboBoxMarca = new JComboBox<Marca>();
		comboBoxMarca.setBounds(106, 73, 65, 22);
		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setBounds(106, 116, 92, 22);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(26, 120, 49, 14);
		
		annadir = new JButton("A\u00F1adir");
		annadir.setBounds(205, 164, 86, 23);
		
		eliminar = new JButton("Eliminar");
		eliminar.setBounds(205, 164, 86, 23);
		
		buttonAnterior = new JButton();
		ImageIcon izda = new ImageIcon("src/img/flechaIzquierda.png");
		buttonAnterior.setIcon(izda);
		getContentPane().add(buttonAnterior);
		buttonAnterior.setBounds(212, 164, 35, 23);
		
		buttonSiguiente = new JButton();
		ImageIcon dcha = new ImageIcon("src/img/flechaDerecha.png");
		buttonSiguiente.setIcon(dcha);
		getContentPane().add(buttonSiguiente);
		buttonSiguiente.setBounds(257, 164, 35, 23);
		
		buscar = new JButton("Buscar");
		buscar.setBounds(205, 164, 86, 23);
		
		salir = new JButton("Salir");
		salir.setBounds(300, 164, 65, 23);
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		getContentPane().setLayout(null);
		getContentPane().add(lblMarca);
		getContentPane().add(lblModelo);
		getContentPane().add(lblMatricula);
		
		panel = new JPanel();
		panel.setToolTipText("Selecciona el color del coche");
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Color", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(236, 31, 77, 97);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		radioButtonPlata = new JRadioButton("Plata");
		radioButtonPlata.setForeground(Color.BLACK);
		radioButtonPlata.setBounds(6, 16, 65, 23);
		panel.add(radioButtonPlata);
		buttonGroup.add(radioButtonPlata);
		
		radioButtonRojo = new JRadioButton("Rojo");
		radioButtonRojo.setForeground(Color.BLACK);
		radioButtonRojo.setBounds(6, 42, 65, 23);
		panel.add(radioButtonRojo);
		buttonGroup.add(radioButtonRojo);
		
		radioButtonAzul = new JRadioButton("Azul");
		radioButtonAzul.setForeground(Color.BLACK);
		radioButtonAzul.setBounds(6, 68, 65, 23);
		panel.add(radioButtonAzul);
		buttonGroup.add(radioButtonAzul);
		getContentPane().add(annadir);
		getContentPane().add(eliminar);
		getContentPane().add(buttonAnterior);
		getContentPane().add(buttonSiguiente);
		getContentPane().add(buscar);
		getContentPane().add(salir);
		getContentPane().add(comboBoxMarca);
		getContentPane().add(comboBoxModelo);
		getContentPane().add(textField);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}