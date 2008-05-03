package buenetxea.gui.panelak;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import buenetxea.db.ResultSetTableModel;
import buenetxea.gui.Nagusia;

public class BucarClientePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFormattedTextField dniTextField;
	private JTable table;
	private JTextField apellido1TextField;
	private JTextField apellido2TextField;
	private JTextField nombreTextField;
	private ResultSetTableModel tableModel;

	/**
	 * Create the panel
	 */
	public BucarClientePanel() {
		super();

		try {
			setBorder(new TitledBorder(null, "Buscar Cliente",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JPanel panel_2;
			panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null,
					"Buscar cliente comprador",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JLabel nombreLabel;
			nombreLabel = new JLabel();
			nombreLabel.setText("Nombre:");

			JLabel apellidosLabel;
			apellidosLabel = new JLabel();
			apellidosLabel.setText("Apellidos:");

			JLabel dniLabel;
			dniLabel = new JLabel();
			dniLabel.setText("DNI:");

			nombreTextField = new JTextField();

			apellido1TextField = new JTextField();

			JButton buscarClientesButton;
			buscarClientesButton = new JButton();
			buscarClientesButton.addActionListener(new BuscarClientes());
			buscarClientesButton.setText("Buscar clientes");

			dniTextField = new JFormattedTextField(new MaskFormatter(
					"########*"));

			dniTextField.setColumns(9);

			JButton venderInmuebleAlButton;
			venderInmuebleAlButton = new JButton();
			venderInmuebleAlButton.setText("Seleccionar cliente");

			JButton crearUnClienteButton;
			crearUnClienteButton = new JButton();
			crearUnClienteButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent arg0) {
					Dialog d = new Dialog(Nagusia.getInstance(),
							"Crear cliente nuevo", true);
					d.addWindowListener(new WindowListener() {

						@Override
						public void windowActivated(WindowEvent e) {
							System.out.println("activated");
						}

						@Override
						public void windowClosed(WindowEvent e) {
							System.out.println("closed");
						}

						@Override
						public void windowClosing(WindowEvent e) {
							System.out.println("closing");
							e.getWindow().dispose();
						}

						@Override
						public void windowDeactivated(WindowEvent e) {
							System.out.println("deactivated");
						}

						@Override
						public void windowDeiconified(WindowEvent e) {
							System.out.println("deiconified");
						}

						@Override
						public void windowIconified(WindowEvent e) {
							System.out.println("iconified");
						}

						@Override
						public void windowOpened(WindowEvent e) {
							System.out.println("opened");
						}
					});
					d.add(new CrearClientePanel());
					d.pack();
					d.setLocationRelativeTo(null);
					d.setVisible(true);
				}
			});
			crearUnClienteButton.setText("Crear un cliente nuevo");

			apellido2TextField = new JTextField();

			tableModel = new ResultSetTableModel(getBuscarClientesQuery());

			JScrollPane scrollPane;
			scrollPane = new JScrollPane();

			table = new JTable();
			table.setModel(tableModel);
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			final GroupLayout groupLayout_3 = new GroupLayout(panel_2);
			groupLayout_3
					.setHorizontalGroup(groupLayout_3
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout_3
											.createSequentialGroup()
											.addGap(15, 15, 15)
											.addGroup(
													groupLayout_3
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addComponent(
																	apellidosLabel,
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	nombreLabel,
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	dniLabel,
																	GroupLayout.Alignment.TRAILING))
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
																									GroupLayout.Alignment.TRAILING)
																							.addComponent(
																									nombreTextField,
																									GroupLayout.Alignment.LEADING,
																									GroupLayout.DEFAULT_SIZE,
																									295,
																									Short.MAX_VALUE)
																							.addGroup(
																									groupLayout_3
																											.createSequentialGroup()
																											.addComponent(
																													apellido1TextField,
																													GroupLayout.DEFAULT_SIZE,
																													146,
																													Short.MAX_VALUE)
																											.addGap(
																													4,
																													4,
																													4)
																											.addComponent(
																													apellido2TextField,
																													GroupLayout.DEFAULT_SIZE,
																													145,
																													Short.MAX_VALUE)))
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					buscarClientesButton))
															.addComponent(
																	dniTextField,
																	GroupLayout.PREFERRED_SIZE,
																	68,
																	GroupLayout.PREFERRED_SIZE))
											.addContainerGap()));
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
																	GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout_3
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	nombreLabel)
															.addComponent(
																	nombreTextField,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout_3
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	apellidosLabel)
															.addComponent(
																	apellido2TextField,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	buscarClientesButton)
															.addComponent(
																	apellido1TextField,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addContainerGap(
													GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)));
			panel_2.setLayout(groupLayout_3);
			final GroupLayout groupLayout_1 = new GroupLayout(this);
			groupLayout_1
					.setHorizontalGroup(groupLayout_1
							.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addGroup(
									groupLayout_1
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													groupLayout_1
															.createParallelGroup(
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	scrollPane,
																	GroupLayout.Alignment.LEADING,
																	GroupLayout.DEFAULT_SIZE,
																	495,
																	Short.MAX_VALUE)
															.addGroup(
																	groupLayout_1
																			.createSequentialGroup()
																			.addComponent(
																					crearUnClienteButton)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					venderInmuebleAlButton))
															.addComponent(
																	panel_2,
																	GroupLayout.Alignment.LEADING,
																	GroupLayout.PREFERRED_SIZE,
																	495,
																	Short.MAX_VALUE))
											.addContainerGap()));
			groupLayout_1
					.setVerticalGroup(groupLayout_1
							.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addGroup(
									groupLayout_1
											.createSequentialGroup()
											.addContainerGap()
											.addComponent(panel_2,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(scrollPane,
													GroupLayout.DEFAULT_SIZE,
													116, Short.MAX_VALUE)
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout_1
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	venderInmuebleAlButton)
															.addComponent(
																	crearUnClienteButton))
											.addContainerGap()));
			setLayout(groupLayout_1);
			//
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private String getBuscarClientesQuery() {
		String dni = dniTextField.getText().trim();
		String nombre = nombreTextField.getText().trim();
		String apellido1 = apellido1TextField.getText().trim();
		String apellido2 = apellido2TextField.getText().trim();

		String query = "SELECT * FROM cliente WHERE";
		if (dni != "")
			query += " dni LIKE '" + dni + "%' AND";
		query += " nombre LIKE '" + nombre + "%' AND apellido1 LIKE '"
				+ apellido1 + "%' AND apellido2 LIKE '" + apellido2 + "%'";
		return query;
	}

	private final class BuscarClientes implements ActionListener {
		public void actionPerformed(final ActionEvent arg0) {
			try {
				tableModel.setQuery(getBuscarClientesQuery());
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
