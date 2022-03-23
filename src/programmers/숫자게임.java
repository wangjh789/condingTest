package programmers;

import java.util.Arrays;

public class 숫자게임 {
	static class Solution {
		public int solution(int[] A, int[] B) {
			int answer = 0;
			Arrays.sort(A);
			Arrays.sort(B);
			int idx=B.length-1;
			for(int i =A.length-1;i>=0;i--){
				if(B[idx] > A[i]){
					idx--;
					answer++;
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{5,1,3,7},new int[]{2,2,6,8}));

	}
}
