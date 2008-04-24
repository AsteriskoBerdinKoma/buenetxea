package buenetxea.gui.panelak;

import java.awt.Color;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import buenetxea.gui.panelak.CrearClientePanel.ValidateDNI;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class CrearPropietarioPanel extends JPanel {

	private JTextArea textArea;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
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

		textField_2 = new JTextField();

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
		
		final GroupLayout groupLayout_1 = new GroupLayout((JComponent) panel);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGap(14, 14, 14)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(telfFijoLabel)
						.addComponent(cpLabel)
						.addComponent(apellidosLabel)
						.addComponent(dniLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(nombreLabel)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(textField, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(textField_5, GroupLayout.Alignment.LEADING)
								.addComponent(textField_3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(telefonoLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(telfMovilLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))))
					.addGap(14, 14, 14))
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(observacionesLabel)
					.addContainerGap(403, Short.MAX_VALUE))
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nombreLabel)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(dniLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(apellidosLabel)
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cpLabel)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(telefonoLabel)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(telfFijoLabel)
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(telfMovilLabel)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(observacionesLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout_1.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {textField_5, textField_6});
		panel.setLayout(groupLayout_1);

		JPanel panel_1;
		panel_1 = new JPanel();

		JButton guardarButton;
		guardarButton = new JButton();
		guardarButton.setText("Guardar");
		final GroupLayout groupLayout_2 = new GroupLayout((JComponent) panel_1);
		groupLayout_2.setHorizontalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, groupLayout_2.createSequentialGroup()
					.addContainerGap(401, Short.MAX_VALUE)
					.addComponent(guardarButton)
					.addContainerGap())
		);
		groupLayout_2.setVerticalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addComponent(guardarButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(groupLayout_2);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 504, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
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
