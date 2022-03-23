package programmers;

import java.util.Arrays;

public class 멀리_뛰기 {
	static class Solution {
		public long solution(int n) {
			if(n==1 ) return 1;
			long[] memo = new long[n+1];
			memo[1] = 1;
			memo[2] = 2;
			for(int i =3;i< memo.length;i++){
				memo[i] = (memo[i-1] + memo[i-2])%1234567;
			}
			return memo[n]%1234567;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(1));

	}
}
