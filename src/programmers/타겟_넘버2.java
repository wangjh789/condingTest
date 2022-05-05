package programmers;

public class 타겟_넘버2 {
    static class Solution {
        int answer= 0;
        public int solution(int[] numbers, int target) {
            dfs(numbers,target,0,0);
            return answer;
        }

        private void dfs(int[] numbers,int target,int idx,int result){
            if(idx == numbers.length){
                if(result == target)
                    answer++;
                return;
            }
            dfs(numbers, target, idx+1, result+numbers[idx]);
            dfs(numbers, target, idx+1, result-numbers[idx]);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{4, 1, 2, 1},4));
    }
}
