package programmers;

public class n진수_게임2 {
    static class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder sb = new StringBuilder();
            int round = 0;
            int num = 0;
            while(sb.length() < t){
                String ans = Integer.toString(num, n);
                int idx = 0;
                while(idx < ans.length()){
                    if(round%m ==p-1){
                        char ch = ans.charAt(idx);
                        sb.append(Character.isAlphabetic(ch)?Character.toUpperCase(ch):ch);
                    }
                    if(sb.length() == t) break;
                    idx++;
                    round++;
                }
                num++;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(2,4,2,1));
    }
}
