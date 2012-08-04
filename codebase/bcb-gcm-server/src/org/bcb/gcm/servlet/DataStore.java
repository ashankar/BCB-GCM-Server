/**
 * 
 */
package org.bcb.gcm.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Anand Shankar
 * 
 */
public final class DataStore {

	private static final List<String> dids = new ArrayList<String>();
	private static final Logger logger = Logger.getLogger(DataStore.class
			.getName());

	private DataStore() {
		throw new UnsupportedOperationException();
	}

	public static void register(String did) {
		logger.info("Registering " + did);
		dids.add(did);
	}

	public static void unregister(String did) {
		logger.info("Unregistering " + did);
		dids.remove(did);
	}

	public static List<String> getDevices() {
		return dids;
	}

}
