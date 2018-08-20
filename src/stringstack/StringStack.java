package stringstack;
import booleanArray.booleanArrays;
import edu.princeton.cs.algs4.*;
public class StringStack<Item> {
	private Item[] a;
	private int N;
	public StringStack(int cap)
	{
		this.N=0;
		a=(Item[]) new Object[cap];
	}
	public boolean isEmpty()
	{
		return N==0;
	}
	public void push(Item s)
	{
		a[N++]=s;
	}
	public Item pop()
	{
		return a[--N];
	}
	public int size()
	{
		return N;
	}
	public static void main(String[] args) {
		StringStack<String> a=new StringStack<String>(20);
		while(!StdIn.isEmpty())
		{
			String s=StdIn.readString();
			if(!s.equals("-"))
				a.push(s);
			else if (!s.isEmpty()) StdOut.println(a.pop()+" ");
		}
		StdOut.printf("the size of the stringstack is %d", a.size());
	}
}
