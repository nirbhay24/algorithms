package com.javaconcepts.threading;

import java.util.Vector;

public class ThreadingClient {


	public static void main(String[] args) {
		Vector<Integer> sharedQueue = new Vector<>();
		int size = 4;
		Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
		Thread consThread = new Thread(new Consumer(sharedQueue, size), "Consumer");
		prodThread.start();
		consThread.start();

	}

}
