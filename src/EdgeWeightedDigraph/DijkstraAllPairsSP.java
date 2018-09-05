package EdgeWeightedDigraph;

public class DijkstraAllPairsSP {
	private DijkstraSP[] all;

	public DijkstraAllPairsSP(EdgeWeightedDigraph G) {
		all=new DijkstraSP[G.V()];
		for(int i=0;i<G.V();i++)
			all[i]=new DijkstraSP(G,i);
	}
	public Iterable<DirectedEdge> pathTo(int v,int w)
	{
		return all[v].pathTo(w);
	}
	public double distTo(int v,int w)
	{
		return all[v].distTo(w);
	}
}
