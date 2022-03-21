package programmers;

import java.util.Arrays;

public class 이진_변환_반복하기 {
	static class Solution {
		public int[] solution(String s) {
			int[] answer = new int[2];
			int zero = 0;
			int count = 0;
			StringBuilder sb = new StringBuilder(s);
			while(!(sb.length() == 1 && sb.charAt(0)=='1')){
				count++;
				int idx = sb.indexOf("0");
				while(idx != -1){
					sb.deleteCharAt(idx);
					zero++;
					idx = sb.indexOf("0");
				}
				int len = sb.length();
				sb = new StringBuilder(Integer.toBinaryString(len));
			}
			answer[0] = count;
			answer[1] = zero;
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution("110010101001")));

	}
}
