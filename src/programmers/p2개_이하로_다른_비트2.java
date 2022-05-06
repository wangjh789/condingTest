package programmers;

import java.util.Arrays;

public class p2개_이하로_다른_비트2 {
    static class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            for(int i=0;i<numbers.length;i++){
                long tmp = numbers[i]+1;
                while(!isValid(numbers[i],tmp)){
                    tmp++;
                }
                answer[i] = tmp;
            }
            return answer;
        }
        private boolean isValid(long target,long num){
            return Long.bitCount(target ^ num)<=2;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new long[]{2, 7})));
    }
}
