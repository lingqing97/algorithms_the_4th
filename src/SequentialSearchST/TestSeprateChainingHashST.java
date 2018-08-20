package SequentialSearchST;

import java.util.Scanner;

public class TestSeprateChainingHashST {
	public static void main(String[] args) {
		SperateChainingHashST<String, Integer> st=new SperateChainingHashST<String, Integer>(997);
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<5;i++)
			st.put(sc.nextLine(), i);
//		System.out.print("the keys of the st is:\n");
//		for(String tempKey:st.keys())
//			System.out.print(tempKey);
		System.out.print("now please input a key to get:\n");
		String tempkey=sc.nextLine();
		System.out.print("the key of "+tempkey+" is "+st.get(tempkey));
		System.out.print("\nnow please input a  key to delete:\n");
		tempkey=sc.nextLine();
		System.out.print("after...\n");
		st.delete(tempkey);
		System.out.print("the key of "+tempkey+" is "+st.get(tempkey));
//		for(String tempKey:st.keys())
//			System.out.print(tempKey);
	}
}
