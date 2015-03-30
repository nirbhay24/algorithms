package com.algorithms.courseraAlgoPart1;


public class QuickFindUFTreeBasedImproved
{
	private int[] id;
	private int[] sz;


	public QuickFindUFTreeBasedImproved(int N)
	{
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++)
		{
			id[i] = i;
			sz[i] = 1;
		}
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
	 * set root of p to the root of q depending which tree is Bigger
	 * @param p
	 * @param q
	 */
	public void union(int p, int q)
	{
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j]) 
		{
			id[i] = j; sz[j] += sz[i]; 
		}
		else 
		{ 
			id[j] = i; sz[i] += sz[j];
		}
	}
}