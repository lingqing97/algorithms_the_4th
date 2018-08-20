package shishu;
import edu.princeton.cs.algs4.*;

import java.lang.Math;

import booleanArray.booleanArrays;
public class shishu {
	private int a;
	private int b;
	private static int MAX=2147483647;
	private static int MIN=-2147483647;
	public shishu(int a,int b) throws ArithmeticException
	{
		if(b==0)
			throw new ArithmeticException("Divide by zero");
		else {
			int gcdab=gcd(a, b);
			if(b<0)
			{
				a=-a;
				b=-b;
			}
			this.a=a/gcdab;
			this.b=b/gcdab;
		}
	}
	public int gcd(int a,int b)
	{
		int p=Math.abs(a);
		int q=Math.abs(b);
		if(p<q)
		{
			int temp=p;
			p=q;
			q=temp;
		}
		while(q>0)
		{
			int temp=p%q;
			p=q;
			q=temp;
		}
		return p;
	}
	public boolean isplusover(int a,int b)
	{
		if(a+b>MAX)
			return false;
		else if(a+b<MIN)
			return false;
		else {
			return true;
		}
	}
	public boolean istimesover(int a,int b)
	{
		if(a*b>MAX)
			return false;
		else if(a*b<MIN)
			return false;
		else {
			return true;
		}
	}
	public shishu plus(shishu b)
	{
		assert isplusover(this.a*b.b, b.a*this.b):"plus is over";
		assert istimesover(this.b, b.b):"times is over";
		return new shishu(this.a*b.b+b.a*this.b,this.b*b.b);
	}
	public shishu minus(shishu b)
	{
		assert istimesover(this.b, b.b):"times is over";
		return new shishu(this.a*b.b-b.a*this.b,this.b*b.b);
	}
	public shishu times(shishu b)
	{
		assert istimesover(this.a, b.a);
		assert istimesover(this.b, b.b);
		return new shishu(this.a*b.a, this.b*b.b);
	}
	public shishu divides(shishu b)
	{
		return new shishu(this.a*b.b, this.b*b.a);
	}
	public boolean equal(shishu b)
	{
		if(this.a==b.a&&this.b==b.b)
			return true;
		else {
			return false;
		}
	}
	public String toString()
	{
		if(Math.abs(this.a)%Math.abs(this.b)==0)
			return String.valueOf(this.a/this.b);
		else {
			return (this.a+"/"+this.b);
		}
	}
	public static void main(String[] args) {
		shishu a=new shishu(12, 3);
		shishu b=new shishu(-15,5);
		StdOut.printf("a plus b is %s\n", a.plus(b));
		StdOut.printf("a minus b is %s\n", a.minus(b));
		StdOut.printf("a times b is %s\n", a.times(b));
		StdOut.printf("a divides b is %s\n", a.divides(b));
		StdOut.printf("a is %s ,b is %s\n", a,b);
	}
}
