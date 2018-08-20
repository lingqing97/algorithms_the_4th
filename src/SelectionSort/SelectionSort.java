package SelectionSort;
import iteratorstack.stack.newstack;
import booleanArray.booleanArrays;
import edu.princeton.cs.algs4.*;
public class SelectionSort {
public void sort(int[] a)
{
	for(int i=0;i<a.length;i++)
	{
		int min=i;
		for(int j=i+1;j<a.length;j++)
			if(less(a[j], a[min])) min=j;
		exch(a, min, i);
	}
}
public boolean less(int a,int b)
{
	return a<b;
}
public void exch(int[] a,int x,int y)
{
	int temp=a[x];
	a[x]=a[y];
	a[y]=temp;
}
public void show(int[] a)
{
	for(int i=0;i<a.length;i++)
		StdOut.println(a[i]);
}
public boolean isSorted(int[] a)
{
	for(int i=1;i<a.length;i++)
		if(less(a[i], a[i-1]))
			return false;
	return true;
}
public static void main(String[] args) {
	int[] a=new int[10];
	for(int i=0;i<10;i++)
		a[i]=StdIn.readInt();
	SelectionSort sort=new SelectionSort();
	sort.sort(a);
	sort.show(a);
}
}
