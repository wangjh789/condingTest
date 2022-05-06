package programmers;

import java.util.Arrays;

public class 이진_변환_반복하기2 {
    static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];
            StringBuilder sb = new StringBuilder(s);
            int zeroCount =0;
            int round = 0;
            while(!(sb.length() == 1 && sb.charAt(0) =='1')){
                int idx = sb.indexOf("0");
                while(idx!=-1){
                    zeroCount++;
                    sb.deleteCharAt(idx);
                    idx = sb.indexOf("0");
                }
                sb = new StringBuilder(Integer.toBinaryString(sb.length()));
                round++;
            }
            answer[0] = round;
            answer[1] = zeroCount;

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution("110010101001")));
    }
}
