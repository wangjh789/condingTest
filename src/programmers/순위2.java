package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 순위2 {
    static class Solution {
        public int solution(int n, int[][] results) {
            int answer = 0;
            Map<Integer, Set<Integer>> winMap = new HashMap<>();
            Map<Integer,Set<Integer>> loseMap = new HashMap<>();
            for(int i =0;i<n;i++){
                winMap.put(i,new HashSet<>());
                loseMap.put(i,new HashSet<>());
            }
            for(int[] result : results){
                int winner = result[0]-1;
                int loser = result[1]-1;
                winMap.get(winner).add(loser);
                loseMap.get(loser).add(winner);
            }
            for(int target=0;target<n;target++){
                Set<Integer> wins = winMap.get(target);// tareget이 이긴 사람
                Set<Integer> loses = loseMap.get(target); //target이 진 사람

                for(int win :wins){ //tareget이 이긴 사람들 하나하나 타켓이 진 사람들 모두를 더함
                    loseMap.get(win).addAll(loses);
                }
                for(int lose:loses){ //target이 진 사람들 하나하나 타겟이 이긴 사람 모두를 더함
                    winMap.get(lose).addAll(wins);
                }
            }
            for(int i =0;i<n;i++){
                if(winMap.get(i).size() + loseMap.get(i).size() == n-1){
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(5,new int[][]{
                {4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}
        }));
    }
}
