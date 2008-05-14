package buenetxea.gui.panelak.azpipanelak;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

import buenetxea.objektuak.Propietario;

public class AreaTablaPropietariosPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	class OwnerTableModel extends AbstractTableModel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Vector<Propietario> m_Propietarios;

		public OwnerTableModel(Vector<Propietario> propietarios) {
			setPropietarios(propietarios);
		}

		public void setPropietarios(Vector<Propietario> propietarios) {
			m_Propietarios = propietarios;
		}

		@Override
		public int getRowCount() {
			return m_Propietarios.size();
		}

		@Override
		public int getColumnCount() {
			// Emandako klaseak dituen atributu kopurua itzuli behar du
			return 4; // num, DNI, nombre, apellido1, apellido2
		}

		@Override
		public Object getValueAt(int row, int column) {
			switch (column) {
			case 0:
				return new String(m_Propietarios.elementAt(row).getDni());
			case 1:
				return new String(m_Propietarios.elementAt(row).getNombre());
			case 2:
				return new String(m_Propietarios.elementAt(row).getApellido1());
			case 3:
				return new String(m_Propietarios.elementAt(row).getApellido2());
			default:
				return null;
			}
		}

		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return new String("DNI");
			case 1:
				return new String("Nombre");
			case 2:
				return new String("1er Apellido");
			case 3:
				return new String("2º Apellido");
			default:
				return null;
			}
		}

		public void setValueAt(Object value, int row, int col) {
			// Our table is made for selection purposes only, no editing
			// allowed.
		}

		@SuppressWarnings("unchecked")
		public Class getColumnClass(int col) {
			return getValueAt(0, col).getClass();
		}

		public boolean isCellEditable(int row, int col) {
			return false;
		}

	}

	protected JTable taula = new JTable();
	protected OwnerTableModel eredua;

	public AreaTablaPropietariosPanel() {
		taula.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		taula.setColumnSelectionAllowed(false);
		taula.setPreferredScrollableViewportSize(new Dimension(250, 150));

		setLayout(new BorderLayout());
		add(new JScrollPane(taula), BorderLayout.NORTH);
		setBorder(new TitledBorder(null, "Propietarios existentes",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));
	}

	public void setOwners(Vector<Propietario> newOwners) {

		if (eredua == null) {
			eredua = new OwnerTableModel(newOwners);
			taula.setModel(eredua);
			TableColumnModel tcm = taula.getColumnModel();
			tcm.getColumn(0).setMaxWidth(80);
			tcm.getColumn(1).setMaxWidth(80);
			tcm.getColumn(2).setMinWidth(100);
			tcm.getColumn(3).setMinWidth(100);
		} else {
			eredua.setPropietarios(newOwners);
			taula.clearSelection();
		}
		taula.doLayout();
		taula.revalidate();
		taula.repaint();
	}

	public ListSelectionModel getSelectionModel() {

		return taula.getSelectionModel();
	}

	// public static void main(String[] args){
	// Vector<Propietario> vp = new Vector<Propietario>();
	// vp.add(new
	// Propietario("7249","joaquin","perez","perez","",0,"",1,1,"",""));
	// vp.add(new
	// Propietario("7245","txomin","pitu","perez","",0,"",1,1,"",""));
	// vp.add(new
	// Propietario("7247","anabel","garcia","iñarritu","",0,"",1,1,"",""));
	//		
	// AreaTablaPropietariosPanel t = new AreaTablaPropietariosPanel();
	// final javax.swing.JFrame jf = new javax.swing.JFrame("Taula");
	// jf.getContentPane().setLayout(new BorderLayout());
	// jf.getContentPane().add(t, BorderLayout.CENTER);
	// jf.addWindowListener(new java.awt.event.WindowAdapter() {
	// public void windowClosing(java.awt.event.WindowEvent e) {
	// jf.dispose();
	// System.exit(0);
	// }
	// });
	// jf.pack();
	// jf.setVisible(true);
	// t.setOwners(vp);
	// }
}
