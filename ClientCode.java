package atm;

import java.util.Scanner;

public class ClientCode {

	public static void main(String[] args) {
		System.out.println("Starting ATM machine");
		ATM atm = ATM.getATM();
		Customer c1 = new User("C1", 111111, 1111, 90000);
		Customer c2 = new User("C2", 222222, 2222, 290000);
		Customer c3 = new User("C3", 333333, 3333, 67000);
		Customer c4 = new User("C4", 444444, 4444, 1000000);
		Customer c5 = new User("C5", 555555, 5555, 200000);
		atm.addCustomerToDB(c1);
		atm.addCustomerToDB(c2);
		atm.addCustomerToDB(c3);
		atm.addCustomerToDB(c4);
		atm.addCustomerToDB(c5);

		Customer m1 = new Manager("M1", 88888888, 8888, 0);
		Customer m2 = new Manager("M2", 99999999, 9999, 0);
		atm.addManagerToDB(m1);
		atm.addManagerToDB(m2);

		Scanner sc = new Scanner(System.in);
		int i = 0;
		while (i < 5) {
			i++;
			System.out.println();
			System.out.println("Please insert card");
			atm.insertDebitCard();
			System.out.println("\nHello Please enter account number:");
			int number = sc.nextInt();
			int maxAttempt = 0;
			while (maxAttempt <= 3) {
				System.out.println("\nPlease enter PIN:");
				int pin = sc.nextInt();
				boolean val = atm.validateCustomer(number, pin);
				if (!val) {
					System.out.println("Sorry wrong PIN enterd or another issue. try again");
					maxAttempt++;
					if (maxAttempt >= 3) {
						System.out.println("SORRY. Card blocked card Number: " + number);
						atm.ejectDebitCard();
						break;
					}
				} else {
					atm.displayOptions();
					break;
				}
			}
		}
	}

}
