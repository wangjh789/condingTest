package programmers;

public class N개의_최소공배수 {
	static class Solution {
		public int solution(int[] arr) {
			int answer =arr[0];
			for(int i =1;i<arr.length;i++){
				answer = answer*arr[i]/ gcd(answer,arr[i]);
			}
			return answer;
		}
		int gcd(int a, int b){ // 최대공약수
			while(b!=0){
				int r = a%b;
				a= b;
				b= r;
			}
			return a;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution(new int[]{2,6,8,14}));

	}

}
