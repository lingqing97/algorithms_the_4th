package EX2_5;
import edu.princeton.cs.algs4.*;
public class SPT implements Comparable<SPT>{
	private String name;
	private double time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public int compareTo(SPT temp)
	{
		if(time<temp.getTime()) return -1;
		else if(time==temp.getTime()) return 0;
		else {
			return 1;
		}
	}
	@Override
	public String toString() {
		return "SPT [name=" + name + ", time=" + time + "]";
	}
}
