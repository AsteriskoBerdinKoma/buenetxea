package buenetxea.gui.panelak.azpipanelak;

import java.text.ParseException;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import buenetxea.objektuak.Propietario;

public class DatosPropietarioPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AreaDatosPropietarioPanel d;
	private AreaTablaPropietariosPanel t;
	private Vector<Propietario> vPropietarios;
	private Vector<Propietario> vPropCriterio;
	private boolean isUpdate;

	/**
	 * Create the panel
	 */
	public DatosPropietarioPanel() {
		super();
		try {
			isUpdate = false;
			d = new AreaDatosPropietarioPanel();
			t = new AreaTablaPropietariosPanel();
			vPropietarios = new Vector<Propietario>();
			vPropCriterio = new Vector<Propietario>();
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
			vPropietarios.add(new Propietario("72472823T", "nicole",
					"sheridan", "smith", "", 0, "", 1, 1, "", ""));
			// pCrit = getPropietariosCriterio();
			// t.setOwners(pCrit);

			t.setBorder(new TitledBorder(null, "Taula",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));
			//

			t.getSelectionModel().addListSelectionListener(
					new ListSelectionListener() {
						public void valueChanged(ListSelectionEvent e) {
							if (!e.getValueIsAdjusting()) {
								ListSelectionModel lm = (ListSelectionModel) e
										.getSource();
								for (int i = e.getFirstIndex(); i <= e
										.getLastIndex(); i++) {
									if (lm.isSelectedIndex(i)) {
										rellenarCampos(i);
										isUpdate = true;
										break;
									}
								}
							}
						}
					});
			d.getNombreTextfieldModel().addDocumentListener(
					new DocumentListener() {

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

			d.getDniFormatedTextfieldModel().addDocumentListener(
					new DocumentListener() {

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

			d.getApellido1TextfieldModel().addDocumentListener(
					new DocumentListener() {

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

			d.getApellido2TextfieldModel().addDocumentListener(
					new DocumentListener() {

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

			final GroupLayout groupLayout = new GroupLayout((JComponent) this);
			groupLayout
					.setHorizontalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addGroup(
									GroupLayout.Alignment.LEADING,
									groupLayout
											.createSequentialGroup()
											.addGap(10, 10, 10)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addComponent(
																	t,
																	GroupLayout.Alignment.TRAILING,
																	GroupLayout.DEFAULT_SIZE,
																	593,
																	Short.MAX_VALUE)
															.addComponent(
																	d,
																	GroupLayout.Alignment.TRAILING,
																	GroupLayout.DEFAULT_SIZE,
																	593,
																	Short.MAX_VALUE))
											.addContainerGap()));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addComponent(d,
							GroupLayout.PREFERRED_SIZE, 242,
							GroupLayout.PREFERRED_SIZE).addPreferredGap(
							LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(t, GroupLayout.DEFAULT_SIZE, 235,
									Short.MAX_VALUE).addContainerGap()));
			setLayout(groupLayout);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
		// Vector<Propietario> vp = new Vector<Propietario>();
		// return vp;
	}

	public boolean getIsUpdate() {
		return isUpdate;
	}

	public void setPropietarios(Vector<Propietario> vp) {
		vPropietarios = vp;
	}

	public boolean comprobarDatos() {
		return false;
	}

	public synchronized void rellenarCampos(int i) {
		Propietario prop = vPropCriterio.elementAt(i);
		d.setDniFormatedTextfield(prop.getDni());
		d.setNombreTextfield(prop.getNombre());
		d.setApellido1Textfield(prop.getApellido1());
		d.setApellido2Textfield(prop.getApellido2());
		d.setCiudadTextfield(prop.getCiudad());
		d.setCpTextfield(prop.getCp());
		d.setDomicilioTextfield(prop.getDomicilio_postal());
		d.setTelFijoTextfield(prop.getTel_fijo());
		d.setTelMovilTextfield(prop.getTel_movil());
		// hora inicio hora fin movil fijo
	}

	public void notificarCambio() {
		isUpdate = false;
		String dniCrit = d.getDniFormatedTextfield();
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
		return new Propietario(d.getDniFormatedTextfield(), d
				.getNombreTextfield(), d.getApellido1Textfield(), d
				.getApellido2Textfield(), d.getDomicilioTextfield(), d
				.getCpTextfield(), d.getCiudadTextfield(), d
				.getTelFijoTextfield(), d.getTelMovilTextfield(), horarioFijo,
				horarioMovil);
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

		JFrame x = new JFrame();
		DatosPropietarioPanel y = new DatosPropietarioPanel();
		x.add(y);
		x.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x.setVisible(true);
	}

}
