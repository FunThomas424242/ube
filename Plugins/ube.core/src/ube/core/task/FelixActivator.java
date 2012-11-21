package ube.core.task;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class FelixActivator implements BundleActivator {
	private BundleContext m_context = null;

	@Override
	public void start(BundleContext context) {
		m_context = context;
	}

	@Override
	public void stop(BundleContext context) {
		m_context = null;
	}

	public Bundle[] getBundles() {
		if (m_context != null) {
			return m_context.getBundles();
		}
		return null;
	}
}