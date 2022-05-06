package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 삼각_달팽이2 {
    static class Solution {
        int[][] board;
        public int[] solution(int n) {
            List<Integer> answer = new ArrayList<>();
            board = new int[n][n];
            build(n,0,0,1);
            for(int i =0;i<n;i++){
                for(int j=0;j<=i;j++){
                    answer.add(board[i][j]);
                }
            }
            return answer.stream().mapToInt(i->i).toArray();
        }
        private void build(int n,int y,int x,int num){
            //...
            for(int i =0;i<n;i++){ //아래 로
                board[y+i][x] = num++;
            }
            for(int i=1;i<n;i++){ //왼쪽으로
                board[y+n-1][x+i] = num++;
            }
            for(int i=1;i<n-1;i++){
                board[y+n-1-i][x+n-1-i] = num++;
            }

            if(n-2 > 0){
                build(n-3,y+2,x+1,num);
            }
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(5)));
    }
}
