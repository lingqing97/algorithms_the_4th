package demo1;
import java.util.Arrays;

import iteratorstack.stack.newstack;
import edu.princeton.cs.algs4.*;
public class quick_find {
	private int[] id;
	private int count;
	public quick_find(int N) {
		id=new int[N];
		count=N;
		for(int i=0;i<N;i++)
			id[i]=i;
	}
	public int count()
	{
		return count;
	}
	public int find(int p)
	{
		return id[p];
	}
	public boolean connect(int p,int q)
	{
		return find(p)==find(q);
	}
	public void union(int p,int q)
	{
		int pid=find(p);
		int qid=find(q);
		if(pid==qid) return;
		for(int i=0;i<id.length;i++)
			if(id[i]==qid)
				id[i]=pid;
		count--;
	}
	@Override
	public String toString() {
		String string="";
		for(int i=0;i<id.length;i++)
			string+=id[i]+" ";
		return string;
	}
	public static void main(String[] args) {
		int N=StdIn.readInt();
		quick_find uf=new quick_find(N);
		while(!StdIn.isEmpty())
		{
			int p=StdIn.readInt();
			int q=StdIn.readInt();
			if(uf.connect(p, q))continue;
			uf.union(p, q);
			StdOut.println(p+" "+q);
			StdOut.println(uf);
			StdOut.println(uf.count()+"components");
		}
	}
}
