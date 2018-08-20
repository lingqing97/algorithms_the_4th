package TransactionSort;
import Sort.Sort;
import edu.princeton.cs.algs4.*;
public class ShellSort {
public void sort(Transaction[] a)
{
	int h=0;
	while(h<(a.length/3)) h=3*h+1;
	while(h>=1)
	{
		for(int i=h;i<a.length;i++)
			for(int j=i;j>=h&&less(a[j].getAmount(),a[j-h].getAmount());j=j-h)
				exch(a,j,j-h);
		h/=3;
	}
}
public boolean less(double x,double y)
{
	return x<y;
}
public void exch(Transaction[] a,int x,int y)
{
	Transaction temp=new Transaction();
	temp=a[x];
	a[x]=a[y];
	a[y]=temp;
}
public void show(Transaction[] a)
{
	for(int i=0;i<a.length;i++)
		StdOut.println(a[i]);
}
public static void main(String[] args) {
	Transaction[] a=new Transaction[]{new Transaction("001",new Date("7/31/2018"),999.5),
			new Transaction("002",new Date("8/1/2018"),994.5),new Transaction("003",new Date("7/31/2018"),1000.5),
	new Transaction("004",new Date("8/2/2018"),555.6),};
	ShellSort sort=new ShellSort();
	sort.sort(a);
	sort.show(a);
}
}
