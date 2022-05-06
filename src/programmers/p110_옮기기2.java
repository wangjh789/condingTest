package programmers;

import java.util.Arrays;
import java.util.Stack;

public class p110_옮기기2 {
    static class Solution {
        public String[] solution(String[] s) {
            String[] answer = new String[s.length];
            for(int i =0;i<s.length;i++){
                char[] target = s[i].toCharArray();
                Stack<Character> st = new Stack<>();
                int count = 0;
                for(char ch : target){
                    if(st.size()>=2){
                        char a = st.pop();
                        char b = st.pop();
                        if(b == '1' && a=='1' && ch =='0'){
                            count++;
                        }else{
                            st.push(b);
                            st.push(a);
                            st.push(ch);
                        }
                    }else st.push(ch);
                }
                System.out.println(st);
                StringBuilder sb= new StringBuilder();
                while(!st.isEmpty() && st.peek()=='1')
                    sb.insert(0,st.pop());
                while(count>0){
                    sb.insert(0,"110");
                    count--;
                }
                while(!st.isEmpty())
                    sb.insert(0,st.pop());

                answer[i] = sb.toString();
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        "1101","100110110","0110110111"
        System.out.println(Arrays.toString(sol.solution(new String[]{
                "1110", "100111100", "0111111010"
        })));
    }
}
