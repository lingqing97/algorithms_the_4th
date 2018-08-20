package EX8;
import edu.princeton.cs.algs4.*;
public class Merge {
private static int[] aux;
private static void sort(int[] a)
{
	aux=new int[a.length];
	sort(a,0,a.length-1);
}
private static void sort(int[] a,int low,int high)
{
	if(low>=high) return;
	int mid=(low+high)/2;
	sort(a,low,mid);
	sort(a,mid+1,high);
	if(a[mid]<=a[mid+1])
	{
	}
	else {
		merge(a,low,mid,high);
	}
}
private static void merge(int[]a,int low,int mid,int high)
{
	int i=low;
	int j=high;
	for(int k=low;k<=mid;k++)
		aux[k]=a[k];
	for(int k=mid+1;k<=high;k++)
		aux[k]=a[high+mid+1-k];
	for(int k=low;k<=high;k++)
	{
		if(less(aux[j], aux[i]))
			a[k]=aux[j--];
		else {
			a[k]=aux[i++];
		}
	}
}
private static boolean less(int x,int y)
{
	return x<y;
}
public static void show(int[] a)
{
	for(int i=0;i<a.length;i++)
		StdOut.println(a[i]);
}
public static void main(String[] args) {
	int[] a=new int[10];
	for(int i=0;i<10;i++)
		a[i]=StdIn.readInt();
	sort(a);
	show(a);
}
}
