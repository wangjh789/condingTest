package programmers;

import java.util.*;

public class 프린터 {
	static class Solution {
		public int solution(int[] priorities, int location) {
			int answer = 0;
			Map<Integer,Integer> map = new HashMap<>();
			Queue<int[]> que= new LinkedList<>(); //int[] 0:value, 1:idx
			for(int i =0;i< priorities.length;i++){
				map.put(priorities[i], map.getOrDefault(priorities[i],0)+1);
				int[] tmp = new int[]{priorities[i],i};
				que.offer(tmp);
			}
			List<Map.Entry<Integer,Integer>> entries = new ArrayList<>(map.entrySet());
			Collections.sort(entries,(o1, o2) -> o2.getKey() - o1.getKey());

			int count = 1;
			int idx = 0;
			while(idx < entries.size()){
				while(!que.isEmpty() && que.peek()[0] != entries.get(idx).getKey()){ //
					int[] val = que.poll();
					que.offer(val);
				}
				int[] target = que.poll();
				if(target[1] == location){
					return count;
				}
				entries.get(idx).setValue(entries.get(idx).getValue()-1);
				if(entries.get(idx).getValue()==0) idx++;
				count++;
			}
			return count;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{1, 1, 9, 1, 1, 1},0));

	}

}
