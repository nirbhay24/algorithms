package com.algorithms.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Krushkal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "C", 5);
		graph.addEdge("A", "C", 8);
		graph.addEdge("A", "D", 8);
		graph.addEdge("B", "D", 20);
		graph.addEdge("C", "E", 1);
		graph.addEdge("C", "D", 7);
		graph.addEdge("D", "E", 2);
		graph.addEdge("D", "F", 6);
		graph.addEdge("E", "F", 4);

		System.out.println("Number of Nodes :"+graph.getNumberOfNodes());

		List<Edge> mst =	new Krushkal(graph).findMst();
		for(Edge e : mst)
		{
			System.out.println(e);
		}

	}
	private final Graph graph;

	public Krushkal(Graph graph) {
		if (graph == null) {
			throw new NullPointerException("The input graph cannot be null.");
		}
		this.graph = graph;
	}


	public List<Edge> findMst() {
		List<Edge> edges = graph.getAllEdges();
		Collections.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				if(!(o1.getWeight()>o2.getWeight()))
				return -1;
				else return 0;
			}
		});
		List<Edge> tree = new ArrayList<>();
		Map<Node, Set<Node>> rechableNodes = new HashMap<>();
		for(Edge e : edges)
		{
			Node one = e.getOne();
			Node two = e.getTwo();
			addEdgeToTree(tree, rechableNodes, e, one, two);
			addEdgeToTree(tree, rechableNodes, e, two, one);

		}

		return tree;		
	}


	private void addEdgeToTree(List<Edge> tree, Map<Node, Set<Node>> rechableNodes,
			Edge e, Node one, Node two) {
		if(!rechableNodes.containsKey(one))
		{
			Set<Node> set = new HashSet<Node>();
			set.add(two);
			for(Node node : rechableNodes.keySet())
			{
				set.add(node);
				rechableNodes.get(node).add(one);
			}
			rechableNodes.put(one, set);
			if(!tree.contains(e))tree.add(e);
		}
		else
		{
			Set<Node> set = rechableNodes.get(one);
			if(!set.contains(two))
				{
				set.add(two);
				rechableNodes.put(one, set);
				if(!tree.contains(e))tree.add(e);
				}
		}
	}

}
