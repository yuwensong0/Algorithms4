package chapter1_2;

import java.util.*;

public class Stack<E> implements Iterable<E>{
	private int N = 0;
	Node first = null;
	private class Node{
		E e;
		Node next;
	}
	
	public boolean isEmpty(){
		return first == null;
	}
	
	public int size(){
		return N;
	}
	
	public E peek(){
		return first.e;
	}
	
	public static <T> Stack<T> copy(Stack<T> stack){
		Stack<T> a = new Stack<>();
		Stack<T> b = new Stack<>();
		for (T t : stack){
			a.push(t);
		}
		for (T t: a){
			b.push(t);
		}
		return b;
	}
	
	public void push(E e){
		Node oldFirst = first;
		first = new Node();
		first.e = e;
		first.next = oldFirst;
		N++;
	}

	public E pop(){
		E e = first.e;
		first = first.next;
		N--;
		return e;
	}
	
	public Iterator<E> iterator(){
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<E>{
		private Node current = first;
		public boolean hasNext(){
			return current != null;
		}
		public E next(){
			E e = current.e;
			current = current.next;
			return e;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		System.out.println(stack.isEmpty());

		for (int i = 0; i < 10; i++){
			stack.push(i);
		}
		for (int i : stack){
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("size = " + stack.size());
		System.out.println(stack.pop());
		System.out.println("size = " + stack.size());
		System.out.println(stack.isEmpty());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		for (int i : Stack.copy(stack)){
			System.out.print(i + " ");
		}
		

	}

}
