package Concesionario.GUI;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import concesionarioCoches.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alta extends VentanaPadre {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Alta(final Concesionario concesionario) {
		super();
		radioButtonPlata.setSelected(true);
		setTitle("Alta");
		
		eliminar.setVisible(false);
		buscar.setVisible(false);
		buttonAnterior.setVisible(false);
		buttonSiguiente.setVisible(false);
		
		comboBoxMarca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
			}
		});
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
		
		annadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (concesionario.annadir(textField.getText(), getColor(),
						(Modelo) comboBoxModelo.getSelectedItem()))
					JOptionPane.showMessageDialog(contentPanel,
							"Coche añadido con éxito.");
				else
					JOptionPane.showMessageDialog(contentPanel,
							"El coche no se ha podido añadir.", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});
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
	
	private Color getColor() {
		if (radioButtonPlata.isSelected())
			return Color.PLATA;
		else if (radioButtonRojo.isSelected())
			return Color.ROJO;
		else if (radioButtonAzul.isSelected())
			return Color.AZUL;
		else
			return null;
	}

}