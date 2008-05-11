package buenetxea.gui.panelak;

import java.awt.BorderLayout;
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

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Descripcion;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Peritaje;
import buenetxea.objektuak.Tasacion;
import buenetxea.objektuak.fitxak.DatosInmueble;

public class VerInmueblePanel2 extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Kudeatzailea kud;

	/**
	 * Create the panel
	 * 
	 * @throws JRException
	 * @throws FileNotFoundException
	 */
	public VerInmueblePanel2() {
		super();
		try {
			kud = Kudeatzailea.getInstance();

			this.setBorder(new TitledBorder(null, "Ver Inmueble",
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

			// JASPER REPORTS
			Inmueble i = kud.getInmueble(12987);
			Peritaje p = kud.getLastPeritaje(i.getReferencia());
			Vector<Descripcion> vDescripciones = kud
					.getDescripciones(p.getId());
			// Descripcion d = vDescripciones.firstElement();
			Tasacion t = kud.getTasacion(p.getId(), i.getReferencia());
			double nuevoPrecio = kud.getLastPrecio(i.getReferencia());
			DatosInmueble di = new DatosInmueble(i.getDireccion(), p
					.getTipo_inmueble(), new Boolean(i.isVendido()), i
					.getZona(), p.getTipo_venta(), new Long(new Double(
					nuevoPrecio).longValue()), new Long(new Integer(p
					.getM2_utiles()).longValue()), new Long(new Integer(p
					.getM2_constr()).longValue()), new Long(new Integer(p
					.getM2_parcela()).longValue()), vDescripciones, p
					.getObservaciones(), new Integer(i.getReferencia()), t
					.isLlaves(), p.getAltura_real_piso(), p.getAltura_edif(),
					new Long(new Integer(p.getAnos_finca()).longValue()), p
							.getOrientacion(), p.getGastos_comun());

			// Datasourceak betetzen dira.
			Collection<DatosInmueble> lista = new ArrayList<DatosInmueble>();
			lista.add(di);

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(
					lista);
			JRBeanCollectionDataSource datasourceSubreport = new JRBeanCollectionDataSource(
					di.getVDescripcion());

			// Erreportea hutsik erakusteko aurrekoa komentatu eta ondokoa
			// erabili.
			// Collection<DatosInmueble> lista = new ArrayList<DatosInmueble>();
			// lista.add(new DatosInmueble());
			//
			// Collection<Descripcion> lista2 = new ArrayList<Descripcion>();
			// lista2.add(new Descripcion());
			//
			// JRBeanCollectionDataSource datasource = new
			// JRBeanCollectionDataSource(
			// lista);
			// JRBeanCollectionDataSource datasourceSubreport = new
			// JRBeanCollectionDataSource(
			// lista2);

			JasperReport masterReport = (JasperReport) JRLoader
					.loadObject("inmueble.jasper");
			JasperReport subReport = (JasperReport) JRLoader
					.loadObject("inmueble_subreport1.jasper");

			Map masterParams = new HashMap();
			masterParams.put("SUBREPORT", subReport);
			masterParams.put("SUBREPORT_DATASOURCE", datasourceSubreport);

			JasperPrint jp = JasperFillManager.fillReport(masterReport,
					masterParams, datasource);

			JRViewer jrv = new JRViewer(jp);
			VerInmueblePanel2.this.add(jrv, BorderLayout.CENTER);
			VerInmueblePanel2.this.validate();
			VerInmueblePanel2.this.repaint();

			JButton button;
			button = new JButton();
			button.addActionListener(new ActionListener() {
				public void actionPerformed(final ActionEvent arg0) {
				}
			});
			panel_1.add(button);
			button.setText("New JButton");
			//
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
}
