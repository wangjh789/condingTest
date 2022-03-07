package programmers;

public class N으로_표현 {
	static class Solution {
		int ans ;
		public int solution(int N, int number) {
			ans = Integer.MAX_VALUE;
			dfs(0,number,N,0);
			if(ans == Integer.MAX_VALUE) return -1;
			return ans;
		}

		void dfs(int depth,int number,int N,int current){
			if(depth > 8)return;
			if(current == number){
				ans  = Math.min(ans,depth);
				return;
			}
			int tmp = 0;
			for(int i=0;i<8;i++){
				if(i + depth < 8){
					tmp = tmp*10 + N;
					dfs(depth+i+1,number,N,current+tmp);
					dfs(depth+i+1,number,N,current-tmp);
					dfs(depth+i+1,number,N,current/tmp);
					dfs(depth+i+1,number,N,current*tmp);
				}
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5,12));

	}
}
