package buenetxea.gui.dialogs;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JDialog;

import buenetxea.gui.Nagusia;
import buenetxea.gui.panelak.VerClientePanel;

import com.swtdesigner.SwingResourceManager;

public class MostrarClienteSeleccionadoDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog
	 */
	public MostrarClienteSeleccionadoDialog(String dni) {
		super(Nagusia.getInstance(), true);

		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		setIconImage(SwingResourceManager.getImage(BuscarClienteDialog.class,
				"/buenetxea/resources/logo_buenetxea.png"));
		setTitle("Ver Cliente");

		VerClientePanel verClientePanel;
		verClientePanel = new VerClientePanel();
		verClientePanel.setCliente(dni);
		final GroupLayout groupLayout = new GroupLayout(
				(JComponent) getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(verClientePanel,
								GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(verClientePanel,
								GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
						.addContainerGap()));
		getContentPane().setLayout(groupLayout);
		pack();

		//
	}

}
