/**
 * 
 * Aceasta clasa creeaza orice echipa. Implementeaza Design Pattern-urile Singleton si Factory.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class TeamFactory {
	/**
	 * instanta fabricii
	 */
	private static TeamFactory instance;
    /**
     * Instanta trebuie sa fie unica.
     * @return instanta
     */
	public static TeamFactory getInstance() {
        if (TeamFactory.instance == null) {
            TeamFactory.instance = new TeamFactory();
        }

        return TeamFactory.instance;
    }
	/**
	 * constructor simplu
	 */
    private TeamFactory() {}
    /**
     * Functia creeaza orice tip de echipa.
     * @param teamType tip echipa
     * @param teamName nume echipa
     * @param gender genul jucatorilor
     * @param numberOfPlayers numarul jucatorilor
     * @return echipa creata
     */
    public Team createTeam(String teamType, String teamName, String gender, int numberOfPlayers) {
    	Team team = null;
    	if(teamType.equals("football")) {
    		team = new FootballTeam(teamName, gender, numberOfPlayers);
    	} else if(teamType.equals("basketball")) {
    		team = new BasketballTeam(teamName, gender, numberOfPlayers);
    	} else if(teamType.equals("handball")) {
    		team = new HandballTeam(teamName, gender, numberOfPlayers);
    	}
    	return team;
    }
}
