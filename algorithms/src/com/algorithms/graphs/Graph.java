package com.algorithms.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
	
	protected List<Edge>edges = new ArrayList<Edge>();
	Map<Node,List<Edge>> map = new HashMap<>();
	
	public List<Edge> getAllEdges()
	{
		return edges;
	}
	
	public boolean addEdge(String node1,String node2,int weight)
	{
		Node nodeOne= new Node(node1);
		Node nodeTwo= new Node(node2);
		Edge edge = new Edge(nodeOne, nodeTwo, weight);
		System.out.printf(" %s -> %s , %d",node1,node2,edge.hashCode());
		if(edges.contains(edge))
			{
			System.out.println("false not added with"+node1 +" to "+node2+" and weight "+weight);
			return false;
			}		
			edges.add(edge);
			addToMap(nodeOne,edge);
			addToMap(nodeTwo, edge);
			
			System.out.printf("true added %s -> %s with weight %d \n",node1,node2,weight);
			return true;
	}
	
	 private void addToMap (Node node, Edge edge) {
	        if (map.containsKey(node)) {
	            List<Edge> l = map.get(node);
	            l.add(edge);
	        } else  {
	            List<Edge> l = new ArrayList<Edge>();
	            l.add(edge);
	            map.put(node, (ArrayList<Edge>) l);
	        }  
	    }
	 
	 public List<Edge> getAdj(Node node) {
	        return map.get(node);
	    }

	    public Map<Node, List<Edge>> getGraph() {
	        return map;
	    }
	    
	    public int getNumberOfNodes()
	    {
	    	return map.size();
	    }
}
