package programmers;

public class 기지국_설치2 {
    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int idx = 0;
            int sIdx = 0;
            int[] range = new int[]{Math.max(0,stations[sIdx]-1-w),Math.min(n-1,stations[sIdx]-1+w)};
            while(idx < n){
                if(idx > range[1] && sIdx+1 < stations.length){
                    sIdx++;
                    range[0] = Math.max(0,stations[sIdx]-1-w);
                    range[1] = Math.min(n-1,stations[sIdx]-1+w);
                }
                if(idx>=range[0] && idx <= range[1]){
                    idx = range[1]+1;
                }else{
                    answer++;
                    idx += w*2+1;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(11,new int[]{4,11},1));
    }
}
