package programmers;

import java.util.Stack;

public class 짝지어_제거하기2 {
    static class Solution {
        public int solution(String s) {
            Stack<Character> stack = new Stack<>();
            for(char ch : s.toCharArray()){
                if(stack.isEmpty()) stack.push(ch);
                else{
                    if(stack.peek() == ch) stack.pop();
                    else stack.push(ch);
                }
            }
            return stack.isEmpty()?1:0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("baabaa"));
    }
}
