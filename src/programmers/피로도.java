package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 피로도 {
	static class Solution {
		int answer;
		boolean[] visited;
		public int solution(int k, int[][] dungeons) {
			answer = 0;
			visited = new boolean[dungeons.length];
			dfs(k,dungeons,new ArrayList<>());

			return answer;
		}
		void dfs(int k, int[][] dungeons, List<int[]> arr){
			if(arr.size() == dungeons.length){
				int count = 0;
				for(int[] dun : arr){
					if(k >= dun[0]){
						k-= dun[1];
						count++;
					}
				}
				answer = Math.max(count,answer);
				return;
			}
			for(int i=0;i< dungeons.length;i++){
				if(!visited[i]){
					visited[i]= true;
					arr.add(dungeons[i]);
					dfs(k,dungeons,arr);
					visited[i] = false;
					arr.remove(arr.size()-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{80,20},{50,40},{30,10}
		System.out.println(sol.solution(80,new int[][]{{80,20},{50,40},{30,10}}));

	}
}
