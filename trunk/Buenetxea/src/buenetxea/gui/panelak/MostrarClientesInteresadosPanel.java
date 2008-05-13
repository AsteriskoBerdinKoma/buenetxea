package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import buenetxea.db.ResultSetTableModel;
import buenetxea.gui.Nagusia;

public class MostrarClientesInteresadosPanel extends JPanel {

	private JTable table_2;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String zonaazkena;
	private int num_habazkena;
	private Double precioazkena;
	private JButton verClienteButton;

	private ResultSetTableModel tableModel;

	/**
	 * Create the panel
	 */
	public MostrarClientesInteresadosPanel() {
		super();
		addComponentListener(new ComponentAdapter() {
			public void componentShown(final ComponentEvent arg0) {
				tableModel = new ResultSetTableModel(crearQuery());
				table_2.setModel(tableModel);
				if (table_2.getRowCount() == 0) {
					verClienteButton.setEnabled(false);
					JOptionPane jop = new JOptionPane(
							"Por el momento, no hay clientes interesados en este inmueble.",
							JOptionPane.INFORMATION_MESSAGE);
					jop.createDialog("Información")
							.setVisible(true);
				}
			}
			public void componentHidden(final ComponentEvent arg0) {
				tableModel = null;
				table_2.setModel(new DefaultTableModel());
			}
		});
	

		setBorder(new TitledBorder(null, "Clientes interesados",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		//tableModel = new ResultSetTableModel(crearQuery());

		JScrollPane scrollPane_1;
		scrollPane_1 = new JScrollPane();

		table_2 = new JTable();
		//table_2.setModel(tableModel);
		table_2.setModel(new DefaultTableModel());
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 2) {
					String dni = (String) table_2.getValueAt(table_2
							.getSelectedRow(), 0);
					Nagusia.getInstance().showVerCliente(dni);
					//MostrarClienteSeleccionadoDialog2 dialogoa = new MostrarClienteSeleccionadoDialog2(dni);
					//dialogoa.pack();
					//dialogoa.setLocationRelativeTo(null);
					//dialogoa.setVisible(true);
				}
			}
		});
		scrollPane_1.setViewportView(table_2);

		verClienteButton = new JButton();
		verClienteButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String dni = (String) table_2.getValueAt(table_2
						.getSelectedRow(), 0);
				Nagusia.getInstance().showVerCliente(dni);
			}
		});
		verClienteButton.setText("Ver cliente");

		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
						.addComponent(verClienteButton, GroupLayout.Alignment.TRAILING))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(verClienteButton))
		);
		setLayout(groupLayout);
	}

	private String crearQuery() {
		// String query = "SELECT * FROM inmueble WHERE referencia = 1";
		if (zonaazkena != "") {
			String query = "SELECT dni AS 'D.N.I.',nombre AS 'Nombre',apellido1 AS 'Primer apellido',apellido2 AS 'Segundo apellido',telefono AS 'Telefono' FROM cliente INNER JOIN preferencia ON fk_cliente_dni = dni "
					+ "WHERE zona ='"
					+ zonaazkena
					+ "' AND desde_habitacion <= "
					+ num_habazkena
					+ " AND hasta_habitacion >= "
					+ num_habazkena
					+ " AND presupuesto >= " + precioazkena;
			return query;
		} else
			return "SELECT dni AS 'D.N.I.',nombre AS 'Nombre',apellido1 AS 'Primer apellido',apellido2 AS 'Segundo apellido',telefono AS 'Telefono' FROM cliente";
	}

	// private final class klienteakatzitu implements ActionListener {
	// public void actionPerformed(final ActionEvent arg0) {
	// try {
	// tableModel.setQuery(crearQuery());
	// } catch (IllegalStateException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	//	
	public void setDatos(String zona, int num_habitaciones, double precio) {
		this.zonaazkena = zona;
		this.num_habazkena = num_habitaciones;
		this.precioazkena = precio;
//		try {
//			tableModel.setQuery(crearQuery());
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void refresh() {
		try {
			tableModel.refresh();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
