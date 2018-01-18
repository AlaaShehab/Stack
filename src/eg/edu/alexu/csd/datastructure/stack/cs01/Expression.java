/**
 *
 */
package eg.edu.alexu.csd.datastructure.stack.cs01;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
/**
 * @author Personal
 *
 */
public class Expression implements IExpressionEvaluator {
/**
 * @param expression to change.
 * @return postfixExp string.
 */
@Override
public String infixToPostfix(final String expression1) {
	if (expression1 == null
	|| expression1.length() == 0) {
	throw new RuntimeException();
	}
int pos = 0;
StringBuffer postfixExp = new StringBuffer();
String expression = expression1.replaceAll(" ", "");
Stack expStack = new Stack();
while (pos < expression.length()) {
	if (pos == 0) {
	if (!Character.isLetterOrDigit(expression.charAt(pos))
	&& expression.charAt(pos) != '(') {
	 throw new RuntimeException();
	}
	}
	int lastIndex = expression.length() - 1;
	if (!Character.isLetterOrDigit(expression.charAt(lastIndex))
	&& expression.charAt(lastIndex) != ')') {
		throw new RuntimeException();
	}
	if (Character.isLetterOrDigit(expression.charAt(pos))) {
		postfixExp.append(expression.charAt(pos));
		if (pos != expression.length() - 1) {
			postfixExp.append(" ");
		}
	} else {
		switch (expression.charAt(pos)) {
		case '+':
			 if (pos != 0
	 && !Character.isLetterOrDigit(expression.charAt(pos - 1))
			 && expression.charAt(pos - 1) != ')') {
			 throw new RuntimeException();
			}
			if (expStack.isEmpty()) {
				expStack.push('+');
				break;
			}
			while ((Character) expStack.peek() == '-'
			|| (Character) expStack.peek() == '*'
			|| (Character) expStack.peek() == '/'
			|| (Character) expStack.peek() == '+') {
				postfixExp.append(expStack.pop());
				if (pos != expression.length() - 1) {
					postfixExp.append(" ");
				}
				if (expStack.isEmpty()) {
					break;
				}
			}
			expStack.push('+');
			break;
		case '-':
			 if (pos != 0
	 && !Character.isLetterOrDigit(expression.charAt(pos - 1))
			&& expression.charAt(pos - 1) != ')') {
				throw new RuntimeException();
			}
			if (expStack.isEmpty()) {
				expStack.push('-');
				break;
			}
			while ((Character) expStack.peek() == '+'
			|| (Character) expStack.peek() == '*'
			|| (Character) expStack.peek() == '/'
			|| (Character) expStack.peek() == '-') {
				postfixExp.append(expStack.pop());
			if (pos != expression.length() - 1) {
				postfixExp.append(" ");
			}
			if (expStack.isEmpty()) {
				break;
			}
			}
			expStack.push('-');
			break;
		case '*':
			if (pos != 0
  && !Character.isLetterOrDigit(expression.charAt(pos - 1))
			 && expression.charAt(pos - 1) != ')') {
			 throw new RuntimeException();
			}
			if (expStack.isEmpty()) {
				expStack.push('*');
				break;
			}
			while ((Character) expStack.peek()
		== '/' || (Character) expStack.peek() == '*') {
			postfixExp.append(expStack.pop());
			if (pos != expression.length() - 1) {
				postfixExp.append(" ");
			}
			if (expStack.isEmpty()) {
				break;
			}
			}
			expStack.push('*');
			break;
		case '/':
			 if (pos != 0
&& !Character.isLetterOrDigit(expression.charAt(pos - 1))
		&& expression.charAt(pos - 1) != ')') {
			 throw new RuntimeException();
			}
			if (expStack.isEmpty()) {
				expStack.push('/');
				break;
			}
			while ((Character) expStack.peek()
	== '*' || (Character) expStack.peek() == '/') {
				postfixExp.append(expStack.pop());
			if (pos != expression.length() - 1) {
				postfixExp.append(" ");
			}
			if (expStack.isEmpty()) {
				break;
			}
			}
			expStack.push('/');
			break;
		case '(':
			expStack.push('('); break;
		case ')':
			if (expStack.isEmpty()) {
				throw new RuntimeException();
			}
			while ((Character) expStack.peek()
				!= '(') {
			postfixExp.append(expStack.pop());
			if (pos != expression.length() - 1) {
				postfixExp.append(" ");
			}
			}
			expStack.pop();
			break;
		default:
			break;
		}
	}
	pos++;
  }
while (!expStack.isEmpty()) {
	if ((Character) expStack.peek() == '(') {
		throw new RuntimeException();
	}
	postfixExp.append(" ");
	postfixExp.append(expStack.pop());
}
return postfixExp.toString();
}
	/**
	 * @param expression to change.
	 * @return postfixExp string.
	 */
	@Override
	public int evaluate(final String expression) {
		int pos = 0;
		int answer = 0;
		int firstNumber = 0;
		int secondNumber = 0;
		Stack expStack = new Stack();
		while (pos < expression.length()) {
	if (Character.isDigit(expression.charAt(pos))) {
				StringBuffer number = new StringBuffer();
				while (expression.charAt(pos) != ' ') {
					number.append(expression.charAt(pos));
					pos++;
				}
	expStack.push(Integer.parseInt(number.toString()));
			} else {
				if (pos == 0) {
					throw new RuntimeException();
				}
				Character op = expression.charAt(pos);
				switch (op) {
				case '+':
			firstNumber = (Integer) expStack.pop();
			secondNumber = (Integer) expStack.pop();
			answer = firstNumber + secondNumber;
			expStack.push(answer);
					break;
				case '-':
			firstNumber = (Integer) expStack.pop();
			secondNumber = (Integer) expStack.pop();
			answer = secondNumber - firstNumber;
			expStack.push(answer);
					break;
				case '*':
			firstNumber = (Integer) expStack.pop();
			secondNumber = (Integer) expStack.pop();
			answer = firstNumber * secondNumber;
			expStack.push(answer);
					break;
				case '/':
			firstNumber = (Integer) expStack.pop();
			secondNumber = (Integer) expStack.pop();
			answer = secondNumber / firstNumber;
			expStack.push(answer);
					break;
				default:
					break;
				}
		if (pos == expression.length() - 1) {
			break;
		}
				pos++;
			}
		pos++;
		}
		if (pos != expression.length() - 1) {
			throw new RuntimeException();
		} else if (expStack.size() > 1) {
			return 0;
		}
		return answer;
	}
}
