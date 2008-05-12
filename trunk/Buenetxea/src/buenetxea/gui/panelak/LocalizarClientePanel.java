package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import buenetxea.kudeatzaileak.Kudeatzailea;

public class LocalizarClientePanel extends JPanel {

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
	private JComboBox comboBox;

	private Kudeatzailea kud;

	/**
	 * Create the panel
	 */
	public LocalizarClientePanel() {
		super();

		try {
			kud = Kudeatzailea.getInstance();

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
			apellidosLabel.setText("Primer apellido:");

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

			JButton verClienteButton;
			verClienteButton = new JButton();
			verClienteButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent arg0) {
					String dni = (String) table.getValueAt(table
							.getSelectedRow(), 0);
					Nagusia.getInstance().showVerCliente(dni);
				}
			});
			verClienteButton.setText("Ver Cliente");

			apellido2TextField = new JTextField();

			JLabel segundoApellidoLabel;
			segundoApellidoLabel = new JLabel();
			segundoApellidoLabel.setText("Segundo Apellido:");

			JLabel nacionalidadLabel;
			nacionalidadLabel = new JLabel();
			nacionalidadLabel.setText("Nacionalidad:");

			Vector<String> v = new Vector<String>(Arrays.asList(kud
					.getNacionalidades()));
			v.insertElementAt("Todas", 0);
			comboBox = new JComboBox(v.toArray());
			comboBox.setSelectedIndex(0);

			tableModel = new ResultSetTableModel(getBuscarClientesQuery());

			JScrollPane scrollPane;
			scrollPane = new JScrollPane();

			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				public void mouseClicked(final MouseEvent e) {
					if (e.getClickCount() == 2) {
						String dni = (String) table.getValueAt(table
								.getSelectedRow(), 0);
						Nagusia.getInstance().showVerCliente(dni);
					}
				}
			});
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
																	nacionalidadLabel,
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	segundoApellidoLabel,
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
													groupLayout_3
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addGroup(
																	groupLayout_3
																			.createSequentialGroup()
																			.addComponent(
																					comboBox,
																					GroupLayout.PREFERRED_SIZE,
																					119,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED,
																					142,
																					Short.MAX_VALUE)
																			.addComponent(
																					buscarClientesButton))
															.addGroup(
																	groupLayout_3
																			.createSequentialGroup()
																			.addGroup(
																					groupLayout_3
																							.createParallelGroup(
																									GroupLayout.Alignment.LEADING)
																							.addComponent(
																									apellido2TextField,
																									GroupLayout.DEFAULT_SIZE,
																									247,
																									Short.MAX_VALUE)
																							.addGroup(
																									groupLayout_3
																											.createSequentialGroup()
																											.addComponent(
																													dniTextField,
																													GroupLayout.PREFERRED_SIZE,
																													68,
																													GroupLayout.PREFERRED_SIZE)
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													nombreLabel)
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													nombreTextField,
																													GroupLayout.DEFAULT_SIZE,
																													130,
																													Short.MAX_VALUE))
																							.addComponent(
																									apellido1TextField,
																									GroupLayout.DEFAULT_SIZE,
																									247,
																									Short.MAX_VALUE))
																			.addGap(
																					117,
																					117,
																					117)))
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
																	GroupLayout.PREFERRED_SIZE)
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
																	apellido1TextField,
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
																	segundoApellidoLabel)
															.addComponent(
																	apellido2TextField,
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
																	nacionalidadLabel)
															.addComponent(
																	comboBox,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	buscarClientesButton))
											.addContainerGap()));
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
															.addComponent(
																	panel_2,
																	GroupLayout.Alignment.LEADING,
																	GroupLayout.PREFERRED_SIZE,
																	495,
																	Short.MAX_VALUE)
															.addComponent(
																	verClienteButton))
											.addContainerGap()));
			groupLayout_1.setVerticalGroup(groupLayout_1.createParallelGroup(
					GroupLayout.Alignment.TRAILING).addGroup(
					groupLayout_1.createSequentialGroup().addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE,
									GroupLayout.DEFAULT_SIZE,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
									146, Short.MAX_VALUE).addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(verClienteButton).addContainerGap()));
			setLayout(groupLayout_1);
			//
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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

	private String getBuscarClientesQuery() {
		String dni = dniTextField.getText().trim();
		String nombre = nombreTextField.getText().trim();
		String apellido1 = apellido1TextField.getText().trim();
		String apellido2 = apellido2TextField.getText().trim();
		int nacIndex = comboBox.getSelectedIndex();
		String nacionalidad = (String) comboBox.getSelectedItem();

		String query = "SELECT dni AS 'DNI', nombre AS 'Nombre', apellido1 AS 'Primer apellido', apellido2 AS 'Segundo apellido', nacionalidad AS 'Nacionalidad', telefono AS 'Teléfono', direccion AS 'Dirección', medio AS 'Medio', asesor AS 'Asesor', fecha AS 'Fecha' FROM cliente WHERE";
		if (dni != "")
			query += " dni LIKE '" + dni + "%' AND";
		query += " nombre LIKE '" + nombre + "%' AND apellido1 LIKE '"
				+ apellido1 + "%' AND apellido2 LIKE '" + apellido2 + "%'";
		if (nacIndex > 0)
			query += " AND nacionalidad = '" + nacionalidad + "'";
		return query;
	}

	public void refresh() {
		try {
			tableModel.refresh();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
