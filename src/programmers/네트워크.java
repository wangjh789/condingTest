package programmers;

import java.util.Arrays;

public class 네트워크 {
	static class Solution {
		public int solution(int n, int[][] computers) {
			int answer = 1;
			int[] parent = new int[n];
			for(int i=0;i<n;i++) parent[i] = i;
			for(int i=0;i<computers.length;i++){ //i번째 노드
				for(int j=0;j<computers[i].length;j++){ //i번 노드와 j번 노드와의 관계
					if(computers[i][j] == 1){
						union(parent,i,j);
					}
				}
			}
			Arrays.sort(parent);
			int tmp = parent[0];
			for(int i=1;i<parent.length;i++){
				if(tmp != parent[i]) {
					answer++;
					tmp = parent[i];
				}
			}
			return answer;
		}

		void union(int[] parent, int a, int b){
			int aP = getParent(parent,a);
			int bP = getParent(parent,b);
			if(aP == bP) return; //이미 같은 그래프에 있음
			//작은 쪽이 부모가 되는 걸로
			if(a > b){
				for(int i=0;i<parent.length;i++){
					if(parent[i] == aP) parent[i] = bP;
				}
			}else{
				for(int i=0;i<parent.length;i++){
					if(parent[i] == bP) parent[i] = aP;
				}
			}
		}
		int getParent(int[] parent,int a){
			if(parent[a] == a) return a;
			return getParent(parent,parent[a]);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1, 1, 0}, {1, 1, 0}, {0, 0, 1}
		System.out.println(sol.solution(3,new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));

	}
}
