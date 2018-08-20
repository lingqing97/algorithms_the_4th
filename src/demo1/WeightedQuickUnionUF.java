package demo1;
import edu.princeton.cs.algs4.*;
public class WeightedQuickUnionUF {
	private int[] id;
	private int[] sz;
	private int count;
	public WeightedQuickUnionUF(int N) {
		int i=0;
		id=new int[N];
		sz=new int[N];
		for(i=0;i<N;i++)
			id[i]=i;
		for(i=0;i<N;i++)
			sz[i]=1;
		count=N;
	}
	public int count()
	{
		return count;
	}
	public boolean connect(int p,int q)
	{
		return find(p)==find(q);
	}
	public int find(int p)
	{
		while(p!=id[p]) p=id[p];
		return p;
	}
	public void union(int p,int q)
	{
		int pid=find(p);
		int qid=find(q);
		if(pid==qid) return;
		if(sz[pid]<sz[qid]){
			id[pid]=qid;
			sz[qid]+=sz[pid];
		}
		else {
			id[qid]=pid;
			sz[pid]+=sz[qid];
		}
		count--;
	}
	public static void main(String[] args) {
		int N=StdIn.readInt();
		WeightedQuickUnionUF uf=new WeightedQuickUnionUF(N);
		while(!StdIn.isEmpty())
		{
			int p=StdIn.readInt();
			int q=StdIn.readInt();
			if(uf.connect(p, q))continue;
			uf.union(p, q);
			StdOut.println(p+" "+q);
		}
		StdOut.println(uf.count()+"components");
	}
}
