package yf.leetcode;

import java.util.ArrayList;

public class PalindromePartitioningII {
	
	private static ArrayList<String> minCut = new ArrayList<String>();
	public static void main(String[] argvs){
		
			String s ="aab";
		 
		    System.out.println(new PalindromePartitioningII().minCut(s));
			
			
		
	}  
    public int minCut(String s){
    	boolean[][] m = buildTable(s);
    	int[] cut = new int[s.length()+1];
    	for(int i=s.length()-1;i>=0;i--){
    		cut[i] = s.length()-i;
    		for(int j=i;j<s.length();j++){
    			if(m[i][j])
    				cut[i] = Math.min(cut[i], cut[j+1]+1);
    		}
    	}
    	return cut[0]-1;
    }
	
	public boolean[][] buildTable(String s) {
		int length = s.length();
		boolean[][] m = new boolean[length][length];
		for(int i=0;i<length;i++)
			m[i][i] = true;
		for(int i=1;i<length;i++){
			//even
			int l = i-1;
			int r = i;
			while(l>=0&&r<length&&s.charAt(l)==s.charAt(r))
				m[l--][r++] = true;
		    //odd
			l = i-1;
		    r = i+1;
		    while(l>=0&&r<length&&s.charAt(l)==s.charAt(r))
		    	m[l--][r++]=true;
		}
	    return m;
    }
	

 

}
