package programmers;

import java.util.*;

public class 외벽_점검 {
	static class Solution {
		Queue<Integer> arr;
		int ans;
		public int solution(int n, int[] weak, int[] dist) {
			ans = -1;
			int[] ext = new int[weak.length*2-1];
			for(int i=0;i<ext.length;i++){
				ext[i] = i>=weak.length?weak[i%weak.length]+n : weak[i];
			}

			int[] dp = new int[weak.length];
			Queue<Integer> que = new LinkedList<>();
			que.offer(weak[0]);
			for(int i =1;i<weak.length;i++){
				dp[0] +=  weak[i]-weak[i-1];
				que.offer(weak[i]);
			}
			arr = new LinkedList<>(que);
			int minSum = dp[0];
			for(int i =1;i<weak.length;i++){
				que.poll();
				que.offer(ext[i+weak.length-1]);
				dp[i] =  dp[i-1] - (ext[i]-ext[i-1]) + (ext[i+weak.length-1]-ext[i+weak.length-2]);
				if(minSum > dp[i]){
					minSum =dp[i];
					arr = new LinkedList<>(que);
				}
			}
			for(int i =1;i<=dist.length;i++){ //i명 배치했을때
				boolean[] visited = new boolean[dist.length];
				dfs(visited,dist,i,new ArrayList<>());
			}

			return ans;
		}
		void dfs(boolean[] visited, int[] dist,int count,List<Integer> tmp){
			if(ans != -1) return ;
			if(tmp.size() == count){
				if(canCover(tmp) && ans== -1){
					ans = tmp.size();
				}
				return;
			}
			for(int i =0;i< dist.length;i++){
				if(!visited[i]){
					tmp.add(dist[i]);
					visited[i] = true;
					dfs(visited,dist,count,tmp);
					tmp.remove(tmp.size()-1);
					visited[i] = false;
				}
			}
		}
		boolean canCover(List<Integer> tmp){
			Queue<Integer> que = new LinkedList<>(arr);
			int idx = 0;
			while(idx< tmp.size() && !que.isEmpty()){
				int num = que.poll();
				int range = num+tmp.get(idx);
				while(!que.isEmpty() && que.peek() <= range){
					que.poll();
				}
				idx++;
			}
			return que.isEmpty();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(12,new int[]{10,12},new int[]{1,2}));

	}
}
