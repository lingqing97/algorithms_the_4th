package MaxPQ;
import edu.princeton.cs.algs4.*;
public class MaxPq {
private char[] pq;
private int N;
public MaxPq(int max) {
	pq=new char[max+1];
	N=0;
}
public void insert(char tmp)
{
	if((N+1)==pq.length) resize(pq.length*2);
	pq[++N]=tmp;
	swin(N);
}
public char delmax()
{
	char key=pq[1];
	exch(1, N--);
	if(N>0&&N==pq.length/4) resize(pq.length/2);
	pq[N+1]=' ';
	sink(1);
	return key;
}
public boolean isEmpty()
{
	return N==0;
}
public int size()
{
	return N;
}
private void resize(int max)
{
	char[] temp=new char[max];
	for(int i=0;i<=N;i++)
		temp[i]=pq[i];
	pq=temp;
}
private boolean less(char x,char y)
{
	return x<y;
}
private void exch(int x,int y)
{
	char temp=pq[x];
	pq[x]=pq[y];
	pq[y]=temp;
}
private void swin(int k)
{
	while(k>1&&less(pq[k/2],pq[k]))
	{
		exch(k/2, k);
		k/=2;
	}
}
private void sink(int k)
{
	while(2*k<=N)
	{
		int j=2*k;
		if(j<N&&less(pq[j], pq[j+1])) j++;
		if(!less(pq[k], pq[j])) break;
		exch(k, j);
		k=j;
	}
}
public static void main(String[] args) {
	MaxPQ aMaxPQ=new MaxPQ(0);
	while(!StdIn.isEmpty())
	{
		char temp=StdIn.readChar();
		if(temp=='*')
			StdOut.printf("%c ", aMaxPQ.delMax());
		else {
			aMaxPQ.insert(temp);
		}
	}
}
}
