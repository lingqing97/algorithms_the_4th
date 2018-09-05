package Digraph;

import EdgeWeightedDigraph.EdgeWeightedDigraph;
public class Topological {
	private Iterable<Integer> order;

	public Topological(Digraph G) {
		DirectedCycle cyclefinder=new DirectedCycle(G);
		if(!cyclefinder.hasCycle())
		{
			DepthFirshOrder dfs=new DepthFirshOrder(G);
			order=dfs.reversepost();
		}
	}
	public Topological(EdgeWeightedDigraph G)
	{
		DirectedCycle cyclefinder=new DirectedCycle(G);
		if(!cyclefinder.EdgeWeightedHasCycle())
		{
			DepthFirshOrder dfs=new DepthFirshOrder(G);
			order=dfs.reversepost();
		}
		else
			order=null;
	}
	public Iterable<Integer> order()
	{
		return order;
	}
	public boolean isDAG()
	{
		return order!=null;
	}
}
