package programmers;

import java.util.Arrays;

public class 카펫 {
	static class Solution {
		public int[] solution(int brown, int yellow) {
			int[] answer = {};
			for(int i=1;i<=yellow;i++){
				if(yellow%i == 0){
					int h = i;
					int w = yellow/i;
					if(check(h,w,brown)){
						return new int[]{w+2,h+2};
					}
				}
			}
			return answer;
		}
		boolean check(int h,int w,int ans){
			return ans == (w+2)*2 + (h*2);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(24, 24)));

	}
}
