package com.tutorialspoint.test;

import java.util.Arrays;
 class A {
	static int  add(int i, int j){
 return i+j;
 }
}
public class MyTest extends A{
	public static void main(String[] args) {
		/*MyTest test=new MyTest();
		String testStrings[] = {"12345-6789","12345","123456","1234abc","1234","1234a","12345-12345","12345-123","12345-678a"};
		for(String testString:testStrings){
		System.out.println("Zip validation failed for :"+testString+" : "+test.validateZip(testString));	
		}
		short s = 9;
		System.out.println(add(s,6));
		
*/ 
		Object[] obj={new Integer(5),new String("fool"),new Double(12.0),new Boolean(true)};
		Arrays.sort(obj);
		System.out.println(obj);
	}
	
	/**
	 * This method returns true if validation fails for ZIP code*/
	public boolean validateZip(String zipCode){
		boolean flag = false;
		String digitRegex = "[0-9]+";
		// split with '-'
		String[] splitStrings = zipCode.split("-");
		// if after split length of array is more than 2 return false
		if (splitStrings.length > 2) {
			flag = true;
		} else {
			int count = 0;
			for (String splitString : splitStrings) {
				if (!(splitString.matches(digitRegex))) {
					flag = true;
				}
				count++;
				if (count == 1) {
					// if check if length of first array is 5
					if (splitString.length() != 5) {
						flag = true;
					}
				} else if (count == 2) {
					// if check if length of second array is 4
					if (splitString.length() != 4) {
						flag = true;
					}
				}
			}
		}
		return flag;
		
	}
	public static void display(Integer a){
	System.out.println("a: "+a);	
	}
}
