package programmers;

import java.util.Arrays;

public class 가장_큰_수2 {
    static class Solution {
        public String solution(int[] numbers) {
            StringBuilder answer = new StringBuilder();
            String[] str = new String[numbers.length];
            for(int i=0;i< numbers.length;i++) str[i] = String.valueOf(numbers[i]);
            Arrays.sort(str,((o1, o2) -> (o2+o1).compareTo(o1+o2)));
            for(String s : str) answer.append(s);
            return answer.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{6, 10, 2}));
    }
}
