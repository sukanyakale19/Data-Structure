package expressionStack;

import java.util.Stack;

public class PrefixEvaluation {
	private static String prefix;


	public static int calc(int a,int b, char operator) {
		switch(operator) {
		case '$':return (int)Math.pow(a, b);
		case '*':return a*b;
		case '/':return a/b;
		case '%':return a%b;
		case '+':return a+b;
		case '-':return a-b;
		
		}
		return 0;
	}
	public static int SolvePrefix(String pre) {
		Stack<Integer> s=new Stack<Integer>();
		for(int i=pre.length()-1;i>=0; i-- ) {
			char sym =pre.charAt(i); 
			if(Character.isDigit(sym)) {//here character converted to string and then string into i nteger
				String operand=Character.toString(sym);
				s.push(Integer.parseInt(operand));
			}
			else {
				int a=s.pop();
				int b=s.pop();
				int c= calc(a,b,sym);
				s.push(c);
				
			}
			
		}
		return s.pop();
	}
	public static int pri(char operator) {
		switch (operator) {
		case '$': return 3;
		case '*': return 2;
		case '/': return 2;
		case '%': return 2;
		case '+': return 1;
		case '-': return 1;
		}
		return 0;
	}
	public static String infixToPrefix(String infix) {
		Stack<Character> s = new Stack<Character>();
		StringBuilder pre = new StringBuilder();
		//1. traverse infix expression from right to left
		for(int i = infix.length()-1; i >= 0; i--) {
			char sym = infix.charAt(i); // sym can be operand, (, ) or operator
			//2. if operand is found, append to prefix.
			if(Character.isDigit(sym))
				pre.append(sym);
			else if(sym == ')') //4. if closing ) is found, then push it on stack.
				s.push(sym);
			else if(sym == '(') { //5. if opening ( is found, 
				// pop all operators from stack one by one and append to prefix
				// until closing ) is found.
				while(s.peek() != ')')
					pre.append(s.pop());
				// also pop and discard closing )
				s.pop();
			} 
			else { //3. if "operator" is found, push it on the stack.
				// if priority of topmost operator from stack > priority of current operator,
				while(!s.isEmpty() && pri(s.peek()) > pri(sym)) {
					// pop operator from stack and append to prefix.
					pre.append(s.pop());
				}
				s.push(sym);
			}		
		} // end of for loop
		//6. when all syms from infix are done, pop all operators from stack one by one and append to prefix
		while(!s.isEmpty())
			pre.append(s.pop());
		//7. reverse the prefix and return
		return pre.reverse().toString();
	}
	public static boolean isBalanced(String expr) {
		Stack<Character> s= new Stack<Character>();
		String open = "([{", close =")]}";
		for (int i=0; i < expr.length(); i++) {
			char sym = expr.charAt(i);
			if (open.indexOf(sym)!=-1)
				s.push(sym);
			else if(close.indexOf(sym)!=-1) {
				if(s.empty())
					return false;
				char pop=s.pop();
				
				if(close.indexOf(sym)!=open.indexOf(pop))
					return false;
			}
		}
		return s.isEmpty();
	}
	

	public static void main(String[] args) {
		String infix = "5+9-4*(8-6/2)   +1$(7-3)";
		 
		String Prefix = "";//"+-+59*4-8/62$1-73";
		
//		prefix = infixToPrefix(infix);
//		System.out.println("Prefix: " + prefix);
//		int result =SolvePrefix(prefix);
//		System.out.println("Result: " + result);
	
		boolean balanced=isBalanced(infix);
		System.out.println("balanced:"+balanced);

	}
	
	

}
