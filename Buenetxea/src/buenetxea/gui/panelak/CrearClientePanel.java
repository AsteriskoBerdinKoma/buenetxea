package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

public class CrearClientePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JFormattedTextField formattedTextField;
	private JTextField textField_7;
	private JTextField textField_6;
	private JTextField textField_5;
	private JTextField textField_3;
	private JTextField textField_2;
	/**
	 * Create the panel
	 * @throws ParseException 
	 */
	public CrearClientePanel() throws ParseException {
		super();
		setBorder(new TitledBorder(null, "Crear cliente", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
		setBackground(UIManager.getColor("Panel.background"));

		JPanel panel;
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("Panel.background"));

		textField_2 = new JTextField();

		textField_3 = new JTextField();

		textField_5 = new JTextField();

		textField_6 = new JTextField();

		textField_7 = new JTextField();

		JLabel dniLabel;
		dniLabel = new JLabel();
		dniLabel.setText("DNI:");

		JLabel nombreLabel;
		nombreLabel = new JLabel();
		nombreLabel.setText("Nombre:");

		JLabel apellido1Label;
		apellido1Label = new JLabel();
		apellido1Label.setText("Apellidos:");

		JLabel telefonoLabel;
		telefonoLabel = new JLabel();
		telefonoLabel.setText("Telefono:");

		JLabel medioLabel;
		medioLabel = new JLabel();
		medioLabel.setText("Medio:");

		JLabel asesorLabel;
		asesorLabel = new JLabel();
		asesorLabel.setText("Asesor:");

		JButton crearPrefereciasDelButton;
		crearPrefereciasDelButton = new JButton();
		crearPrefereciasDelButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		crearPrefereciasDelButton.setText("Crear preferecias del cliente");

		formattedTextField = new JFormattedTextField(new MaskFormatter("########U"));
		formattedTextField.setColumns(9);

		textField = new JTextField();
		final GroupLayout groupLayout_1 = new GroupLayout((JComponent) panel);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(asesorLabel)
								.addComponent(medioLabel)
								.addComponent(apellido1Label)
								.addComponent(dniLabel))
							.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(groupLayout_1.createSequentialGroup()
									.addGap(4, 4, 4)
									.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)))
								.addGroup(groupLayout_1.createSequentialGroup()
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(groupLayout_1.createSequentialGroup()
											.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(nombreLabel)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(textField, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
										.addGroup(groupLayout_1.createSequentialGroup()
											.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE))))))
						.addComponent(crearPrefereciasDelButton)
						.addGroup(groupLayout_1.createSequentialGroup()
							.addComponent(telefonoLabel)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 143, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(dniLabel)
						.addComponent(formattedTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(nombreLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(apellido1Label)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(telefonoLabel)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41, 41, 41)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(medioLabel)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(asesorLabel)
						.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addComponent(crearPrefereciasDelButton)
					.addContainerGap())
		);
		groupLayout_1.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {nombreLabel, telefonoLabel});
		panel.setLayout(groupLayout_1);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 513, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);

		
		//
	}

}
