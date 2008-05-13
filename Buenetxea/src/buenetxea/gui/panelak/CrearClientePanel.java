package buenetxea.gui.panelak;

import java.awt.ComponentOrientation;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

import buenetxea.gui.dialogs.CrearClienteDialog;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Cliente;
import buenetxea.objektuak.Preferencias;

import com.toedter.calendar.JDateChooser;

public class CrearClientePanel extends JPanel {

	private JSpinner spinner_altura;
	private JSpinner spinner_habithasta;
	private JFormattedTextField formattedTextField_1;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField_dir;
	private JTextArea textArea;
	private JTextField textField_tipo;
	private JTextField textField_4_zona;
	private JTextField textField_presupuesto;
	private JSpinner spinner_aseos;
	private JSpinner spinner_ba�os;
	private JSpinner spinner_habitdesde;
	private JSpinner spinner_hastametros;
	private JSpinner spinner_desdemetros;
	private JComboBox comboBox;
	private JRadioButton actualRadioButton;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField_nombre;
	private JFormattedTextField formattedTextField;
	private JTextField textField_asesor;
	private JTextField textField_medio;
	private JTextField textField_apellido2;
	private JTextField textField_apellido1;
	private JDateChooser dateChooser;
	private JRadioButton radioButton;
	private JCheckBox exteriorCheckBox;

	private CrearClienteDialog jabea;
	private boolean closeAfterSave;

	private Kudeatzailea kud;

	/**
	 * Create the panel
	 * 
	 * @throws ParseException
	 */
	public CrearClientePanel() {
		super();

		try {
			closeAfterSave = false;

			kud = Kudeatzailea.getInstance();

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

			textField_apellido1 = new JTextField();

			textField_apellido2 = new JTextField();

			textField_medio = new JTextField();

			textField_asesor = new JTextField();

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

			try {
				formattedTextField = new JFormattedTextField(new MaskFormatter(
						"########U"));
				formattedTextField.setInputVerifier(new ValidateDNI());
				formattedTextField.setColumns(9);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				formattedTextField_1 = new JFormattedTextField(
						new MaskFormatter("#########"));
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			textField_nombre = new JTextField();

			JLabel nacionalidadLabel;
			nacionalidadLabel = new JLabel();
			nacionalidadLabel.setText("Nacionalidad:");

			comboBox = new JComboBox(kud.getNacionalidades());

			JLabel fechaLabel;
			fechaLabel = new JLabel();
			fechaLabel.setText("Fecha:");

			actualRadioButton = new JRadioButton();
			actualRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent arg0) {
					if (actualRadioButton.isSelected())
						dateChooser.setEnabled(false);
					else
						dateChooser.setEnabled(true);
				}
			});
			buttonGroup.add(actualRadioButton);
			actualRadioButton.setSelected(true);
			actualRadioButton.setText("Actual");

