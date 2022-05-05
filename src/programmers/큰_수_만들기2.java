package programmers;

public class 큰_수_만들기2 {
    static class Solution {
        public String solution(String number, int k) {
            StringBuilder answer = new StringBuilder();
            int count = number.length()-k;
            int idx =0;
            while(count >0){
                int max = -1;
                int nextIdx = idx;
                for(int i=idx;i<=number.length()-count;i++){
                    if(number.charAt(i)-'0' > max){
                        max = number.charAt(i)-'0';
                        nextIdx = i+1;
                    }
                }
                answer.append(max);
                idx = nextIdx;
                count--;
            }

            return answer.toString();
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("4177252841",4));
    }
}
