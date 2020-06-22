/**
 * 
 * Aceasta clasa reprezinta o echipa de handbal. Se suprascrie metoda accept pentru un rezultat specific.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class HandballTeam extends Team implements Element{

	/**
	 * constructor
	 * @param teamName denumirea echipei
	 * @param gender genul
	 * @param numberOfPlayers numarul de jucatori
	 */
	public HandballTeam(String teamName, String gender, int numberOfPlayers) {
		super(teamName, gender, numberOfPlayers);
	}
    @Override
    public double accept(TeamVisitor visitor)  
    { 
        return visitor.visit(this); 
    } 
}
