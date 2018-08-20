package RedBlackBinarySearchTree;

public class RedBlackBST<Key extends Comparable<Key>,Value> {
	private Node root;
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private class Node
	{
		private Key key;
		private Value val;
		private Node left,right;
		private int N;
		private boolean color;
		
		public Node(Key key,Value val,int N,boolean color) {
			this.key=key;
			this.val=val;
			this.N=N;
			this.color=color;
		}
	}
	private boolean IsRed(Node h)
	{
		if(h==null) return false;
		return h.color==RED;
	}
	public int size()
	{
		return size(root);
	}
	private int size(Node x)
	{
		if(x==null) return 0;
		return x.N;
	}
	private Node RotateLeft(Node h)
	{
		Node x=h.right;
		h.right=x.left;
		x.left=h;
		x.color=h.color;
		x.N=h.N;
		h.N=size(h.left)+size(h.right)+1;
		return x;
	}
	private Node RotateRight(Node h)
	{
		Node x=h.left;
		h.left=x.right;
		x.right=h;
		x.color=h.color;
		x.N=h.N;
		h.N=size(h.left)+size(h.right)+1;
		return x;
	}
	private void FlipColor(Node h)
	{
		h.color=RED;
		h.left.color=BLACK;
		h.right.color=BLACK;
	}
	public Value get(Key key)
	{
		return get(root,key);
	}
	private Value get(Node x,Key key)
	{
		if(x==null) return null;
		int cmp=key.compareTo(x.key);
		if(cmp<0) return get(x.left,key);
		else if(cmp>0) return get(x.right,key);
		else return x.val;
	}
	public void put(Key key,Value val)
	{
		root=put(root,key,val);
	}
	private Node put(Node x,Key key,Value val)
	{
		if(x==null) return new Node(key,val,1,RED);
		int cmp=key.compareTo(x.key);
		if(cmp<0) x.left=put(x.left,key,val);
		else if(cmp>0) x.right=put(x.right,key,val);
		else x.val=val;
		if(IsRed(x.right)&&!IsRed(x.left)) x=RotateLeft(x);
		if(IsRed(x.left)&&IsRed(x.left.left)) x=RotateRight(x);
		if(IsRed(x.left)&&IsRed(x.right)) FlipColor(x);
		x.N=size(x.left)+size(x.right)+1;
		return x;
	}
}
