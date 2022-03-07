package programmers;

import java.util.Arrays;

public class 도둑질 {
	static class Solution {
		public int solution(int[] money) {
			int answer;
			int[] dp = new int[money.length];

			// 첫번쨰 집 털고, 마지막 집 털지 않는 경우
			dp[0] = money[0];
			dp[1] = Math.max(money[0],money[1]);
			for(int i=2;i<money.length-1;i++) dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]);

			answer = dp[money.length-2];
			Arrays.fill(dp,0);

			dp[1]  = money[1];
			//첫번째 집 무조건 안터는 경우
			for(int i=2;i<money.length;i++) dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]);
//			System.out.println(Arrays.toString(dp));
			answer = Math.max(answer,dp[money.length-1]);
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{1,2,3}));

	}
}
