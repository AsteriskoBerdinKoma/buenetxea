package buenetxea.gui.dialogs;

import javax.swing.GroupLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;

import buenetxea.gui.Nagusia;
import buenetxea.gui.panelak.VerClientePanel;

public class MostrarClienteSeleccionadoDialog extends JFrame {

	/**
	 * Launch the application
	 * @param args
	 */
	private static Nagusia jabea;
	/**
	 * Create the frame
	 */
	public MostrarClienteSeleccionadoDialog(String dni) {
		super();
		setName("Cliente Interesado");
		getContentPane().setName("Cliente Seleccionado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Nagusia.getInstance().showVerCliente(dni);
		VerClientePanel panela = new VerClientePanel();
		panela.setCliente(dni);
				
		final GroupLayout groupLayout = new GroupLayout((JComponent) getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panela, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addComponent(panela, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		pack();
		//
	}
}