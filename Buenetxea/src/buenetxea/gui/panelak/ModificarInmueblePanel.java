package buenetxea.gui.panelak;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.border.TitledBorder;

import buenetxea.gui.panelak.azpipanelak.DatosInmueblePanel;
import buenetxea.objektuak.Inmueble;

public class ModificarInmueblePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DatosInmueblePanel datosInmueblePanel;

	/**
	 * Create the panel
	 */
	public ModificarInmueblePanel() {
		super();
		setBorder(new TitledBorder(null, "Modificar Inmueble",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION, null, null));

		JButton modificarInmuebleButton;
		modificarInmuebleButton = new JButton();
		modificarInmuebleButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
			}
		});
		modificarInmuebleButton.setText("Guardar cambios");

		JScrollPane scrollPane_1;
		scrollPane_1 = new JScrollPane();

		datosInmueblePanel = new DatosInmueblePanel();
		scrollPane_1.setViewportView(datosInmueblePanel);
		final GroupLayout groupLayout = new GroupLayout((JComponent) this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.TRAILING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap().addGroup(
						groupLayout.createParallelGroup(
								GroupLayout.Alignment.TRAILING).addComponent(
								scrollPane_1, GroupLayout.Alignment.LEADING,
								GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
								.addComponent(modificarInmuebleButton))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.TRAILING)
				.addGroup(
						groupLayout.createSequentialGroup().addComponent(
								scrollPane_1, GroupLayout.DEFAULT_SIZE, 305,
								Short.MAX_VALUE).addPreferredGap(
								LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(modificarInmuebleButton)
								.addContainerGap()));
		setLayout(groupLayout);
		//
	}

	public void setDatuak(Inmueble inmueble) {
		datosInmueblePanel.setDatuak(inmueble);
	}

}
