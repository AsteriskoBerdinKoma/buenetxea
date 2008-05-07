package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class LocalizarClientePanel extends JPanel {

	private JTable table;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField textField_1;
	private JComboBox comboBox;
	private JTextField textField;
	/**
	 * Create the panel
	 */
	public LocalizarClientePanel() {
		super();
		setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null), "Localizar Cliente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

		JPanel panel;
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null), "Búsqueda:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

		JLabel dniLabel;
		dniLabel = new JLabel();
		dniLabel.setText("DNI:");

		JLabel nacionalidadLabel;
		nacionalidadLabel = new JLabel();
		nacionalidadLabel.setText("Nacionalidad:");

		JLabel nombreLabel;
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre:");

		JLabel apellido1Label;
		apellido1Label = new JLabel();
		apellido1Label.setText("Apellido1:");

		JLabel apellido2Label;
		apellido2Label = new JLabel();
		apellido2Label.setText("Apellido2:");

		textField = new JTextField();

		comboBox = new JComboBox();

		textField_1 = new JTextField();

		textField_2 = new JTextField();

		textField_3 = new JTextField();

		JButton buscarButton;
		buscarButton = new JButton();
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				
			}
		});
		buscarButton.setText("Buscar");

		JPanel panel_1;
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new TitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null), "Resultado de la búsqueda:", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

		JScrollPane scrollPane;
		scrollPane = new JScrollPane();

		
		scrollPane.setViewportView(table);
	
		
		JButton imprimirButton;
		imprimirButton = new JButton();
		imprimirButton.setText("Imprimir");
		final GroupLayout groupLayout_2 = new GroupLayout((JComponent) panel_1);
		groupLayout_2.setHorizontalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addContainerGap(358, Short.MAX_VALUE)
					.addComponent(imprimirButton)
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
		);
		groupLayout_2.setVerticalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(imprimirButton))
		);
		panel_1.setLayout(groupLayout_2);
		final GroupLayout groupLayout_1 = new GroupLayout((JComponent) panel);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nacionalidadLabel)
								.addComponent(dniLabel))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(comboBox, 0, 145, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
							.addGap(21, 21, 21)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nombreLabel)
								.addComponent(apellido1Label)
								.addComponent(apellido2Label))
							.addGap(5, 5, 5)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
								.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(buscarButton)
							.addGap(12, 12, 12))))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(dniLabel)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(nacionalidadLabel)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(nombreLabel)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(apellido1Label)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(apellido2Label)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(buscarButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout_1);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		//
	}

}
