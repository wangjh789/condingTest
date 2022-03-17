package programmers;

import java.util.*;

public class 보석_쇼핑 {
	static class Solution {
		public int[] solution(String[] gems) {
			int[] answer = new int[2];
			int dist = Integer.MAX_VALUE;
			Set<String> set = new HashSet<>(Arrays.asList(gems));
			Map<String,Integer> map = new HashMap<>();
			int left = 0;
			int right = 0;

			while(true){ //정지 조건을 right로 하지 않은 이유는 범위를 줄여야 하기 떄문에
				if(map.size() == set.size()){ //보석 종류별로 map에 포함 되었을떄 left를 증가시켜 범위를 줄임
					map.put(gems[left], map.get(gems[left])-1);

					if(map.get(gems[left]) == 0){
						map.remove(gems[left]);
					}
					left++;
				}else if(right == gems.length){
					break;
				} else{
					map.put(gems[right],map.getOrDefault(gems[right],0)+1);
					right++;
				}
				if(map.size() == set.size()){
					if(right-left < dist){
						answer[0] = left+1;
						answer[1] = right;
						dist = right-left;
					}
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(new String[]{
				"DIA",
				"RUBY",
				"RUBY",
				"DIA",
				"DIA",
				"EMERALD",
				"SAPPHIRE",
				"DIA"
		})));

	}
}
