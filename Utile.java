package mm1;

import java.util.Random;

public class Utile {
	//tirage aléa...
    private static Random rdm;
    public static double lambda;
    public static double mu;

    //Initialisation de Stats en renseignant mu, lambda et en creant le PRNG
    public static void init(double lambda, double mu) {
        Utile.lambda=lambda;
        Utile.mu = mu;
        Utile.rdm = new Random(java.time.LocalTime.now().toSecondOfDay());
    }

    //Fonction renvoyant la valeur de la v.a X, pour calculer les
    //inter-arrivees et la durée de service.
    private static double getx() {
        double x = rdm.nextDouble(0, 1);
        return x;
    }

    //Fonction renvoyant le temps d'arrivee du prochain client , en fonction
    //de l'arrivee du client precedent.
    //Pour une inter-arrivee on utilise lambda, et pour une duree de service
    //on utilise le parametre mu
    public static double getNextEventTime(double date, boolean arrivee) {
        double param = arrivee ? lambda : mu;
        double ndate = date + (-Math.log(1-getx()))/param;
        return ndate;
    }
}
