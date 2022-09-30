package mm1;

public class MM1 {

	private void run(int lambda, int mu, int t, int debug) {
		return;
	}
	//java MM1 lambda mu t debug
	public static void main(String[] args) {

		if (args.length != 4) {
			System.out.println("Usage: java MM1 lambda mu t debug");
			return;
		}
		Ech echeancier = new Ech();
		
		//Début de la simulation
		echeancier.addclient(0);
		
		double date0 = 0;
		System.out.println("0 : 0");
		for (int i = 0; i<5 ; i++) {
			double t = Stats.getNexta(date0);
			System.out.println(i+":"+t);
			date0 = t;
		}
	}
}
