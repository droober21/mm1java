package mm1;
import java.lang.Math;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Random;

public class Stats {
	//ts les calculs
	private static Random rdm;
	public static int lambda;
	public static int mu;
	
	public static void init(int lambda, int mu) {
		Stats.lambda=lambda;
		Stats.mu = mu;
		Stats.rdm = new Random(java.time.LocalTime.now().toSecondOfDay());
	}
	
	public static double getx() {
		double r = rdm.nextDouble(0, 1);
		double x = (-1/lambda)*Math.log(1-r);
		return x;
	}
	
	public static double getNexta(double datea) {
		double dated = datea + (-Math.log(1-getx()))/lambda;
		return dated;
	}
}
