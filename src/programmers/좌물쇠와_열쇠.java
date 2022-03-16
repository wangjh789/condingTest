package programmers;

import java.util.Arrays;

public class 좌물쇠와_열쇠 {
	static class Solution {
		public boolean solution(int[][] key, int[][] lock) {
			boolean answer = false;
			int M = key.length;
			int N = lock.length;
			int[][] board = new int[N+(M-1)*2][N+(M-1)*2];
			for(int i=M-1;i<N+M-1;i++){
				for(int j=M-1;j<N+M-1;j++){
					board[i][j] = lock[i-M+1][j-M+1];
				}
			}
			for(int i=0;i<N+(M-1)*2;i++) {
				for (int j=0;j<N+(M-1)*2; j++) {
					for (int k=0;k<4;k++){
						key = rotateKey(key);
						if(valid(board,key,i,j,M,N)){
							return true;
						}
					}
				}
			}
			return answer;
		}
		boolean valid(int[][] board,int[][] key,int y,int x,int M,int N){
			for(int i=M-1;i<N+M-1;i++){
				for(int j=M-1;j<N+M-1;j++){
					int val = board[i][j];
					if(!(i-y<0 || i-y>=M || j-x<0  || j-x>=M)){
						val += key[i-y][j-x];
					}
					if(val != 1) {
						return false;
					}
				}
			}
			return true;
		}

		int[][] rotateKey(int[][] key){
			int[][] rotate = new int[key.length][key[0].length];
			for(int i=0;i<key.length;i++){
				for(int j=0;j<key[0].length;j++){
					rotate[j][key.length-1-i] = key[i][j];
				}
			}
			return rotate;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0, 0, 0}, {1, 0, 0}, {0, 1, 1}
//		{1, 1, 1}, {1, 1, 0}, {1, 0, 1}
		System.out.println(sol.solution(
				new int[][]{
						{0, 0, 0},
						{1, 0, 0},
						{0, 1, 1}},
				new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}));

	}
}
