package programmers;

import java.util.Arrays;

public class 가장_큰_수 {
	static class Solution {
		public String solution(int[] numbers) {
			StringBuilder sb = new StringBuilder();
			String[] tmp = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
			Arrays.sort(tmp,(o1, o2) ->(o2+o1).compareTo(o1+o2));
			Arrays.stream(tmp).forEach(sb::append);
			if(tmp[0].equals("0")) return "0";

			return sb.toString();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));

	}
}
