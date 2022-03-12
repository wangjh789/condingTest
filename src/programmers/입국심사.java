package programmers;

import java.time.LocalDate;
import java.util.Arrays;


public class 입국심사 {
	static class Solution {
		public long solution(int n, int[] times) {
			Arrays.sort(times);
			long left = 1;
			long right = (long) n*times[times.length-1]; //최악의 경우
			while(left<= right){
//				System.out.println(left+" "+right);
				long mid = (right+left)/2;
				long count = 0;
				for(int t : times) count+= mid/t;
				if(count < n){
					left = mid+1;
				}else{
					right = mid-1;
				}
			}
			return left;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(8,new int[]{5, 7, 12}));

	}
}
