package programmers;

public class JadenCase_문자열_만들기 {
	static class Solution {
		public String solution(String s) {
			StringBuilder answer = new StringBuilder();
			int idx = 0;
			while(idx < s.length()){

				if(idx >0 && s.charAt(idx-1)==' ' && Character.isAlphabetic(s.charAt(idx))){
					answer.append(Character.toUpperCase(s.charAt(idx)));
				}else{
					if(Character.isAlphabetic(s.charAt(idx))){
						if(idx == 0) answer.append(Character.toUpperCase(s.charAt(idx)));
						else answer.append(Character.toLowerCase(s.charAt(idx)));
					}else answer.append(s.charAt(idx));
				}
				idx++;
			}
			return answer.toString();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("3people unFollowed me"));

	}
}
