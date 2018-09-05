package Digraph;

import EdgeWeightedDigraph.EdgeWeightedDigraph;
import EdgeWeightedDigraph.DirectedEdge;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
	private boolean[] marked;
	private int[] edgeTo;
	private DirectedEdge[] edgeWeightedTo;
	private boolean[] onStack;
	private Stack<DirectedEdge> cycleFinder;
	private Stack<Integer> cycle;
	public DirectedCycle(Digraph graph) {
		marked=new boolean[graph.V()];
		onStack=new boolean[graph.V()];
		edgeTo=new int[graph.V()];
		for(int i=0;i<graph.V();i++)
			if(!marked[i])
				dfs(graph,i);
	}
	public DirectedCycle(EdgeWeightedDigraph graph) {
		marked=new boolean[graph.V()];
		onStack=new boolean[graph.V()];
		edgeWeightedTo=new DirectedEdge[graph.V()];
		for(int i=0;i<graph.V();i++)
			if(!marked[i])
				dfs(graph,i);
	}
	private void dfs(EdgeWeightedDigraph G,int v)
	{
		marked[v]=true;
		onStack[v]=true;
		for(DirectedEdge e:G.adj(v))
		{
			int w=e.to();
			if(hasCycle()) return;
			else if(!marked[w])
			{
				edgeWeightedTo[w]=e;
				dfs(G,w);
			}
			else if(onStack[w])
			{
				cycleFinder=new Stack<DirectedEdge>();
				DirectedEdge x=e;
				for(;x!=null;x=edgeWeightedTo[x.from()])
					cycleFinder.push(x);
			}
		}
		onStack[v]=false;
	}
	private void dfs(Digraph G,int v)
	{
		marked[v]=true;
		onStack[v]=true;
		for(int w:G.adj(v))
		{
			if(hasCycle()) return;
			else if(!marked[w])
			{
				edgeTo[w]=v;
				dfs(G,w);
			}
			else if(onStack[w])
			{
				cycle=new Stack<Integer>();
				for(int i=v;i!=w;i=edgeTo[i])
					cycle.push(i);
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v]=false;
	}
	public boolean EdgeWeightedHasCycle()
	{
		return cycleFinder!=null;
	}
	public Iterable<DirectedEdge> EdgeWeightedCycle()
	{
		return cycleFinder;
	}
	public boolean hasCycle()
	{
		return cycle!=null;
	}
	public Iterable<Integer> Cycle()
	{
		return cycle;
	}
}
