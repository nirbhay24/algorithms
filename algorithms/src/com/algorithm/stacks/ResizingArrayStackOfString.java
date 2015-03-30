package com.algorithm.stacks;

public class ResizingArrayStackOfString {

	String[] s = null;
	int N=0;

	public ResizingArrayStackOfString()
	{
		s = new String[1]; 
	}

	//double size of array s[]  when array is full
	public void push(String item)
	{
		if (N == s.length) resize(2 * s.length);
		s[N++] = item;
	}
	//halve size of array s[]  when array is one-quarter full
	public String pop()
	 {
	 String item = s[--N];
	 s[N] = null;
	 if (N > 0 && N == s.length/4) resize(s.length/2);
	 return item;
	 }
	private void resize(int capacity)
	{
		String[] copy = new String[capacity];
		for (int i = 0; i < N; i++)
			copy[i] = s[i];
		s = copy;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
