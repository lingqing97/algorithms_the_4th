package BinarySearchST;
import java.util.Scanner;
import edu.princeton.cs.algs4.*;
public class TestBinarySearchST {
public static void main(String[] args) {
	BinarySearchST<String, Integer> st=new BinarySearchST<String,Integer>(10);
	Scanner scanner=new Scanner(System.in);
	System.out.print("please input your keys:");
	for(int i=0;i<5;i++)
		st.put(scanner.nextLine(), i);
	System.out.print("please input a key:");
	String tempkey=scanner.nextLine();
	System.out.println(st.get(tempkey));
	st.delete("b");
	System.out.print("the min of less b is:"+st.floor("b"));
	System.out.print("the keys of st is:");
	for(String temp:st.keys())
	{
		System.out.println(temp);
	}
}
}
