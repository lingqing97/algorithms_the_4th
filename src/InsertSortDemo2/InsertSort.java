package InsertSortDemo2;
import SelectionSort.SelectionSort;
import edu.princeton.cs.algs4.*;
public class InsertSort {
public void Sort(int[] a)
{
	for(int i=1;i<a.length;i++)
	{
		int j=i-1;
		a[0]=a[i];
		for(;less(a[0], a[j]);j--)
			a[j+1]=a[j];
		a[j+1]=a[0];
	}
}
public boolean less(int x,int y)
{
	return x<y;
}
public void exch(int[] a,int x,int y)
{
	int temp=a[x];
	a[x]=a[y];
	a[y]=temp;
}
public void show(int[] a)
{
	for(int i=1;i<a.length;i++)
		StdOut.println(a[i]);
}
public static void main(String[] args) {
	int[] a=new int[10+1];
	for(int i=1;i<=10;i++)
		a[i]=StdIn.readInt();
	InsertSort sort=new InsertSort();
	sort.Sort(a);
	sort.show(a);
}
}
