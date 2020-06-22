/**
 * 
 * Aceasta clasa reprezinta o echipa de baschet. Se suprascrie metoda accept
 * pentru un rezultat specific.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class BasketballTeam extends Team implements Element{

	/**
	 * @param teamName numele echipei
	 * @param gender genul
	 * @param numberOfPlayers numarul de jucatori
	 */
	public BasketballTeam(String teamName, String gender, int numberOfPlayers) {
		super(teamName, gender, numberOfPlayers);
	}

    @Override
    public double accept(TeamVisitor visitor)  
    { 
        return visitor.visit(this); 
    } 
}
