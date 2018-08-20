package delete_elements;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;
public class Delete_elements {
	public static int count(int[] a) {
		int cnt=0;
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]==a[i+1])
				cnt++;
		}
		return cnt;
	}
	public static int[] remove(int[] a) {
		int cnt=count(a);
		int s=0;
		int[] b=new int[a.length-cnt];
		b[0]=a[0];
		for(int i=0;i<a.length-1;i++)
		{
			if(a[i]==a[i+1])
				s++;
			else {
				b[i-s+1]=a[i+1];
			}
		}
		return b;
	}
	public static void main(String[] args) {
		int[] a={1,1,2,2,2,3,3,3,3};
		int[] b=remove(a);
		for(int i=0;i<b.length;i++)
			StdOut.println(b[i]);
	}
}
