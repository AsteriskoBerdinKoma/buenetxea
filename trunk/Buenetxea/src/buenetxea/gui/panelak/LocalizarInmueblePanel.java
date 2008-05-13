package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import buenetxea.db.ResultSetTableModel;
import buenetxea.kudeatzaileak.Kudeatzailea;

public class LocalizarInmueblePanel extends JPanel {

	private ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private ResultSetTableModel tableModel;
	private JComboBox comboBox_ascensor;
	private JComboBox comboBox_exterior;
	private JTextField textField_prezioa;
	private JComboBox comboBox_9;
	private JComboBox comboBox_8;
	private JComboBox comboBox_7;
	private JTextField textField_8;
	private JTextField textField_7;
	private JTextField textField_6;
	private JSpinner spinner_hastaHab;
	private JSpinner spinner_desdeHab;
	private String zona = "", herrialdea = "", probintzia = "", exterior = "",
			estado = "";
	private int prezioa = -1, habitacionesDesde = -1, habitacionesHasta = -1;
	private String ascensor = "";
	private Vector<String> herrialdeInteresatuak = new Vector();
	private Vector<String> zonaInteresatuak = new Vector();
	private int herrialdeInteresKop, zonaInteresKop = 0;
	private String zeudenHerriak, zeudenZonak;
	private String s = "No";
	private int vendido = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Kudeatzailea kud;

	/**
	 * Create the panel
	 */
	public LocalizarInmueblePanel() {
		super();
		addComponentListener(new ComponentAdapter() {
			public void componentShown(final ComponentEvent arg0) {
				if (tableModel == null)
					tableModel = new ResultSetTableModel(getQuery());
				else {
					try {
						tableModel.refresh();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				table.setModel(tableModel);
			}

			public void componentHidden(final ComponentEvent arg0) {
				table.setModel(new DefaultTableModel());
			}
		});

		try {
			kud = Kudeatzailea.getInstance();

			setBorder(new TitledBorder(null, "Localizador",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			// if checkBox.setSelectedIcon(Nº Habitaciones:){
			// selekzionau zenbat abitaziokin nahi dan
			// spinner_1 = new JSpinner();
			// }

			JLabel estadoLabel_1;
			estadoLabel_1 = new JLabel();
			estadoLabel_1.setText("Estados:");

			final JCheckBox checkBox_1;
			checkBox_1 = new JCheckBox();
			checkBox_1.setText("Nº Habitaciones:");

			JLabel deLabel_1;
			deLabel_1 = new JLabel();
			deLabel_1.setText("Desde");

			spinner_desdeHab = new JSpinner();

			JLabel hastaLabel_2;
			hastaLabel_2 = new JLabel();
			hastaLabel_2.setText("hasta");

			spinner_hastaHab = new JSpinner();

			JCheckBox altaCheckBox_1;
			altaCheckBox_1 = new JCheckBox();
			altaCheckBox_1.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent arg0) {
					estado = "alta";
				}
			});
			buttonGroup.add(altaCheckBox_1);
			altaCheckBox_1.setSelected(true);
			altaCheckBox_1.setText("Alta");

			JCheckBox bajaCheckBox_1;
			bajaCheckBox_1 = new JCheckBox();
			bajaCheckBox_1.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					estado = "baja";
				}
			});
			buttonGroup.add(bajaCheckBox_1);
			bajaCheckBox_1.setText("Baja");

