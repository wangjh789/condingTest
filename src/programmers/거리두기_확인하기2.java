package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기2 {
    static class Solution {
        int[] dy = new int[]{-1,1,0,0};
        int[] dx = new int[]{0,0,-1,1};
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];
            for(int k =0;k< places.length;k++){
                String[] place = places[k];
                boolean[][] checked = new boolean[5][5];
                boolean hasProb = false;
                for(int i =0;i<5;i++){
                    for(int j=0;j<5;j++){
                        if(place[i].charAt(j) == 'P' && !checked[i][j]){ //사람이고 아직 확인 안했을때
                            Queue<int[]> que = new LinkedList<>();
                            que.offer(new int[]{i,j,0});
                            checked[i][j] = true;

                            while(!que.isEmpty()){
                                int[] pos = que.poll();
                                if(pos[2] > 2) break;
                                for(int dir =0;dir<4;dir++){
                                    int ny = pos[0] + dy[dir];
                                    int nx = pos[1] + dx[dir];
                                    if(ny >= 5 || nx >= 5 || nx <0 || ny <0) continue;
                                    if(place[ny].charAt(nx)=='X' || checked[ny][nx]) continue;
                                    checked[ny][nx] = true;
                                    if(place[ny].charAt(nx) == 'P' && pos[2]+1 <= 2){
                                        hasProb = true;
                                        break;
                                    }
                                    que.offer(new int[]{ny,nx,pos[2]+1});
                                }
                                if(hasProb) break;
                            }
                            if(hasProb) break;
                        }
                        if(hasProb) break;
                    }
                    if(hasProb) break;
                }
                answer[k] = hasProb?0:1;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        })));
//        {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
    }
}
