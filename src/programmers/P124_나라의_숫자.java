package programmers;

import java.util.Objects;

public class P124_나라의_숫자 {
	static class Solution {
		public String solution(int n) {
			StringBuilder sb = new StringBuilder();

			int rest = 0;
			while(n != 0){

				rest = n%3;
				n /= 3;
				if(rest == 0){
					n --;
					rest = 4;
				}
				sb.insert(0,rest);
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(10));
	}
}
