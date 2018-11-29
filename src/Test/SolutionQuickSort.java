package Test;
import java.util.*;

public class SolutionQuickSort {
	static void quickSort(int[] ar) {
		int[] rezult=new int[ar.length];
		ArrayList<Integer> AR=new ArrayList<Integer>();
		for(int i=0; i< ar.length;i++)AR.add(ar[i]);
        ArrayList<Integer> al = pivot(AR);
        for(int i=0; i< ar.length;i++) rezult[i]=al.get(i);
        printArray(rezult);
    }   
	
	static ArrayList<Integer> pivot(ArrayList<Integer> AR){
		
		ArrayList<Integer> rezult=new ArrayList<Integer>();
		if(AR.size()==0)return rezult;
		if(AR.size()==1)return AR;
		rezult.add(AR.get(0));
		int pivot_position=0;
		//System.out.println("AR="+AR);
		for(int i=1;i<AR.size();i++) {
			int number = AR.get(i);
			if(number<AR.get(0)) {
				rezult.add(pivot_position,number);
				pivot_position++;
			} else {
				rezult.add(number);
			}
		}
		//System.out.println("rezult="+rezult);
		int division=pivot_position;
		ArrayList<Integer> rezult_left= new ArrayList<Integer>();
		for(int i=0; i< division;i++)rezult_left.add(rezult.get(i));
		ArrayList<Integer> rezult_right= new ArrayList<Integer>();
		for(int i=division+1; i< rezult.size();i++)rezult_right.add(rezult.get(i));		
		//System.out.println("LEFT="+rezult_left);
		//System.out.println("RIGHT="+rezult_right);
		ArrayList<Integer> left=pivot(rezult_left);
		ArrayList<Integer> right=pivot(rezult_right);
		//System.out.println("LEFT="+left);
		//System.out.println("RIGHT="+right);
		left.add(rezult.get(division));
		for(int i=0; i< right.size();i++)left.add(right.get(i));
		return left;
		
	}

static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
   public static void main(String[] args) {
       /* Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
           ar[i]=in.nextInt(); 
        }*/
	   int[] ar={5, 8, 1, 3, 7, 9, 2};
       quickSort(ar);
    }    
}
