package programmers;

public class 큰_수_만들기 {
	static class Solution {
		public String solution(String number, int k) {
			int len = number.length();
			int count = len-k;
			StringBuilder sb = new StringBuilder();
			int idx = 0;
			while(count > 0){
				System.out.println(idx+" "+sb);
				int max = -1;
				int tmp = idx;
				for(int i=idx;i<=len-count;i++){
					if(max < number.charAt(i)-'0'){
						max =  number.charAt(i)-'0';
						tmp = i;
					}
				}
				sb.append(max);
				idx = tmp+1;
				count--;
			}
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("4177252841",4));
	}
}
