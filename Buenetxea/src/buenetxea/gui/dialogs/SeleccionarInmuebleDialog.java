package buenetxea.gui.dialogs;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import buenetxea.gui.panelak.VenderInmueblePanel;
import buenetxea.kudeatzaileak.Kudeatzailea;
import buenetxea.objektuak.Inmueble;

import com.swtdesigner.SwingResourceManager;

public class SeleccionarInmuebleDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JLabel errorLabel;
	private VenderInmueblePanel jabea;

	/**
	 * Create the dialog
	 */
	public SeleccionarInmuebleDialog() {
		super();
		setIconImage(SwingResourceManager.getImage(
				SeleccionarInmuebleDialog.class,
				"/buenetxea/resources/logo_buenetxea.png"));
		setTitle("Seleccionar Inmueble");
		setModal(true);

		JLabel referenciaDelInmuebleLabel;
		referenciaDelInmuebleLabel = new JLabel();
		referenciaDelInmuebleLabel.setText("Referencia del inmueble:");

		textField = new JTextField();

		JButton seleccionarButton;
		seleccionarButton = new JButton();
		seleccionarButton.addActionListener(new ActionListener() {

			public void actionPerformed(final ActionEvent e) {
				try {
					int ref = Integer.parseInt(textField.getText().trim());
					Inmueble inmueble = Kudeatzailea.getInstance().getInmueble(
							ref);
					if (inmueble == null)
						errorLabel
								.setText("El inmueble seleccionado no existe");
					else {
						errorLabel.setText("");
						jabea.setInmueble(inmueble);
						dispose();
					}
				} catch (NumberFormatException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				} catch (ClassNotFoundException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
				errorLabel.setText("La referencia introducida no es correcta");
			}
		});
		seleccionarButton.setText("Seleccionar");

		errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		final GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																GroupLayout.Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				referenciaDelInmuebleLabel)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				textField,
																				GroupLayout.DEFAULT_SIZE,
																				102,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				seleccionarButton))
														.addComponent(
																errorLabel))
										.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap().addGroup(
						groupLayout.createParallelGroup(
								GroupLayout.Alignment.BASELINE).addComponent(
								referenciaDelInmuebleLabel).addComponent(
								seleccionarButton).addComponent(textField,
								GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)).addPreferredGap(
						LayoutStyle.ComponentPlacement.RELATED).addComponent(
						errorLabel).addContainerGap(18, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);
		pack();
		//
	}

	public void setJabea(VenderInmueblePanel owner) {
		this.jabea = owner;
	}

}
