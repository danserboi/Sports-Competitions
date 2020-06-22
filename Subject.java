/**
 * 
 * Interfata pentru entitatea Subject din cadrul Design Pattern-ului Observer
 * @author SERBOI FLOREA-DAN 325CB
 */
public interface Subject {
	/**
	 * inregistreaza un observator
	 * @param observer echipa
	 */
	public void registerObserver(Team observer);
	/**
	 * notifica observatorii (echipele)
	 */
	public void notifyObservers();
}