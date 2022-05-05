package programmers;

import java.util.Arrays;

public class 네트워크2 {
    static class Solution {
        int[] parents;
        public int solution(int n, int[][] computers) {
            int answer = 0;
            parents = new int[n];
            for(int i =0;i<parents.length;i++)
                parents[i] = i;
            int N = computers.length;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i==j) continue;
                    if(computers[i][j] == 1 && getParent(i) != getParent(j)){
                        union(i,j);
                    }
                }
            }
            Arrays.sort(parents);
            int tmp = -1;
            for(int p : parents){
                if(tmp != p){
                    answer++;
                    tmp = p;
                }
            }
            return answer;
        }
        private int getParent(int a){
            if(parents[a] == a) return a;
            return getParent(parents[a]);
        }

        private void union(int a,int b){ //더 작은 쪽으로 수렴
            int aP = getParent(a);
            int bP = getParent(b);
            if(a>b){
                for(int i =0;i<parents.length;i++)
                    if(parents[i]==aP) parents[i] = bP;
            }else{
                for(int i =0;i<parents.length;i++)
                    if(parents[i]==bP) parents[i] = aP;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
                3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}
        ));
    }
}
