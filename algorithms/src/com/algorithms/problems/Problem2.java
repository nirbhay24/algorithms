package com.algorithms.problems;

public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(addIterative(4, 5));
		  System.out.println(Integer.toString(4,8));
	}
	public static int addIterative(int a, int b){  

        while (b != 0){
            System.out.println("------start------------");
            int carry = (a & b) ; //CARRY is AND of two bits
            System.out.println("1:"+Integer.toString(carry,4));
            a = a ^b; //SUM of two bits is A XOR B
            System.out.println("2:"+Integer.toString(a,4));          
            b = carry << 1; //shifts carry to 1 bit to calculate sum
            System.out.println("3:"+Integer.toString(b,4));
            System.out.println("------end------------");
        }
        System.out.println(Integer.toString(a,4));

        
        return a;
 }


}
