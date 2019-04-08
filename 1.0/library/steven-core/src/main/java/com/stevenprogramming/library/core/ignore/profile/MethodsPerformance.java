package com.stevenprogramming.library.core.ignore.profile;

public class MethodsPerformance {

	public void start(String name) {
		Profiler.getInstance().start(name);
	}

	public void stop(String name) {
		Profiler.getInstance().stop(name);
	}

	public void createAdditionInmutable(int amount) {
		String value = "";
		for (int cont = 0; cont < amount; cont++) {
			value += String.valueOf(cont);
		}
	}

	public void createConcatInmutable(int amount) {
		String value = "";
		for (int cont = 0; cont < amount; cont++) {
			value.concat(String.valueOf(cont));
		}
	}

	public void createStringBuilderInmutable(int amount) {
		StringBuilder value = new StringBuilder();
		for (int cont = 0; cont < amount; cont++) {
			value.append(String.valueOf(cont));
		}
	}

	public void createStringBufferInmutable(int amount) {
		StringBuilder value = new StringBuilder();
		for (int cont = 0; cont < amount; cont++) {
			value.append(String.valueOf(cont));
		}
	}
}
