package EdgeWeightedGraph;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Queue;

public class EdgeWeightedGraph {
	private final int V;
	private int E;
	private Bag<Edge>[] adj;

	public EdgeWeightedGraph(int v) {
		this.V=v;
		this.E=0;
		adj=(Bag<Edge>[]) new Bag[v];
		for(int i=0;i<v;i++)
			adj[i]=new Bag<Edge>();
	}
	public void addEdge(Edge e)
	{
		int v=e.either();
		int w=e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public int V()
	{
		return V;
	}
	public int E()
	{
		return E;
	}
	public Iterable<Edge> adj(int v)
	{
		return adj[v];
	}
	public Iterable<Edge> edges()
	{
		Bag<Edge> bag=new Bag<Edge>();
		for(int v=0;v<V;v++)
			for(Edge temp:adj[v])
				if(temp.other(v)>v) bag.add(temp);
		return bag;
	}
	public String toString() {
		String s=V+" vertices "+E+" edge \n";
		for(int i=0;i<V;i++)
		{
			s+=i+" : ";
					for(Edge temp:adj[i])
						if(temp.other(i)>i)
						s+=temp.other(i)+" ";
			s+="\n";
		}
		return s;
	}
}
