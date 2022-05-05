package programmers;

public class 보행자_천국2 {
    static class Solution {
        int MOD = 20170805;
        public int solution(int m, int n, int[][] cityMap) {
            int answer = 0;
            int[][][] dist = new int[m][n][2]; //0: 아래, 1: 오른쪽
            for(int i =0;i<m;i++){ // row 초기화
                if(cityMap[i][0] == 1) break;
                dist[i][0][0] = 1; //아래로 빠지는
                if(cityMap[i][0] == 2) continue;
                dist[i][0][1] = 1; //오른쪽으로 빠지는
            }
            for(int j=0;j<n;j++){ //col 초기화
                if(cityMap[0][j] == 1) break;
                dist[0][j][1] = 1; //오른쪽
                if(cityMap[0][j] == 2) continue;
                dist[0][j][0] = 1; //아래
            }
            for(int i =1;i<m;i++){
                for(int j=1;j<n;j++){
                    if(cityMap[i][j] == 1) continue;
                    if(cityMap[i][j] == 0){
                        dist[i][j][0] = (dist[i-1][j][0] + dist[i][j-1][1])%MOD;
                        dist[i][j][1] = (dist[i-1][j][0] + dist[i][j-1][1])%MOD;
                    }else{
                        dist[i][j][0] = dist[i-1][j][0];
                        dist[i][j][1] = dist[i][j-1][1];
                    }
                }
            }

            return dist[m-1][n-1][0];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(3,6,new int[][]{
                {0, 2, 0, 0, 0, 2},
                {0, 0, 2, 0, 1, 0},
                {1, 0, 0, 2, 2, 0}
        }));
    }
}
