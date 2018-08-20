package Graph;
import java.util.Arrays;

import edu.princeton.cs.algs4.*;
public class Graph {
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	public Graph(int V) {
		this.V=V;
		adj=(Bag<Integer>[]) new Bag[V];
		for(int i=0;i<V;i++)
			adj[i]=new Bag<Integer>();
	}
	public Graph(In in)
	{
		this(in.readInt());
		E=in.readInt();
		for(int i=0;i<E;i++)
		{
			int v=in.readInt();
			int w=in.readInt();
			addEdge(v, w);
		}
	}
	public int V()
	{
		return V;
	}
	public int E()
	{
		return E;
	}
	public void addEdge(int v,int w)
	{
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	@Override
	public String toString() {
		String s=V+" vertices "+E+" edge \n";
		for(int i=0;i<V;i++)
		{
			s+=i+" : ";
					for(int temp:adj[i])
						s+=temp+" ";
			s+="\n";
		}
		return s;
	}
}
