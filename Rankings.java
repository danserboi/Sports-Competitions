import java.util.ArrayList;
/**
 * 
 * Aceasta clasa reprezinta clasamentul echipelor. Echipele observa clasamentului. Vor sa afle pe ce loc sunt.
 * Pentru o echipa, acelasi index este folosit si pentru locul in clasament, si pentru punctaj
 * Deci informatiile pentru o echipa se gasesc la acelasi index, indiferent de lista.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class Rankings implements Subject{
	/**
	 * Echipele observa cum evolueaza clasamentul. Vor sa vada pe ce loc sunt.
	 */
	private ArrayList<Team> observers;
	/**
	 * Lista cu locurile din clasament ale fiecarei echipe.
	 */
	private ArrayList<Integer> ranks;
	/**
	 * Lista cu punctajele fiecarei echipe.
	 */
	private ArrayList<Integer> competitionScores;
	/**
	 * constructorul instantiaza cele 3 liste
	 */
	public Rankings() {
		super();
		this.observers = new ArrayList<Team>();
		this.ranks = new ArrayList<Integer>();
		this.competitionScores = new ArrayList<Integer>();
	}
	/**
	 * inregistreaza un observator
	 */
	public void registerObserver(Team observer) {
		observers.add(observer);
	}
	/**
	 * notifica fiecare observator. Astfel, echipele sunt instiintate de locul pe care il ocupa dupa un meci.
	 */
	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = observers.get(i);
			observer.update(ranks.get(i));
		}
	}
	/**
	 * adauga un loc in clasament (odata cu o noua echipa)
	 * @param rank loc
	 */
	public void addRank(int rank) {
		ranks.add(rank);
	}
	/**
	 * adauga un scor in clasament (odata cu o noua echipa)
	 * @param competitionScore punctaj
	 */
	public void addCompetitionScore(int competitionScore) {
		competitionScores.add(competitionScore);
	}
	/**
	 * Functia intoarce locul care se cuvine unui anumit punctaj
	 * @param competitionScore punctaj
	 * @return loc
	 */
	public int calculateRank(int competitionScore)
	{
		int rank = 1;
		for(int score : competitionScores)
		{
			if(score > competitionScore)
				rank++;
		}
		return rank;
	}
	/**
	 * Functia actualizeaza locurile din clasament.
	 */
	public void updateRank() {
		for(int i = 0; i <= competitionScores.size() - 1; i++) {
			ranks.set(i, calculateRank(competitionScores.get(i)));
		}
	}
	/**
	 * La un anumit index, este setat un nou punctaj.
	 * @param competitionScore punctaj
	 * @param index int
	 */
	public void setCompetitionScore(int competitionScore, int index) {
		competitionScores.set(index, competitionScore);
	}
	/**
	 * Getter pentru punctajul de la un anume index.
	 * @param index int
	 * @return int
	 */
	public int getCompetitionScore(int index) {
		return competitionScores.get(index);
	}
	/**
	 * Functia construieste un string formatat cu primele 3 locuri din clasament si cu locurile pe care le ocupa fiecare echipa.
	 * @return string-ul formatat
	 */
	String result() {
		StringBuilder sb = new StringBuilder();
		Team max1 = null, max2 = null, max3 = null;
		for(int i = 0; i <= ranks.size() - 1; i++) {
			if(ranks.get(i) == 1)
				max1 = observers.get(i);
			if(ranks.get(i) == 2)
				max2 = observers.get(i);
			if(ranks.get(i) == 3)
				max3 = observers.get(i);
		}
		if(max1 != null)
			sb.append(max1.getTeamName() + "\n");
		if(max2 != null)
			sb.append(max2.getTeamName() + "\n");
		if(max3 != null)
			sb.append(max3.getTeamName() + "\n");
		for(int i = 0; i <= ranks.size() - 1; i++) {
			sb.append("Echipa " + observers.get(i).getTeamName() + " a ocupat locul " + ranks.get(i) + "\n");
		}
		return sb.toString();
	}
}
