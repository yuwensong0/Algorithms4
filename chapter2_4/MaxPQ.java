package chapter2_4;

public class MaxPQ<Key extends Comparable<Key>> {
	private Key[] pq;
	private int N;

	public MaxPQ() {
		pq = (Key[]) new Comparable[2];
		N = 0;
	}

	public MaxPQ(int maxN) {
		N = 0;
		pq = (Key[]) new Comparable[maxN + 1];
	}

	public MaxPQ(Key[] a) {
		N = a.length;
		pq = (Key[]) new Comparable[N + 1];
		for (int i = 0; i < a.length; i++) {
			pq[i + 1] = a[i];
		}
		for (int k = N / 2; k >= 1; k--) {
			sink(k);
		}
	}

	public void insert(Key v) {
		if (N == pq.length - 1) resize(2 * N);
		pq[++N] = v;
		swim(N);
	}

	public Key max() {
		return pq[1];
	}

	public Key delMax() {
		Key t = pq[1];
		exch(1, N);
		pq[N--] = null;
		sink(1);
		if (N > 0 && N == ((pq.length - 1)/4)) resize(2 * N);
		return t;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}
	
	private void resize(int max) {
		Key[] t = (Key[]) new Comparable[max + 1];
		for (int i = 1; i <= N; i++) {
			t[i] = pq[i];
		}
		pq = t;
	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k /= 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (!less(k, j))
				break;
			exch(j, k);
			k = j;
		}
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] a = { 5, 2, 4, 5, 44, 4, 3, 11, 5, 7, 1, 663, 2, 1, 41, 3, 6, 8, 1 };
		MaxPQ<Integer> pq = new MaxPQ<>();
		while (!pq.isEmpty()) {
			System.out.print(pq.delMax() + " ");
		}
		pq.insert(3);
		pq.insert(1);
		pq.insert(9);
		while (!pq.isEmpty()) {
			System.out.print(pq.delMax() + " ");
		}
		pq.insert(3);
		pq.insert(1);
		pq.insert(9);
		pq.insert(9);
		pq.insert(0);
		while (!pq.isEmpty()) {
			System.out.print(pq.delMax() + " ");
		}

	}

}