			final JCheckBox vendidoCheckBox_1;
			vendidoCheckBox_1 = new JCheckBox();
			vendidoCheckBox_1.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					estado = "vendido";
				}
			});
			buttonGroup.add(vendidoCheckBox_1);
			vendidoCheckBox_1.setText("Vendido");

			JButton localizarButton_1_1;
			localizarButton_1_1 = new JButton();

			localizarButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					try {
						prezioa = Integer.parseInt(textField_prezioa.getText());
					} catch (NumberFormatException e2) {
						prezioa = -1;
					}
					exterior = comboBox_exterior.getSelectedItem().toString()
							.trim();
					ascensor = comboBox_ascensor.getSelectedItem().toString()
							.trim();
					if (checkBox_1.isSelected()) {
						habitacionesDesde = Integer.parseInt(spinner_desdeHab
								.getValue().toString());
						habitacionesHasta = Integer.parseInt(spinner_hastaHab
								.getValue().toString());
					}
					try {
						if (vendidoCheckBox_1.isSelected())
							vendido = 1;
					} catch (RuntimeException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						tableModel.setQuery(getQuery());
					} catch (IllegalStateException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			localizarButton_1_1.setText("Localizar");

			JLabel exteriorLabel_1;
			exteriorLabel_1 = new JLabel();
			exteriorLabel_1.setText("Exterior:");

			JLabel precioLabel_1;
			precioLabel_1 = new JLabel();
			precioLabel_1.setText("Precio:");

			JLabel zonaLabel_1;
			zonaLabel_1 = new JLabel();
			zonaLabel_1.setText("Zona:");

			JLabel label_2;
			label_2 = new JLabel();
			label_2.setText("Población:");

			JLabel provinciaLabel_1;
			provinciaLabel_1 = new JLabel();
			provinciaLabel_1.setText("Provincia:");

			textField_6 = new JTextField();

			textField_7 = new JTextField();

			textField_8 = new JTextField();

			comboBox_7 = new JComboBox();
			comboBox_7.setModel(new DefaultComboBoxModel(new String[] {
					"Parte vieja", "Centro", "Afueras", "Kontxa" }));

			comboBox_8 = new JComboBox();
			comboBox_8.setModel(new DefaultComboBoxModel(new String[] {
					"Donostia", "Irun", "Bilbao", "Gasteiz", "Renteria" }));

			comboBox_9 = new JComboBox();
			comboBox_9.setModel(new DefaultComboBoxModel(new String[] {
					"Guipuzcoa", "Vizcaya", "Araba" }));

			JButton button_1_1;
			button_1_1 = new JButton();
			button_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					herrialdeInteresKop++;
					herrialdea = comboBox_8.getSelectedItem().toString();
					herrialdeInteresatuak.add(herrialdea);
					if (herrialdeInteresKop > 1) {
						zeudenHerriak = textField_6.getText();
						textField_6.setText(herrialdea + "," + zeudenHerriak);
					} else
						textField_6.setText(herrialdea);

				}
			});
			button_1_1.setText("Añadir población");

			JButton button_2_1;
			button_2_1 = new JButton();
			button_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent arg0) {
					probintzia = comboBox_9.getSelectedItem().toString().trim();
					textField_7.setText(probintzia);
				}
			});

			button_2_1.setText("Añadir provincia");
			JButton button_3;
			button_3 = new JButton();
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					zonaInteresKop++;
					zona = comboBox_7.getSelectedItem().toString().trim();
					zonaInteresatuak.add(zona);
					if (zonaInteresKop > 1) {
						zeudenZonak = textField_8.getText();
						textField_8.setText(zeudenZonak + "," + zona);
					} else
						textField_8.setText(zona);

				}
			});
			button_3.setText("Añadir zona");

			JLabel hastaLabel_1_1;
			hastaLabel_1_1 = new JLabel();
			hastaLabel_1_1.setText("Hasta");

			textField_prezioa = new JTextField();

			JLabel label_1_1;
			label_1_1 = new JLabel();
			label_1_1.setText("€");

			comboBox_exterior = new JComboBox();
			comboBox_exterior.setModel(new DefaultComboBoxModel(new String[] {
					"Todos", "No", "Si" }));

			JLabel asceensorLabel_1;
			asceensorLabel_1 = new JLabel();
			asceensorLabel_1.setText("Ascensor:");

			comboBox_ascensor = new JComboBox();
			comboBox_ascensor.setModel(new DefaultComboBoxModel(new String[] {
					"Todos", "No", "Si" }));

			JScrollPane scrollPane;
			scrollPane = new JScrollPane();

			// tableModel = new ResultSetTableModel(getQuery());

			table = new JTable();
			scrollPane.setViewportView(table);
			// table.setModel(tableModel);
			table.setModel(new DefaultTableModel());

			final GroupLayout groupLayout = new GroupLayout(this);
			groupLayout
					.setHorizontalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	scrollPane,
																	GroupLayout.DEFAULT_SIZE,
																	566,
																	Short.MAX_VALUE)
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.LEADING)
																							.addGroup(
																									groupLayout
																											.createSequentialGroup()
																											.addGap(
																													13,
																													13,
																													13)
																											.addComponent(
																													exteriorLabel_1,
																													GroupLayout.PREFERRED_SIZE,
																													48,
																													GroupLayout.PREFERRED_SIZE)
																											.addGap(
																													12,
																													12,
																													12)
																											.addComponent(
																													comboBox_exterior,
																													GroupLayout.PREFERRED_SIZE,
																													63,
																													GroupLayout.PREFERRED_SIZE))
																							.addGroup(
																									groupLayout
																											.createSequentialGroup()
																											.addGroup(
																													groupLayout
																															.createParallelGroup(
																																	GroupLayout.Alignment.LEADING)
																															.addGroup(
																																	groupLayout
																																			.createSequentialGroup()
																																			.addPreferredGap(
																																					LayoutStyle.ComponentPlacement.RELATED)
																																			.addComponent(
																																					checkBox_1,
																																					GroupLayout.PREFERRED_SIZE,
																																					117,
																																					GroupLayout.PREFERRED_SIZE)
																																			.addPreferredGap(
																																					LayoutStyle.ComponentPlacement.RELATED)
																																			.addComponent(
																																					deLabel_1,
																																					GroupLayout.DEFAULT_SIZE,
																																					55,
																																					Short.MAX_VALUE))
																															.addGroup(
																																	groupLayout
																																			.createSequentialGroup()
																																			.addGap(
																																					68,
																																					68,
																																					68)
																																			.addComponent(
																																					estadoLabel_1,
																																					GroupLayout.PREFERRED_SIZE,
																																					49,
																																					GroupLayout.PREFERRED_SIZE)
																																			.addGap(
																																					8,
																																					8,
																																					8)
																																			.addComponent(
																																					altaCheckBox_1,
																																					GroupLayout.PREFERRED_SIZE,
																																					47,
																																					GroupLayout.PREFERRED_SIZE)))
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													spinner_desdeHab,
																													GroupLayout.PREFERRED_SIZE,
																													44,
																													GroupLayout.PREFERRED_SIZE)))
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.TRAILING)
																							.addComponent(
																									asceensorLabel_1,
																									GroupLayout.PREFERRED_SIZE,
																									58,
																									GroupLayout.PREFERRED_SIZE)
																							.addGroup(
																									groupLayout
																											.createParallelGroup(
																													GroupLayout.Alignment.LEADING)
																											.addComponent(
																													bajaCheckBox_1,
																													GroupLayout.PREFERRED_SIZE,
																													50,
																													GroupLayout.PREFERRED_SIZE)
																											.addComponent(
																													hastaLabel_2,
																													GroupLayout.PREFERRED_SIZE,
																													32,
																													GroupLayout.PREFERRED_SIZE)))
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.LEADING)
																							.addComponent(
																									spinner_hastaHab,
																									GroupLayout.PREFERRED_SIZE,
																									43,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									comboBox_ascensor,
																									GroupLayout.PREFERRED_SIZE,
																									63,
																									GroupLayout.PREFERRED_SIZE))
																			.addGap(
																					23,
																					23,
																					23)
																			.addComponent(
																					vendidoCheckBox_1,
																					GroupLayout.PREFERRED_SIZE,
																					71,
																					GroupLayout.PREFERRED_SIZE)
																			.addGap(
																					37,
																					37,
																					37)
																			.addComponent(
																					localizarButton_1_1,
																					GroupLayout.PREFERRED_SIZE,
																					86,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.TRAILING)
																							.addComponent(
																									precioLabel_1,
																									GroupLayout.PREFERRED_SIZE,
																									40,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									zonaLabel_1,
																									GroupLayout.PREFERRED_SIZE,
																									31,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									label_2,
																									GroupLayout.PREFERRED_SIZE,
																									59,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									provinciaLabel_1,
																									GroupLayout.PREFERRED_SIZE,
																									56,
																									GroupLayout.PREFERRED_SIZE))
																			.addGap(
																					20,
																					20,
																					20)
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.LEADING)
																							.addGroup(
																									groupLayout
																											.createSequentialGroup()
																											.addComponent(
																													hastaLabel_1_1,
																													GroupLayout.PREFERRED_SIZE,
																													33,
																													GroupLayout.PREFERRED_SIZE)
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													textField_prezioa,
																													GroupLayout.PREFERRED_SIZE,
																													66,
																													GroupLayout.PREFERRED_SIZE)
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													label_1_1,
																													GroupLayout.PREFERRED_SIZE,
																													28,
																													GroupLayout.PREFERRED_SIZE))
																							.addComponent(
																									textField_8,
																									GroupLayout.Alignment.TRAILING,
																									GroupLayout.DEFAULT_SIZE,
																									170,
																									Short.MAX_VALUE)
																							.addComponent(
																									textField_6,
																									GroupLayout.Alignment.TRAILING,
																									GroupLayout.DEFAULT_SIZE,
																									170,
																									Short.MAX_VALUE)
																							.addComponent(
																									textField_7,
																									GroupLayout.Alignment.TRAILING,
																									GroupLayout.DEFAULT_SIZE,
																									170,
																									Short.MAX_VALUE))
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.LEADING)
																							.addComponent(
																									comboBox_7,
																									0,
																									170,
																									Short.MAX_VALUE)
																							.addComponent(
																									comboBox_8,
																									0,
																									170,
																									Short.MAX_VALUE)
																							.addComponent(
																									comboBox_9,
																									0,
																									170,
																									Short.MAX_VALUE))
																			.addGap(
																					12,
																					12,
																					12)
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.LEADING)
																							.addComponent(
																									button_1_1,
																									GroupLayout.PREFERRED_SIZE,
																									129,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									button_2_1,
																									GroupLayout.PREFERRED_SIZE,
																									129,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									button_3,
																									GroupLayout.PREFERRED_SIZE,
																									129,
																									GroupLayout.PREFERRED_SIZE))))
											.addContainerGap()));
			groupLayout
					.setVerticalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout
											.createSequentialGroup()
											.addGap(5, 5, 5)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	provinciaLabel_1,
																	GroupLayout.PREFERRED_SIZE,
																	16,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	comboBox_9,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	button_2_1,
																	GroupLayout.PREFERRED_SIZE,
																	26,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	textField_7,
																	GroupLayout.PREFERRED_SIZE,
																	16,
																	GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	label_2,
																	GroupLayout.PREFERRED_SIZE,
																	16,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	button_1_1,
																	GroupLayout.PREFERRED_SIZE,
																	26,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	comboBox_8,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	textField_6,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(6, 6, 6)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	zonaLabel_1,
																	GroupLayout.PREFERRED_SIZE,
																	16,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	textField_8,
																	GroupLayout.PREFERRED_SIZE,
																	21,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	comboBox_7,
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	button_3,
																	GroupLayout.PREFERRED_SIZE,
																	26,
																	GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	precioLabel_1,
																	GroupLayout.PREFERRED_SIZE,
																	16,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	hastaLabel_1_1,
																	GroupLayout.PREFERRED_SIZE,
																	16,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	textField_prezioa,
																	GroupLayout.PREFERRED_SIZE,
																	20,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	label_1_1,
																	GroupLayout.PREFERRED_SIZE,
																	16,
																	GroupLayout.PREFERRED_SIZE))
											.addGap(8, 8, 8)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									comboBox_exterior,
																									GroupLayout.PREFERRED_SIZE,
																									GroupLayout.DEFAULT_SIZE,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									comboBox_ascensor,
																									GroupLayout.PREFERRED_SIZE,
																									GroupLayout.DEFAULT_SIZE,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									asceensorLabel_1,
																									GroupLayout.PREFERRED_SIZE,
																									16,
																									GroupLayout.PREFERRED_SIZE)))
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addGap(
																					4,
																					4,
																					4)
																			.addComponent(
																					exteriorLabel_1,
																					GroupLayout.PREFERRED_SIZE,
																					16,
																					GroupLayout.PREFERRED_SIZE)))
											.addGap(8, 8, 8)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addComponent(
																	localizarButton_1_1,
																	GroupLayout.PREFERRED_SIZE,
																	26,
																	GroupLayout.PREFERRED_SIZE)
															.addGroup(
																	groupLayout
																			.createParallelGroup(
																					GroupLayout.Alignment.BASELINE)
																			.addComponent(
																					deLabel_1,
																					GroupLayout.PREFERRED_SIZE,
																					16,
																					GroupLayout.PREFERRED_SIZE)
																			.addComponent(
																					spinner_desdeHab,
																					GroupLayout.PREFERRED_SIZE,
																					20,
																					GroupLayout.PREFERRED_SIZE)
																			.addComponent(
																					hastaLabel_2,
																					GroupLayout.PREFERRED_SIZE,
																					16,
																					GroupLayout.PREFERRED_SIZE)
																			.addComponent(
																					spinner_hastaHab,
																					GroupLayout.PREFERRED_SIZE,
																					20,
																					GroupLayout.PREFERRED_SIZE)
																			.addComponent(
																					checkBox_1,
																					GroupLayout.PREFERRED_SIZE,
																					24,
																					GroupLayout.PREFERRED_SIZE)))
											.addGap(4, 4, 4)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addGap(
																					5,
																					5,
																					5)
																			.addComponent(
																					estadoLabel_1,
																					GroupLayout.PREFERRED_SIZE,
																					16,
																					GroupLayout.PREFERRED_SIZE))
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addGap(
																					1,
																					1,
																					1)
																			.addGroup(
																					groupLayout
																							.createParallelGroup(
																									GroupLayout.Alignment.BASELINE)
																							.addComponent(
																									altaCheckBox_1,
																									GroupLayout.PREFERRED_SIZE,
																									24,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									vendidoCheckBox_1,
																									GroupLayout.PREFERRED_SIZE,
																									24,
																									GroupLayout.PREFERRED_SIZE)
																							.addComponent(
																									bajaCheckBox_1,
																									GroupLayout.PREFERRED_SIZE,
																									24,
																									GroupLayout.PREFERRED_SIZE))))
											.addGap(7, 7, 7).addComponent(
													scrollPane,
													GroupLayout.DEFAULT_SIZE,
													115, Short.MAX_VALUE)
											.addContainerGap()));
			groupLayout.linkSize(javax.swing.SwingConstants.VERTICAL,
					new java.awt.Component[] { textField_6, textField_7,
							textField_8 });
			setLayout(groupLayout);
			//
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (ClassNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}

	private String getQuery() {

		String query = "SELECT distinct I.referencia AS 'Inmueble Ref.', I.zona AS 'Zona' FROM Inmueble  I "
				+ "INNER JOIN (rel_peritaje_inmueble  RPI INNER JOIN (peritaje  P INNER JOIN descripcion  D ON "
				+ "P.id = D.fk_peritaje_id) ON RPI.fk_peritaje_id = P.id) ON "
				+ "I.referencia = RPI.fk_inmueble_referencia WHERE";

		query += " I.direccion LIKE '%" + probintzia + "%' AND ";

		query += " I.direccion LIKE '%" + herrialdea + "%' AND ";

		query += " I.direccion LIKE '%" + zona + "%'";

		if (prezioa != -1)
			query += " AND RPI.precio_venta<=" + prezioa;

		query += " AND P.exterior='" + exterior + "'";

		if (!ascensor.equalsIgnoreCase("Todos"))
			query += " AND P.ascensor=" + ascensor.equalsIgnoreCase("Si");

		if (habitacionesDesde != -1 && habitacionesHasta != -1)

			query += " AND I.referencia IN ( SELECT COUNT(*)  FROM"
					+ " peritaje P INNER JOIN descripcion D ON P.id = D.fk_peritaje_id"
					+ " WHERE D.tipo LIKE '%habit%'" + " GROUP BY p.id"
					+ " HAVING COUNT (*) BETWEEN" + habitacionesDesde + "AND"
					+ habitacionesHasta + ")";

		query += " AND I.vendido = vendido";

		return query;
	}
}
