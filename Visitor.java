/**
 * 
 * Interfata pentru entitatea Visitor din cadrul Design Pattern-ului Visitor.
 * @author SERBOI FLOREA-DAN 325CB
 */
public interface Visitor {
	/**
	 * visit pentru echipa de fotbal
	 * @param footballTeam echipa
	 * @return scor
	 */
	public double visit(FootballTeam footballTeam);
	/**
	 * visit pentru echipa de bascket
	 * @param basketballTeam echipa
	 * @return scor
	 */	
	public double visit(BasketballTeam basketballTeam);
	/**
	 * visit pentru echipa de handbal
	 * @param handballTeam echipa
	 * @return scor
	 */
	public double visit(HandballTeam handballTeam);
}
