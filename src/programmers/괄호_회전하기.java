package programmers;

import java.util.Stack;

public class 괄호_회전하기 {
	static class Solution {
		public int solution(String s) {
			if(s.length() % 2 != 0) return 0;
			int answer = 0;
			StringBuilder sb = new StringBuilder(s);
			for(int i =0;i<s.length();i++){
//				System.out.println(sb+" "+answer);
				if(isValid(sb)) answer++;
				char ch = sb.charAt(0);
				sb.deleteCharAt(0).append(ch);
			}
			return answer;
		}
		boolean isValid(StringBuilder s){
			Stack<Character> st = new Stack<>();
			for(int i=0;i<s.length();i++){
				if(st.isEmpty()) st.push(s.charAt(i));
				else{
					if(s.charAt(i) == ')' && st.peek()=='(') st.pop();
					else if(s.charAt(i) == '}' && st.peek()=='{') st.pop();
					else if(s.charAt(i) == ']' && st.peek()=='[') st.pop();
					else st.push(s.charAt(i));
				}
			}
			return st.isEmpty();
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("}]()[{"));

	}
}
