package atm;

public abstract class Transaction implements Printer {

	protected Customer customer;
	protected String tx = "";
	abstract void perform();

	Transaction(Customer cus) {
		this.customer = cus;
	}
}
