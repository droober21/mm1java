
import java.util.LinkedList;

//Classe représentant l'échéancier
public class Ech {
	//linked list pr les events
	private LinkedList<Evt> events = new LinkedList<Evt>();

	private int nbmaxc = 0;

	//Fonction créant un événement et l'ajoutant à la file avec optimisation mémoire
	//datea : date d'arrivée du client
	//nbc : nombre de clients après l'ajout dans la file
	public Evt addclient(double datea, int nbc) {
		if (nbc>nbmaxc) {
			Evt nv = new Evt(datea);
			events.add(nv);
			nbmaxc++;
		}
		else {
			Evt nv = events.get(nbc-1);
			//utile pour les stats et le numéro du client
			Evt.newclient(nv);
			nv.setdatea(datea);
		}
		//si le client n'attend pas
		if (nbc == 1)
			Stats.cpasatt();
		return events.get(nbc-1);
	}

	//Fonction faisant partir un client de la file avec optimisation mémoire
	//
	public Evt depclient(double dated) {
		Evt dep = events.pop();
		dep.setdated(dated);
		events.add(dep);
		return dep;
	}
	public boolean isEmpty() {
		return events.isEmpty();
	}

	public Evt getLastClient(){
		return events.getLast();
	}

	public int getNbClient(){
		return events.size();
	}
}
