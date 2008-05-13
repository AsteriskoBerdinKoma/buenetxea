package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import buenetxea.gui.Nagusia;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Visita;

import com.toedter.calendar.JDateChooser;

public class IntroducirDatosVisitaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JSpinner spinner_3;
	private JSpinner spinner_2;
	private JTextField textField_5;
	private JTextField textField;
	private JSpinner spinner_1;
	private JSpinner spinner;
	private JTextField textField_4;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField refTextfield;
	private JDateChooser dataDatos;
	private JDateChooser dateChooser_1;
	private JCheckBox precioCheckBox;
	private JCheckBox precioCheckBox_1;
	private JCheckBox precioCheckBox_1_1;
	private JCheckBox precioCheckBox_1_2;
	private JCheckBox precioCheckBox_1_3;
	private JCheckBox precioCheckBox_1_4;
	private JCheckBox precioCheckBox_1_5;
	private JCheckBox precioCheckBox_1_6;
	private JCheckBox precioCheckBox_1_7;
	private JCheckBox precioCheckBox_1_8;
	private JCheckBox precioCheckBox_1_9;
	private JCheckBox precioCheckBox_1_10;
	private JCheckBox precioCheckBox_1_11;
	private JCheckBox precioCheckBox_1_12;
	private JCheckBox precioCheckBox_1_13;
	private JCheckBox precioCheckBox_1_14;
	private JCheckBox precioCheckBox_1_15;
	private JCheckBox precioCheckBox_1_16;
	private JCheckBox precioCheckBox_1_17;
	private JCheckBox precioCheckBox_1_18;
	private JCheckBox precioCheckBox_1_19;
	private JTabbedPane tabbedPane;
	private JButton crearimprimirButton;
	private JButton introducirDatosButton;

	/**
	 * Create the panel
	 */
	public IntroducirDatosVisitaPanel() {
		super();
		setBorder(new TitledBorder(null, "Introducir Datos de Visita",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		tabbedPane = new JTabbedPane();

		JPanel crearVisitaPanel = new JPanel();
		crearVisitaPanel.setBorder(new TitledBorder(new TitledBorder(null, "",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null), "Introducir datos",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JPanel introducirDatosPanel = new JPanel();

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new TitledBorder(null, "",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null), "Datos",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new TitledBorder(null, "",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null), "Datos Visita",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		tabbedPane.addTab("Introducir resultados de visita", null,
				introducirDatosPanel, null);
		tabbedPane
				.addTab("Crear ficha de visita", null, crearVisitaPanel, null);

		crearimprimirButton = new JButton();
		crearimprimirButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				try {
					int refInm;
					try {
						refInm = Integer.valueOf(textField_3.getText().trim());
					} catch (NumberFormatException e) {
						refInm = -1;
					}
					Calendar fecha = dateChooser_1.getCalendar();
					fecha.set(Calendar.HOUR_OF_DAY, Integer.parseInt(spinner
							.getValue().toString().trim()));
					fecha.set(Calendar.MINUTE, Integer.parseInt(spinner_1
							.getValue().toString().trim()));
					String dni = textField_4.getText();
					String representante = textField.getText();
					boolean clienteExiste = Kudeatzailea.getInstance()
							.existeCliente(dni);
					Inmueble i = Kudeatzailea.getInstance().getInmueble(refInm);
					if (i != null && clienteExiste) {
						Nagusia.getInstance().showVerVisita(refInm, fecha, dni,
								representante);
					} else {
						JOptionPane jop = new JOptionPane(
								"El cliente o el inmueble introducidos no existen.",
								JOptionPane.ERROR_MESSAGE);
						jop.createDialog("Error en los datos").setVisible(true);
					}

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		crearimprimirButton.setText("Ver ficha visita");

		JLabel referenciaInmuebleLabel_1;
		referenciaInmuebleLabel_1 = new JLabel();
		referenciaInmuebleLabel_1.setText("Referencia Inmueble:");

		textField_3 = new JTextField();

		JLabel fechaLabel_1;
		fechaLabel_1 = new JLabel();
		fechaLabel_1.setText("Fecha:");

		JLabel horaLabel_1;
		horaLabel_1 = new JLabel();
		horaLabel_1.setText("Hora:");

		JLabel dniClienteLabel_1;
		dniClienteLabel_1 = new JLabel();
		dniClienteLabel_1.setText("DNI Cliente:");

		textField_4 = new JTextField();

		dataDatos = new JDateChooser();
		dataDatos.setDateFormatString("d/M/yyyy");
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		dataDatos.setCalendar(cal);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setDateFormatString("d/M/yyyy");
		Calendar cal2 = new GregorianCalendar();
		cal2.setTime(new Date());
		dateChooser_1.setCalendar(cal2);

		spinner = new JSpinner();

		JLabel label;
		label = new JLabel();
		label.setText(":");

		spinner_1 = new JSpinner();

		JLabel representanteLabel;
		representanteLabel = new JLabel();
		representanteLabel.setText("Representante:");

		introducirDatosButton = new JButton();
		introducirDatosButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				Visita v = generarDatosVisita();
				try {
					boolean clienteExiste = Kudeatzailea.getInstance()
							.existeCliente(textField_2.getText());
					Inmueble i = Kudeatzailea.getInstance().getInmueble(
							Integer.valueOf(refTextfield.getText().trim()));
					if (i != null && clienteExiste) {
						boolean visitaOk = Kudeatzailea.getInstance()
								.crearVisita(v);
						if (visitaOk) {
							JOptionPane jop = new JOptionPane(
									"Visita introducida correctamente.",
									JOptionPane.INFORMATION_MESSAGE);
							jop.createDialog("Visita introducida").setVisible(
									true);
						} else {
							JOptionPane jop = new JOptionPane(
									"No se ha podido introducir la visita.",
									JOptionPane.ERROR_MESSAGE);
							jop.createDialog("Error al introducir la visita")
									.setVisible(true);
						}
					} else {
						JOptionPane jop = new JOptionPane(
								"El cliente o el inmueble introducidos no existen.",
								JOptionPane.ERROR_MESSAGE);
						jop.createDialog("Error en los datos").setVisible(true);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		introducirDatosButton.setText("Introducir Datos");

		JLabel representanteLabel_1;
		representanteLabel_1 = new JLabel();
		representanteLabel_1.setText("Representante");

		textField_5 = new JTextField();

		spinner_2 = new JSpinner();

		JLabel label_1;
		label_1 = new JLabel();
		label_1.setText(":");

		spinner_3 = new JSpinner();

		textField = new JTextField();

		JLabel referenciaInmuebleLabel;
		referenciaInmuebleLabel = new JLabel();
		referenciaInmuebleLabel.setText("Referencia Inmueble:");

		refTextfield = new JTextField();

		JLabel fechaLabel;
		fechaLabel = new JLabel();
		fechaLabel.setText("Fecha:");

		JLabel horaLabel;
		horaLabel = new JLabel();
		horaLabel.setText("Hora:");

		JLabel dniClienteLabel;
		dniClienteLabel = new JLabel();
		dniClienteLabel.setText("DNI Cliente:");

		textField_2 = new JTextField();

		precioCheckBox = new JCheckBox();
		precioCheckBox.setText("Precio");

		precioCheckBox_1 = new JCheckBox();
		precioCheckBox_1.setText("No le gusta la zona");

		precioCheckBox_1_1 = new JCheckBox();
		precioCheckBox_1_1.setText("Lo quieren más alto");

		precioCheckBox_1_2 = new JCheckBox();
		precioCheckBox_1_2.setText("Muchas reformas");

		precioCheckBox_1_3 = new JCheckBox();
		precioCheckBox_1_3.setText("Quieren más habitaciones");

		precioCheckBox_1_4 = new JCheckBox();
		precioCheckBox_1_4.setText("Visita anulada comprador");

		precioCheckBox_1_5 = new JCheckBox();
		precioCheckBox_1_5.setText("Visita anulada propietario");

		precioCheckBox_1_6 = new JCheckBox();
		precioCheckBox_1_6.setText("Oscuro");

		precioCheckBox_1_7 = new JCheckBox();
		precioCheckBox_1_7.setText("Lo quieren más grande");

		precioCheckBox_1_8 = new JCheckBox();
		precioCheckBox_1_8.setText("No tiene asecensor");

		precioCheckBox_1_9 = new JCheckBox();
		precioCheckBox_1_9.setText("Quieren más baños");

		precioCheckBox_1_10 = new JCheckBox();
		precioCheckBox_1_10.setText("Concertada 2ª visita");

		precioCheckBox_1_11 = new JCheckBox();
		precioCheckBox_1_11.setText("¡Vendido en esta visita!");

		precioCheckBox_1_12 = new JCheckBox();
		precioCheckBox_1_12.setText("Plantón");

		precioCheckBox_1_13 = new JCheckBox();
		precioCheckBox_1_13.setText("Le gusta");

		precioCheckBox_1_14 = new JCheckBox();
		precioCheckBox_1_14.setText("Todo exterior");

		precioCheckBox_1_15 = new JCheckBox();
		precioCheckBox_1_15.setText("Quieren balcón/terraza");

		precioCheckBox_1_16 = new JCheckBox();
		precioCheckBox_1_16.setText("No gusta distribución");

		precioCheckBox_1_17 = new JCheckBox();
		precioCheckBox_1_17.setText("¡Alquilado en esta visita!");

		precioCheckBox_1_18 = new JCheckBox();
		precioCheckBox_1_18.setText("La gestión de venta la hace otra agencia");

		precioCheckBox_1_19 = new JCheckBox();
		precioCheckBox_1_19.setText("Podriamos peritar su piso");

		final GroupLayout groupLayout_1 = new GroupLayout(
				(JComponent) crearVisitaPanel);
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
														.addGroup(
																groupLayout_1
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addGroup(
																				groupLayout_1
																						.createSequentialGroup()
																						.addGroup(
																								groupLayout_1
																										.createParallelGroup(
																												GroupLayout.Alignment.LEADING)
																										.addComponent(
																												dniClienteLabel_1)
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
																																						.addGroup(
																																								groupLayout_1
																																										.createParallelGroup(
																																												GroupLayout.Alignment.LEADING)
																																										.addComponent(
																																												fechaLabel_1)
																																										.addComponent(
																																												horaLabel_1))
																																						.addGap(
																																								83,
																																								83,
																																								83)
																																						.addGroup(
																																								groupLayout_1
																																										.createParallelGroup(
																																												GroupLayout.Alignment.LEADING)
																																										.addGroup(
																																												groupLayout_1
																																														.createSequentialGroup()
																																														.addComponent(
																																																spinner,
																																																GroupLayout.PREFERRED_SIZE,
																																																40,
																																																GroupLayout.PREFERRED_SIZE)
																																														.addPreferredGap(
																																																LayoutStyle.ComponentPlacement.RELATED)
																																														.addComponent(
																																																label)
																																														.addPreferredGap(
																																																LayoutStyle.ComponentPlacement.RELATED)
																																														.addComponent(
																																																spinner_1,
																																																GroupLayout.PREFERRED_SIZE,
																																																39,
																																																GroupLayout.PREFERRED_SIZE))
																																										.addComponent(
																																												dateChooser_1,
																																												GroupLayout.DEFAULT_SIZE,
																																												91,
																																												Short.MAX_VALUE)
																																										.addComponent(
																																												textField_3,
																																												GroupLayout.DEFAULT_SIZE,
																																												91,
																																												Short.MAX_VALUE)
																																										.addComponent(
																																												textField_4,
																																												GroupLayout.DEFAULT_SIZE,
																																												91,
																																												Short.MAX_VALUE)))
																																		.addGroup(
																																				groupLayout_1
																																						.createSequentialGroup()
																																						.addComponent(
																																								representanteLabel)
																																						.addPreferredGap(
																																								LayoutStyle.ComponentPlacement.RELATED)
																																						.addComponent(
																																								textField,
																																								GroupLayout.DEFAULT_SIZE,
																																								127,
																																								Short.MAX_VALUE)))
																														.addPreferredGap(
																																LayoutStyle.ComponentPlacement.RELATED)))
																						.addGap(
																								167,
																								167,
																								167))
																		.addComponent(
																				referenciaInmuebleLabel_1))
														.addComponent(
																crearimprimirButton,
																GroupLayout.Alignment.TRAILING))));
		groupLayout_1
				.setVerticalGroup(groupLayout_1
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout_1
										.createSequentialGroup()
										.addGap(13, 13, 13)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																referenciaInmuebleLabel_1,
																GroupLayout.PREFERRED_SIZE,
																16,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_3,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																fechaLabel_1,
																GroupLayout.PREFERRED_SIZE,
																16,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																dateChooser_1,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																horaLabel_1,
																GroupLayout.PREFERRED_SIZE,
																16,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																groupLayout_1
																		.createSequentialGroup()
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout_1
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								spinner,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								label)
																						.addComponent(
																								spinner_1,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																groupLayout_1
																		.createSequentialGroup()
																		.addComponent(
																				dniClienteLabel_1,
																				GroupLayout.PREFERRED_SIZE,
																				16,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(
																				10,
																				10,
																				10)
																		.addGroup(
																				groupLayout_1
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								representanteLabel)
																						.addComponent(
																								textField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																textField_4,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18, 18, 18).addComponent(
												crearimprimirButton).addGap(
												312, 312, 312)));
		crearVisitaPanel.setLayout(groupLayout_1);

		final GroupLayout groupLayout_3 = new GroupLayout((JComponent) panel_2);
		groupLayout_3
				.setHorizontalGroup(groupLayout_3
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout_3
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout_3
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																referenciaInmuebleLabel)
														.addComponent(
																fechaLabel)
														.addComponent(
																representanteLabel_1))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_3
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																groupLayout_3
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout_3
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								dataDatos,
																								0,
																								0,
																								Short.MAX_VALUE)
																						.addComponent(
																								refTextfield,
																								GroupLayout.DEFAULT_SIZE,
																								149,
																								Short.MAX_VALUE))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED,
																				12,
																				Short.MAX_VALUE)
																		.addGroup(
																				groupLayout_3
																						.createParallelGroup(
																								GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								groupLayout_3
																										.createSequentialGroup()
																										.addComponent(
																												dniClienteLabel)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												textField_2,
																												GroupLayout.PREFERRED_SIZE,
																												87,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								groupLayout_3
																										.createSequentialGroup()
																										.addComponent(
																												horaLabel)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												spinner_2,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												label_1)
																										.addPreferredGap(
																												LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												spinner_3,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))))
														.addComponent(
																textField_5,
																GroupLayout.DEFAULT_SIZE,
																310,
																Short.MAX_VALUE))));
		groupLayout_3
				.setVerticalGroup(groupLayout_3
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout_3
										.createSequentialGroup()
										.addGap(2, 2, 2)
										.addGroup(
												groupLayout_3
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																referenciaInmuebleLabel,
																GroupLayout.PREFERRED_SIZE,
																16,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_2,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																dniClienteLabel,
																GroupLayout.PREFERRED_SIZE,
																16,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																refTextfield,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_3
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addGroup(
																groupLayout_3
																		.createParallelGroup(
																				GroupLayout.Alignment.LEADING)
																		.addGroup(
																				groupLayout_3
																						.createParallelGroup(
																								GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								spinner_3,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								label_1)
																						.addComponent(
																								spinner_2,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								horaLabel,
																								GroupLayout.PREFERRED_SIZE,
																								16,
																								GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				groupLayout_3
																						.createSequentialGroup()
																						.addGap(
																								4,
																								4,
																								4)
																						.addComponent(
																								fechaLabel,
																								GroupLayout.PREFERRED_SIZE,
																								16,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																dataDatos,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												groupLayout_3
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addComponent(
																representanteLabel_1)
														.addComponent(
																textField_5,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		groupLayout_3.linkSize(javax.swing.SwingConstants.VERTICAL,
				new java.awt.Component[] { refTextfield, textField_2 });
		panel_2.setLayout(groupLayout_3);
		final GroupLayout groupLayout_4 = new GroupLayout((JComponent) panel_3);
		groupLayout_4
				.setHorizontalGroup(groupLayout_4
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout_4
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout_4
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																groupLayout_4
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout_4
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								precioCheckBox_1_17,
																								GroupLayout.DEFAULT_SIZE,
																								171,
																								Short.MAX_VALUE)
																						.addComponent(
																								precioCheckBox_1_5,
																								GroupLayout.DEFAULT_SIZE,
																								171,
																								Short.MAX_VALUE)
																						.addComponent(
																								precioCheckBox_1,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_1,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_2,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_4,
																								GroupLayout.DEFAULT_SIZE,
																								171,
																								Short.MAX_VALUE)
																						.addComponent(
																								precioCheckBox_1_6,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_7,
																								GroupLayout.DEFAULT_SIZE,
																								171,
																								Short.MAX_VALUE)
																						.addComponent(
																								precioCheckBox_1_3,
																								GroupLayout.DEFAULT_SIZE,
																								171,
																								Short.MAX_VALUE)
																						.addComponent(
																								precioCheckBox))
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayout_4
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								precioCheckBox_1_8,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_9,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_10,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_11,
																								GroupLayout.PREFERRED_SIZE,
																								170,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_12,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_13,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_14,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_15,
																								GroupLayout.PREFERRED_SIZE,
																								185,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_16,
																								GroupLayout.PREFERRED_SIZE,
																								173,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(
																				67,
																				67,
																				67))
														.addGroup(
																groupLayout_4
																		.createSequentialGroup()
																		.addComponent(
																				precioCheckBox_1_18,
																				GroupLayout.PREFERRED_SIZE,
																				271,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				152,
																				Short.MAX_VALUE))
														.addGroup(
																groupLayout_4
																		.createSequentialGroup()
																		.addComponent(
																				precioCheckBox_1_19,
																				GroupLayout.PREFERRED_SIZE,
																				177,
																				GroupLayout.PREFERRED_SIZE)
																		.addContainerGap(
																				246,
																				Short.MAX_VALUE)))));
		groupLayout_4
				.setVerticalGroup(groupLayout_4
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout_4
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout_4
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addGroup(
																groupLayout_4
																		.createSequentialGroup()
																		.addComponent(
																				precioCheckBox,
																				GroupLayout.PREFERRED_SIZE,
																				23,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_1)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_2)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_3)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_4)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_5)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_6)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_7))
														.addGroup(
																groupLayout_4
																		.createSequentialGroup()
																		.addComponent(
																				precioCheckBox_1_8)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_9)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_10)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_11)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_12)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_13)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_14)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_15)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				precioCheckBox_1_16)))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(precioCheckBox_1_17)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(precioCheckBox_1_18)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(precioCheckBox_1_19)
										.addContainerGap(17, Short.MAX_VALUE)));
		panel_3.setLayout(groupLayout_4);
		final GroupLayout groupLayout_2 = new GroupLayout(
				(JComponent) introducirDatosPanel);
		groupLayout_2.setHorizontalGroup(groupLayout_2.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout_2.createSequentialGroup().addContainerGap(354,
						Short.MAX_VALUE).addComponent(introducirDatosButton)
						.addContainerGap()).addGroup(
				groupLayout_2.createSequentialGroup().addContainerGap()
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 453,
								Short.MAX_VALUE).addGap(12, 12, 12)).addGroup(
				groupLayout_2.createSequentialGroup().addGap(12, 12, 12)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 451,
								Short.MAX_VALUE).addGap(12, 12, 12)));
		groupLayout_2
				.setVerticalGroup(groupLayout_2.createParallelGroup(
						GroupLayout.Alignment.LEADING).addGroup(
						groupLayout_2.createSequentialGroup()
								.addGap(12, 12, 12).addComponent(panel_2,
										GroupLayout.PREFERRED_SIZE, 113,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel_3,
										GroupLayout.PREFERRED_SIZE, 338,
										Short.MAX_VALUE).addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(introducirDatosButton)
								.addContainerGap()));
		introducirDatosPanel.setLayout(groupLayout_2);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								480, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(tabbedPane,
				GroupLayout.PREFERRED_SIZE, 530, Short.MAX_VALUE));
		setLayout(groupLayout);
		//
	}

	public Visita generarDatosVisita() {
		Visita v = null;
		try {
			int refInmueble = Integer.valueOf(refTextfield.getText().trim());
			Calendar fecha = dataDatos.getCalendar();
			fecha.set(Calendar.HOUR_OF_DAY, Integer.parseInt(spinner_2
					.getValue().toString()));
			fecha.set(Calendar.MINUTE, Integer.parseInt(spinner_3.getValue()
					.toString()));
			String dni = textField_2.getText();
			String representante = textField_5.getText();
			v = new Visita(fecha, representante, precioCheckBox.isSelected(),
					precioCheckBox_1.isSelected(), precioCheckBox_1_1
							.isSelected(), precioCheckBox_1_2.isSelected(),
					precioCheckBox_1_3.isSelected(), precioCheckBox_1_4
							.isSelected(), precioCheckBox_1_5.isSelected(),
					precioCheckBox_1_6.isSelected(), precioCheckBox_1_7
							.isSelected(), precioCheckBox_1_8.isSelected(),
					precioCheckBox_1_9.isSelected(), precioCheckBox_1_10
							.isSelected(), precioCheckBox_1_11.isSelected(),
					precioCheckBox_1_12.isSelected(), precioCheckBox_1_13
							.isSelected(), precioCheckBox_1_14.isSelected(),
					precioCheckBox_1_15.isSelected(), precioCheckBox_1_16
							.isSelected(), precioCheckBox_1_17.isSelected(),
					precioCheckBox_1_18.isSelected(), precioCheckBox_1_19
							.isSelected(), refInmueble, dni);
			return v;
		} catch (Exception e) {
			e.printStackTrace();
			return v;
		}
	}

}
