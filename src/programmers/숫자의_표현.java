package programmers;

public class 숫자의_표현 {
	static class Solution {
		public int solution(int n) {
			int answer = 1;
			int limit = n%2==0?n/2 : n/2+1;
			int left = 1;
			int right = 1;
			int val = 1;
			while(left<limit){
				if(val == n) answer++;

				if(val >= n){
					val -= left;
					left++;
				}else{
					right++;
					val += right;
				}
			}

			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(1));

	}
}
