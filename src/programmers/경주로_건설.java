package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 경주로_건설 {
	static class Solution {
		int[][][] cost;
		boolean[][][] visited;
		int[] dy = new int[]{-1,1,0,0};
		int[] dx = new int[]{0,0,-1,1};
		public int solution(int[][] board) {
			int answer = Integer.MAX_VALUE;
			int n = board.length;
			cost = new int[n][n][4];
			visited = new boolean[n][n][4];
			for(int[][] a : cost){
				for(int[] b : a) Arrays.fill(b,Integer.MAX_VALUE);
			}

			Queue<int[]> que = new LinkedList<>();
			que.offer(new int[]{0,0,4});
			cost[0][0][0] = 0;
			cost[0][0][1] = 0;
			cost[0][0][2] = 0;
			cost[0][0][3] = 0;
			visited[0][0][0] = true;
			visited[0][0][1] = true;
			visited[0][0][2] = true;
			visited[0][0][3] = true;


			while(!que.isEmpty()){
				int[] cur = que.poll();
				for(int i =0;i<4;i++){
					int ny = cur[0] + dy[i];
					int nx = cur[1] + dx[i];

					if(ny < 0 || ny>= n || nx <0 || nx >=n) continue;
					if(board[ny][nx] == 1) continue;
					int value;
					if(cur[2] == 4)
						value = 100; //처음 상황 처리
					else{
						if(i == cur[2]) value = cost[cur[0]][cur[1]][cur[2]] + 100;
						else  value = cost[cur[0]][cur[1]][cur[2]] + 600;
					}
					if(!visited[ny][nx][i] ||cost[ny][nx][i] >= value ){
						cost[ny][nx][i] = Math.min(value,cost[ny][nx][i]);
						que.add(new int[]{ny,nx,i});
						visited[ny][nx][i] = true;
					}
				}
			}
			for(int t : cost[n-1][n-1]){
				answer = Math.min(t,answer);
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}
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
