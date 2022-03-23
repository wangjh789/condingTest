package programmers;

import java.util.Arrays;

public class 스티커_모으기 {
	static class Solution {
		public int solution(int[] sticker) {
			if(sticker.length == 1) return sticker[0];
			int answer = 0;
			int[] dp = new int[sticker.length];
			// 첫번쨰 스티커를 무조건 뗀 상황
			dp[0] = sticker[0];
			dp[1] = sticker[0];
			for(int i =2;i<sticker.length-1;i++){
				dp[i] = Math.max(dp[i-1],dp[i-2]+sticker[i]);
			}
			//첫번째 스티커를 떼지 않은 상황
			int[] dp2 = new int[sticker.length];
			dp2[0] = 0;
			dp2[1] = sticker[1];
			for(int i =2;i<sticker.length;i++){
				dp2[i] = Math.max(dp2[i-1],dp2[i-2]+sticker[i]);
			}
			answer = Math.max(dp[dp.length-2],dp2[dp2.length-1]);
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{1, 3, 2, 5, 4}));

	}
}
