package demo1;
import iteratorstack.stack.newstack;
import edu.princeton.cs.algs4.*;
public class queue<Item> {
private Item[] aItems=(Item[]) new Object[1];
private int first=0;
private int last=0;
public boolean isEmpty(){return (last-first)==0;}
public int size(){return (last-first);}
public void resize(int max)
{
	Item[] tempItems=(Item[]) new Object[max];
	for(int i=0;i<(last-first);i++)
		tempItems[i]=aItems[i];
	aItems=tempItems;
}
public void enqueue(Item s)
{
	if((last-first)==aItems.length) resize(aItems.length*2);
	aItems[last++]=s;
}
public Item dequeue()
{
	Item tempItem=aItems[first];
	for(int i=first;i<last;i++)
	{
		aItems[i]=aItems[i+1];
	}
	last--;
	if((last-first)>0&&(last-first)==aItems.length/4) resize(aItems.length/2);
	return tempItem;
}
public static void main(String[] args) {
	queue<Integer> q=new queue<Integer>();
	for(int i=0;i<5;i++)
	{
		StdOut.printf("now the size of the queue is %d\n", q.size());
		q.enqueue(i);
	}
	for(int i=0;i<5;i++)
		StdOut.println(q.dequeue());
}
}
