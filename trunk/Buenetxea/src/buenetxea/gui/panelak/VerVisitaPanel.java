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
import java.util.Date;
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

	private final Nagusia jabea;

	private String clientedniazkena;
	private int inmueblerefazkena;
	private Date fechaazkena;
	private int horaazkena;
	private int minutoazkena;
	
	/**
	 * Create the panel
	 * @throws IOException 
	 * 
	 * @throws JRException
	 * @throws FileNotFoundException
	 */

	public VerVisitaPanel(Nagusia jabea, String clientedni,int inmuebleref,Date fecha, int hora, int minuto) throws IOException {
		super();

		this.jabea = jabea;

		this.clientedniazkena = clientedni;
		this.inmueblerefazkena = inmuebleref;
		this.fechaazkena = fecha;
		this.horaazkena = hora;
		this.minutoazkena = minuto;
		
		this.setBorder(new TitledBorder(null, "Ver visita",
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
		
		
		try {
			JasperReport jr;
			DatosVisita dv = new DatosVisita();
			HashMap hutsa = new HashMap();
			
				//DATUEK BETE
				InprimagailuKudeatzailea inpr = InprimagailuKudeatzailea.getInstance();
				dv = inpr.InprimatuVisita(clientedniazkena, inmueblerefazkena,fechaazkena,horaazkena,minutoazkena);

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
		JButton button;
		button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0){
				
			}
		});
		panel_1.add(button);
		button.setText("New JButton");
		//
		
	}

}