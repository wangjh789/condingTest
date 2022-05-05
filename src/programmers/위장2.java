package programmers;

import java.util.HashMap;
import java.util.Map;

public class 위장2 {
    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            Map<String,Integer> type = new HashMap<>();
            for(String[] clo : clothes)
                type.put(clo[1],type.getOrDefault(clo[1],0)+1);
            System.out.println(type);
            for(Map.Entry<String,Integer> entry : type.entrySet()){
                answer*=entry.getValue()+1;
            }

            return answer-1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[][]{
                {"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}
        }));
    }
}
