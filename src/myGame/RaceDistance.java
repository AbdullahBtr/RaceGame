package myGame;



public class RaceDistance extends Race {



	public RaceDistance(String name, double strecke) {
		super(name);
		this.name = name;
		this.strecke = strecke;
	}

	public RaceDistance(String name, double strecke, int number) {
		super(name, number);
		this.name = name;
		this.strecke = strecke;
		this.number = number;
	}



	public void raceStartWithDistance() {
		System.out.println("******************************");
		System.out.println(name + " race is " + " starting...");
		System.out.println("******************************");
		System.out.println();
		while (this.getWinner() == null) {
			this.startCars();
		}
		if (getWinner() != null) {
			System.out.println(toString());
		}
	}

	public Car getWinner() {
		Car winner = null;
		for (Car car : cars) {
			if (car.getDistanz() >= this.strecke) {
				if (winner == null) {
					winner = car;

				} else {
					if (car.getDistanz() > winner.getDistanz()) {
						winner = car;

					}
				}
			}
		}
		return winner;
	}

	
	
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.name + "(" + this.cars.size() + ") :" + this.strecke
				+ "\n");
		for (Car car : cars) {
			sb.append(car);
			sb.append("\n");
		}
		if (this.getWinner() != null) {
			sb.append("\n");
			sb.append("Winner: ");
			sb.append(this.getWinner());
			sb.append("\n");
		} else {
			sb.append("Rennen noch nicht gestartet");
			sb.append("\n");
		}
		return sb.toString();
	}

	

	
}
