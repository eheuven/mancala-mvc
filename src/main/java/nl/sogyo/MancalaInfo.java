package nl.sogyo;

import nl.sogyo.mancala.Speler;
import nl.sogyo.mancala.Vakje;

public class MancalaInfo {
	
	Vakje eersteVakje;

	MancalaInfo(Vakje beginVakje){
		eersteVakje = beginVakje;
	}
	
	public Message getMessage() {
		   
		Speler speler1 = eersteVakje.geefEigenaar();
		Speler speler2 = eersteVakje.vindKalaha().geefVolgende().geefEigenaar();
		Message message = new Message(speler1.isAanDeBeurt(),speler1.isWinaar(), speler2.isWinaar());
		   
		return message;
	}
	
}
