package Date;
import edu.princeton.cs.algs4.*;
public class Date {
	String day;
	String month;
	String year;
	public Date(String date)
	{
		String[] tempdate=date.split("/");
		month=tempdate[0];
		day=tempdate[1];
		year=tempdate[2];
	}
	public String getday()
	{
		return this.day;
	}
	public String getmonth()
	{
		return this.month;
	}
	public String getyear()
	{
		return year;
	}
	public String toString()
	{
		return month+"/"+day+"/"+year;
	}
	public static void main(String[] args) {
		Date date=new Date("7/30/2018");
		StdOut.println(date.day);
		StdOut.println(date);
	}
}
