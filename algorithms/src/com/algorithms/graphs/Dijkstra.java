package com.algorithms.graphs;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Dijkstra {

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
		graph.addEdge("C", "E", 6);
		graph.addEdge("C", "D", 7);
		graph.addEdge("D", "E", 2);
		graph.addEdge("D", "F", 5);
		graph.addEdge("E", "F", 4);

		System.out.println("Number of Nodes :"+graph.getNumberOfNodes());

		Map<Node,Integer> sortestpaths =	new Dijkstra(graph).findShortest(new Node("A"));
		for(Node node: sortestpaths.keySet())
		{
			System.out.printf("Sortest Distance from A  -> %s is : %d \n",node.getName(),sortestpaths.get(node));
		}

	}
	private final Graph graph;

	public Dijkstra(Graph graph) {
		if (graph == null) {
			throw new NullPointerException("The input graph cannot be null.");
		}
		this.graph = graph;
	}


	public Map<Node,Integer> findShortest(Node source) {
		final Queue<Node> queue = new ConcurrentLinkedQueue<>();
		queue.add(source);
		Map<Node,Integer> map = new HashMap<>();
		map.put(source, 0);

		final Set<Node> doneSet = new HashSet<Node>();
		
		while (!queue.isEmpty()) {
			Node src = queue.poll();
			doneSet.add(src);

			for (Edge edge : graph.getAdj(src)) {
				Node currentNode = edge.getAdjacentNode(src);
				if (!doneSet.contains(currentNode)) {
					int newDistance = map.get(src) + edge.getWeight();
					if(!map.containsKey(currentNode))
					{
						map.put(currentNode, newDistance);
						queue.add(currentNode);
					}
					else
					{
						if(newDistance <= map.get(currentNode))
						{
							map.put(currentNode, newDistance);
						}
					}

				}
			}
		}

		return map;
	}

}
