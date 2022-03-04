package programmers;

import java.util.HashMap;
import java.util.Map;

public class 완주하지_못한_선수 {
	static class Solution {
		public String solution(String[] participant, String[] completion) {
			Map<String,Integer> map = new HashMap<>();
			for(String p : participant){
				map.put(p,map.getOrDefault(p,0)+1);
			}
			for(String com : completion){
				map.put(com,map.get(com)-1);
				if(map.get(com) == 0) map.remove(com);
			}
			for(String t : map.keySet()){
				return t;
			}
			return null;
		}
	}

	public static void main(String[] args){
		Solution sol = new Solution();
		System.out.println(sol.solution(new String[]{"leo", "kiki", "eden"},new String[]{"eden", "kiki"}));
	}
}
