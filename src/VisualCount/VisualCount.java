package VisualCount;
import org.omg.CORBA.INTERNAL;

import edu.princeton.cs.algs4.*;
public class VisualCount {
	private int counter;
	private int n;
	private int N;
	private int max;
	public VisualCount(int N,int max)
	{
		this.N=N;
		this.max=max;
		this.n=0;
		this.counter=0;
		StdDraw.setXscale(0,max);
		StdDraw.setYscale(-max,max);
		StdDraw.setPenRadius(0.01);
		StdDraw.point(0, 0);
	}
	public void add()
	{
		if(n+1>N)
		{
			System.out.println("the operator times is to much");
			return;
		}
		if(counter>max)
		{
			System.out.println("the counter is to big");
			return;
		}
		n++;
		counter++;
		StdDraw.point(n, counter);
	}
	public void minus() {
		if(n+1>N)
		{
			System.out.println("the operator times is to much");
			return;
		}
		if(counter<-max)
		{
			System.out.println("the counter is to small");
			return;
		}
		n++;
		counter--;
		StdDraw.point(n, counter);
	}
	public String tosString() {
		return String.valueOf(counter);
	}
	public static void main(String[] args) {
		VisualCount test=new VisualCount(20, 10);
		for(int i=0;i<10;i++)
		{
			test.add();
		}
		for(int i=0;i<10;i++)
		{
			test.minus();
		}
		for(int i=0;i<5;i++)
		{
			test.add();
		}
	}
}
