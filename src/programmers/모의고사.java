package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
	static class Solution {
		public int[] solution(int[] answers) {
			int[] stuA = new int[]{1, 2, 3, 4, 5};
			int[] stuB = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
			int[] stuC = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
			int[] score = new int[3];
			for(int i=0;i<answers.length;i++){
				if(stuA[i%stuA.length] == answers[i]) score[0]++;
				if(stuB[i%stuB.length] == answers[i]) score[1]++;
				if(stuC[i%stuC.length] == answers[i]) score[2]++;
			}
			int max = 0;
			for (int j : score) max = Math.max(max, j);
			List<Integer> ans = new ArrayList<>();
			for(int i=0;i<score.length;i++){
				if(score[i] == max){
					ans.add(i+1);
				}
			}
			return ans.stream().mapToInt(i->i).toArray();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(new int[]{1,3,2,4,2})));

	}
}
