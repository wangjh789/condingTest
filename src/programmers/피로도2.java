package programmers;

import java.util.Arrays;

public class 피로도2 {
    static class Solution {
        int answer = 0;
        public int solution(int k, int[][] dungeons) {
            boolean[] visited = new boolean[dungeons.length];
            dfs(k,dungeons,visited,0);

            return answer;
        }
        private void dfs(int k,int[][] dungeons,boolean[] visited,int count){
            answer = Math.max(count,answer);
            for(int i =0;i< dungeons.length;i++){
                if(!visited[i] && dungeons[i][0] <= k){
                    visited[i] = true;
                    dfs(k-dungeons[i][1],dungeons,visited,count+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        {80,20},{50,40},{30,10} 최소 피로도, 소모 피로도
        System.out.println(sol.solution(80,new int[][]{
                {80,20},{50,40},{30,10}
        }));
    }
}
