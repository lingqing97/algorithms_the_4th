package Graph;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	public DepthFirstSearch(Graph  G,int s) {
		marked=new boolean[G.V()];
		dfs(G,s);
	}
	private void dfs(Graph G,int v)
	{
		marked[v]=true;
		count++;
		for(int s:G.adj(v))
			if(!marked[s])
				dfs(G,s);
	}
	public boolean marked(int w)
	{
		return marked[w];
	}
	public int count()
	{
		return count;
	}
}
