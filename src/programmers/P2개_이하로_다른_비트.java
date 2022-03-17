package programmers;

import java.util.Arrays;

public class P2개_이하로_다른_비트 {
	static class Solution {
		public long[] solution(long[] numbers) {
			long[] answer = new long[numbers.length];
			for(int i =0;i<numbers.length;i++){
				if(numbers[i]%2==0) {
					answer[i] = numbers[i]+1;
					continue;
				}
				StringBuilder sb = new StringBuilder(Long.toBinaryString(numbers[i]));
				if(sb.lastIndexOf("0") == -1){ //0이 없으면
					sb.setCharAt(0,'0');
					sb.insert(0,'1');
				}else{ //0이 있으면 1로 바꾸고 0뒤에서 가장 가까운 1을 0으로 바꿈
					int zero_idx = sb.lastIndexOf("0");
					int one_idx = sb.indexOf("1",zero_idx);
					sb.setCharAt(zero_idx,'1');
					sb.setCharAt(one_idx,'0');
				}
				answer[i] = Long.parseLong(sb.toString(),2);
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(Arrays.toString(sol.solution(new long[]{2, 7})));

	}
}
