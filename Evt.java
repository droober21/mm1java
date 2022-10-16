package mm1;

public class Evt {
	//date, arrivée/départ
	private double datea, dated;
	//numéro de l'événement
	private int num;
	public static int nbclient = 0;

	//arrivée d'un client
	public Evt(double date) {
		this.datea = date;
		this.num = Evt.nbclient++;
	}

	public static void newclient(Evt evt){
		evt.num = Evt.nbclient++;
	}
	public double getdatea() {
		return this.datea;
	}
	public int getnum() {
		return this.num;
	}

	public void setdated(double dated){
		this.dated = dated;
	}
	public void setdatea(double datea){
		this.datea = datea;
	}
}
