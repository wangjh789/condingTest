package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리2 {
    static class Solution {
        int[] dy=  new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        int answer =-1;
        public int solution(int[][] maps) {
            boolean[][] visited= new boolean[maps.length][maps[0].length];
            visited[0][0] = true;
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{0,0,1});
            while(!que.isEmpty()){
                int[] cur = que.poll();
                if(cur[0] == maps.length-1 && cur[1] == maps[0].length-1){
                    answer = answer==-1? cur[2] : Math.min(answer,cur[2]);
                }
                for(int i =0;i<4;i++){
                    int ny = cur[0] + dy[i];
                    int nx = cur[1] + dx[i];
                    if(ny >= maps.length || ny <0 || nx >= maps[0].length || nx <0) continue;
                    if(visited[ny][nx] || maps[ny][nx] == 0) continue;
                    visited[ny][nx] = true;
                    que.offer(new int[]{ny,nx,cur[2]+1});
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,1},
                {0,0,0,0,1}
        }));
    }
}
