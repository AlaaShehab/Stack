/**
 *
 */
package eg.edu.alexu.csd.datastructure.stack.cs01;

import java.util.Scanner;

/**
 * @author Personal
 *
 */
public class Main {

	/**
	 * @param args for main class.
	 */
	public static void main(final String[] args) {
		Stack stack = new Stack();
		final int option3 = 3, option4 = 4, option5 = 5;
		final int option6 = 6, option2 = 2;
		final int option1 = 1;
		while (true) {
			System.out.println("please choose an operation: ");
			System.out.println("1 : push in stack");
			System.out.println("2 : pop from stack");
			System.out.println("3 : peek from stack");
			System.out.println("4 : Get size of stack");
			System.out.println("5 : Ckeck if stack is empty");
			System.out.println("6 : To end program");
			Scanner scan = new Scanner(System.in);
			String input = null;
			input = scan.nextLine();
			int value = 0;
			if (Character.isDigit(input.charAt(0))
				&& input.length() == 1) {
				value = Integer.parseInt(input);
			}
			switch (value) {
			case option1:
			while (true) {
				System.out.println("Enter value:");
				int val = 0;
				input = scan.nextLine();
				if (Character.isDigit(input.charAt(0))
					&& input.length() == 1) {
				val = Integer.parseInt(input);
				stack.push(val);
				break;
				} else {
				System.out.println("Wrong Input");
				}
			}
				break;
			case option2:
				try {
					stack.pop();
				} catch (Exception e) {
				System.out.println("No element to be poped");
				}
				break;
			case option3:
				try {
					System.out.println(stack.peek());
				} catch (Exception e) {
				System.out.println("No element to be peeked");
				}
				break;
			case option4:
				System.out.println(stack.size());
				break;
			case option5:
				if (stack.isEmpty()) {
				System.out.println("Stack is empty");
				} else {
				System.out.println("Stack is not empty");
				}
				break;
			case option6:
				return;
			default:
				break;
			}
		}
	}
}
