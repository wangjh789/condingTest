package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 카카오_프렌즈_컬러링북 {
	static class Solution {
		int[] dy = new int[]{-1,1,0,0};
		int[] dx = new int[]{0,0,-1,1};
		public int[] solution(int m, int n, int[][] picture) {
			int numberOfArea = 0;
			int maxSizeOfOneArea = 0;
			boolean[][] visited = new boolean[m][n];
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(!visited[i][j] && picture[i][j] !=0){ //방문하지 않았다면
						Queue<int[]> que = new LinkedList<>();
						que.offer(new int[]{i,j});
						int val = picture[i][j];
						visited[i][j] = true;
						int size = 1;
						while(!que.isEmpty()){
							int[] cur = que.poll();
							for(int k=0;k<4;k++){
								int ny = cur[0] + dy[k];
								int nx = cur[1] + dx[k];

								if(ny < 0 || ny >= m || nx <0 || nx >= n) continue;
								if(visited[ny][nx] || picture[ny][nx]==0) continue;
								if(picture[ny][nx] != val) continue;
								size++;
								visited[ny][nx] = true;
								que.offer(new int[]{ny,nx});
							}
						}
						numberOfArea++;
						maxSizeOfOneArea = Math.max(maxSizeOfOneArea,size);
						System.out.println(i+" "+j+" "+size);
					}
				}
			}

			int[] answer = new int[2];
			answer[0] = numberOfArea;
			answer[1] = maxSizeOfOneArea;
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
		System.out.println(Arrays.toString(sol.solution(6, 4, new int[][]{
				{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
		})));

	}
}
