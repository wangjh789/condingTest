package programmers;

import java.util.*;

public class 가장_먼_노드 {
	static class Solution {
		public int solution(int n, int[][] edge) {
			int answer = 0;
			int max = 0;
			int[] dist = new int[n];
			Arrays.fill(dist,-1);
			Map<Integer, List<Integer>> graph = new HashMap<>();
			for(int[] ed : edge){
				if(!graph.containsKey(ed[0]-1)) graph.put(ed[0]-1,new ArrayList<>());
				if(!graph.containsKey(ed[1]-1)) graph.put(ed[1]-1,new ArrayList<>());
				graph.get(ed[0]-1).add(ed[1]-1);
				graph.get(ed[1]-1).add(ed[0]-1);
			}
			dist[0] = 0; //0번 노드는 거리 0으로 초기화
			Queue<Integer> que = new LinkedList<>();
			que.offer(0); //0번 노드를 넣음
			while(!que.isEmpty()){
				int target = que.poll();
				for(int i=0;i<graph.get(target).size();i++){
					int neighbor = graph.get(target).get(i); // 이웃한 노드
					if(dist[neighbor] == -1){ //방문하지 않은 상태
						dist[neighbor] = dist[target]+1;
						max = Math.max(max,dist[neighbor]);
						que.offer(neighbor);
					}
				}
			}
			for(int i=1;i<dist.length;i++){
				if(dist[i] == max) answer++;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}
		System.out.println(sol.solution(6,
				new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));

	}
}
