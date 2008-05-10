package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class IntroducirDatosVisitaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField_4;
	private JComboBox comboBox_8;
	private JComboBox comboBox_7;
	private JComboBox comboBox_6;
	private JComboBox comboBox_5;
	private JTextField textField_3;
	private JTextField textField_2;
	private JComboBox comboBox_4;
	private JTextField textField_1;

	/**
	 * Create the panel
	 */
	public IntroducirDatosVisitaPanel() {
		super();
		setBorder(new TitledBorder(null, "Introducir Datos de Visita",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JTabbedPane tabbedPane;
		tabbedPane = new JTabbedPane();

		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(null, "",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null), "Introducir datos",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));
		tabbedPane.addTab("Crear visita", null, panel, null);

		JButton crearimprimirButton;
		crearimprimirButton = new JButton();
		crearimprimirButton.setText("Crear/Imprimir");

		JLabel referenciaInmuebleLabel_1;
		referenciaInmuebleLabel_1 = new JLabel();
		referenciaInmuebleLabel_1.setText("Referencia Inmueble:");

		textField_3 = new JTextField();

		JLabel fechaLabel_1;
		fechaLabel_1 = new JLabel();
		fechaLabel_1.setText("Fecha:");

		comboBox_5 = new JComboBox();

		comboBox_6 = new JComboBox();

		comboBox_7 = new JComboBox();

		JLabel horaLabel_1;
		horaLabel_1 = new JLabel();
		horaLabel_1.setText("Hora:");

		comboBox_8 = new JComboBox();

		JLabel dniClienteLabel_1;
		dniClienteLabel_1 = new JLabel();
		dniClienteLabel_1.setText("DNI Cliente:");

		textField_4 = new JTextField();
		final GroupLayout groupLayout_1 = new GroupLayout((JComponent) panel);
		groupLayout_1.setHorizontalGroup(groupLayout_1.createParallelGroup(
				GroupLayout.Alignment.LEADING)
				.addGroup(
						groupLayout_1.createSequentialGroup().addContainerGap()
								.addComponent(referenciaInmuebleLabel_1)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(textField_3,
										GroupLayout.PREFERRED_SIZE, 87,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)).addGroup(
						groupLayout_1.createSequentialGroup().addContainerGap()
								.addComponent(fechaLabel_1).addGap(4, 4, 4)
								.addComponent(comboBox_5,
										GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(comboBox_6,
										GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE).addGap(6,
										6, 6).addComponent(comboBox_7,
										GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)).addGroup(
						groupLayout_1.createSequentialGroup().addContainerGap()
								.addComponent(horaLabel_1).addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(comboBox_8,
										GroupLayout.PREFERRED_SIZE, 41,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)).addGroup(
						groupLayout_1.createSequentialGroup().addContainerGap()
								.addComponent(dniClienteLabel_1)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(textField_4,
										GroupLayout.PREFERRED_SIZE, 87,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)).addGroup(
						groupLayout_1.createSequentialGroup().addContainerGap(
								103, Short.MAX_VALUE).addComponent(
								crearimprimirButton).addContainerGap()));
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
																GroupLayout.Alignment.BASELINE)
														.addComponent(
																fechaLabel_1,
																GroupLayout.PREFERRED_SIZE,
																16,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBox_5,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBox_6,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBox_7,
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
																horaLabel_1,
																GroupLayout.PREFERRED_SIZE,
																16,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBox_8,
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
																dniClienteLabel_1,
																GroupLayout.PREFERRED_SIZE,
																16,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																textField_4,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(crearimprimirButton)
										.addGap(431, 431, 431)));
		panel.setLayout(groupLayout_1);

		final JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Introducir datos", null, panel_1, null);

		JPanel panel_2;
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new TitledBorder(null, "",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null), "Datos",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JLabel referenciaInmuebleLabel;
		referenciaInmuebleLabel = new JLabel();
		referenciaInmuebleLabel.setText("Referencia Inmueble:");

		textField_1 = new JTextField();

		JLabel fechaLabel;
		fechaLabel = new JLabel();
		fechaLabel.setText("Fecha:");

		JLabel horaLabel;
		horaLabel = new JLabel();
		horaLabel.setText("Hora:");

		comboBox_4 = new JComboBox();

		JLabel dniClienteLabel;
		dniClienteLabel = new JLabel();
		dniClienteLabel.setText("DNI Cliente:");

		textField_2 = new JTextField();

		JPanel panel_3;
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new TitledBorder(null, "",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null), "Datos Visita",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JCheckBox precioCheckBox;
		precioCheckBox = new JCheckBox();
		precioCheckBox.setText("Precio");

		JCheckBox precioCheckBox_1;
		precioCheckBox_1 = new JCheckBox();
		precioCheckBox_1.setText("No le gusta la zona");

		JCheckBox precioCheckBox_1_1;
		precioCheckBox_1_1 = new JCheckBox();
		precioCheckBox_1_1.setText("Lo quieren más alto");

		JCheckBox precioCheckBox_1_2;
		precioCheckBox_1_2 = new JCheckBox();
		precioCheckBox_1_2.setText("Muchas reformas");

		JCheckBox precioCheckBox_1_3;
		precioCheckBox_1_3 = new JCheckBox();
		precioCheckBox_1_3.setText("Quieren más habitaciones");

		JCheckBox precioCheckBox_1_4;
		precioCheckBox_1_4 = new JCheckBox();
		precioCheckBox_1_4.setText("Visita anulada comprador");

		JCheckBox precioCheckBox_1_5;
		precioCheckBox_1_5 = new JCheckBox();
		precioCheckBox_1_5.setText("Visita anulada propietario");

		JCheckBox precioCheckBox_1_6;
		precioCheckBox_1_6 = new JCheckBox();
		precioCheckBox_1_6.setText("Oscuro");

		JCheckBox precioCheckBox_1_7;
		precioCheckBox_1_7 = new JCheckBox();
		precioCheckBox_1_7.setText("Lo quieren más grande");

		JCheckBox precioCheckBox_1_8;
		precioCheckBox_1_8 = new JCheckBox();
		precioCheckBox_1_8.setText("No tiene asecensor");

		JCheckBox precioCheckBox_1_9;
		precioCheckBox_1_9 = new JCheckBox();
		precioCheckBox_1_9.setText("Quieren más baños");

		JCheckBox precioCheckBox_1_10;
		precioCheckBox_1_10 = new JCheckBox();
		precioCheckBox_1_10.setText("Concertada 2ª visita");

		JCheckBox precioCheckBox_1_11;
		precioCheckBox_1_11 = new JCheckBox();
		precioCheckBox_1_11.setText("¡Vendido en esta visita!");

		JCheckBox precioCheckBox_1_12;
		precioCheckBox_1_12 = new JCheckBox();
		precioCheckBox_1_12.setText("Plantón");

		JCheckBox precioCheckBox_1_13;
		precioCheckBox_1_13 = new JCheckBox();
		precioCheckBox_1_13.setText("Le gusta");

		JCheckBox precioCheckBox_1_14;
		precioCheckBox_1_14 = new JCheckBox();
		precioCheckBox_1_14.setText("Todo exterior");

		JCheckBox precioCheckBox_1_15;
		precioCheckBox_1_15 = new JCheckBox();
		precioCheckBox_1_15.setText("Quieren balcón/terraza");

		JCheckBox precioCheckBox_1_16;
		precioCheckBox_1_16 = new JCheckBox();
		precioCheckBox_1_16.setText("No gusta distribución");

		JCheckBox precioCheckBox_1_17;
		precioCheckBox_1_17 = new JCheckBox();
		precioCheckBox_1_17.setText("¡Alquilado en esta visita!");

		JCheckBox precioCheckBox_1_18;
		precioCheckBox_1_18 = new JCheckBox();
		precioCheckBox_1_18.setText("La gestión de venta la hace otra agencia");

		JCheckBox precioCheckBox_1_19;
		precioCheckBox_1_19 = new JCheckBox();
		precioCheckBox_1_19.setText("Podriamos peritar su piso");

		JButton introducirDatosButton;
		introducirDatosButton = new JButton();
		introducirDatosButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
			}
		});
		introducirDatosButton.setText("Introducir Datos");

		JDateChooser dateChooser;
		dateChooser = new JDateChooser();
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
																								149,
																								Short.MAX_VALUE)
																						.addComponent(
																								precioCheckBox_1_5,
																								GroupLayout.DEFAULT_SIZE,
																								149,
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
																								149,
																								Short.MAX_VALUE)
																						.addComponent(
																								precioCheckBox_1_6,
																								GroupLayout.PREFERRED_SIZE,
																								142,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								precioCheckBox_1_7,
																								GroupLayout.DEFAULT_SIZE,
																								149,
																								Short.MAX_VALUE)
																						.addComponent(
																								precioCheckBox_1_3,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.DEFAULT_SIZE,
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
																				130,
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
																				224,
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
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		panel_3.setLayout(groupLayout_4);
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
														.addGroup(
																groupLayout_3
																		.createSequentialGroup()
																		.addComponent(
																				referenciaInmuebleLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				textField_1,
																				GroupLayout.PREFERRED_SIZE,
																				97,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																groupLayout_3
																		.createSequentialGroup()
																		.addComponent(
																				fechaLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				dateChooser,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				horaLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				comboBox_4,
																				GroupLayout.PREFERRED_SIZE,
																				41,
																				GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(dniClienteLabel)
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(textField_2,
												GroupLayout.PREFERRED_SIZE, 87,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(28, Short.MAX_VALUE)));
		groupLayout_3.setVerticalGroup(groupLayout_3.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout_3.createSequentialGroup().addGap(2, 2, 2).addGroup(
						groupLayout_3.createParallelGroup(
								GroupLayout.Alignment.BASELINE).addComponent(
								referenciaInmuebleLabel,
								GroupLayout.PREFERRED_SIZE, 16,
								GroupLayout.PREFERRED_SIZE).addComponent(
								dniClienteLabel, GroupLayout.PREFERRED_SIZE,
								16, GroupLayout.PREFERRED_SIZE).addComponent(
								textField_2, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addComponent(
								textField_1, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addGroup(
						groupLayout_3.createParallelGroup(
								GroupLayout.Alignment.LEADING).addComponent(
								dateChooser, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addGroup(
								groupLayout_3.createSequentialGroup().addGap(2,
										2, 2).addComponent(fechaLabel,
										GroupLayout.PREFERRED_SIZE, 16,
										GroupLayout.PREFERRED_SIZE)).addGroup(
								groupLayout_3.createParallelGroup(
										GroupLayout.Alignment.BASELINE)
										.addComponent(horaLabel,
												GroupLayout.PREFERRED_SIZE, 16,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBox_4,
												GroupLayout.PREFERRED_SIZE, 20,
												GroupLayout.PREFERRED_SIZE)))
						.addGap(41, 41, 41)));
		groupLayout_3.linkSize(javax.swing.SwingConstants.HORIZONTAL,
				new java.awt.Component[] { textField_1, textField_2 });
		panel_2.setLayout(groupLayout_3);
		final GroupLayout groupLayout_2 = new GroupLayout((JComponent) panel_1);
		groupLayout_2.setHorizontalGroup(groupLayout_2.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout_2.createSequentialGroup().addContainerGap(332,
						Short.MAX_VALUE).addComponent(introducirDatosButton)
						.addContainerGap()).addGroup(
				groupLayout_2.createSequentialGroup().addGap(12, 12, 12)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 429,
								Short.MAX_VALUE).addGap(12, 12, 12)).addGroup(
				groupLayout_2.createSequentialGroup().addContainerGap()
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 431,
								Short.MAX_VALUE).addGap(12, 12, 12)));
		groupLayout_2
				.setVerticalGroup(groupLayout_2.createParallelGroup(
						GroupLayout.Alignment.LEADING).addGroup(
						groupLayout_2.createSequentialGroup()
								.addGap(12, 12, 12).addComponent(panel_2,
										GroupLayout.PREFERRED_SIZE, 95,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel_3,
										GroupLayout.PREFERRED_SIZE, 325,
										Short.MAX_VALUE).addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(introducirDatosButton)
								.addContainerGap()));
		panel_1.setLayout(groupLayout_2);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE,
								480, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addComponent(tabbedPane,
						GroupLayout.PREFERRED_SIZE, 506, Short.MAX_VALUE)
						.addContainerGap()));
		setLayout(groupLayout);
		//
	}

}
