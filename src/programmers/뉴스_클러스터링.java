package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 뉴스_클러스터링 {
	static class Solution {
		public int solution(String str1, String str2) {
			Map<String,int[]> map = new HashMap<>();
			setMap(str1,map,0);
			setMap(str2,map,1);
			for(Map.Entry<String,int[]> t : map.entrySet()){
				System.out.println(t.getKey() +" "+ Arrays.toString(t.getValue()));
			}
			if(map.size()==0){
				if(str1.length() == str2.length()){
					for(int i=0;i<str1.length();i++){
						if(Character.toUpperCase(str1.charAt(i)) != Character.toUpperCase(str2.charAt(i)))
							return 0;
					}
					return 65536;
				}else return 0;
			}

			int max = 0;
			int min = 0;
			for(Map.Entry<String,int[]> t : map.entrySet()){
				max += Math.max(t.getValue()[0],t.getValue()[1]);
				min += Math.min(t.getValue()[0],t.getValue()[1]);
			}
			return min*65536/max;
		}
		void setMap(String str,Map<String,int[]> map,int idx){
			for(int i=0;i<str.length()-1;i++){
				if(!(Character.isAlphabetic(str.charAt(i)) && Character.isAlphabetic(str.charAt(i+1)))) continue;
				StringBuilder sb = new StringBuilder();
				sb.append(Character.toUpperCase(str.charAt(i)))
						.append(Character.toUpperCase(str.charAt(i+1)));

				if(!map.containsKey(sb.toString())) map.put(sb.toString(),new int[2]);
				map.get(sb.toString())[idx] ++;
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("E=M*C^2","e=m*c^2"));

	}
}
