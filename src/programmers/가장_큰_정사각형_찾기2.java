package programmers;

import java.util.Arrays;

public class 가장_큰_정사각형_찾기2 {
    static class Solution {
        public int solution(int [][]board) {
            int answer = 0;
            int r = board.length;
            int c = board[0].length;
            int[][] dp = new int[r][c];
            for(int i =1;i<r;i++){
                for(int j=1;j<c;j++){
                    if(check(board,i,j)){
                        dp[i][j] = 1;

                        if(check(dp,i,j)){
                            dp[i][j] = getVal(dp,i,j);
                        }
                    }
                    answer =  Math.max(answer,dp[i][j]);
                }
            }
            return (answer+1)*(answer+1);
        }
        private int getVal(int[][] dp,int y,int x){
            int a = dp[y-1][x];
            int b = dp[y][x-1];
            int c = dp[y-1][x-1];
            int d = dp[y][x];
            return Math.min(Math.min(a,b),Math.min(c,d))+1;
        }
        private boolean check(int[][] board,int y,int x){
            int a = board[y-1][x];
            int b = board[y][x-1];
            int c = board[y-1][x-1];
            int d = board[y][x];
            return !(a == 0|| b==0 || c==0 || d==0);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{
                {0,0,1,1},{1,1,1,1}
        }));
    }
}
