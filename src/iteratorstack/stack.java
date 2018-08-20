package iteratorstack;
import java.awt.event.ItemEvent;
import java.util.Iterator;

import edu.princeton.cs.algs4.StdOut;
public class stack <Item>{
	private Item[] a=(Item[]) new Object[1];
	private int N=0;
	public boolean isEmpty(){return N==0;}
	public int size(){return N;}
	public void resize(int max)
	{
		Item[] temp=(Item[]) new Object[max];
		for(int i=0;i<N;i++)
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
		a[N]=null;
		if(N>0&&N==a.length/4) resize(a.length/2);
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
		stack<Integer> a=new stack<Integer>();
		for(int i=0;i<10;i++)
			a.push(i);
		for(Iterator<Integer> it=a.iterator();it.hasNext();)
			StdOut.println(it.next());
	}
}
