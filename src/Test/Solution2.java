package Test;

public class Solution2 {
	class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
		 
		//public class Solution2 {
			Solution2(){
				Point[] points = new Point[4];
				points[0]=new Point(3,10);
				points[1]=new Point(0,2);
				points[2]=new Point(0,2);
				points[3]=new Point(3,10);
				int rex = maxPoints(points);
				System.out.println("REX="+rex);
			}
		    public int maxPoints(Point[] points) {
		    	int maxcounter=0;
		        for(int i=0; i< points.length-1;i++) {
		        	for(int j=i+1;j< points.length;j++) {
		        		if(points[i].x-points[j].x==0)continue;
		        		double alpha = 1.0*(points[i].y-points[j].y)/(points[i].x-points[j].x);
		        		double b = 1.0*(points[j].x*points[i].y-points[j].y*points[i].x)/(points[j].x-points[i].x);
		        		int counter=0;
		        		for(int k=0; k< points.length;k++) {
		        			if(points[k].x*alpha+b==points[k].y) {
		        				counter++;
		        				System.out.println("C="+counter);
		        			}
		        		}
		        		if(maxcounter<counter) {
		        			maxcounter=counter;
		        		}
		        	}
		        }
		        return maxcounter;
		    }
		//}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 s = new Solution2();

	}

}
