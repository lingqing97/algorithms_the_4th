package EX8;
import edu.princeton.cs.algs4.*;
public class MergeBU_2 {
private static int[] sort(int[] a)
{
	int[] perm=new int[a.length];
	int[] aux=new int[a.length];
	for(int i=0;i<a.length;i++)
		perm[i]=a[i];
	for(int sz=1;sz<a.length;sz*=2)
		for(int low=0;low<a.length-sz;low+=2*sz)
			perm=merge(aux,perm,low,low+sz-1,Math.min(low+2*sz-1, a.length-1));
	return perm;
}
private static int[] merge(int[] aux,int[] perm,int low,int mid,int high) {
	int i=low;
	int j=mid+1;
	for(int k=low;k<=high;k++)
		aux[k]=perm[k];
	for(int k=low;k<=high;k++)
	{
		if(i>mid) perm[k]=aux[j++];
		else if(j>high) perm[k]=aux[i++];
		else if(less(aux[j],aux[i])) perm[k]=aux[j++];
		else {
			perm[k]=aux[i++];
		}
	}
	return perm;
}
private static boolean less(int x,int y) {
	return x<y;
}
private static void show(int[] a) {
	for(int i=0;i<a.length;i++)
		StdOut.println(a[i]);
}
public static void main(String[] args) {
	int[] a=new int[10];
	for(int i=0;i<10;i++)
		a[i]=StdIn.readInt();
	int[] perm=sort(a);
	show(perm);
}
}
