package yf.leetcode.gasstation;

public class Gasstation {
	public static void main(String[] argvs){
		int[] gas={2,3,4,6,5};
		int[] cost={1,1,8,3,5};
		System.out.println(new Gasstation().canCompleteCircuit(gas,cost));
	}
	 public int canCompleteCircuit(int[] gas, int[] cost) {
		 int length = gas.length;
		 int beginNode = 0;
		 int currentNode = beginNode;
		 int hasGoneNode = 0;
		 int gasCount = gas[beginNode]-cost[beginNode];
		 while(true){
			 if(gasCount>=0){
				 currentNode = nextNode(length,currentNode);
				 gasCount += gas[currentNode]-cost[currentNode]; 
			 }
			 else{
				 beginNode = prevNode(length,beginNode);
				 gasCount += gas[beginNode]-cost[beginNode];
			 }
			 hasGoneNode++;
			 if(hasGoneNode==length)
				 break;
		 }
		 if(gasCount>=0)
			 return beginNode;
		 return -1;
	 }
	 public int nextNode(int length,int node){
		 if(node==length-1)
			 return 0;
		 else{
			 return node+1;
		 }
	 }
	 public int prevNode(int length,int node){
		 if(node==0)
			 return length-1;
		 else{
			 return node-1;
		 }
	 }
}
