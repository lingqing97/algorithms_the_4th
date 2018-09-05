package Digraph;

public class KosarajuSCC {
	private boolean[] marked;
	private int count;
	private int[] id;
	public KosarajuSCC(Digraph G) {
		marked=new boolean[G.V()];
		id=new int[G.V()];
		DepthFirshOrder dfs=new DepthFirshOrder(G.reverse());
		Iterable<Integer> reversepost=dfs.reversepost();
		for(int i:reversepost)
			if(!marked[i])
			{
				dfs(G,i);
				count++;
			}
	}
	private void dfs(Digraph G,int v)
	{
		marked[v]=true;
		id[v]=count;
		for(int w:G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	public  boolean stronglyConnected(int v,int w)
	{
		return id[v]==id[w];
	}
	public int id(int v)
	{
		return id[v];
	}
	public int count()
	{
		return count;
	}
}
