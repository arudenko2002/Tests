package Test;

public class Stairs {
	public Stairs(){}

	/**
	 * @param args
	 */
	public void Stair(int n, int stairs, String rez) {

	      String result = rez+" "+stairs;
	      n=n-stairs;
	      if(n==0) {
	         System.out.println(result);
	      }
	      if(n>0) Stair(n, 1,result);
	      if(n>1) Stair(n, 2, result);
	}
	public void printPermutations(int n) {
         Stair(n, 1,"");
         Stair(n, 2, "");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stairs s = new Stairs();
        s.printPermutations(4);
	}

}
