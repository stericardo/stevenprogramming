package com.stevenprogramming.library.core.ignore.inner;

/**
 * @Autor Steven Ricardo Mendez Brenes
 * @date 2018-Mar-23 5:02:32 PM
 * @Version 1.0
 */
public class ShadowConcept {

	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("ShadowTest.this.x = " + ShadowConcept.this.x);
		}
	}

	public static void main(String... args) {
		ShadowConcept st = new ShadowConcept();
		ShadowConcept.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}