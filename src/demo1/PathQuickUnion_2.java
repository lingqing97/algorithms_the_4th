package demo1;
import edu.princeton.cs.algs4.*;
public class PathQuickUnion_2 {
private int[] id;
private int[] sz;
private int count;
public PathQuickUnion_2(int N) {
	id=new int[N];
	sz=new int[N];
	count=N;
	for(int i=0;i<N;i++)
		id[i]=i;
	for(int i=0;i<N;i++)
		sz[i]=1;
}
public int count(){return count;}
public boolean connect(int p,int q){ return find(p)==find(q);}
public int find(int p)
{
	int x=p;
	while(p!=id[p]) p=id[p];
	while(x!=id[x])
	{
		int temp=x;
		x=id[x];
		id[temp]=p;
	}
	return p;
}
public void union(int p,int q)
{
	int pid=find(p);
	int qid=find(q);
	if(pid==qid) return;
	if(sz[pid]<sz[qid]){ id[pid]=qid;sz[qid]+=sz[pid];}
	else {
		id[qid]=pid;
		sz[pid]+=sz[qid];
	}
	count--;
}
public String toString() {
	String string="";
	for(int i=0;i<id.length;i++)
		string+=id[i]+" ";
	return string;
}
public static void main(String[] args) {
	int N=StdIn.readInt();
	PathQuickUnion_2 uf=new PathQuickUnion_2(N);
	while(!StdIn.isEmpty())
	{
		int p=StdIn.readInt();
		int q=StdIn.readInt();
		if(uf.connect(p, q)) continue;
		uf.union(p, q);
		StdOut.println(p+" "+q);
		StdOut.println(uf);
		StdOut.println(uf.count()+"components");
	}
}
}
