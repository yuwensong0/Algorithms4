package chapter1_2;

public class Buffer {
	private Stack<Character> leftStack;
	private Stack<Character> rightStack;
	
	public Buffer() {
		leftStack = new Stack<>();
		rightStack = new Stack<>();
	}
	
	public void insert(char c) {
		leftStack.push(c);
	}
	
	public char delete() {
		return leftStack.pop();
	}
	
	public void left(int k) {
		while (k > 0) {
			rightStack.push(leftStack.pop());
			k--;
		}
	}
	
	public void right(int k) {
		while (k > 0) {
			leftStack.push(rightStack.pop());
			k--;
		}
	}
	
	public int size() {
		return leftStack.size() + rightStack.size();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer b = new Buffer();
		System.out.println(b.size());
		b.insert('a');
		b.insert('b');
		b.insert('c');
		System.out.println(b.size());
		System.out.println(b.delete());
		b.insert('c');
		b.left(2);
		System.out.println(b.delete());
		b.right(1);
		System.out.println(b.delete());
		

	}

}
