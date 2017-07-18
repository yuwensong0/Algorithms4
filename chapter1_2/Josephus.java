package chapter1_2;

public class Josephus {
	public static void go(int N, int M) {
		Queue<Integer> queue = new Queue<>();
		for (int i = 0; i < N; i++) {
			queue.enqueue(i);
		}
		while (!queue.isEmpty()) {
			for (int i = 0; i < M - 1; i++) {
				queue.enqueue(queue.dequeue());
			}
			System.out.print(queue.dequeue() + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 7;
		int M = 2;
		go(N, M);
	}

}
