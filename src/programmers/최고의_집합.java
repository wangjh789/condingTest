package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 최고의_집합 {
	static class Solution {
		public int[] solution(int n, int s) {
			int[] answer = new int[n];
			int idx = 0;
			while(s > 0){
				int val = s/n;
				if(val == 0) return new int[]{-1};
				answer[idx++] = val;
				s -=val;
				n--;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(2, 1)));

	}
}
