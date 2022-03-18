package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 기둥과_보_설치 {
	static class Solution {
		public int[][] solution(int n, int[][] build_frame) {
			List<int[]> answer = new ArrayList<>();
			boolean[][] gidung = new boolean[n+1][n+1];
			boolean[][] boo = new boolean[n+1][n+1];

			for(int[] t : build_frame){
				int y = t[1];
				int x =t[0];
				int type = t[2];
				int order = t[3];
				if(order==1){ // 설치 명령일 시
					if(type == 0 && checkGidoung(gidung,boo,y,x)) gidung[y][x] = true;
					else if(type==1 && checkBo(gidung,boo,y,x)) boo[y][x] = true;
				}else{ //삭제 명령일 시
					if(type==0){ // 기둥 삭제 일시
						gidung[y][x] = false;
						gidung[y][x] = !canDelete(gidung,boo,n);
					}else{ //보 삭제 명령 일시
						boo[y][x] = false;
						boo[y][x] = !canDelete(gidung,boo,n);
					}
				}
			}
			for(int i =0;i<=n;i++){
				for(int j =0;j<=n;j++){
					if(gidung[i][j]) answer.add(new int[]{j,i,0});
				}
			}
			for(int i =0;i<=n;i++){
				for(int j =0;j<=n;j++){
					if(boo[i][j]) answer.add(new int[]{j,i,1});
				}
			}
			answer.sort((o1, o2) -> {
				if(o1[0] != o2[0]) return o1[0] - o2[0];
				if(o1[1] != o2[1]) return o1[1] - o2[1];
				return o1[2] - o2[2];
			});
			return answer.toArray(new int[0][]);
		}
		boolean canDelete(boolean[][] gidung,boolean[][] boo,int n){ //0: 기둥 1: 보
			for(int i =0;i<=n;i++){
				for(int j=0;j<=n;j++){
					if(gidung[i][j] && !checkGidoung(gidung,boo,i,j)) return false;
					else if(boo[i][j] && !checkBo(gidung,boo,i,j)) return false;
				}
			}
			return true;
		}
		boolean checkGidoung(boolean[][]gidung,boolean[][] boo,int y,int x){
			if(y == 0) return true;
			if(y>0 && gidung[y-1][x]) return true;
			if(boo[y][x])return true;
			if(x>0 && boo[y][x-1]) return true;
			return false;
		}
		boolean checkBo(boolean[][]gidung,boolean[][] boo,int y,int x){
			if(y>0 && gidung[y-1][x]) return true;
			if(y>0 && x+1 < gidung.length && gidung[y-1][x+1])return true;
			if(x+1 < gidung.length && x>0 && boo[y][x-1] && boo[y][x+1]) return true;
			return false;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}
		System.out.println(Arrays.deepToString(sol.solution(5, new int[][]{
				{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}
		})));

	}
}
