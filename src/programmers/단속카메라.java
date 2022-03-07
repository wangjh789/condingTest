package programmers;

import java.util.Arrays;

public class 단속카메라 {
	static class Solution {
		public int solution(int[][] routes) {
			int answer = 0;
			Arrays.sort(routes,(o1, o2) -> o1[1]-o2[1]); //나가는 시점으로 오름차순 정렬
			int idx = 0;
			while(idx< routes.length){
				answer++;
				int pos = routes[idx][1]; //끝나는 시각
				int tmp = idx+1;
				while(tmp<routes.length && (pos >= routes[tmp][0] && pos <= routes[tmp][1]) ){
					tmp++;
				}
				idx = tmp;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}
		System.out.println(sol.solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}));

	}
}
