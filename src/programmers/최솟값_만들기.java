package programmers;

import java.util.Arrays;

public class 최솟값_만들기 {
	static class Solution {
		public int solution(int []A, int []B) {
			int answer = 0;
			Arrays.sort(A);
			Arrays.sort(B);
			for(int i =0;i<A.length;i++){
				int bIdx = A.length-i-1;
				answer += A[i]*B[bIdx];
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{1, 4, 2},new int[]{5, 4, 4}));

	}
}
