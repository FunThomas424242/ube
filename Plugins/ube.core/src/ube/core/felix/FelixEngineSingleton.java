package ube.core.felix;

/**
 * Singleton to hold the reference of felix engine.
 * 
 * @author SchubertT006
 * 
 */
public class FelixEngineSingleton {
	protected static final FelixLauncher felixLauncher = new FelixLauncher();

	public static FelixLauncher getFelixLauncher() {
		return felixLauncher;
	}
}
