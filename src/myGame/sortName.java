package myGame;

import java.util.Comparator;

public class sortName implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		
		return car1.getName().compareTo(car2.getName());
	}

}
