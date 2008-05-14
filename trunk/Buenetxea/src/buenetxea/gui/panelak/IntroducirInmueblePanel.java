package buenetxea.gui.panelak;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import buenetxea.gui.Nagusia;
import buenetxea.gui.panelak.azpipanelak.DatosInmueblePanel;
import buenetxea.gui.panelak.azpipanelak.DatosPropietarioPanel;
import buenetxea.gui.panelak.azpipanelak.DatosTasacionPanel;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Descripcion;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Peritaje;
import buenetxea.objektuak.Propietario;
import buenetxea.objektuak.RelInmueblePropietario;
import buenetxea.objektuak.Tasacion;

public class IntroducirInmueblePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JScrollPane datosInmScroll;
	DatosInmueblePanel datosInm = new DatosInmueblePanel();
	DatosTasacionPanel datosTas;
	DatosPropietarioPanel datosProp1 = new DatosPropietarioPanel();
	DatosPropietarioPanel datosProp2;
	Vector<Propietario> vAllPropietarios = new Vector<Propietario>();
	boolean segundoPropietario = false;

	JTabbedPane tabbedPane;

	/**
	 * Create the panel
	 */
	public IntroducirInmueblePanel() {
		super();
		try {
			setBorder(new TitledBorder(null, "Introducir Inmueble",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			tabbedPane = new JTabbedPane();

			datosTas = new DatosTasacionPanel();

			vAllPropietarios = Kudeatzailea.getInstance().getPropietarios();
			datosProp1.setPropietarios(vAllPropietarios);

			datosInmScroll = new JScrollPane(datosInm);

			tabbedPane.addTab("Datos Peritaje", datosInmScroll);
			tabbedPane.addTab("Datos Tasación", datosTas);
			tabbedPane.addTab("Datos 1er Propietario", datosProp1);

			datosProp1.getSegPropButton().addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (!segundoPropietario) {
								datosProp2 = new DatosPropietarioPanel();
								datosProp2.setPropietarios(vAllPropietarios);
								datosProp2.getSegPropButton().setVisible(false);
								tabbedPane.addTab("Datos 2º Propietario",
										datosProp2);
								segundoPropietario = true;
								datosProp1.getSegPropButton().setText(
										"Deshabilitar 2º Propietario");
							} else {
								tabbedPane.remove(datosProp2);
								datosProp1.getSegPropButton().setText(
										"Habilitar 2º Propietario");
								segundoPropietario = false;
							}

						}

					});

			JButton guardarButton;
			guardarButton = new JButton();
			guardarButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {

					int id = 1;
					try {
						boolean compInm = datosInm.comprobarDatos();
						boolean compTas = datosTas.comprobarDatos();
						boolean compProp1 = datosProp1.comprobarDatos();
						boolean compProp2 = true;
						if (segundoPropietario) {
							compProp2 = datosProp2.comprobarDatos();
						}
						if (compInm && compTas && compProp1 && compProp2) {
							Peritaje p = datosInm.generarPeritaje(id);
							Inmueble i = datosInm.generarInmueble();
							Propietario p1 = datosProp1.generarPropietario();
							Propietario p2 = null;
							if (segundoPropietario) {
								p2 = datosProp2.generarPropietario();
							}
							boolean peritajeOk = Kudeatzailea.getInstance()
									.crearPeritaje(p);
							id = (Kudeatzailea.getInstance()
									.getLastPeritajeId());
							Tasacion t = datosTas.generarTasacion(id, i
									.getReferencia());
							Vector<Descripcion> vd = datosInm
									.generarDescripciones(id);
							boolean inmuebleOk = Kudeatzailea.getInstance()
									.crearInmueble(i);
							boolean tasacionOk = Kudeatzailea.getInstance()
									.crearTasacion(t);
							boolean descripcionesOk = true;
							boolean propietario1Ok = true;
							boolean propietario2Ok = true;
							for (Descripcion d : vd) {
								if (!Kudeatzailea.getInstance()
										.crearDescripcion(d))
									descripcionesOk = false;
							}
							if (!segundoPropietario) {
								boolean update = false;
								for (Propietario pr : vAllPropietarios) {
									if (pr.compareTo(p1) == 0) {
										update = true;
									}
								}
								if (update) {
									propietario1Ok = Kudeatzailea.getInstance()
											.actualizarPropietario(p1);
									Kudeatzailea
											.getInstance()
											.crearRelPropInmueble(
													new RelInmueblePropietario(
															i.getReferencia(),
															p1.getDni(),
															t.getPrecio_venta(),
															p.getFecha(), ""));
								} else {
									propietario1Ok = Kudeatzailea.getInstance()
											.crearPropietario(p1);
									Kudeatzailea
											.getInstance()
											.crearRelPropInmueble(
													new RelInmueblePropietario(
															i.getReferencia(),
															p1.getDni(),
															t.getPrecio_venta(),
															p.getFecha(), ""));
								}
							} else {
								boolean update1 = false;
								boolean update2 = false;
								for (Propietario pr : vAllPropietarios) {
									if (pr.compareTo(p1) == 0) {
										update1 = true;
									}
									if (pr.compareTo(p2) == 0) {
										update2 = true;
									}
								}
								if (update1) {
									propietario1Ok = Kudeatzailea.getInstance()
											.actualizarPropietario(p1);
									Kudeatzailea
											.getInstance()
											.crearRelPropInmueble(
													new RelInmueblePropietario(
															i.getReferencia(),
															p1.getDni(),
															t.getPrecio_venta(),
															p.getFecha(), ""));
								} else {
									propietario1Ok = Kudeatzailea.getInstance()
											.crearPropietario(p1);
									Kudeatzailea
											.getInstance()
											.crearRelPropInmueble(
													new RelInmueblePropietario(
															i.getReferencia(),
															p1.getDni(),
															t.getPrecio_venta(),
															p.getFecha(), ""));
								}
								if (update2) {
									propietario2Ok = Kudeatzailea.getInstance()
											.actualizarPropietario(p2);
									Kudeatzailea
											.getInstance()
											.crearRelPropInmueble(
													new RelInmueblePropietario(
															i.getReferencia(),
															p2.getDni(),
															t.getPrecio_venta(),
															p.getFecha(), ""));
								} else {
									propietario2Ok = Kudeatzailea.getInstance()
											.crearPropietario(p2);
									Kudeatzailea
											.getInstance()
											.crearRelPropInmueble(
													new RelInmueblePropietario(
															i.getReferencia(),
															p2.getDni(),
															t.getPrecio_venta(),
															p.getFecha(), ""));
								}
							}

							if (peritajeOk && inmuebleOk && tasacionOk
									&& descripcionesOk && propietario1Ok
									&& propietario2Ok) {
								JOptionPane jop = new JOptionPane(
										"La operación se ha realizado correctamente.",
										JOptionPane.INFORMATION_MESSAGE);
								jop.createDialog("Inmueble introducido")
										.setVisible(true);
								/*
								 * Debería llamar al método
								 * buscarClientesInteresados(). Si ese método no
								 * existe, debería destruirse el objeto y
								 * volverse a asignar desde el panel principal.
								 */
								limpiarDatos();
								clientesInteresados(i, vd, t);

							} else {
								JOptionPane jop = new JOptionPane(
										"No se ha podido introducir el inmueble.\nResive sus datos.",
										JOptionPane.ERROR_MESSAGE);
								jop.createDialog(
										"Error al introducir el inmueble")
										.setVisible(true);
							}
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane jop = new JOptionPane(
								"No se ha podido introducir el inmueble."
										+ " \n" + e1.getMessage(),
								JOptionPane.ERROR_MESSAGE);
						jop.createDialog("Error al introducir el inmueble")
								.setVisible(true);
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane jop = new JOptionPane(
								"No se ha podido introducir el inmueble.",
								JOptionPane.ERROR_MESSAGE);
						jop.createDialog("Error al introducir el inmueble")
								.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			});
			guardarButton.setText("Guardar");
			final GroupLayout groupLayout = new GroupLayout((JComponent) this);
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addComponent(tabbedPane,
					GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE).addGroup(
					GroupLayout.Alignment.TRAILING,
					groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(guardarButton)));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addComponent(
							tabbedPane, GroupLayout.DEFAULT_SIZE, 300,
							Short.MAX_VALUE).addGap(11, 11, 11).addComponent(
							guardarButton).addContainerGap()));
			setLayout(groupLayout);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isSegundoPropietario() {
		return segundoPropietario;
	}

	public void limpiarDatos() {

		try {
			Vector<Propietario> vpR = Kudeatzailea.getInstance()
					.getPropietarios();
			datosProp1.setPropietarios(vpR);
			if (segundoPropietario) {
				datosProp2.setPropietarios(vpR);
				Component[] compProp2 = this.datosProp2.getComponents();
			}
			Component[] compTas = this.datosTas.getComponents();
			for (int i = 0; i < compTas.length; i++) {
				if (compTas[i].getClass().equals(JPanel.class)) {
					JPanel jp = (JPanel) compTas[i];
					Component[] jpcomp = jp.getComponents();
					for (int j = 0; j < jpcomp.length; j++) {
						if (jpcomp[j].getClass().equals(JTextField.class)) {
							JTextField x = (JTextField) jpcomp[j];
							x.setText("0.0");
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void clientesInteresados(Inmueble i, Vector<Descripcion> vd,
			Tasacion t) {
		Nagusia n = Nagusia.getInstance();
		int hab = 0;
		for (Descripcion d : vd) {
			if (d.getTipo().startsWith("habit")
					|| d.getTipo().startsWith("Habit"))
				hab++;
		}
		n.showMostrarClientesInterados(i.getZona(), hab, t.getPrecio_venta());
	}

	public boolean isClientesInteresados(double precio, String zona,
			int numHabit, int numAseos) {
		// Kudeatzailea.getInstance.hayClientesInteresados(precio,zona,numHabit,numAseos);
		return false;
	}

	// public static void main(String[] args) {
	// try {
	// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	// } catch (ClassNotFoundException e) {
	// e.printStackTrace();
	// } catch (InstantiationException e) {
	// e.printStackTrace();
	// } catch (IllegalAccessException e) {
	// e.printStackTrace();
	// } catch (UnsupportedLookAndFeelException e) {
	// e.printStackTrace();
	// }
	// IntroducirInmueblePanel iip = new IntroducirInmueblePanel();
	// JFrame frame = new JFrame();
	// frame.setSize((iip.getPreferredSize()));
	// frame.add(iip);
	// frame.setLocationRelativeTo(null);
	// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	// frame.setVisible(true);
	// }

}
