package programmers;

import java.util.*;

public class 주식가격 {
	static class Solution {
		public int[] solution(int[] prices) {
			int[] answer = new int[prices.length];
			for(int i=0;i<prices.length;i++){
				int count = 0;
				for(int j=i+1;j<prices.length;j++){
					count++;
					if(prices[i] > prices[j]) break;
				}
				answer[i] = count;
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 2, 3})));
	}
}
