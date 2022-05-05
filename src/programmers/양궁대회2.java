package programmers;

import java.util.Arrays;

public class 양궁대회2 {
    static class Solution {
        int max = -1;
        int[] answer = new int[]{-1};
        public int[] solution(int n, int[] info) {

            dfs(n,info,new int[11],0);

            return answer;
        }

        private void dfs(int n,int[] info,int[] log,int idx){
            if(n == 0){
                int val = calScore(info,log);
                if(val == -1) return;
                System.out.println(Arrays.toString(log)+" "+val);
                if(max < val){
                    max = val;
                    answer = Arrays.copyOf(log,11);
                }
                return;
            }
            if(idx > 10) return;
            for(int i=0;i<=n;i++){
                log[idx] = i;
                dfs(n-i,info,log,idx+1);
                log[idx] = 0;
            }
        }
        private int calScore(int[] a,int[] l){
            int aScore = 0;
            int lScore = 0;
            for(int i =0;i<11;i++){
                if(a[i] == 0 && l[i] == 0) continue;
                if(a[i] >= l[i]) aScore+= 10-i;
                else lScore+= 10-i;
            }
            return lScore > aScore? lScore-aScore:-1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(5, new int[]{2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0})));
    }
}
