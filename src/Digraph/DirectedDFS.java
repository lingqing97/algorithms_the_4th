package Digraph;

public class DirectedDFS {
	private boolean[] marked;
	public DirectedDFS(Digraph G,int s) {
		marked=new boolean[G.V()];
		dfs(G,s);
	}
	public DirectedDFS(Digraph G,Iterable<Integer> sources)
	{
		marked=new boolean[G.V()];
		for(int temp:sources)
			if(!marked[temp])
				dfs(G,temp);
	}
	private void dfs(Digraph G,int v)
	{
		marked[v]=true;
		for(int w:G.adj(v))
			if(!marked[w])
				dfs(G,w);
	}
	public boolean marked(int w)
	{
		return marked[w];
	}
	
}
