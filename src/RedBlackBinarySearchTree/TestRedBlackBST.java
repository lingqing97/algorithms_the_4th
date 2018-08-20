package RedBlackBinarySearchTree;

import java.util.Scanner;

public class TestRedBlackBST {
public static void main(String[] args) {
	RedBlackBST<String, Integer> bst=new RedBlackBST<String, Integer>();
	Scanner sc=new Scanner(System.in);
	System.out.print("please input the keys:\n");
	for(int i=0;i<5;i++)
		bst.put(sc.nextLine(), i+1);
	System.out.print("please input a key to get its value:\n");
	String tempkey=sc.nextLine();
	System.out.print("the value of key "+tempkey+" is:"+bst.get(tempkey));
}
}
