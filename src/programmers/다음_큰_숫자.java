package programmers;

import java.util.Arrays;

public class 다음_큰_숫자 {
	static class Solution {
		public int solution(int n) {
			int count = Integer.bitCount(n);
			n++;
			while(true){
				if(Integer.bitCount(n)==count){
					break;
				}
				n++;
			}
			return n;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(78));
	}
}
