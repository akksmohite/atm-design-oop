package atm;

public class CheckBalance extends Transaction implements Printer {

	CheckBalance(Customer cus) {
		super(cus);
	}

	@Override
	public void perform() {
		System.out.println(customer.name + " checking balance Balance: " + customer.balance);
	}

	@Override
	public String print() {
		return customer.name + " checking balance Balance: " + customer.balance;
	}
}
