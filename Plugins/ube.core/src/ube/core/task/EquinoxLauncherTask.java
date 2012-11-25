package ube.core.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.Task;
import org.apache.tools.ant.taskdefs.condition.Condition;
import org.eclipse.osgi.launch.Equinox;
import org.osgi.framework.BundleException;

public class EquinoxLauncherTask extends Task {

	private final List<Condition> conditions = new ArrayList<Condition>();

	public void add(Condition c) {
		conditions.add(c);
	}

	private static Equinox osgiEngine = null;

	private Boolean shutdown = null;

	public void setShutdown(String makeShutdown) throws BundleException,
			InterruptedException {
		if ("true".equals(makeShutdown)) {
			this.shutdown = Boolean.TRUE;
		}

		if ("false".equals(makeShutdown)) {
			this.shutdown = Boolean.FALSE;
		}
		log("Attribute shutdown set to " + this.shutdown);

	}

	@Override
	public void execute() {

		if (!checkPreConditions()) {
			log("Conditions of Task does not satisfied.");
			return;
		}

		// Control Start/Shutdown of Felix
		if (Boolean.TRUE.equals(this.shutdown)) {

			// shutdownFelixEngine();
			shutdownOSGIEngine();

		}

		if (Boolean.FALSE.equals(this.shutdown)) {

			// startFelixEngine();
			startOSGIEngine();

		}

	}

	private Boolean checkPreConditions() {
		boolean areTrue = true;
		for (Iterator<Condition> iterator = conditions.iterator(); iterator
				.hasNext();) {
			Condition condition = iterator.next();
			areTrue = areTrue && condition.eval();
			log("Condition is " + condition.eval());
		}
		// never null because autoboxing of primitive date type
		return areTrue;
	}

	private void startOSGIEngine() {

		log("UBE is ready to starting OSGI engine.");
		final Map<String, ?> map = new HashMap<String, Object>();
		osgiEngine = new Equinox(map);
		try {
			osgiEngine.init();
			osgiEngine.start();

		} catch (BundleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log("OSGI engine has been started by UBE.");

	}

	private void shutdownOSGIEngine() {
		log("UBE is trying to stop the OSGI engine.");
		try {
			osgiEngine.stop();
		} catch (BundleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log("OSGI engine has been stopped by UBE.");
	}

	public static void main(String[] args) {
		EquinoxLauncherTask launcher = new EquinoxLauncherTask();
		launcher.execute();
	}

}
