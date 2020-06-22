JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	BasketballStrategy.java \
	BasketballTeam.java \
	Competition.java \
	Context.java \
	Element.java \
	FootballStrategy.java \
	FootballTeam.java \
	HandballStrategy.java \
	HandballTeam.java \
	Main.java \
	Observer.java \
	Player.java \
	Rankings.java \
	Strategy.java \
	Subject.java \
	TeamFactory.java \
	Team.java \
	TeamVisitor.java \
	Visitor.java

default:  classes

classes: $(CLASSES:.java=.class)

run: classes
	java Main ${COMANDA} ${IN1} ${IN2} ${OUT}
clean:
	$(RM) *.class
