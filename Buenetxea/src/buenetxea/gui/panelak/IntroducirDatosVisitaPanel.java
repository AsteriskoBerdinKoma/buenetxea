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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class IntroducirDatosVisitaPanel extends JPanel {

	private JTextField textField_4;
	private JComboBox comboBox_8;
	private JComboBox comboBox_7;
	private JComboBox comboBox_6;
	private JComboBox comboBox_5;
	private JTextField textField_3;
	private JTextField textField_2;
	private JComboBox comboBox_4;
	private JComboBox comboBox_3;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1;
	private JTextField textField_1;
	/**
	 * Create the panel
	 */
	public IntroducirDatosVisitaPanel() {
		super();

		JTabbedPane tabbedPane;
		tabbedPane = new JTabbedPane();











		final JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null), "Introducir datos", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
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
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(GroupLayout.Alignment.TRAILING, groupLayout_1.createSequentialGroup()
					.addContainerGap(114, Short.MAX_VALUE)
					.addComponent(crearimprimirButton)
					.addContainerGap())
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(referenciaInmuebleLabel_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(fechaLabel_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6, 6, 6)
							.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6, 6, 6)
							.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(horaLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(dniClienteLabel_1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(2, 2, 2)
							.addComponent(referenciaInmuebleLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(6, 6, 6)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(4, 4, 4)
							.addComponent(fechaLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(6, 6, 6)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(4, 4, 4)
							.addComponent(horaLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(6, 6, 6)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGap(2, 2, 2)
							.addComponent(dniClienteLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(17, 17, 17)
					.addComponent(crearimprimirButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout_1);

		final JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Introducir datos", null, panel_1, null);

		JPanel panel_2;
		panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null), "Datos", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

		JLabel referenciaInmuebleLabel;
		referenciaInmuebleLabel = new JLabel();
		referenciaInmuebleLabel.setText("Referencia Inmueble:");

		textField_1 = new JTextField();

		JLabel fechaLabel;
		fechaLabel = new JLabel();
		fechaLabel.setText("Fecha:");

		comboBox_1 = new JComboBox();

		comboBox_2 = new JComboBox();

		comboBox_3 = new JComboBox();

		JLabel horaLabel;
		horaLabel = new JLabel();
		horaLabel.setText("Hora:");

		comboBox_4 = new JComboBox();

		JLabel dniClienteLabel;
		dniClienteLabel = new JLabel();
		dniClienteLabel.setText("DNI Cliente:");

		textField_2 = new JTextField();
		final GroupLayout groupLayout_3 = new GroupLayout((JComponent) panel_2);
		groupLayout_3.setHorizontalGroup(
			groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_3.createSequentialGroup()
							.addComponent(referenciaInmuebleLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_3.createSequentialGroup()
							.addComponent(fechaLabel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6, 6, 6)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
							.addGap(6, 6, 6)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_3.createSequentialGroup()
							.addComponent(horaLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_3.createSequentialGroup()
							.addComponent(dniClienteLabel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout_3.setVerticalGroup(
			groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_3.createSequentialGroup()
					.addGroup(groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_3.createSequentialGroup()
							.addGap(2, 2, 2)
							.addComponent(referenciaInmuebleLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(6, 6, 6)
					.addGroup(groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_3.createSequentialGroup()
							.addGap(4, 4, 4)
							.addComponent(fechaLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(6, 6, 6)
					.addGroup(groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_3.createSequentialGroup()
							.addGap(4, 4, 4)
							.addComponent(horaLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(6, 6, 6)
					.addGroup(groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_3.createSequentialGroup()
							.addGap(2, 2, 2)
							.addComponent(dniClienteLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		panel_2.setLayout(groupLayout_3);

		JPanel panel_3;
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null), "Datos Visita", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

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
		final GroupLayout groupLayout_4 = new GroupLayout((JComponent) panel_3);
		groupLayout_4.setHorizontalGroup(
			groupLayout_4.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_4.createSequentialGroup()
							.addComponent(precioCheckBox_1_18, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(groupLayout_4.createSequentialGroup()
							.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addComponent(precioCheckBox_1_17, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(precioCheckBox_1_5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(precioCheckBox_1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox, GroupLayout.Alignment.LEADING)
								.addComponent(precioCheckBox_1_1, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_2, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_4, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(precioCheckBox_1_6, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_7, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(precioCheckBox_1_3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(precioCheckBox_1_8, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_9, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_10, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_11, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_12, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_13, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_14, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_15, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addComponent(precioCheckBox_1_16, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
							.addGap(64, 64, 64))
						.addGroup(groupLayout_4.createSequentialGroup()
							.addComponent(precioCheckBox_1_19, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		groupLayout_4.setVerticalGroup(
			groupLayout_4.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioCheckBox)
						.addComponent(precioCheckBox_1_8))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioCheckBox_1)
						.addComponent(precioCheckBox_1_9))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioCheckBox_1_1)
						.addComponent(precioCheckBox_1_10))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioCheckBox_1_2)
						.addComponent(precioCheckBox_1_11))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioCheckBox_1_3)
						.addComponent(precioCheckBox_1_12))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioCheckBox_1_4)
						.addComponent(precioCheckBox_1_13))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioCheckBox_1_5)
						.addComponent(precioCheckBox_1_14))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioCheckBox_1_6)
						.addComponent(precioCheckBox_1_15))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioCheckBox_1_7)
						.addComponent(precioCheckBox_1_16))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(precioCheckBox_1_17)
					.addGap(47, 47, 47)
					.addComponent(precioCheckBox_1_18)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 2, Short.MAX_VALUE)
					.addComponent(precioCheckBox_1_19)
					.addContainerGap())
		);
		panel_3.setLayout(groupLayout_4);

		JButton introducirDatosButton;
		introducirDatosButton = new JButton();
		introducirDatosButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
			}
		});
		introducirDatosButton.setText("Introducir Datos");
		final GroupLayout groupLayout_2 = new GroupLayout((JComponent) panel_1);
		groupLayout_2.setHorizontalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_2.createSequentialGroup()
							.addGap(12, 12, 12)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 459, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 459, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(GroupLayout.Alignment.TRAILING, groupLayout_2.createSequentialGroup()
					.addContainerGap(331, Short.MAX_VALUE)
					.addComponent(introducirDatosButton)
					.addGap(27, 27, 27))
		);
		groupLayout_2.setVerticalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addGap(12, 12, 12)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 387, GroupLayout.PREFERRED_SIZE)
					.addGap(26, 26, 26)
					.addComponent(introducirDatosButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(groupLayout_2);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 698, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		//
	}

}
