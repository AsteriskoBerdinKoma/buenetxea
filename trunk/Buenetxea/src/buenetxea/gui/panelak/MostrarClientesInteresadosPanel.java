package buenetxea.gui.panelak;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import buenetxea.db.ResultSetTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import buenetxea.db.ResultSetTableModel;
import buenetxea.gui.dialogs.BuscarClienteDialog;
import buenetxea.kudeatzaileak.Kudeatzailea;


public class MostrarClientesInteresadosPanel extends JPanel {

	private JTable table_2;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String zonaazkena;
	private int num_habazkena;
	private Double precioazkena;

	private ResultSetTableModel tableModel;

	/**
	 * Create the panel
	 */
	public MostrarClientesInteresadosPanel() {
		super();

		setBorder(new TitledBorder(null, "Clientes interesados",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		tableModel = new ResultSetTableModel(crearQuery());

		JScrollPane scrollPane_1;
		scrollPane_1 = new JScrollPane();

		table_2 = new JTable();
		table_2.setModel(tableModel);
		table_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table_2);

		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
				.addGroup(GroupLayout.Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		//	
	}

	private String crearQuery() {
	//String query = "SELECT * FROM inmueble WHERE referencia = 1";
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
	// public void setDatos (String zona,int num_habitaciones,double precio){
	// this.zonaazkena = zona;
	// this.num_habazkena = num_habitaciones;
	// this.precioazkena = precio;
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
}
