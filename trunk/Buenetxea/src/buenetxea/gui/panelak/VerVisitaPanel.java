package buenetxea.gui.panelak;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
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
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.fitxak.DatosVisita;

public class VerVisitaPanel extends JPanel {

	private JButton verFichaVaciaButton;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JRViewer viewer;

	private final URL reportPath = VerInmueblePanel.class
			.getResource("/buenetxea/reports/Visita.jasper");

	private String dniCliente;
	private int refInmueble;
	private Calendar fechaVisita;
	private String representante;

	private Kudeatzailea kud;

	private JasperPrint jp;

	public VerVisitaPanel() {
		super();
		try {

			kud = Kudeatzailea.getInstance();

			this.setBorder(new TitledBorder(null, "Ver visita",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));

			Collection<DatosVisita> lista = new ArrayList<DatosVisita>();
			lista.add(new DatosVisita());

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(
					lista);

			JasperReport masterReport;

			masterReport = (JasperReport) JRLoader.loadObject(reportPath);

			jp = JasperFillManager.fillReport(masterReport, new HashMap(),
					datasource);

			viewer = new JRViewer(jp);

			verFichaVaciaButton = new JButton();
			verFichaVaciaButton.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent e) {
					setDatos("", -1, null, "");
				}
			});
			verFichaVaciaButton.setText("Ver Ficha Vacia");

			final GroupLayout groupLayout = new GroupLayout((JComponent) this);
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addContainerGap()
							.addGroup(
									groupLayout.createParallelGroup(
											GroupLayout.Alignment.LEADING)
											.addComponent(viewer,
													GroupLayout.DEFAULT_SIZE,
													464, Short.MAX_VALUE)
											.addComponent(verFichaVaciaButton))
							.addContainerGap()));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addComponent(
							verFichaVaciaButton).addPreferredGap(
							LayoutStyle.ComponentPlacement.RELATED)
							.addComponent(viewer, GroupLayout.DEFAULT_SIZE,
									305, Short.MAX_VALUE).addContainerGap()));
			setLayout(groupLayout);
			final FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		catch (SQLException e) {
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

	public void setDatos(String dniCl, int refInm, Calendar fecha, String repr) {
		DatosVisita dv;
		try {
			try {
				this.dniCliente = dniCl;
				this.refInmueble = refInm;
				this.fechaVisita = fecha;
				this.representante = repr;

				if (fecha != null) {
					dv = kud.getDatosVisita(dniCliente, refInmueble,
							fechaVisita, representante);
					if (dv == null) {
						dv = new DatosVisita();
						this.dniCliente = "";
						this.refInmueble = -1;
						this.fechaVisita = null;
						this.representante = "";
					}
				} else {
					dv = new DatosVisita();
					this.dniCliente = "";
					this.refInmueble = -1;
					this.fechaVisita = null;
					this.representante = "";
				}
			} catch (SQLException e) {
				e.printStackTrace();
				dv = new DatosVisita();
				this.dniCliente = "";
				this.refInmueble = -1;
				this.fechaVisita = null;
				this.representante = "";
			}
			Collection<DatosVisita> lista = new ArrayList<DatosVisita>();
			lista.add(dv);

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(
					lista);

			JasperReport masterReport = (JasperReport) JRLoader
					.loadObject(reportPath);

			jp.removePage(0);
			jp.addPage((JRPrintPage) JasperFillManager.fillReport(masterReport,
					new HashMap(), datasource).getPages().get(0));

			this.validate();
			this.repaint();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}