package programmers;

public class k진수에서_소수_개수_구하기2 {
    static class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            String[] words = Integer.toString(n,k).split("0");
            for(String word : words){
                if(word.length() == 0) continue;
                if(isPrime(Long.parseLong(word))) {
                    answer++;
                }
            }
            return answer;
        }

        private boolean isPrime(long num){
            if (num <= 1) return false;
            if( num == 2) return true;
            for(int i =2;i<=Math.sqrt((double) num);i++){
                if(num%i==0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(1000000,3));
    }
}
