package ube.core.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.felix.framework.Felix;
import org.apache.felix.framework.util.FelixConstants;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

public class FelixLauncher {
	private FelixActivator m_activator = null;
	private Felix m_felix = null;

	public FelixLauncher() {
		// Create a configuration property map.
		Map configMap = new HashMap();
		// Create host activator;
		m_activator = new FelixActivator();
		List list = new ArrayList();
		list.add(m_activator);
		configMap.put(FelixConstants.SYSTEMBUNDLE_ACTIVATORS_PROP, list);

		try {
			// Now create an instance of the framework with
			// our configuration properties.
			m_felix = new Felix(configMap);
			// Now start Felix instance.
			m_felix.start();
		} catch (Exception ex) {
			System.err.println("Could not create framework: " + ex);
			ex.printStackTrace();
		}
	}

	public Bundle[] getInstalledBundles() {
		// Use the system bundle activator to gain external
		// access to the set of installed bundles.
		return m_activator.getBundles();
	}

	public void shutdownApplication() throws BundleException,
			InterruptedException {
		// Shut down the felix framework when stopping the
		// host application.
		m_felix.stop();
		m_felix.waitForStop(0);
	}
}