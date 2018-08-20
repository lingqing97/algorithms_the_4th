package CombinationWordsCount;
import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.List;
public class CombinationWordsCount {
public static List<String> CombinationWords(String[] string) {
	List<String> list=new ArrayList<String>();
	for(int i=0;i<string.length;i++)
	{
		String firString=string[i];
		for(int j=i+1;j<string.length;j++)
		{
			String scdstring=string[j];
			for(int k=0;k<string.length;k++)
				if(((firString+scdstring).equals(string[k]))||((scdstring+firString).equals(string[k])))
				list.add(string[k]);
		}
	}
	return list;
}
public static void main(String[] args) {
	String[] strings = {"after","thought","afterthought","mooncake","hard","work","hardwork","moon","cake"};
	List<String> listString = CombinationWords(strings);
	for (String string : listString) {
		System.out.print(string + " ");
	}
	
}
}
