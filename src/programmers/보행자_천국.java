package programmers;

import java.util.*;

public class 보행자_천국 {
	static class Solution {
		int MOD = 20170805;

		public int solution(int m, int n, int[][] cityMap) {
			int answer = 0;
			int dp[][][] = new int[m][n][2];//0 : 아래로 , 1:오른쪽으로
			for(int i=0;i<m;i++){ //row 초기화
				if(cityMap[i][0]==1) break;
				dp[i][0][0] = 1;
				if(cityMap[i][0]==2) continue;
				dp[i][0][1] = 1;
			}
			for(int j=0;j<n;j++){ //col 초기화
				if(cityMap[0][j]==1) break;
				dp[0][j][1] = 1;
				if(cityMap[0][j]==2) continue;
				dp[0][j][0] = 1;
			}
			for(int i=1;i<m;i++){
				for(int j=1;j<n;j++){
					if(cityMap[i][j]==1) continue;

					if(cityMap[i][j]==0){
						dp[i][j][0] += (dp[i-1][j][0] + dp[i][j-1][1])%MOD;
						dp[i][j][1] += (dp[i-1][j][0] + dp[i][j-1][1])%MOD;
					}else{
						dp[i][j][0] = dp[i-1][j][0];
						dp[i][j][1] = dp[i][j-1][1];
					}
				}
			}
			return dp[m-1][n-1][0];
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0, 0, 0}, {0, 0, 0}, {0, 0, 0}
//		{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}
		System.out.println(sol.solution(3,6,new int[][]{
				{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}
		}));

	}
}
