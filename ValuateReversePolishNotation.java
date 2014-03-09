import java.util.Stack;

public class ValuateReversePolishNotation {
	public static void main(String[] argvs){
		String[] tokens={"2","1","+","3","-"};
		System.out.println(evalRPN(tokens));
	}
	public static int evalRPN(String[] tokens){
		if(tokens==null)
			return 0;
		Stack<String> tokenStack = new Stack<String>();
	
		for(int i=0;i<tokens.length;i++){
			if(tokens[i].equals("+")){
				int a=Integer.parseInt(tokenStack.pop());
				int b=Integer.parseInt(tokenStack.pop());
				tokenStack.push(""+(b+a));
			}
			else if(tokens[i].equals("-")){
				int a=Integer.parseInt(tokenStack.pop());
				int b=Integer.parseInt(tokenStack.pop());
				tokenStack.push(""+(b-a));
			}
			else if(tokens[i].equals("*")){
				int a=Integer.parseInt(tokenStack.pop());
				int b=Integer.parseInt(tokenStack.pop());
				tokenStack.push(""+(b*a));
			}
			else if(tokens[i].equals("/")){
				int a=Integer.parseInt(tokenStack.pop());
				int b=Integer.parseInt(tokenStack.pop());
				tokenStack.push(""+(b/a));
			}
			else{
				tokenStack.push(tokens[i]);
			}
			
		}
		return Integer.parseInt(tokenStack.pop());
	}
}
