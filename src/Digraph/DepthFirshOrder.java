package Digraph;
import EdgeWeightedDigraph.DirectedEdge;
import EdgeWeightedDigraph.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DepthFirshOrder {
	private boolean[] marked;
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversepost;
	public DepthFirshOrder(Digraph G) {
		marked=new boolean[G.V()];
		pre=new Queue<Integer>();
		post=new Queue<Integer>();
		reversepost=new Stack<Integer>();
		for(int i=0;i<G.V();i++)
			if(!marked[i])
				dfs(G,i);
	}
	private void dfs(Digraph G,int v)
	{
		marked[v]=true;
		pre.enqueue(v);
		for(int w:G.adj(v))
			if(!marked[w])
				dfs(G,w);
		post.enqueue(v);
		reversepost.push(v);
	}
	public DepthFirshOrder(EdgeWeightedDigraph G) {
		marked=new boolean[G.V()];
		pre=new Queue<Integer>();
		post=new Queue<Integer>();
		reversepost=new Stack<Integer>();
		for(int i=0;i<G.V();i++)
			if(!marked[i])
				dfs(G,i);
	}
	private void dfs(EdgeWeightedDigraph G,int v)
	{
		marked[v]=true;
		pre.enqueue(v);
		for(DirectedEdge e:G.adj(v))
		{
			int w=e.to();
			if(!marked[w])
				dfs(G,w);
		}
		post.enqueue(v);
		reversepost.push(v);
	}
	public Iterable<Integer> pre()
	{
		return pre;
	}
	public Iterable<Integer> post()
	{
		return post;
	}
	public Iterable<Integer> reversepost()
	{
		return reversepost;
	}
}
