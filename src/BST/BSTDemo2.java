package BST;

import edu.princeton.cs.algs4.Queue;

public class BSTDemo2<Key extends Comparable<Key>,Value> {
	private Node root;
	private class Node
	{
		private Key key;
		private Value val;
		private Node leftNode=null;
		private Node rightNode=null;
		private int N;		
		public Node(Key key,Value val,int N) {
			this.key=key;
			this.val=val;
			this.N=N;
		}
		public Key getKey() {
			return key;
		}
		public Value getVal() {
			return val;
		}
		public int getN() {
			return N;
		}
		@Override
		public String toString() {
			return "Node [key=" + key + ", val=" + val + ", leftNode="
					+ leftNode + ", rightNode=" + rightNode + ", N=" + N + "]";
		}
		
	}
	public int size()
	{
		return size(root);
	}
	private int size(Node x)
	{
		if(x==null) return 0;
		else
			return x.N;
	}
	public Value get(Key key)
	{
		return get(root,key);
	}
	private Value get(Node x,Key key)
	{
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return get(x.leftNode,key);
		else if(cmp>0) return get(x.rightNode,key);
		else
		{
			return x.val;
		}
	}
	public void put(Key key,Value val)
	{
		root=put(root,key,val);
	}
	private Node put(Node x,Key key,Value val)
	{
		if(x==null)
		{
			return new Node(key,val,1);
		}
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.leftNode=put(x.leftNode,key,val);
		else if(cmp>0) x.rightNode=put(x.rightNode,key,val);
		else
		{
			x.val=val;
		}
		x.N=size(x.leftNode)+size(x.rightNode)+1;
		return x;
	}
	public Key min()
	{
		if(min(root)!=null)
			return min(root).key;
		else return null;
	}
	private Node min(Node x)
	{
		if(x.leftNode==null) return x;
		return min(x.leftNode);
	}
	public Key max()
	{
		return max(root).key;
	}
	private Node max(Node x)
	{
		if(x.rightNode==null) return x;
		else return max(x.rightNode);
	}
	public Node select(int k)
	{
		return select(root,k);
	}
	private Node select(Node x,int k)
	{
		if(x==null) return null;
		int t=size(x.leftNode);
		if(t==k) return x;
		else if(k<t) return select(x.leftNode,k);
		else
		{
			return select(x.rightNode,k-t-1);
		}
	}
	public int rank(Key key)
	{
		return rank(root,key);
	}
	private int rank(Node x,Key key)
	{
		if(x==null) return 0;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return rank(x.leftNode,key);
		else if(cmp>0) return 1+size(x.leftNode)+rank(x.rightNode,key);
		else
		{
			return size(x.leftNode);
		}
	}
	public void deleteMin()
	{
		root=deleteMin(root);
	}
	private Node deleteMin(Node x)
	{
		if(x.leftNode==null) return x.rightNode;
		x.leftNode=deleteMin(x.leftNode);
		x.N=size(x.leftNode)+size(x.rightNode)+1;
		return x;
	}
	public void delete(Key key)
	{
		root=delete(root,key);
	}
	private Node delete(Node x,Key key)
	{
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.leftNode=delete(x.leftNode,key);
		else if(cmp>0) x.rightNode=delete(x.rightNode,key);
		else
		{
			if(x.leftNode==null) return x.rightNode;
			if(x.rightNode==null) return x.leftNode;
			Node t=x;
			x=min(t.rightNode);
			x.rightNode=deleteMin(t.rightNode);
			x.leftNode=t.leftNode;
		}
		x.N=size(x.leftNode)+size(x.rightNode)+1;
		return x;
	}
	public Iterable<Key> keys()
	{
		return keys(min(),max());
	}
	private Iterable<Key> keys(Key low,Key high)
	{
		Queue<Key> queue=new Queue<Key>();
		keys(root,queue,low,high);
		return queue;
	}
	private void keys(Node x,Queue<Key> queue,Key low,Key high)
	{
		if(x==null) return;
		int cmplow=low.compareTo(x.key);
		int cmphigh=high.compareTo(x.key);
		if(cmplow<0) keys(x.leftNode, queue, low, high);
		if(cmplow<=0&&cmphigh>=0) queue.enqueue(x.key);
		if(cmphigh>0) keys(x.rightNode, queue, low, high);
	}
	@Override
	public String toString() {
		return "BSTDemo2 [root.key=" + root.getKey() + "root.value="+root.getVal()+"root.N="+root.getN()+"]\n";
	}
	
}
