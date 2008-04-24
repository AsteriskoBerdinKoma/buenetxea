package buenetxea.gui.panelak;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import buenetxea.kudeatzaileak.ClienteKud;
import buenetxea.objektuak.Cliente;

import com.toedter.calendar.JDateChooser;

public class CrearClientePanel extends JPanel {

	private JTextArea textArea;
	private JTextField textField_8;
	private JTextField textField_4;
	private JTextField textField_1;
	private JSpinner spinner_4;
	private JSpinner spinner_3;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JSpinner spinner;
	private JComboBox comboBox;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JFormattedTextField formattedTextField;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField textField_2;

	/**
	 * Create the panel
	 * 
	 * @throws ParseException
	 */
	public CrearClientePanel() throws ParseException {
		super();

		setBorder(new TitledBorder(null, "Crear cliente",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));
		setBackground(UIManager.getColor("Panel.background"));

		JPanel panel;
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos del cliente",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));
		panel.setBackground(UIManager.getColor("Panel.background"));

		textField_2 = new JTextField();

		textField_3 = new JTextField();

		textField_5 = new JTextField();

		textField_6 = new JTextField();

		textField_7 = new JTextField();

		JLabel dniLabel;
		dniLabel = new JLabel();
		dniLabel.setText("DNI:");

		JLabel nombreLabel;
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre:");

		JLabel apellido1Label;
		apellido1Label = new JLabel();
		apellido1Label.setText("Apellidos:");

		JLabel telefonoLabel;
		telefonoLabel = new JLabel();
		telefonoLabel.setText("Telefono:");

		JLabel medioLabel;
		medioLabel = new JLabel();
		medioLabel.setText("Medio:");

		JLabel asesorLabel;
		asesorLabel = new JLabel();
		asesorLabel.setText("Asesor:");

		formattedTextField = new JFormattedTextField(new MaskFormatter(
				"########U"));
		formattedTextField.setInputVerifier(new ValidateDNI());
		formattedTextField.setColumns(9);

		textField = new JTextField();

		JLabel nacionalidadLabel;
		nacionalidadLabel = new JLabel();
		nacionalidadLabel.setText("Nacionalidad:");

		comboBox = new JComboBox();

		JLabel fechaLabel;
		fechaLabel = new JLabel();
		fechaLabel.setText("Fecha:");

		JRadioButton actualRadioButton;
		actualRadioButton = new JRadioButton();
		actualRadioButton.setSelected(true);
		actualRadioButton.setText("Actual");

		final JRadioButton radioButton;
		radioButton = new JRadioButton();

		final JDateChooser dateChooser;
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d/M/yyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		dateChooser.setCalendar(cal);

		JPanel panel_1;
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Preferencias del cliente",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JLabel zonaLabel;
		zonaLabel = new JLabel();
		zonaLabel.setText("Zona:");

		JButton guardarButton;
		guardarButton = new JButton();
		guardarButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {

				ClienteKud clientekud = null;
				int dni=Integer.parseInt(formattedTextField.getText());
				String nombre=textField.getText();
				String apellido1=textField_2.getText();
				String apellido2=textField_3.getText();
				String nacionalidad=comboBox.getSelectedItem().toString();
				int telefono= Integer.parseInt(textField_5.getText());
				String medio=textField_6.getText();
				String asesor=textField_7.getText();

				Date fecha;
				if (radioButton.isSelected())
					fecha = new Date();
				else

				{
					 fecha = dateChooser.getDate();
				}
				Cliente cliente=new Cliente (dni,nombre,apellido1,apellido2,
						nacionalidad,fecha,telefono,medio,asesor);
				clientekud.InsertCliente(dni, nombre, apellido1, apellido2, fecha, nacionalidad, telefono, medio, asesor);
				}
		});
		guardarButton.setText("Guardar");

		JLabel tipoLabel;
		tipoLabel = new JLabel();
		tipoLabel.setText("Tipo:");

		JLabel metrosCuadradosLabel;
		metrosCuadradosLabel = new JLabel();
		metrosCuadradosLabel.setText("Metros cuadrados:");

		JLabel desdeLabel;
		desdeLabel = new JLabel();
		desdeLabel.setText("Desde");

		spinner = new JSpinner();

		JLabel m2Label;
		m2Label = new JLabel();
		m2Label.setText("m²");

		JLabel hastaLabel;
		hastaLabel = new JLabel();
		hastaLabel.setText("  hasta");

		spinner_2 = new JSpinner();

		JLabel m2Label_1;
		m2Label_1 = new JLabel();
		m2Label_1.setText("m²");

		JCheckBox exteriorCheckBox;
		exteriorCheckBox = new JCheckBox();
		exteriorCheckBox
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		exteriorCheckBox.setText("Exterior");

		JLabel numHabitacionesLabel;
		numHabitacionesLabel = new JLabel();
		numHabitacionesLabel.setText("Num. habitaciones:");

		spinner_1 = new JSpinner();

		JLabel label;
		label = new JLabel();
		label.setText("Baños:");

		spinner_3 = new JSpinner();

		JLabel aseosLabel;
		aseosLabel = new JLabel();
		aseosLabel.setText("Aseos:");

		spinner_4 = new JSpinner();

		JLabel presupuestoLabel;
		presupuestoLabel = new JLabel();
		presupuestoLabel.setText("Presupuesto:");

		textField_1 = new JTextField();

		JLabel label_1;
		label_1 = new JLabel();
		label_1.setText("€");

		textField_4 = new JTextField();

		textField_8 = new JTextField();

		JLabel obserbacionesLabel;
		obserbacionesLabel = new JLabel();
		obserbacionesLabel.setText("Observaciones:");

		JScrollPane scrollPane;
		scrollPane = new JScrollPane();

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		final GroupLayout groupLayout_2 = new GroupLayout(panel_1);
		groupLayout_2.setHorizontalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
						.addGroup(groupLayout_2.createSequentialGroup()
							.addComponent(numHabitacionesLabel)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_2.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(aseosLabel)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(exteriorCheckBox)
						.addGroup(groupLayout_2.createSequentialGroup()
							.addComponent(presupuestoLabel)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(label_1))
						.addComponent(obserbacionesLabel)
						.addGroup(groupLayout_2.createSequentialGroup()
							.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(groupLayout_2.createSequentialGroup()
									.addComponent(zonaLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
								.addGroup(groupLayout_2.createSequentialGroup()
									.addComponent(metrosCuadradosLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(desdeLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(m2Label)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(hastaLabel)))
							.addGap(4, 4, 4)
							.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(groupLayout_2.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(m2Label_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout_2.createSequentialGroup()
									.addComponent(tipoLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
					.addGap(1, 1, 1))
		);
		groupLayout_2.setVerticalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(zonaLabel)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tipoLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(metrosCuadradosLabel)
						.addComponent(desdeLabel)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(m2Label)
						.addComponent(hastaLabel)
						.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(m2Label_1))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(numHabitacionesLabel)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label)
						.addComponent(spinner_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(aseosLabel)
						.addComponent(spinner_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(exteriorCheckBox)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(presupuestoLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(obserbacionesLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(groupLayout_2);

		final GroupLayout groupLayout_1 = new GroupLayout(panel);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(fechaLabel)
						.addComponent(medioLabel)
						.addComponent(nacionalidadLabel)
						.addComponent(apellido1Label)
						.addComponent(dniLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(GroupLayout.Alignment.LEADING, groupLayout_1.createSequentialGroup()
							.addComponent(actualRadioButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(radioButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(comboBox, GroupLayout.Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_6, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(asesorLabel, GroupLayout.Alignment.TRAILING)
								.addComponent(telefonoLabel, GroupLayout.Alignment.TRAILING))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
								.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
							.addGap(162, 162, 162))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(nombreLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
								.addGroup(groupLayout_1.createSequentialGroup()
									.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
					.addContainerGap())
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(dniLabel)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nombreLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(apellido1Label)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(nacionalidadLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(telefonoLabel)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(medioLabel)
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(asesorLabel)
							.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(fechaLabel)
							.addComponent(actualRadioButton))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(1, 1, 1)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(radioButton))))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout_1);
		final GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(panel_1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
						.addComponent(guardarButton))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
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
