package programmers;

public class 타켓_넘버 {
	static class Solution {
		int answer;
		public int solution(int[] numbers, int target) {
			answer = 0;
			dfs(numbers,target,0,0);
			return answer;
		}

		void dfs(int[] numbers,int target, int cur,int idx){
			if(idx == numbers.length){
				if(cur == target) answer++;
				return ;
			}
			dfs(numbers,target,cur+numbers[idx],idx+1);
			dfs(numbers,target,cur-numbers[idx],idx+1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1},3));

	}
}
