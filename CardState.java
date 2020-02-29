package atm;

public class CardState implements State {

	private ATM atm;

	CardState(ATM atm) {
		this.atm = atm;
	}

	public ATM getAtm() {
		return atm;
	}

	public void setAtm(ATM atm) {
		this.atm = atm;
	}

	@Override
	public void displayOptions() {
		Customer cus = atm.getCustomer();
		Disp display = null;
		if (cus instanceof Manager) {
			display = ManagerDisplay.getDisplay();
		} else if (cus instanceof User) {
			display = Display.getDisplay();
		}
		display.setCustomer(cus);
		display.show();
		display.clearTransaction();
		ejectDebitCard();

	}

	@Override
	public void ejectDebitCard() {
		System.out.println("ejecting debit card");
		atm.setState(new NoCardState(atm));

	}

	@Override
	public void insertDebitCard() {
		System.out.println("sorry aleready card inserted");

	}

}
