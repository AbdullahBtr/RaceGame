package myGame;

import java.util.ArrayList;
import java.util.Collections;



public class RaceRound extends Race {

	
	


	
	

	public RaceRound(String name,ArrayList<Car> car,int round) {

		super(name);
		this.cars = car;
		this.round=round;
	}

	public RaceRound(String name, int round, int number) {
		super(name, number);
		this.name = name;
		this.round = round;
		this.number = number;
		

	}

	public RaceRound(String name, int round) {
		super(name);
		this.name = name;
		this.round = round;
	}



	public void raceStartWithRound() {

		currentRound = 1;
		int i = 1;
		System.out.println("******************************");
		System.out.println(name + " race is " + " starting...");
		System.out.println("******************************");
		System.out.println();
		while (currentRound <= getRound()) {
			System.out.println("********");
			System.out.println("Round " + currentRound);
			System.out.println("********");
			
			Collections.sort(cars, new sortTime());
			for (Car car : cars) {

				startCarsRound();
				System.out.println(i + ". " + car.getName()
						+ " got in the round " + currentRound + " at the time "
						+ car.getTime());

				++i;

			}

			++currentRound;

		}
		if (getWinnerRound() != null) {
			System.out.println();
			System.out.println("***Winner of the race**");
			System.out.println(getWinnerRound());
		}

	}

	public Car getWinnerRound() {
		Car winner = null;
		for (Car car : cars) {

			if (winner == null) {
				car = cars.get(0);
				winner = car;

			}
		}
		return winner;
	}

	public void addtoList(Car car) {
		if (this.cars.contains(car)) {
			throw new IllegalArgumentException(
					"This car is already in this race");
		} else
			cars.add(car);
		

	}



	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.name + "(" + this.cars.size() + ") :" + this.round
				+ "\n");

		if (this.getWinnerRound() != null) {
			sb.append("\n");
			sb.append("Winner: ");
			sb.append(this.getWinnerRound());
			sb.append("\n");
		} else {
			sb.append("Rennen noch nicht gestartet");
			sb.append("\n");
		}

		return sb.toString();
	}



	
}
