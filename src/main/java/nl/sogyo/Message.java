package nl.sogyo;

public class Message {
	
	private String message;
	private boolean winnaar1;
	private boolean winnaar2;
	private boolean speler1Beurt;
	
	public String getMessage(){
		return message;
	}

	void setSpeler1Beurt(boolean beurt) {
		speler1Beurt = beurt;
	}
	
	void setWinnaars(boolean win1, boolean win2) {
		winnaar1 = win1;
		winnaar2 = win2;
	}
	
	void maakMessage() {	
		if(winnaar1 && winnaar2) {
			message = "Gelijk spel!";
		}else if(winnaar1) {
			message = "Speler 1 heeft gewonnen!";
		}else if(winnaar2) {
			message = "Speler 2 heeft gewonnen!";
		}else if(speler1Beurt) {
			message = "Speler 1 (bovenkant) is aan de beurt";
		}else {
			message = "Speler 2 (onderkant) is aan de beurt";
		}
	}
	
}
