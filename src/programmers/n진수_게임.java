package programmers;

import java.util.Arrays;

public class n진수_게임 {
	static class Solution {
		public String solution(int n, int t, int m, int p) {
			StringBuilder answer = new StringBuilder();
			int num = 0;
			p--;
			int turn = 0;
			while(true){
				char[] numToArr = Integer.toString(num,n).toCharArray();
//				System.out.println(Arrays.toString(numToArr));
				int idx = 0;
				while(idx < numToArr.length){
					if(turn == p) {
						char tmp = Character.isAlphabetic(numToArr[idx])?
								Character.toUpperCase(numToArr[idx]):numToArr[idx];
						answer.append(tmp);
					}
					if(answer.length() ==t) break;
					turn++;
					turn%=m;
					idx++;
				}
				if(answer.length() >= t) break;
				num++;
			}
			return answer.toString();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(16,16,2,2));

	}
}
