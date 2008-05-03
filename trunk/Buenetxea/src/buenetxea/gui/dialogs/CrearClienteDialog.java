package buenetxea.gui.dialogs;

import javax.swing.GroupLayout;
import javax.swing.JDialog;

import buenetxea.gui.panelak.CrearClientePanel;

public class CrearClienteDialog extends JDialog {

	// /**
	// * Launch the application
	// * @param args
	// */
	// public static void main(String args[]) {
	// try {
	// CrearClienteDialog dialog = new CrearClienteDialog();
	// dialog.addWindowListener(new WindowAdapter() {
	// public void windowClosing(WindowEvent e) {
	// System.exit(0);
	// }
	// });
	// dialog.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog
	 */
	public CrearClienteDialog() {
		super();
		setTitle("Crear un cliente nuevo");
		setModal(true);

		CrearClientePanel crearClientePanel;
		crearClientePanel = new CrearClientePanel();
		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(crearClientePanel,
				GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(crearClientePanel,
				GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE));
		getContentPane().setLayout(groupLayout);
		pack();
		//
	}

}
