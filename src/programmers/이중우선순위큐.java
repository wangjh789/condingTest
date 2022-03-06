package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 이중우선순위큐 {
	static class Solution {
		public int[] solution(String[] operations) {
			int[] answer = new int[2];
			PriorityQueue<Integer> que = new PriorityQueue<>(); //오름차순
			for(String oper : operations){
				String[] order = oper.split(" ");
				if(order[0].equals("I")){
					que.add(Integer.valueOf(order[1]));
				}
				else{
					if(que.isEmpty()) continue;
					if(order[1].equals("-1")){
						que.poll();
					}else{
						PriorityQueue<Integer> up = new PriorityQueue<>(Collections.reverseOrder());
						up.addAll(que);
						que.clear();
						up.poll();
						que.addAll(up);
					}
				}
			}
			if(que.isEmpty())return new int[]{0,0};
			PriorityQueue<Integer> up = new PriorityQueue<>(Collections.reverseOrder());
			up.addAll(que);
			answer[0] = up.poll();
			answer[1] = que.poll();


			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"})));

	}
}
