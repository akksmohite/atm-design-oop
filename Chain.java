package atm;

public abstract class Chain {

	protected ATM atm;
	
	abstract void dispense(int money);
	
	Chain() {
		atm = ATM.getATM();
	}
	int getATMBalance() {
		return atm.getBalance();
	}
}
