package smalldate;
import org.omg.CORBA.INTERNAL;

import booleanArray.booleanArrays;
import edu.princeton.cs.algs4.*;
public class smalldate {
	private int month;
	private int day;
	private int year;
	public smalldate(String date) throws ArithmeticException
	{
		String[] tempdate=date.split("/");
		int month=Integer.parseInt(tempdate[0]);
		int day=Integer.parseInt(tempdate[1]);
		int year=Integer.parseInt(tempdate[2]);
		if(month<=0||month>12)
			throw new ArithmeticException("type over");
		else if(day<=0)
			throw new ArithmeticException("type over");
		else if(month==2&&isruennian(tempdate[2])&&day>28)
			throw new ArithmeticException("type over");
		else if(month==2&&(!isruennian(tempdate[2]))&&day>29)
			throw new ArithmeticException("type over");
		else {
			this.month=month;
			this.day=day;
			this.year=year;
		}	
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isruennian(String year)
	{
		int tempyear=Integer.parseInt(year);
		if(tempyear%4==0&&tempyear%100!=0)
			return true;
		else if(tempyear%400==0)
			return true;
		else {
			return false;
		}
	}
	public String toString()
	{
		return month+"/"+day+"/"+year;
	}
	public static void main(String[] args) {
		smalldate test001=new smalldate("12/7/2018");
		StdOut.println(test001);
	}
}
