package chapter1_2;

public class GeneralizedArrayQueue<E> {
	private E[] queue = (E[]) new Object[1];
	private int N = 0;
	
	private void resize(int max) {
		E[] temp = (E[]) new Object[max];
		for (int i = 0; i < N; i++) {
			temp[i] = queue[i];
		}
		queue = temp;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void insert(E e) {
		if (N == queue.length) {
			resize(2 * N);
		}
		queue[N++] = e;
	}
	
	public E delete(int k) {
		if (k > N) {
			return null;
		}
		E e = queue[k - 1];
		for (int i = k - 1; i < N; i++) {
			queue[i] = queue[i + 1];
		}
		N--;
		return e;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GeneralizedArrayQueue<Integer> queue = new GeneralizedArrayQueue<>();
		System.out.println(queue.isEmpty());
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);
		System.out.println(queue.delete(2));
		System.out.println(queue.delete(2));
		System.out.println(queue.delete(2));
		System.out.println(queue.isEmpty());

	}

}
