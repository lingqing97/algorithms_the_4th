package EdgeWeightedDigraph;
import java.lang.Double;

import edu.princeton.cs.algs4.Stack;
import Digraph.Topological;
public class AcyclicSP {
	private DirectedEdge edgeTo[];
	private double distTo[];
	Topological top;
	public AcyclicSP(EdgeWeightedDigraph G,int s) {
		edgeTo=new DirectedEdge[G.V()];
		distTo=new double[G.V()];
		for(int i=0;i<G.V();i++)
			distTo[i]=Double.POSITIVE_INFINITY;
		distTo[s]=0.0;
		top=new Topological(G);
		for(int v:top.order())
			realx(G,v);
	}
	private void realx(EdgeWeightedDigraph G,int v)
	{
		for(DirectedEdge e:G.adj(v))
		{
			int w=e.to();
			if(distTo[w]>distTo[v]+e.weight())
			{
				distTo[w]=distTo[v]+e.weight();
				edgeTo[w]=e;
			}
		}
	}
	public double distTo(int v)
	{
		return distTo[v];
	}
	public boolean hasPath(int v)
	{
		return distTo[v]<Double.POSITIVE_INFINITY;
	}
	public Iterable<DirectedEdge> pathTo(int v)
	{
		if(!hasPath(v)) return null;
		Stack<DirectedEdge> path=new Stack<DirectedEdge>();
		for(DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()])
			path.push(e);
		return path;
	}
	public void printTop()
	{
		for(int v:top.order())
			System.out.print(v+" ");
	}
}
