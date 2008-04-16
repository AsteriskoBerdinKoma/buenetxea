package buenetxea.gui.panelak;

import javax.swing.GroupLayout;
import javax.swing.JButton;
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

	private JTextField textField;
	private JComboBox comboBox_4;
	private JComboBox comboBox_3;
	private JComboBox comboBox_2;
	private JComboBox comboBox;
	private JTextField textField_1;
	/**
	 * Create the panel
	 */
	public IntroducirDatosVisitaPanel() {
		super();

		JTabbedPane tabbedPane;
		tabbedPane = new JTabbedPane();

		JPanel panel_2;

		JLabel datosDelInmuebleLabel;

		JButton buscarButton;

		JPanel panel_3;

		JPanel panel_4;

		JPanel panel_5;

		JLabel introducirFechaLabel;

		JLabel introducirHoraLabel;

		JLabel introducirClienteLabel;

		JButton crearimprimirButton;

		final JPanel panel = new JPanel();
		tabbedPane.addTab("crear visita", null, panel, null);
		panel_2 = new JPanel();
		panel_2.setName("Ref.Inmueble");
		panel_2.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null), "Ref.Inmueble", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		datosDelInmuebleLabel = new JLabel();
		datosDelInmuebleLabel.setText("Referencia Inmueble:");

		textField_1 = new JTextField();
		buscarButton = new JButton();
		buscarButton.setText("Buscar");
		panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null), "Datos", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Datos del Inmueble", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null), "Introducir Datos", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		introducirFechaLabel = new JLabel();
		introducirFechaLabel.setText("Introducir fecha:");
		introducirHoraLabel = new JLabel();
		introducirHoraLabel.setText("introducir hora:");
		introducirClienteLabel = new JLabel();
		introducirClienteLabel.setText("Introducir cliente:");

		comboBox = new JComboBox();

		comboBox_2 = new JComboBox();

		comboBox_3 = new JComboBox();

		comboBox_4 = new JComboBox();

		textField = new JTextField();
		crearimprimirButton = new JButton();
		crearimprimirButton.setText("Crear/Imprimir");
		final GroupLayout groupLayout_4 = new GroupLayout((JComponent) panel_5);
		groupLayout_4.setHorizontalGroup(
			groupLayout_4.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(introducirFechaLabel)
						.addComponent(introducirHoraLabel)
						.addComponent(introducirClienteLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout_4.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout_4.setVerticalGroup(
			groupLayout_4.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(introducirFechaLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(introducirHoraLabel)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_4.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(introducirClienteLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel_5.setLayout(groupLayout_4);
		final GroupLayout groupLayout_2 = new GroupLayout((JComponent) panel_2);
		groupLayout_2.setHorizontalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addGap(24, 24, 24)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(GroupLayout.Alignment.TRAILING, groupLayout_2.createSequentialGroup()
							.addComponent(datosDelInmuebleLabel)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addGap(136, 136, 136))
						.addGroup(GroupLayout.Alignment.TRAILING, groupLayout_2.createSequentialGroup()
							.addComponent(buscarButton)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
					.addGap(0, 0, Short.MAX_VALUE))
		);
		groupLayout_2.setVerticalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addGap(5, 5, 5)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(datosDelInmuebleLabel)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
					.addComponent(buscarButton))
		);
		panel_2.setLayout(groupLayout_2);
		final GroupLayout groupLayout_3 = new GroupLayout((JComponent) panel_3);
		groupLayout_3.setHorizontalGroup(
			groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(crearimprimirButton, GroupLayout.Alignment.TRAILING)
						.addGroup(GroupLayout.Alignment.TRAILING, groupLayout_3.createSequentialGroup()
							.addGroup(groupLayout_3.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(panel_5, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
								.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE))
							.addContainerGap())))
		);
		groupLayout_3.setVerticalGroup(
			groupLayout_3.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(crearimprimirButton)
					.addContainerGap())
		);
		panel_3.setLayout(groupLayout_3);
		final GroupLayout groupLayout_1 = new GroupLayout((JComponent) panel);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(panel_3, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 460, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout_1);

		final JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Introducir datos", null, panel_1, null);
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
