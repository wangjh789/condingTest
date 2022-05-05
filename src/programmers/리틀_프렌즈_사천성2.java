package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 리틀_프렌즈_사천성2 {
    static class Solution {
        int[] dy = new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        public String solution(int m, int n, String[] board) {
            StringBuilder answer = new StringBuilder();
            char[][] boardChar = new char[m][n];
            for(int i =0;i<m;i++)
                for(int j=0;j<n;j++)
                    boardChar[i][j] = board[i].charAt(j);
            boolean possible = true;
            while (possible) {
                possible = false; // 하나라도 지워지면 true
                for(int i =0;i<m;i++){
                    for(int j=0;j<n;j++){
                        boolean[][] visited  = new boolean[m][n];
                        if(Character.isAlphabetic(boardChar[i][j])){
                            char target = boardChar[i][j];
                            Queue<int[]> queue = new LinkedList<>();
                            queue.offer(new int[]{i,j,-1,0}); //y,x,이전 방향, 커브
                            visited[i][j] = true;
                            while(!queue.isEmpty()){
                                int[] cur = queue.poll();
                                if(cur[3] == 2) continue; //커브 2번이상 함
                                if((cur[0]!=i ||cur[1] != j )&&
                                        boardChar[cur[0]][cur[1]]==target){
                                    System.out.println(target);
                                    possible = true;
                                    boardChar[cur[0]][cur[1]] = '.';
                                    boardChar[i][j] = '.';
                                    answer.append(target);
                                    break;
                                }
                                for(int dir=0;dir<4;dir++){
                                    int ny = dy[dir] + cur[0];
                                    int nx = dx[dir] + cur[1];
                                    if(ny >= m || nx>=n || ny <0 || nx <0) continue;
                                    if(visited[ny][nx] || boardChar[ny][nx] == '*') continue;
                                    if(Character.isAlphabetic(boardChar[ny][nx]) && boardChar[ny][nx] != target) continue;
                                    visited[ny][nx] = true;
                                    if(cur[0] == i && cur[1] == j){ //처음 시작일 경우
                                        queue.offer(new int[]{ny,nx,dir,0});
                                    }else{ //방향이 동일하면
                                        if(cur[2] == dir) queue.offer(new int[]{ny,nx,dir,cur[3]});
                                        else queue.offer(new int[]{ny,nx,dir,cur[3]+1});
                                    }
                                }
                            }
                        }
                        if(possible) break;
                    }
                    if(possible) break;
                }
//                if(!possible) return "IMPOSSIBLE";
            }
            return answer.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                sol.solution(4,4,
                        new String[]{
                                ".ZI.", "M.**", "MZU.", ".IU."}));
    }
}
