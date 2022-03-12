package programmers;

import java.util.*;

public class 순위 {
	static class Solution {
		public int solution(int n, int[][] results) {
			int answer = 0;
			Map<Integer, Set<Integer>> winLog = new HashMap<>(); //내가 이긴 선수
			Map<Integer,Set<Integer>> loseLog = new HashMap<>(); //내가 진 선수
			for(int i=0;i<n;i++){
				winLog.put(i,new HashSet<>());
				loseLog.put(i,new HashSet<>());
			}
//			for(int[] result : results){
//				int winner = result[0]-1;
//				int loser = result[1]-1;
//				winLog.get(winner).add(loser);
//				loseLog.get(loser).add(winner);
//			}
			for(int i=0;i<2;i++){
				for(int[] result : results){
					int winner = result[0]-1;
					int loser = result[1]-1;

					winLog.get(winner).add(loser); //자신의 승리 기록
					Queue<Integer> windQue = new LinkedList<>();
					windQue.offer(winner);
					while(!windQue.isEmpty()){ // 자신을 이긴 사람들에게도 승점 적립
						int target = windQue.poll();
						for(int neighbor : loseLog.get(target)){
							winLog.get(neighbor).addAll(winLog.get(target));
						}
					}

					loseLog.get(loser).add(winner); //자신의 패배 기록
					Queue<Integer> loseQue = new LinkedList<>();
					loseQue.add(loser);
					while(!loseQue.isEmpty()){ //자신이 이긴 사람들에게도 패배 기록
						int target = loseQue.poll();
						for(int neighbor : winLog.get(target)){
							loseLog.get(neighbor).addAll(loseLog.get(target));
						}
					}

				}
			}
			for(int i=0;i<n;i++){
				if(winLog.get(i).size() + loseLog.get(i).size() == n-1) answer++;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
//      {1, 2}, {4, 5}, {3, 4}, {2, 3}
//		{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
		System.out.println(sol.solution(5,new int[][]{{1, 2}, {4, 5}, {3, 4}, {2, 3}}));

	}
}
