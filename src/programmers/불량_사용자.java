package programmers;

import java.util.*;

public class 불량_사용자 {
	static class Solution {
		boolean[] used;
		Set<Set<String>> ansSet;
		public int solution(String[] user_id, String[] banned_id) {
			used = new boolean[user_id.length];
			ansSet = new HashSet<>();
			dfs(user_id,banned_id,new HashSet<>());

			return ansSet.size();
		}
		void dfs(String[] user_id,String[] banned_id,Set<String> arr){
			if(arr.size() == banned_id.length){
				ansSet.add(new HashSet<>(arr));
				return;
			}
			for(int i=0;i< user_id.length;i++){
				if(!used[i] && isMatch(banned_id[arr.size()],user_id[i])){
					used[i] = true;
					arr.add(user_id[i]);
					dfs(user_id,banned_id,arr);
					arr.remove(user_id[i]);
					used[i] = false;
				}
			}
		}
		boolean isMatch(String masked, String id){
			if(masked.length() != id.length() ) return false;
			for(int i =0;i<masked.length();i++){
				if(masked.charAt(i) == '*') continue;
				if(masked.charAt(i) != id.charAt(i)) return false;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new String[]{
				"frodo", "fradi", "crodo", "abc123", "frodoc"
		},new String[]{
				"fr*d*", "*rodo", "******", "******"}));

	}
}
