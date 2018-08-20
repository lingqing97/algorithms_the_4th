package EX8;
import java.util.concurrent.Exchanger;

import edu.princeton.cs.algs4.*;
public class Merge_2 {
private static void sort(int[] a)
{
	int[] aux=new int[a.length];
	sort(aux,a,0,a.length-1);
}
private static void sort(int[] aux,int[] a,int low,int high)
{
	if((high-low)<15)
	{
		InsertionSort(a,low,high);
		return;
	}
	int mid=(low+high)/2;
	sort(aux,a,low,mid);
	sort(aux,a,mid+1,high);
	if(a[mid]>a[mid+1])
		merge(aux,a,low,mid,high);
}
private static void merge(int[] aux,int[] a,int low,int mid,int high)
{
	int i=low;
	int j=mid+1;
	for(int k=low;k<=high;k++)
		aux[k]=a[k];
	for(int k=low;k<=high;k++)
	{
		if(i>mid) a[k]=aux[j++];
		else if(j>high) a[k]=aux[i++];
		else if(less(aux[j],aux[i])) a[k]=aux[j++];
		else {
			a[k]=aux[i++];
		}
	}
}
private static boolean less(int x,int y)
{
	return x<y;
}
private static void InsertionSort(int[] a,int low,int high)
{
	for(int i=low;i<=high;i++)
		for(int j=i;j>low&&less(a[j], a[j-1]);j--)
			exch(a,j,j-1);
}
private static void exch(int[] a,int x,int y)
{
	int temp=a[x];
	a[x]=a[y];
	a[y]=temp;
}
private static boolean isSorted(int[] a)
{
	for(int i=1;i<a.length;i++)
		if(less(a[i], a[i-1]))
			return false;
	return true;
}
private static void show(int[] a)
{
	for(int i=0;i<a.length;i++)
		StdOut.println(a[i]);
}
public static void main(String[] args) {
	int[] a=new int[10];
	for(int i=0;i<10;i++)
		a[i]=StdIn.readInt();
	sort(a);
	assert isSorted(a);
	show(a);
}
}
