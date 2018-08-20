package EX2_5;
import edu.princeton.cs.algs4.*;
public class Recode implements Comparable<Recode>{
	private String string;
	private int count=0;
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public int getCount() {
		return count;
	}
	public void addCount() {
		this.count++;
	}
	public int compareTo(Recode temp)
	{
		if(count<temp.getCount()) return -1;
		else if(count==temp.getCount()) return 0;
		else {
			return 1;
		}
	}
	@Override
	public String toString() {
		return "Recode [string=" + string + ", count=" + count + "]";
	}
}
