package yf.leetcode.candy;

public class Candy {
	public static void main(String[] argvs){
		int[] ratings = {2,2,2,2,2,1};
		System.out.println(candy(ratings));
	}
	 public static int candy(int[] ratings) {
		 
		
		 int[] A = new int[ratings.length];
		 A[0]=1;
		 for(int i=1;i<ratings.length;i++){
			 
			if(ratings[i]>ratings[i-1]){
				A[i]=A[i-1]+1;
			}
			else{
				A[i]=1;
			}
			 
		 }
		 int ans = A[ratings.length-1];  
	     for (int i = ratings.length - 2; i >= 0 ; i--)  
	        {  
	            if (ratings[i] > ratings[i+1]) A[i] = max(A[i], A[i+1]+1);  
	            ans += A[i];  
	        }  
		 
	     return ans;
	 }
	 public static int max(int a,int b){
		 return a>b?a:b;
	 }
	
}
