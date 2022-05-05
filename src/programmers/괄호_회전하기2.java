package programmers;

import java.util.Stack;

public class 괄호_회전하기2 {
    static class Solution {
        public int solution(String s) {
            int answer = 0;
            int len = s.length();
            StringBuilder sb= new StringBuilder(s);
            while(len >0 ){
                if(isValid(sb.toString())) answer++;
                char t = sb.charAt(0);
                sb.deleteCharAt(0);
                sb.append(t);

                len--;
            }
            return answer;
        }
        private boolean isValid(String s){
            Stack<Character> st = new Stack<>();
            for(int i =0;i<s.length();i++){
                char target = s.charAt(i);
                if(st.isEmpty()) st.push(target);
                else{
                    char peek = st.peek();
                    if((target == '}' && peek == '{') ||
                            (target == ']' && peek == '[')||
                            (target == ')' && peek == '(')){
                        st.pop();
                    }else{
                        st.push(target);
                    }
                }
            }
            return st.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("[](){}"));
    }
}
