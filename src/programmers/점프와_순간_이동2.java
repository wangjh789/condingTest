package programmers;

import java.util.Arrays;

public class 점프와_순간_이동2 {
    static public class Solution {
        public int solution(int n) {
            int ans = 0;
            int[] dp = new int[n+1];
            Arrays.fill(dp,n);
            dp[0] = 0;
            for(int i =1;i<n+1;i++){
                dp[i] = dp[i-1]+1;
                if(i%2==0) dp[i] = Math.min(dp[i],dp[i/2]);
            }
            System.out.println(Arrays.toString(dp));



            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5));
    }
}
