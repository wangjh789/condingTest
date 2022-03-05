package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {
	static class Solution {
		public int solution(int bridge_length, int weight, int[] truck_weights) {
			Queue<Integer> que = new LinkedList<>();
			for(int i=0;i<bridge_length;i++) que.offer(0);
			int time = 0;
			int w = 0;
			int count = 0;
			int idx = 0;
			while(idx < truck_weights.length){
				int tmp = que.poll();
				if(tmp!=0) count--;
				w-= tmp;
				if(idx < truck_weights.length && w + truck_weights[idx] <= weight && count < bridge_length){
					count++;
					w += truck_weights[idx];
					que.offer(truck_weights[idx]);
					idx++;
				}else que.offer(0);
				time++;
			}
			time+=bridge_length;
			return time;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(100,100,new int[]{10,10,10,10,10,10,10,10,10,10}));

	}

}
