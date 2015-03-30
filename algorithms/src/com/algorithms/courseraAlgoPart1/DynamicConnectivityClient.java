package com.algorithms.courseraAlgoPart1;

import com.algorithms.StdIn;
import com.algorithms.StdOut;

public class DynamicConnectivityClient {
	public static void main(String[] args)
	{
		//simpleUF();
//		treeBasedUF();
		treeBasedUFImproved();
	}

	private static void treeBasedUF() {
		int N = StdIn.readInt();
		QuickFindUFTreeBased uf = new QuickFindUFTreeBased(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p, q))
			{
				uf.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
	}

	private static void treeBasedUFImproved() {
		int N = StdIn.readInt();
		QuickFindUFTreeBasedImproved uf = new QuickFindUFTreeBasedImproved(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p, q))
			{
				uf.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
	}

	private static void simpleUF() {
		int N = StdIn.readInt();
		QuickFindUF uf = new QuickFindUF(N);
		while (!StdIn.isEmpty())
		{
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			if (!uf.connected(p, q))
			{
				uf.union(p, q);
				StdOut.println(p + " " + q);
			}
		}
	}

}
