package programmers;

import java.util.Arrays;

public class 기지국_설치 {
	static class Solution {
		public int solution(int n, int[] stations, int w) {
			int answer = 0;
			int sIdx = 0;
			int[] range = new int[]{Math.max(stations[sIdx]-1-w,0), Math.min(stations[sIdx]-1+w,n-1)};
			int idx = 0;
			while(idx < n){
				System.out.println(idx+" "+answer);
				if(idx > range[1] && sIdx+1 < stations.length){ // station 최신화
					sIdx++;
					range[0] = Math.max(stations[sIdx]-1-w,0);
					range[1] = Math.min(stations[sIdx]-1+w,n-1);
				}
				if(idx>= range[0] && idx <= range[1]){
					idx = range[1] +1;
				}else{
					answer++;
					idx += (w*2+1);
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(11,new int[]{4,11},0));

	}
}
