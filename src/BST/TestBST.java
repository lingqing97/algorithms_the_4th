package BST;
import java.util.Scanner;
public class TestBST {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.print("please input the keys:");
		BST<String, Integer> bst=new BST<String, Integer>();
		for(int i=0;i<5;i++)
			bst.put(scanner.nextLine(), i);
//		System.out.print("please input a key:"+"\n");
//		String tempkey=scanner.nextLine();
//		System.out.print("the value of "+tempkey+" is:"+bst.get(tempkey)+"\n");
//		System.out.print("the min key is:"+bst.min()+"\n");
//		System.out.print("the max key if:"+bst.max()+"\n");
//		System.out.print("please input a rank to select(0-4):"+"\n");
//		int temprank=scanner.nextInt();
//		System.out.print("the rank of "+temprank+" is "+bst.select(temprank)+"\n");
//		System.out.print("the key of b's rank is "+bst.rank("b")+"\n");
		bst.delete("e");
//		System.out.print("delete a after:");
//		System.out.print("the value of "+tempkey+" is:"+bst.get(tempkey)+"\n");
		for(String temp:bst.keys())
			System.out.println(temp);
	}
}
