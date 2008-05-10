package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Inmueble;

public class LocalizarInmueblePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JTable table;
	private final JComboBox comboBox_4;
	private final JComboBox comboBox_5;
	private final JComboBox comboBox_3;
	private final JTextField textField_4;
	private final JSpinner spinner_1;
	private final JSpinner spinner;
	private final JComboBox comboBox_2;
	private final JComboBox comboBox_1;
	private final JTextField textField_3;
	private final JTextField textField_2;
	private final JComboBox comboBox;
	private final JTextField textField_1;
	private final JTextField textField;

	/**
	 * Create the panel
	 */
	public LocalizarInmueblePanel() {
		super();
		setBorder(new TitledBorder(null, "Localizador",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JTabbedPane tabbedPane;
		tabbedPane = new JTabbedPane();

		final JPanel panel = new JPanel();
		tabbedPane.addTab("Referencia", null, panel, null);
		JLabel referenciaLabel;
		referenciaLabel = new JLabel();
		referenciaLabel.setText("Referencia:");

		textField = new JTextField();

		JButton localizarButton;
		localizarButton = new JButton();
		localizarButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				int referencia;
				referencia=Integer.parseInt(textField.getText());
				try {
					Inmueble inmueble= Kudeatzailea.getInstance().getInmueble(referencia);
					//inmueble.get
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane joptionpane = new JOptionPane("La referencia del inmueble introducida no se encuentra en la base de datos.", JOptionPane.ERROR_MESSAGE);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		);
		localizarButton.setText("Localizar");
		final GroupLayout groupLayout_1 = new GroupLayout(panel);
		groupLayout_1.setHorizontalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(referenciaLabel)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(localizarButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout_1.setVerticalGroup(
			groupLayout_1.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_1.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(referenciaLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(localizarButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(groupLayout_1);

		JLabel zonaLabel;

		JButton button;

		JLabel label;

		JLabel provinciaLabel;

		JButton button_1;

		JButton button_2;

		JLabel precioLabel;

		JCheckBox checkBox;

		JLabel deLabel;

		JLabel hastaLabel;

		JLabel hastaLabel_1;

		JLabel exteriorLabel;

		JLabel asceensorLabel;

		JLabel btLabel;

		JCheckBox bajaCheckBox;

		JCheckBox altaCheckBox;

		JCheckBox vendidoCheckBox;

		JLabel estadoLabel;

		JButton localizarButton_1;

		final JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Características", null, panel_1, null);
		zonaLabel = new JLabel();
		zonaLabel.setText("Zona:");

		textField_1 = new JTextField();

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Centro", "Parte vieja",
		"A las afueras"}));
		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		button.setText("Añadir zona");
		label = new JLabel();
		label.setText("Población:");
		provinciaLabel = new JLabel();
		provinciaLabel.setText("Provincia:");

		textField_2 = new JTextField();

		textField_3 = new JTextField();
		button_1 = new JButton();
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		button_1.setText("Añadir población");
		button_2 = new JButton();
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				
			}
		});
		button_2.setText("Añadir provincia");

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Donostia", "Irun",
		"Bilbo", "Barakaldo", "Gasteiz"}));
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Gipuzkoa", "Bizkaia",
		"Araba"}));

		

		spinner = new JSpinner();
		precioLabel = new JLabel();
		precioLabel.setText("Precio:");
		checkBox = new JCheckBox();
		checkBox.setText("Nº Habitaciones:");
		//if checkBox.isSelected(){
			//selekzionau zenbat abitaziokin nahi dan
			deLabel = new JLabel();
			deLabel.setText("De");
			//spinner_1 = new JSpinner();//
			hastaLabel = new JLabel();
			hastaLabel.setText("hasta");
		//}
		spinner_1 = new JSpinner();

		textField_4 = new JTextField();
		hastaLabel_1 = new JLabel();
		hastaLabel_1.setText("Hasta");
		exteriorLabel = new JLabel();
		exteriorLabel.setText("Exterior:");

		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Todos",
				"Sí", "No" }));
		comboBox_3.setSelectedIndex(0);
		asceensorLabel = new JLabel();
		asceensorLabel.setText("Ascensor:");

		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "Todos",
				"Sí", "No" }));
		comboBox_5.setSelectedIndex(0);
		btLabel = new JLabel();
		btLabel.setText("B/T:");

		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "Todos",
				"Balcón", "Terraza", "Balcón y terraza", "Ninguno" }));
		bajaCheckBox = new JCheckBox();
		bajaCheckBox.setText("Baja");
		altaCheckBox = new JCheckBox();
		altaCheckBox.setSelected(true);
		altaCheckBox.setText("Alta");
		vendidoCheckBox = new JCheckBox();
		vendidoCheckBox.setText("Vendido");
		estadoLabel = new JLabel();
		estadoLabel.setText("Estados:");
		localizarButton_1 = new JButton();
		localizarButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				
			}
		});
		localizarButton_1.setText("Localizar");

		JLabel label_1;
		label_1 = new JLabel();
		label_1.setText("€");
		final GroupLayout groupLayout_2 = new GroupLayout(panel_1);
		groupLayout_2.setHorizontalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(estadoLabel, GroupLayout.Alignment.TRAILING)
								.addComponent(checkBox, GroupLayout.Alignment.TRAILING))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(groupLayout_2.createSequentialGroup()
									.addComponent(deLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(hastaLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout_2.createSequentialGroup()
									.addComponent(altaCheckBox)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(bajaCheckBox)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(vendidoCheckBox)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 4, Short.MAX_VALUE)
									.addComponent(localizarButton_1))))
						.addGroup(groupLayout_2.createSequentialGroup()
							.addGap(10, 10, 10)
							.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(exteriorLabel)
								.addComponent(precioLabel)
								.addComponent(zonaLabel)
								.addComponent(label)
								.addComponent(provinciaLabel))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(groupLayout_2.createSequentialGroup()
									.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
										.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
										.addGroup(groupLayout_2.createSequentialGroup()
											.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(comboBox, 0, 51, Short.MAX_VALUE)
										.addComponent(comboBox_1, 0, 51, Short.MAX_VALUE)
										.addComponent(comboBox_2, 0, 51, Short.MAX_VALUE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
											.addComponent(button_1)
											.addComponent(button_2))
										.addComponent(button, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout_2.createSequentialGroup()
									.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(groupLayout_2.createSequentialGroup()
											.addComponent(hastaLabel_1)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE))
										.addGroup(groupLayout_2.createSequentialGroup()
											.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(asceensorLabel)))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(btLabel)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout_2.setVerticalGroup(
			groupLayout_2.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(provinciaLabel)
						.addComponent(button_2)
						.addComponent(comboBox_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label)
						.addComponent(button_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(zonaLabel)
						.addComponent(button)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioLabel)
						.addComponent(hastaLabel_1)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(exteriorLabel)
						.addComponent(comboBox_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(asceensorLabel)
						.addComponent(comboBox_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btLabel)
						.addComponent(comboBox_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(checkBox)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(hastaLabel)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(deLabel))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout_2.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(estadoLabel)
						.addComponent(altaCheckBox)
						.addComponent(bajaCheckBox)
						.addComponent(vendidoCheckBox)
						.addComponent(localizarButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout_2.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button, button_1, button_2});
		groupLayout_2.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {button, button_1, button_2});
		panel_1.setLayout(groupLayout_2);

		JScrollPane scrollPane;
		scrollPane = new JScrollPane();

		String[] zutabeIzenak = { "Referencia" , "Zona" , "Direccion", "Vendido"};
		Object[][] data = {
			    {"Mary", "Campione",
			     "Snowboarding", new Integer(5)},
			    {"Alison", "Huml",
			     "Rowing", new Integer(3)},
			    {"Kathy", "Walrath",
			     "Knitting", new Integer(2)},
			    {"Sharon", "Zakhour",
			     "Speed reading", new Integer(20)},
			    {"Philip", "Milne",
			     "Pool", new Integer(10)}
			};
		table = new JTable(data, zutabeIzenak);
		scrollPane.setViewportView(table);
		final GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
						.addComponent(scrollPane, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
						.addComponent(tabbedPane, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		//
	}

}
