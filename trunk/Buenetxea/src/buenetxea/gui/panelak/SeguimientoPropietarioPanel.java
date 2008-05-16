package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import buenetxea.db.CachedRowSetTableModel;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Inmueble;

public class SeguimientoPropietarioPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField refInmuebletextField;
	private JTable tablaVisitas;
	private JTable tablaCambios;
	private CachedRowSetTableModel tableModelVisitas;
	private CachedRowSetTableModel tableModelCambios;

	private final String queryVisitasVacio = "SELECT fk_cliente_dni AS 'DNI Cliente', fecha AS 'Fecha visita', " +
											 "precio AS '¿Precio?', le_gusta AS '¿Le gusta?', vendido_en_esta_visita AS '¿Vendido?', " +
											 "alquilado_en_esta_visita AS '¿Alquilado?', representante AS 'Representante' " +
											 "FROM rel_visita WHERE false";
	private final String queryCambiosVacio = "SELECT fk_propietario_dni AS 'DNI Propietario', " +
											 "fecha AS 'Fecha de cambio', nuevo_precio AS 'Nuevo Precio', " +
											 "observaciones AS 'Motivo de cambio' " +
											 "FROM rel_inmueble_propietario WHERE false";

	private Kudeatzailea kud;

	/**
	 * Create the panel
	 */
	public SeguimientoPropietarioPanel() {
		super();
		addComponentListener(new ComponentAdapter() {
			public void componentShown(final ComponentEvent arg0) {

			}

			public void componentHidden(final ComponentEvent arg0) {
				//Put here the code to empty the fields
			}
		});

		try {
			kud = Kudeatzailea.getInstance();

			setBorder(new TitledBorder(null, "Seguimiento propietario",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JPanel panel;
			panel = new JPanel();
			panel.setBorder(new TitledBorder(null,
					"Cambios realizados por los propietarios",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JPanel panelVisitas;
			panelVisitas = new JPanel();
			panelVisitas.setBorder(new TitledBorder(null, "Visitas realizadas",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JPanel panelCambios;
			panelCambios = new JPanel();
			panelCambios.setBorder(new TitledBorder(null, "Búsqueda",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JScrollPane scrollVisitas;
			scrollVisitas = new JScrollPane();

			JScrollPane scrollCambios;
			scrollCambios = new JScrollPane();
			
			tableModelVisitas = new CachedRowSetTableModel(queryVisitasVacio);
			tableModelCambios = new CachedRowSetTableModel(queryCambiosVacio);

			tablaVisitas = new JTable();
			tablaVisitas.setModel(tableModelVisitas);
			scrollVisitas.setViewportView(tablaVisitas);

			tablaCambios = new JTable();
			tablaCambios.setModel(tableModelCambios);
			scrollCambios.setViewportView(tablaCambios);

			JLabel label;
			label = new JLabel();
			label.setText("Ref. Inmueble:");

			JButton mostrarSegButton;
			mostrarSegButton = new JButton();
			mostrarSegButton.setText("Mostrar seguimiento");

			refInmuebletextField = new JTextField();

			mostrarSegButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					if (!refInmuebletextField.getText().isEmpty()) {
						int numReferencia;
						numReferencia = Integer.parseInt(refInmuebletextField.getText());
						try {

							Inmueble inmueble = kud.getInmueble(numReferencia);
							if (inmueble != null) {
								tableModelVisitas.setQuery(getQuery());
								tableModelCambios.setQuery(getQuery2());
							} else {
								JOptionPane joptionpane = new JOptionPane(
										"La referencia del inmueble introducida no se encuentra en la base de datos.",
										JOptionPane.ERROR_MESSAGE);
								joptionpane.createDialog(
										"Inmueble no encontrado").setVisible(
										true);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
							JOptionPane joptionpane = new JOptionPane(
									"La referencia del inmueble introducida no se encuentra en la base de datos.",
									JOptionPane.ERROR_MESSAGE);
							joptionpane.createDialog("Inmueble no encontrado")
									.setVisible(true);
						}
					}
				}

			});

			final GroupLayout groupLayout_2 = new GroupLayout(
					(JComponent) panelVisitas);
			groupLayout_2.setHorizontalGroup(groupLayout_2.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_2.createSequentialGroup().addContainerGap()
							.addComponent(scrollVisitas,
									GroupLayout.DEFAULT_SIZE, 428,
									Short.MAX_VALUE).addContainerGap()));
			groupLayout_2.setVerticalGroup(groupLayout_2.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_2.createSequentialGroup().addComponent(
							scrollVisitas, GroupLayout.DEFAULT_SIZE, 88,
							Short.MAX_VALUE).addContainerGap()));
			panelVisitas.setLayout(groupLayout_2);
			final GroupLayout groupLayout_1 = new GroupLayout(
					(JComponent) panel);
			groupLayout_1.setHorizontalGroup(groupLayout_1.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_1.createSequentialGroup().addContainerGap()
							.addComponent(scrollCambios,
									GroupLayout.DEFAULT_SIZE, 428,
									Short.MAX_VALUE).addContainerGap()));
			groupLayout_1.setVerticalGroup(groupLayout_1.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_1.createSequentialGroup().addComponent(
							scrollCambios, GroupLayout.DEFAULT_SIZE, 87,
							Short.MAX_VALUE).addContainerGap()));
			panel.setLayout(groupLayout_1);
			final GroupLayout groupLayout_3 = new GroupLayout(
					(JComponent) panelCambios);
			groupLayout_3.setHorizontalGroup(groupLayout_3.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_3.createSequentialGroup().addContainerGap()
							.addComponent(label).addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(refInmuebletextField,
									GroupLayout.PREFERRED_SIZE, 93,
									GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(mostrarSegButton).addContainerGap(
									160, Short.MAX_VALUE)));
			groupLayout_3.setVerticalGroup(groupLayout_3.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout_3.createSequentialGroup().addGroup(
							groupLayout_3.createParallelGroup(
									GroupLayout.Alignment.BASELINE)
									.addComponent(label).addComponent(
											refInmuebletextField,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(mostrarSegButton))
							.addContainerGap(GroupLayout.DEFAULT_SIZE,
									Short.MAX_VALUE)));
			panelCambios.setLayout(groupLayout_3);
			final GroupLayout groupLayout = new GroupLayout((JComponent) this);
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
																	GroupLayout.Alignment.LEADING)
															.addComponent(
																	panel,
																	0,
																	0,
																	Short.MAX_VALUE)
															.addComponent(
																	panelCambios,
																	GroupLayout.DEFAULT_SIZE,
																	464,
																	Short.MAX_VALUE)
															.addComponent(
																	panelVisitas,
																	GroupLayout.Alignment.TRAILING,
																	GroupLayout.PREFERRED_SIZE,
																	0,
																	Short.MAX_VALUE))
											.addContainerGap()));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addComponent(
							panelCambios, GroupLayout.PREFERRED_SIZE,
							GroupLayout.DEFAULT_SIZE,
							GroupLayout.PREFERRED_SIZE).addPreferredGap(
							LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panelVisitas,
									GroupLayout.DEFAULT_SIZE, 129,
									Short.MAX_VALUE).addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 128,
									Short.MAX_VALUE).addGap(12, 12, 12)));
			setLayout(groupLayout);
			//
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

	private String getQuery() {
		int ref = Integer.parseInt(refInmuebletextField.getText().trim());
		return "SELECT fk_cliente_dni AS 'DNI Cliente', fecha AS 'Fecha visita', "
				+ "precio AS '¿Precio?', le_gusta AS '¿Le gusta?', "
				+ "vendido_en_esta_visita AS '¿Vendido?', "
				+ "alquilado_en_esta_visita AS '¿Alquilado?', "
				+ "representante AS 'Representante'  "
				+ "FROM rel_visita WHERE fk_inmueble_referencia ="
				+ ref
				+ " GROUP BY fk_cliente_dni";
	}

	private String getQuery2() {
		int ref = Integer.parseInt(refInmuebletextField.getText().trim());
		return "SELECT fk_propietario_dni AS 'DNI Propietario', "
				+ "fecha AS 'Fecha de cambio', nuevo_precio AS 'Nuevo Precio', "
				+ "observaciones AS 'Motivo de cambio' "
				+ "FROM rel_inmueble_propietario WHERE fk_inmueble_referencia ="
				+ ref;
	}
}
