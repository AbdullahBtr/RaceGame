package myGame;


public class Bet {
	int amountWin;
	int betAmount;
	Car car;
	int amount;
	Race race;
	Player player;
	/*
	 * Wette Konstruktor, wette erstellen mit Betrag
	 */
	public Bet(Car car, int betAmount, Player player) {
		if (amount < 0) {
			throw new IllegalArgumentException(
					"Amount has to be higher than 0!");
		}

		this.betAmount = betAmount;
		this.player = player;
		this.car = car;
		this.amountWin=-1;
	}

	public void getWin(Car winner, int factor) {
		if (this.car.equals(winner)) {
			this.amountWin = betAmount * factor;
		} else {
			this.amountWin = 0;
		}
	}

	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.player);
		sb.append(" :");
		sb.append(this.betAmount);
		sb.append("$");
		sb.append(this.car);

		if (this.amountWin != -1) {
			sb.append("->");
			sb.append(this.amountWin);

		}
		return sb.toString();
	}

}
