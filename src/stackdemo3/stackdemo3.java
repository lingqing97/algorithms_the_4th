package stackdemo3;
import edu.princeton.cs.algs4.*;
public class stackdemo3<Item> {
private class Node
{
	Item item;
	Node next;
	}
private Node first=null;
private int N=0;
public boolean isEmpty(){return first==null;}
public int size(){return N;}
public void push(Item s)
{
	Node oldfirst=first;
	first=new Node();
	first.item=s;
	first.next=oldfirst;
	N++;
	}
public Item pop()
{
	Node temp=first;
	first=first.next;
	N--;
	return temp.item;
}
public static void main(String[] args) {
	stackdemo3<Integer> a=new stackdemo3<Integer>();
	for(int i=0;i<5;i++)
		a.push(i);
	for(int i=0;i<5;i++)
		StdOut.println(a.pop());
}
}
