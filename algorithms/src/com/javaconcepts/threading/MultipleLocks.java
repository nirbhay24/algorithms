package com.javaconcepts.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MultipleLocks {

	Random random = new Random();

	Object lock1 = new Object();
	Object lock2 = new Object();

	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();

	/**
	 * We are not making method synchronized because we have only one object here of our MultipleLocks class and when one thread have
	 * lock of this class then  other thread can't  have lock of the class
	 * but we want stageTwo to be able to run by another thread , as it is modifying another datatype
	 */
	public  void stageOne()
	{
		//so we are giving lock on object1 and object2
		synchronized (lock1) {
			try {
				System.out.println("adding to list 1");
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(random.nextInt());
		}
	}

	public  void stageTwo()
	{
		synchronized (lock2) {
			try {
				System.out.println("adding to list 2");
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(random.nextInt());
		}
	}	
	public void doProcess()
	{
		System.out.println("process start");
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
		System.out.println("process end");

	}

	public static void main(String[] args) {
		System.out.println("started");
		Long start = System.currentTimeMillis();
		final MultipleLocks obj = new MultipleLocks();

		/**
		 * two threading doing same process but running on same object obj1
		 */
		Thread t1 =new Thread(new Runnable() {
			@Override
			public void run() {
				obj.doProcess();
			}
		});

		Thread t2 =new Thread(new Runnable() {
			@Override
			public void run() {
				obj.doProcess();
			}
		});

		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Long end = System.currentTimeMillis();
		System.out.println((end-start) + " milli seconds");
		System.out.println("List1 size : "+obj.list1.size() +"List2 size : "+obj.list2.size());
	}
}
