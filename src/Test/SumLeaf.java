package Test;

import java.util.ArrayList;

public class SumLeaf {

	/**
	 * @param args
	 */



 // Definition for binary tree
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  
    public SumLeaf(){}
 
    public int sumNumbers2(TreeNode root, ArrayList<Integer> ar) {
        int result=0;
        if(root==null) return 0;
        ar.add(0,root.val);
        if(root.left==null && root.right==null) {
        	return sum(ar);
        }
        ArrayList<Integer> ar2= new ArrayList<Integer>(ar);
        
        if(root.left!=null) {
            result +=sumNumbers2(root.left,ar);
        } 
        if(root.right!=null) {
            result +=sumNumbers2(root.right,ar2);
        } 
        return result;
    }
    public int sum( ArrayList<Integer> ar) {
        int result=0;
        int mn=1;
        for(int i=0; i< ar.size();i++) {
            result += mn*ar.get(i);
            mn *=10;
        }
        return result;
    }
    public int sumNumbers(TreeNode root) {
        if(root==null)return 0;
        if(root.left==null && root.right==null)return root.val;
        ArrayList<Integer> ar = new ArrayList<Integer>();
        int result=sumNumbers2(root,ar);
        return result;
    }
    
    public static void main(String[] args) {
    	SumLeaf sl = new SumLeaf();
    	TreeNode tn = sl.new TreeNode(0);
    	tn.left = sl.new TreeNode(1);
    	tn.right = sl.new TreeNode(3);
    	int i = sl.sumNumbers(tn);
    	System.out.println("R="+i);
    }
}
