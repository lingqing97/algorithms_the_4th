package QuickSort;
import edu.princeton.cs.algs4.*;
public class QuickSort {
private static void sort(double[] a)
{
	StdRandom.shuffle(a);
	sort(a,0,a.length-1);
}
private static void sort(double[] a,int low,int high)
{
	if(low>=high) return;
	int j=partition(a,low,high);
	sort(a,low,j-1);
	sort(a,j+1,high);
}
private static int partition(double[] a,int low,int high)
{
	int i=low;
	int j=high+1;
	double v=a[low];
	while(true)
	{
		while(less(a[++i],v)) if(i==high) break;
		while(less(v,a[--j])) if(j==low) break;
		if(i>=j) break;
		exch(a,i,j);
	}
	exch(a,low,j);//a[j]处的元素小于等于v;
	return j;
}
private static void exch(double[] a,int x,int y)
{
	double temp=a[x];
	a[x]=a[y];
	a[y]=temp;
}
private static boolean less(double x,double y)
{
	return x<y;
}
private static void show(double[] a)
{
	for(int i=0;i<a.length;i++)
		StdOut.printf("%.2f ", a[i]);
}
public static void main(String[] args) {
	double[] a=new double[20];
	for(int i=0;i<20;i++)
		a[i]=StdRandom.uniform()*10;
	sort(a);
	show(a);
}
}
