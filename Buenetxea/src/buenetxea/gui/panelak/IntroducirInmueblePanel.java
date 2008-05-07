package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Descripcion;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Peritaje;
import buenetxea.objektuak.Tasacion;

public class IntroducirInmueblePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JScrollPane datosInmScroll;
	DatosInmueblePanel datosInm = new DatosInmueblePanel();
	DatosTasacionPanel datosTas;
	DatosPropietario datosProp1 = new DatosPropietario(this);
	DatosPropietario datosProp2 = new DatosPropietario(null);
	
	JTabbedPane tabbedPane;
	boolean segundoPropietario = false;

	/**
	 * Create the panel
	 */
	public IntroducirInmueblePanel() {
		super();
		setBorder(new TitledBorder(null, "Introducir Inmueble", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));

		tabbedPane = new JTabbedPane();
		
		try {
			datosTas = new DatosTasacionPanel();
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		datosInmScroll = new JScrollPane(datosInm);
		
		tabbedPane.addTab("Datos Peritaje", datosInmScroll);
		tabbedPane.addTab("Datos Tasación", datosTas);
		tabbedPane.addTab("Datos 1er Propietario", datosProp1);

		JButton guardarButton;
		guardarButton = new JButton();
		guardarButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				
				//if comprobar datos guztiak ondo
				//datosInm.comprobarDatos();
				//datosTas.comprobarDatos();
				//deitu generar objeto
				//deitu peritajeKud.insertPeritaje;
				//deitu inmuebleKud.insertInmueble;
				//getAzkeneko peritajeKud.getLastId
				//deitu tasacionKud.insertTasacion;
				//getAzkeneko peritajeKud.getLastId
				//while deitu descripcionKud.insertDescripcion()
				//
				int id = -1;
				try {
					id = Kudeatzailea.getInstance().getLastPeritajeId();
				} catch (Exception ex1) {
					ex1.printStackTrace();
				}
				Peritaje p = datosInm.generarPeritaje(id);
				Inmueble i = datosInm.generarInmueble();
				Vector<Descripcion> vd = datosInm.generarDescripciones(id);
				Tasacion t = datosTas.generarTasacion(id, i.getReferencia());
				try {
					if (Kudeatzailea.getInstance().crearPeritaje(p))
					{
						JOptionPane jop = new JOptionPane(
								"El inmueble se ha introducido correctamente.",
								JOptionPane.INFORMATION_MESSAGE);
						jop.createDialog("Inmueble introducido").setVisible(true);
					}
					else{
						JOptionPane jop = new JOptionPane(
								"No se ha podido crear el propietario.",
								JOptionPane.ERROR_MESSAGE);
						jop.createDialog("Error al crear el cliente")
								.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane jop = new JOptionPane(
							"No se ha podido crear el propietario."+" \n" + e1.getMessage(),
							JOptionPane.ERROR_MESSAGE);
					jop.createDialog("Error al crear el propietario").setVisible(
							true);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane jop = new JOptionPane(
							"No se ha podido crear el propietario.",
							JOptionPane.ERROR_MESSAGE);
					jop.createDialog("Error al crear el propietario").setVisible(
							true);
				}
			}
		});
		guardarButton.setText("Guardar");
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
				.addGroup(GroupLayout.Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(guardarButton))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
					.addGap(11, 11, 11)
					.addComponent(guardarButton)
					.addContainerGap())
		);
		setLayout(groupLayout);
		//
	}
	
	public void segundoPropietario(){
		tabbedPane.addTab("Datos 2º Propietario", datosProp2);
		segundoPropietario = true;
	}
	
	public static void main (String[] args){
		try {
			UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName() );
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		IntroducirInmueblePanel iip = new IntroducirInmueblePanel();
		JFrame frame = new JFrame();
		frame.setSize((iip.getPreferredSize()));
		frame.add(iip);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
