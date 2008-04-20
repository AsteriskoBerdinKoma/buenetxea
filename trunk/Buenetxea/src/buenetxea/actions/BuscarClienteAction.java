package buenetxea.actions;

import org.jdesktop.application.Application;
import org.jdesktop.application.Task;

public class BuscarClienteAction extends Task<Object, Object> {

	public BuscarClienteAction(Application application) {
		super(application);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Object doInBackground() throws Exception {
		System.out.println("egiten...");
		Thread.sleep(5000);
		return null;
	}

	@Override
	protected void finished() {
		System.out.println("YA!");
	}

}
