package myGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Grafic extends GraficStart {
	Container c;
	JButton button;
	JPanel pnlLeft,pnlTest;
	JTable table;
	JScrollPane scrollTabelle;
	Player player;
	JLabel header;
	JButton btnInfo;
	JButton btnAdd;
	JProgressBar progBar;
	JLabel auto, leistung, preis, nummer, rennen, runde,strecke,stop;
	JTextField autoText, nummerText, rennenText;
	JPanel pnlAdd;
	JSpinner spinPreis, spinLeistung, spinRunde,spinStrecke;
	Race model;
	JButton btnStart;
	JComboBox rennenArt;
	JInternalFrame jf;
	JButton btnStop;
	
	

	public Grafic(Race model) {
		this.model = model;
		createWidgets();
		addWidgets();
		pack();
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setSize(600, 400);
		addWindowListener(new MyWindowListener());
	}

	public void createWidgets() {
		// Header erstellen
		header = new JLabel("Auto Manager");
		header.setBackground(Color.BLACK);
		header.setOpaque(true);// hintergrund wird durchsichtig->true
		header.setForeground(Color.WHITE);
		header.setHorizontalAlignment(header.CENTER);// Schrift with horizontal
														// zentriert->in zentrum
														// schieben
		header.setFont(header.getFont().deriveFont(Font.BOLD + Font.ITALIC, 30));// generiert
																					// schriftart
																					// automatisch
		// ProgressBar erstellen
		progBar = new JProgressBar(0, 100);
		progBar.setPreferredSize(new Dimension(0, 20));

		// Tabelle im Zentrum erstellen mit ScrollPane
		table = new JTable(model);
		table.setAutoCreateRowSorter(true);
		scrollTabelle = new JScrollPane(table);

		// Info-Button erstellen
		btnInfo = new JButton("Information");
		btnInfo.setAlignmentX(LEFT_ALIGNMENT);

		// Neues Panel erstellen
		pnlAdd = new JPanel();
		pnlAdd.setLayout(new GridLayout(0, 2, 5, 5));

		// Links neues Panel erstellen
		pnlLeft = new JPanel();
		pnlLeft.setLayout(new BoxLayout(pnlLeft, BoxLayout.PAGE_AXIS));

		auto = new JLabel("Auto");
		autoText = new JTextField();

		leistung = new JLabel("Leistung");
		spinLeistung = new JSpinner();

		preis = new JLabel("Preis");
		spinPreis = new JSpinner();

		nummer = new JLabel("Nummer");
		nummerText = new JTextField();

		rennen = new JLabel("Rennen");
		rennenText = new JTextField();

		runde = new JLabel("Runde");
		spinRunde = new JSpinner();

		btnAdd = new JButton("Hinzufügen");
		btnAdd.setEnabled(false);

		btnStart = new JButton("Starten");
		btnStart.setEnabled(false);
		
		strecke=new JLabel("Strecke");
		spinStrecke= new JSpinner();
		//ComboBox für rennenart
		rennenArt= new JComboBox(new Object []{"Distanzrennen","Rundenrennen"});
		rennenArt.setBounds(70,120,90,25  );
		
		
		btnStop=new JButton("Stop");
		btnStop.setPreferredSize(new Dimension(60, 5));
		btnStop.setEnabled(false);
		
		pnlTest= new JPanel();
		pnlTest.setBackground(Color.BLACK);
		pnlTest.setLayout(new BoxLayout(pnlTest, BoxLayout.PAGE_AXIS));

	}

	public void addWidgets() {
		c = getContentPane();
		c.setLayout(new BorderLayout(5, 5));
		c.add(BorderLayout.PAGE_START, header);
		c.add(BorderLayout.SOUTH, progBar);
		c.add(BorderLayout.CENTER, scrollTabelle);
		c.add(BorderLayout.LINE_START, pnlLeft);
		c.add(BorderLayout.SOUTH, btnStart);
		c.add(BorderLayout.AFTER_LINE_ENDS,btnStop);
		// In Panel hinzufügen
		pnlAdd.add(auto);
		pnlAdd.add(autoText);

		pnlAdd.add(leistung);
		pnlAdd.add(spinLeistung);

		pnlAdd.add(preis);
		pnlAdd.add(spinPreis);

		pnlAdd.add(nummer);
		pnlAdd.add(nummerText);

		
		
//		pnlAdd.add(strecke);
//		pnlAdd.add(spinStrecke);
//		
//		pnlAdd.add(runde);
//		pnlAdd.add(spinRunde);
//		
//		pnlAdd.add(rennen);
//		pnlAdd.add(rennenText);
//		
//		pnlAdd.add(rennenArt);




		pnlAdd.add(Box.createVerticalGlue());
		pnlAdd.add(btnAdd);
		

		// Bevrzugte größe für pnlAdd Komponenten
		pnlAdd.setMaximumSize(pnlAdd.getPreferredSize());
		pnlAdd.setAlignmentX(LEFT_ALIGNMENT);

		// pnlAdd Komponenten im Linken panel hinzufügen
		pnlLeft.add(pnlAdd);
		pnlLeft.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
		pnlLeft.add(Box.createVerticalGlue());
		pnlLeft.add(btnInfo);

		btnAdd.addActionListener(new AddAutoAction());
		autoText.addCaretListener(new AutoListener());
		btnStart.addActionListener(new AddAutoRennenAction());
		btnStop.addActionListener(new StopAutoRennenAction() );

	}

	private class AddAutoAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// Text aus autoText bekommen
			String auto = autoText.getText();
			// Leistung aus spinLeistung in Integer casten
			int leistung = (Integer) spinLeistung.getValue();
			// Preis aus spinPreis in Integer casten
			int preis = (Integer) spinPreis.getValue();
//			//selektierte rennArt
//			String renn= rennenArt.getSelectedItem().toString();
//			//name des rennens
//			String rName = rennenText.getText();
//			//strecke des Rennens
//			int strecke=(Integer) spinStrecke.getValue();
//			//runde des Rennens
//			int runde=(Integer) spinRunde.getValue();
			Car car = new Car(auto, leistung, preis);
			model.addtoList(car);
			
			
//			if(renn.equals("Distanzrennen")){
//				RaceDistance rd= new RaceDistance(rName,strecke);
//				Car car = new Car(auto, leistung, preis);
//				rd.addtoList(car);
//				model.addtoList(car);
//			}else if(renn.equals("Rundenrennen")){
//				RaceRound rr=new RaceRound(rName,runde);
//				Car car = new Car(auto, leistung, preis);
//				rr.addtoList(car);
//				model.addtoList(car);
//			}
			
			
			if (model.cars.size() < 0) {
				btnStart.setEnabled(false);
				btnStop.setEnabled(false);

			} else {
				btnStart.setEnabled(true);
				btnStop.setEnabled(true);

			}

		}

	}

	//Rennen stoppen
	private class StopAutoRennenAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			model.endRacee();
			
		}
		
	}
	
	// Rennen starten
	private class AddAutoRennenAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			((RaceRound) model).raceStartWithRound();

		}

	}

	private class AutoListener implements CaretListener {

		public void caretUpdate(CaretEvent e) {
			// Text vom Feld bekommen mit getSource() auf JTextField casten
			JTextField fld = (JTextField) e.getSource();
			String text = fld.getText();
			
			
			// Wenn text leer ode rleerzeichen am anfang
			if (text.trim().isEmpty()) {
				btnAdd.setEnabled(false);
			} else {
				btnAdd.setEnabled(true);
			}

		}

	}

	class MyWindowListener extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent arg0) {
			System.exit(0);

		}

	}

}
