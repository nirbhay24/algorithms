package com.algorithms.courseraAlgoPart1;


public class QuickFindUFTreeBased
{
	private int[] id;
	
	public QuickFindUFTreeBased(int N)
	{
		id = new int[N];
		for (int i = 0; i < N; i++) id[i] = i;
	}
	
	/**
	 * chase parent pointer till you reach root
	 * @param i
	 * @return
	 */
	private int root(int i)
	{
		while (i != id[i]) i = id[i];
		return i;
	}
	
	/**
	 * If two nodes have same roots then they are connected
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean connected(int p, int q)
	{
		return root(p) == root(q);
	}
	
	/**
	 * set root of p to the root of q
	 * @param p
	 * @param q
	 */
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
}