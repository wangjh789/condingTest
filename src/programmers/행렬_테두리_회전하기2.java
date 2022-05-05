package programmers;

import java.util.Arrays;

public class 행렬_테두리_회전하기2 {
    static class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int[] answer = new int[queries.length];
            int[][] board = new int[rows][columns];
            int count = 1;
            for(int i =0;i<rows;i++){
                for(int j=0;j<columns;j++){
                    board[i][j] = count++;
                }
            }
            for(int i =0;i< queries.length;i++){
                answer[i] = rotate(board,queries[i]);
            }
            return answer;
        }
        private int rotate(int[][] board, int[]query){
            int y1 = query[0]-1;
            int x1 = query[1]-1;
            int y2 = query[2]-1;
            int x2 = query[3]-1;

            int tmp = board[y1][x1];
            int min = tmp;

            for(int i=x1+1;i<=x2;i++){ //위
                int val = board[y1][i];
                board[y1][i] = tmp;
                tmp =val;

                min = Math.min(val,min);
            }
            for(int i=y1+1;i<=y2;i++){ //오
                int val = board[i][x2];
                board[i][x2] = tmp;
                tmp =val;

                min = Math.min(val,min);
            }
            for(int i=x2-1;i>=x1;i--){ //아래
                int val = board[y2][i];
                board[y2][i] = tmp;
                tmp = val;

                min = Math.min(val,min);
            }
            for(int i =y2-1;i>=y1;i--){ //왼
                int val = board[i][x1];
                board[i][x1] = tmp;
                tmp = val;

                min = Math.min(val,min);
            }
            return min;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(6, 6,
                new int[][]{
                        {2, 2, 5, 4},
                        {3, 3, 6, 6},
                        {5, 1, 6, 3}})));
    }
}
