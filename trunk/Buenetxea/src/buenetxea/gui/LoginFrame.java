package buenetxea.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import buenetxea.db.Connector;
import buenetxea.kudeatzaileak.Kudeatzailea;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			LoginFrame frame = new LoginFrame();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private final JPasswordField passwordField;
	private final JTextField textField;

	/**
	 * Create the frame
	 */
	public LoginFrame() {
		super();
		this.setResizable(false);
		this.setTitle("Buenetxea Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel nombreDeUsuarioLabel;
		nombreDeUsuarioLabel = new JLabel();
		nombreDeUsuarioLabel.setText("Nombre de usuario:");

		JLabel label;
		label = new JLabel();
		label.setText("Contrase�a:");

		this.textField = new JTextField();

		this.passwordField = new JPasswordField();

		JButton aceptarButton;
		aceptarButton = new JButton();
		aceptarButton.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent evt) {
				LoginFrame.this.loginEgin(evt);
			}
		});
		aceptarButton.setText("Aceptar");
		final GroupLayout groupLayout = new GroupLayout(this.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(label, GroupLayout.Alignment.TRAILING)
								.addComponent(nombreDeUsuarioLabel, GroupLayout.Alignment.TRAILING))
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)))
						.addComponent(aceptarButton, GroupLayout.Alignment.TRAILING))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(nombreDeUsuarioLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(label)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(aceptarButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		this.getContentPane().setLayout(groupLayout);
		pack();
		//
	}

	private void loginEgin(java.awt.event.ActionEvent evt) {
		try {
			Connector con = new Connector(this.textField.getText(), String
					.valueOf(this.passwordField.getPassword()));
			Nagusia mainForm = new Nagusia(new Kudeatzailea(con));
			mainForm.setLocationRelativeTo(null);
			mainForm.setExtendedState(MAXIMIZED_BOTH);
			this.setVisible(false);
			mainForm.setVisible(true);
		} catch (SQLException ex) {
			ex.printStackTrace();
			if (ex.getErrorCode() == 1045) {
				JOptionPane jop = new JOptionPane(
						"El nombre de usuario o la contrase�a son incorrectos.",
						JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION,
						new javax.swing.ImageIcon(this.getClass().getResource(
								"/ingrGast/resources/loginFailed_48x48.png")));
				jop.createDialog(null, "Conexi�n fallida").setVisible(true);
			} else if (ex.getErrorCode() == 1044) {
				JOptionPane jop = new JOptionPane(
						"Este usuario no tiene permisos para acceder al programa.",
						JOptionPane.ERROR_MESSAGE, JOptionPane.DEFAULT_OPTION,
						new javax.swing.ImageIcon(this.getClass().getResource(
								"/ingrGast/resources/loginFailed_48x48.png")));
				jop.createDialog(null, "Conexi�n fallida").setVisible(true);
			} else if (ex.getErrorCode() == 0) {
				JOptionPane jop = new JOptionPane("MySQL no est� en marcha.",
						JOptionPane.ERROR_MESSAGE);
				jop.createDialog(null, "Conexi�n fallida").setVisible(true);
			}
			this.textField.setText("");
			this.passwordField.setText("");
			this.textField.requestFocus();
		}
	}
}