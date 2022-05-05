package programmers;

import java.util.*;

public class 보석_쇼핑2 {
    static class Solution {
        public int[] solution(String[] gems) {
            int[] answer = new int[2];
            Set<String> types = new HashSet<>(Arrays.stream(gems).toList());
            int dist = Integer.MAX_VALUE;
            Map<String,Integer> bag = new HashMap<>();
            int left = 0;
            int right = 0;
            while(true){
                if(right != gems.length && bag.size() != types.size()){ //종류별로 다 모으지 못했을때
                    bag.put(gems[right],bag.getOrDefault(gems[right],0)+1);
                    right++;
                }else if(right == gems.length) break;
                else{ //다 모았을 때
                    bag.put(gems[left], bag.get(gems[left])-1);

                    if(bag.get(gems[left]) == 0){
                        bag.remove(gems[left]);
                    }
                    left++;
                }
                if(bag.size() == types.size()){
                    if(right - left < dist){
                        answer[0] = left+1;
                        answer[1] = right;
                        dist = right-left;
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(new String[]{
                "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"
        })));
    }
}
