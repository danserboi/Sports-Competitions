/**
 * 
 * Aceasta clasa reprezinta contextul in care se executa o strategie.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class Context {
		/**
		 * strategie
		 */
	   private Strategy strategy;
	   /**
	    * constructor cu un parametru
	    * @param strategy strategie
	    */
	   public Context(Strategy strategy){
	      this.strategy = strategy;
	   }
	   /**
	    * Aceasta functie executa strategia.
	    * @param team echipa
	    * @return rezultatul operatiei
	    */
	   public double executeStrategy(Team team){
	      return strategy.doOperation(team);
	   }
	}
