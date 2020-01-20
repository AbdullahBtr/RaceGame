package myGame;

import java.util.ArrayList;
import java.util.List;

public class BetHouse {

	private int factor;
	List<Player> player = new ArrayList<>();
	RaceRound rr;
	RaceDistance rd;
	List<Bet> bet = new ArrayList<>();
	private Car winner;
	
	
	public BetHouse(Race race, int factor) {
		if (factor < 0) {
			throw new IllegalArgumentException(
					"Amount has to be higher than 0!");
		}
		this.factor = factor;
		this.race = race;

	}
	public void addPlayer(Player player) {
		if (this.player.contains(player)) {
			throw new IllegalArgumentException("Player already in List");
		}else{
			this.player.add(player);
		}
		
	}
	
	
	
	public void remove(Bet beta){
		if(!bet.isEmpty()){
			bet.remove(beta);
		}else{
			bet.add(new Bet(winner, factor, null));
		}
		
	}
	
	public void addBet(String carName, int betAmount, Player player) {
		for (Car car : this.race.getCars()) {
			if(car.getName().equals(carName)){
				bet.add(new Bet(car,betAmount,player));
			}
		}
	}
	
	public void raceStartRound(){
		race.raceStart();
		this.setWinner(this.race.getWinner());
	}

	public void betResult(){
		for(Bet bet:bet){
			bet.getWin(this.winner, this.factor);
		}
	}
	
	public String toString(){
		StringBuilder sb= new StringBuilder();
		sb.append("Rennen:\n");
		sb.append(this.race);
		sb.append("Wetten:\n");
		if(bet.size()>0){
		for(Bet bet:this.bet){
			sb.append(bet);
			sb.append("\n");
			
		}
		}else{
			sb.append("Keine Wetten");
		}
	return sb.toString();
	}
	
	public void sizeOfList() {
		this.player.size();
		System.out.println(this.player.size());
	}

	public int getFactor() {
	return factor;
	}

	public void setfactor(int factor) {
		this.factor = factor;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player) {
		this.player = player;
	}

	public List<Bet> getBet() {
		return bet;
	}

	public void setBet(List<Bet> bet) {
}
	public Car getWinner() {
		return winner;
	}
	public void setWinner(Car winner) {
		this.winner = winner;
	}

}