package programmers;

import java.util.Arrays;

public class 섬_연결하기2 {
    static class Solution {
        int[] parent;
        public int solution(int n, int[][] costs) {
            int answer = 0;
            parent = new int[n];
            for(int i =0;i<parent.length;i++) parent[i] = i;
            Arrays.sort(costs,(o1, o2) -> o1[2]-o2[2]);
            for(int[] cost : costs){
                if(!isCycle(cost[0],cost[1])){
                    union(cost[0],cost[1]);
                    answer+= cost[2];
                }
            }
            return answer;
        }

        private void union(int a,int b){
            int aP = getParent(a);
            int bP = getParent(b);
            if(a<b){
                for(int i=0;i<parent.length;i++){
                    if(parent[i]==bP) parent[i] = aP;
                }
            }else{
                for(int i=0;i<parent.length;i++){
                    if(parent[i]==aP) parent[i] = bP;
                }
            }
        }

        private boolean isCycle(int a,int b){
            return getParent(a) == getParent(b);
        }

        private int getParent(int a){
            if(parent[a] ==a) return a;
            return getParent(parent[a]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(4,new int[][]{
                {0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}
        }));
    }
}
