package Test;

public class canCompleteCirquit {
	public canCompleteCirquit(){}
	public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i=0; i< gas.length;i++) {
            int flag=0;
            int sum=0;
            for(int j=i; j< gas.length;j++) {
            	sum+=gas[j]-cost[j];
                if(sum<0) {
                    flag=1;
                    break;
                }
            }
            
            if(flag==0) {
                for(int j=0; j< i;j++) {
                	sum+=gas[j]-cost[j];
                    if(sum<0) {
                    flag=1;
                    break;
                   }
                }
            }
            if(flag==0) return i;
            
        }
        return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		canCompleteCirquit cc = new canCompleteCirquit();
		int[] gas={1,2,3,3};
		int[] cost={2,1,5,1};
		int i = cc.canCompleteCircuit(gas,cost);
		System.out.println("R="+i);
	}

}
