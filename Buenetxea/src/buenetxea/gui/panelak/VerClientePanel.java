package buenetxea.gui.panelak;

import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
import buenetxea.kudeatzaileak.InprimagailuKudeatzailea;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Cliente;
import buenetxea.objektuak.fitxak.DatosCliente;

public class VerClientePanel extends JPanel {

	private JTextField textField;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String clientedniazkena;
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

			masterReport = (JasperReport) JRLoader
					.loadObject("ClienteVacio.jasper");

			jp = JasperFillManager.fillReport(masterReport, new HashMap(),
					datasource);

			viewer = new JRViewer(jp);

			JButton button_1;
			button_1 = new JButton();
			button_1.setText("New JButton");

			JLabel label;
			label = new JLabel();
			label.setText("New JLabel");

			textField = new JTextField();

			JButton verButton;
			verButton = new JButton();
			verButton.setText("Ver Ficha Cliente");

			JButton verFichaVaciaButton;
			verFichaVaciaButton = new JButton();
			verFichaVaciaButton.setText("Ver Ficha Vacia");
			final GroupLayout groupLayout = new GroupLayout((JComponent) this);
			groupLayout
					.setHorizontalGroup(groupLayout
							.createParallelGroup(GroupLayout.Alignment.TRAILING)
							.addGroup(
									GroupLayout.Alignment.LEADING,
									groupLayout
											.createSequentialGroup()
											.addContainerGap()
											.addGroup(
													groupLayout
															.createParallelGroup(
																	GroupLayout.Alignment.LEADING)
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addComponent(
																					viewer,
																					GroupLayout.DEFAULT_SIZE,
																					519,
																					Short.MAX_VALUE)
																			.addContainerGap())
															.addGroup(
																	groupLayout
																			.createSequentialGroup()
																			.addComponent(
																					label)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					textField,
																					GroupLayout.PREFERRED_SIZE,
																					97,
																					GroupLayout.PREFERRED_SIZE)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					verButton)
																			.addPreferredGap(
																					LayoutStyle.ComponentPlacement.RELATED)
																			.addComponent(
																					verFichaVaciaButton)
																			.addContainerGap(
																					144,
																					Short.MAX_VALUE))
															.addComponent(
																	button_1,
																	GroupLayout.Alignment.TRAILING))));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addGroup(
							groupLayout.createParallelGroup(
									GroupLayout.Alignment.BASELINE)
									.addComponent(label).addComponent(
											textField,
											GroupLayout.PREFERRED_SIZE,
											GroupLayout.DEFAULT_SIZE,
											GroupLayout.PREFERRED_SIZE)
									.addComponent(verButton).addComponent(
											verFichaVaciaButton))
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(viewer, GroupLayout.PREFERRED_SIZE,
									323, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(
									LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(button_1).addContainerGap()));
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
		}
	}

	public void setCliente(String dni) {
		DatosCliente dc;
		if (dni == null)
			dc = new DatosCliente();
		else {
			try {
				Cliente c = kud.getCliente(dni);
				if (c != null) {
					cliente = c;

				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void jasperReport() {
		try {
			JasperReport jr;
			JasperPrint jp = null;
			InprimagailuKudeatzailea inpr = InprimagailuKudeatzailea
					.getInstance();
			DatosCliente dc = new DatosCliente();

			// Datasourceak betetzen dira.
			dc = inpr.InprimatuCliente(clientedniazkena);
			Collection<DatosCliente> lista = new ArrayList<DatosCliente>();
			lista.add(dc);
			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(
					lista);
			JRBeanCollectionDataSource datasourceSubreport = new JRBeanCollectionDataSource(
					inpr.ClienteSubReport(clientedniazkena));

			JasperReport masterReport = (JasperReport) JRLoader
					.loadObject("Cliente.jasper");
			JasperReport subReport = (JasperReport) JRLoader
					.loadObject("cliente_subreport1.jasper");

			Map masterParams = new HashMap();
			masterParams.put("SUBREPORT", subReport);
			masterParams.put("SUBREPORT_DATASOURCE", datasourceSubreport);

			jp.removePage(0);
			jp.addPage((JRPrintPage) JasperFillManager.fillReport(masterReport,
					masterParams, datasource).getPages().get(0));

		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}