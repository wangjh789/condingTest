package programmers;

import java.util.Stack;

public class 짝지어_제거하기 {
	static class Solution {
		public int solution(String s) {
			StringBuilder sb = new StringBuilder(s);
			Stack<Character> st = new Stack<>();
			for(char ch : s.toCharArray()){
				if(st.isEmpty()){
					st.push(ch);
				}else{
					if(st.peek() == ch){
						st.pop();
					}else st.push(ch);
				}
			}

			return st.size() == 0? 1:0;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("baabaa"));

	}
}
