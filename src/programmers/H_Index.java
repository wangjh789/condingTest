package programmers;

import java.util.Arrays;

public class H_Index {
	static  class Solution {
		public int solution(int[] citations) {
			int answer = 0;
			Arrays.sort(citations);
			for(int i=0;i<citations.length;i++){
				int h = citations.length - i;
				if(citations[i]>=h){
					answer = h;
					break;
				}
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{3, 0, 6, 1, 5}));

	}
}
