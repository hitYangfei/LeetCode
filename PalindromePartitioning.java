package yf.leetcode;
import java.util.ArrayList;

public class PalindromePartitioning {
	
	public static void main(String[] argvs){
		for(int j=0;j<10;j++){
			StringBuilder s = new StringBuilder();
		    for(int i=0;i<20;i++){
		    	s.append("a");
		    }
		    long a = System.currentTimeMillis();
		    new PalindromePartitioning().partitionDP(s.toString());
			System.out.println(System.currentTimeMillis()-a);
			a = System.currentTimeMillis();
			new PalindromePartitioning().partitionRecursion(s.toString());
			System.out.println(System.currentTimeMillis()-a);
		}
		
	}

	 public ArrayList<ArrayList<String>> partitionRecursion(String s) {
	        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	        ArrayList<String> tmp = new ArrayList<String>();
	        dfsRecursion(res,tmp,s);
	        return res;
	    }
	    
	    public void dfsRecursion(ArrayList<ArrayList<String>> res, ArrayList<String> tmp, String s){
	        if (s.length()==0) res.add(new ArrayList<String>(tmp));
	        for(int i=1;i<=s.length();i++){
	            String substr = s.substring(0,i);
	            if(isPalindrome(substr)){
	                tmp.add(substr);
	                dfsRecursion(res,tmp,s.substring(i));
	                tmp.remove(tmp.size()-1);
	            }
	        }    
	    }
	    
	 public void dfsDP(ArrayList<ArrayList<String>> res, ArrayList<String> tmp, String s,int[][] m,int offset){
	        if (offset==s.length()) res.add(new ArrayList<String>(tmp));
	        for(int i=offset;i<s.length();i++){
	            if(m[offset][i]==1){
	              tmp.add(s.substring(offset,i+1));
	              dfsDP(res,tmp,s,m,i+1);
	              tmp.remove(tmp.size()-1);
	            }
	        }    
	    }
	
	 public ArrayList<ArrayList<String>> partitionDP(String s) {
	        int length = s.length();
	        int[][] m = new int[length][length];
	      
	        for(int i=0;i<length;i++){
	        	for(int j=i+1;j<=length;j++){
	        		if(isPalindrome(s.substring(i,j))){
	        			m[i][j-1]=1;
	        		}
	        	}
	        }
	        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	        ArrayList<String> tmp = new ArrayList<String>();
	        dfsDP(res,tmp,s,m,0);
	        return res;
	      
	  }
	 public boolean isPalindrome(String s){
	        int i = 0;
	        int j = s.length()-1;
	        while(i<j){
	            if (s.charAt(i++) != s.charAt(j--)) return false;
	        }
	        return true;
	    }
}
