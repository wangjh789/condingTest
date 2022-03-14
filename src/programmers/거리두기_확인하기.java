package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 거리두기_확인하기 {
	static class Solution {
		int[] dy = new int[]{-1,1,0,0};
		int[] dx = new int[]{0,0,-1,1};
		public int[] solution(String[][] places) {
			int[] answer = new int[places.length];
			for(int k=0;k<places.length;k++){ //각 대기실 마다 체크
				boolean isSafe = true;
				for(int i=0;i<5;i++){
					for(int j=0;j<5;j++){
						if(places[k][i].charAt(j) != 'P') continue;
						int[][] dist = new int[5][5];
						Queue<int []> que = new LinkedList<>();
						que.offer(new int[]{i,j});
						while(!que.isEmpty()){
							int[] cur = que.poll();
							for(int z=0;z<4;z++){
								int ny = cur[0] + dy[z];
								int nx = cur[1] + dx[z];
								if(ny <0 || ny >= 5 || nx <0 || nx >=5) continue;
								if(places[k][ny].charAt(nx) == 'X') continue;
								if(dist[ny][nx] != 0 || (ny==i && nx ==j)) continue; //이미 지나온 길
								dist[ny][nx] = dist[cur[0]][cur[1]]+1;
								if(places[k][ny].charAt(nx) == 'P' && dist[ny][nx] <= 2){
//									System.out.println(k+"번째 회의실   "+i+" "+j+"    "+ny+" "+nx);
									isSafe = false;
									break;
								}
								que.add(new int[]{ny,nx});
							}
							if(!isSafe) break;
						}
						if(!isSafe) break;
					}
					if(!isSafe) break;
				}
				answer[k] = isSafe?1:0;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
//		{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
//		{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
//		{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
//		{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
//		[1, 0, 1, 1, 1]
		System.out.println(Arrays.toString(sol.solution(new String[][]{
				{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
				{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
				{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
				{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
				{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
		})));

	}
}
