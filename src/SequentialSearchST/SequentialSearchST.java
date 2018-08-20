package SequentialSearchST;

import iteratorstack.stack.newstack;
import edu.princeton.cs.algs4.*;

import java.util.Queue;

import javax.management.openmbean.KeyAlreadyExistsException;

public class SequentialSearchST<Key,Value> {
	private Node firstNode;
	private int N=0;
	private class Node
	{
		private Key key;
		private Value val;
		private Node nextNode;
		public Node(Key key,Value val,Node nextNode) {
			this.key=key;
			this.val=val;
			this.nextNode=nextNode;
		}
	}
	public Value get(Key key)
	{
		for(Node temp=firstNode;temp!=null;temp=temp.nextNode)
			if(temp.key.equals(key))
			{
				return temp.val;
			}
		return null;
	}
	public void put(Key key,Value val)
	{
		for(Node temp=firstNode;temp!=null;temp=temp.nextNode)
			if(temp.key.equals(key))
			{
				temp.val=val;
				return;
			}
		N++;
		firstNode=new Node(key, val, firstNode);
	}
	public int size()
	{
		return N;
	}
	public void delete(Key key)
	{
		firstNode=delete(firstNode,key);
	}
	private Node delete(Node x,Key key)
	{
		if(x==null)
		{
			return null;
		}
		if(x.key.equals(key))
		{
			N--;
			return x.nextNode;
		}
		x.nextNode=delete(x.nextNode, key);
		return x;
	}
	public Key[] keys()
	{
		Key[] keys=(Key[]) new Object[size()+1];
		int i=0;
		for(Node temp=firstNode;temp!=null;temp=temp.nextNode)
			keys[i++]=temp.key;
		return keys;
	}
}
