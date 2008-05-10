package buenetxea.gui.panelak.azpipanelak;

import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import buenetxea.objektuak.Propietario;

public class DatosPropietarioPanel extends JPanel {

	private JButton segPropButton;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AreaDatosPropietarioPanel d;
	private AreaTablaPropietariosPanel t;
	private Vector<Propietario> vPropietarios;
	private Vector<Propietario> vPropCriterio;

	/**
	 * Create the panel
	 */
	public DatosPropietarioPanel() {
		super();
		d = new AreaDatosPropietarioPanel();
		t = new AreaTablaPropietariosPanel();
		vPropietarios = new Vector<Propietario>();
		vPropCriterio = new Vector<Propietario>();
		t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					ListSelectionModel lm = (ListSelectionModel) e.getSource();
					for (int i = e.getFirstIndex(); i <= e.getLastIndex(); i++) {
						if (lm.isSelectedIndex(i)) {
							rellenarCampos(i);
							break;
						}
					}
				}
			}
		});
		d.getNombreTextfieldModel().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				notificarCambio();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				notificarCambio();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				notificarCambio();
			}
		});

		d.getDniTextfieldModel().addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				notificarCambio();
			}
			@Override
			public void insertUpdate(DocumentEvent e) {
				notificarCambio();
			}
			@Override
			public void removeUpdate(DocumentEvent e) {
				notificarCambio();
			}
		});

		d.getApellido1TextfieldModel().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						notificarCambio();
					}
					@Override
					public void insertUpdate(DocumentEvent e) {
						notificarCambio();
					}
					@Override
					public void removeUpdate(DocumentEvent e) {
						notificarCambio();
					}
				});

		d.getApellido2TextfieldModel().addDocumentListener(new DocumentListener() {
					@Override
					public void changedUpdate(DocumentEvent e) {
						notificarCambio();
					}
					@Override
					public void insertUpdate(DocumentEvent e) {
						notificarCambio();
					}
					@Override
					public void removeUpdate(DocumentEvent e) {
						notificarCambio();
					}
				});

		segPropButton = new JButton();
		segPropButton.setText("Habilitar 2º Propietario");

		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGroup(
												groupLayout
														.createParallelGroup(
																GroupLayout.Alignment.TRAILING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								GroupLayout.Alignment.LEADING)
																						.addComponent(
																								t,
																								GroupLayout.Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								480,
																								Short.MAX_VALUE)
																						.addComponent(
																								d,
																								GroupLayout.Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								480,
																								Short.MAX_VALUE)))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addContainerGap(
																				349,
																				Short.MAX_VALUE)
																		.addComponent(
																				segPropButton)))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addComponent(d,
						GroupLayout.PREFERRED_SIZE, 242,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addComponent(t,
						GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addComponent(
						segPropButton).addContainerGap(
						GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	public void getPropietariosCriterio(String dniCrit, String nomCrit,
			String ap1Crit, String ap2Crit) {
		for (Propietario i : vPropietarios) {
			if (i.getNombre().startsWith(nomCrit)
					&& i.getDni().startsWith(dniCrit)
					&& i.getApellido1().startsWith(ap1Crit)
					&& i.getApellido2().startsWith(ap2Crit))
				vPropCriterio.add(i);
		}
	}

	public void setPropietarios(Vector<Propietario> vp) {
		vPropietarios = vp;
	}

	public boolean comprobarDatos() {
		boolean correcto = true;
		if (!d.verifyDNI(d.getDniTextfield())) {
			JOptionPane jop = new JOptionPane(
					"El DNI introducido no es válido",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog("Faltan datos").setVisible(true);
			correcto = false;
		}
		if (d.getNombreTextfield().isEmpty()) {
			JOptionPane jop = new JOptionPane(
					"Debe introducir un nombre de propietario",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog("Faltan datos").setVisible(true);
			correcto = false;
		}
		if (d.getApellido1Textfield().isEmpty()) {
			JOptionPane jop = new JOptionPane(
					"Debe introducir el primer apellido",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog("Faltan datos").setVisible(true);
			correcto = false;
		}
		if (d.getApellido2Textfield().isEmpty()) {
			JOptionPane jop = new JOptionPane(
					"Debe introducir el segundo apellido",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog("Faltan datos").setVisible(true);
			correcto = false;
		}
		if (d.getTelFijoTextfield() < 100000000 && d.getTelMovilTextfield() < 100000000) {
			JOptionPane jop = new JOptionPane(
					"Debe introducir un teléfono de contacto",
					JOptionPane.ERROR_MESSAGE);
			jop.createDialog("Faltan datos").setVisible(true);
			correcto = false;
		}
		return correcto;
	}

	public synchronized void rellenarCampos(int i) {
		Propietario prop = vPropCriterio.elementAt(i);
		d.setDniTextfield(prop.getDni());
		d.setNombreTextfield(prop.getNombre());
		d.setApellido1Textfield(prop.getApellido1());
		d.setApellido2Textfield(prop.getApellido2());
		d.setCiudadTextfield(prop.getCiudad());
		d.setCpTextfield(prop.getCp());
		d.setDomicilioTextfield(prop.getDomicilio_postal());
		d.setTelFijoTextfield(prop.getTel_fijo());
		d.setTelMovilTextfield(prop.getTel_movil());
		String[] horFijo = prop.getHorario_fijo().split(":");
		String[] horMovil =prop.getHorario_movil().split(":");
		d.setHoraFijoInicioComboBox(Integer.valueOf(horFijo[0]));
		d.setHoraFijoFinCombobox(Integer.valueOf(horFijo[1]));
		d.setHoraMovilInicioCombobox(Integer.valueOf(horMovil[0]));
		d.setHoraMovilFinCombobox(Integer.valueOf(horMovil[1]));
	}

	public void notificarCambio() {
		String dniCrit = d.getDniTextfield();
		String nomCrit = d.getNombreTextfield();
		String ap1Crit = d.getApellido1Textfield();
		String ap2Crit = d.getApellido2Textfield();
		vPropCriterio.removeAllElements();
		getPropietariosCriterio(dniCrit, nomCrit, ap1Crit, ap2Crit);
		if (dniCrit.isEmpty() && nomCrit.isEmpty() && ap1Crit.isEmpty()
				&& ap2Crit.isEmpty())
			t.setOwners(new Vector<Propietario>());
		else
			t.setOwners(vPropCriterio);
	}

	public Propietario generarPropietario() {
		String horarioFijo = String.valueOf(d.getHoraFijoInicioComboBox())
				+ ":" + d.getHoraFijoFinCombobox();
		String horarioMovil = String.valueOf(d.getHoraMovilInicioCombobox())
				+ ":" + d.getHoraMovilFinCombobox();
		return new Propietario(d.getDniTextfield(), d.getNombreTextfield(), d
				.getApellido1Textfield(), d.getApellido2Textfield(), d
				.getDomicilioTextfield(), d.getCpTextfield(), d
				.getCiudadTextfield(), d.getTelFijoTextfield(), d
				.getTelMovilTextfield(), horarioFijo, horarioMovil);
	}

	public JButton getSegPropButton() {
		return segPropButton;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		Vector<Propietario> vPropietarios = new Vector<Propietario>();
		vPropietarios.add(new Propietario("72498991R", "joaquin", "perez",
				"perez", "", 0, "", 1, 1, "", ""));
		vPropietarios.add(new Propietario("72453454A", "txomin", "pitu",
				"perez", "", 0, "", 1, 1, "", ""));
		vPropietarios.add(new Propietario("72472349B", "anabel", "garcia",
				"iñarritu", "", 0, "", 1, 1, "", ""));
		vPropietarios.add(new Propietario("72422349X", "anabel", "garcia",
				"iñarritu", "", 0, "", 1, 1, "", ""));
		vPropietarios.add(new Propietario("72412982D", "anabel", "garcia",
				"iñarritu", "", 0, "", 1, 1, "", ""));
		vPropietarios.add(new Propietario("72482348E", "ramon", "lizarazu",
				"ruterberg", "", 0, "", 1, 1, "", ""));
		vPropietarios.add(new Propietario("72472823T", "nicole", "sheridan",
				"smith", "", 0, "", 1, 1, "", ""));

		JFrame x = new JFrame();
		DatosPropietarioPanel y = new DatosPropietarioPanel();
		y.setPropietarios(vPropietarios);
		x.add(y);
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setVisible(true);
	}

}
