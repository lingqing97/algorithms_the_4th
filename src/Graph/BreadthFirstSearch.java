package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class BreadthFirstSearch {
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	public BreadthFirstSearch(Graph G,int s) {
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		bfs(G,s);
	}
	private void bfs(Graph G,int v)
	{
		edu.princeton.cs.algs4.Queue<Integer> queue=new edu.princeton.cs.algs4.Queue<Integer>();
		queue.enqueue(v);
		marked[v]=true;
		while(!queue.isEmpty())
		{
			int temp=queue.dequeue();
			for(int w:G.adj(temp))
				if(!marked[w])
				{
					edgeTo[w]=temp;
					marked[w]=true;
					queue.enqueue(w);
				}
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
		for(int i=w;edgeTo[i]!=s;i=edgeTo[i])
			stack.push(i);
		stack.push(s);
		return stack;
	}
}
