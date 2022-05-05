package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class 프렌즈4블록2 {
    static class Solution {
        public int solution(int m, int n, String[] board) {
            int answer = 0;
            char[][] chars = new char[m][n];
            for(int i =0;i<board.length;i++){
                chars[i] = board[i].toCharArray();
            }
            while(true){
                List<int[]> remove = new ArrayList<>();
                for(int i =0;i<m-1;i++){
                    for(int j=0;j<n-1;j++){
                        if(chars[i][j] == '.') continue;
                        if(check(chars,i,j))
                            remove.add(new int[]{i,j});
                    }
                }
                if(remove.isEmpty())break;

                for(int[] rm : remove){
                    for(int i =rm[0];i<rm[0]+2;i++){
                        for(int j=rm[1];j<rm[1]+2;j++){
                            if(chars[i][j] != '.'){
                                answer++;
                                chars[i][j] = '.';
                            }
                        }
                    }
                }
                // 당기기
                for(int col = 0;col<n;col++){
                    Stack<Character> st = new Stack<>();
                    for(int row=m-1;row>=0;row--){
                        if(chars[row][col] != '.')
                            st.push(chars[row][col]);
                    }
                    while(st.size() < m)
                        st.push('.');
                    for(int row=0;row<m;row++){
                        chars[row][col] = st.pop();
                    }
                }


            }
            return answer;
        }
        private boolean check(char[][] board,int y,int x){
            char target = board[y][x];
            if(board[y+1][x] == target &&
                    board[y][x+1]==target &&
                    board[y+1][x+1] == target) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(6,6,new String[]{
                "TTTANT",
                "RRFACC",
                "RRRFCC",
                "TRRRAA",
                "TTMMMF",
                "TMMTTJ"
        }));
    }
}
