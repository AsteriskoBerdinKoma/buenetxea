package buenetxea.gui.dialogs;

import javax.swing.GroupLayout;
import javax.swing.JDialog;
import javax.swing.JTextField;

import buenetxea.gui.Nagusia;
import buenetxea.gui.panelak.dialogPanels.BucarClientePanel;

import com.swtdesigner.SwingResourceManager;

public class BuscarClienteDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField dniTextField;

	/**
	 * Create the dialog
	 */
	public BuscarClienteDialog() {
		super(Nagusia.getInstance(), true);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setIconImage(SwingResourceManager.getImage(BuscarClienteDialog.class,
				"/buenetxea/resources/logo_buenetxea.png"));
		setTitle("Buscar clientes");

		BucarClientePanel bucarClientePanel;
		bucarClientePanel = new BucarClientePanel();
		bucarClientePanel.setCloseAfterSave(this, true);
		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(bucarClientePanel,
				GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(bucarClientePanel,
				GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE));
		getContentPane().setLayout(groupLayout);
		pack();
		//
	}

	public void setResultField(JTextField field) {
		dniTextField = field;
	}

	public void setSavedDNI(String nan) {
		if (dniTextField != null)
			dniTextField.setText(nan);
	}

}
