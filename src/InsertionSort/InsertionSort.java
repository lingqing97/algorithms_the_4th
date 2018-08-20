package InsertionSort;
import SelectionSort.SelectionSort;
import edu.princeton.cs.algs4.*;
public class InsertionSort {
public void sort(int[] a)
{
	for(int i=1;i<a.length;i++)
	{
		for(int j=i;j>0&&less(a[j],a[j-1]);j--)
			exch(a, j, j-1);
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
public boolean isSorted(int[] a)
{
	for(int i=0;i<a.length;i++)
		if(less(a[i], a[i-1]))
			return false;
	return true;
}
public void show(int[] a)
{
	for(int i=0;i<a.length;i++)
		StdOut.println(a[i]);
}
public static void main(String[] args) {
	int[] a=new int[10];
	for(int i=0;i<10;i++)
		a[i]=StdIn.readInt();
	InsertionSort sort=new InsertionSort();
	sort.sort(a);
	sort.show(a);
}
}
