package programmers;

import java.util.*;

public class 카드_짝_맞추기 {
	static class Solution {
		class Pair{
			int y;
			int x;
			int move;
			Pair(int y,int x,int move){
				this.y = y;
				this.x =x;
				this.move = move;
			}
		}

		int[] dy = new int[]{-1,1,0,0};
		int[] dx = new int[]{0,0,-1,1};
		List<Integer> pairs = new ArrayList<>();
		List<List<Integer>> orders = new ArrayList<>();
		boolean[] used;
		public int solution(int[][] board, int r, int c) {
			int answer = Integer.MAX_VALUE;
			for(int i = 0;i<4;i++){
				for(int j=0;j<4;j++){
					if(board[i][j] != 0 && !pairs.contains(board[i][j])){
						pairs.add(board[i][j]);
					}
				}
			}
			used = new boolean[pairs.size()];
			dfs(new ArrayList<>());


			for(int i =0;i< orders.size();i++){
				int[] cur = new int[]{r,c};
				int[][] copyBoard = new int[4][4];
				int move = 0;

				for(int a =0;a<4;a++){
					for(int b=0;b<4;b++){
						copyBoard[a][b] = board[a][b];
					}
				}
				Queue<Integer> que = new LinkedList<>(orders.get(i));
				while(!que.isEmpty()){
					int target = que.poll();
					//첫번째 카드 찾기
					move+= searchTarget(copyBoard,target,cur);
					//엔터
					move+=1;
					copyBoard[cur[0]][cur[1]] = 0;
					//두번째 카드 찾기
					move+= searchTarget(copyBoard,target,cur);
					move+=1;
					copyBoard[cur[0]][cur[1]] = 0;
				}
				answer = Math.min(answer,move);
			}
			return answer;
		}
		int searchTarget(int[][] board,int target,int[] pos){ //가장 가까운 target 찾기
			Queue<Pair> que = new LinkedList<>();
			int y = pos[0];
			int x = pos[1];
			que.offer(new Pair(y,x,0));
			boolean[][] visited = new boolean[4][4];
			while(!que.isEmpty()){
				Pair next = que.poll();
				if(board[next.y][next.x] == target){
					pos[0] = next.y;
					pos[1] = next.x;
					return next.move;
				}

				for(int i =0;i<4;i++){ //하나씩 상하좌우 탐색
					int ny = next.y + dy[i];
					int nx = next.x + dx[i];

					if(ny <0 || ny >= 4 || nx <0 || nx>=4) continue;
					if(visited[ny][nx]) continue;
					visited[ny][nx] = true;
					que.offer(new Pair(ny,nx,next.move+1));
				}
				for(int i =0;i<4;i++){ //shit 로 이동
					Pair step = checkRoute(board,next.y,next.x,i);
					int ny = step.y;
					int nx = step.x;
					if(ny == y && nx==x) continue;
					if(visited[ny][nx]) continue;
					visited[ny][nx] = true;
					que.offer(new Pair(ny,nx,next.move+1));
				}
			}
			return 0;
		}
		Pair checkRoute(int[][] board, int y,int x,int dir){
			y+= dy[dir];
			x+= dx[dir];
			while(y>=0 && y<=3 && x>=0 && x<=3){
				if(board[y][x] != 0) return new Pair(y,x,0); //카드가 있으면
				y+= dy[dir];
				x+= dx[dir];
			}
			return new Pair(y-dy[dir], x-dx[dir],0);
		}

		void dfs(List<Integer> arr){
			if(arr.size() == pairs.size()){
				orders.add(new ArrayList<>(arr));
			}
			for(int i =0;i< pairs.size();i++){
				if(!used[i]){
					used[i] = true;
					arr.add(pairs.get(i));
					dfs(arr);
					arr.remove(arr.size()-1);
					used[i] = false;
				}
			}
		}



	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}
		System.out.println(sol.solution(
				new int[][]{
						{1,0,0,3},
						{2,0,0,0},
						{0,0,0,2},
						{3,0,1,0}
				},1,0
		));

	}
}
