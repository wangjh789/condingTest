package programmers;

import java.util.HashMap;
import java.util.Map;

public class 스킬트리 {
	static class Solution {
		public int solution(String skill, String[] skill_trees) {
			int answer = 0;
			Map<Character,Integer> map = new HashMap<>();
			for(int i =0;i<skill.length();i++){
				map.put(skill.charAt(i),i);
			}
			for(String tree : skill_trees){
				int idx = 0;
				boolean possible = true;
				for(int i =0;i<tree.length();i++){
					if(!map.containsKey(tree.charAt(i))) continue;
					int step = map.get(tree.charAt(i));
					if(step != idx){
						possible = false;
						break;
					}else idx++;
				}
				if(possible) answer++;

			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("CBD",new String[]{"BACDE", "CBADF", "AECB", "BDA"}));

	}
}
