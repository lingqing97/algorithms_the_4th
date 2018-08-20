package Graph;

public class TwoColor {
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColor=true;
	public TwoColor(Graph G) {
		marked=new boolean[G.V()];
		color=new boolean[G.V()];
		for(int i=0;i<G.V();i++)
		{
			if(!marked[i])
				dfs(G,i);
		}
	}
	private void dfs(Graph G,int v)
	{
		marked[v]=true;
		for(int w:G.adj(v))
		{
			if(!marked[w])
			{
				color[v]=!color[v];
				dfs(G,w);
			}
			else if(color[w]==color[v]) isTwoColor=false;
		}
	}
	public boolean IsTwoColor()
	{
		return isTwoColor;
	}
}
