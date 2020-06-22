/**
 * 
 * Interfata pentru entitatea Strategy din cadrul Design Pattern-ului Strategy.
 * @author SERBOI FLOREA-DAN 325CB
 */
public interface Strategy {
	/**
	 * Calculeaza scorul unei echipe
	 * @param team echipa
	 * @return scor
	 */
	public double doOperation(Team team);
}
