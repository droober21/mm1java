
public class MM1 {

	//Fonction réalisant la routine de simulation avec les paramètres souhaités
	private static void run(Ech ech, int t, boolean debug){
		//date de la prochaine arrivée
		double nva = 0;
		//date du prochain départ, initialisé à la date du premier départ
		double nvd = Utile.getNextEventTime(0,false);
		//booléen indiquant si on a atteint la fin du temps de simulation
		boolean end = false;
		//entier représentant le nombre de client dans la file
		int nbc = 0;

		while (!end) {
			//si la prochaine arrivée est avant le prochain départ
			//et qu'on a pas atteint la fin du temps de simulation
			//on calcule le prochain départ
			if (nva < nvd) {
				nbc++;
				Evt arr = ech.addclient(nva, nbc);
				Stats.arrClient(nva, nbc);
				if (debug)
					System.out.println("Date=" + nva
							+ " Arrivee client #" + arr.getnum());
				nva = Utile.getNextEventTime(nva, true);
				if (nva > t)
					end = true;
			}
			//Sinon le prochain départ est avant la prochaine arrivée
			else {
				nbc--;
				Evt last = ech.depclient(nvd);
				Stats.depClient(last.getdatea(),nvd);
				if (debug)
					System.out.println("Date=" + nvd +" Depart client #" +last.getnum()
							+ " arrive a t=" + last.getdatea());
				//S'il n'y a pas de client dans la file, le temps de service
				//commence à partir de l'arrivée du prochain client
				double debdep = (nbc == 0 ? nva : nvd);
				nvd = Utile.getNextEventTime(debdep, false);
			}
		}
		Stats.statsFin(t);
	}
	public static void main(String[] args) {

		if (args.length != 4) {
			System.out.println("Usage: java MM1 lambda mu t debug");
			return;
		}
		double lambda = Double.parseDouble(args[0]);
		double mu = Double.parseDouble(args[1]);
		int t = Integer.parseInt(args[2]);
		boolean debug = (Integer.parseInt(args[3]) == 0 ? false : true);

		Ech ech = new Ech();
		Utile.init(lambda, mu);

		//Début de la simulation
		run(ech, t, debug);

	}
}
