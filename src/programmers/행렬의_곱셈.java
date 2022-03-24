package programmers;

import java.util.Arrays;

public class 행렬의_곱셈 {
	static class Solution {
		public int[][] solution(int[][] arr1, int[][] arr2) {
			int y = arr1.length;
			int x = arr2[0].length;
			int[][] answer = new int[y][x];
			for(int i =0;i<y;i++){
				for(int j =0 ;j<x;j++){
					for(int k=0;k<arr1[0].length;k++){
						answer[i][j] += arr1[i][k] * arr2[k][j];
					}
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.deepToString(sol.solution(new int[][]{
				{1, 4},
				{3, 2},
				{4, 1}
		}, new int[][]{
				{3, 3},
				{3, 3}
		})));

	}
}
