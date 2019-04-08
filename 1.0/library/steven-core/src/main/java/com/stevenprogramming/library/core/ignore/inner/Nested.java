package com.stevenprogramming.library.core.ignore.inner;

/**
 * @Autor Steven Ricardo Mendez Brenes
 * @date 2018-Mar-23 4:33:35 PM
 * @Version 1.0
 * 
 * Nested classes are divided into two categories: 
 * 			static 
 * 			non-static(Inner Classes). 
 * 
 * Nested classes that are declared static are called static nested classes. 
 * Non-static nested classes are called inner classes.
 * 
 * Inner classes has 2 kinds: 
 * 			Local Classes
 * 			Anonymous Classes
 * 
 * Why Use Nested Classes?
 * 1) It is a way of logically grouping classes that are only used in one place
 * 2) It increases encapsulation
 * 3) It can lead to more readable and maintainable code
 */

public class Nested {

	/**
	 * 
	 * Static nested classes do not have access to other members of the enclosing class
	 * And like static class methods, a static nested class cannot refer directly to instance 
	 * variables or methods defined in its enclosing class: it can use them only through an object reference.
	 * 
	 * Static nested classes are accessed using the enclosing class name: 
	 * 		Nested.StaticNestedClass
	 *		Nested.StaticNestedClass nestedObject = new Nested.StaticNestedClass();
	 */
	static class StaticNestedClass {
	}

	/**
	 * 
	 * Non-static nested classes (inner classes) have access to other members of the
	 * enclosing class, even if they are declared private
	 * 
	 * Because an inner class is associated with an instance, it cannot define any static members itself.
	 * An instance of InnerClass can exist only within an instance of OuterClass and has direct access to 
	 * the methods and fields of its enclosing instance.
	 * 
	 * Nested nestedObject = new Nested();
	 * Nested.InnerClass innerObject = nestedObject.new InnerClass();
	 *
	 */
	class InnerClass {

	}
}
