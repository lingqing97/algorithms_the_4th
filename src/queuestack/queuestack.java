package queuestack;
import iteratorstack.stack.newstack;

import javax.xml.soap.Node;

import edu.princeton.cs.algs4.*;
public class queuestack<Item> {
private Node first;
private Node last;
private int N;
private class Node
{
	Item item;
	Node next;
}
public boolean isEmpty(){return first==null;}
public int size(){return N;}
public void enqueue(Item s)
{
	Node oldlast=last;
	last=new Node();
	last.item=s;
	last.next=null;
	if(isEmpty())first=last;
	else oldlast.next=last;
	N++;
}
public Item dequeue()
{
	Item temp=first.item;
	first=first.next;
	if(isEmpty()) last=null;
	N--;
	return temp;
}
public static void main(String[] args) {
	queuestack<Integer> a=new queuestack<Integer>();
	for(int i=0;i<5;i++)
		a.enqueue(i);
	for(int i=0;i<5;i++)
		StdOut.println(a.dequeue());
}
}
