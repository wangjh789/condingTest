package programmers;

public class 점프와_순간이동 {
	static class Solution {
		public int solution(int n) {
			int ans = 0;
			while(n !=0){
				if(n %2 != 0) ans ++;
				n/=2;
			}
			return ans;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(5));

	}

}
