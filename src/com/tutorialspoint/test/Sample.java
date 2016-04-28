package com.tutorialspoint.test;

public class Sample {
	public static void main(String[] args) {
		Child child=new Child();
		System.out.println(""+child.large(23, 21));
	}
}
class Parent {
	int large(int a, int b) {
		if (a < b) {
			return a;
		} else {
			return b;
		}

	}
}

class Child extends Parent {
	int large(int a, int b) {
		return super.large(a, b) - 15;
	}
}
