package programmers;

import java.util.*;

public class 배달 {
	static class Solution {
		public int solution(int N, int[][] road, int K) {
			int answer = 0;
			int[][] dist = new int[N][N];
			for(int i =0;i<N;i++){
				for(int j=0;j<N;j++){
					if(i==j) {
						dist[i][j] = 0;continue;
					}
					dist[i][j] = 500001;
				}
			}
			for(int[] r : road){ //인접 노드 간선 가중치
				dist[r[0]-1][r[1]-1] = Math.min(dist[r[0]-1][r[1]-1],r[2]);
				dist[r[1]-1][r[0]-1] = Math.min(dist[r[0]-1][r[1]-1],r[2]);
			}

			for(int k=0;k<N;k++){
				for(int i=0;i<N;i++){
					for(int j=0;j<N;j++){
						if(i==j) continue;
						dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
					}
				}
			}
			for(int i=0;i<dist[0].length;i++){
				if (dist[0][i] <= K) answer++;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}
		System.out.println(sol.solution(5,new int[][]{
				{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}},
				3));

	}
}
