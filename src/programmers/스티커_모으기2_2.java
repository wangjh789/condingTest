package programmers;

import java.util.Arrays;

public class 스티커_모으기2_2 {
    static class Solution {
        public int solution(int[] sticker) {
            if(sticker.length ==1){
                return sticker[0];
            }else if(sticker.length==2){
                return Math.max(sticker[0],sticker[1]);
            }

            int answer = 0;
            int[] dp = new int[sticker.length];
            //첫번째 스티커를 뜯는 경우
            dp[0] = sticker[0];
            dp[1] = dp[0];
            for(int i =2;i<sticker.length-1;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+sticker[i]);
            }
            answer = dp[sticker.length-2];
            //첫번째 스티커를 뜯지 않는 경우
            dp[0]=0;
            dp[1] = sticker[1];
            for(int i =2;i<sticker.length;i++){
                dp[i] = Math.max(dp[i-1],dp[i-2]+sticker[i]);
            }
            answer = Math.max(answer,dp[sticker.length-1]);


            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{14, 6, 5, 11, 3, 9, 2, 10}));
    }
}