			radioButton = new JRadioButton();
			radioButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					if (radioButton.isSelected())
						dateChooser.setEnabled(true);
					else
						dateChooser.setEnabled(false);
				}
			});
			buttonGroup.add(radioButton);

			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("d/M/yyyy");
			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			dateChooser.setCalendar(cal);
			dateChooser.setEnabled(false);

			JPanel panel_1;
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null,
					"Preferencias del cliente",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JLabel zonaLabel;
			zonaLabel = new JLabel();
			zonaLabel.setText("Zona:");

			JLabel direccionLabel;
			direccionLabel = new JLabel();
			direccionLabel.setText("Direccion:");

			JButton guardarButton;
			guardarButton = new JButton();
			guardarButton.addActionListener(new ActionListener() {

				public void actionPerformed(final ActionEvent arg0) {
					String dni = formattedTextField.getText();
					String nombre = textField_nombre.getText();
					String apellido1 = textField_apellido1.getText();
					String apellido2 = textField_apellido2.getText();
					String direccion = textField_dir.getText();
					String nacionalidad = comboBox.getSelectedItem().toString();
					int telefono = Integer.parseInt(formattedTextField_1
							.getText());
					String medio = textField_medio.getText();
					String asesor = textField_asesor.getText();

					Calendar fecha;
					if (radioButton.isSelected()) {
						fecha = new GregorianCalendar();
						fecha.setTime(new Date());
					} else
						fecha = dateChooser.getCalendar();
						String zona = textField_4_zona.getText();
						String tipo = textField_tipo.getText();
						int metrosDesde = Integer.parseInt(spinner_desdemetros.getValue().toString());
						int metrosHasta = Integer.parseInt(spinner_hastametros.getValue().toString());
						int habitDesde = Integer.parseInt(spinner_habitdesde.getValue().toString());
						int habitHasta = Integer.parseInt(spinner_habithasta.getValue().toString());
						int ba�os = Integer.parseInt(spinner_ba�os.getValue().toString());
						int aseos = Integer.parseInt(spinner_aseos.getValue().toString());
						boolean exterior = exteriorCheckBox.isSelected(); 
						double presupuesto = Integer.parseInt(textField_presupuesto.getText());
						String observaciones = textArea.getText();
						int altura = Integer.parseInt(spinner_altura.getValue().toString());
						Preferencias preferencias = new Preferencias (dni,tipo,exterior,metrosDesde,metrosHasta,
								zona,ba�os,aseos,presupuesto,observaciones,habitDesde,habitHasta,altura);
					
						Cliente cliente = new Cliente(dni, nombre, apellido1,
							apellido2, direccion, nacionalidad, fecha,
							telefono, medio, asesor);
					try {
						if (Kudeatzailea.getInstance().crearCliente(cliente) && Kudeatzailea.getInstance().insertPreferencias(preferencias)) {
							JOptionPane jop = new JOptionPane(
									"El cliente se ha creado correctamente con las preferencias introducidas.",
									JOptionPane.INFORMATION_MESSAGE);
							jop.createDialog("Cliente creado").setVisible(true);

							if (closeAfterSave) {
								jabea.setSavedDNI(dni);
								jabea.dispose();
							}
						} else {
							JOptionPane jop = new JOptionPane(
									"No se ha podido crear el cliente.",
									JOptionPane.ERROR_MESSAGE);
							jop.createDialog("Error al crear el cliente")
									.setVisible(true);
						}
					} catch (SQLException e) {
						e.printStackTrace();

						JOptionPane jop = new JOptionPane(
								"No se ha podido crear el cliente." + "\n"
										+ e.getMessage(),
								JOptionPane.ERROR_MESSAGE);
						jop.createDialog("Error al crear el cliente")
								.setVisible(true);
					} catch (ClassNotFoundException e) {
						e.printStackTrace();

						JOptionPane jop = new JOptionPane(
								"No se ha podido crear el cliente.",
								JOptionPane.ERROR_MESSAGE);
						jop.createDialog("Error al crear el cliente")
								.setVisible(true);
					} catch (HeadlessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
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

			spinner_desdemetros = new JSpinner();

			JLabel m2Label;
			m2Label = new JLabel();
			m2Label.setText("m�");

			JLabel hastaLabel;
			hastaLabel = new JLabel();
			hastaLabel.setText("  hasta");

			spinner_hastametros = new JSpinner();

			JLabel m2Label_1;
			m2Label_1 = new JLabel();
			m2Label_1.setText("m�");

			exteriorCheckBox = new JCheckBox();
			exteriorCheckBox
					.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			exteriorCheckBox.setText("Exterior");

			JLabel numHabitacionesLabel;
			numHabitacionesLabel = new JLabel();
			numHabitacionesLabel.setText("Num. habitaciones:");

			spinner_habitdesde = new JSpinner();

			JLabel label;
			label = new JLabel();
			label.setText("Ba�os:");

			spinner_ba�os = new JSpinner();

			JLabel aseosLabel;
			aseosLabel = new JLabel();
			aseosLabel.setText("Aseos:");

			spinner_aseos = new JSpinner();

			JLabel presupuestoLabel;
			presupuestoLabel = new JLabel();
			presupuestoLabel.setText("Presupuesto:");

			textField_presupuesto = new JTextField();

			JLabel label_1;
			label_1 = new JLabel();
			label_1.setText("�");

			textField_4_zona = new JTextField();

			textField_tipo = new JTextField();

			JLabel obserbacionesLabel;
			obserbacionesLabel = new JLabel();
			obserbacionesLabel.setText("Observaciones:");

			JScrollPane scrollPane;
			scrollPane = new JScrollPane();

			textArea = new JTextArea();
			scrollPane.setViewportView(textArea);

			textField_dir = new JTextField();

			JLabel desdeLabel_1;
			desdeLabel_1 = new JLabel();
			desdeLabel_1.setText("Desde");

			JLabel hastaLabel_1;
			hastaLabel_1 = new JLabel();
			hastaLabel_1.setText("  hasta");

			spinner_habithasta = new JSpinner();

			final GroupLayout groupLayout_1 = new GroupLayout(panel);
			groupLayout_1.setHorizontalGroup(
				groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(groupLayout_1.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(direccionLabel)
							.addComponent(nacionalidadLabel)
							.addComponent(apellido1Label)
							.addComponent(dniLabel)
							.addComponent(medioLabel)
							.addComponent(fechaLabel))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(groupLayout_1.createSequentialGroup()
								.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addGroup(groupLayout_1.createSequentialGroup()
										.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(nombreLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(textField_nombre, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE))
									.addGroup(groupLayout_1.createSequentialGroup()
										.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
											.addComponent(textField_dir, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
											.addGroup(groupLayout_1.createSequentialGroup()
												.addComponent(textField_apellido1, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(textField_apellido2, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
											.addGroup(groupLayout_1.createSequentialGroup()
												.addComponent(textField_medio, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(asesorLabel)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(textField_asesor, GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
											.addGroup(groupLayout_1.createSequentialGroup()
												.addComponent(actualRadioButton)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(radioButton)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
							.addGroup(groupLayout_1.createSequentialGroup()
								.addComponent(comboBox, 0, 71, Short.MAX_VALUE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(telefonoLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
								.addGap(104, 104, 104)))
						.addContainerGap())
			);
			groupLayout_1.setVerticalGroup(
				groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(groupLayout_1.createSequentialGroup()
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(dniLabel)
							.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(nombreLabel)
							.addComponent(textField_nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(apellido1Label)
							.addComponent(textField_apellido1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_apellido2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(nacionalidadLabel)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(telefonoLabel)
							.addComponent(formattedTextField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(direccionLabel)
							.addComponent(textField_dir, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(medioLabel, GroupLayout.Alignment.LEADING)
							.addGroup(groupLayout_1.createSequentialGroup()
								.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(textField_asesor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(asesorLabel)
									.addComponent(textField_medio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addGroup(groupLayout_1.createSequentialGroup()
										.addGap(4, 4, 4)
										.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
											.addComponent(actualRadioButton)
											.addComponent(fechaLabel)))
									.addGroup(groupLayout_1.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
											.addComponent(dateChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(radioButton))))))
						.addGap(35, 35, 35))
			);
			panel.setLayout(groupLayout_1);

			JLabel alturaLabel;
			alturaLabel = new JLabel();
			alturaLabel.setText("Altura");

			spinner_altura = new JSpinner();

			JLabel pisoLabel;
			pisoLabel = new JLabel();
			pisoLabel.setText("piso");

			final GroupLayout groupLayout_2 = new GroupLayout(panel_1);
			groupLayout_2.setHorizontalGroup(
				groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(groupLayout_2.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
							.addComponent(exteriorCheckBox)
							.addGroup(groupLayout_2.createSequentialGroup()
								.addComponent(presupuestoLabel)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(textField_presupuesto, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(label_1))
							.addComponent(obserbacionesLabel)
							.addGroup(groupLayout_2.createSequentialGroup()
								.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.TRAILING)
									.addGroup(groupLayout_2.createSequentialGroup()
										.addComponent(label)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(spinner_ba�os, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(aseosLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(spinner_aseos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
										.addComponent(alturaLabel))
									.addGroup(GroupLayout.Alignment.LEADING, groupLayout_2.createSequentialGroup()
										.addComponent(zonaLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(textField_4_zona, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
									.addGroup(GroupLayout.Alignment.LEADING, groupLayout_2.createSequentialGroup()
										.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
											.addComponent(metrosCuadradosLabel)
											.addComponent(numHabitacionesLabel))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
											.addGroup(groupLayout_2.createSequentialGroup()
												.addComponent(desdeLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(spinner_habitdesde, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout_2.createSequentialGroup()
												.addComponent(desdeLabel)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(spinner_desdemetros, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(m2Label)))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
											.addComponent(hastaLabel_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
											.addComponent(hastaLabel))))
								.addGap(4, 4, 4)
								.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
									.addGroup(groupLayout_2.createSequentialGroup()
										.addComponent(tipoLabel)
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(textField_tipo, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
									.addGroup(groupLayout_2.createSequentialGroup()
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
											.addGroup(groupLayout_2.createSequentialGroup()
												.addComponent(spinner_hastametros, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(m2Label_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
											.addGroup(groupLayout_2.createSequentialGroup()
												.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
													.addComponent(spinner_altura)
													.addComponent(spinner_habithasta, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(pisoLabel)))))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
						.addGap(1, 1, 1))
			);
			groupLayout_2.setVerticalGroup(
				groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(groupLayout_2.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(zonaLabel)
							.addComponent(textField_4_zona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField_tipo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(tipoLabel))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(metrosCuadradosLabel)
							.addComponent(desdeLabel)
							.addComponent(spinner_desdemetros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(m2Label)
							.addComponent(hastaLabel)
							.addComponent(spinner_hastametros, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(m2Label_1))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(groupLayout_2.createSequentialGroup()
								.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(numHabitacionesLabel)
									.addComponent(desdeLabel_1)
									.addComponent(spinner_habitdesde, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(label)
									.addComponent(spinner_ba�os, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(aseosLabel)
									.addComponent(spinner_aseos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(alturaLabel)
									.addComponent(spinner_altura, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(pisoLabel))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(exteriorCheckBox)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(presupuestoLabel)
									.addComponent(textField_presupuesto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(label_1))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(obserbacionesLabel))
							.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(hastaLabel_1)
								.addComponent(spinner_habithasta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
						.addContainerGap())
			);
			panel_1.setLayout(groupLayout_2);
			final GroupLayout groupLayout = new GroupLayout(this);
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addComponent(panel_1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
							.addComponent(guardarButton))
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(guardarButton)
						.addContainerGap())
			);
			setLayout(groupLayout);
			//
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	public final class ValidateDNI extends InputVerifier {

		String pattern = "RWAGMYFPDXBNJZSQVHLCKET";

		/**
		 * Verifica un DNI.
		 */
		private boolean verifyDNI(String DNI) {
			// Eliminamos caracteres de separaci�n.
			DNI = DNI.replaceAll("[.-]", "");
			if (DNI.length() != 9)
				return false;
			// El �ltimo car�cter debe ser una letra
			if (!Character.isLetter(DNI.charAt(8)))
				return false;
			int digits;
			try {
				digits = Integer.parseInt(DNI.substring(0, 8));
			} catch (NumberFormatException e) {
				return false;
			}
			// El algoritmo m�gico
			int pos = (digits % 23);
			if (pos == 0)
				pos = pattern.length();
			pos = pos - 1; // Las tiras en Java est�n basadas en cero!
			return (pattern.charAt(pos) == DNI.charAt(8));
		}

		@Override
		public boolean verify(JComponent input) {
			boolean b = false;
			if (input instanceof JFormattedTextField) {
				String value = ((JFormattedTextField) input).getText();
				if (value == null)
					return true;
				b = verifyDNI(value);
			}
			if (!b) {
				JOptionPane jop = new JOptionPane(
						"El DNI introducido no es correcto. Introd�zcalo de nuevo.",
						JOptionPane.ERROR_MESSAGE);
				jop.createDialog("DNI incorrecto").setVisible(true);
			}
			return b;
		}
	}

	public void setCloseAfterSave(CrearClienteDialog owner, boolean close) {
		this.jabea = owner;
		this.closeAfterSave = close;
	}
}
