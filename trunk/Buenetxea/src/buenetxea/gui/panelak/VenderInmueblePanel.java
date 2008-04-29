package buenetxea.gui.panelak;

import java.sql.SQLException;

import javax.swing.ActionMap;
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

import org.jdesktop.application.Action;
import org.jdesktop.application.Application;
import org.jdesktop.application.Task;

import buenetxea.BuenetxeaApp;
import buenetxea.actions.BuscarClienteAction;
import buenetxea.db.ResultSetTableModel;
import buenetxea.kudeatzaileak.Kudeatzailea;

public class VenderInmueblePanel extends JPanel {

	private JTextField textField_3;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFormattedTextField formattedTextField;
	private JTable table;
	private JTextField textField_2;
	private JTextField textField_1;

	/**
	 * Create the panel
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public VenderInmueblePanel() {
		super();

		try {
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

			textField_1 = new JTextField();

			textField_2 = new JTextField();

			ActionMap actionMap = Application.getInstance(BuenetxeaApp.class)
					.getContext().getActionMap(this);

			JButton buscarClientesButton;
			buscarClientesButton = new JButton();
			buscarClientesButton.setAction(actionMap.get("buscarCliente"));
			buscarClientesButton.setText("Buscar clientes");

			formattedTextField = new JFormattedTextField();
			formattedTextField.setColumns(9);

			JScrollPane scrollPane;
			scrollPane = new JScrollPane();

			table = new JTable();
			table.setModel(new ResultSetTableModel(Kudeatzailea.getInstance()
					.getBuscarClientesQuery(formattedTextField.getText(),
							textField_1.getText(), textField_2.getText(),
							textField_3.getText())));
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);

			JButton venderInmuebleAlButton;
			venderInmuebleAlButton = new JButton();
			venderInmuebleAlButton
					.setText("Vender inmueble al cliente seleccionado");

			JButton crearUnClienteButton;
			crearUnClienteButton = new JButton();
			crearUnClienteButton.setText("Crear un cliente nuevo");

			textField_3 = new JTextField();

			JLabel referenciaLabel;
			referenciaLabel = new JLabel();
			referenciaLabel.setText("Referencia:");

			JLabel label;
			label = new JLabel();
			label.setText("Dirección:");

			JLabel label_1;
			label_1 = new JLabel();
			label_1.setText("New JLabel");

			JLabel zonaLabel;
			zonaLabel = new JLabel();
			zonaLabel.setText("Zona:");

			JLabel label_2;
			label_2 = new JLabel();
			label_2.setText("New JLabel");

			JLabel label_3;
			label_3 = new JLabel();
			label_3.setText("New JLabel");
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
											.addContainerGap(340,
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
																									textField_1,
																									GroupLayout.Alignment.LEADING,
																									GroupLayout.DEFAULT_SIZE,
																									292,
																									Short.MAX_VALUE)
																							.addGroup(
																									groupLayout_3
																											.createSequentialGroup()
																											.addComponent(
																													textField_2,
																													GroupLayout.DEFAULT_SIZE,
																													144,
																													Short.MAX_VALUE)
																											.addGap(
																													4,
																													4,
																													4)
																											.addComponent(
																													textField_3,
																													GroupLayout.DEFAULT_SIZE,
																													144,
																													Short.MAX_VALUE)))
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					buscarClientesButton))
															.addComponent(
																	formattedTextField,
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
																	formattedTextField,
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
																	textField_1,
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
																	textField_2,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	textField_3,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	buscarClientesButton))
											.addContainerGap(
													GroupLayout.DEFAULT_SIZE,
													Short.MAX_VALUE)));
			groupLayout_3.linkSize(javax.swing.SwingConstants.HORIZONTAL,
					new java.awt.Component[] { textField_2, textField_3 });
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
																	482,
																	Short.MAX_VALUE)
															.addComponent(
																	panel_2,
																	GroupLayout.PREFERRED_SIZE,
																	482,
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
																	panel_1,
																	GroupLayout.DEFAULT_SIZE,
																	482,
																	Short.MAX_VALUE))
											.addContainerGap()));
			groupLayout_1
					.setVerticalGroup(groupLayout_1
							.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addGroup(
									groupLayout_1
											.createSequentialGroup()
											.addComponent(panel_1,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(panel_2,
													GroupLayout.PREFERRED_SIZE,
													GroupLayout.DEFAULT_SIZE,
													GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(scrollPane,
													GroupLayout.DEFAULT_SIZE,
													142, Short.MAX_VALUE)
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Action
	public Task<?, ?> buscarCliente() {
		return new BuscarClienteAction(BuenetxeaApp.getApplication());
	}

}
