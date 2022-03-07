package programmers;

import java.util.Arrays;

public class 정수_삼각형 {
	static class Solution {
		public int solution(int[][] triangle) {
			int answer = 0;
			int[][] dp = new int[triangle.length][triangle.length];
			dp[0][0] = triangle[0][0];
			for(int i=1;i< triangle.length;i++){
				dp[i][0] = triangle[i][0] + dp[i-1][0];

				for(int j=1;j<i+1;j++){
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-1]) + triangle[i][j];
				}
			}
			for(int i=0;i< triangle.length;i++){
				answer  = Math.max(answer,dp[triangle.length-1][i]);
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
		System.out.println(sol.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));

	}
}
