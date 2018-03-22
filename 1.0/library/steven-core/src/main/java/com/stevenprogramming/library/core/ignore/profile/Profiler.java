package com.stevenprogramming.library.core.ignore.profile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Vincent Mimoun-Prat
 *
 */
public class Profiler {

	public static final int THEORETICAL_MAX_NAME_LENGTH = 50;

	private static Profiler singletonInstance = null;

	private Map<String, Profile> profiles; // Fast access to profiles by name
	private List<Profile> profilesStack; // Profiles as created chronologically

	/**
	 * Get access to the singleton instance (create it if necessary)
	 */

	public static Profiler getInstance() {
		if (singletonInstance == null) {
			synchronized (Profiler.class) {
				if (singletonInstance == null) {
					singletonInstance = new Profiler();
				}
			}
		}
		return singletonInstance;
	}

	/**
	 * Protected constructor for singleton
	 */
	protected Profiler() {
		profiles = new HashMap<String, Profile>();
		profilesStack = new ArrayList<Profile>();
	}

	/**
	 * Start a profile. If the profile does not exist, it will be created. If it
	 * exists, a new round of measure is taken.
	 * 
	 * @param name
	 *            The name of the profile. If possible, less than
	 *            Profiler.THEORETICAL_MAX_NAME_LENGTH characters
	 * 
	 * @see Profiler.THEORETICAL_MAX_NAME_LENGTH
	 */
	public synchronized void start(String name) {
		Profile p = profiles.get(name);
		if (p == null) {
			p = new Profile(name);
			profiles.put(name, p);
			profilesStack.add(p);
		}
		p.start();
	}

	/**
	 * Stop a profile and compute some statistics about it.
	 * 
	 * @param name The name of the profile as declared in the corresponding start method
	 * 
	 */
	public synchronized void stop(String name) {
		Profile p = profiles.get(name);
		if (p == null) {
			throw new RuntimeException(
					"The profile " + name + " has not been created by a call to the start() method!");
		}
		p.stop();
	}

	/**
	 * Clear all the current measures. Not to be called within any start/stop pair.
	 */
	public void reset() {
		profiles.clear();
	}

	/**
	 * Build a string containing all the information about the measures we have
	 * taken so far.
	 */
	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer();
		for (Profile p : profilesStack) {
			sb.append(p.toString());
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Output the measures to an output string
	 */
	public void toCsvFile(OutputStream os) throws IOException {
		Profile.writeCsvHeader(os);
		for (Profile p : profilesStack) {
			p.writeCsvLine(os);
		}
	}

}
