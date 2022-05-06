package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 아이템_줍기2 {
    static class Solution {
        int LEN = 51*2;
        int[] dy = new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int answer = 0;
            int[][] board = new int[LEN][LEN];
            boolean[][] visited = new boolean[LEN][LEN];
            for(int[] rect : rectangle){
                int x1 = rect[0]*2;
                int y1 = rect[1]*2;
                int x2 = rect[2]*2;
                int y2 = rect[3]*2;
                for(int i =y1;i<=y2;i++){
                    for(int j=x1;j<=x2;j++){
                        board[i][j]++;
                    }
                }

//                board[y1][x1] --;
//                board[y1][x2] --;
//                board[y2][x1] --;
//                board[y2][x2] --;
            }
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{characterY*2,characterX*2,0});
            visited[characterY*2][characterX*2] = true;

            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                System.out.println(cur[0]+" "+cur[1]);
                if(cur[0] == itemY*2 && cur[1]==itemX*2){
                    System.out.println(cur[2]);
                    continue;
                }
                for(int i =0;i<4;i++){
                    int ny= cur[0] + dy[i];
                    int nx = cur[1] + dx[i];

                    if(ny>=LEN || ny<0 || nx>=LEN || nx<0) continue;
                    if(board[ny][nx] == 0 || visited[ny][nx]) continue;
                    if(board[ny][nx]==1 && !isBoundary(board,ny,nx)) continue;
                    if(!(ny == itemY*2 && ny==itemX*2)){
                        visited[ny][nx] = true;
                    }
                    queue.offer(new int[]{ny,nx,cur[2]+1});
                }
            }
            for(int[] line:board){
                System.out.println(Arrays.toString(line));
            }
            return answer;
        }
        private boolean isBoundary(int[][] board,int y,int x){
            if(y+1 < LEN && board[y+1][x]==0) return true; //오른쪽 체크
            if(y-1 >= 0 && board[y-1][x] == 0) return true;
            if(x+1 < LEN && board[y][x+1]==0) return true;
            if(x-1 >= 0 && board[y][x-1] == 0) return true;
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(
                new int[][]{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},1,3,7,8
        ));
    }
}
