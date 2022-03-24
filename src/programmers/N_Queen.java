package programmers;

import java.lang.reflect.Array;
import java.util.Arrays;

public class N_Queen {
	static class Solution {
		int answer ;
		public int solution(int n) {
			answer = 0;
			int[] memo = new int[n]; //i,j : i번째 줄에 j번째 칸에 퀸이 있다.
			dfs(memo,n,0);
			return answer;
		}

		void dfs(int[] memo,int n,int idx){
			if(idx == n){
				answer++;
//				System.out.println(Arrays.toString(memo));
				return;
			}
			for(int i =0;i<n;i++){
				if(isPossible(memo, idx, i)){
					memo[idx] = i;
					dfs(memo,n,idx+1);
				}
			}
		}
		boolean isPossible(int[] memo, int y,int x){ //y ,x에 놓아도 될까
			for(int i =0;i<y;i++){
				int j = memo[i]; //i,j 에 퀸
				if(x ==j) return false; // 같은 컬럼
				if(Math.abs(x-j) == Math.abs(y-i)) return false; //대각
			}
			return true;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(4));

	}
}
