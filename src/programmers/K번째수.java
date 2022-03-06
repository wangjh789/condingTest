package programmers;

import java.util.Arrays;

public class K번째수 {
	static class Solution {
		public int[] solution(int[] array, int[][] commands) {
			int[] answer = new int[commands.length];
			for(int i=0;i< commands.length;i++){
				int a = commands[i][0];
				int b = commands[i][1];
				int c = commands[i][2];
				int[] tmp = Arrays.copyOfRange(array,a-1,b);
				Arrays.sort(tmp);
				answer[i] = tmp[c-1];
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{2, 5, 3}, {4, 4, 1}, {1, 7, 3}
		System.out.println(Arrays.toString(sol.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));

	}
}
