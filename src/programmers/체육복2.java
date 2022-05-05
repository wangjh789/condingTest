package programmers;

import java.util.Arrays;

public class 체육복2 {
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            int[] stus = new int[n];
            Arrays.fill(stus,1);
            for(int lo : lost) stus[lo-1]--;
            for(int res : reserve) stus[res-1]++;
            if(stus[0]==2 && stus[1]==0){
                stus[0]--;
                stus[1]++;
            }
            for(int i =0;i<n;i++){
                if(i+1 <n && stus[i]==0 && stus[i+1] ==2){
                    stus[i]++;
                    stus[i+1]--;
                }
                if(i-1 >=0 && stus[i]==0 && stus[i-1]==2){
                    stus[i]++;
                    stus[i-1]--;
                }
            }
            if(stus[n-2]==2 && stus[n-1]==0){
                stus[n-2]--;
                stus[n-1]++;
            }
            for(int stu : stus){
                if(stu>=1) answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5,new int[]{2,4},new int[]{1,3,5}));
    }
}
