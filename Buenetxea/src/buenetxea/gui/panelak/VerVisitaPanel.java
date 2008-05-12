package buenetxea.gui.panelak;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
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
import buenetxea.db.Connector;
import buenetxea.gui.Nagusia;
import buenetxea.kudeatzaileak.InprimagailuKudeatzailea;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Descripcion;
import buenetxea.objektuak.Inmueble;
import buenetxea.objektuak.Tasacion;
import buenetxea.objektuak.fitxak.DatosInmueble;
import buenetxea.objektuak.fitxak.DatosVisita;

public class VerVisitaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private final Nagusia jabea;

	private String dniCliente;
	private int refInmueble;
	private Calendar fechaVisita;
	private String representante;
	

	public VerVisitaPanel() {
		super();
		this.dniCliente = "00000000A";
		this.refInmueble = 0;
		Calendar cal = new GregorianCalendar();
		cal.setTime(new Date());
		this.fechaVisita = cal;
		this.representante = "Ninguno";
		
		addComponentListener(new ComponentAdapter() {
			public void componentShown(final ComponentEvent arg0) {
				try {
					JasperReport jr;
					DatosVisita dv = new DatosVisita();
					HashMap hutsa = new HashMap();
					
						//DATUEK BETE
						InprimagailuKudeatzailea inpr = InprimagailuKudeatzailea.getInstance();
						dv = inpr.InprimatuVisita(dniCliente, refInmueble,fechaVisita, representante);

						//DATASOURCE  BETE
						Collection<DatosVisita> lista = new ArrayList<DatosVisita>();
						lista.add(dv);
						JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(lista);
						
						//JASPERREPORT BETE
						JasperReport masterReport = (JasperReport) JRLoader.loadObject("Visita.jasper");
						JasperPrint jp = JasperFillManager.fillReport(masterReport,hutsa, datasource);

						JRViewer jrv = new JRViewer(jp);
						VerVisitaPanel.this.add(jrv, BorderLayout.CENTER);
						VerVisitaPanel.this.validate();
						VerVisitaPanel.this.repaint();
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

		this.setBorder(new TitledBorder(null, "Ver visita",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		this.setLayout(new BorderLayout());
		final FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		//
		
	}
	public void setDatos(String dniCl, int refInm, Calendar fecha, String repr){
		this.dniCliente = dniCl;
		this.refInmueble = refInm;
		this.fechaVisita = fecha;
		this.representante = repr;
	}

}