package nl.sogyo;

public class BordItemInfo {

	private int aantalStenen;
	private int itemNr;
	
	public BordItemInfo(int stenen, int index) {
		aantalStenen = stenen;
		itemNr = index;
	}
	
	public int getAantalStenen(){
		return aantalStenen;
	}
	
	public int getItemNr() {
		return itemNr;
	}
	
}
