package myGame;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class GraficStart extends JFrame {

	public static void main(String[] args) {
		Race model= new RaceRound("Waldrennen",new ArrayList<Car>(),2);
		Grafic g= new Grafic(model);
		g.setTitle("Race");
		
		g.setVisible(true);
		
		
		
		

	}

}
