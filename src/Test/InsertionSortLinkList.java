package Test;

import java.util.ArrayList;

public class InsertionSortLinkList {
	/**/
	 //* Definition for singly-linked list.
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
	  public ListNode newnode(int val) {
		  return new ListNode(val);
	  }
	 
	    public ListNode insertionSortList(ListNode head) {
	        if(head==null) return null;
	        if(head.next==null) return head;
	        ListNode result = new ListNode(head.val);
	        ListNode cnr=result;
	        ListNode cn = head.next;
	        
	        while(cn!=null) {
	            cnr=result;
	            int flag=0;
	            ListNode prev=null;
	            while(cnr!=null) {
	                if(cnr.val >= cn.val && (prev==null || cn.val > prev.val)) {
	                	flag=1;
	                    ListNode nln=new ListNode(cn.val);
	                    if(prev==null) {
	                    	nln.next=result;
	                    	result=nln;
	                    	//prev=result; 
	                    } else {
	                    	//cnr.next=nln;
	                    	prev.next=nln;
	                    	nln.next=cnr;
	                    }
	                    nln.next=cnr;
	                    break;
	                }
	                prev=cnr;
	                cnr=cnr.next;
	            }
	            if(flag==0) {
	            	prev.next=new ListNode(cn.val); 
	            }
	            cn=cn.next;
	        }
	        return result;
	    }
	    public void print(ListNode l, String title){
	    	//System.out.println(title+"="+l.val);
	    	ListNode cr=l;
	    	while(cr!=null) {
	    		System.out.println(title+"="+cr.val);
	    		cr=cr.next;
	    	}
	    }
	    
	    public void reorderList(ListNode head) {
	        if(head==null) return;
	        ArrayList<Integer> ar = new ArrayList<Integer>();
	        while(head!=null) {
	            ar.add(head.val);
	            head=head.next;
	        }
	        ListNode result = new ListNode(ar.get(0));
	        ListNode cn = result;
	        int index1=1;
	        int index2=ar.size()-1;
	        for(int i=1; i< ar.size();i++) {
	            int s = i %2;
	            if(s==0) {
	               ListNode ln = new ListNode(ar.get(index1));
	               index1++;
	               cn.next=ln;
	            } else {
	               ListNode ln = new ListNode(ar.get(index2));
	               index2--;
	               cn.next=ln;
	            }
	            cn=cn.next;
	            if(index1>index2)break;
	        }
	        print(result,"output2");
	        head=result;
	    }
	    public static void main(String[] args) {
			// TODO Auto-generated method stub
	    	InsertionSortLinkList  i = new InsertionSortLinkList ();
			ListNode head=i.newnode(1);
			ListNode node=i.newnode(2);
			head.next=node;
			ListNode node2=i.newnode(3);
			node.next=node2;
			//ListNode node3=i.newnode(3);
			//node2.next=node3;
			i.print(head, "input:");
		    //ListNode li = i.insertionSortList(head);
		    i.reorderList(head);
		    i.print(head,"output:");
		}
}
