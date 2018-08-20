package BST;

import javax.swing.JComboBox.KeySelectionManager;

import edu.princeton.cs.algs4.Queue;

public class BST<Key extends Comparable<Key>,Value> {
	private Node rootNode;
	private class Node{
		private Key key;
		private Value val;
		private Node rightNode;
		private Node leftNode;
		private int N;
		public Node(Key key,Value val,int N) {
			this.key=key;
			this.val=val;
			this.N=N;
		}
		public Key getKey() {
			return key;
		}
		public void setKey(Key key) {
			this.key = key;
		}
		public Value getVal() {
			return val;
		}
		public void setVal(Value val) {
			this.val = val;
		}
		public int getN() {
			return N;
		}
		public void setN(int n) {
			N = n;
		}
		
	}
	public int size()
	{
		return size(rootNode);
	}
	private int size(Node x)
	{
		if(x==null) return 0;
		else {
			return x.N;
		}
	}
	public Value get(Key key)
	{
		if(get(rootNode,key)!=null)
			return get(rootNode,key).val;
		else {
			return null;
		}
	}
	private Node get(Node x,Key key)
	{
		if(x==null) return null;
		else {
			int cmp=key.compareTo(x.key);
			if(cmp<0) return get(x.leftNode,key);
			else if(cmp>0) return get(x.rightNode,key);
			else {
				return x;
			}
		}
	}
	public void put(Key key,Value val)
	{
		rootNode=put(rootNode, key,val);
	}
	private Node put(Node x,Key key,Value val)
	{
		if(x==null) 
		{
			return new Node(key, val, 1);
		}
		else {
			int cmp=key.compareTo(x.key);
			if(cmp<0) x.leftNode=put(x.leftNode, key,val);
			else if(cmp>0) x.rightNode=put(x.rightNode, key,val);
			else {
				x.val=val;
			}
			x.N=size(x.leftNode)+size(x.leftNode)+1;
			return x;
		}
	}
	public Key min()
	{
		return min(rootNode).key;
	}
	private Node min(Node x)
	{
		if(x.leftNode==null) return x;
		else {
			return min(x.leftNode);
		}
	}
	public Key max()
	{
		return max(rootNode).key;
	}
	private Node max(Node x)
	{
		if(x.rightNode==null) return x;
		else {
			return max(x.rightNode);
		}
	}
	public Node floor(Key key)
	{
		return floor(rootNode,key);
	}
	private Node floor(Node x,Key key) {
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return floor(x.leftNode,key);
		else if(cmp==0) return x;
		else {
			Node t= floor(x.rightNode,key);
			if(t==null) return x;
			else {
				return t;
			}
		}
	}
	public Node ceiling(Key key)
	{
		return ceiling(rootNode,key);
	}
	private Node ceiling(Node x,Key key)
	{
		if(x==null) return x;
		int cmp=key.compareTo(x.key);
		if(cmp==0) return x;
		else if(cmp>0) return ceiling(x.rightNode,key);
		else {
			Node t=ceiling(x.leftNode.key);
			if(t!=null) return t;
			else {
				return x;
			}
		}	
	}
	public Key select(int k)
	{
		return select(rootNode,k).key;
	}
	private Node select(Node x,int k)
	{
		if(x==null) return null;
		int t=size(x.leftNode);
		if(k<t) return select(x.leftNode, k);
		else if(k==t) return x;
		else {
			return select(x.rightNode, k-t-1);
		}
	}
	public int rank(Key key)
	{
		return rank(rootNode,key);
	}
	private int rank(Node x,Key key)
	{
		if(x==null) return 0;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return rank(x.leftNode,key);
		else if(cmp==0) return size(x.leftNode);
		else {
			return 1+size(x.leftNode)+rank(x.rightNode,key);
		}
	}
	public void deletemin() {
		rootNode=deletemin(rootNode);
	}
	private Node deletemin(Node x)
	{
		if(x.leftNode==null) return x.rightNode;
		x.leftNode=deletemin(x.leftNode);
		x.N=size(x.leftNode)+size(x.rightNode)+1;
		return x;
	}
	public void deletemax()
	{
		rootNode=deletemax(rootNode);
	}
	private Node deletemax(Node x)
	{
		if(x.rightNode==null) return x.leftNode;
		x.rightNode=deletemax(x.rightNode);
		x.N=size(x.leftNode)+size(x.rightNode)+1;
		return x;
	}
	public void delete(Key key)
	{
		rootNode=delete(rootNode,key);
	}
	private Node delete(Node x,Key key)
	{
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp>0) x.rightNode=delete(x.rightNode, key);
		else if(cmp<0) x.leftNode=delete(x.leftNode, key);
		else {
			if(x.leftNode==null) return x.rightNode;
			if(x.rightNode==null) return x.leftNode;
			Node t=x;
			x=min(t.rightNode);
			x.rightNode=deletemin(t.rightNode);
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
		Queue<Key> queue = new Queue<Key>();
		keys(rootNode,queue,low,high);
		return queue;
	}
	private void keys(Node x,Queue<Key> queue,Key low,Key high)
	{
		if(x==null) return;
		int cmplow=low.compareTo(x.key);
		int cmphigh=high.compareTo(x.key);
		if(cmplow<0) keys(x.leftNode, queue,low,high);
		if(cmplow<=0 && cmphigh>=0) queue.enqueue(x.key);
		if(cmphigh>0) keys(x.rightNode, queue, low, high);
	}
	@Override
	public String toString() {
		return "BST [rootNode.key=" + rootNode.getKey() + "]\n"+"BST [rootNode.value=" + rootNode.getVal() + "]\n"+"BST [rootNode.N=" + rootNode.getN() + "]\n";
	}
	
}
