package programmers;

import java.util.Arrays;

public class 쿼드압축_후_개수_세기 {
	static class Solution {
		public int[] solution(int[][] arr) {
			int[] answer = new int[2];

			return check(arr,0,0,arr.length);
		}
		int[] check(int[][] arr,int y,int x,int count){
			int[] result = new int[2];
			int target = arr[y][x];
			boolean possible = true;
			for(int i =y;i<y+count;i++){
				for(int j=x;j<x+count;j++){
					if(arr[i][j] != target){
						possible = false;
						break;
					}
				}
			}
			if(possible){
				if(target == 1) result[1] = 1;
				else result[0] =1;
			}else{
				int next = count/2;
				for(int i =y;i<y+count;i+=next) {
					for (int j = x; j < x + count; j+=next) {
						int[] t = check(arr,i,j,next);
						result[0] += t[0];
						result[1] += t[1];
					}
				}
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}
		System.out.println(Arrays.toString(sol.solution(new int[][]{{
				1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));

	}
}
