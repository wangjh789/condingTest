package programmers;

import java.util.*;

public class 전력망을_둘로_나누기 {
	static class Solution {
		public int solution(int n, int[][] wires) {
			int answer = n;
			Map<Integer, List<Integer>> map = new HashMap<>();
			for(int i=0;i<n;i++) map.put(i,new ArrayList<>());
			for(int[] wire : wires){
				map.get(wire[0]-1).add(wire[1]-1);
				map.get(wire[1]-1).add(wire[0]-1);
			}
			for(int[] wire:wires){
				int left = wire[0]-1;
				int right = wire[1]-1;
				int countL = 1;
				int countR = 1;
				boolean[] visited = new boolean[n];
				Queue<Integer> que = new LinkedList<>();
				que.offer(left);
				visited[left] = true;
				while(!que.isEmpty()){
					int cur = que.poll();

					for(int i =0;i<map.get(cur).size();i++){
						if(map.get(cur).get(i) == right) continue;
						if(visited[map.get(cur).get(i)]) continue;
						countL++;
						visited[map.get(cur).get(i)] = true;
						que.offer(map.get(cur).get(i));
					}
				}

				visited = new boolean[n];
				que.offer(right);
				visited[right] = true;
				while(!que.isEmpty()){
					int cur = que.poll();

					for(int i =0;i<map.get(cur).size();i++){
						if(map.get(cur).get(i) == left) continue;
						if(visited[map.get(cur).get(i)]) continue;
						countR++;
						visited[map.get(cur).get(i)] = true;
						que.offer(map.get(cur).get(i));
					}
				}
				answer = Math.min(answer,Math.abs(countL-countR));
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}
//		{1,2},{2,3},{3,4}
		System.out.println(sol.solution(4,new int[][]{
				{1,2},{2,3},{3,4}
		}));

	}
}
