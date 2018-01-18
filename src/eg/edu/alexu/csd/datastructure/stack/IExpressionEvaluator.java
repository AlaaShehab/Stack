/**
 *
 */
package eg.edu.alexu.csd.datastructure.stack;

/**
 * @author Personal
 *
 */
public interface IExpressionEvaluator {
	/**
	* Takes a symbolic/numeric infix expression
	* as input and converts it to postfix notation.
	* @param expression infix expression
	* @return postfix expression
	*/
	public String infixToPostfix(String expression);
	/**
	* Evaluate a postfix numeric expression, with a single space separator
	* @param expression postfix expression
	* @return the expression evaluated value
	*/
	public int evaluate(String expression);
}
