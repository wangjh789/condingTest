package programmers;

import java.util.*;

public class 퍼즐_조각_채우기 {
	static class Solution {
		int[] dy = new int[]{-1,1,0,0};
		int[] dx = new int[]{0,0,-1,1};
		public int solution(int[][] game_board, int[][] table) {
			int answer = 0;
			Map<int[][],Integer> blocks = getBlocks(table,1);
			Map<int[][],Integer> empties = getBlocks(game_board,0);
			List<Map.Entry<int[][],Integer>> blockList = new ArrayList<>(blocks.entrySet());
			blockList.sort((o1, o2) -> o2.getValue()-o1.getValue());
			List<Map.Entry<int[][],Integer>> emptyList = new ArrayList<>(empties.entrySet());
			emptyList.sort((o1, o2) -> o2.getValue()-o1.getValue());
			boolean[] used = new boolean[blocks.size()];
			for(Map.Entry<int[][],Integer> tmp : emptyList){
				int[][] empty = tmp.getKey();
				for(int i=0;i<blockList.size();i++){
					int[][] block = blockList.get(i).getKey();
					if(used[i]) continue;
					boolean match = false;
					for(int j=0;j<4;j++){
						block = rotate(block);
						if(match(empty,block)){
							match = true;
							answer+= blockList.get(i).getValue();
							break;
						}
					}
					if(match) {
						used[i] = true;
						break;
					}
				}
			}
			return answer;
		}
		boolean match(int[][] empty, int[][] block){
			if(empty.length != block.length || empty[0].length != block[0].length) return false;
			for(int i =0;i<empty.length;i++){
				for(int j=0;j<empty[0].length;j++){
					int val = empty[i][j] + block[i][j];
					if(val != 1) return false;
				}
			}
			return true;
		}
		Map<int[][],Integer> getBlocks(int[][] table,int target){
			boolean[][] visited = new boolean[table.length][table[0].length];
			Map<int[][],Integer> blocks = new HashMap<>();
			for(int i =0;i<table.length;i++){
				for(int j=0;j<table[0].length;j++){
					if(table[i][j]==target && !visited[i][j]){
						visited[i][j] = true;
						Queue<int[]> que = new LinkedList<>();
						List<int[]> tmp = new ArrayList<>();
						int[] init = new int[]{i,j};
						que.offer(init);
						tmp.add(init);
						int maxY =i;
						int maxX = j;
						int minY = i;
						int minX = j;
						while(!que.isEmpty()){
							int[] cur = que.poll();
							for(int dir = 0;dir<4;dir++){
								int ny = cur[0] + dy[dir];
								int nx = cur[1] + dx[dir];
								if(ny<0 || ny>= table.length || nx<0 || nx >= table[0].length) continue;
								if(table[ny][nx] != target || visited[ny][nx]) continue;
								visited[ny][nx] = true;
								maxY = Math.max(maxY,ny);
								minY = Math.min(minY,ny);
								maxX = Math.max(maxX,nx);
								minX = Math.min(minX,nx);
								int[] item = new int[]{ny,nx};
								que.offer(item);
								tmp.add(item);
							}
						}
						for(int[] t :tmp){
							t[0] -= minY;
							t[1] -= minX;
						}
//						int range = Math.max(maxY - minY +1,maxX - minX +1);
						int[][] piece = new int[maxY - minY +1][maxX - minX +1];
						if(target == 0){
							for(int[] line :piece){
								Arrays.fill(line,1);
							}
						}
						for(int[] t : tmp)
							piece[t[0]][t[1]] = target;
						blocks.put(piece,tmp.size());
					}
				}
			}
			return blocks;
		}
		int[][] rotate(int[][] origin){
			int[][] tmp = new int[origin[0].length][origin.length];
			for(int i =0;i<origin.length;i++){
				for(int j=0;j<origin[0].length;j++){
					tmp[j][origin.length-1-i] = origin[i][j];
				}
			}
			return tmp;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
//		{1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0},
//		{0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0},
//		{1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1},
//		{0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
//		{0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1},
//		{0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
//		{0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0},
//		{1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0},
//		{0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0},
//		{0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1},
//		{0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}

//      {1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},
//      {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1},
//      {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0},
//      {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1}, {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1}, {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}

//       {1,1,0,0,1,0},{0,0,1,0,1,0},{0,1,1,0,0,1},{1,1,0,1,1,1},{1,0,0,0,1,0},{0,1,1,1,0,0}
//		{1,0,0,1,1,0},{1,0,1,0,1,0},{0,1,1,0,1,1},{0,0,1,0,0,0},{1,1,0,1,1,0},{0,1,0,0,0,0}
		System.out.println(sol.solution(
				new int[][]{{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0}, {1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0}, {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}},
				new int[][]{{1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1}, {1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0}, {0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0}, {1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1}, {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1}, {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}}
		));

	}
}
