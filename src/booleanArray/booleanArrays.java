package booleanArray;

import edu.princeton.cs.algs4.StdOut;

public class booleanArrays {
public static int gcd(int a,int b) {
	if(a<b)
	{
		int temp=a;
		a=b;
		b=temp;
	}
	if(b>0)
	{
		int temp=a%b;
		a=b;
		b=temp;
		return gcd(a, b);
	}
	else {
		return a;
	}
}
public static boolean[][] init(boolean[][] a) {
	int M=a.length;
	int N=a[0].length;
	for(int i=0;i<M;i++)
	{
		for(int j=0;j<N;j++)
		{
			if(gcd(i, j)==1)
				a[i][j]=true;
			else {
				a[i][j]=false;
			}
		}		
	}
	return a;
}
	public static void main(String[] args) {
		boolean[][] a=new boolean[20][20];
		init(a);
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<20;j++)
				StdOut.printf("%b ",a[i][j]);
			StdOut.println("\n");
		}
	}
}
