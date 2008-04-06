package buenetxea.gui.panelak;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.sf.jasperreports.engine.JRException;

public class VerInmueblePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel
	 * 
	 * @throws JRException
	 * @throws FileNotFoundException
	 */
	public VerInmueblePanel() {
		super();
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

		JButton button;
		button = new JButton();
		panel_1.add(button);
		button.setText("New JButton");
		//
	}
}
