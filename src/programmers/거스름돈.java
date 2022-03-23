package programmers;

import java.util.Arrays;
import java.util.Set;

public class 거스름돈 {
	static class Solution {
		public int solution(int n, int[] money) {
			Arrays.sort(money);
			int[][] dp = new int[money.length+1][n+1]; //i: 사용한 지폐의 종류 , j: 지불하는 가지수
			dp[0][0] = 1;
			for(int i=1;i<dp.length;i++){
				for(int j=0;j<n+1;j++){
					if(money[i-1] > j){
						dp[i][j] = dp[i-1][j];
					}else if(money[i-1] == j) dp[i][j] = (dp[i-1][j] + 1)%1000000007;
					else{
						dp[i][j] = (dp[i-1][j] + dp[i][j-money[i-1]])%1000000007;
					}
				}
			}
//			for(int[] line:dp){
//				System.out.println(Arrays.toString(line));
//			}
			return dp[money.length][n];
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5,new int[]{1,2,5}));

	}
}
