package buenetxea.gui;

import java.awt.Frame;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

public class VenderInmuebleDialog extends JDialog {

	private final JFormattedTextField formattedTextField;
	private final JTable table;
	private final JTextField textField_2;
	private final JTextField textField_1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 648927771057505907L;

	/**
	 * Create the dialog
	 * 
	 * @throws ParseException
	 */
	public VenderInmuebleDialog(Frame jabea) {
		super(jabea, true);
		setTitle("Vender Inmueble");

		JPanel panel;
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Vender Inmueble",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JPanel panel_1;
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Datos del Inmueble",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JPanel panel_2;
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Buscar cliente comprador",
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

		JLabel referenciaLabel;
		referenciaLabel = new JLabel();
		referenciaLabel.setText("Referencia:");

		JLabel label;
		label = new JLabel();
		label.setText("New JLabel");

		textField_2 = new JTextField();

		JButton buscarClientesButton;
		buscarClientesButton = new JButton();
		buscarClientesButton.setText("Buscar clientes");

		formattedTextField = new JFormattedTextField();
		formattedTextField.setColumns(9);

		JScrollPane scrollPane;
		scrollPane = new JScrollPane();

		table = new JTable();
		scrollPane.setViewportView(table);

		JButton venderInmuebleAlButton;
		venderInmuebleAlButton = new JButton();
		venderInmuebleAlButton
				.setText("Vender inmueble al cliente seleccionado");
		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 511,
								Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 380,
								Short.MAX_VALUE).addContainerGap()));
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
																				formattedTextField,
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
																				textField_1,
																				GroupLayout.DEFAULT_SIZE,
																				193,
																				Short.MAX_VALUE))
														.addComponent(
																textField_2,
																GroupLayout.Alignment.TRAILING,
																GroupLayout.DEFAULT_SIZE,
																310,
																Short.MAX_VALUE))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(buscarClientesButton)));
		groupLayout_3.setVerticalGroup(groupLayout_3.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout_3.createSequentialGroup().addGroup(
						groupLayout_3.createParallelGroup(
								GroupLayout.Alignment.BASELINE).addComponent(
								dniLabel).addComponent(formattedTextField,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addComponent(
								nombreLabel).addComponent(textField_1,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addGroup(
						groupLayout_3.createParallelGroup(
								GroupLayout.Alignment.BASELINE).addComponent(
								apellidosLabel).addComponent(
								buscarClientesButton).addComponent(textField_2,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)).addContainerGap(
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panel_2.setLayout(groupLayout_3);
		final GroupLayout groupLayout_2 = new GroupLayout(panel_1);
		groupLayout_2.setHorizontalGroup(groupLayout_2.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout_2.createSequentialGroup().addContainerGap()
						.addComponent(referenciaLabel).addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(label).addContainerGap(353,
								Short.MAX_VALUE)));
		groupLayout_2.setVerticalGroup(groupLayout_2.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout_2.createSequentialGroup().addGroup(
						groupLayout_2.createParallelGroup(
								GroupLayout.Alignment.BASELINE).addComponent(
								referenciaLabel).addComponent(label))
						.addContainerGap(22, Short.MAX_VALUE)));
		panel_1.setLayout(groupLayout_2);

		JButton crearUnClienteButton;
		crearUnClienteButton = new JButton();
		crearUnClienteButton.setText("Crear un cliente nuevo");
		final GroupLayout groupLayout_1 = new GroupLayout(panel);
		groupLayout_1.setHorizontalGroup(groupLayout_1.createParallelGroup(
				GroupLayout.Alignment.TRAILING).addComponent(panel_1,
				GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
				.addGroup(
						groupLayout_1.createSequentialGroup().addContainerGap(
								127, Short.MAX_VALUE).addComponent(
								crearUnClienteButton).addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(venderInmuebleAlButton))
				.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 495,
						Short.MAX_VALUE).addComponent(scrollPane,
						GroupLayout.Alignment.LEADING,
						GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE));
		groupLayout_1
				.setVerticalGroup(groupLayout_1.createParallelGroup(
						GroupLayout.Alignment.LEADING).addGroup(
						groupLayout_1.createSequentialGroup().addComponent(
								panel_1, GroupLayout.PREFERRED_SIZE, 66,
								GroupLayout.PREFERRED_SIZE).addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel_2,
										GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(scrollPane,
										GroupLayout.DEFAULT_SIZE, 153,
										Short.MAX_VALUE).addPreferredGap(
										LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										groupLayout_1.createParallelGroup(
												GroupLayout.Alignment.BASELINE)
												.addComponent(
														venderInmuebleAlButton)
												.addComponent(
														crearUnClienteButton))));
		panel.setLayout(groupLayout_1);
		getContentPane().setLayout(groupLayout);
		pack();
		//
	}

}
