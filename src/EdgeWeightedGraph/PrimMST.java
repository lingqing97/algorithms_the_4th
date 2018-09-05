package EdgeWeightedGraph;
import java.lang.Double;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.IndexMinPQ;

public class PrimMST {
	private boolean[] marked;
	private double[] distTo;
	private Edge[] edgeTo;
	private IndexMinPQ<Double> pq;
	public PrimMST(EdgeWeightedGraph G) {
		marked=new boolean[G.V()];
		distTo=new double[G.V()];
		edgeTo=new Edge[G.V()];
		for(int i=0;i<G.V();i++)
			distTo[i]=Double.POSITIVE_INFINITY;
		distTo[0]=0.0;
		pq=new IndexMinPQ(G.V());
		pq.insert(0, 0.0);
		while(!pq.isEmpty())
		{
			visit(G,pq.delMin());
		}
	}
	private void visit(EdgeWeightedGraph G,int v)
	{
		marked[v]=true;
		for(Edge e:G.adj(v))
		{
			int w=e.other(v);
			if(marked[w]) continue;
			if(distTo[w]>e.weight())
			{
				edgeTo[w]=e;
				distTo[w]=e.weight();
				if(pq.contains(w)) pq.change(w, e.weight());
				else
					pq.insert(w, e.weight());
			}
		}
	}
	public Iterable<Edge> edges()
	{
		Bag<Edge> mst=new Bag<Edge>();
		for(int i=1;i<edgeTo.length;i++)
			mst.add(edgeTo[i]);
		return mst;
	}
	
}
