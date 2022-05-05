package programmers;

import java.util.Arrays;

public class H_Index2 {
    static class Solution {
        public int solution(int[] citations) {
            int answer = citations.length;
            Arrays.sort(citations);
            while(answer>0){
                int count = 0;
                for(int i =citations.length-1;i>=0;i--){
                    if(citations[i] >= answer)
                        count++;

                    if(answer == count) return answer;
                }
                answer--;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{0,0,0,0,0}));
    }
}
