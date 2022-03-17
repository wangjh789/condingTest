package programmers;

import java.util.Arrays;

public class 합승_택시_요금 {
	static class Solution {
		public int solution(int n, int s, int a, int b, int[][] fares) {
			int answer = 100000*n;
			int[][] dist = new int[n][n];
			int[] cost = new int[n]; // s ~ i 까지 동승했을때의 최소 금액
			Arrays.fill(cost,100000*n);
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i != j){
						dist[i][j] = 100000*n;
					}
				}
			}
			for(int [] fare:fares){ //인접 노드 가중치 설정
				dist[fare[0]-1][fare[1]-1] = fare[2];
				dist[fare[1]-1][fare[0]-1] = fare[2];
			}
			for(int k=0;k<n;k++){ //플로이드 와샬 알고리즘 -> 노드의 전체 최소 거리
				for(int i=0;i<n;i++){
					for(int j=0;j<n;j++){
						if(i == j) continue;
						dist[i][j] = Math.min(dist[i][k] + dist[k][j],dist[i][j]);
					}
				}
			}
//			for(int[] d : dist){
//				System.out.println(Arrays.toString(d));
//			}
			for(int i=0;i<n;i++){
				cost[i] =Math.min(cost[i], dist[s-1][i] + dist[i][a-1]+dist[i][b-1]);
			}
			for(int i : cost) answer = Math.min(i,answer);
//			System.out.println(Arrays.toString(cost));
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{4, 1, 10},
//		{3, 5, 24},
//		{5, 6, 2},
//		{3, 1, 41},
//		{5, 1, 24},
//		{4, 6, 50},
//		{2, 4, 66},
//		{2, 3, 22},
//		{1, 6, 25}
		System.out.println(sol.solution(6,4,6,2,new int[][]{
				{4, 1, 10},
				{3, 5, 24},
				{5, 6, 2},
				{3, 1, 41},
				{5, 1, 24},
				{4, 6, 50},
				{2, 4, 66},
				{2, 3, 22},
				{1, 6, 25}}));

	}
}
