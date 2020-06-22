/**
 * 
 * Aceasta este clasa Strategy care implementeaza operatia care calculeaza scorul unei echipe de fotbal.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class FootballStrategy implements Strategy{
	/**
	 * Functia calculeaza scorul unei echipe de fotbal.
	 * @param team echipa
	 * @return returneaza scorul
	 */
	public double doOperation(Team team) {
		 double score = 0; 
	        if(team.getGender().equals("masculin")) {
	        	Player currentPlayer = null;
	        	int max = team.getPlayers().get(0).getScore();
	        	for(int i = 0; i <= team.getPlayers().size() - 1; i++) {
	        		currentPlayer = team.getPlayers().get(i);
	        		if(currentPlayer.getScore() > max)
	        			max = currentPlayer.getScore();
	        		score += currentPlayer.getScore();
	        	}
	        	score += max;
	        }
	        else {
	        	Player currentPlayer = null;
	        	int min = team.getPlayers().get(0).getScore();;
	        	for(int i = 0; i <= team.getPlayers().size() - 1; i++) {
	        		currentPlayer = team.getPlayers().get(i);
	        		if(currentPlayer.getScore() < min)
	        			min = currentPlayer.getScore();
	        		score += currentPlayer.getScore();
	        	}
	        	score += min;        	
	        }
	        return score;
	}
}
