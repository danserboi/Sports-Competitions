import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
/**
 * Aceasta este clasa main. Se citesc echipele din fisier, se citesc echipe angrenate in competitie, se desfasoara meciurile
 * si se scrie in fisierul rezultatul final, formatat dupa cerinta.
 * @author SERBOI FLOREA-DAN 325CB
 *
 */
public class Main {
	/**
	 * Metoda main este cea principala unde se citeste din cele 2 fisiere si scrie in fisierul de output rezultatul cerut.
	 * @param args argumentul functiei main
	 * @throws Exception arunc exceptiile.
	 */
	public static void main(String[] args) throws Exception{		
		File inputTeams = new File(args[1]);
		BufferedReader bufferTeams = new BufferedReader(new FileReader(inputTeams));
		File output = new File(args[3]);
	    PrintWriter printWriter = new PrintWriter(output);
	    // liste specifice fiecarui tip de echipa
	    ArrayList<FootballTeam> footballTeams = new ArrayList<FootballTeam>();
	    ArrayList<BasketballTeam> basketballTeams = new ArrayList<BasketballTeam>();
	    ArrayList<HandballTeam> handballTeams = new ArrayList<HandballTeam>();
	    // instantiem "creatorul" de echipe
	    TeamFactory teamFactory = TeamFactory.getInstance();
	    String line;
	    String[] fields;
	    // citim echipele pe care le adaugam in lista tipului lor
	    while ((line = bufferTeams.readLine()) != null) {
			fields = line.split(", ");
			if(fields.length == 4) {
				int noPlayers = Integer.parseInt(fields[3]);
				//cream o echipa
				Team team = teamFactory.createTeam(fields[0], fields[1], fields[2], noPlayers);
				if(fields[0].equals("football"))
					footballTeams.add((FootballTeam)team);
				if(fields[0].equals("basketball"))
					basketballTeams.add((BasketballTeam)team);
				if(fields[0].equals("handball"))
					handballTeams.add((HandballTeam)team);
				// adaugam jucatorii
				for(int i = 0; i < noPlayers; i++) {
					line = bufferTeams.readLine();
					fields = line.split(", ");
					team.getPlayers().add(new Player(fields[0], Integer.parseInt(fields[1])));
				}
				// tratam separat cazul inscriere, afisand formatat dupa cerinta
				if(args[0].equals("inscriere"))
					printWriter.println(team);
			}
		}
	    bufferTeams.close();
	    // tratam separat cazul competie: se desfasora meciurile echipelor angrenate in competitie
	    // la sfarsit, afisam rezultatul cu locurile echipelor, dupa cerinta
	    if(args[0].equals("competitie")) {
			// se citesc din cel de-al doilea fisier tipul competitiei si apoi echipele angrenate
	    	File inputComp = new File(args[2]);
			BufferedReader bufferComp = new BufferedReader(new FileReader(inputComp));
			line = bufferComp.readLine();
			fields = line.split(", ");
			Competition competition = new Competition(fields[0], fields[1]);    
			while ((line = bufferComp.readLine()) != null) {
				// daca echipa respecta tipul competitiei si se regaseste in lista, este adaugata
				if(fields[0].equals("football"))
					for(FootballTeam currentTeam : footballTeams) 
						if(line.equals(currentTeam.getTeamName()))
							competition.addTeam(currentTeam);
				if(fields[0].equals("basketball"))
					for(BasketballTeam currentTeam : basketballTeams)
						if(line.equals(currentTeam.getTeamName()))
							competition.addTeam(currentTeam);							
				if(fields[0].equals("handball"))
					for(HandballTeam currentTeam : handballTeams)
						if(line.equals(currentTeam.getTeamName()))
							competition.addTeam(currentTeam);
			}
			// se desfasoara meciurile
			competition.matches();
			// se afiseaza rezultatul
			printWriter.print(competition.getClasament().result());
			bufferComp.close();
		}
	    printWriter.close();
	}
}
