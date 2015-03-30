package com.javaconcepts.threading;

import java.util.Scanner;

class Process extends Thread
{
	
	// this variable is changed from another thread 
	// here main method is changing this value 
	private volatile boolean  running= true;
	@Override
	public void run() {
		while(running){
		System.out.println("Hello");
		}
	}
	
	public void shutdown()
	{
		running = false;
	}
}
public class VolatileUse {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Process p = new Process();
		p.start();
		
		Scanner scan = new Scanner(System.in);
		scan.nextLine();
		
		p.shutdown();
	}

	
}
