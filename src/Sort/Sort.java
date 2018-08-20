package Sort;
import iteratorstack.stack.newstack;
import edu.princeton.cs.algs4.*;
public class Sort {
	public void sort(double[] a)
	{
		/*SelctionSort*/
//		for(int i=0;i<a.length;i++)
//		{
//			int min=i;
//			for(int j=i+1;j<a.length;j++)
//				if(less(a[j], a[min])) min=j;
//			exch(a, min, i);
//			show(a);
//		}
		/*InsertionSort*/
//		for(int i=1;i<a.length;i++)
//		{
//			for(int j=i;j>=1&&less(a[j], a[j-1]);j--)
//				exch(a, j, j-1);
//			show(a);
//		}
		/* ShellSort */
		int h=0;
		while(h<(a.length/3)) h=3*h+1;
		while(h>=1)
		{
			for(int i=h;i<a.length;i++)
			{
				for(int j=i;j>=h&&less(a[j], a[j-h]);j=j-h)
					exch(a, j, j-h);
				show(a);
			}
			h/=3;
		}
	}
	public boolean less(double x,double y)
	{
		return x<y;
	}
	public void exch(double[] a,int x,int y)
	{
		double temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	public void show(double[] a)
	{
		StdDraw.setXscale(0,1);
		StdDraw.setYscale(0,1);
		StdDraw.setPenRadius(0.01);
		for(int i=0;i<a.length;i++)
		{
			double x=1.0*i/a.length;
			double y=a[i]/2.0;
			double rw=0.5/a.length;
			double rh=a[i]/2.0;
			StdDraw.filledRectangle(x, y,rw, rh);
		}
		sleep(655350000);
		StdDraw.clear();
	}
	public void sleep(double n)
	{
		while(n!=0.0)
		{
			n--;
		}
	}
	public static void main(String[] args) {
		double[] a=new double[50];
		for(int i=0;i<50;i++)
			a[i]=StdRandom.random();
		Sort sort=new Sort();
		sort.sort(a);
	}
}
