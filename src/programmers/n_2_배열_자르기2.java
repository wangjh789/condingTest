package programmers;

import java.util.Arrays;

public class n_2_배열_자르기2 {
    static class Solution {
        public int[] solution(int n, long left, long right) {
            int ansIdx = 0;
            int[] answer = new int[(int) (right-left+1)];
            int line = (int) (left/n);
            int idx = (int) (left%n);
            int rightLine = (int) (right/n);
            int rightIdx = (int) (right%n);
            while(line <= rightLine){
                if(line != rightLine) {
                    while (idx < n) {
                        if (idx < line) answer[ansIdx++] = line + 1;
                        else answer[ansIdx++] = idx + 1;
                        idx++;
                    }
                }else{
                    while(idx <= rightIdx){
                        if(idx < line) answer[ansIdx++] = line+1;
                        else answer[ansIdx++] = idx+1;
                        idx++;
                    }
                }
                idx = 0;
                line++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol =new Solution();
        System.out.println(Arrays.toString(sol.solution(4,7,14)));
    }
}
