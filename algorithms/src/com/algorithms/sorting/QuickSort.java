package com.algorithms.sorting;

import java.util.Arrays;
/**
 * 
 * @author NirbhayMishra24@gmail.com
 * program demonstrating quicksort 
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {21,2,32,534,54,2124,9,23,43,7,2121,86,3,65,342,8,756,32,22,8,34,93};
		printArray(a);
		new QuickSort().sort(a,0,a.length-1);
		
	}

	private void sort(int[] a,int low,int heigh) {

		
		if (a == null || a.length == 0)
			return;
 
		if (low >= heigh)
			return;
		
		//for convenience we are choosing last element as pivot element
		int pivot= a[heigh];
		
		int heighpointer=heigh;
		int lowpointer=low;
		
		
			while(lowpointer<heighpointer)
			{
				if(a[lowpointer]>pivot){
				int temp= a[lowpointer];
				a[lowpointer]=a[heighpointer-1];
				a[heighpointer-1]=pivot;
				a[heighpointer]=temp;
				heighpointer--;
				}
				else
				{
				lowpointer++;
				}
				printArray(a);
			}

			printArray(a);
			//after  iteration we will have lowerpointer == heighpointer
			//and all low to lowerointer less then equat to pivot element and heighpointer to heigh greater then pivot element
			if(low<lowpointer)
			sort(a, low, lowpointer-1);
			if((lowpointer+1)<heigh)
			sort(a, lowpointer+1, heigh);
			
	}

	  public static void printArray(int[] b) {
	        System.out.println(Arrays.toString(b));
	    }
}
