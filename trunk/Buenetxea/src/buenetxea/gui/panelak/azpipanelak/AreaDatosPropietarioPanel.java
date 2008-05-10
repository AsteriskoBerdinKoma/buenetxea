package buenetxea.gui.panelak.azpipanelak;

import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;
import javax.swing.text.Document;
import javax.swing.text.MaskFormatter;

/**
 * @author Mireia
 * 
 */
public class AreaDatosPropietarioPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField ciudadTextfield;
	private JTextField telFijoTextfield;
	private JTextField apellido2Textfield;
	private JTextField apellido1Textfield;
	private JTextField domicilioTextfield;
	private JComboBox horaMovilFinCombobox;
	private JComboBox horaMovilInicioCombobox;
	private JComboBox horaFijoFinCombobox;
	private JComboBox horaFijoInicioComboBox;
	private JTextField telMovilTextfield;
	private JTextField cpTextfield;
	private JTextField nombreTextfield;
	private JTextField dniTextfield;

	private String dniPattern = "RWAGMYFPDXBNJZSQVHLCKET";

	/**
	 * Create the panel
	 * 
	 * @throws ParseException
	 */

	public AreaDatosPropietarioPanel() throws ParseException {
		super();

		setBorder(new TitledBorder(null, "Crear Propietario",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JLabel dniLabel;
		dniLabel = new JLabel();
		dniLabel.setText("DNI");

		dniTextfield = new JTextField();
		dniTextfield.setColumns(9);

		JLabel nombreLabel;
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre");

		nombreTextfield = new JTextField();

		JLabel apellidosLabel;
		apellidosLabel = new JLabel();
		apellidosLabel.setText("Apellidos");

		JLabel cpLabel;
		cpLabel = new JLabel();
		cpLabel.setText("C.P.");

		cpTextfield = new JTextField();

		JLabel telfFijoLabel;
		telfFijoLabel = new JLabel();
		telfFijoLabel.setText("Telf. fijo");

		telMovilTextfield = new JTextField();

		JLabel telfMovilLabel;
		telfMovilLabel = new JLabel();
		telfMovilLabel.setText("Telf. movil");

		JLabel horarioFijoLabel;
		horarioFijoLabel = new JLabel();
		horarioFijoLabel.setText("Horario fijo");

		JLabel horarioMovilLabel;
		horarioMovilLabel = new JLabel();
		horarioMovilLabel.setText("Horario movil");

		horaFijoInicioComboBox = new JComboBox();
		for (int i = 0; i <= 23; i++) {
			horaFijoInicioComboBox.addItem(i);
		}

		JLabel label;
		label = new JLabel();
		label.setText("a");

		horaFijoFinCombobox = new JComboBox();
		for (int i = 0; i <= 59; i++) {
			horaFijoFinCombobox.addItem(i);
		}

		horaMovilInicioCombobox = new JComboBox();

		for (int i = 0; i <= 23; i++) {
			horaMovilInicioCombobox.addItem(i);
		}

		JLabel label_1;
		label_1 = new JLabel();
		label_1.setText("a");

		horaMovilFinCombobox = new JComboBox();
		for (int i = 0; i <= 59; i++) {
			horaMovilFinCombobox.addItem(i);
		}

		JLabel domicilioPostalLabel;
		domicilioPostalLabel = new JLabel();
		domicilioPostalLabel.setText("Domicilio postal");

		domicilioTextfield = new JTextField();

		apellido1Textfield = new JTextField();

		apellido2Textfield = new JTextField();

		telFijoTextfield = new JTextField();

		JLabel ciudadLabel;
		ciudadLabel = new JLabel();
		ciudadLabel.setText("Ciudad");

		ciudadTextfield = new JTextField();

		final GroupLayout groupLayout_1 = new GroupLayout((JComponent) this);
		groupLayout_1
				.setHorizontalGroup(groupLayout_1
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																horarioFijoLabel,
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																telfFijoLabel,
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																domicilioPostalLabel,
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																cpLabel,
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																apellidosLabel,
																GroupLayout.Alignment.TRAILING)
														.addComponent(
																dniLabel,
																GroupLayout.Alignment.TRAILING))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																domicilioTextfield,
																GroupLayout.DEFAULT_SIZE,
																374,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout_1
																		.createSequentialGroup()
																		.addComponent(
																				dniTextfield,
																				GroupLayout.PREFERRED_SIZE,
																				159,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				nombreLabel,
																				GroupLayout.PREFERRED_SIZE,
																				41,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				6,
																				6,
																				6)
																		.addComponent(
																				nombreTextfield,
																				GroupLayout.DEFAULT_SIZE,
																				164,
																				Short.MAX_VALUE))
														.addGroup(
																groupLayout_1
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout_1
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addGroup(
																								groupLayout_1
																										.createSequentialGroup()
																										.addComponent(
																												horaFijoInicioComboBox,
																												GroupLayout.PREFERRED_SIZE,
																												45,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												label)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												horaFijoFinCombobox,
																												GroupLayout.PREFERRED_SIZE,
																												69,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								telFijoTextfield,
																								GroupLayout.PREFERRED_SIZE,
																								147,
																								GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED,
																				GroupLayout.DEFAULT_SIZE,
																				Short.MAX_VALUE)
																		.addGroup(
																				groupLayout_1
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addGroup(
																								groupLayout_1
																										.createSequentialGroup()
																										.addGap(
																												13,
																												13,
																												13)
																										.addComponent(
																												telfMovilLabel))
																						.addGroup(
																								groupLayout_1
																										.createSequentialGroup()
																										.addGap(
																												4,
																												4,
																												4)
																										.addComponent(
																												horarioMovilLabel)))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout_1
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								telMovilTextfield,
																								GroupLayout.PREFERRED_SIZE,
																								152,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								groupLayout_1
																										.createSequentialGroup()
																										.addComponent(
																												horaMovilInicioCombobox,
																												GroupLayout.PREFERRED_SIZE,
																												69,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												label_1)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												horaMovilFinCombobox,
																												0,
																												0,
																												Short.MAX_VALUE))))
														.addGroup(
																groupLayout_1
																		.createSequentialGroup()
																		.addComponent(
																				apellido1Textfield,
																				GroupLayout.DEFAULT_SIZE,
																				177,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				apellido2Textfield,
																				GroupLayout.DEFAULT_SIZE,
																				191,
																				Short.MAX_VALUE))
														.addGroup(
																groupLayout_1
																		.createSequentialGroup()
																		.addComponent(
																				cpTextfield,
																				GroupLayout.PREFERRED_SIZE,
																				174,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				ciudadLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				ciudadTextfield,
																				GroupLayout.DEFAULT_SIZE,
																				159,
																				Short.MAX_VALUE)))
										.addGap(34, 34, 34)));
		groupLayout_1
				.setVerticalGroup(groupLayout_1
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(dniLabel)
														.addComponent(
																dniTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																nombreLabel)
														.addComponent(
																nombreTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																apellidosLabel)
														.addComponent(
																apellido1Textfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																apellido2Textfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(cpLabel)
														.addComponent(
																cpTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																ciudadLabel)
														.addComponent(
																ciudadTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																domicilioPostalLabel)
														.addComponent(
																domicilioTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																telfFijoLabel)
														.addComponent(
																telfMovilLabel)
														.addComponent(
																telFijoTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																telMovilTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(11, 11, 11)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																horarioFijoLabel)
														.addComponent(
																horaFijoInicioComboBox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label)
														.addComponent(
																horaFijoFinCombobox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																horarioMovilLabel)
														.addComponent(
																horaMovilInicioCombobox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_1)
														.addComponent(
																horaMovilFinCombobox,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		groupLayout_1.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { horaFijoFinCombobox,
						horaFijoInicioComboBox });
		groupLayout_1.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { horaFijoFinCombobox,
						horaFijoInicioComboBox });
		groupLayout_1.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { dniTextfield, telFijoTextfield });
		groupLayout_1.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { horaMovilFinCombobox,
						horaMovilInicioCombobox });
		setLayout(groupLayout_1);
		//
	}

	public boolean verifyDNI(String DNI) {
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
			pos = dniPattern.length();
		pos = pos - 1; // Las tiras en Java están basadas en cero!
		return (dniPattern.charAt(pos) == DNI.charAt(8));
	}

	public String getDniTextfield() {
		return dniTextfield.getText().trim();
	}

	public Document getDniTextfieldModel() {
		return dniTextfield.getDocument();
	}

	public void setDniTextfield(String dni) {
		dniTextfield.setText(dni);
	}

	public String getNombreTextfield() {
		return nombreTextfield.getText().trim();
	}

	public Document getNombreTextfieldModel() {
		return nombreTextfield.getDocument();
	}

	public void setNombreTextfield(String nombre) {
		nombreTextfield.setText(nombre);
	}

	public String getApellido1Textfield() {
		return apellido1Textfield.getText().trim();
	}

	public Document getApellido1TextfieldModel() {
		return apellido1Textfield.getDocument();
	}

	public void setApellido1Textfield(String apellido1) {
		apellido1Textfield.setText(apellido1);
	}

	public String getApellido2Textfield() {
		return apellido2Textfield.getText().trim();
	}

	public Document getApellido2TextfieldModel() {
		return apellido2Textfield.getDocument();
	}

	public void setApellido2Textfield(String apellido2) {
		apellido2Textfield.setText(apellido2);
	}

	public int getCpTextfield() {
		return Integer.parseInt(cpTextfield.getText().trim());
	}

	public void setCpTextfield(int cp) {
		cpTextfield.setText(String.valueOf(cp));
	}

	public String getCiudadTextfield() {
		return ciudadTextfield.getText().trim();
	}

	public void setCiudadTextfield(String ciudad) {
		ciudadTextfield.setText(ciudad);
	}

	public String getDomicilioTextfield() {
		return domicilioTextfield.getText().trim();
	}

	public void setDomicilioTextfield(String domicilio) {
		domicilioTextfield.setText(domicilio);
	}

	public int getTelFijoTextfield() {
		return Integer.parseInt(telFijoTextfield.getText().trim());
	}

	public void setTelFijoTextfield(int telFijo) {
		telFijoTextfield.setText(String.valueOf(telFijo));
	}

	public int getTelMovilTextfield() {
		return Integer.parseInt(telMovilTextfield.getText().trim());
	}

	public void setTelMovilTextfield(int telMovil) {
		telMovilTextfield.setText(String.valueOf(telMovil));
	}

	public int getHoraFijoInicioComboBox() {
		return horaFijoInicioComboBox.getSelectedIndex() + 1;
	}

	public void setHoraFijoInicioComboBox(int horaFijoInicio) {
		horaFijoInicioComboBox.setSelectedIndex(horaFijoInicio - 1);
	}

	public int getHoraFijoFinCombobox() {
		return horaFijoFinCombobox.getSelectedIndex() + 1;
	}

	public void setHoraFijoFinCombobox(int horaFijoFin) {
		horaFijoFinCombobox.setSelectedIndex(horaFijoFin - 1);
	}

	public int getHoraMovilInicioCombobox() {
		return horaMovilInicioCombobox.getSelectedIndex() + 1;
	}

	public void setHoraMovilInicioCombobox(int horaMovilInicio) {
		horaMovilInicioCombobox.setSelectedIndex(horaMovilInicio - 1);
	}

	public int getHoraMovilFinCombobox() {
		return horaMovilFinCombobox.getSelectedIndex() + 1;
	}

	public void setHoraMovilFinCombobox(int horaMovilFin) {
		horaMovilFinCombobox.setSelectedIndex(horaMovilFin - 1);
	}
}
