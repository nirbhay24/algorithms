package com.javaconcepts.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPool {


	public static void main(String[] args) throws InterruptedException {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i=1; i<6;i++)
		{
			Processor processor = new Processor(i);
			executor.submit(processor);
		}
		System.out.println("all submited");
		executor.awaitTermination(6, TimeUnit.SECONDS);
		executor.shutdown();
		System.out.println("Ended waiting and moved");
	}

}

class Processor implements Runnable
{
	int id;
	public Processor(int id) {
		this.id= id;
	}
	@Override
	public void run() {
		System.out.println("Task "+ this.id+" stared");		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Task "+ this.id+" ended");		

	}

}