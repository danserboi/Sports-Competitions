/**
 * 
 * Aceasta clasa este responsabila de calcularea scorului unei echipe.
 * Sunt folosite Design Pattern-urile Visitor si Strategy.
 * Functia visit este supraincarcata pentru fiecare tip de echipa deoarece calculul scorului se face diferit.
 * @author SERBOI FLOREA-DAN 325CB
 */
public class TeamVisitor implements Visitor{
    
	@Override
    public double visit(FootballTeam footballTeam) 
    { 
		Context context = new Context(new FootballStrategy());
		return context.executeStrategy(footballTeam);
    }
    @Override
	public double visit(BasketballTeam basketballTeam) {
		Context context = new Context(new BasketballStrategy());
		return context.executeStrategy(basketballTeam);
    }
    @Override
    public double visit(HandballTeam handballTeam) {
		Context context = new Context(new HandballStrategy());
		return context.executeStrategy(handballTeam);
    }
}
