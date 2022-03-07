package programmers;

import java.util.Arrays;

public class 섬_연결하기 {
	static class Solution {
		int[] parent;
		public int solution(int n, int[][] costs) {
			int answer = 0;
			Arrays.sort(costs,(o1, o2) -> o1[2] - o2[2]);
			parent = new int[n];
			for(int i=0;i<n;i++)parent[i] = i; //자기 자신을 parent
			for(int[] cost: costs){
//				System.out.println(Arrays.toString(parent)+" "+answer);
				int a = cost[0];
				int b = cost[1];
				if(!isCycle(a,b)){ //부모가 같지 않으면
					union(a,b);
					answer+= cost[2];
				}
			}
			return answer;
		}
		int getParent(int a){
			if(parent[a] == a){
				return a;
			}
			return getParent(parent[a]);
		}
		void union(int a,int b){ //작은 쪽으로 부모 변경
			if(a > b){
				int t = parent[a];
				for(int i=0;i<parent.length;i++) if(parent[i]==t) parent[i] = getParent(b);
//				parent[a] = getParent(b);
			}else{
				int t = parent[b];
				for(int i=0;i<parent.length;i++) if(parent[i]==t) parent[i] = getParent(a);
//				parent[b] = getParent(a);
			}
		}
		boolean isCycle(int a,int b){
			int aP = getParent(a);
			int bP = getParent(b);
			return aP==bP;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}
		int[][] t = new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		System.out.println(sol.solution(4,t));

	}
}
