package buenetxea.gui.panelak;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.swtdesigner.SwingResourceManager;

public class BuenetxeaPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel
	 */
	public BuenetxeaPanel() {
		super();
		setBorder(new TitledBorder(null, "Buenetxea Servicios Inmobiliarios",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JLabel label;
		label = new JLabel();
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(SwingResourceManager.getIcon(BuenetxeaPanel.class,
				"/buenetxea/resources/buenetxea.gif"));

		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 480,
								Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				groupLayout.createSequentialGroup().addComponent(label,
						GroupLayout.PREFERRED_SIZE, 364, Short.MAX_VALUE)
						.addContainerGap()));
		setLayout(groupLayout);
		//
	}

}
