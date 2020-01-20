package myGame;

public class Reifen extends Car {

	Car car;
	private String name;
	private double cost;
	private int beschleunigung;

	public Reifen(String name, double cost, int beschleunigung) {
		super(name);
		this.name = name;
		this.cost = cost;
		setBeschleunigung(beschleunigung);
	}

	@Override
	public void tunen(int beschleunigung) {
		this.beschleunigung += beschleunigung;
		setSpeed(this.beschleunigung);

	}

	public String toString() {
		return (name + " " + cost + " " + beschleunigung);
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getBeschleunigung() {
		return beschleunigung;
	}

	public void setBeschleunigung(int beschleunigung) {
		if (beschleunigung > 0 && beschleunigung <= 100) {
			this.beschleunigung = beschleunigung;
		} else {
			throw new IllegalArgumentException(
					"Wert muss zwischen 0 und 100 liegen");
		}

	}

}
