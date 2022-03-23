package programmers;

import java.util.Arrays;

public class 가장_큰_정사각형_찾기 {
	static class Solution {
		public int solution(int [][]board) {
			int answer = 0;
			int [][] dp = new int[board.length][board[0].length];
			for(int i=0;i<board.length;i++) dp[i][0] = board[i][0];
			for(int j=0;j<board[0].length;j++){
				answer = Math.max(answer,board[0][j]);
				dp[0][j] = board[0][j];
			}

			for(int i=1;i<board.length;i++){
				for(int j=1;j<board[0].length;j++){
					if(board[i][j] == 0) continue;
					int a = dp[i-1][j];
					int b = dp[i][j-1];
					int c = dp[i-1][j-1];
					if(a==0 || b==0 || c==0) dp[i][j] = 1; //하나라도 0이 있으면
					else if(a==b && b==c){
						dp[i][j] = a+1;
					}else{
						int val = Math.min(Math.min(a,b),c);
						dp[i][j] = val+1;
					}
					answer = Math.max(dp[i][j],answer);
				}
			}
//			for(int[] line : dp){
//				System.out.println(Arrays.toString(line));
//			}
			return answer*answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}

		System.out.println(sol.solution(new int[][]{
				{0,1,1,1},
				{1,1,1,1},
				{1,1,1,1},
				{0,0,1,0}
		}));

	}
}
