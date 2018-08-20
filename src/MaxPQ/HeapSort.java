package MaxPQ;
import java.nio.channels.Pipe.SinkChannel;
import java.util.concurrent.Exchanger;

import iteratorstack.stack.newstack;
import edu.princeton.cs.algs4.*;
public class HeapSort {
public void sort(double[] a)
{
	int N=a.length-1;
	for(int i=N/2;i>=1;i--)
	{
		sink(a,i,N);
	}
	while(N>1)
	{
		exch(a,1,N--);
		sink(a,1,N);
		show(a);
	}
}
private void sink(double[] a,int k,int N)
{
	while(2*k<=N)
	{
		int j=2*k;
		if(j<N&&less(a[j],a[j+1])) j++;
		if(!less(a[k],a[j])) break;
		exch(a,k,j);
		k=j;
	}
}
private boolean less(double x,double y)
{
	return x<y;
}
private void exch(double[] a,int x,int y)
{
	double temp=a[x];
	a[x]=a[y];
	a[y]=temp;
}
private void show(double[] a) {
	StdDraw.setXscale(0,a.length);
	StdDraw.setYscale(0,10);
	StdDraw.setPenRadius(0.01);
	for(int i=1;i<a.length;i++)
	{
		double x=i;
		double y=a[i]/2;
		double rw=1/(2*a.length);
		double rh=a[i]/2;
		StdDraw.rectangle(x, y, rw, rh);
	}
	sleep(655350000);
	StdDraw.clear();
}
private void sleep(double n) {
	while(n!=0)
	{
		n--;
	}
}
public static void main(String[] args) {
	double[] a=new double[20];
	for(int i=0;i<a.length;i++)
		a[i]=StdRandom.uniform()*10;
	HeapSort sort=new HeapSort();
	sort.sort(a);
}
}
