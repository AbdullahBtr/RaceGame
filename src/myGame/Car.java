package myGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/*
 * Autos erstellen, AutoEQ den Autos hinzufügen,Autos fortbewegen,Autos tunen
 */

public class Car implements Comparable<Car> {

	List<Reifen> reifenList = new ArrayList<>();
	Reifen reifen;
	Lenkrad lenkrad;
	List<Lenkrad> lenkräder = new ArrayList<>();
	private String name;
	private static int number = 0;
	private String paint;
	private int speed;
	double distanz;
	int time;
	int lowestTime;
	double cost;
	Player player;
	RaceRound rr;
	
	
	public Car(Player player,String name){
		this.name=name;
		this.player=player;
	}
	
	public Car(String name) {
		this.name = name;
		++number;
		this.distanz = 0;
	}

	public Car(String name, int speed, Lenkrad lenkrad,Reifen reifen) {
		this.name = name;
		++number;
		this.distanz = 0;
		this.speed = speed;
		this.lenkrad = lenkrad;
		this.reifen=reifen;
	}

	public Car(String name, int speed, Reifen reifen) {
		this.name = name;
		++number;
		this.distanz = 0;
		this.speed = speed;
		this.reifen = reifen;
	}

	public Car(String name, int speed,double cost) {
		this.name = name;
		this.speed = speed;
		this.distanz = 0;
		this.time = 0;
		this.cost=cost;
		this.distanz=0;
		++number;
	}

	public Car(String name, String paint, int speed) {
		this.name = name;
		this.paint = paint;
		this.speed = speed;
		++number;
	}

	public String toString() {
		return (name + " with speed " + speed + " mit den Reifen " + reifenList
				+ " und dem Lenkrad " + lenkräder);
	}

	public void tunen(int tune) {
		speed = speed + tune;

	}


	public void moveCar() {
		Random r = new Random();
		distanz = distanz + speed * (r.nextInt(100) + 1) / 100;

	}

	public void moveCarRound() {
		Random r = new Random();
	try{
		time = time + (r.nextInt(100) * 100) / speed;
	}catch(ArithmeticException e){
		System.out.println(e.getMessage());
	}
		lowestTime = time;

	}

	public void remove(Lenkrad lenkrad) {

		lenkräder.remove(lenkrad);
	}

	public void addLenkrad(Lenkrad lenkrad) {

		if (lenkräder.isEmpty()) {
			speed = speed + lenkrad.getLenkGenauigkeit();
			cost+=lenkrad.getCost();
			lenkräder.add(lenkrad);
		} else {
			cost+=lenkrad.getCost();
			for (Lenkrad lenkradd : new ArrayList<>(lenkräder)) {// Copy-Arraylist
																	// erstellen
																	// und über
																	// diese
																	// iterieren

				lenkräder.remove(lenkradd);
				speed = speed - lenkradd.getLenkGenauigkeit();
				lenkräder.add(lenkrad);
				speed += lenkrad.getLenkGenauigkeit();
			}

		}
	}

	public void addReifen(Reifen reifen) {

		if (reifenList.isEmpty()) {
			reifenList.add(reifen);
			speed = speed + reifen.getBeschleunigung();
			cost+=reifen.getCost();
		} else {
			cost+=reifen.getCost();
			for (Reifen reifenn : new ArrayList<>(reifenList)) {// Copy-Arraylist
																// erstellen und
																// über diese
																// iterieren

				reifenList.remove(reifenn);
				speed = speed - reifenn.getBeschleunigung();
				lenkräder.add(lenkrad);
				speed += reifen.getBeschleunigung();
			}

		}
	}

	public void sizeOfList() {

		System.out.println(reifenList.size() + " " + lenkräder.size());
	}

	public void addAllEq(Lenkrad lenkrad, Reifen reifen) {
		lenkräder.add(lenkrad);
		reifenList.add(reifen);
		speed = speed + reifen.getBeschleunigung()
				+ lenkrad.getLenkGenauigkeit();
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public String getPaint() {
		return paint;
	}

	public void setPaint(String paint) {
		this.paint = paint;
	}

	public int getSpeed() {
		return speed;
	}

	public static int number() {
		return number;
	}

	public void setName(String name) {
		this.name = name;

	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int compareTo(Car car) {

		return car.name.compareTo(getName());
	}

	public int getLowestTime() {
		return lowestTime;
	}

	public void setLowestTime(int lowestTime) {
		this.lowestTime = lowestTime;
	}

	public double getDistanz() {
		return distanz;
	}

	public void setDistanz(double distanz) {
		this.distanz = distanz;
	}

	
	public Lenkrad getLenkrad() {
		return lenkrad;
	}

	public void setLenkrad(Lenkrad lenkrad) {
		this.lenkrad = lenkrad;
	}

	public List<Reifen> getReifenList() {
		return reifenList;
	}

	public void setReifenList(List<Reifen> reifenList) {
		this.reifenList = reifenList;
	}

	public Reifen getReifen() {
		return reifen;
	}

	public void setReifen(Reifen reifen) {
		this.reifen = reifen;
	}

	public List<Lenkrad> getLenkräder() {
		return lenkräder;
	}

	public void setLenkräder(List<Lenkrad> lenkräder) {
		this.lenkräder = lenkräder;
	}

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		Car.number = number;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
