package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 야근_지수 {
	static class Solution {
		public long solution(int n, int[] works) {
			long answer = 0;
			PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
			for(int w : works) {
				que.add(w);
			}
			while(!que.isEmpty() &&n > 0){
				int t = que.poll();
				if(t==0) break;
				que.add(t-1);
				n--;
			}
			while(!que.isEmpty()){
				int t = que.poll();
				answer+= (long) t*t;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(1,new int[]{2, 1, 2}));

	}
}
