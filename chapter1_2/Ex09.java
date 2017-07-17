package chapter1_2;

public class Ex09 {
	public static void go(String s){
		String[] a = s.split(" ");
		Stack<String> stack = new Stack<>();
		for (String str : a){
			if (str.equals(")")){
				String temp = stack.pop();
				temp = stack.pop() + temp;
				temp = "(" + stack.pop() + temp + ")";
				stack.push(temp);
			} else {
				stack.push(str);
			}
		}
		System.out.println(stack.pop());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
		go(s);
	}

}
