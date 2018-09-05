package EdgeWeightedGraph;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class LazyPrimMST {
	private MinPQ<Edge> pq;
	private boolean[] marked;
	private Queue<Edge> mst;
	public LazyPrimMST(EdgeWeightedGraph G) {
		pq=new MinPQ<Edge>();
		marked=new boolean[G.V()];
		mst=new Queue<Edge>();
		visit(G,0);
		while(!pq.isEmpty())
		{
			Edge e=pq.delMin();
			int v=e.either();
			int w=e.other(v);
			if(marked[v]&&marked[w]) continue;
			mst.enqueue(e);
			if(marked[v]) visit(G,w);
			if(marked[w]) visit(G,v);
		}
	}
	private void visit(EdgeWeightedGraph G,int v)
	{
		marked[v]=true;
		for(Edge temp:G.adj(v))
			if(!marked[temp.other(v)])
				pq.insert(temp);
	}
	public Iterable<Edge> mst()
	{
		return mst;
	}
}
