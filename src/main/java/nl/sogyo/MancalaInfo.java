package nl.sogyo;

import java.util.ArrayList;
import nl.sogyo.mancala.*;

public class MancalaInfo {
	
	private Vakje eersteVakje;
	private ArrayList<Speler> spelerLijst = new ArrayList<>();
	private ArrayList<BordItemInfo> speler1VakjeInfoLijst;
	private ArrayList<BordItemInfo> speler2VakjeInfoLijst;
	private BordItemInfo speler1kalaha;
	private BordItemInfo speler2kalaha;
	private Message message;
	
	MancalaInfo(Vakje beginVakje){
		eersteVakje = beginVakje;
		spelerLijst.add(eersteVakje.geefEigenaar());
		spelerLijst.add(eersteVakje.vindKalaha().geefVolgende().geefEigenaar());
		updateInfo();
	}
	
	public Message getMessage() {  
		return message;
	}
	
	ArrayList<Speler> getSpelerLijst(){
		return spelerLijst;
	}
	
	BordItem geefBordItem(int index) {
		return eersteVakje.geefVolgende(index);		
	}
	
	public ArrayList<BordItemInfo> getVakjeInfoLijst(Speler speler){
		if(spelerLijst.get(0).equals(speler)) {
			return speler1VakjeInfoLijst;
		}
		return speler2VakjeInfoLijst;
	}
	
	public BordItemInfo getKalahaInfo(Speler speler) {
		if(spelerLijst.get(0).equals(speler)) {
			return speler1kalaha;
		}
		return speler2kalaha;
	}
	
	public void updateInfo() {
		updateVakjeInfoLijsten(); 
		updateKalahaInfos(); // gebruikt lengte infolijsten
		updateMessage();
	}
	
	private void updateMessage() {
		Speler speler1 = spelerLijst.get(0);
		Speler speler2 = spelerLijst.get(1);
		message = new Message(speler1.isAanDeBeurt(),speler1.isWinaar(), speler2.isWinaar());
	}
	
	private void updateVakjeInfoLijsten(){
		speler1VakjeInfoLijst = maakVakjeInfoLijst(0);
		speler2VakjeInfoLijst = maakVakjeInfoLijst(speler1VakjeInfoLijst.size()+1);
	}
	
	private void updateKalahaInfos(){
		Kalaha kalaha1 = eersteVakje.vindKalaha();
		Kalaha kalaha2 = eersteVakje.vindKalaha().geefVolgende().vindKalaha();
		int positieKalaha2 = speler1VakjeInfoLijst.size() + 1 + speler2VakjeInfoLijst.size();
		speler1kalaha = new BordItemInfo(kalaha1.getAantalStenen(),speler1VakjeInfoLijst.size());
		speler2kalaha = new BordItemInfo(kalaha2.getAantalStenen(),positieKalaha2);
	}
	
	
	private ArrayList<BordItemInfo> maakVakjeInfoLijst(int vakjeIndex) {
		ArrayList<BordItemInfo> vakjeLijst = new ArrayList<>();
		for(int i = vakjeIndex; eersteVakje.geefVolgende(i) instanceof Vakje; i++) {
			BordItemInfo itemInfo = new BordItemInfo(eersteVakje.geefVolgende(i).getAantalStenen(),i);
			vakjeLijst.add(itemInfo);
		}
		return vakjeLijst;
	}

}
