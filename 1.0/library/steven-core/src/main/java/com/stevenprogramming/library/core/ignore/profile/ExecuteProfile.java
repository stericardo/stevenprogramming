package com.stevenprogramming.library.core.ignore.profile;

/**
 * @author Steven Ricardo Mendez Brenes
 * @since 22 March 2018
 * @version 1.0
 *
 */
public class ExecuteProfile {

	

	public static void main(String[] args) {
		int amount = 100000;
		MethodsPerformance methodsPerformance = new MethodsPerformance();
		ProfileThread profileThread = new ProfileThread(ProfileEnum.ADDICTION, amount, methodsPerformance);
		profileThread.start();
		
		profileThread = new ProfileThread(ProfileEnum.CONCAT, amount, methodsPerformance);
		profileThread.start();
		
		profileThread = new ProfileThread(ProfileEnum.BUILDER, amount, methodsPerformance);
		profileThread.start();
		
		profileThread = new ProfileThread(ProfileEnum.BUFFER, amount, methodsPerformance);
		profileThread.start();

		

	}
	
	/**
	 * With 1 000 000 of String processed we got:
	 * BUILDER                                           :   1 calls, total   218 ms,   avg   218   ms, min   218 ms,   max   218 ms,   delta     0 ms (0%)
	 * ADDICTION                                         :   1 calls, total 1834337 ms, avg 1834337 ms, min 1834337 ms, max 1834337 ms, delta     0 ms (0%)
     * BUFFER                                            :   1 calls, total   174 ms,   avg   174   ms, min   174 ms,   max   174 ms,   delta     0 ms (0%)
     * CONCAT                                            :   1 calls, total   196 ms,   avg   196   ms, min   196 ms,   max   196 ms,   delta     0 ms (0%)
	 * 
	 * As you can see normal + took: 1834337ms = 1834,337 s =  30 minutes
	 * Then 30 minutes vrs Builder(218 ms) vrs Buffer(174 ms) vrs concat (196)
	 * 
	 */
	
	/**
	 * With 100 000 of String processed we got:
	 * 
	 * ADDICTION                                         :   1 calls, total 14275 ms, avg 14275 ms, min 14275 ms, max 14275 ms, delta     0 ms (0%)
	 * CONCAT                                            :   1 calls, total    64 ms, avg    64 ms, min    64 ms, max    64 ms, delta     0 ms (0%)
	 * BUILDER                                           :   1 calls, total    51 ms, avg    51 ms, min    51 ms, max    51 ms, delta     0 ms (0%)
	 * BUFFER                                            :   1 calls, total    61 ms, avg    61 ms, min    61 ms, max    61 ms, delta     0 ms (0%)
	 * 
	 * As you can see normal + took: 14275 ms = 14,275 s 
	 * Then 14,275 seconds vrs Builder(51 ms) vrs Buffer(61 ms) vrs concat (64)
	 * 
	 * Two more intents:
	 * 1) Addiction 14,123 seconds vrs Builder(44 ms) vrs Buffer(28 ms) vrs concat (38)
	 * 2) Addiction 14,214 seconds vrs Builder(43 ms) vrs Buffer(30 ms) vrs concat (58)
	 * 
	 */
	
	/**
	 	long a, b, c, d;
		a = System.currentTimeMillis();
		// some code 1
		b = System.currentTimeMillis();
		// some code 2
		c = System.currentTimeMillis();
		// some code 3
		d = System.currentTimeMillis();
		
		System.out.println("Some code 1 took "+(b-a)+"mil to execute. ("+((b-a)/1000)+" seconds)");
		System.out.println("Some code 2 took "+(c-b)+"mil to execute. ("+((c-b)/1000)+" seconds)");
		System.out.println("Some code 3 took "+(d-c)+"mil to execute. ("+((d-c)/1000)+" seconds)");
	 */

}
