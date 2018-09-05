package Digraph;
import edu.princeton.cs.algs4.*;
public class Digraph {
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	public Digraph(int V) {
		this.V=V;
		adj=(Bag<Integer>[]) new Bag[V];
		for(int i=0;i<V;i++)
			adj[i]=new Bag<Integer>();
	}
	public int V(){
		return V;
	}
	public int E()
	{
		return E;
	}
	public void addEdge(int v,int w)
	{
		adj[v].add(w);;
		E++;
	}
	public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
	public Digraph reverse()
	{
		Digraph temp=new Digraph(V);
		for(int v=0;v<V;v++)
			for(int w:adj(v))
			temp.addEdge(w, v);
		return temp;
	}
	public String toString() {
		String s=V+" vertices "+E+" edge \n";
		for(int i=0;i<V;i++)
		{
			s+=i+" : ";
					for(int temp:adj[i])
						s+=temp+" ";
			s+="\n";
		}
		return s;
	}
}
