package SequentialSearchST;

import edu.princeton.cs.algs4.Queue;

public class SperateChainingHashST<Key,Value> {
	private int N=0;
	private int M;
	private SequentialSearchST<Key, Value>[] st;
	public SperateChainingHashST(int M)
	{
		this.M=M;
		st=(SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for(int i=0;i<M;i++)
			st[i]=new SequentialSearchST<Key,Value>();
	}
	private int hash(Key key)
	{
		return (key.hashCode()&0x7fffffff)%M;
	}
	public Value get(Key key)
	{
		return st[hash(key)].get(key);
	}
	public void put(Key key,Value val)
	{
		st[hash(key)].put(key, val);
		N++;
	}
	public void delete(Key key)
	{
		st[hash(key)].delete(key);
		N--;
	}
	public Iterable<Key> keys()
	{
		Queue<Key> queue=new Queue<Key>();
		for(int i=0;i<M;i++)
		{
			for(Key tempKey:st[i].keys())
				queue.enqueue(tempKey);
		}
		return queue;
	}
}
