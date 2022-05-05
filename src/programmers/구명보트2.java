package programmers;

import java.util.Arrays;

public class 구명보트2 {
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            Arrays.sort(people);
            int left = 0;
            int right = people.length-1;
            while(left<=right){
                int w = people[right--]; //제일 무거운 사람
                while(w + people[left] <= limit){
                    w+= people[left++];
                }
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{50,70, 80, 50},100));
    }
}
