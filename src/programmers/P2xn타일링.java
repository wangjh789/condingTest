package programmers;

public class P2xn타일링 {
	static class Solution {
		int[] memo;
		public int solution(int n) {
			if(n <= 2) return n;
			memo = new int[n+1];
			memo[0] = 0;
			memo[1] = 1;
			memo[2] = 2;
			int a = 3;
			while(a <= n){
				memo[a] = (memo[a-1] + memo[a-2])%1000000007;
				a++;
			}
			return memo[n];
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(4));

	}
}
