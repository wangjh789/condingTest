package programmers;

public class 사라지는_발판 {
	static class Solution {
		int answer;
		boolean[][] visited;
		int[] dy = new int[]{-1,1,0,0};
		int[] dx = new int[]{0,0,-1,1};
		public int solution(int[][] board, int[] aloc, int[] bloc) {
			answer = 0;
			visited = new boolean[board.length][board[0].length];
			dfs(board,aloc[0],aloc[1],bloc[0],bloc[1],0);
			return answer;
		}
		void dfs(int[][] board,int ay,int ax,int by,int bx,int count){
			if(visited[ay][ax] || visited[by][bx]){  //서있는 발판이 사라지면
				System.out.println((count-1)+" 발판이 사라짐");
				return;
			}

			boolean move = false;
			for(int i =0;i<4;i++){
				int ny = 0;
				int nx = 0;
				if(count%2 == 0){ //a 차례
					ny = ay + dy[i];
					nx = ax + dx[i];
				}else{ //b 차례
					ny = by + dy[i];
					nx = bx + dx[i];
				}
				if(ny<0 || ny>=board.length || nx <0 || nx >= board[0].length) continue;
				if(board[ny][nx] == 0) continue;
				if(visited[ny][nx]) continue;

				if(count%2 == 0) visited[ay][ax] = true;
				else visited[by][bx] = true;

				move = true;
				if(count %2==0) dfs(board,ny,nx,by,bx,count+1); //a
				else dfs(board,ay,ax,ny,nx,count+1); //b

				if(count%2 == 0) visited[ay][ax] = false;
				else visited[by][bx] = false;

			}
			if(!move) { //움직이지 못했을 경우
				System.out.println(count + " 움직이지 못함");
				return;
			}


		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1, 1, 1}, {1, 1, 1}, {1, 1, 1}
		System.out.println(sol.solution(
				new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}},
				new int[]{1,0},new int[]{1,2}
		));

	}
}
