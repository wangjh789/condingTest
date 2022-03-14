package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {
	static class Solution {
		int[] dy = new int[]{-1,1,0,0};
		int[] dx = new int[]{0,0,-1,1};
		public int solution(int[][] maps) {
			int answer = 0;
			final int Y = maps.length;
			final int X = maps[0].length;
			int[][] memo = new int[Y][X];
			memo[0][0] = 1;
			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[]{0,0});
			while(!que.isEmpty()){
				int[] cur = que.poll();
				for(int i=0;i<4;i++){
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];

					if(ny <0 || ny >= Y || nx <0 || nx >= X) continue;
					if(memo[ny][nx] != 0) continue; //이미 방문한 적있음
					if(maps[ny][nx] == 0) continue;//막혀 있는 곳
					memo[ny][nx] = memo[cur[0]][cur[1]] +1;
					que.offer(new int[]{ny,nx});
				}
			}
			if(memo[Y-1][X-1] != 0){
				return memo[Y-1][X-1];
			}
			return -1;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}
		System.out.println(sol.solution(new int[][]{
				{1,0,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,1,1,0,1},
				{0,0,0,0,1}}));

	}
}
