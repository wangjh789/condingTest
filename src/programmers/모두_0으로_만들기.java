package programmers;

import java.util.*;

public class 모두_0으로_만들기 {
	static class Solution {
		long[] long_a;
		boolean[] visited;
		List<Integer>[] adjust ;
		long answer;
		public long solution(int[] a, int[][] edges) {
			answer = 0;
			long sum = 0;
			visited = new boolean[a.length];
			adjust = new List[a.length];
			long_a = new long[a.length];
			for(int i =0;i<a.length;i++){
				sum+= a[i];
				long_a[i] = a[i];
				adjust[i] = new ArrayList<>();
			}
			if(sum != 0) return -1;
			for(int[] edge : edges){
				adjust[edge[0]].add(edge[1]);
				adjust[edge[1]].add(edge[0]);
			}
			dfs(0);


			return answer;
		}
		long dfs(int v){
			visited[v] = true;

			for(int i=0;i<adjust[v].size();i++){
				int next = adjust[v].get(i);
				if(!visited[next]){
					long_a[v] += dfs(next);
				}
			}
			answer += Math.abs(long_a[v]);
			return long_a[v];
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0,1},{3,4},{2,3},{0,3}
//		[-2, 8, -5, -5, -3, 0, 5, 2], [{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}
		System.out.println(sol.solution(
				new int[]{-2, 8, -5, -5, -3, 0, 5, 2},
				new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 6}, {2, 7}}));

	}
}
