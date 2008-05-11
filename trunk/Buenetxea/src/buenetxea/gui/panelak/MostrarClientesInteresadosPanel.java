package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import buenetxea.db.ResultSetTableModel;
import buenetxea.gui.Nagusia;
import buenetxea.gui.dialogs.BuscarClienteDialog;
import buenetxea.gui.dialogs.MostrarClienteSeleccionadoDialog;
import buenetxea.objektuak.Cliente;

public class MostrarClientesInteresadosPanel extends JPanel {

	private JTable table_1;
	private String zonaazkena;
	private int num_habazkena;
	private Double precioazkena;
	private ResultSetTableModel tableModel;	
	/**
	 * Create the panel
	 */
	public MostrarClientesInteresadosPanel(String zona,int num_habitaciones,Double precio) {
		super();
	//	closeAfterSave = false;
		this.zonaazkena = zona;
		this.num_habazkena = num_habitaciones;
		this.precioazkena = precio;
		setBorder(new TitledBorder(null, "Clientes interesados", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

		tableModel = new ResultSetTableModel(CrearQuery());
		JScrollPane scrollPane;
		scrollPane = new JScrollPane();
		
		
		table_1 = new JTable();
		//table_1.setSelectionModel(null);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter(){
		     public void mouseClicked(MouseEvent e){
		    	 String clienteref;
		      if (e.getClickCount() == 2){
		           clienteref = (String) table_1.getValueAt(table_1.getSelectedRow(),1);
		           MostrarClienteSeleccionadoDialog klientea = new MostrarClienteSeleccionadoDialog(clienteref);
		       }
		      }
		     } );
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 390, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		//

	
	
	}

	private String CrearQuery() {
		
		String query = "SELECT * FROM Cliente INNER JOIN preferencia ON fk_cliente_dni = dni WHERE";
		
			query += " zona ='" + zonaazkena + "%' AND";
		query += " desde_habitacion <= '" + num_habazkena + "%' AND hasta_habitacion >= '"
				+ num_habazkena + "%' AND presupuesto >= '" + precioazkena + "%'";
		
		return query;
	}
	
	private final class klienteakatzitu implements ActionListener {
		public void actionPerformed(final ActionEvent arg0) {
			try {
				tableModel.setQuery(CrearQuery());
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
/*
	public void setCloseAfterSave(BuscarClienteDialog owner, boolean close) {
		//this.jabea = owner;
		this.closeAfterSave = close;
	}*/
}
