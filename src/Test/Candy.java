package Test;

import java.util.Hashtable;

import Test.InsertionSortLinkList.ListNode;
public class Candy {
    public Candy(){}

    public int candy(int[] ratings) {
        int sum=0;
        int min=1000;
        int max=-1;
        int flag=0;
        if(ratings.length==0) {
            return 0;
        }
        if(ratings.length==1) {
            return 1;
        }
        for(int i=0; i< ratings.length;i++) {
            if(ratings[i]==0) flag=1;
        }
        if(flag>0) {
            for(int i=0; i< ratings.length;i++){
                ratings[i]++;
            }
        }
        for(int i=0; i< ratings.length;i++){
            if(max<ratings[i])max=ratings[i];
        }
        int[] ii=new int[max+1];
        for(int i=0; i< ratings.length;i++) {
            ii[ratings[i]]=ratings[i];
        }
        //ArrayList<Integer> ar = new AreayList<Integer>();
        Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
        int j=1;
        for(int i=0; i< ii.length;i++) {
            //if(ii[i]>0) ar.add(ii[i]);
            if(ii[i]>0) { 
            	ht.put(ii[i],j);
            	j++;
            }
        }
        
        for(int i=0; i<ratings.length;i++) {
            sum += (ht.containsKey(ratings[i]))?ht.get(ratings[i]):0;
        }
        return sum;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Candy c = new Candy();
    	int[] A={2,2};
    	int i=c.candy(A);
    	System.out.println("R="+i);
	}
}
