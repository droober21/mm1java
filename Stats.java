package mm1;

import java.util.ArrayList;

public class Stats {
	//ts les calculs

	//nombre de clients sans attente
	private static double csatt = 0;
	//temps total de sejour des clients
	private static double totsj = 0;
	//temps du dernier evenement
	private static double tclient = 0;
	//Tableau des temps cumulees selon le nombre de client dans le systeme
	private static ArrayList<Double> tc = new ArrayList<Double>();

	//Fonction appelée par Ech lorsqu'un client n'attend pas dans la file
	public static void cpasatt() {
		csatt++;
	}

	public static void arrClient(double datea, int nbclient) {
		//Mise à jour du temps pour la moyenne de clients dans le système
		if (tc.size() < nbclient) {
			tc.add(datea - tclient);
		} else {
			tc.set(nbclient - 1, tc.get(nbclient - 1) + datea - tclient);
		}
		tclient = datea;
	}

	//Fonction traitant le depart d'un client au niveau stats
	public static void depClient(double datea, double dated) {
		totsj += dated - datea;
	}

	public static void statsFin(int time) {
		System.out.println("-----------------------\nRESULTATS THEORIQUES\n-----------------------");
		if (Utile.lambda < Utile.mu) {
			System.out.println("lambda<mu : file stable");
		} else {
			System.out.println("lambda>mu : file instable !");
		}
		System.out.println("ro : " + Utile.lambda/ Utile.mu);
		System.out.println("Nombre de clients attendus : " + time*Utile.lambda);
		System.out.println("Prob de service sans attente : " + (1-Utile.lambda/Utile.mu));
		System.out.println("Prob file occupee : " + Utile.lambda/Utile.mu);
		System.out.println("Debit : " + Utile.lambda);
		System.out.println("Esp nb clients : "+(Utile.lambda/Utile.mu)/(1-(Utile.lambda/Utile.mu)));
		System.out.println("Temps moyen de sejour : " + 1/(Utile.mu*(1-Utile.lambda/Utile.mu)));

		System.out.println("-----------------------\nRESULTATS SIMULATION\n-----------------------");
		System.out.println("Nombre total de clients : " + Evt.nbclient);
		System.out.println("Proportion clients sans attente : " + csatt/Evt.nbclient);
		System.out.println("Proportion clients avec attente : " + (1-csatt/Evt.nbclient));
		System.out.println("Debit : "+Evt.nbclient/tclient);
		double nbcm = 0;
		for (int i = 1 ; i<tc.size(); i++ ) {
			nbcm += i*tc.get(i);
		}
		System.out.println("Nb moyen de clients dans systeme : " + nbcm/tclient);
		System.out.println("Temps moyen de sejour : " + totsj/Evt.nbclient);
	}
}