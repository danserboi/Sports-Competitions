import java.util.*;
/**
 * 
 * Aceasta clasa reprezinta o echipa. Implementeaza Observer (actualizeaza locul in clasament).
 * @author SERBOI FLOREA-DAN 325CB
 */
public abstract class Team implements Observer{
	/**
	 * Numele echipei.
	 */
	private String teamName;
	/**
	 * Genul jucatorilor.
	 */
	private String gender;
	/**
	 * Numarul jucatorilor.
	 */
	private int numberOfPlayers;
	/**
	 * Lista de jucatori.
	 */
	private ArrayList <Player> players;
	/**
	 * Locul echipei in clasament.
	 */
	private int place;
	/**
	 * constructor
	 * @param teamName echipa
	 * @param gender gen
	 * @param numberOfPlayers numar jucatori
	 */
	public Team(String teamName, String gender, int numberOfPlayers) {
		super();
		this.teamName = teamName;
		this.gender = gender;
		this.numberOfPlayers = numberOfPlayers;
		players = new ArrayList <Player>(numberOfPlayers);
		this.place = 0;
	}
	/**
	 * getter nume
	 * @return nume
	 */
	public String getTeamName() {
		return teamName;
	}
	/**
	 * getter gen
	 * @return gen
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * getter numar jucatori
	 * @return numar jucatori
	 */
	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}
	/**
	 * getter lista jucatori
	 * @return lista jucatori
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}
	/**
	 * actualizeaza locul in clasament
	 */
	public void update(int place)
	{
		this.place = place;
	}
	@Override
	public String toString() {
		return "{teamName: " + teamName + ", gender: " + gender + ", numberOfPlayers: " + numberOfPlayers
				+ ", players: " + players + "}";
	}
}
