package programmers;

import java.util.*;

public class 기능개발 {
	static class Solution {
		public int[] solution(int[] progresses, int[] speeds) {
			List<Integer> ans = new ArrayList<>();
			Queue<Integer> que = new ArrayDeque<>();
			for(int i=0;i<speeds.length;i++){
				int value = (100-progresses[i])%speeds[i]!=0?
						(100-progresses[i])/speeds[i]+1:(100-progresses[i])/speeds[i];
				que.offer(value);
			}
			int ex= 0 ;
			while(!que.isEmpty()){
				int count = 1;
				ex = Math.max(ex,que.poll());
				while(!que.isEmpty() && que.peek() <= ex){
					count++;
					ex = Math.max(ex,que.poll());
				}
				ans.add(count);
			}
			return ans.stream().mapToInt(i->i).toArray();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(
				sol.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}))
		);

	}
}
