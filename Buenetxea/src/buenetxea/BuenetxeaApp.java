package buenetxea;

import javax.swing.UIManager;

import org.jdesktop.application.Application;

import buenetxea.gui.LoginFrame;

public class BuenetxeaApp extends Application {

	@Override
	protected void startup() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			LoginFrame login = new LoginFrame();
			login.setLocationRelativeTo(null);
			login.setVisible(true);
			// if (Connector.isConnectedToDatabase()) {
			//				
			// }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static BuenetxeaApp getApplication() {
		return Application.getInstance(BuenetxeaApp.class);
	}

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		launch(BuenetxeaApp.class, args);
	}
}
