package myGame;

public class Lenkrad extends Car {

	/*
	 * TODO deutsche Begriffe ins englische übersetzen
	 */
	private String name;
	private double cost;
	private int lenkGenauigkeit;

	public Lenkrad(String name, double cost, int lenkGenauigkeit) {
		super(name);
		this.name = name;
		this.cost = cost;
		setLenkGenauigkeit(lenkGenauigkeit);
	}

	@Override
	public void tunen(int lenkGenauigkeit) {
		this.lenkGenauigkeit = lenkGenauigkeit;
		setSpeed(this.lenkGenauigkeit);
	}

	public String toString() {
		return (name + " " + cost + " " + lenkGenauigkeit);
	}


	public String getName() {
		return name;
	}

	public double getCost() {
		return cost;
	}

	public int getLenkGenauigkeit() {
		return lenkGenauigkeit;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setLenkGenauigkeit(int lenkGenauigkeit) {
		if (lenkGenauigkeit > 0 && lenkGenauigkeit <= 20) {
			this.lenkGenauigkeit = lenkGenauigkeit;
		} else {
			throw new IllegalArgumentException(
					"Wert muss zwischen 0 und 20 liegen");
		}

	}

}
