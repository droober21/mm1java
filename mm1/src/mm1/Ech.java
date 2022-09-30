package mm1;
import java.util.Calendar;
import java.time.LocalTime;
import java.util.LinkedList;

public class Ech {
	//linked list pr les events
	
	private LinkedList<Evt> events;
	public Ech() {
		events = new LinkedList<Evt>();
	}
	
	public void addclient(double datea) {
		events.add(new Evt(datea));
		System.out.println("Date=" + datea
				+ " Arrivee client #" + events.getLast().getnum());
	}
	
	public void depclient(double dated) {
		System.out.println("Date=" + dated +" Depart client #"+ 
				events.getFirst().getnum() + " arrive a t="
				+ events.getFirst().getdatea());
		events.removeFirst();
	}
}
