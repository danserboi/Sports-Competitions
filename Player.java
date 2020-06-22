/**
 * 
 * Aceasta clasa reprezinta un jucator.
 * Se suprascrie metoda toString pentru a afisa dupa formatul dorit.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class Player {
	/**
	 * numele jucatorului
	 */
	private String name;
	/**
	 * scorul jucatorului
	 */
	private int score;
	/**
	 * @param name numele jucatorului
	 * @param score scorul jucatorului
	 */
	public Player(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	@Override
	public String toString() {
		return "{name: " + name + ", score: " + score + "}";
	}
}
