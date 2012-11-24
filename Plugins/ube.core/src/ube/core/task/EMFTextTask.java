/**
 * 
 */
package ube.core.task;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * @author SchubertT006
 * 
 */
public class EMFTextTask extends Task {

	private File ubeFile = null;

	public void setFile(String filePath) {
		final File file = new File(filePath);
		if (file.exists()) {
			ubeFile = file;
		}
	}

	@Override
	public void execute() throws BuildException {
		super.execute();
		log("UBE file is: " + ubeFile.getAbsolutePath());
	}

}
