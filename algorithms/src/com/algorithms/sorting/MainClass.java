package com.algorithms.sorting;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {32,2,3005,98,109,31,929,82,4};
		int size=a.length;
		for(int i=0;i<size;i++)
		{
			for(int j=0;j<(size-i-1);j++)
			{
				if(a[j]>a[j+1])
				{
					int temp = a[j+1];
					a[j+1]= a[j];
					a[j]=temp;
				}
				printArray(a);
			}
		}
		System.out.println("\n-------------------------------------");
		printArray(a);
	}

	private static void printArray(int[] a) {
		for(int j:a)
		{
			System.out.print(j+" ");
		}
		System.out.println();
	}

}
