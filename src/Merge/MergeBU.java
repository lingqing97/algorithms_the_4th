package Merge;
import edu.princeton.cs.algs4.*;
public class MergeBU {
private static int[] aux;
private static void sort(int[] a)
{
	aux=new int[a.length];
	for(int sz=1;sz<a.length;sz*=2)
		for(int low=0;low<a.length-sz;low+=sz*2)
			merge(a,low,low+sz-1,Math.min(low+2*sz-1, a.length-1));
}
private static void merge(int[] a,int low,int mid,int high)
{
	int i=low;
	int j=mid+1;
	for(int k=low;k<=high;k++)
		aux[k]=a[k];
	for(int k=low;k<=high;k++)
	{
		if(i>mid) { a[k]=aux[j++];}
		else if(j>high) { a[k]=aux[i++]; }
		else if(less(aux[j],aux[i])) { a[k]=aux[j++];}
		else { a[k]=aux[i++]; }
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
