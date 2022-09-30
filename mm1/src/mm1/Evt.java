package mm1;

public class Evt {
	//date, arrivée/départ
	private double datea;
	private double dated;
	//0 pour arrivée, 1 pour départ
	private int num;
	private int etat;
	private static int nbclient = 0;
	
	//arrivée d'un client
	public Evt(double date) {
		this.datea = date;
		this.etat = 0;
		this.num = Evt.nbclient;
		Evt.nbclient++;
	}

	//Depart d'un client
	public void depart(double date) {
		this.etat = 1;
		this.dated = date;
	}
	
	public double getdatea() {
		return this.datea;
	}
	public double getdated() {
		return this.dated;
	}
	public int getnum() {
		return this.num;
	}
	public int getetat() {
		return this.etat;
	}
}
