package programmers;

import java.util.Stack;

public class 올바른_괄호 {
	static class Solution {
		boolean solution(String s) {
			int t = 0;
			for(int i =0;i<s.length();i++){
				if(s.charAt(i)=='(') t++;
				else t--;

				if(t <0) return false;
			}

			return t==0;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.solution("(())()"));

	}
}
