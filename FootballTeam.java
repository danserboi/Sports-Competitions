/**
 * 
 * Aceasta clasa reprezinta o echipa de fotbal. Se suprascrie metoda accept pentru un rezultat specific.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class FootballTeam extends Team implements Element{

	/**
	 * constructor
	 * @param teamName denumirea echipei
	 * @param gender genul
	 * @param numberOfPlayers numarul de jucatori
	 */
	public FootballTeam(String teamName, String gender, int numberOfPlayers) {
		super(teamName, gender, numberOfPlayers);
	}

    @Override
    public double accept(TeamVisitor visitor)  
    { 
        return visitor.visit(this); 
    } 
	
}
