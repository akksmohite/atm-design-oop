package atm;

import java.util.Scanner;

public class WithdrawlTransaction extends Transaction implements Printer {

	private Chain chain;

	WithdrawlTransaction(Customer cus) {
		super(cus);
		chain = new ThousandChain(new HundreadChain(new FiftyChain(new TenChain(null))));
	}

	@Override
	public void perform() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please entry money to withdraw\n");
		int money = sc.nextInt();
		if (money <= customer.balance && money <= ATM.getATM().getBalance()) {
			chain.dispense(money);
			customer.balance -= money;
			tx = customer.name + " withdrwaing money " + money;
			System.out.println(customer.name + " withdrwaing money " + money);
		} else {
			if (money > customer.balance)
				System.out.println("Sorry not sufficent balance in ur account ");
			else if (money > ATM.getATM().getBalance())
				System.out.println("Sorry not sufficent balance in ATM machine ");
		}
	}

	@Override
	public String print() {
		return tx == "" ? null : tx;
	}

}
