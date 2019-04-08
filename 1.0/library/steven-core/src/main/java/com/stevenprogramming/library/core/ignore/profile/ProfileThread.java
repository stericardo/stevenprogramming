package com.stevenprogramming.library.core.ignore.profile;

public class ProfileThread extends Thread {

	private ProfileEnum enumProfile;
	private int amount;
	private MethodsPerformance methodsPerformance;

	private ProfileThread() {
	}

	public ProfileThread(ProfileEnum enumProfile, int amount, MethodsPerformance methodsPerformance) {
		this.enumProfile = enumProfile;
		this.amount = amount;
		this.methodsPerformance = methodsPerformance;
	}

	@Override
	public void run() {
		methodsPerformance.start(enumProfile.name());
		switch (enumProfile) {
		case ADDICTION:
			this.methodsPerformance.createAdditionInmutable(this.amount);
			break;
		case CONCAT:
			this.methodsPerformance.createConcatInmutable(amount);
			break;
		case BUILDER:
			this.methodsPerformance.createStringBuilderInmutable(amount);
			break;
		case BUFFER:
			this.methodsPerformance.createStringBufferInmutable(amount);
			break;
		default:
			break;
		}
		methodsPerformance.stop(enumProfile.name());
		System.out.println("Finished >>> " + enumProfile.name() + "\n" + Profiler.getInstance().toString());
	}

}
