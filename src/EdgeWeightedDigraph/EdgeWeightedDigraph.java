package EdgeWeightedDigraph;

import EdgeWeightedGraph.Edge;
import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedDigraph {
	private int V;
	private int E;
	private Bag<DirectedEdge>[] adj;
	public EdgeWeightedDigraph(int V) {
		this.V=V;
		this.E=0;
		adj=(Bag<DirectedEdge>[]) new Bag[V];
		for(int i=0;i<V;i++)
			adj[i]=new Bag<DirectedEdge>();
	}
	public void addEdge(DirectedEdge e)
	{
		int v=e.from();
		adj[v].add(e);
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
	public Iterable<DirectedEdge> adj(int v)
	{
		return adj[v];
	}
	public Iterable<DirectedEdge> edges()
	{
		Bag<DirectedEdge> edges=new Bag<DirectedEdge>();
		for(int i=0;i<V;i++)
		{
			for(DirectedEdge e:adj[i])
				edges.add(e);
		}
		return edges;
	}
	public String toString() {
		String s=V+" vertices "+E+" edge \n";
		for(int i=0;i<V;i++)
		{
			s+=i+" : ";
					for(DirectedEdge temp:adj[i])
						s+=temp.to()+" ";
			s+="\n";
		}
		return s;
	}
}
