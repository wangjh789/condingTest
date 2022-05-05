package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로_건설2 {
    //코너 600원
    //직진 100원
    static class Solution {
        int[] dy = new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        int FORWARD = 100;
        int CORNER = 500;
        public int solution(int[][] board) {
            int answer = Integer.MAX_VALUE;
            int N = board.length;
            int[][][] dist = new int[N][N][4];
            for(int i =0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(i == 0 && j == 0) continue;
                    Arrays.fill(dist[i][j],Integer.MAX_VALUE);
                }
            }

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(0,0,-1,0)); //첫 시작은 dir -1
            while(!queue.isEmpty()){
                Node cur = queue.poll();
//                System.out.println(cur.toString());

                if(cur.x == N-1 && cur.y == N-1){
                    answer = Math.min(answer,cur.cost);
                    continue;
                }
                if(cur.cost > answer) continue;

                for(int i=0;i<4;i++){
                    int ny = cur.y + dy[i];
                    int nx = cur.x + dx[i];

                    if(ny >=N || nx >=N || ny <0 || nx<0) continue; //범위 밖
                    if(board[ny][nx] == 1 ) continue; //벽에 막히거나 이미 더 효율적으로 왔으면
                    int cost = 0;
                    if(cur.dir == -1){ //첫 시작이면
                        cost = FORWARD;
                    }else{
                        if(cur.dir != i) //방향이 다르면
                            cost = cur.cost+FORWARD+CORNER;
                        else
                            cost = cur.cost+FORWARD;
                    }
                    if(dist[ny][nx][i] < cost) continue;
                    dist[ny][nx][i] = cost;
                    queue.offer(new Node(ny,nx,i,cost));
                }
            }
//            for(int[] line: dist){
//                System.out.println(Arrays.toString(line));
//            }
            return answer;
        }

        class Node{
            int y;
            int x;
            int dir;
            int cost;
            Node(int y,int x,int dir,int cost){
                this.y = y;
                this.x =x ;
                this.dir =dir;
                this.cost= cost;
            }

        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{
                {0,0,0,0,0,0,0,1},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,1,0,0},
                {0,0,0,0,1,0,0,0},
                {0,0,0,1,0,0,0,1},
                {0,0,1,0,0,0,1,0},
                {0,1,0,0,0,1,0,0},
                {1,0,0,0,0,0,0,0}
        }));

    }
}
