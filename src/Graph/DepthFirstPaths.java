package Graph;

import java.util.Stack;

public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	public DepthFirstPaths(Graph G,int s) {
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		dfs(G,s);
	}
	private void dfs(Graph G,int v)
	{
		marked[v]=true;
		for(int s:G.adj(v))
			if(!marked[s])
			{
				edgeTo[s]=v;
				dfs(G,s);
			}
	}
	public boolean hasPathTo(int w)
	{
		return marked[w];
	}
	public Iterable<Integer> PathTo(int w)
	{
		if(!hasPathTo(w)) return null;
		Stack<Integer> stack=new Stack<Integer>();
		for(int i=w;i!=s;i=edgeTo[i])
			stack.push(i);
		stack.push(s);
		return stack;
	}
}
