package buenetxea.gui.panelak;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import buenetxea.gui.dialogs.BuscarClienteDialog;
import buenetxea.gui.dialogs.CrearClienteDialog;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Inmueble;

public class VenderInmueblePanel extends JPanel {

	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JTextField textField;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFormattedTextField dniTextField;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel errorLabel;

	private Inmueble inmueble;

	private Kudeatzailea kud;

	/**
	 * Create the panel
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public VenderInmueblePanel() {
		super();

		try {
			kud = Kudeatzailea.getInstance();

			inmueble = new Inmueble(1, "zona", "direccion", false);

			setBorder(new TitledBorder(null, "Vender Inmueble",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JPanel panel_1;
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Datos del Inmueble",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JPanel panel_2;
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Cliente comprador",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JLabel dniLabel;
			dniLabel = new JLabel();
			dniLabel.setText("DNI:");

			JButton buscarClientesButton;
			buscarClientesButton = new JButton();
			buscarClientesButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent arg0) {
					BuscarClienteDialog bcd = new BuscarClienteDialog();
					bcd.setResultField(dniTextField);
					bcd.pack();
					bcd.setLocationRelativeTo(null);
					bcd.setVisible(true);
				}
			});
			buscarClientesButton.setText("Buscar Cliente");

			dniTextField = new JFormattedTextField(new MaskFormatter(
					"########U"));
			dniTextField.setInputVerifier(new InputVerifier() {

				@Override
				public boolean verify(JComponent input) {
					try {
						boolean b = kud.existeCliente(dniTextField.getText());
						if (!b) {
							errorLabel
									.setText("No existen clientes con este DNI.");
							dniTextField.setText("");
						} else
							errorLabel.setText("");
						return b;
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					} catch (SQLException e) {
						e.printStackTrace();
						return false;
					}
				}
			});
			dniTextField.setColumns(9);

			JButton venderInmuebleButton;
			venderInmuebleButton = new JButton();
			venderInmuebleButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					CrearClienteDialog ccd = new CrearClienteDialog();
					ccd.setResultField(dniTextField);
					ccd.pack();
					ccd.setLocationRelativeTo(null);
					ccd.setVisible(true);
				}
			});
			venderInmuebleButton.setText("Vender inmueble");

			JLabel referenciaLabel;
			referenciaLabel = new JLabel();
			referenciaLabel.setText("Referencia:");

			JLabel label;
			label = new JLabel();
			label.setText("Dirección:");

			label_1 = new JLabel();
			label_1.setText("New JLabel");

			JLabel zonaLabel;
			zonaLabel = new JLabel();
			zonaLabel.setText("Zona:");

			label_2 = new JLabel();
			label_2.setText("New JLabel");

			label_3 = new JLabel();
			label_3.setText("New JLabel");

			JPanel panel;
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Datos de venta",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JLabel precioDeVentaLabel;
			precioDeVentaLabel = new JLabel();
			precioDeVentaLabel.setText("Precio de venta:");

			JLabel honorariosLabel;
			honorariosLabel = new JLabel();
			honorariosLabel.setText("Honorarios:");

			JLabel precioDelPropietarioLabel;
			precioDelPropietarioLabel = new JLabel();
			precioDelPropietarioLabel.setText("Precio del propietario:");

			textField = new JTextField();

			textField_1 = new JTextField();

			textField_2 = new JTextField();

			JLabel ivaLabel;
			ivaLabel = new JLabel();
			ivaLabel.setText("IVA:");

			textField_3 = new JTextField();

			JLabel label_4;
			label_4 = new JLabel();
			label_4.setText("€");

			JLabel label_5;
			label_5 = new JLabel();
			label_5.setText("€");

			errorLabel = new JLabel();
			errorLabel.setForeground(new Color(255, 0, 0));
			errorLabel.setText("New JLabel");

			JButton crearClienteNuevoButton;
			crearClienteNuevoButton = new JButton();
			crearClienteNuevoButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent arg0) {
					CrearClienteDialog ccd = new CrearClienteDialog();
					ccd.setResultField(dniTextField);
					ccd.pack();
					ccd.setLocationRelativeTo(null);
					ccd.setVisible(true);
				}
			});
			crearClienteNuevoButton.setText("Crear cliente nuevo");
			final GroupLayout groupLayout = new GroupLayout(panel);
			groupLayout
					.setHorizontalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addGroup(
									groupLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addComponent(
																	precioDeVentaLabel,
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	precioDelPropietarioLabel,
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	honorariosLabel,
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	ivaLabel,
																	GroupLayout.Alignment.TRAILING))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.TRAILING)
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addComponent(
																					textField,
																					GroupLayout.DEFAULT_SIZE,
																					118,
																					Short.MAX_VALUE)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					label_4))
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.TRAILING)
																							.addComponent(
																									textField_3,
																									GroupLayout.Alignment.LEADING,
																									GroupLayout.DEFAULT_SIZE,
																									118,
																									Short.MAX_VALUE)
																							.addComponent(
																									textField_1,
																									GroupLayout.Alignment.LEADING,
																									GroupLayout.DEFAULT_SIZE,
																									118,
																									Short.MAX_VALUE)
																							.addComponent(
																									textField_2,
																									GroupLayout.DEFAULT_SIZE,
																									118,
																									Short.MAX_VALUE))
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					label_5)))
											.addGap(171, 171, 171)));
			groupLayout
					.setVerticalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout
											.createSequentialGroup()
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	precioDeVentaLabel)
															.addComponent(
																	textField,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	label_4))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	precioDelPropietarioLabel)
															.addComponent(
																	textField_2,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	label_5))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	honorariosLabel)
															.addComponent(
																	textField_1,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(6, 6, 6)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	ivaLabel)
															.addComponent(
																	textField_3,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(87, 87, 87)));
			groupLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
					new java.awt.Component[] { textField, textField_2 });
			panel.setLayout(groupLayout);
			final GroupLayout groupLayout_2 = new GroupLayout(panel_1);
			groupLayout_2
					.setHorizontalGroup(groupLayout_2
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout_2
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													groupLayout_2
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addComponent(
																	label,
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	zonaLabel,
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	referenciaLabel,
																	GroupLayout.Alignment.TRAILING))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout_2
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addComponent(
																	label_1)
															.addComponent(
																	label_2)
															.addComponent(
																	label_3))
											.addContainerGap(292,
													Short.MAX_VALUE)));
			groupLayout_2
					.setVerticalGroup(groupLayout_2
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout_2
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													groupLayout_2
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	referenciaLabel)
															.addComponent(
																	label_1))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout_2
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	zonaLabel)
															.addComponent(
																	label_2))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout_2
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(label)
															.addComponent(
																	label_3))
											.addContainerGap(
													GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)));
			panel_1.setLayout(groupLayout_2);
			final GroupLayout groupLayout_3 = new GroupLayout(panel_2);
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
																					dniLabel)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					dniTextField,
																					GroupLayout.PREFERRED_SIZE,
																					68,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					buscarClientesButton)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					crearClienteNuevoButton))
															.addComponent(
																	errorLabel))
											.addContainerGap(74,
													Short.MAX_VALUE)));
			groupLayout_3
					.setVerticalGroup(groupLayout_3
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout_3
											.createSequentialGroup()
											.addGroup(
													groupLayout_3
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	dniLabel)
															.addComponent(
																	dniTextField,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	buscarClientesButton)
															.addComponent(
																	crearClienteNuevoButton))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(errorLabel)
											.addContainerGap(
													GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)));
			panel_2.setLayout(groupLayout_3);
			final GroupLayout groupLayout_1 = new GroupLayout(this);
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
																	panel_2,
																	GroupLayout.Alignment.TRAILING,
																	0,
																	0,
																	Short.MAX_VALUE)
															.addComponent(
																	panel_1,
																	0,
																	0,
																	Short.MAX_VALUE)
															.addComponent(
																	panel,
																	GroupLayout.DEFAULT_SIZE,
																	434,
																	Short.MAX_VALUE)
															.addComponent(
																	venderInmuebleButton,
																	GroupLayout.Alignment.TRAILING))
											.addContainerGap()));
			groupLayout_1.setVerticalGroup(groupLayout_1.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_1.createSequentialGroup().addComponent(panel_1,
							GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
							Short.MAX_VALUE).addGap(3, 3, 3).addComponent(
							panel_2, GroupLayout.PREFERRED_SIZE, 84,
							GroupLayout.PREFERRED_SIZE).addPreferredGap(
							LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE,
									145, Short.MAX_VALUE).addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(venderInmuebleButton)
							.addContainerGap()));
			setLayout(groupLayout_1);
			//
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
		this.label_1.setText(Integer.toString(inmueble.getReferencia()));
		this.label_2.setText(inmueble.getZona());
		this.label_3.setText(inmueble.getDireccion());
	}

	// private String getBuscarClientesQuery() {
	// String dni = dniTextField.getText().trim();
	//
	// String query = "SELECT * FROM cliente WHERE";
	// if (dni != "")
	// query += " dni LIKE '" + dni + "%' AND";
	// query += " nombre LIKE '" + nombre + "%' AND apellido1 LIKE '"
	// + apellido1 + "%' AND apellido2 LIKE '" + apellido2 + "%'";
	// return query;
	// }

	// private final class BuscarClientes implements ActionListener {
	// public void actionPerformed(final ActionEvent arg0) {
	// try {
	// tableModel.setQuery(getBuscarClientesQuery());
	// } catch (IllegalStateException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
}
