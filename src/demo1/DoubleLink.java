package demo1;
import javax.xml.soap.Node;

import iteratorstack.stack.newstack;
import edu.princeton.cs.algs4.*;
public class DoubleLink<Item> {
private class DoubleNode
{
	Item item;
	DoubleNode next;
	DoubleNode front;
}
private DoubleNode first=null;
private DoubleNode last=null;
public void push_front(Item s)
{
	DoubleNode temp=new DoubleNode();
	temp.item=s;
	if(first==null)
	{
		last=temp;
		first=temp;
	}
	else {
		first.front=temp;
		temp.next=first;
		first=temp;
	}
}
public void push_last(Item s)
{
	DoubleNode temp=new DoubleNode();
	temp.item=s;
	if(last==null)
	{
		last=temp;
		first=temp;
	}
	else {
		last.next=temp;
		temp.front=last;
		last=temp;
	}
}
public Item pop_first()
{
	if(first==null) return null;
	else if(first.next!=null)
	{
		Item temp=first.item;
		first=first.next;
		first.front.next=null;
		first.front=null;
		return temp;
	}
	else {
		Item temp=first.item;
		first=null;
		last=null;
		return temp;
	}
}
public Item pop_last()
{
	if(last==null) return null;
	else if(last.front!=null)
	{
		Item temp=last.item;
		last=last.front;
		last.next.front=null;
		last.next=null;
		return temp;
	}
	else {
		Item temp=last.item;
		first=null;
		last=null;
		return temp;
	}
}
public void remove(DoubleNode node)
{
	if(node==first)
	{
		first=first.next;
		first.front.next=null;
		first.front=null;
	}
	else if(node==last)
	{
		last=last.front;
		last.next.front=null;
		last.next=null;
	}
	else {
		node.front.next=node.next;
		node.next.front=node.front;
		node.front=null;
		node.next=null;
	}
}
public void remove(int k)
{
	DoubleNode curNode=first;
	for(int i=1;i<k&&curNode!=null;i++)
		curNode=curNode.next;
	remove(curNode);
}
public void insert(DoubleNode node,Item s)
{
	if(node==last)
	{
		push_last(s);
	}
	else {
		DoubleNode temp=new DoubleNode();
		temp.item=s;
		temp.next=node.next;
		temp.front=node;
		node.next.front=temp;
		node.next=temp;
	}
}
public void insert_front(int k,Item s)
{
	DoubleNode curDoubleNode=first;
	if(k-1==0) push_front(s);
	else {
		for(int i=1;i<(k-1)&&curDoubleNode!=null;i++)
			curDoubleNode=curDoubleNode.next;
		insert(curDoubleNode,s);
	}
}
public void insert_last(int k,Item s)
{
	DoubleNode curDoubleNode=first;
	for(int i=1;i<k&&curDoubleNode!=null;i++)
		curDoubleNode=curDoubleNode.next;
	insert(curDoubleNode,s);	
}
public static void main(String[] args) {
	DoubleLink<Integer> test=new DoubleLink<Integer>();
	for(int i=0;i<5;i++)
		test.push_front(i);
	for(int i=0;i<5;i++)
		StdOut.println(test.pop_last());
}
}
