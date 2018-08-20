package listbag;
import iteratorstack.stack.newstack;
import java.util.Iterator;
import javax.xml.soap.Node;

import edu.princeton.cs.algs4.*;
public class listbag<Item> {
private Node first=null;
private int N;
private class Node
{
	Item item;
	Node next;
}
public void add(Item s)
{
	Node oldfirst=first;
	first=new Node();
	first.item=s;
	first.next=oldfirst;
	N++;
}
public Iterator<Item> iterator()
{
	return new newlist();
}
private class newlist implements Iterator<Item>
{
	private Node currentNode=first;
	public boolean hasNext(){return currentNode!=null;}
	public Item next()
	{
		Item tempItem=currentNode.item;
		currentNode=currentNode.next;
		return tempItem;
	}
	public void remove() {
		
	}
}
public static void main(String[] args) {
	listbag<Integer> a=new listbag<Integer>();
	for(int i=0;i<5;i++)
		a.add(i);
	for(Iterator<Integer> it=a.iterator();it.hasNext();)
		StdOut.println(it.next());
}
}
