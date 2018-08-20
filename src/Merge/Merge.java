package Merge;
import edu.princeton.cs.algs4.*;
public class Merge {
private static int[] aux;
private static void sort(int[] a)
{
	aux=new int[a.length];
	sort(a,0,a.length-1);
}
private static void sort(int[] a,int low,int high)
{
	if(low>=high) return;
	int mid=low+(high-low)/2;
	sort(a,low,mid);
	sort(a,mid+1,high);
	merge(a,low,mid,high);
}
public static void merge(int[] a, int lo, int mid, int hi){
	//将a[lo...mid]  和a[mid+1...hi]归并
	    int i = lo;   // 第一个有序区域的索引 
	    int j = mid +1;  //第二个有序区域的索引
	    
	    for(int k = lo; k <= hi; k++){//将a[lo...hi]复制到aux[lo...hi]中，这样在操作a[]是数据不会被覆盖而丢
	        aux[k] = a[k];            //aux[]   是在类中建立的一个辅助数组，它的大小和a[]的大小一样大
	    }
	    
	    for(int k = lo; k <=hi; k++){  //归并到a[lo...hi]中
	        if(i > mid){            //左半边用尽，也就是当第一个有序数组的所有数据都放入到归并的数组中了，由于上一次结果会i++，
	                                //所以会进入到这个条件中，那就直接把右边的往归并数组里扔就可以了
	            a[k] = aux[j++];
	        }else if(j > hi){       //同上，当右半边数据（第二个有序区域）都放入到归并的数组中了，那就直接吧剩下的左边数据（第一个有序数组）放入归并数组
	            a[k] = aux[i++];
	        }else if(less(aux[j], aux[i])){//这句话才是归并在比较大小的那句，谁小谁放入数组中
	            a[k] = aux[j++];
	        }else{
	            a[k] = aux[i++];
	        }
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
