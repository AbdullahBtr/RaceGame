package myGame;

import java.util.Comparator;

public class sortSpeed implements Comparator<Car> {

	@Override
	public int compare(Car car1, Car car2) {
		//M�glichkeit 1
		return (int) (car1.getSpeed()-car2.getSpeed()) ;
		/*M�glichkeit 2
		 * return Integer.compare(car1.getSpeed(),car2.getSpeed());
		 */
	}

}
