package atm;

import java.util.Scanner;

public class DepositMoney extends Transaction implements Printer {

	DepositMoney(Customer cus) {
		super(cus);
	}

	@Override
	public void perform() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please entry money to deposit\n");
		int money = sc.nextInt();
		if (money > 0) {
			customer.balance += money;
			tx += customer.name + " depositing money " + money;
			System.out.println(customer.name + " depositing money " + money);
		} else
			System.out.println("Cant deposit. Provide valid amount");
	}

	@Override
	public String print() {
		return tx == "" ? null : tx;
	}

}
