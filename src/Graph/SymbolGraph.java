package Graph;

import java.util.HashMap;

import edu.princeton.cs.algs4.In;

public class SymbolGraph {
	private HashMap<String, Integer> st;
	private String[] keys;
	private Graph G;
	public SymbolGraph(String stream,String sp) {
		In in=new In(stream);
		st=new HashMap<String, Integer>();
		while(in.hasNextLine())
		{
			String[] line=in.readLine().split(sp);
			for(int i=0;i<line.length;i++)
				if(!st.containsKey(line[i]))
				st.put(line[i], st.size());
		}
		keys=new String[st.size()];
		for(String temp:st.keySet())
			keys[st.get(temp)]=temp;
		G=new Graph(st.size());
		In newin=new In(stream);
		while(newin.hasNextLine())
		{
			String[] line=newin.readLine().split(sp);
			int v=st.get(line[0]);
			for(int i=1;i<line.length;i++)
				G.addEdge(v, st.get(line[i]));
		}
	}
	public boolean contain(String s)
	{
		return st.containsKey(s);
	}
	public int index(String s)
	{
		return st.get(s);
	}
	public String name(int v)
	{
		return keys[v];
	}
	public Graph G()
	{
		return G;
	}
}
