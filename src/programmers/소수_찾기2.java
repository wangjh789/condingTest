package programmers;

import java.util.HashSet;
import java.util.Set;

public class 소수_찾기2 {
    static class Solution {
        Set<Integer> set;
        public int solution(String numbers) {
            int answer = 0;
            set = new HashSet<>();
            dfs(numbers.toCharArray(),new StringBuilder(),new boolean[numbers.length()]);
            for(int s : set){
                if(isPrime(s)) answer++;
            }
            return answer;
        }
        private void dfs(char[] nums,StringBuilder sb,boolean[] visited){
            if(sb.length() != 0) {
                set.add(Integer.valueOf(sb.toString()));
            }
            for(int i=0;i<nums.length;i++){
                if(!visited[i]){
                    visited[i] = true;
                    sb.append(nums[i]);
                    dfs(nums,sb,visited);
                    visited[i] = false;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }

        private boolean isPrime(int num){
            if(num == 2) return true;
            if(num <2) return false;
            for(int i=2;i<=Math.sqrt((double) num);i++){
                if(num%i==0) return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("17"));
    }
}
