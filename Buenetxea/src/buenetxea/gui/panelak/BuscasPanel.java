package buenetxea.gui.panelak;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
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
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import buenetxea.db.ResultSetTableModel;
import buenetxea.gui.Nagusia;
import buenetxea.gui.dialogs.BuscarClienteDialog;
import buenetxea.gui.dialogs.CrearClienteDialog;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Preferencias;

public class BuscasPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Kudeatzailea kud;
	
	private JTable table;
	private JTextField dniTextField;
	private JLabel errorLabel;

	private ResultSetTableModel tableModel;

	/**
	 * Create the panel
	 */
	public BuscasPanel() {
		super();
		try {
			kud = Kudeatzailea.getInstance();
		
		addComponentListener(new ComponentAdapter() {
			public void componentShown(final ComponentEvent e) {
				if (tableModel == null)
					tableModel = new ResultSetTableModel(getQuery());
				else {
					try {
						tableModel.refresh();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				table.setModel(tableModel);
			}

			public void componentHidden(final ComponentEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});

		JPanel panel;
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Seleccionar Cliente",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JLabel dniLabel;
		dniLabel = new JLabel();
		dniLabel.setText("DNI:");

		dniTextField = new JTextField();

		JButton verInmueblesButton;
		verInmueblesButton = new JButton();
		verInmueblesButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
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
		verInmueblesButton.setText("Ver inmuebles de interes");

		errorLabel = new JLabel();
		errorLabel.setForeground(new Color(255, 0, 0));

		JButton crearClienteNuevoButton;
		crearClienteNuevoButton = new JButton();
		crearClienteNuevoButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				CrearClienteDialog ccd = new CrearClienteDialog();
				ccd.setResultField(dniTextField);
				ccd.pack();
				ccd.setLocationRelativeTo(null);
				ccd.setVisible(true);
			}
		});
		crearClienteNuevoButton.setText("Crear cliente nuevo");

		JScrollPane scrollPane;
		scrollPane = new JScrollPane();

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 2) {
					int ref = Integer.parseInt((String) table.getValueAt(table
							.getSelectedRow(), 0));
					Nagusia.getInstance().showVerInmueble(ref);
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setModel(new DefaultTableModel());
		scrollPane.setViewportView(table);

		JButton verInmuebleButton;
		verInmuebleButton = new JButton();
		verInmuebleButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int ref = Integer.parseInt((String) table.getValueAt(table
						.getSelectedRow(), 0));
				Nagusia.getInstance().showVerInmueble(ref);
			}
		});
		verInmuebleButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 2) {
					int ref = Integer.parseInt((String) table.getValueAt(table
							.getSelectedRow(), 0));
					Nagusia.getInstance().showVerInmueble(ref);
				}
			}
		});
		verInmuebleButton.setText("Ver ficha del inmueble");

		JButton buscarClienteButton;
		buscarClienteButton = new JButton();
		buscarClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				BuscarClienteDialog bcd = new BuscarClienteDialog();
				bcd.setResultField(dniTextField);
				bcd.pack();
				bcd.setLocationRelativeTo(null);
				bcd.setVisible(true);
			}
		});
		buscarClienteButton.setText("Buscar cliente");
		final GroupLayout groupLayout_1 = new GroupLayout((JComponent) panel);
		groupLayout_1
				.setHorizontalGroup(groupLayout_1
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																groupLayout_1
																		.createSequentialGroup()
																		.addComponent(
																				dniLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				dniTextField,
																				GroupLayout.PREFERRED_SIZE,
																				86,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				buscarClienteButton)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				crearClienteNuevoButton)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				verInmueblesButton))
														.addComponent(
																errorLabel))
										.addContainerGap(62, Short.MAX_VALUE)));
		groupLayout_1
				.setVerticalGroup(groupLayout_1
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout_1
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout_1
														.createParallelGroup(
																GroupLayout.Alignment.BASELINE)
														.addComponent(dniLabel)
														.addComponent(
																dniTextField,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																buscarClienteButton)
														.addComponent(
																crearClienteNuevoButton)
														.addComponent(
																verInmueblesButton))
										.addPreferredGap(
												LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(errorLabel)
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		panel.setLayout(groupLayout_1);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.TRAILING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap().addGroup(
						groupLayout.createParallelGroup(
								GroupLayout.Alignment.TRAILING).addComponent(
								scrollPane, GroupLayout.Alignment.LEADING,
								GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
								.addComponent(panel,
										GroupLayout.Alignment.LEADING,
										GroupLayout.DEFAULT_SIZE, 593,
										Short.MAX_VALUE).addComponent(
										verInmuebleButton)).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE).addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE,
								223, Short.MAX_VALUE).addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(verInmuebleButton).addContainerGap()));
		setLayout(groupLayout);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//
	}

	private String getQuery() {
		
		String dni = dniTextField.getText().trim();
		Preferencias preferenciasCliente=null;
		String query;
		
		if (!dni.equals(""))
		{	
			try {
				preferenciasCliente = kud.getPreferencias(dni);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane jop = new JOptionPane(
					"El cliente  introducido no existen.",
					JOptionPane.ERROR_MESSAGE);
				jop.createDialog("Error en los datos").setVisible(true);
				e.printStackTrace();
			}
			if (preferenciasCliente != null)
			{	
				query = "SELECT distinct I.referencia AS 'Inmueble Ref.', I.zona AS 'Zona',P.m2_constr,P.ascensor, p.tipo_inmueble, P.tipo_venta,I.direccion,RPI.precio_venta  FROM Inmueble  I "
				+ "INNER JOIN (rel_peritaje_inmueble  RPI INNER JOIN (peritaje  P INNER JOIN descripcion  D ON "
				+ "P.id = D.fk_peritaje_id) ON RPI.fk_peritaje_id = P.id) ON "
				+ "I.referencia = RPI.fk_inmueble_referencia WHERE";
			
				query += " P.tipo_inmueble LIKE '%"+ preferenciasCliente.getTipo()+ "%'";
			
				query += " AND P.id IN (SELECT id FROM Peritaje WHERE " + preferenciasCliente.getDesde_metros()+ "<= m2_utiles AND " +
					 + preferenciasCliente.getHasta_metros() + " <= m2_utiles";
			
				query += " AND P.exterior="+ preferenciasCliente.getExterior();
			
				query += " AND I.referencia IN ( SELECT RPI.fk_inmueble_referencia, COUNT(*)  FROM"
				+ " rel_peritaje_inmueble RPI INNER JOIN (peritaje P INNER JOIN descripcion D ON P.id = D.fk_peritaje_id) ON RPI.fk_peritaje_id=P.id"
				+ " WHERE D.tipo LIKE 'habit%'"
				+ " GROUP BY RPI.fk_inmueble_referencia"
				+ " HAVING COUNT(*) BETWEEN "
				+ preferenciasCliente.getDesdeHabitaciones()
				+ " AND "
				+ preferenciasCliente.getHastaHabitaciones()+ ")";
			
				query += " AND I.zona LIKE '%" + preferenciasCliente.getZona()+ "%'";
				query += " AND I.referencia IN ( SELECT RPI.fk_inmueble_referencia, COUNT(*)  FROM"
				+ " rel_peritaje_inmueble RPI INNER JOIN (peritaje P INNER JOIN descripcion D ON P.id = D.fk_peritaje_id) ON RPI.fk_peritaje_id=P.id"
				+ " WHERE D.tipo LIKE 'baño%'"
				+ " GROUP BY RPI.fk_inmueble_referencia"
				+ " HAVING COUNT(*) =" + preferenciasCliente.getBanos()+ ")";
			
				query += " AND I.referencia IN ( SELECT RPI.fk_inmueble_referencia, COUNT(*)  FROM"
				+ " rel_peritaje_inmueble RPI INNER JOIN (peritaje P INNER JOIN descripcion D ON P.id = D.fk_peritaje_id) ON RPI.fk_peritaje_id=P.id"
				+ " WHERE D.tipo LIKE 'aseo%'"
				+ " GROUP BY RPI.fk_inmueble_referencia"
				+ " HAVING COUNT(*) =" + preferenciasCliente.getAseos()+ ")";
			
				query += " AND RPI.precio_venta <= " + preferenciasCliente.getPresupuesto();
			
			}
			else
				query = "SELECT distinct I.referencia AS 'Inmueble Ref.', I.zona AS 'Zona',P.m2_constr,P.ascensor, p.tipo_inmueble, P.tipo_venta,I.direccion,RPI.precio_venta  FROM Inmueble  I "
					+ "INNER JOIN (rel_peritaje_inmueble  RPI INNER JOIN (peritaje  P INNER JOIN descripcion  D ON "
					+ "P.id = D.fk_peritaje_id) ON RPI.fk_peritaje_id = P.id) ON "
					+ "I.referencia = RPI.fk_inmueble_referencia WHERE false";			
			 }
		else
			
			query = "SELECT distinct I.referencia AS 'Inmueble Ref.', I.zona AS 'Zona',P.m2_constr,P.ascensor, p.tipo_inmueble, P.tipo_venta,I.direccion,RPI.precio_venta  FROM Inmueble  I "
				+ "INNER JOIN (rel_peritaje_inmueble  RPI INNER JOIN (peritaje  P INNER JOIN descripcion  D ON "
				+ "P.id = D.fk_peritaje_id) ON RPI.fk_peritaje_id = P.id) ON "
				+ "I.referencia = RPI.fk_inmueble_referencia WHERE false";
		
		return query;
	}
}
