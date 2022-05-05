package programmers;

import java.util.Arrays;

public class 정수_삼각형2 {
    static class Solution {
        public int solution(int[][] triangle) {
            int answer =0;
            int N = triangle.length;
            int[][] dp = new int[N][N];
            dp[0][0] = triangle[0][0];
            for(int i =0;i<N-1;i++){
                for(int j=0;j<=i;j++){
                    dp[i+1][j] = Math.max(dp[i+1][j],dp[i][j]+ triangle[i+1][j]);
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1],dp[i][j]+ triangle[i+1][j+1]);
                }
            }
            for(int i :dp[N-1]) answer = Math.max(answer,i);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{
                {7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}
        }));
    }
}
