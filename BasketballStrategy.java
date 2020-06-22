/**
 * 
 * Aceasta este clasa Strategy care implementeaza operatia care calculeaza 
 * scorul unei echipe de bascket.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class BasketballStrategy implements Strategy{
	/**
	 * Functia calculeaza scorul unei echipe de baschet.
	 * @param team echipa
	 * @return returneaza scorul
	 */
	public double doOperation(Team team) {
		double score = 0;
		Player currentPlayer = null;
		for(int i = 0; i <= team.getPlayers().size() - 1; i++) {
			currentPlayer = team.getPlayers().get(i);
			score += currentPlayer.getScore();
		}
		score /= team.getPlayers().size();
		return score;
	}
}
