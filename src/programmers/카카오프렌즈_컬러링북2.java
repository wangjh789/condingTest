package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오프렌즈_컬러링북2 {
    static class Solution {
        int[] dy = new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        boolean[][] visited;
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            visited = new boolean[m][n];
            for(int i =0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(!visited[i][j] && picture[i][j] != 0){
                        Queue<int[]> que= new LinkedList<>();
                        que.offer(new int[]{i,j});
                        visited[i][j] = true;
                        int size = 1;
                        while(!que.isEmpty()){
                            int[] target = que.poll();
                            for(int k=0;k<4;k++){
                                int ny = target[0] + dy[k];
                                int nx = target[1] + dx[k];
                                if(ny >= m || nx >= n || ny < 0 || nx <0) continue;
                                if(visited[ny][nx] ||
                                        picture[ny][nx] == 0 ||
                                        picture[ny][nx] != picture[i][j]) continue;

                                visited[ny][nx] = true;
                                size++;
                                que.offer(new int[]{ny,nx});
                            }
                        }
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea,size);
                        numberOfArea++;
                    }
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] ints = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}
        };
        System.out.println(Arrays.toString(
                solution.solution(6, 4, ints)));
    }
}
