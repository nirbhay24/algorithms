package com.algorithms.graphs;

public class Edge{
	
	Node one , two;
	int weight;
	
	
	public Edge(Node one, Node two, int weight) {
		super();
		this.one = one;
		this.two = two;
		this.weight = weight;
	}
	
	
	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((one == null) ? 0 : one.hashCode());
		result = prime * result + ((two == null) ? 0 : two.hashCode());
		result = prime * result + weight;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		if(one.equals(other.one) && two.equals(other.two) && weight==other.weight)
			{
			System.out.print("here true");
			return true;
			}
		if(two.equals(other.one) && one.equals(other.two) && weight==other.weight)
			return true;			
		if (weight != other.weight)
			return false;
		return false;
	}
	
	 public Node getAdjacentNode (Node node) {
	        return node.equals(one) ? two : one; 
	    }


	public Node getOne() {
		return one;
	}


	public void setOne(Node one) {
		this.one = one;
	}


	public Node getTwo() {
		return two;
	}


	public void setTwo(Node two) {
		this.two = two;
	}


	@Override
	public String toString() {
		return "Edge [one=" + one + ", two=" + two + ", weight=" + weight + "]";
	}
	 
	
}