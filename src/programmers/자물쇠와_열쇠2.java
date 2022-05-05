package programmers;

import java.util.Arrays;

public class 자물쇠와_열쇠2 {
    static class Solution {
        public boolean solution(int[][] key, int[][] lock) {
            boolean answer = false;
            int N = key.length;
            int M = lock.length;
            int[][] board = setBoard(N,M,lock);
            for(int i =0;i<board.length;i++){
                for(int j=0;j< board.length;j++){
                    int[][] tKey = copyKey(key,N);
                    for(int k =0;k<3;k++){ //rotate
                        tKey = rotate(tKey,N);

                        if(check(N,M,i,j,board,tKey)){
                            System.out.println("tt");
                            return true;
                        }
                    }
                }
            }
            for(int[] lien : board){
                System.out.println(Arrays.toString(lien));
            }
            return answer;
        }

        private boolean check(int N,int M,int y,int x,int[][]board,int[][]tKey){
            for(int i=N-1;i<N-1+M;i++){
                for(int j=N-1;j<N-1+M;j++){
                    int val = board[i][j];
                    if(i < y+N && j < x+N){
                        val += tKey[i+y-1][j+x-1];
                    }
                    if(val != 1) return false;

                }
            }
            return true;
        }
        private int[][] rotate(int[][] tKey,int N){
            int[][] result = new int[N][N];
            for(int i =0;i<N;i++){
                for(int j=0;j<N;j++){
                    result[i][j] = tKey[j][N-1-i];
                }
            }
            return result;
        }
        private int[][] copyKey(int[][] key,int N){
            int[][] tKey = new int[N][N];
            for(int i =0;i<N;i++){
                for(int j=0;j<N;j++){
                    tKey[i][j] = key[i][j];
                }
            }
            return tKey;
        }

        private int[][] setBoard(int N,int M,int[][] lock){
            int[][] board = new int[((N-1)*2)+M][((N-1)*2)+M];
            for(int i =0;i<M;i++){
                for(int j =0;j<M;j++){
                    board[i+N-1][j+N-1] = lock[i][j];
                }
            }
            return board;
        }
    }

    public static void main(String[] args) {
        int[][] key = new int[][]{
                {0, 0, 0}, {1, 0, 0}, {0, 1, 1}
        };
        int[][] lock = new int[][]{
                {1, 1, 1}, {1, 1, 0}, {1, 0, 1}
        };
        Solution sol = new Solution();
        System.out.println(sol.solution(key,lock));
    }
}
