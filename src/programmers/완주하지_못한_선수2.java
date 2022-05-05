package programmers;

import java.util.*;

public class 완주하지_못한_선수2 {
    static class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String,Integer> map = new HashMap<>();
            for(String part : participant){
                map.put(part,map.getOrDefault(part,0)+1);
            }
            for(String com:completion){
                int val = map.get(com);
                if(val == 1){
                    map.remove(com);
                }else map.put(com,val-1);
            }
            List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
            return list.get(0).getKey();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}
                ));
    }
}
