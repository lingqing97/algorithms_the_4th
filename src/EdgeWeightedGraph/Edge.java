package EdgeWeightedGraph;

import javax.management.RuntimeErrorException;

public class Edge implements Comparable<Edge>{
	private int v;
	private int w;
	private final double weight;
	public Edge(int v,int w,double weight) {
		this.v=v;
		this.w=w;
		this.weight=weight;
	}
	public double weight()
	{
		return weight;
	}
	public int either()
	{
		return v;
	}
	public int other(int v)
	{
		if(v==this.v) return this.w;
		else if(v==this.w) return this.v;
		else
			throw new RuntimeException("error");
	}
	public int compareTo(Edge that)
	{
		if(this.weight<that.weight) return -1;
		else if(this.weight==that.weight) return 0;
		else
			return 1;
	}
	@Override
	public String toString() {
		return "Edge [v=" + v + ", w=" + w + ", weight=" + weight + "]";
	}
}
