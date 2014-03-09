package yf.leetcode.reverseWords;

public class ReverseWords {
	public static void main(String[] argvs){
		String s = "   a   b ";
		System.out.println(new ReverseWords().reverseWords(s));
		
				
	}
	public String reverseWords(String s) {
		if(s==null)
			return new String();
		if(s.length()==0)
			return s;
		String strs = s.trim();
		if(strs.length()==0){
			return new String("");
		}
		//去掉多余空格
        StringBuffer str = new StringBuffer();
        int state = 0;
        for(int i=strs.length()-1;i>=0;i--){
        	if(state==0){
        		if(strs.charAt(i)!=' '){
        			str.append(strs.charAt(i));
        		}
        		else{
        			state = 1;
        			str.append(strs.charAt(i));
        		}
        	}
        	else if(state==1){
        		if(strs.charAt(i)!=' '){
        			str.append(strs.charAt(i));
        			state = 0;
        		}
        	}
        }
        String strTmp = str.toString();
        StringBuffer result = new StringBuffer();
        int positon = -1;
        for(int i=0;i<str.length();i++){
        	if(strTmp.charAt(i)!=' '){
        		result.insert(positon+1, strTmp.charAt(i));
        	}
        	else{
        		positon = i;
        		result.append(strTmp.charAt(i));
        	}
        }
        return result.toString().trim();
    }
}
