package programmers;

public class 가장_긴_팰린드롬2 {
    static class Solution {
        public int solution(String s) {
            if(s.length()==0) return 0;
            int answer = 0;
            for(int i =0;i<s.length();i++){
                answer = Math.max(answer,moveBasedCenter(s,i));
                if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                    answer = Math.max(answer,moveEvenly(s,i));
                }
            }

            return answer;
        }
        private int moveBasedCenter(String s,int idx){
            int ans = 1;
            int left = idx-1;
            int right = idx+1;
            while(left>=0 && right<s.length()){
                if(s.charAt(left) != s.charAt(right)) break;
                left--;
                right++;
                ans+=2;
            }
            return ans;
        }
        private int moveEvenly(String s,int idx){
            int ans = 2;
            int left = idx-1;
            int right = idx+2;
            while(left>=0 && right<s.length()){
                if(s.charAt(left) != s.charAt(right)) break;
                left--;
                right++;
                ans+=2;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("abcdcba"));
    }
}
