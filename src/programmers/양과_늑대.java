package programmers;

import java.util.*;

public class 양과_늑대 {
	static class Solution {
		int maxS ;
		Map<Integer, List<Integer>> map;
		public int solution(int[] info, int[][] edges) {
			maxS = 0;
			map = new HashMap<>();
			for(int[] edge : edges){
				if(!map.containsKey(edge[0])) map.put(edge[0],new ArrayList<>());
				map.get(edge[0]).add(edge[1]);
			}
			List<Integer> arr = new ArrayList<>();
			arr.add(0);
			dfs(0,0,0,arr,info);

			return maxS;
		}
		void dfs(int idx,int sh,int wo,List<Integer> arr,int[] info){
			if(info[idx]==0) sh++;
			else wo++;
			if(sh <= wo) return;

			maxS = Math.max(maxS, sh);

			List<Integer> next = new ArrayList<>(arr);
			if(map.containsKey(idx)) next.addAll(map.get(idx));
			next.remove(Integer.valueOf(idx));
			for(int i =0;i<next.size();i++){
				dfs(next.get(i),sh,wo,next,info);
			}
			return;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}
		System.out.println(sol.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1},
				new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}
				));
	}
}
