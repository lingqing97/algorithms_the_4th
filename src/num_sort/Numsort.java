package num_sort;
import edu.princeton.cs.algs4.*;
public class Numsort {
	public static void sort(int[] a) {
		int temp=0;
		if(a[0]>a[1]){
			temp=a[0];
			a[0]=a[1];
			a[1]=temp;
		}
		if(a[0]>a[2])
		{
			temp=a[0];
			a[0]=a[2];
			a[2]=temp;
		}
		if(a[1]>a[2])
		{
			temp=a[1];
			a[1]=a[2];
			a[2]=temp;
		}
	}
	public static void main(String[] args) {
		int[] a={1,3,2};
		sort(a);
		for(int i=0;i<3;i++)
			StdOut.println(a[i]);
	}
}
