package com.algorithm.stacks;

import java.util.Iterator;

public class LinkedStackOfStringsGenerics<I> implements Iterable<I>
{ 
	private Node first = null;
	private class Node
	{
		I item;
		Node next;
	}
	public boolean isEmpty()
	{
		return first == null; 
	}
	public void push(I item)
	{
		Node oldfirst = first;
		first = new Node();
		first.item = item;
		first.next = oldfirst;
	}
	public I pop()
	{
		I item = first.item;
		first = first.next;
		return item;
	}
	@Override
	public Iterator<I> iterator() {

		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<I>
	 {
	 private Node current = first;
	 public boolean hasNext() { return current != null; }
	 public void remove() { /* not supported */ }
	 public I next()
	 {
	 I item = current.item;
	 current = current.next;
	 return item;
	 }
	 }
	
	
}