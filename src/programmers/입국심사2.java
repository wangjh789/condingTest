package programmers;

import java.util.Arrays;

public class 입국심사2 {
    static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            Arrays.sort(times);
            long right = (long) times[times.length - 1] *n;
            long left = 0;
            while(left<= right){
                long mid = (right+left)/2;
                long val = 0; //mid 초에 처리할 수 있는 사람 수
                for(int time :times){
                    val += mid/time;
                }
                if(n > val){ //mid초 보다 더 시간이 필요할 때
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            return left;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(6,new int[]{7,10}));
    }

}
