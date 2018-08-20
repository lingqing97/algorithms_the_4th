package EX2_5;
import java.util.Arrays;

import demo1.quick_find;
import edu.princeton.cs.algs4.*;
public class test {
public static void main(String[] args) {
	String[] nameStrings=new String[10];
	for(int i=0;i<10;i++)
		nameStrings[i]=StdIn.readString();
	Arrays.sort(nameStrings,new California());
	for(String temp:nameStrings)
		StdOut.println(temp);
}
}
