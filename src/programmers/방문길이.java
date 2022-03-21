package programmers;

public class 방문길이 {
	static class Solution {
		boolean[][][] visited;
		public int solution(String dirs) {
			int answer = 0;
			int n = 11;
			int y = 5;
			int x = 5;
			visited = new boolean[n][n][4];
			for(char dir : dirs.toCharArray()){
				int ny = y;
				int nx = x;
				int num ;
				if(dir=='U'){
					ny++;
					num = 0;
				}
				else if(dir=='D') {
					ny--;
					num = 1;
				}
				else if(dir=='L') {
					nx--;
					num = 2;
				}
				else {
					nx++;
					num = 3;
				}

				if(ny<0 || ny>=n|| nx<0 || nx>=n) continue;
				if(num == 0){
					if(!visited[ny][nx][0] && !visited[y][x][1]) answer++;
					visited[ny][nx][0] = true;
					visited[y][x][1] = true;
				}else if(num == 1){
					if(!visited[ny][nx][1] && !visited[y][x][0]) answer++;
					visited[ny][nx][1] = true;
					visited[y][x][0] = true;
				}else if(num==2){
					if(!visited[ny][nx][2] && !visited[y][x][3]) answer++;
					visited[ny][nx][2] = true;
					visited[y][x][3] = true;
				}else{
					if(!visited[ny][nx][3] && !visited[y][x][2]) answer++;
					visited[ny][nx][3] = true;
					visited[y][x][2] = true;
				}

				y = ny;
				x = nx;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("LULLLLLLU"));

	}
}
