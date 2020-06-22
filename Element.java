/**
 * 
 * Interfata pentru Element, entitate din Design Pattern-ul Visitor.
 * @author SERBOI FLOREA-DAN 325CB
 */
public interface Element {
	/**
	 *
	 * @param visitor vizitator
	 * @return scor
	 */
	public double accept(TeamVisitor visitor); 
}
