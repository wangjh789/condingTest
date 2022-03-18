package programmers;

public class 모음사전 {
	static class Solution {
		public int solution(String word) {
			int answer = 0;
			String str = "AEIOU";
			int[] x = {781,156,31,6,1};
			int idx,result = word.length();
			for(int i =0;i<word.length();i++){
				idx = str.indexOf(word.charAt(i));
				System.out.println(result+" "+idx);
				result += x[i] *idx;
			}
			return result;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("A"));

	}
}
