package buenetxea.gui.panelak;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import buenetxea.gui.dialogs.BuscarClienteDialog;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Cliente;
import buenetxea.objektuak.fitxak.DatosCliente;

public class VerClientePanel extends JPanel {

	private JFormattedTextField textField;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final URL reportPath = VerInmueblePanel.class
			.getResource("/buenetxea/reports/Cliente.jasper");
	private final URL subreportPath = VerInmueblePanel.class
			.getResource("/buenetxea/reports/ClienteSubReport.jasper");
	private final URL reportVacioPath = VerInmueblePanel.class
			.getResource("/buenetxea/reports/ClienteVacio.jasper");

	private JRViewer viewer;

	private Kudeatzailea kud;

	private Cliente cliente;

	private JasperPrint jp;

	/**
	 * Create the panel
	 * 
	 * @throws JRException
	 * @throws FileNotFoundException
	 */

	public VerClientePanel() {
		super();

		try {

			kud = Kudeatzailea.getInstance();

			this.setBorder(new TitledBorder(null, "Ver cliente solicitado",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));
			final FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);

			// Erreportea hutsik erakusteko aurrekoa komentatu eta ondokoa
			// erabili.
			Collection<DatosCliente> lista = new ArrayList<DatosCliente>();
			lista.add(new DatosCliente());

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(
					lista);

			JasperReport masterReport;

			masterReport = (JasperReport) JRLoader.loadObject(reportVacioPath);

			Map map = new HashMap();
			map.put("IMAGE", VerClientePanel.class
					.getResource("/buenetxea/resources/logo_buenetxea.png"));

			jp = JasperFillManager.fillReport(masterReport, map, datasource);

			viewer = new JRViewer(jp);

			JLabel dniDelClienteLabel;
			dniDelClienteLabel = new JLabel();
			dniDelClienteLabel.setText("DNI del cliente:");

			JButton verButton;
			verButton = new JButton();
			verButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					setCliente(textField.getText().trim());
				}
			});
			verButton.setText("Ver Ficha Cliente");

			JButton verFichaVaciaButton;
			verFichaVaciaButton = new JButton();
			verFichaVaciaButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					setCliente("");
				}
			});
			verFichaVaciaButton.setText("Ver Ficha Vacia");

			JButton buscarClienteButton;
			buscarClienteButton = new JButton();
			buscarClienteButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					BuscarClienteDialog bcd = new BuscarClienteDialog();
					bcd.setResultField(textField);
					bcd.pack();
					bcd.setLocationRelativeTo(null);
					bcd.setVisible(true);
					while (bcd.isVisible())
						;
					setCliente(textField.getText().trim());
				}
			});
			buscarClienteButton.setText("Buscar Cliente");

			textField = new JFormattedTextField(new MaskFormatter("########U"));
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
																	GroupLayout.DEFAULT_SIZE,
																	612,
																	Short.MAX_VALUE)
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addComponent(
																					dniDelClienteLabel)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					textField,
																					GroupLayout.PREFERRED_SIZE,
																					85,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					buscarClienteButton)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					verButton)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					verFichaVaciaButton)))
											.addContainerGap()));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addGroup(
							groupLayout.createParallelGroup(
									GroupLayout.Alignment.BASELINE)
									.addComponent(dniDelClienteLabel)
									.addComponent(verButton).addComponent(
											verFichaVaciaButton).addComponent(
											buscarClienteButton).addComponent(
											textField,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(viewer, GroupLayout.DEFAULT_SIZE,
									322, Short.MAX_VALUE).addContainerGap()));
			setLayout(groupLayout);
			//

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setCliente(String dni) {
		DatosCliente dc;
		try {
			if (dni == null) {
				dc = new DatosCliente();
				cliente = null;
			} else {
				try {
					Cliente c = kud.getCliente(dni);
					if (c != null) {
						cliente = c;
						textField.setText(String.valueOf(c.getDni()));
						dc = new DatosCliente(c.getNombre(), c.getApellido1(),
								c.getApellido2(), c.getMedio(),
								c.getTelefono(), c.getAsesor(), c.getDni());
					} else {
						dc = new DatosCliente();
						cliente = null;
						textField.setText("");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					dc = new DatosCliente();
					cliente = null;
					textField.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					dc = new DatosCliente();
					cliente = null;
					textField.setText("");
				}
			}
			Collection<DatosCliente> lista = new ArrayList<DatosCliente>();
			lista.add(dc);

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(
					lista);

			JRBeanCollectionDataSource datasourceSubreport;
			datasourceSubreport = new JRBeanCollectionDataSource(kud
					.getDatosClienteSubreport(dni));

			JasperReport masterReport;
			Map map;
			if (cliente == null) {
				masterReport = (JasperReport) JRLoader
						.loadObject(reportVacioPath);
				map = new HashMap();
				map
						.put(
								"IMAGE",
								VerClientePanel.class
										.getResource("/buenetxea/resources/logo_buenetxea.png"));
			} else {
				masterReport = (JasperReport) JRLoader.loadObject(reportPath);
				JasperReport subReport = (JasperReport) JRLoader
						.loadObject(subreportPath);
				map = new HashMap();
				map.put("SUBREPORT", subReport);
				map.put("SUBREPORT_DATASOURCE", datasourceSubreport);
			}

			jp.removePage(0);
			jp.addPage((JRPrintPage) JasperFillManager.fillReport(masterReport,
					map, datasource).getPages().get(0));

			this.validate();
			this.repaint();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateCliente() {
		setCliente(cliente.getDni());
	}

}