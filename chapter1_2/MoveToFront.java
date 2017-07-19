package chapter1_2;

public class MoveToFront<E> {
	DoubleLinked<E> dl;
	public MoveToFront() {
		this(null);
	}
	public MoveToFront(E[] a) {
		dl = new DoubleLinked<>();
		for (E s : a) {
			if (!dl.contains(s)) {
				dl.insertAsLast(s);
			}
		}
	}
	
	public void add(E e) {
		if (!dl.contains(e)) {
			dl.insertAsFirst(e);
		} else {
			dl.delete(e);
			dl.insertAsFirst(e);
		}
	}
	
	public void show() {
		for (E e : dl) {
			System.out.print(e + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a = {1,2,4,3,4,2,5,7,2,4,9,1};
		MoveToFront<Integer> f = new MoveToFront<>(a);
		f.show();
		System.out.println();
		f.add(6);
		f.show();
		System.out.println();
		f.add(9);
		f.show();
		System.out.println();
		

	}

}
