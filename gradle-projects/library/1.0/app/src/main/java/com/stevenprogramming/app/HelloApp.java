package com.stevenprogramming.app;

import com.stevenprogramming.core.HelloCore;

public class HelloApp {

	public static void main(String[] args) {
		HelloCore helloCore = new HelloCore();
		System.out.println(helloCore.getGreeting("Steven From App to Core") + " " + args[0] + " " + args[1]);
	}
}