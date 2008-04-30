package buenetxea.gui.panelak;


import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
/**
 * @author Mireia
 *
 */
public class CrearPropietarioPanel extends JPanel {

	private JTextField textField_7;
	private JComboBox comboBox_4;
	private JComboBox comboBox_3;
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JTextArea textArea;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField;
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

		textField = new JTextField();

		JLabel apellidosLabel;
		apellidosLabel = new JLabel();
		apellidosLabel.setText("Apellidos:");

		textField_1 = new JTextField();

		JLabel cpLabel;
		cpLabel = new JLabel();
		cpLabel.setText("C.P:");

		textField_3 = new JTextField();

		JLabel telefonoLabel;
		telefonoLabel = new JLabel();
		telefonoLabel.setText("Ciudad:");

		textField_4 = new JTextField();

		JLabel telfFijoLabel;
		telfFijoLabel = new JLabel();
		telfFijoLabel.setText("Telf. fijo:");

		textField_5 = new JTextField();

		JLabel telfMovilLabel;
		telfMovilLabel = new JLabel();
		telfMovilLabel.setText("Telf. movil:");

		textField_6 = new JTextField();

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
		guardarButton.setText("Guardar");

		JLabel domicilioPostalLabel;
		domicilioPostalLabel = new JLabel();
		domicilioPostalLabel.setText("Domicilio postal:");

		textField_7 = new JTextField();
		
		
		final GroupLayout groupLayout_1 = new GroupLayout((JComponent) panel);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(horarioFijoLabel, GroupLayout.Alignment.TRAILING)
						.addComponent(telfFijoLabel, GroupLayout.Alignment.TRAILING)
						.addComponent(domicilioPostalLabel, GroupLayout.Alignment.TRAILING)
						.addComponent(cpLabel, GroupLayout.Alignment.TRAILING)
						.addComponent(apellidosLabel, GroupLayout.Alignment.TRAILING)
						.addComponent(dniLabel, GroupLayout.Alignment.TRAILING))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(label)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(horarioMovilLabel)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 4, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(24, Short.MAX_VALUE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(textField_6, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(telefonoLabel, GroupLayout.Alignment.TRAILING)
										.addComponent(nombreLabel, GroupLayout.Alignment.TRAILING))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
										.addComponent(textField, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
									.addGap(14, 14, 14))
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(telfMovilLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))))))
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(observacionesLabel)
					.addContainerGap(403, Short.MAX_VALUE))
				.addGroup(GroupLayout.Alignment.LEADING, groupLayout_1.createSequentialGroup()
					.addGap(90, 90, 90)
					.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
					.addContainerGap(14, Short.MAX_VALUE))
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap(88, Short.MAX_VALUE)
					.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
					.addGap(249, 249, 249))
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGap(88, 88, 88)
					.addComponent(formattedTextField, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
					.addGap(249, 249, 249))
				.addGroup(GroupLayout.Alignment.LEADING, groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(dniLabel)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nombreLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(apellidosLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cpLabel)
						.addComponent(telefonoLabel)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(domicilioPostalLabel)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(telfFijoLabel)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(telfMovilLabel)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11, 11, 11)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(horarioFijoLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label)
						.addComponent(horarioMovilLabel)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(observacionesLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout_1.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboBox, comboBox_1});
		groupLayout_1.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboBox, comboBox_1});
		panel.setLayout(groupLayout_1);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(guardarButton, GroupLayout.Alignment.TRAILING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
					.addContainerGap())
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
