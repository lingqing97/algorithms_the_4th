package TransactionSort;
import edu.princeton.cs.algs4.*;
public class Transaction {
private String who;
private Date when;
private double amount;
public Transaction() {
}
public Transaction(String who,Date date,double amount) {
	this.who=who;
	this.when=date;
	this.amount=amount;
}
public String getWho() {
	return who;
}
public void setWho(String who) {
	this.who = who;
}
public Date getWhen() {
	return when;
}
public void setWhen(Date when) {
	this.when = when;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Transaction [who=" + who + ", when=" + when + ", amount=" + amount
			+ "]";
}

}
