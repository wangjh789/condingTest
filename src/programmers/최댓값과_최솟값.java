package programmers;

import java.util.Arrays;

public class 최댓값과_최솟값 {
	static class Solution {
		public String solution(String s) {
			String answer = "";
			int[] t = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
			int max = t[0];
			int min = t[0];
			for(int a : t){
				max = Math.max(max,a);
				min = Math.min(min,a);
			}

			return String.valueOf(min)+" "+String.valueOf(max);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("1 2 3 4"));

	}
}
