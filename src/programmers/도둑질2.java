package programmers;

import java.util.Arrays;

public class 도둑질2 {
    static class Solution {
        public int solution(int[] money) {
            int answer = 0;
            int[] dp = new int[money.length];
            //첫번째 집을 무조건 터는 경우
            dp[0] = money[0];
            dp[1] = dp[0];
            for(int i=2;i<money.length-1;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]);
                answer = Math.max(answer,dp[i]);
            }
            //첫번째 집을 무조건 털지 않는 경우
            dp[0] = 0;
            dp[1] = money[1];
            for(int i=2;i<money.length;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]);
                answer = Math.max(answer,dp[i]);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1, 2, 3, 1}));
    }
}
