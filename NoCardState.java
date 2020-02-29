package atm;

public class NoCardState implements State {
	private ATM atm;

	public NoCardState(ATM atm) {
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
		System.out.println("Cant display. Insert card");

	}

	@Override
	public void ejectDebitCard() {
		System.out.println("cant eject no card insrted");

	}

	@Override
	public void insertDebitCard() {
		System.out.println("card inserted");
		this.atm.setState(new CardState(atm));
	}

}
