package nl.sogyo;

public class BordItemInfo {

	private int aantalStenen;
	private int itemNr;
	
	public int getAantalStenen(){
		return aantalStenen;
	}
	
	public int getItemNr() {
		return itemNr;
	}
	
	void setAantalStenen(int stenen) {
		aantalStenen = stenen;
	}
	
	void setItemNr(int nr) {
		itemNr = nr;
	}
	
}
