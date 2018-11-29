package Test;

import java.util.ArrayList;

public class Solution {
    public Solution(){}
	/**
	 * @param args
	 */
	private String eval(String o1, String o2, String o) {
		int op1 = Integer.parseInt(o1);
		int op2 = Integer.parseInt(o2);
		if(o.equals("+")) return ""+(op1+op2);
		if(o.equals("-")) return ""+(op1-op2);
		if(o.equals("*")) return ""+(op1*op2);
		if(o.equals("/")) return ""+(op1/op2);
		return null;
	}
    
	public int evalRPN(String[] tokens) {
	   String oper="*/+-";
	   ArrayList<String> ar = new ArrayList<String>();
	   for(int i=0; i<tokens.length;i++) {
		   String token = tokens[i];
		   if(oper.contains(token)) {
			   int size = ar.size();
			   String operand2=ar.get(size-1);
			   String operand1=ar.get(size-2);
			   ar.remove(size-1);
			   ar.remove(size-2);
			   String rez = eval(operand1, operand2, token);
			   ar.add(rez);
		   } else {
			   ar.add(token);
		   }
	   }
	   return Integer.parseInt(ar.get(0));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] input = {"4", "13", "5", "/", "+"};
		Solution solution = new Solution();
		int i = solution.evalRPN(input);
		System.out.println("Result="+i);
	}

}
