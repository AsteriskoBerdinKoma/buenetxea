package buenetxea.gui.panelak;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import buenetxea.gui.Nagusia;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Descripcion;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Peritaje;
import buenetxea.objektuak.Tasacion;
import buenetxea.objektuak.fitxak.DatosInmueble;

public class VerInmueblePanel extends JPanel {

	private JButton venderInmuebleButton;
	private JButton modificarInmuebleButton;
	private JButton button;
	private JLabel referenciaDelInmuebleLabel;
	private JButton verFichaDelButton;
	private JTextField textField;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JRViewer viewer;

	private Kudeatzailea kud;

	private Inmueble inmueble;

	private JasperPrint jp;

	/**
	 * Create the panel
	 * 
	 * @throws JRException
	 * @throws FileNotFoundException
	 */
	public VerInmueblePanel() {
		super();
		try {
			kud = Kudeatzailea.getInstance();

			this.setBorder(new TitledBorder(null, "Ver Inmueble",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));
			final FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);

			// Erreportea hutsik erakusteko aurrekoa komentatu eta ondokoa
			// erabili.
			Collection<DatosInmueble> lista = new ArrayList<DatosInmueble>();
			lista.add(new DatosInmueble());

			Collection<Descripcion> lista2 = new ArrayList<Descripcion>();
			lista2.add(new Descripcion());

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(
					lista);
			JRBeanCollectionDataSource datasourceSubreport = new JRBeanCollectionDataSource(
					lista2);

			JasperReport masterReport = (JasperReport) JRLoader
					.loadObject("inmueble.jasper");
			JasperReport subReport = (JasperReport) JRLoader
					.loadObject("inmueble_subreport1.jasper");

			Map masterParams = new HashMap();
			masterParams.put("SUBREPORT", subReport);
			masterParams.put("SUBREPORT_DATASOURCE", datasourceSubreport);

			jp = JasperFillManager.fillReport(masterReport, masterParams,
					datasource);

			viewer = new JRViewer(jp);

			final GroupLayout groupLayout = new GroupLayout((JComponent) this);
			groupLayout
					.setHorizontalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addComponent(
																	viewer,
																	GroupLayout.Alignment.TRAILING,
																	GroupLayout.DEFAULT_SIZE,
																	624,
																	Short.MAX_VALUE)
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
																											.addComponent(
																													getReferenciaDelInmuebleLabel())
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													getTextField(),
																													GroupLayout.PREFERRED_SIZE,
																													79,
																													GroupLayout.PREFERRED_SIZE)
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													getVerFichaDelButton())
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED)
																											.addComponent(
																													getButton())
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED,
																													40,
																													Short.MAX_VALUE))
																							.addGroup(
																									groupLayout
																											.createSequentialGroup()
																											.addComponent(
																													getVenderInmuebleButton())
																											.addPreferredGap(
																													LayoutStyle.ComponentPlacement.RELATED)))
																			.addComponent(
																					getModificarInmuebleButton())))
											.addContainerGap()));
			groupLayout
					.setVerticalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addGroup(
									groupLayout
											.createSequentialGroup()
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	getReferenciaDelInmuebleLabel())
															.addComponent(
																	getTextField(),
																	GroupLayout.PREFERRED_SIZE,
																	GroupLayout.DEFAULT_SIZE,
																	GroupLayout.PREFERRED_SIZE)
															.addComponent(
																	getVerFichaDelButton())
															.addComponent(
																	getButton()))
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(viewer,
													GroupLayout.DEFAULT_SIZE,
													341, Short.MAX_VALUE)
											.addPreferredGap(
													LayoutStyle.ComponentPlacement.RELATED)
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.BASELINE)
															.addComponent(
																	getModificarInmuebleButton())
															.addComponent(
																	getVenderInmuebleButton()))
											.addContainerGap()));
			setLayout(groupLayout);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setInmueble(int ref) {
		DatosInmueble di;
		try {
			try {
				if (ref < 0) {
					di = new DatosInmueble();
					Vector<Descripcion> vd = new Vector<Descripcion>();
					vd.addElement(new Descripcion());
					di.setVDescripcion(vd);
					inmueble = null;
					textField.setText("");
				} else {
					Inmueble i = kud.getInmueble(ref);
					if (i != null) {
						inmueble = i;
						textField.setText(String.valueOf(i.getReferencia()));
						Peritaje p = kud.getLastPeritaje(i.getReferencia());
						Vector<Descripcion> vDescripciones;
						Tasacion t;
						if (p != null) {
							vDescripciones = kud.getDescripciones(p.getId());
							if (vDescripciones.size() == 0) {
								vDescripciones.addElement(new Descripcion());
							}
							t = kud.getTasacion(p.getId(), i.getReferencia());
						} else {
							p = new Peritaje();
							vDescripciones = new Vector<Descripcion>();
							vDescripciones.addElement(new Descripcion());
							t = new Tasacion();
						}
						double nuevoPrecio = kud.getLastPrecio(i
								.getReferencia());
						di = new DatosInmueble(i.getDireccion(), p
								.getTipo_inmueble(),
								new Boolean(i.isVendido()), i.getZona(), p
										.getTipo_venta(), new Long(new Double(
										nuevoPrecio).longValue()), new Long(
										new Integer(p.getM2_utiles())
												.longValue()), new Long(
										new Integer(p.getM2_constr())
												.longValue()), new Long(
										new Integer(p.getM2_parcela())
												.longValue()), vDescripciones,
								p.getObservaciones(), new Integer(i
										.getReferencia()), t.isLlaves(), p
										.getAltura_real_piso(), p
										.getAltura_edif(), new Long(
										new Integer(p.getAnos_finca())
												.longValue()), p
										.getOrientacion(), p.getGastos_comun());
					} else {
						di = new DatosInmueble();
						Vector<Descripcion> vd = new Vector<Descripcion>();
						vd.addElement(new Descripcion());
						di.setVDescripcion(vd);
						inmueble = null;
						textField.setText("");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				di = new DatosInmueble();
				Vector<Descripcion> vd = new Vector<Descripcion>();
				vd.addElement(new Descripcion());
				di.setVDescripcion(vd);
				inmueble = null;
				textField.setText("");
			}

			// Datasourceak betetzen dira.
			Collection<DatosInmueble> lista = new ArrayList<DatosInmueble>();
			lista.add(di);

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(
					lista);
			JRBeanCollectionDataSource datasourceSubreport = new JRBeanCollectionDataSource(
					di.getVDescripcion());

			JasperReport masterReport = (JasperReport) JRLoader
					.loadObject("inmueble.jasper");
			JasperReport subReport = (JasperReport) JRLoader
					.loadObject("inmueble_subreport1.jasper");

			Map masterParams = new HashMap();
			masterParams.put("SUBREPORT", subReport);
			masterParams.put("SUBREPORT_DATASOURCE", datasourceSubreport);

			jp.removePage(0);
			jp.addPage((JRPrintPage) JasperFillManager.fillReport(masterReport,
					masterParams, datasource).getPages().get(0));

			this.validate();
			this.repaint();
			enableDisableButtons();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Errorea eguneratzerakoan");
		}
	}

	private void enableDisableButtons() {
		if (inmueble == null) {
			modificarInmuebleButton.setEnabled(false);
			venderInmuebleButton.setEnabled(false);
		} else {
			modificarInmuebleButton.setEnabled(true);
			if (inmueble.isVendido())
				venderInmuebleButton.setEnabled(false);
			else
				venderInmuebleButton.setEnabled(true);
		}
	}

	/**
	 * @return
	 */
	protected JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
		}
		return textField;
	}

	/**
	 * @return
	 */
	protected JButton getVerFichaDelButton() {
		if (verFichaDelButton == null) {
			verFichaDelButton = new JButton();
			verFichaDelButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					setInmueble(Integer.parseInt(textField.getText().trim()));
				}
			});
			verFichaDelButton.setText("Ver Ficha del Inmueble");
		}
		return verFichaDelButton;
	}

	/**
	 * @return
	 */
	protected JLabel getReferenciaDelInmuebleLabel() {
		if (referenciaDelInmuebleLabel == null) {
			referenciaDelInmuebleLabel = new JLabel();
			referenciaDelInmuebleLabel.setText("Referencia del Inmueble:");
		}
		return referenciaDelInmuebleLabel;
	}

	/**
	 * @return
	 */
	protected JButton getButton() {
		if (button == null) {
			button = new JButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					setInmueble(-1);
				}
			});
			button.setText("Ver Ficha Vacía");
		}
		return button;
	}

	/**
	 * @return
	 */
	protected JButton getModificarInmuebleButton() {
		if (modificarInmuebleButton == null) {
			modificarInmuebleButton = new JButton();
			modificarInmuebleButton.setEnabled(false);
			modificarInmuebleButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
				}
			});
			modificarInmuebleButton.setText("Modificar Inmueble");
		}
		return modificarInmuebleButton;
	}

	/**
	 * @return
	 */
	protected JButton getVenderInmuebleButton() {
		if (venderInmuebleButton == null) {
			venderInmuebleButton = new JButton();
			venderInmuebleButton.setEnabled(false);
			venderInmuebleButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					if (inmueble != null) {
						Nagusia.getInstance().showVenderInmueble(inmueble);
					}
				}
			});
			venderInmuebleButton.setText("Vender Inmueble");
		}
		return venderInmuebleButton;
	}

	public void updateInmueble() {
		setInmueble(inmueble.getReferencia());
	}
}
