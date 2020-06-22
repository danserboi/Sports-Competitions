import java.util.ArrayList;
/**
 * 
 * Aceasta clasa trateaza competitia. Se desfasoara meciurile si se actualizeaza
 * clasamentul.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class Competition {
	/**
	 * tipul competitiei: de fotbal, baschet sau handbal
	 */
	private String type;
	/**
	 * genul participantilor la competitie: feminin sau masculin
	 */
	private String gender;
	/**
	 * echipele participante
	 */
	private ArrayList <Team> teams;
	/**
	 * clasamentul echipelor
	 */
	private Rankings clasament;
	/**
	 * @param type tipul competitiei
	 * @param gender genul participantilor
	 */
	public Competition(String type, String gender) {
		this.type = type;
		this.gender = gender;
		this.teams = new ArrayList <Team>();
		this.clasament = new Rankings();
	}
	/**
	 * Adauga o echipa in competitie, si, implicit, in clasament.
	 * @param team echipa
	 */
	public void addTeam(Team team)
	{
		if(gender.equals(team.getGender())) {
			teams.add(team);
			clasament.registerObserver(team);
			clasament.addRank(teams.size());
			clasament.addCompetitionScore(0);
		}
	}
	/**
	 * In aceasta functie sunt tratate meciurile si, implicit, rezultatul lor
	 * care are un impact asupra clasamentului.
	 */
	public void matches()
	{
		TeamVisitor visitor = new TeamVisitor();
		for(int i = 0; i <= teams.size() - 2; i++) {
			for(int j = i + 1; j <= teams.size() - 1; j++) {
				double score1 = 0, score2 = 0;
				if( teams.get(0) instanceof FootballTeam ) {
					FootballTeam team1 = (FootballTeam)teams.get(i);
					score1 = team1.accept(visitor);
					FootballTeam team2 = (FootballTeam)teams.get(j);
					score2 = team2.accept(visitor);
				}
				if( teams.get(0) instanceof BasketballTeam ) {
					BasketballTeam team1 = (BasketballTeam)teams.get(i);
					score1 = team1.accept(visitor);
					BasketballTeam team2 = (BasketballTeam)teams.get(j);
					score2 = team2.accept(visitor);
				}
				if( teams.get(0) instanceof HandballTeam ) {
					HandballTeam team1 = (HandballTeam)teams.get(i);
					score1 = team1.accept(visitor);
					HandballTeam team2 = (HandballTeam)teams.get(j);
					score2 = team2.accept(visitor);
				}
				if(Math.abs(score1 - score2) < 0.00001) {
					clasament.setCompetitionScore(clasament.getCompetitionScore(i) + 1, i);
					clasament.setCompetitionScore(clasament.getCompetitionScore(j) + 1, j);
				}
				else if(score1 > score2)	
					clasament.setCompetitionScore(clasament.getCompetitionScore(i) + 3, i);
				else 
					clasament.setCompetitionScore(clasament.getCompetitionScore(j) + 3, j);
				clasament.updateRank();
				clasament.notifyObservers();
			}
		}
	}
	/**
	 * getter pentru clasament
	 * @return clasament
	 */
	public Rankings getClasament() {
		return clasament;
	}
	
}