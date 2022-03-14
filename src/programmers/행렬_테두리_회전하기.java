package programmers;

import java.util.Arrays;

public class 행렬_테두리_회전하기 {
	static class Solution {
		public int[] solution(int rows, int columns, int[][] queries) {
			int[] answer = new int[queries.length];
			int[][] graph = new int[rows][columns];
			int count = 1;
			for(int i=0;i<rows;i++){
				for(int j=0;j<columns;j++){
					graph[i][j] = count++;
				}
			}
			for(int i=0;i< queries.length;i++){
				int[] query = queries[i];
				answer[i] = rotate(graph,query[0]-1,query[1]-1,query[2]-1,query[3]-1);
			}
			return answer;
		}
		int rotate(int[][] graph, int y1,int x1,int y2,int x2){
			int ex = graph[y1][x1];
			int min = ex;
			for(int x=x1+1;x<=x2;x++){ // 위쪽
				int tmp = graph[y1][x];
				graph[y1][x] = ex;
				ex = tmp;
				min = Math.min(ex,min);
			}
			for(int y=y1+1;y<=y2;y++){ //오른쪽
				int tmp = graph[y][x2];
				graph[y][x2] = ex;
				ex = tmp;
				min = Math.min(ex,min);
			}
			for(int x=x2-1;x>=x1;x--){ //아래
				int tmp = graph[y2][x];
				graph[y2][x] = ex;
				ex = tmp;
				min = Math.min(ex,min);
			}
			for(int y=y2-1;y>=y1;y--){ //왼쪽
				int tmp = graph[y][x1];
				graph[y][x1] = ex;
				ex = tmp;
				min = Math.min(ex,min);
			}
			return min;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{2,2,5,4},{3,3,6,6},{5,1,6,3}
		System.out.println(Arrays.toString(sol.solution(6, 6,
				new int[][]{{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}})));

	}
}
