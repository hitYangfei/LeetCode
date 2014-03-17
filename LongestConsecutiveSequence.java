package yf.leetcode;

import java.util.Hashtable;
import java.util.Map;

public class LongestConsecutiveSequence {
	public static void main(String[] argvs){
		int[] num={100,4,200,1,3,2};
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(num));
	}
	public int longestConsecutive(int[] num) {
		Map<Integer,Integer> hash = new Hashtable<Integer,Integer>();
		for(int i=0;i<num.length;i++)
			hash.put(num[i], num[i]);
		int currentLongest = 1;
		for(int i=0;i<num.length;i++){
			int tmpLongest=1;
			int currentNum = num[i];
			while(hash.get(--currentNum)!=null){
				tmpLongest++;
				hash.remove(currentNum);
			}
			currentNum = num[i];
			while(hash.get(++currentNum)!=null){
				tmpLongest++;
				hash.remove(currentNum);
			}
			if(tmpLongest>currentLongest)
				currentLongest = tmpLongest;
		}
		return currentLongest;
	}
}
