package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import buenetxea.gui.panelak.azpipanelak.DatosInmueblePanel;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Descripcion;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Peritaje;

public class ModificarInmueblePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DatosInmueblePanel datosInmueblePanel;

	private Kudeatzailea kud;

	/**
	 * Create the panel
	 */
	public ModificarInmueblePanel() {
		super();
		try {
			kud = Kudeatzailea.getInstance();

			setBorder(new TitledBorder(null, "Modificar Inmueble",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			JButton modificarInmuebleButton;
			modificarInmuebleButton = new JButton();
			modificarInmuebleButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					try {
						boolean compInm = datosInmueblePanel.comprobarDatos();
						if (compInm) {
							Inmueble i = datosInmueblePanel.generarInmueble();
							int id = (kud.getLastPeritaje(i.getReferencia()))
									.getId();
							Peritaje p = datosInmueblePanel.generarPeritaje(id);
							Vector<Descripcion> vd = datosInmueblePanel
									.generarDescripciones(id);
							boolean peritajeOk = kud.updatePeritaje(p);
							boolean inmuebleOk = kud.updateInmueble(i);
							boolean descripcionesOk = kud.updateDescripciones(
									id, vd);
							if (!descripcionesOk) {
								JOptionPane jop = new JOptionPane(
										"No ha sido posible modificar las descripciones del inmueble.",
										JOptionPane.ERROR_MESSAGE);
								jop.createDialog(
										"Errol al modificar el inmueble")
										.setVisible(true);
							} else if (inmuebleOk && peritajeOk) {
								JOptionPane jop = new JOptionPane(
										"El inmueble se ha modificado correctamente.",
										JOptionPane.INFORMATION_MESSAGE);
								jop.createDialog("Inmueble modificado")
										.setVisible(true);
							} else {
								JOptionPane jop = new JOptionPane(
										"No ha sido posible modificar el inmueble.",
										JOptionPane.ERROR_MESSAGE);
								jop.createDialog(
										"Errol al modificar el inmueble")
										.setVisible(true);
							}
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
						JOptionPane jop = new JOptionPane(
								"No ha sido posible modificar el inmueble.",
								JOptionPane.ERROR_MESSAGE);
						jop.createDialog("Errol al modificar el inmueble")
								.setVisible(true);
					}
				}
			});
			modificarInmuebleButton.setText("Guardar cambios");

			JScrollPane scrollPane_1;
			scrollPane_1 = new JScrollPane();

			datosInmueblePanel = new DatosInmueblePanel();
			scrollPane_1.setViewportView(datosInmueblePanel);
			final GroupLayout groupLayout = new GroupLayout((JComponent) this);
			groupLayout
					.setHorizontalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addGroup(
									groupLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.TRAILING)
															.addComponent(
																	scrollPane_1,
																	GroupLayout.Alignment.LEADING,
																	GroupLayout.DEFAULT_SIZE,
																	464,
																	Short.MAX_VALUE)
															.addComponent(
																	modificarInmuebleButton))
											.addContainerGap()));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.TRAILING).addGroup(
					groupLayout.createSequentialGroup().addComponent(
							scrollPane_1, GroupLayout.DEFAULT_SIZE, 305,
							Short.MAX_VALUE).addPreferredGap(
							LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(modificarInmuebleButton)
							.addContainerGap()));
			setLayout(groupLayout);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		//
	}

	public void setDatuak(Inmueble inmueble) {
		datosInmueblePanel.setDatuak(inmueble);
	}

}
