package chapter3_1;

import chapter1_2.Queue;

public class ArrayST<Key, Value> {
	private int N;
	private Key[] keys;
	private Value[] vals;

	public ArrayST() {
		N = 0;
		keys = (Key[]) new Object[1];
		vals = (Value[]) new Object[1];
	}

	public void put(Key key, Value val) {
		for (int i = 0; i < N; i++) {
			if (key.equals(keys[i])) {
				vals[i] = val;
				return;
			}
		}
		keys[N] = key;
		vals[N] = val;
		N++;
		if (N == keys.length)
			resize(2 * N);
		return;
	}

	public Value get(Key key) {
		for (int i = 0; i < N; i++) {
			if (key.equals(keys[i])) {
				Value valTemp = vals[i];
				Key keyTemp = keys[i];
				for (int j = i; j > 0; j--) {
					keys[j] = keys[j - 1];
					vals[j] = vals[j - 1];
				}
				keys[0] = keyTemp;
				vals[0] = valTemp;
				return valTemp;
			}
		}
		return null;
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void delete(Key key) {
		for (int i = 0; i < N; i++) {
			if (key.equals(keys[i])) {
				N--;
				for (int k = i; k < N; k++) {
					keys[k] = keys[k + 1];
					vals[k] = vals[k + 1];
				}
				keys[N] = null;
				vals[N] = null;
				if (N > 0 && N <= keys.length / 4)
					resize(2 * N);
				return;
			}
		}
	}

	public boolean contains(Key key) {
		for (int i = 0; i < N; i++) {
			if (key.equals(keys[i])) {
				return true;
			}
		}
		return false;
	}

	public Iterable<Key> keys() {
		Queue<Key> queue = new Queue<>(); 
		for (int i = 0; i < N; i++) {
			queue.enqueue(keys[i]);
		}
		return queue;
	}

	private void resize(int max) {
		Key[] keysTemp = (Key[]) new Object[max];
		Value[] valsTemp = (Value[]) new Object[max];
		for (int i = 0; i < N; i++) {
			keysTemp[i] = keys[i];
			valsTemp[i] = vals[i];
		}
		keys = keysTemp;
		vals = valsTemp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayST<String, Integer> st = new ArrayST<>();
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		st.put("a", 1);
		st.put("b", 3);
		st.put("c", 4);
		st.put("a", 9);
		st.put("g", 3);
		for (String key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println();
		for (String key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println();
		for (String key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println();
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		//System.out.println(st.get("b"));
		System.out.println(st.get("r") == null);
		for (String key : st.keys()) {
			System.out.println("key : " + key + "  val : " + st.get(key));
		}
		System.out.println();
		st.delete("a");
		System.out.println(st.isEmpty());
		System.out.println(st.size());
		System.out.println(st.get("a") == null);

	}

}
