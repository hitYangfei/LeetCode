package yf.leetcode.singlenumber;

public class SingleNumber {
	//singleI
	/* public int singleNumber(int[] A) {
	        int x=A[0];
	        for(int i=1;i<A.length;i++){
	            x=x^A[i];
	        }
	        return x;
	 }*/
	public static void main(String[] argvs){
		int[] A = new int[10];
		A[0]=3;
		A[1]=3;
		A[2]=3;
		A[3]=4;
		A[4]=4;
		A[5]=4;
		A[6]=-5;
		A[7]=-5;
		A[8]=-5;
		A[9]=9;
		System.out.println(new SingleNumber().singleNumber(A));
		
	}
	 //singleII
	 public int singleNumber(int[] A) {
	     int[] bits = new int[32];
	     for(int i=0;i<bits.length;i++)
	    	 bits[i]=0;
	     for(int i=0;i<A.length;i++){
	    	 for(int j=0;j<bits.length;j++)
	    		 if(((0x1<<j)&A[i])!=0)
	    			 bits[j]++;
	     }
	     int x=0;
	     for(int i=0;i<bits.length;i++){
	    	 if(bits[i]%3!=0){
	    		 x+=(0x1<<i);
	    	 }
	     }
	     return x;
	 }
}
