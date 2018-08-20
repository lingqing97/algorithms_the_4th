package SequentialSearchST;

import java.util.Scanner;

public class TestSequentialSearchST {
public static void main(String[] args) {
	SequentialSearchST<String, Integer> st=new SequentialSearchST<String, Integer>();
	Scanner sc=new Scanner(System.in);
	for(int i=0;i<3;i++)
		st.put(sc.nextLine(), i);
	System.out.print("please input a key:");
	String  tempkey=sc.next();
	System.out.println(st.get(tempkey));
	System.out.print("the size of st is:"+st.size());
	st.delete("b");
	System.out.print("after delete b the st is:");
//	System.out.println(st.get("a"));
//	System.out.println(st.get("c"));
//	System.out.print("the size of st is:"+st.size());
	for(String temp:st.keys())
		System.out.println(temp);
	
}
}
