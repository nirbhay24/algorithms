package com.algorithm.stacks;

import java.util.Iterator;

import com.algorithms.StdIn;
import com.algorithms.StdOut;

public class StacksMainClass {

	public static void main(String[] args)
	{
//	 LinkedStackOfStrings stack = new LinkedStackOfStrings();
//	 while (!StdIn.isEmpty())
//	 {
//	 String s = StdIn.readString();
//	 if (s.equals("-")) StdOut.print(stack.pop());
//	 else stack.push(s);
//	 }
//	 

//-------------------------Fixed size stack ,array Implementation  -------------------------		

//	 System.out.println("Fixed Capacity Of Stack is Being Initialized enter max size : ");
//	 FixedCapacityStackOfStrings fixedStack = new FixedCapacityStackOfStrings(StdIn.readInt());
//	 while (!StdIn.isEmpty())
//	 {
//	 String s = StdIn.readString();
//	 if (s.equals("-")) StdOut.print(fixedStack.pop());
//	 else fixedStack.push(s);
//	 }
	 
	 
//-----------------------Resizing Array-----------------
	 
//	 System.out.println("Resizing Array Capacity Of Stack is Being Initialized enter max size : ");
//	 ResizingArrayStackOfString resizing = new ResizingArrayStackOfString();
//	 while (!StdIn.isEmpty())
//	 {
//	 String s = StdIn.readString();
//	 if (s.equals("-")) StdOut.print(resizing.pop());
//	 else resizing.push(s);
//	 }


//-------------------------- Generics Based Stack-------------------------		
//		 System.out.println("Generics Based Stack : ");
//		 LinkedStackOfStringsGenerics<Integer> stackGenerics = new LinkedStackOfStringsGenerics<Integer>();
//		 while (!StdIn.isEmpty())
//		 {
//		 int s = StdIn.readInt();
//		 if (s==0) StdOut.print(stackGenerics.pop());
//		 else stackGenerics.push(s);
//		 }

		 
		 System.out.println("Generics Based Stack with Iterator : ");
		 LinkedStackOfStringsGenerics<Integer> stackGenerics = new LinkedStackOfStringsGenerics<Integer>();
	
		 stackGenerics.push(1);
		 stackGenerics.push(2);
		 stackGenerics.push(3);
		 stackGenerics.push(4);
		 stackGenerics.push(5);
		 stackGenerics.push(6);
	
		 
		 Iterator<Integer> stacIterator =	stackGenerics.iterator();
		 while (stacIterator.hasNext()) {
			Integer integer = (Integer) stacIterator.next();
			System.out.println(integer);
		}
		 

		
	}
}
