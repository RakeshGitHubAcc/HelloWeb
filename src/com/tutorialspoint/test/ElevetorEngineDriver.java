package com.tutorialspoint.test;

public class ElevetorEngineDriver {
	 public static void main(String[] args) {
	        ElevatorEngine engine = new ElevatorEngine();
	        engine.startEngine();
	        
	        engine.pressButton(5);
	        sleep();
	        sleep();
	        sleep();
	        engine.pressButton(1);
	        sleep();
	        sleep();
	        sleep();
	        engine.pressButton(6);
	        sleep();
	        sleep();
	        sleep();
	        engine.pressButton(1);
	        engine.pressButton(4);
	        engine.pressButton(2);
	        sleep();
	        sleep();
	        sleep();
	        sleep();
	        engine.pressButton(9);
	        sleep();
	        sleep();
	        engine.pressButton(1);
	        sleep();
	        sleep();
	        sleep();
	        engine.stopEngine();
	        try {
	            engine.join();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	     
	    public static void sleep(){
	        try {
	            Thread.sleep(1500);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
}
