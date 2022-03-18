package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 아이템_줍기 {
	static class Solution {
		boolean[][] visited;
		int[] dy = {-1,1,0,0};
		int[] dx = {0,0,-1,1};
		int answer;
		public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
			answer = Integer.MAX_VALUE;
			int board[][] = new int[101][101];
			int corner[][] = new int[101][101];

			visited = new boolean[101][101];
			characterX*=2;
			characterY*=2;
			itemX*=2;
			itemY*=2;
			for(int[] rec : rectangle){
				rec[0] *=2;
				rec[1] *=2;
				rec[2] *= 2;
				rec[3] *=2;
				for(int i = rec[3];i>=rec[1];i--){
					for(int j = rec[2];j>=rec[0];j--){
						board[i][j] +=1;
					}
					corner[i][rec[2]] +=1;
					corner[i][rec[0]] +=1;
				}
				for(int j =rec[2];j>=rec[0];j--){
					corner[rec[3]][j] +=1;
					corner[rec[1]][j] +=1;
				}
				corner[rec[3]][rec[2]] -=1;
				corner[rec[3]][rec[0]] -=1;
				corner[rec[1]][rec[2]] -=1;
				corner[rec[1]][rec[0]] -=1;
			}

//			for(int[] b :board) System.out.println(Arrays.toString(b));
//			System.out.println("------");
//			for(int[] b :corner) System.out.println(Arrays.toString(b));
			dfs(board,corner,characterY,characterX,itemY,itemX,0);
			return answer;
		}
		void dfs(int[][] board, int[][] corner, int y, int x, int itemY, int itemX, int count){
			if(y == itemY && x== itemX){
				answer = Math.min(count/2,answer);
				return;
			}
			for(int i =0;i<4;i++){
				int ny = y + dy[i];
				int nx = x + dx[i];

				if(ny < 0 || ny >= board.length || nx <0 || nx >= board[0].length) continue;
				if(visited[ny][nx]) continue; //이미 방문한 곳
				if(corner[ny][nx] == 0 || board[ny][nx] == 0) continue;
				if(corner[y][x] == 2 && board[ny][nx] !=1) continue; //교점일 경우
				visited[ny][nx] = true;
				dfs(board, corner, ny, nx, itemY, itemX, count+1);
				visited[ny][nx] = false;
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}
		System.out.println(sol.solution(new int[][]
						{{1,1,7,4},
						{3,2,5,5},
						{4,3,6,9},
						{2,6,8,8}},

				1,3,7,8));

	}
}
