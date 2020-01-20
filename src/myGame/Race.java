package myGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class Race implements TableModel {

	/*
	 * Rennen-> entweder Rundenbasiert oder Streckenbasiert.
	 */

	protected String name;
	protected boolean crash;
	protected int number;
	protected List<Car> cars = new ArrayList<Car>();
	protected double strecke;
	protected int round;
	protected int currentRound;
	protected List<TableModelListener> tableListener = new ArrayList<TableModelListener>();

	public Race(String name) {
		this.name = name;
	}

	public Race(String name, int number) {
		this.name = name;
		this.number = number;
	}

	

	public void addtoList(Car car) {
		if (this.cars.contains(car)) {
			throw new IllegalArgumentException(
					"This car is already in this race");
		} else{
			cars.add(car);
		}
		
		for (TableModelListener l : tableListener) {
			l.tableChanged(new TableModelEvent(this));
		}
	}

	public void remove(Car car) {
		Scanner s;
		if (cars.isEmpty()) {
			System.out.println("List is empty");
			System.out.println();
			s = new Scanner(System.in);
			System.out
					.println("Do you want to add a new Car? Than Yes name of the car?");
			String s1 = s.nextLine();
			Car a = new Car(s1);
			cars.add(a);

		} else {
			cars.remove(car);
		}
	}

	public void startCars() {
		for (Car car : this.cars) {
			car.moveCar();

		}
	}

	public void startCarsRound() {
		for (Car car : cars) {
			car.moveCarRound();
		}

	}

	public void endRacee() {
		for (Car car : cars) {
			car.setTime(0);
		}
	}

	public void carName() {
		for (Car car : cars) {
			System.out.println(car.getName());
		}
	}

	public void clearAll() {

		cars.clear();
	}

	public int sizeOfList() {
	return 	cars.size();
		
	}

	// public void raceStart() {
	// s = new Scanner(System.in);
	// System.out.println("Do you want to start race with round or distance?");
	// String abfrage = s.nextLine().toLowerCase();
	// switch (abfrage) {
	// case "round":
	// System.out.println("Race with round choosed,Good Luck!");
	// rc.raceStartWithRound();
	// break;
	// case "distance":
	// System.out.println("Race with distance choosed,Good Luck!");
	// rd.raceStartWithDistance();
	// break;
	// default:
	// throw new IllegalArgumentException(
	// "You have to choose either rounds or distance!");
	// }
	// }

	public void endRace() {
		if (crash == true) {
			System.out
					.println("Es gab ein Unfall, das Rennen muss pausiert werden");
			System.exit(-1);
		}

	}

	public void crashRandom(int crashTime) {
		Random r = new Random();
		crashTime = r.nextInt(crashTime);
		crash = true;
		endRace();

	}
	
	public Car getCar( int rowIndex){
		
		return cars.get(rowIndex);
	}

	// public String getPrintString(){
	// StringBuilder sb= new StringBuilder();
	// sb.append("Rennen: ");
	// sb.append(this.name);
	// sb.append("Teilnehmer: ");
	// sb.append(this.cars.size());
	// sb.append("Strecke: ");
	// sb.append(this.strecke)
	// }



	@Override
	public void addTableModelListener(TableModelListener l) {
		tableListener.add(l);

	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {

		case 0:
			return String.class;
		case 1:
			return Integer.class;
		case 2:
			return Integer.class;
		case 3:
			return Integer.class;
		case 4: 
			return String.class;
		case 5: 
			return Integer.class;
		
		default:
			return null;
		}
	}

	@Override
	public int getColumnCount() {
	
		return 6;
	}

	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {

		case 0:
			return "Auto";
		case 1:
			return "Leistung";
		case 2:
			return "Preis";
		case 3:
			return "Nummer";
		case 4:
			return "Rennen";
		case 5:
			return "Runde";
		default:
			return null;
		}

	}

	@Override
	public int getRowCount() {
		return sizeOfList();

	}


	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		
			Car car = getCar(rowIndex);
			switch (columnIndex) {

			case 0:
				return car.getName();
			case 1:
				return car.getSpeed();
			case 2:
				return car.getCost();
			case 3:
				return sizeOfList();
			case 4:
				return getName();
			case 5:
				return getRound();
			default:
				return null;
			
		}
		
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		tableListener.remove(l);

	}

	@Override
	public void setValueAt(Object arg0, int arg1, int arg2) {
	

	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCrash() {
		return crash;
	}

	public void setCrash(boolean crash) {
		this.crash = crash;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public double getStrecke() {
		return strecke;
	}

	public void setStrecke(double strecke) {
		this.strecke = strecke;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}

	public List<TableModelListener> getTableListener() {
		return tableListener;
	}

	public void setTableListener(List<TableModelListener> tableListener) {
		this.tableListener = tableListener;
	}
	
}
