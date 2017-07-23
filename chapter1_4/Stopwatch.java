package chapter1_4;

public class Stopwatch {
	private final long start;
	public Stopwatch() {
		start = System.currentTimeMillis();
	}
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		return (now - start) / 1000.0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 2000;
		int[] a = new int[N];
		for (int i = 0; i < N; i++) {
			a[i] = (int) ((Math.random() - 0.5) * 2000000000);
		}
		Stopwatch timer = new Stopwatch();
		int cnt = ThreeSum.count(a);
		double time = timer.elapsedTime();
		System.out.println(cnt + " triples " + time + " seconds");
		Stopwatch timerFast = new Stopwatch();
		int cntFast = ThreeSum.count(a);
		double timeFast = timerFast.elapsedTime();
		System.out.println(cntFast + " triples " + timeFast + " seconds");
		

	}

}
