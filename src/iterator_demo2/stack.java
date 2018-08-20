package iterator_demo2;
import booleanArray.booleanArrays;
import iteratorstack.stack.newstack;
import edu.princeton.cs.algs4.*;
public class stack<Item> {
	private Item[] a=(Item[]) new Object[1];
	private int N=0;
	public boolean isEmpty(){return N==0;}
	public int size(){return N;}
	public void resize(int max)
	{
		Item[] temp=(Item[]) new Object[max];
		for(int i=0;i<a.length;i++)
			temp[i]=a[i];
		a=temp;
	}
	public void push(Item s)
	{
		if(N==a.length) resize(N*2);
		a[N++]=s;
	}
	public Item pop()
	{
		Item temp=a[--N];
		if(N>0&&N==a.length/4) resize(a.length/2);
		a[N]=null;
		return temp;
	}
	public Iterator<Item> iterator()
	{
		return new newstack();
	}
	public class newstack implements Iterator<Item>
	{
		private int i=N;
		public boolean hasNext()
		{
			return i>0;
		}
		public Item next()
		{
			return a[--i];
		}
		public void remove(){}
	}
	public static void main(String[] args) {
		stack<Double> aStack=new stack<Double>();
		for(int i=0;i<5;i++)
		{
			aStack.push(i+0.0);
			StdOut.printf("now the size of the stack is %d\n", aStack.size());
		}
		
		for(Iterator<Double> it=aStack.iterator();it.hasNext();)
		{
			StdOut.println(it.next());
			StdOut.printf("now the size of the stack is %d\n", aStack.size());
		}
			
	}
}
