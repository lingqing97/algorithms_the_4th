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
	//��a[lo...mid]  ��a[mid+1...hi]�鲢
	    int i = lo;   // ��һ��������������� 
	    int j = mid +1;  //�ڶ����������������
	    
	    for(int k = lo; k <= hi; k++){//��a[lo...hi]���Ƶ�aux[lo...hi]�У������ڲ���a[]�����ݲ��ᱻ���Ƕ���
	        aux[k] = a[k];            //aux[]   �������н�����һ���������飬���Ĵ�С��a[]�Ĵ�Сһ����
	    }
	    
	    for(int k = lo; k <=hi; k++){  //�鲢��a[lo...hi]��
	        if(i > mid){            //�����þ���Ҳ���ǵ���һ������������������ݶ����뵽�鲢���������ˣ�������һ�ν����i++��
	                                //���Ի���뵽��������У��Ǿ�ֱ�Ӱ��ұߵ����鲢�������ӾͿ�����
	            a[k] = aux[j++];
	        }else if(j > hi){       //ͬ�ϣ����Ұ�����ݣ��ڶ����������򣩶����뵽�鲢���������ˣ��Ǿ�ֱ�Ӱ�ʣ�µ�������ݣ���һ���������飩����鲢����
	            a[k] = aux[i++];
	        }else if(less(aux[j], aux[i])){//��仰���ǹ鲢�ڱȽϴ�С���Ǿ䣬˭С˭����������
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
