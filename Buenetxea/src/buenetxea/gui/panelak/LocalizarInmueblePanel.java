package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import buenetxea.db.ResultSetTableModel;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Inmueble;

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
	private  String zona, herrialdea, probintzia, exterior, estado = "";
	private int prezioa, habitacionesDesde, habitacionesHasta;
	private boolean ascensor;
	private Vector<String> herrialdeInteresatuak;
	private Vector<String> zonaInteresatuak;
	private int herrialdeInteresKop, zonaInteresKop = 0;
	private String zeudenHerriak, zeudenZonak;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Create the panel
	 */
	public LocalizarInmueblePanel() {
		super();
		setBorder(new TitledBorder(null, "Localizador",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		//if checkBox.setSelectedIcon(Nº Habitaciones:){
			//selekzionau zenbat abitaziokin nahi dan
			//spinner_1 = new JSpinner();
		//}

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

		JCheckBox vendidoCheckBox_1;
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
				prezioa = Integer.parseInt(textField_prezioa.getText());
				exterior = comboBox_exterior.getSelectedItem().toString();
				ascensor = Boolean.getBoolean(comboBox_ascensor.getSelectedItem().toString());
				if (checkBox_1.isSelected()){
					habitacionesDesde = Integer.parseInt(spinner_desdeHab.getValue().toString());
					habitacionesHasta = Integer.parseInt(spinner_hastaHab.getValue().toString());
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
		comboBox_7.setModel(new DefaultComboBoxModel (new String[] {"Parte vieja", "Centro", "Afueras"}));

		comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel (new String[] {"Donostia", "Irun", "Bilbao","Gasteiz","Renteria" }));
		
		comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel (new String[] {"Guipuzcoa", "Vizcaya", "Araba"}));

		JButton button_1_1;
		button_1_1 = new JButton();
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				herrialdeInteresKop ++;
				herrialdea = comboBox_8.getSelectedItem().toString();
				herrialdeInteresatuak.add(herrialdea);
				if (herrialdeInteresKop > 1){
					zeudenHerriak = textField_6.getText();
					textField_6.setText(herrialdea+","+zeudenHerriak);
				}
				else
					textField_6.setText(herrialdea);
					
					
			}
		});
		button_1_1.setText("Añadir población");

		JButton button_2_1;
		button_2_1 = new JButton();
		button_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				 probintzia = comboBox_9.getSelectedItem().toString();
				textField_7.setText(probintzia);
			}
		});
		
		button_2_1.setText("Añadir provincia");
		JButton button_3;
		button_3 = new JButton();
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				zonaInteresKop++;
				zona = comboBox_7.getSelectedItem().toString();
				zonaInteresatuak.add(zona);
				if (zonaInteresKop>1){
					zeudenZonak = textField_8.getText();
					textField_8.setText(zeudenZonak+","+zona);
				}
				else
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
		

		JLabel asceensorLabel_1;
		asceensorLabel_1 = new JLabel();
		asceensorLabel_1.setText("Ascensor:");

		comboBox_ascensor = new JComboBox();
		

		JScrollPane scrollPane;
		scrollPane = new JScrollPane();

		tableModel = new ResultSetTableModel(getQuery());
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(tableModel);
		


		
		final GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36, 36, 36)
							.addComponent(provinciaLabel_1, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(textField_7, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button_2_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(33, 33, 33)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(12, 12, 12)
							.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button_1_1, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(68, 68, 68)
									.addComponent(estadoLabel_1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
									.addGap(8, 8, 8)
									.addComponent(altaCheckBox_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(checkBox_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(deLabel_1, GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(13, 13, 13)
											.addComponent(exteriorLabel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
											.addGap(12, 12, 12)
											.addComponent(comboBox_exterior, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
											.addGap(12, 12, 12)
											.addComponent(asceensorLabel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
										.addComponent(comboBox_ascensor, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(bajaCheckBox_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
												.addComponent(spinner_desdeHab, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(hastaLabel_2, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(spinner_hastaHab, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(vendidoCheckBox_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
							.addComponent(localizarButton_1_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(52, 52, 52)
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(precioLabel_1, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(zonaLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(12, 12, 12)
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_8, GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(hastaLabel_1_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(textField_prezioa, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(button_2_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(3, 3, 3)
							.addComponent(textField_7, 0, 0, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5, 5, 5)
							.addComponent(provinciaLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11, 11, 11)
							.addComponent(comboBox_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5, 5, 5)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1, 1, 1)
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(comboBox_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, 0, 0, Short.MAX_VALUE))))
					.addGap(6, 6, 6)
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5, 5, 5)
							.addComponent(zonaLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(3, 3, 3)
								.addComponent(textField_8, 0, 0, Short.MAX_VALUE))
							.addGroup(groupLayout.createSequentialGroup()
								.addGap(1, 1, 1)
								.addComponent(comboBox_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(8, 8, 8)
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(precioLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(hastaLabel_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_prezioa, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(8, 8, 8)
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4, 4, 4)
							.addComponent(exteriorLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(comboBox_exterior, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4, 4, 4)
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(asceensorLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_ascensor, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4, 4, 4)
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(checkBox_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(4, 4, 4)
									.addComponent(localizarButton_1_1, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8, 8, 8)
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(deLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_desdeHab, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
								.addComponent(hastaLabel_2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(spinner_hastaHab, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
					.addGap(4, 4, 4)
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5, 5, 5)
							.addComponent(estadoLabel_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1, 1, 1)
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(altaCheckBox_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(bajaCheckBox_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(vendidoCheckBox_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))))
					.addGap(7, 7, 7)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		//
	}


	private String getQuery() {
		
		String query = "SELECT I.referencia AS 'Inmueble Ref.', I.zona AS 'Zona' FROM Inmueble AS I" +
				"INNER JOIN (rel_peritaje_inmueble AS RPI INNER JOIN (peritaje as P INNER JOIN descripcion AS D ON" +
				"P.id = D.fk_peritaje_id) ON RPI.fk_peritaje_id = P.id) ON " +
				"I.referencia = RPI.fk_inmueble_referencia" +
				" WHERE ";
		if (probintzia!="")
		{
			query += "";
		}
		
		
		return null;
	}
	
	public void refresh()
	{
		try {
			tableModel.refresh();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
