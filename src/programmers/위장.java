package programmers;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
	static class Solution {
		public int solution(String[][] clothes) {
			int answer = 1;
			Map<String,Integer> map = new HashMap<>();
			for(String[] c : clothes){
				map.put(c[1],map.getOrDefault(c[1],0)+1);
			}
			for(Map.Entry<String,Integer> t : map.entrySet()){
				answer*=t.getValue()+1;
			}
			return answer-1;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}}
		System.out.println(sol.solution(
				new String[][]{{"yellowhat", "headgear"},
						{"bluesunglasses", "eyewear"},
						{"green_turban", "headgear"}}));
	}
}
