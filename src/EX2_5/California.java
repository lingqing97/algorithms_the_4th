package EX2_5;
import edu.princeton.cs.algs4.*;
import java.util.Arrays;
import java.util.Comparator;
public class California implements Comparator<String>{
	private String ruleString="RWQOJMVAHBSGZXNTCIEKUPDYFL";
	public int compare(String str1, String str2) {
		int min = Math.min(str1.length(), str2.length());
		for (int i = 0; i < min; i++) {
			int index1 = ruleString.indexOf(str1.charAt(i));
			int index2 = ruleString.indexOf(str2.charAt(i));
			if (index1 != index2) {
				return index1 - index2;
			}
		}
		return str1.length() - str2.length();
	}
}

