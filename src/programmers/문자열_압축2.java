package programmers;

public class 문자열_압축2 {
        static class Solution {
            public int solution(String s) {
                int answer = Integer.MAX_VALUE;
                for(int term = 1;term<= s.length()/2;term++){
                    int idx = 0;
                    int value = 0;
                    while(idx+term <= s.length()){
                        int count = 0;
                        String target = s.substring(idx,idx+term);
                        while(idx+term <= s.length() && target.equals(s.substring(idx,idx+term))){
                            count++;
                            idx += term;
                        }
                        if(count == 1){
                            value+= term;
                        }else value+= term+String.valueOf(count).length();
                    }
                    value += s.length()-idx;
                    answer = Math.min(value,answer);
                }
                return answer;
            }
        }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        aabbaccc
        System.out.println(solution.solution("aabbaccc"));
        System.out.println(solution.solution("ababcdcdababcdcd"));
        System.out.println(solution.solution("abcabcdede"));
        System.out.println(solution.solution("abcabcabcabcdededededede"));
        System.out.println(solution.solution("xababcdcdababcdcd"));

    }
}
