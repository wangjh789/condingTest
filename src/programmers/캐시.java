package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class 캐시 {
	static class Solution {
		public int solution(int cacheSize, String[] cities) {
			int answer = 0;
			if(cacheSize==0) return cities.length*5;
			Queue<String> que = new LinkedList<>();
			for(String city : cities){
				String target = city.toLowerCase();
				if(que.contains(target)){
					answer++;
					que.remove(target);
					que.offer(target);
				}else{
					answer+=5;
					que.offer(target);
					if(que.size() > cacheSize){
						que.poll();
					}
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(3,new String[]
				{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));

	}
}
