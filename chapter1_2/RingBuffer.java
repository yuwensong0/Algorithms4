package chapter1_2;

public class RingBuffer <E> {
	private int head;
	private int tail;
	private int N;
	private E[] queue;
	
	public RingBuffer() {
		this(128);
	}
	public RingBuffer(int a) {
		queue = (E[]) new Object[a];
		head = 0;
		tail = 0;
		N = 0;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public boolean isFull() {
		return N == queue.length;
	}
	
	public void enqueue(E e) {
		queue[tail++] = e;
		tail %= queue.length;
		N++;
	}
	
	public E dequeue() {
		E e = queue[head++];
		head %= queue.length;
		N--;
		return e;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		RingBuffer<Integer> r = new RingBuffer<>(12);
		System.out.println(r.isEmpty());
		System.out.println(r.isFull());
		while (!r.isFull()) {
			r.enqueue(i++);
		}
		System.out.println(r.isEmpty());
		System.out.println(r.isFull());
		while (!r.isEmpty()) {
			System.out.print(r.dequeue() + " ");
		}
	}
}
