package BinarySearchST;

import demo1.queue;
import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>,Value> {
private Key[] keys;
private Value[] vals;
private int N;

public BinarySearchST(int max) {
	keys=(Key[]) new Comparable[max];
	vals=(Value[]) new Object[max];
	N=0;
}
public int size()
{
	return N;
}
public int rank(Key key)
{
	int low=0,high=N-1;
	while(low<=high)
	{
		int mid=(low+high)/2;
		int cmp=key.compareTo(keys[mid]);
		if(cmp<0) high=mid-1;
		else if(cmp>0) low=mid+1;
		else {
			return mid;
		}
	}
	return low;
}
public boolean isEmpty()
{
	return N==0;
}
public Value get(Key key)
{
	if(isEmpty()) return null;
	int i=rank(key);
	if(i<N&&keys[i].compareTo(key)==0) return vals[i];
	else {
		return null;
	}
}
public void put(Key key,Value val)
{
	int i=rank(key);
	if(i<N&&keys[i].compareTo(key)==0) vals[i]=val;
	else {
		for(int j=N;j>i;j--)
		{
			keys[j]=keys[j-1];
			vals[j]=vals[j-1];
		}
		keys[i]=key;
		vals[i]=val;
		N++;
	}
}
public void delete(Key key)
{
	int i=rank(key);
	if(i<N&&key.compareTo(keys[i])==0)
	{
		for(int j=i;j<N;j++)
		{
			keys[j]=keys[j+1];
			vals[i]=vals[i];
		}
		N--;
	}
}
public Value floor(Key key)
{
	int i=rank(key);
	if(i<N&&key.compareTo(keys[i])==0)
	{
		return vals[i];
	}
	else if(i<N&&key.compareTo(keys[i])!=0)
	{
		return vals[i-1];
	}
	else {
		return null;
	}
}
public Iterable<Key> keys()
{
	Queue<Key> queue=new Queue<Key>();
	for(int i=0;i<N;i++)
		queue.enqueue(keys[i]);
	return queue;
}
}
