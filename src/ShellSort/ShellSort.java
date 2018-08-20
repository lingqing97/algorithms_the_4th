package ShellSort;
import InsertionSort.InsertionSort;
import edu.princeton.cs.algs4.*;
public class ShellSort {
	public void sort(int[] a)
	{
		int h=0;
		while(h<(a.length/3)) h=3*h+1;
		while(h>=1)
		{
			for(int i=h;i<a.length;i++)
				for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
					exch(a, j, j-h);
			h/=3;
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
		ShellSort sort=new ShellSort();
		sort.sort(a);
		sort.show(a);
	}
}
