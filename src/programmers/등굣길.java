package programmers;

import java.util.Arrays;

public class 등굣길 {
	static class Solution {
		public int solution(int m, int n, int[][] puddles) {
			int answer = 0;
			int[][] map = new int[n][m];
			for(int[] puddle : puddles){
				map[puddle[1]-1][puddle[0]-1] = -1;
			}
			for(int i=0;i<map.length;i++){
				if(map[i][0] == -1){
					break;
				}else{
					map[i][0] = 1;
				}
			}
			for(int i=0;i<map[0].length;i++){
				if(map[0][i] == -1){
					break;
				}else{
					map[0][i] = 1;
				}
			}
			for(int i=1;i<map.length;i++){
				for(int j=1;j<map[0].length;j++){
					if(map[i][j] == -1) continue;
					if(map[i-1][j] == -1 && map[i][j-1] == -1) continue;
					else if(map[i-1][j] == -1) map[i][j] = map[i][j-1];
					else if(map[i][j-1] == -1) map[i][j] = map[i-1][j];
					else{
						map[i][j] = map[i][j-1]+map[i-1][j];
					}
				}
			}

//			for(int[] line : map){
//				System.out.println(Arrays.toString(line));
//			}
			return map[n-1][m-1]%1000000007;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(4,3,new int[][]{{2,2}}));

	}
}
