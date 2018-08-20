package QuickSort;
import java.util.concurrent.Exchanger;

import booleanArray.booleanArrays;
import edu.princeton.cs.algs4.*;
public class Quick3waySort {
private static void sort(double[] a)
{
	StdRandom.shuffle(a);
	sort(a,0,a.length-1);
}
private static void sort(double[] a,int low,int high)
{
	if(low>=high) return;
	int lt=low,i=low+1,gt=high;
	double v=a[low];
	while(i<=gt)
	{
		int cmp=compare(a[i],v);
		if(cmp<0) exch(a,lt++,i++);
		else if(cmp>0) exch(a,i,gt--);
		else i++;
		show(a);
	}
	sort(a,low,lt-1);
	sort(a,gt+1,high);
}
private static int compare(double x,double y)
{
	if(x<y) return -1;
	else if(x>y) return 1;
	else return 0;
}
private static void exch(double[] a,int x,int y)
{
	double temp =a[x];
	a[x]=a[y];
	a[y]=temp;
}
private static void show(double[] a)
{
	StdDraw.setXscale(0,a.length);
	StdDraw.setYscale(0,10);
	StdDraw.setPenRadius(0.01);
	for(int i=0;i<a.length;i++)
	{
		double x=i;
		double y=a[i]/2;
		double rw=1.0/a.length;
		double rh=a[i]/2;
		StdDraw.rectangle(x, y, rw, rh);
	}
	sleep(655350000);
	StdDraw.clear();
}
private static void sleep(double n)
{
	while(n!=0)
	{
		n--;
	}
}
public static void main(String[] args) {
	double[] a=new double[10];
	for(int i=0;i<a.length;i++)
		a[i]=StdRandom.uniform()*10;
	sort(a);
}
}
