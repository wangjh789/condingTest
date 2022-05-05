package programmers;

import java.util.*;

public class 캐시2 {
    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            List<String> arr = new ArrayList<>();
            for(String city : cities){
                char[] target = city.toCharArray();
                for(int i =0;i< target.length;i++) target[i] = Character.toLowerCase(target[i]);
                String t = String.valueOf(target);
                System.out.println(t);

                int pos = arr.indexOf(t);
                if(pos != -1){ // cache hit
                    answer++;
                    arr.remove(pos);
                    arr.add(t);
                }else{ // cache miss
                    answer+=5;
                    arr.add(t);
                    if(arr.size() > cacheSize){
                        arr.remove(0);
                    }
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3,new String[]{
                "A","B","A"
        }));
    }
}
