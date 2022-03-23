package programmers;

import java.util.*;

public class 스타_수열 {
	static class Solution {
		public int solution(int[] a) {
			int answer = 0;
			int[] count = new int[a.length];//a 원소의 등장횟수
			for (int i = 0; i < a.length; i++) count[a[i]]++;

			for(int i =0;i<count.length;i++){
				if(count[i] ==0) continue;
				if(answer >= count[i]) continue;
				int tmp = 0; //해당 원소 i가 사용된 횟수
				for(int j=0;j<count.length-1;j++){
					if(a[j] != i && a[j+1] !=i) continue;
					if(a[j] == a[j+1]) continue;
					tmp++;
					j++;
				}
				answer = Math.max(tmp,answer);
			}
			return answer*2;
		}

	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]
				{5,2,3,3,5,3}));
	}
}
