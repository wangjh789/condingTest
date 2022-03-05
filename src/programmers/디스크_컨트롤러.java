package programmers;

import java.util.*;

public class 디스크_컨트롤러 {
	static class Solution {
		public int solution(int[][] jobs) {
			int answer = 0;
			Arrays.sort(jobs,(o1, o2) -> o1[0]-o2[0]);
			int idx = 0;
			int count = 0;
			int time = 0;
			PriorityQueue<int[]> que = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
			while(count < jobs.length){
				while(idx < jobs.length && jobs[idx][0] <= time){
					que.add(jobs[idx++]);
				}
				if(que.isEmpty()){
					time = jobs[idx][0];
				}else{
					int[] tmp = que.poll();
					time += tmp[1];
					answer+= time - tmp[0];
					count++;
				}
			}
			return answer/jobs.length;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//		{0, 3}, {1, 9}, {2, 6}
		System.out.println(sol.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));

	}

}
