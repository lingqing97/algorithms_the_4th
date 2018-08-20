package EX2_5;
import edu.princeton.cs.algs4.*;
import java.lang.String;
public class Domain implements Comparable<Domain>{
private String domain;
private String redomain="";
public Domain(String init) {
 domain=init;
 String[] temp=domain.split("\\.");
 for(int i=temp.length-1;i>=0;i--)
	 if(i!=0)
		 redomain+=temp[i]+'.';
	 else {
		 redomain+=temp[i];
	 }
}

public String getDomain() {
	return domain;
}

public void setDomain(String domain) {
	this.domain = domain;
}

public String getRedomain() {
	return redomain;
}

public void setRedomain(String redomain) {
	this.redomain = redomain;
}

public int compareTo(Domain temp) {
	return redomain.compareTo(temp.getRedomain());
}

@Override
public String toString() {
	return "Domain [domain=" + domain + ", redomain=" + redomain + "]";
}

}
