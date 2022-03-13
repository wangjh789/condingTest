package programmers;

public class 문자열_압축 {
	static class Solution {
		public int solution(String s) {
			int answer = s.length();
			int maxTerm  = s.length()/2;
			for(int term = 1;term<=maxTerm;term++){
				int idx = 0;
				int len = 0;
				while(idx + term <= s.length()){
					String target = s.substring(idx,idx+term);
					int count = 0;
					while(idx + term <= s.length() && s.substring(idx,idx+term).equals(target)){
						count++;
						idx += term;
					}
					len+=term;
					if(count != 1) len+=String.valueOf(count).length();
				}
				answer  = Math.min(answer,len+(s.length()-idx));
			}
			return answer;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("xababcdcdababcdcd"));

	}
}
