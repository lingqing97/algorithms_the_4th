package binarysearch;

import edu.princeton.cs.algs4.StdOut;

public class binarysearch {
public static int rank(int key,int[] a) {
	int low=0;
	int hight=a.length-1;
	while(low<=hight)
	{
		int mid=(low+hight)/2;
		if(key>a[mid]) low=mid+1;
		else if(key<a[mid]) hight=mid-1;
		else {
			while(a[mid]==a[mid-1]&&mid>0)
				mid--;
			return mid;
		}
	}
	return -1;
}
public static int count(int key,int[] a) {
	int i=rank(key,a);
	int cnt=0;
	if(i!=(-1))
	{
		while(i<(a.length-1)&&a[i]==a[i+1])
		{
			cnt++;
			i++;
		}
		return cnt+1;
	}
	else {
		return cnt;
	}
}
public static void main(String[] args) {
	int[] a={1,1,2,2,2,3,3,3,3};
	StdOut.printf("the elements that low of the 3 have %d\n",rank(3, a));
	StdOut.printf("the elements equal to 3 have %d", count(3, a));
}
}
