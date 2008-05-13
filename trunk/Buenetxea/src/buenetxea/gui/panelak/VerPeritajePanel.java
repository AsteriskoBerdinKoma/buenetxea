package buenetxea.gui.panelak;

import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import buenetxea.objektuak.Peritaje;

public class VerPeritajePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final URL reportPath = VerInmueblePanel.class
			.getResource("/buenetxea/reports/Peritaje.jasper");

	private JRViewer viewer;

	/**
	 * Create the panel
	 * 
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 * 
	 * @throws JRException
	 * @throws FileNotFoundException
	 */

	public VerPeritajePanel() {
		super();

		try {
			this.setBorder(new TitledBorder(null, "Ver Ficha de Peritaje",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, null, null));
			final FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);

			Collection<Peritaje> lista = new ArrayList<Peritaje>();
			lista.add(new Peritaje());

			JRBeanCollectionDataSource datasource = new JRBeanCollectionDataSource(
					lista);

			JasperReport jr = (JasperReport) JRLoader.loadObject(reportPath);

			JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(),
					datasource);

			viewer = new JRViewer(jp);
			final GroupLayout groupLayout = new GroupLayout((JComponent) this);
			groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(viewer, GroupLayout.DEFAULT_SIZE,
									464, Short.MAX_VALUE).addContainerGap()));
			groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
					GroupLayout.Alignment.LEADING).addGroup(
					groupLayout.createSequentialGroup().addContainerGap()
							.addComponent(viewer, GroupLayout.DEFAULT_SIZE,
									323, Short.MAX_VALUE).addContainerGap()));
			setLayout(groupLayout);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}