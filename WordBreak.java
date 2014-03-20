package yf.leetcode.wordbreak;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	public static void main(String[] argvs) throws IOException{
		String s = "fajbeokiakfmlacbinjdnjdmmfha";
		Set<String> dict = new HashSet<String>();
		FileInputStream fin = new FileInputStream("testcase.txt");
		DataInputStream din = new DataInputStream(fin);

		
		char c;
		int length = fin.available(); 
		int flag = 0;
		StringBuilder tmp = new StringBuilder();
		for(int i=0;i<length;i++){
			c=(char)din.readByte();
			if(c==',')
				continue;
			else if(c=='\"'&&flag==0){
				flag=1;
			}
			else if(c=='\"'&&flag==1){
				flag=0;
				dict.add(tmp.toString());
				tmp = new StringBuilder();
			}
			else 
				tmp.append(c);
			
		 
		}
		fin.close();
		ArrayList<String > result = wordBreak(s,dict);
		for(String resultTmp:result){
			System.out.println(resultTmp);
		}
		
		
		
	}
	
	public static List<ArrayList<Integer>> allPath = new ArrayList<ArrayList<Integer>>();
	
	public static ArrayList<String> wordBreak(String s, Set<String> dict) {
		List<Integer> list = new ArrayList<Integer>();  
	     for (int i = s.length() - 1; i >= 0; i--) {  
	         String sub = s.substring(i);  
	         if (dict.contains(sub)) {  
	             list.add(i);  
	         } else {  
	             for (Integer index : list) {  
	                 sub = s.substring(i, index);  
	                 if (dict.contains(sub)) {  
	                     list.add(i);  
	                     break;  
	                 }  
	             }  
	         }  
	     }  
	    
	     if (list.isEmpty()) {  
	         return new ArrayList<String>();  
	     } else {  
	         Integer index = list.get(list.size() - 1);  
	         if(index == 0){
	        	 
	        	 ArrayList<Integer> path = new ArrayList<Integer>();
	        	 printPath(s,list,path,dict);
	        	 ArrayList<String> pathString = new ArrayList<String>();
	        	 for(ArrayList<Integer> tmp:allPath){
	        		
	        		 StringBuilder tmpString = new StringBuilder(s);
	        		 for(Integer tmpInt:tmp){
	        			 if(tmpInt!=0)
	        				 tmpString.insert(tmpInt, " ");
	        				
	        			
	        			 
	        		 }
	        		 
	        		 pathString.add(tmpString.toString());
	        	 }
	        	 
	        	 return pathString;
	         }
	         return new ArrayList<String>(); 
	     }  
    }
	public static void printPath(String s,List<Integer> list,ArrayList<Integer> currentPath,Set<String> dict){
		List<Integer> listTmp = copyList(list);
		while(true){
			Integer index = listTmp.get(0); 
			if(dict.contains(s.substring(index))){
				ArrayList<Integer> currentPathTmp = (ArrayList<Integer>) copyList(currentPath);
				currentPathTmp.add(index);
				if(index==0){
					allPath.add(currentPathTmp);
					return;
				}
				listTmp.remove(0);
				printPath(s.substring(0,index),listTmp,currentPathTmp,dict);
			}
			else{
				if(listTmp.size()==1)
					return;
				listTmp.remove(0);
			}
		}
	}
	public static List<Integer> copyList(List<Integer> tmp){
		List<Integer> aa = new ArrayList<Integer>();
		for(Integer a:tmp){
			aa.add(a);
		}
		return aa;
	}
	
	 
}
