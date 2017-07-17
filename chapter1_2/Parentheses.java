package chapter1_2;

public class Parentheses {
	public static boolean go(String s){
		s = s.trim();
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++){
			if (!stack.isEmpty()){
				String pre = stack.pop();
				String after = s.substring(i, i + 1);
				String a = pre + after;
				if (a.equals("[]") || a.equals("{}") || a.equals("()")){
					continue;
				} else {
					stack.push(pre);
					stack.push(after);
				}
			} else {
				stack.push(s.substring(i, i + 1));
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(go("[()]{}{[()()]()}"));
		System.out.println(go("[()]{}{[()()](})"));
		System.out.println(go("[()]{}{[()()]()}["));

	}

}
