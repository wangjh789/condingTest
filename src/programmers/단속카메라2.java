package programmers;

import java.util.Arrays;

public class 단속카메라2 {
    static class Solution {
        public int solution(int[][] routes) {
            int answer = 0;
            Arrays.sort(routes,(o1, o2) -> o1[1]-o2[1]);
            int camera = -30001;
            for(int[] route:routes){
                int start = route[0];
                int end = route[1];
                if(camera >= start && camera <= end) continue;
                camera = end;
                answer++;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[][]{
                {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}
        }));
    }
}
