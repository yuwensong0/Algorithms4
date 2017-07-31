package chapter2_4;

public class IndexMinPQ<Key extends Comparable<Key>> {
	private int N;
	private Key[] keys;
	private int[] pq;
	private int[] qp;

	public IndexMinPQ(int maxN) {
		N = 0;
		keys = (Key[]) new Comparable[maxN + 1];
		pq = new int[maxN + 1];
		qp = new int[maxN + 1];
		for (int i = 0; i < qp.length; i++) {
			qp[i] = -1;
		}
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public boolean contains(int k) {
		return qp[k] != -1;
	}

	public void insert(int k, Key key) {
		N++;
		keys[k] = key;
		pq[N] = k;
		qp[k] = N;
		swim(N);
	}

	public Key min() {
		return keys[pq[1]];
	}

	public int delMin() {
		int min = pq[1];
		exch(1, N--);
		sink(1);
		keys[pq[N + 1]] = null;
		qp[pq[N + 1]] = -1;
		return min;
	}
	
	public int minIndex() {
		return pq[1];
	}
	
	public void change(int k, Key key) {
		keys[k] = key;
		swim(qp[k]);
		sink(qp[k]);
	}
	
	public void delete(int k) {
		int t  = qp[k];
		keys[k] = null;
		exch(t, N--);
		swim(t);
		sink(t);
		qp[k] = -1;

	}

	private boolean less(int i, int j) {
		return keys[pq[i]].compareTo(keys[pq[j]]) < 0;
	}

	private void exch(int i, int j) {
		int t = pq[i];
		pq[i] = pq[j];
		pq[j] = t;
		qp[pq[i]] = i;
		qp[pq[j]] = j;
	}

	private void swim(int k) {
		while (k > 1 && less(k, k / 2)) {
			exch(k, k / 2);
			k /= 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j + 1, j)) j++;
			if (!less(j, k)) break;
			exch(j, k);
			k = j;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = { 5, 2, 4, 5, 44, 4, 3, 11, 5, 7, 1, 663, 2, 1, 41, 3, 6, 8, 1 };
		IndexMinPQ<Integer> pq = new IndexMinPQ<>(10);
		System.out.println(pq.isEmpty());
		System.out.println(pq.size());
		pq.insert(1, 3);
		pq.insert(2, 1);
		pq.insert(3, 7);
		pq.insert(4, 8);
		pq.insert(5, 5);
		pq.insert(6, 0);
		pq.insert(7, 3);
		System.out.println(pq.isEmpty());
		System.out.println(pq.contains(5));
		System.out.println(pq.size());
		pq.delete(1);
		pq.change(2, 10);
		System.out.println(pq.minIndex());
		while (!pq.isEmpty()) {
			System.out.print(pq.min() + " ");
			pq.delMin();
		}
		

	}

}
