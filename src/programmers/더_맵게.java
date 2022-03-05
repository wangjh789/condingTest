package programmers;

import java.util.PriorityQueue;

public class 더_맵게 {
	static class Solution {
		public int solution(int[] scoville, int K) {
			PriorityQueue<Integer> que = new PriorityQueue<>();
			for(int t : scoville) que.offer(t);
			int count = 0;
			while(que.peek() < K){
				if(que.isEmpty()) return -1;
				int targetA = que.poll();
				if(que.isEmpty()) return -1;
				int targetB = que.poll();
				int value = (targetA + (targetB*2));
				que.offer(value);
				count++;
			}
			return count;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{1, 2, 3, 9, 10, 12},7));
	}
}
