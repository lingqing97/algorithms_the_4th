package demo1;
import iteratorstack.stack.newstack;

import java.awt.event.ItemEvent;

import booleanArray.booleanArrays;
import edu.princeton.cs.algs4.*;
public class del_k<Item> {
private class Node
{
	Item item;
	Node nextNode;
}
private Node firstNode;
public void push_front(Item s)
{
	if(firstNode==null)
	{
		firstNode=new Node();
		firstNode.item=s;
		firstNode.nextNode=null;
	}
	else
	{
		Node oldfirNode=firstNode;
		firstNode=new Node();
		firstNode.item=s;
		firstNode.nextNode=oldfirNode;
	}
}
public Item remove(int k)
{
	Node temp=firstNode;
	if(k==1)
	{
		firstNode=firstNode.nextNode;
		temp.nextNode=null;
		return temp.item;
	}
	else {
		for(int i=1;i<(k-1)&&temp!=null;i++)
			temp=temp.nextNode;
		if(temp==null) return null;
		Node tempNode=temp.nextNode;
		Item item=tempNode.item;
		temp.nextNode=tempNode.nextNode;
		tempNode.nextNode=null;
		return item;
	}
}
public boolean find(Item key)
{
	Node curNode=firstNode;
	while(curNode!=null&&curNode.item!=key)
	{
		curNode=curNode.nextNode;
	}
	if(curNode!=null) return true;
	else {
		return false;
	}
}
public static void main(String[] args) {
	del_k<Integer> a=new del_k<Integer>();
	for(int i=0;i<5;i++)
		a.push_front(i);
	StdOut.printf("%b ", a.find(5));;
}
}
