package programmers;

import java.util.*;

public class 소수_찾기 {
	static class Solution {
		static boolean[] isVisited;
		static Set<Integer> set;
		public int solution(String numbers) {
			int answer = 0;
			set = new HashSet<>();
			isVisited = new boolean[numbers.length()];

			for(int i=1;i<=numbers.length();i++){
				getNumbers(i,numbers.toCharArray(),new ArrayList<>());
			}
			for(int target :set){
				if(isSosu(target)) answer++;
			}
			return answer;
		}
		void getNumbers(int length,char[] chars,List<Character> arr){
			if(arr.size() == length){
				StringBuilder sb= new StringBuilder();
				for(char t : arr) sb.append(t);
				set.add(Integer.parseInt(sb.toString()));
				return;
			}
			for(int i=0;i< chars.length;i++){
				if(!isVisited[i]){
					isVisited[i] = true;
					arr.add(chars[i]);

					getNumbers(length,chars,arr);

					isVisited[i] = false;
					arr.remove(Character.valueOf(chars[i]));
				}
			}
		}
		boolean isSosu(int num){
			if(num < 2) return false;
			if(num==2) return true;
			for(int i=2;i<=num/2;i++){
				if(num%i==0) return false;
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("17"));

	}
}
