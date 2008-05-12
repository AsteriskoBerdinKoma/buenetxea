package buenetxea.gui.panelak;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRPrintPage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import buenetxea.gui.Nagusia;
import buenetxea.kudeatzaileak.InprimagailuKudeatzailea;
import buenetxea.objektuak.fitxak.DatosCliente;

public class VerClientePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String clientedniazkena;

	/**
	 * Create the panel
	 * 
	 * @throws JRException
	 * @throws FileNotFoundException
	 */

	public VerClientePanel(Nagusia jabea, String clientedni) {
		super();

		this.clientedniazkena = clientedni;

		this.setBorder(new TitledBorder(null, "Ver cliente solicitado",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		this.setLayout(new BorderLayout());

		final JPanel panel_1 = new JPanel();
		final FlowLayout flowLayout_1 = new FlowLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_1.setLayout(flowLayout_1);
		panel_1.setSize(484, 34);
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		this.add(panel_1, BorderLayout.SOUTH);

		JButton button;
		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
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
					masterParams.put("SUBREPORT_DATASOURCE",
							datasourceSubreport);

					jp.removePage(0);
					jp.addPage((JRPrintPage) JasperFillManager.fillReport(
							masterReport, masterParams, datasource).getPages()
							.get(0));

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
		});
		panel_1.add(button);
		button.setText("New JButton");
		//

	}

}