package myGame;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;
	private static int number = 0;
	private int kontostand;
	Car car;
	List<Car> cars = new ArrayList<>();

	public void add(Car car) {
		if (this.kontostand <= car.getCost()) {
			throw new IllegalArgumentException("Ihr Kontostand ist zu niedrig");
		} else {
			cars.add(car);
		}

	}

	public Player(String name) {
		this.name = name;
		++number;
	}

	public Player(String name, int kontostand) {
		this.name = name;
		this.kontostand = kontostand;
		++number;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Spieler:\n");
		sb.append(this.getName() + "\n");
		sb.append("Auto/s: \n");
		for (Car car : cars) {

			sb.append(car + "\n");
		}
		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		Player.number = number;
	}

	public int getKontostand() {
		return kontostand;
	}

	public void setKontostand(int kontostand) {
		this.kontostand = kontostand;
	}

}
