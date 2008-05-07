package buenetxea.gui.panelak.azpipanelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import buenetxea.gui.panelak.IntroducirInmueblePanel;

public class DatosPropietario extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	IntroducirInmueblePanel nagusia;
	boolean segundoPropietario = false;

	/**
	 * Create the panel
	 */
	public DatosPropietario(IntroducirInmueblePanel gurasoa) {
		super();
		nagusia = gurasoa;
		

		final JLabel kaixoKuxkiLabel = new JLabel();
		kaixoKuxkiLabel.setText("Kaixo kuxki");
		add(kaixoKuxkiLabel);

		final JButton button = new JButton();
		if (nagusia == null)
			button.setEnabled(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent arg0) {
				if(!segundoPropietario){
					nagusia.segundoPropietario();
					segundoPropietario = true;
					button.setText("Eliminar propietario");
				} else{
					
				}
			
			}
		});
		button.setText("Añadir propietario");
		add(button);
		//
	}

}
