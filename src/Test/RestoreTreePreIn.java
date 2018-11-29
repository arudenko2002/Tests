package Test;

public class RestoreTreePreIn {
	  public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
		 
       public RestoreTreePreIn(){}
		//public class Solution {
		    public int get_index_root_i(int root, int[] inorder) {
		    for(int i=0; i< inorder.length;i++) {
		        if(root==inorder[i]) return i;
		    }
		    return -1;
		}
		public int[] getArray(int[] a, int index1, int index2) {
		    if(index1>index2) return new int[0];
		    int[] result=new int[index2-index1+1];
		    int counter=0;
		    for(int i=index1; i< index2+1;i++) {
		        result[counter]=a[i];
		        counter++;
		    }
		    return result;
		}
		    public TreeNode buildTree(int[] preorder, int[] inorder) {
		        if(preorder.length==1 && inorder.length==1 && preorder[0]==inorder[0]) {
		            return new TreeNode(preorder[0]);
		        }
		        //if(preorder==null && inorder==null) return null;
		        if(preorder.length==0 && inorder.length==0) return null;
		        int root_p=preorder[0];
		        int index_root_i = get_index_root_i(root_p, inorder);
		        int[] left_inorder=getArray(inorder, 0, index_root_i-1);
		        int[] left_preorder=getArray(preorder,1,left_inorder.length);
		        int[] right_inorder=getArray(inorder,index_root_i+1,inorder.length-1);
		        int[] right_preorder=getArray(preorder,1+left_inorder.length, preorder.length-1);
		        TreeNode left_tree=buildTree(left_preorder, left_inorder);
		        TreeNode right_tree=buildTree(right_preorder, right_inorder);
		        TreeNode tn = new TreeNode(root_p);
		        tn.left=left_tree;
		        tn.right=right_tree;
		        return tn;
		    }
		    
		    public void print(TreeNode tn) {
		    	if(tn!=null)System.out.println(tn.val);else {System.out.println("null");return;}
		    	print(tn.left);
		    	print(tn.right);
		    }
		    
		    public void doIt() {
		    	int[] a={1,2};
		    	int[] b={1,2};
		    	TreeNode tn = buildTree(a,b);
		    	print (tn);
		    }
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreTreePreIn r = new RestoreTreePreIn();
		r.doIt();
	}

}
