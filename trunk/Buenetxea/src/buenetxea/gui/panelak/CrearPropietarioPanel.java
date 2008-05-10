package buenetxea.gui.panelak;


import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import buenetxea.objektuak.Propietario;
import buenetxea.kudeatzaileak.Kudeatzailea;
/**
 * @author Mireia
 *
 */
public class CrearPropietarioPanel extends JPanel {

	private JTextField textField_ciudad;
	private JTextField textField_telfijo;
	private JTextField textField_apellido2;
	private JTextField textField_apellido1;
	private JTextField textField_domi;
	private JComboBox comboBox_4;
	private JComboBox comboBox_3;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JTextField textField_telmovil;
	private JTextField textField_cp;
	private JTextField textField_nombre;
	private JFormattedTextField formattedTextField;
	/**
	 * Create the panel
	 * @throws ParseException 
	 */
	
	public CrearPropietarioPanel() throws ParseException {
		super();

		JPanel panel;
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Crear Propietario", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

		JLabel dniLabel;
		dniLabel = new JLabel();
		dniLabel.setText("DNI:");

		formattedTextField = new JFormattedTextField(new MaskFormatter(
		"########U"));
		formattedTextField.setInputVerifier(new ValidateDNI());
		formattedTextField.setColumns(9);

		JLabel nombreLabel;
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre:");

		textField_nombre = new JTextField();

		JLabel apellidosLabel;
		apellidosLabel = new JLabel();
		apellidosLabel.setText("Apellidos:");

		JLabel cpLabel;
		cpLabel = new JLabel();
		cpLabel.setText("C.P:");

		textField_cp = new JTextField();

		JLabel telfFijoLabel;
		telfFijoLabel = new JLabel();
		telfFijoLabel.setText("Telf. fijo:");

		textField_telmovil = new JTextField();

		JLabel telfMovilLabel;
		telfMovilLabel = new JLabel();
		telfMovilLabel.setText("Telf. movil:");

		JLabel observacionesLabel;
		observacionesLabel = new JLabel();
		observacionesLabel.setText("Observaciones:");

		textArea = new JTextArea();

		JLabel horarioFijoLabel;
		horarioFijoLabel = new JLabel();
		horarioFijoLabel.setText("Horario fijo:");

		JLabel horarioMovilLabel;
		horarioMovilLabel = new JLabel();
		horarioMovilLabel.setText("Horario movil:");

		comboBox = new JComboBox();
		  for (int i = 0; i <= 23; i++)
	        {
	        comboBox.addItem(i);
	    }

		JLabel label;
		label = new JLabel();
		label.setText(":");

		comboBox_1 = new JComboBox();
		comboBox_1 = new JComboBox();
		  for (int i = 0; i <= 59; i++)
	        {
	        comboBox_1.addItem(i);
	    }

		comboBox_3 = new JComboBox();
		
		  for (int i = 0; i <= 23; i++)
	        {
	        comboBox_3.addItem(i);
	    }

		JLabel label_1;
		label_1 = new JLabel();
		label_1.setText(":");

		comboBox_4 = new JComboBox();
		comboBox_4 = new JComboBox();
		  for (int i = 0; i <= 59; i++)
	        {
	        comboBox_4.addItem(i);
	    }

		JButton guardarButton;
		guardarButton = new JButton();
		guardarButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String dni;
				String apellido1;
				String apellido2;
				String nombre;
				String domicilio_postal;
				int cp;
				String ciudad;
				int tel_fijo;
				int tel_movil;
				String horario_fijo;
				String horario_movil;
				String observaciones;
				dni = formattedTextField.getText();
				apellido1 = textField_apellido1.getText();
				apellido2=  textField_apellido2.getText();
				nombre = textField_nombre.getText();
				domicilio_postal = textField_domi.getText();
				cp = Integer.parseInt(textField_cp.getText());
				ciudad = textField_ciudad.getText();
				tel_fijo = Integer.parseInt(textField_telfijo.getText());
				tel_movil = Integer.parseInt(textField_telmovil.getText());
				int orduak_fijo = Integer.parseInt(comboBox.getSelectedItem().toString());
				int minutuak_fijo =  Integer.parseInt(comboBox_1.getSelectedItem().toString());
				horario_fijo = orduak_fijo + ": " + minutuak_fijo ;
				int orduak_movil = Integer.parseInt(comboBox_3.getSelectedItem().toString());
				int minutuak_movil =  Integer.parseInt(comboBox_4.getSelectedItem().toString());
				horario_movil =  orduak_movil + ": " + minutuak_movil ;
				observaciones = textArea.getText();
				Propietario propietario = new Propietario (dni, nombre, apellido1,apellido2,
						domicilio_postal, cp, ciudad , tel_fijo, tel_movil, horario_fijo,horario_movil);
				try {
					if (Kudeatzailea.getInstance().crearPropietario(propietario))
					{
						JOptionPane jop = new JOptionPane(
								"El propietario se ha creado correctamente.",
								JOptionPane.INFORMATION_MESSAGE);
						jop.createDialog("Cliente creado").setVisible(true);
					}
					else{
						JOptionPane jop = new JOptionPane(
								"No se ha podido crear el propietario.",
								JOptionPane.ERROR_MESSAGE);
						jop.createDialog("Error al crear el cliente")
								.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane jop = new JOptionPane(
							"No se ha podido crear el propietario."+" \n" + e1.getMessage(),
							JOptionPane.ERROR_MESSAGE);
					jop.createDialog("Error al crear el propietario").setVisible(
							true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane jop = new JOptionPane(
							"No se ha podido crear el propietario.",
							JOptionPane.ERROR_MESSAGE);
					jop.createDialog("Error al crear el propietario").setVisible(
							true);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		guardarButton.setText("Guardar");

		JLabel domicilioPostalLabel;
		domicilioPostalLabel = new JLabel();
		domicilioPostalLabel.setText("Domicilio postal:");

		textField_domi = new JTextField();

		textField_apellido1 = new JTextField();

		textField_apellido2 = new JTextField();

		textField_telfijo = new JTextField();

		JLabel ciudadLabel;
		ciudadLabel = new JLabel();
		ciudadLabel.setText("Ciudad:");

		textField_ciudad = new JTextField();
		
		
		final GroupLayout groupLayout_1 = new GroupLayout((JComponent) panel);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(textArea, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(horarioFijoLabel, GroupLayout.Alignment.TRAILING)
										.addComponent(telfFijoLabel, GroupLayout.Alignment.TRAILING)
										.addComponent(domicilioPostalLabel, GroupLayout.Alignment.TRAILING)
										.addComponent(cpLabel, GroupLayout.Alignment.TRAILING)
										.addComponent(apellidosLabel, GroupLayout.Alignment.TRAILING)
										.addComponent(dniLabel, GroupLayout.Alignment.TRAILING))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(textField_domi, GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)
										.addGroup(groupLayout_1.createSequentialGroup()
											.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(nombreLabel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
											.addGap(6, 6, 6)
											.addComponent(textField_nombre, GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
										.addGroup(groupLayout_1.createSequentialGroup()
											.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(groupLayout_1.createSequentialGroup()
													.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
													.addComponent(label)
													.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
													.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE))
												.addComponent(textField_telfijo, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addGroup(groupLayout_1.createSequentialGroup()
													.addGap(13, 13, 13)
													.addComponent(telfMovilLabel))
												.addGroup(groupLayout_1.createSequentialGroup()
													.addGap(4, 4, 4)
													.addComponent(horarioMovilLabel)))
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(textField_telmovil, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout_1.createSequentialGroup()
													.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
													.addComponent(label_1)
													.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
													.addComponent(comboBox_4, 0, 0, Short.MAX_VALUE))))
										.addGroup(groupLayout_1.createSequentialGroup()
											.addComponent(textField_apellido1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(textField_apellido2, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
										.addGroup(groupLayout_1.createSequentialGroup()
											.addComponent(textField_cp, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(ciudadLabel)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(textField_ciudad, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))))
							.addGap(34, 34, 34))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(observacionesLabel)
							.addContainerGap(387, Short.MAX_VALUE))))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(dniLabel)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nombreLabel)
						.addComponent(textField_nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(apellidosLabel)
						.addComponent(textField_apellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_apellido2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cpLabel)
						.addComponent(textField_cp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ciudadLabel)
						.addComponent(textField_ciudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(domicilioPostalLabel)
						.addComponent(textField_domi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(telfFijoLabel)
						.addComponent(telfMovilLabel)
						.addComponent(textField_telfijo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_telmovil, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11, 11, 11)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(horarioFijoLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(horarioMovilLabel)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(observacionesLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout_1.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBox, comboBox_1});
		groupLayout_1.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {formattedTextField, textField_telfijo});
		groupLayout_1.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBox_3, comboBox_4});
		groupLayout_1.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboBox, comboBox_1});
		panel.setLayout(groupLayout_1);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(guardarButton)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 488, Short.MAX_VALUE))
					.addGap(16, 16, 16))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(21, 21, 21)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 320, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(guardarButton)
					.addContainerGap())
		);
		setLayout(groupLayout);
		//
	}
	private final class ValidateDNI extends InputVerifier {

		String pattern = "RWAGMYFPDXBNJZSQVHLCKET";

		/**
		 * Verifica un DNI.
		 */
		private boolean verifyDNI(String DNI) {
			// Eliminamos caracteres de separación.
			DNI = DNI.replaceAll("[.-]", "");
			if (DNI.length() != 9)
				return false;
			// El último carácter debe ser una letra
			if (!Character.isLetter(DNI.charAt(8)))
				return false;
			int digits;
			try {
				digits = Integer.parseInt(DNI.substring(0, 8));
			} catch (NumberFormatException e) {
				return false;
			}
			// El algoritmo mágico
			int pos = (digits % 23);
			if (pos == 0)
				pos = pattern.length();
			pos = pos - 1; // Las tiras en Java están basadas en cero!
			return (pattern.charAt(pos) == DNI.charAt(8));
		}

		@Override
		public boolean verify(JComponent input) {
			if (input instanceof JFormattedTextField) {
				Object o = ((JFormattedTextField) input).getValue();
				if (o == null)
					return true;
				String value = o.toString();
				return verifyDNI(value);
			}
			return false;
		}
	}
}
