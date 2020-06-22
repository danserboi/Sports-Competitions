/**
 * 
 * Aceasta este clasa Strategy care implementeaza operatia care calculeaza scorul unei echipe de handbal.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class HandballStrategy implements Strategy{
	/**
	 * Functia calculeaza scorul unei echipe de handbal.
	 * @param team echipa
	 * @return returneaza scorul
	 */
	public double doOperation(Team team) {
    	double score = 0;
        if(team.getGender().equals("masculin")) {
        	Player currentPlayer = null;
        	for(int i = 0; i <= team.getPlayers().size() - 1; i++) {
        		currentPlayer = team.getPlayers().get(i);
        		score += currentPlayer.getScore();
        	}
        }
        else {
        	score = 1;
        	Player currentPlayer = null;
        	for(int i = 0; i <= team.getPlayers().size() - 1; i++) {
        		currentPlayer = team.getPlayers().get(i);
        		score *= currentPlayer.getScore();
        	}      	
        }
    	return score;
	}
}
