package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 블록_이동하기2 {
    static class Solution {
        int[] dy = new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        int N;
        public int solution(int[][] board) {
            int answer = Integer.MAX_VALUE;
            N = board.length;
            boolean[][][][] visited = new boolean[N][N][N][N];
            visited[0][0][0][1] = true;
            Queue<Pos> queue = new LinkedList<>();
            queue.offer(new Pos(0,0,0,1,0,0));
            while(!queue.isEmpty()){
                Pos cur = queue.poll();
                if((cur.y1==N-1 && cur.x1==N-1) || (cur.y2==N-1 && cur.x2==N-1)){
                    answer = Math.min(answer,cur.step);
                    continue;
                }
                for(int i =0;i<4;i++){ //이동
                    int ny1 = cur.y1 + dy[i];
                    int nx1 = cur.x1 + dx[i];
                    int ny2 = cur.y2 + dy[i];
                    int nx2 = cur.x2 + dx[i];
                    if(ny1 >= N || nx1 >=N || ny1 <0 || nx1 <0) continue;
                    if(ny2 >= N || nx2 >=N || ny2 <0 || nx2 <0) continue;
                    if(board[ny1][nx1] ==1 || board[ny2][nx2] == 1) continue;
                    if(visited[ny1][nx1][ny2][nx2]) continue;
                    visited[ny1][nx1][ny2][nx2] = true;
                    queue.offer(new Pos(ny1,nx1,ny2,nx2,cur.step+1,cur.sh));
                }
                int y1 = cur.y1;
                int x1 = cur.x1;
                int y2 = cur.y2;
                int x2 = cur.x2;

                if(cur.sh == 0){ // 수평 -> 수직
                    //위로 회전 (회전하려는 방향이 비었으면)
                    if(y1-1>=0 && board[y1-1][x1]==0 && y2-1>=0 && board[y2-1][x2] == 0){
                        if(!visited[y1-1][x1][y1][x1]){
                            visited[y1-1][x1][y1][x1] = true;
                            queue.offer(new Pos(y1-1,x1,y1,x1,cur.step+1,1)); //node1 기준
                        }
                        if(!visited[y2-1][x2][y2][x2]) {
                            visited[y2-1][x2][y2][x2] = true;
                            queue.offer(new Pos(y2 - 1, x2, y2, x2, cur.step + 1, 1)); //node2 기준
                        }
                    }
                    //아래로 회전
                    if(y1+1<N && board[y1+1][x1]==0 && y2+1<N && board[y2+1][x2] == 0){
                        if(!visited[y1][x1][y1+1][x1]) {
                            visited[y1][x1][y1+1][x1] = true;
                            queue.offer(new Pos(y1, x1, y1 + 1, x1, cur.step + 1, 1)); //node1 기준
                        }
                        if(!visited[y2][x2][y2+1][x2]) {
                            visited[y2][x2][y2+1][x2] = true;
                            queue.offer(new Pos(y2, x2, y2 + 1, x2, cur.step + 1, 1)); //node2 기준
                        }
                    }
                }else{ // 수직 -> 수평
                        //왼쪽으로 회전
                    if(x1-1>=0 && board[y1][x1-1]==0 && x2-1>=0 && board[y2][x2-1] == 0){
                        if(!visited[y1][x1-1][y1][x1]) {
                            visited[y1][x1-1][y1][x1] = true;
                            queue.offer(new Pos(y1, x1 - 1, y1, x1, cur.step + 1, 0)); //node1 기준
                        }
                        if(!visited[y2][x2-1][y2][x2]) {
                            visited[y2][x2-1][y2][x2] = true;
                            queue.offer(new Pos(y2, x2 - 1, y2, x2, cur.step + 1, 0)); //node2 기준
                        }
                    }//오른쪽으로 회전
                    if(x1+1<N && board[y1][x1+1]==0 && x2+1<N && board[y2][x2+1] == 0){
                        if(!visited[y1][x1][y1][x1+1]) {
                            visited[y1][x1][y1][x1+1] = true;
                            queue.offer(new Pos(y1, x1, y1, x1 + 1, cur.step + 1, 0)); //node1 기준
                        }
                        if(!visited[y2][x2][y2][x2+1]) {
                            visited[y2][x2][y2][x2+1] = true;
                            queue.offer(new Pos(y2, x2, y2, x2 + 1, cur.step + 1, 0)); //node2 기준
                        }
                    }
                }
            }
            return answer;
        }

        class Pos{
            int y1;
            int x1;
            int y2;
            int x2;
            int step;
            int sh; //0 : 평행 1 : 수직
            public Pos(int y1, int x1, int y2, int x2,int step, int sh) {
                this.y1 = y1;
                this.x1 = x1;
                this.y2 = y2;
                this.x2 = x2;
                this.step = step;
                this.sh = sh;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 0, 0}
        }));
    }
}
