package LinearProbingHashST;

import edu.princeton.cs.algs4.Queue; 

public class LinearProbingHashST<Key,Value> {
	private int N;
	private int M;
	private Key[] keys;
	private Value[] vals;
	public LinearProbingHashST()
	{
		this.M=16;
		keys=(Key[]) new Object[M];
		vals=(Value[]) new Object[M];
	}
	public LinearProbingHashST(int M) {
		this.M=M;
		keys=(Key[]) new Object[M];
		vals=(Value[]) new Object[M];
	}
	private int hash(Key key)
	{
		return (key.hashCode()&0x7fffffff)%M;
	}
	private void resize(int max)
	{
		LinearProbingHashST<Key, Value> stRedo=new LinearProbingHashST<Key, Value>(max);
		for(int i=0;i<M;i++)
			if(keys[i]!=null)
			stRedo.put(keys[i], vals[i]);
		keys=stRedo.keys;
		vals=stRedo.vals;
		M=stRedo.M;
	}
	public void put(Key key,Value val)
	{
		if(N==M) resize(2*M);
		int i=hash(key);
		for(;keys[i]!=null;i=(i+1)%M)
			if(keys[i].equals(key))
			{
				vals[i]=val;
			}
		keys[i]=key;
		vals[i]=val;
		N++;
	}
	public Value get(Key key)
	{
		for(int i=hash(key);keys[i]!=null;i=(i+1)%M)
			if(keys[i].equals(key))
				return vals[i];
		return null;
	}
	public boolean contain(Key key)
	{
		for(int i=hash(key);keys[i]!=null;i=(i+1)%M)
			if(keys[i].equals(key))
				return true;
		return false;
	}
	public void delete(Key key)
	{
		if(!contain(key)) return;
		int i=hash(key);
		while(!keys[i].equals(key))
			i=(i+1)%M;
		keys[i]=null;
		vals[i]=null;
		i=(i+1)%M;
		while(keys[i]!=null)
		{
			Key tempKey=keys[i];
			Value tempValue=vals[i];
			keys[i]=null;
			vals[i]=null;
			N--;
			put(tempKey,tempValue);
			i=(i+1)%M;
		}
		N--;
		if(N>0&&N==M/8) resize(M/2);
	}
	public Iterable<Key> keys()
	{
		Queue<Key> queue=new Queue<Key>();
		for(int i=0;i<M;i++)
			if(keys[i]!=null)
			queue.enqueue(keys[i]);
		return queue;
	}
}
