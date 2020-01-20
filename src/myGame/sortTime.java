package myGame;

import java.util.Comparator;

public class sortTime implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		// TODO Auto-generated method stub
		return (car1.getTime()-car2.getTime());
	}

}
