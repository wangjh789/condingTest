package programmers;

import java.util.Arrays;

public class 합승_택시_요금2 {
    static class Solution {
        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = 100001;
            int[] cost = new int[n];
            int[][] dist = new int[n][n];
            Arrays.fill(cost,100001*n);
            for(int i =0;i<n;i++)
                for(int j=0;j<n;j++)
                    if(i!=j) dist[i][j] = 100001*n;
            for(int[] fare : fares){
                dist[fare[0]-1][fare[1]-1] = fare[2];
                dist[fare[1]-1][fare[0]-1] = fare[2];
            }
            for(int k=0;k<n;k++){ //플루이드 와샬
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        if(i == j) continue;
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
            for(int i =0;i<n;i++){
                cost[i] = dist[s-1][i] + dist[i][a-1] + dist[i][b-1];
                answer = Math.min(cost[i],answer);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(6,4,6,2,new int[][]{
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        }));
    }
}
