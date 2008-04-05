package buenetxea;

import javax.swing.UIManager;

import buenetxea.gui.LoginFrame;

public class Launcher {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginFrame login = new LoginFrame();
                login.setLocationRelativeTo(null);
                login.setVisible(true);
            }
        });
	}
}
