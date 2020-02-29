package atm;

import java.util.Scanner;

public class Display extends Disp implements Printer {

	private static final Display display = new Display();

	private Display() {

	}

	public static Display getDisplay() {
		return display;
	}

	public void show() {
		System.out.println("\t\t\tWelcome " + customer.name);
		Scanner sc = new Scanner(System.in);
		boolean isCancelled = false;
		while (!isCancelled) {
			System.out.println("[Select option: ] 1. Withdrawl 2.Deposit 3.Check balance 4.Cancel");
			int op = sc.nextInt();
			Option option = Option.getOption(op);
			if (option == null) {
				System.out.println("Wrong option selected. Try again");
				continue;
			}
			switch (option) {
			case CHECKBALANCE:
				Transaction cbtx = new CheckBalance(customer);
				cbtx.perform();
				addTransaction(customer, cbtx.print());
				setCurrentTx(cbtx.print());
				break;
			case WITHDRAWL:
				Transaction wtx = new WithdrawlTransaction(customer);
				wtx.perform();
				addTransaction(customer, wtx.print());
				setCurrentTx(wtx.print());
				break;
			case DEPOSIT:
				Transaction dtx = new DepositMoney(customer);
				dtx.perform();
				addTransaction(customer, dtx.print());
				setCurrentTx(dtx.print());
				break;
			case CANCEL:
				System.out.println("Cancelling transaction");
				isCancelled = true;
				break;
			}
		}
		if (transactions.get(this.customer) != null && !transactions.get(this.customer).isEmpty()) {
			System.out.println("\n [DO u want to print?]");
			sc = new Scanner(System.in);
			String op = sc.nextLine();
			switch (op) {
			case "y":
			case "Y":
				print();
				break;
			default:
				break;
			}
		}
	}

	@Override
	public String print() {
		System.out.println(
				"############################################## Customer Transaction ########################################");
		System.out.println(getCurrentTx());

//		transactions.entrySet().forEach(c -> {
//			if(customer == c.getKey())
//				for (String s : c.getValue())
//					if(s != null)
//						System.out.println("\t\t\tTx: " + s);
//		});
		System.out.println(
				"############################################ END #################################################################");
		return null;
	}

}
